/**
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
 *
 * Licensed under the GNU GENERAL PUBLIC LICENSE, Version 3, 29 June 2007 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.gnu.org/licenses/
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * -----------------------------------------------------------------
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc.
 *
 */
package tain.kr.com.test.mon.v01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.FileSystem;
import org.hyperic.sigar.FileSystemUsage;
import org.hyperic.sigar.Mem;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;
import org.hyperic.sigar.Swap;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrCpuInfo.java
 *   -. Package    : tain.kr.com.test.mon.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 30. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrCpuInfo implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrCpuInfo.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Sigar sigar;
	
	private CpuInfo[] arrCpuInfo;  // cpu information. e.g. vender, mode, and so on
	private CpuPerc[] arrCpuPerc;  // cpu information per cores
	private CpuPerc cpuPerc;       // cpu information of cores summary
	
	private Mem mem;               // memory information
	private Swap swap;             // swap information
	
	private FileSystem[] arrFileSystem; // file system
	
	private Connection conn;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrCpuInfo() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		
		try {
			this.sigar = new Sigar();
			
			this.arrCpuInfo = this.sigar.getCpuInfoList();
			this.arrCpuPerc = this.sigar.getCpuPercList();
			this.cpuPerc = this.sigar.getCpuPerc();
			
			this.mem = this.sigar.getMem();
			this.swap = this.sigar.getSwap();
			
			this.arrFileSystem = this.sigar.getFileSystemList();
	
			setterToDerby();
			
		} catch (SigarException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (this.conn != null) try { this.conn.close(); } catch (Exception e) {}
			if (this.sigar != null) try { this.sigar.close(); } catch (Exception e) {}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void setterToDerby() throws Exception {
		
		setConnection();
		
		this.conn.setAutoCommit(false);
		
		String dttm = getTimestamp();
		
		if (flag) {
			/*
			 * old records in KANG.TB_CPUINFO be set to be unusable
			 */
			PreparedStatement psUpdate = this.conn.prepareStatement(
					"update KANG.TB_CPUINFO set F_YN = 'N' where F_YN = 'Y'");
			
			psUpdate.executeUpdate();
			
			if (flag) log.debug("update KANG.TB_CPUINFO..");
			
			psUpdate.close();
		}
		
		if (flag) {
			/*
			 * insert a information to KANG.TB_CPUINFO
			 */
			PreparedStatement psInsert = this.conn.prepareStatement(
					"insert into KANG.TB_CPUINFO "
					+ "( F_VNDR, F_MDL, F_MHZ, F_TTL, F_PHS, F_CPC )"
					+ " values "
					+ "( ?, ?, ?, ?, ?, ? )");
			
			psInsert.setString(1, this.arrCpuInfo[0].getVendor());
			psInsert.setString(2, this.arrCpuInfo[0].getModel());
			psInsert.setInt(3, this.arrCpuInfo[0].getMhz());
			psInsert.setInt(4, this.arrCpuInfo[0].getTotalCores());
			psInsert.setInt(5, this.arrCpuInfo[0].getTotalSockets());
			psInsert.setInt(6, this.arrCpuInfo[0].getCoresPerSocket());
			
			psInsert.executeUpdate();
			
			if (flag) log.debug("insert KANG.TB_CPUINFO..");
			
			psInsert.close();
		}
		
		if (flag) {
			/*
			 * insert informations to KANG.TB_CPUREC
			 */
			PreparedStatement psInsert = this.conn.prepareStatement(
					"insert into KANG.TB_CPUREC "
					+ "( F_DTTM, F_CPUNM, F_USR, F_SYS, F_IDL, F_WAIT, F_NCE, F_CMB, F_IRQ )"
					+ " values "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ? )");

			for (int i=0; i < arrCpuPerc.length; i++) {
				psInsert.setTimestamp(1, Timestamp.valueOf(dttm));
				psInsert.setString(2, "CPU" + i);
				psInsert.setDouble(3, this.arrCpuPerc[i].getUser());
				psInsert.setDouble(4, this.arrCpuPerc[i].getSoftIrq());
				psInsert.setDouble(5, this.arrCpuPerc[i].getIdle());
				psInsert.setDouble(6, this.arrCpuPerc[i].getWait());
				psInsert.setDouble(7, this.arrCpuPerc[i].getNice());
				psInsert.setDouble(8, this.arrCpuPerc[i].getCombined());
				psInsert.setDouble(9, this.arrCpuPerc[i].getIrq());
				
				psInsert.executeUpdate();
			}
			
			psInsert.setString(1, dttm);
			psInsert.setString(2, "TOTAL");
			psInsert.setDouble(3, this.cpuPerc.getUser());
			psInsert.setDouble(4, this.cpuPerc.getSoftIrq());
			psInsert.setDouble(5, this.cpuPerc.getIdle());
			psInsert.setDouble(6, this.cpuPerc.getWait());
			psInsert.setDouble(7, this.cpuPerc.getNice());
			psInsert.setDouble(8, this.cpuPerc.getCombined());
			psInsert.setDouble(9, this.cpuPerc.getIrq());
			
			psInsert.executeUpdate();

			if (flag) log.debug("insert KANG.TB_CPUREC...");
			
			psInsert.close();
		}
		
		if (flag) {
			/*
			 * insert information to KANG.TB_MEMREC
			 */
			PreparedStatement psInsert = this.conn.prepareStatement(
					"insert into KANG.TB_MEMREC "
					+ "( F_DTTM, F_RAM, F_TTL, F_FRE, F_USE, F_FREP, F_USEP, F_AFRE, F_AUSE, F_SWTTL, F_SWFRE, F_SWUSE, F_SWPGI, F_SWPGO )"
					+ " values "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )" );
			
			psInsert.setString(1, dttm);
			psInsert.setLong(2, this.mem.getRam());
			psInsert.setLong(3, this.mem.getTotal());
			psInsert.setLong(4, this.mem.getFree());
			psInsert.setLong(5, this.mem.getUsed());
			psInsert.setDouble(6, this.mem.getFreePercent());
			psInsert.setDouble(7, this.mem.getUsedPercent());
			psInsert.setLong(8, this.mem.getActualFree());
			psInsert.setLong(9, this.mem.getActualUsed());
			psInsert.setLong(10, this.swap.getTotal());
			psInsert.setLong(11, this.swap.getFree());
			psInsert.setLong(12, this.swap.getUsed());
			psInsert.setLong(13, this.swap.getPageIn());
			psInsert.setLong(14, this.swap.getPageOut());
			
			psInsert.executeUpdate();

			if (flag) log.debug("insert KANG.TB_MEMREC...");
			
			psInsert.close();
		}
		
		if (flag) {
			/*
			 * insert information to KANG.TB_DSKREC
			 */
			PreparedStatement psInsert = this.conn.prepareStatement(
					"insert into KANG.TB_DSKREC "
					+ "( F_DTTM, F_DEVNM, F_DIRNM, F_SYSNM, F_TYPNM, F_TOT, F_USE, F_AVL, F_USEP )"
					+ " values "
					+ "( ?, ?, ?, ?, ?, ?, ?, ?, ? )");

			for (int i=0; i < arrCpuPerc.length; i++) {
				if ("cdrom".equals(this.arrFileSystem[i].getSysTypeName())
						|| "dvd".equals(this.arrFileSystem[i].getSysTypeName()))
					continue;
				
				FileSystemUsage usage = this.sigar.getFileSystemUsage(this.arrFileSystem[i].getDirName());
				
				psInsert.setTimestamp(1, Timestamp.valueOf(dttm));
				psInsert.setString(2, this.arrFileSystem[i].getDevName());
				psInsert.setString(3, this.arrFileSystem[i].getDirName());
				psInsert.setString(4, this.arrFileSystem[i].getSysTypeName());
				psInsert.setString(5, this.arrFileSystem[i].getTypeName());
				psInsert.setLong(6, usage.getTotal());
				psInsert.setLong(7, usage.getTotal() - usage.getFree());
				psInsert.setLong(8, usage.getAvail());
				psInsert.setDouble(9, usage.getUsePercent());
				
				psInsert.executeUpdate();
			}

			if (flag) log.debug("insert KANG.TB_DSKREC...");
			
			psInsert.close();
		}
		
		this.conn.commit();
		this.conn.close();
		
		if (flag) log.debug("success completed...");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void setConnection() throws SQLException {
		
		@SuppressWarnings("unused")
		String framework = "derbyClient";
		String driver = "org.apache.derby.jdbc.ClientDriver";
		String protocol = "jdbc:derby://localhost:1527/";
		String database = "taindb01";
		
		String user = "kang";
		String pass = "kang123!";
		
		try {
			Class.forName(driver).newInstance();
			
			Properties prop = new Properties();  // connection properties
			prop.put("user", user);
			prop.put("password", pass);
			
			this.conn = DriverManager.getConnection(protocol + database + ";create=true", prop);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static String getTimestamp(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	public static String getTimestamp() {
		return getTimestamp("yyyy-MM-dd HH:mm:00.000");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {
			/*
			 * begin
			 */
			String oldTimestamp = "";
			
			for (int i=0; ; i = ++i % 1000) {
				String curTimestamp = getTimestamp();
				
				if (!oldTimestamp.equals(curTimestamp)) {
					
					Thread thread = new Thread(new ThrCpuInfo());
					thread.start();
					thread.join();

					oldTimestamp = curTimestamp;
				}
				
				try { Thread.sleep(10 * 1000); } catch (InterruptedException e) {}
			}
		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
