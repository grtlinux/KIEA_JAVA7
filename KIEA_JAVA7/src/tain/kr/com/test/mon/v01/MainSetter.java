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
 *   -. FileName   : MainSetter.java
 *   -. Package    : tain.kr.com.test.mon.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 30. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainSetter implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainSetter.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Sigar sigar;
	
	private CpuInfo[] arrCpuInfo;   // cpu information. e.g. vender, mode, and so on.
	private CpuPerc[] arrCpuPerc;   // cpu information per cores
	private CpuPerc cpuPerc;        // cpu information of cores summary
	
	private Mem mem;                // memory information
	private Swap swap;              // swap information
	
	private FileSystem[] arrFileSystem;   // file system
	
	private Connection conn;
	
	private String dttm;
	private PreparedStatement ps;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainSetter() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		try {
			
			if (flag) getSystemInformation();
			if (flag) setConnection();

			if (flag) {
				/*
				 * set the flag of autocommit to false
				 */
				this.conn.setAutoCommit(false);
				if (flag) log.debug("setAutoComit(false)...");
			}
			
			if (flag) insertTbCpuRec();
			if (flag) insertTbMemRec();
			if (flag) insertTbDskRec();

			if (flag) updateTbCpuInfo();
			if (flag) insertTbCpuInfo();

			if (flag) {
				/*
				 * commit of the transactions
				 */
				this.conn.commit();
				if (flag) log.debug("commit()...");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			if (this.conn != null) {
				/*
				 * rollback of the transactions if any exception be occured
				 */
				try { this.conn.rollback(); } catch (SQLException e2) {}
				if (flag) log.debug("rollback()...");
			}
		} finally {
			if (flag) closeResource();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void getSystemInformation() throws Exception {
		
		this.sigar = new Sigar();
		
		this.arrCpuInfo = this.sigar.getCpuInfoList();
		this.arrCpuPerc = this.sigar.getCpuPercList();
		this.cpuPerc = this.sigar.getCpuPerc();
		
		this.mem = this.sigar.getMem();
		this.swap = this.sigar.getSwap();
		
		this.arrFileSystem = this.sigar.getFileSystemList();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void setConnection() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		String driver = "org.apache.derby.jdbc.ClientDriver";
		String protocol = "jdbc:derby://localhost:1527/";
		String database = "taindb01";
		String create = "true";
		String user = "kang";
		String password = "kang123!";
		
		try {
			Class.forName(driver).newInstance();
			
			Properties prop = new Properties();  // connection properties
			prop.put("create", create);
			prop.put("user", user);
			prop.put("password", password);
			
			this.conn = DriverManager.getConnection(protocol + database, prop);
			
			this.dttm = getTimestamp();

		} catch (ClassNotFoundException e) {
			throw e;
		} catch (InstantiationException e) {
			throw e;
		} catch (IllegalAccessException e) {
			throw e;
		} catch (SQLException e) {
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void closeResource() {
		
		if (this.ps != null) try { this.ps.close(); } catch (Exception e) {}
		if (this.conn != null) try { this.conn.close(); } catch (Exception e) {}
		if (this.sigar != null) try { this.sigar.close(); } catch (Exception e) {}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private void updateTbCpuInfo() throws SQLException {
		
		if (flag) {
			/*
			 * old records in TB_CPUINFO be set to be unusable
			 */
			try {
				this.ps = this.conn.prepareStatement(""
						+ "update KANG.TB_CPUINFO set F_YN = 'N' where F_YN = 'Y'"
						);
				
				this.ps.executeUpdate();
				
			} catch (Exception e) {
				throw e;
			}
			
			if (flag) log.debug("update KANG.TB_CPUINFO...");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void insertTbCpuInfo() throws SQLException {
		
		if (flag) {
			/*
			 * insert a current information to table KANG.TB_CPUINFO
			 */
			try {
				this.ps = this.conn.prepareStatement(""
						+ "insert into KANG.TB_CPUINFO "
						+ "( F_VNDR, F_MDL, F_MHZ, F_TTL, F_PHS, F_CPC )"
						+ " values "
						+ "( ?, ?, ?, ?, ?, ? )"
						);
				
				this.ps.setString(1, this.arrCpuInfo[0].getVendor());
				this.ps.setString(2, this.arrCpuInfo[0].getModel());
				this.ps.setInt(3, this.arrCpuInfo[0].getMhz());
				this.ps.setInt(4, this.arrCpuInfo[0].getTotalCores());
				this.ps.setInt(5, this.arrCpuInfo[0].getTotalSockets());
				this.ps.setInt(6, this.arrCpuInfo[0].getCoresPerSocket());

				this.ps.executeUpdate();
				
			} catch (Exception e) {
				throw e;
			}
			
			if (flag) log.debug("insert KANG.TB_CPUINFO...");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void insertTbCpuRec() throws SQLException {
		
		if (flag) {
			/*
			 * insert a current information to table KANG.TB_CPUREC
			 */
			try {
				this.ps = this.conn.prepareStatement(""
						+ "insert into KANG.TB_CPUREC "
						+ "( F_DTTM, F_CPUNM, F_USR, F_SYS, F_IDL, F_WAIT, F_NCE, F_CMB, F_IRQ )"
						+ " values "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ? )"
						);

				for (int i=0; i < this.arrCpuPerc.length; i++) {
					this.ps.setTimestamp(1, Timestamp.valueOf(this.dttm));
					this.ps.setString(2, "CPU" + i);
					this.ps.setDouble(3, this.arrCpuPerc[i].getUser());
					this.ps.setDouble(4, this.arrCpuPerc[i].getSoftIrq());
					this.ps.setDouble(5, this.arrCpuPerc[i].getIdle());
					this.ps.setDouble(6, this.arrCpuPerc[i].getWait());
					this.ps.setDouble(7, this.arrCpuPerc[i].getNice());
					this.ps.setDouble(8, this.arrCpuPerc[i].getCombined());
					this.ps.setDouble(9, this.arrCpuPerc[i].getIrq());
					
					this.ps.executeUpdate();
				}
				
				this.ps.setTimestamp(1, Timestamp.valueOf(this.dttm));
				this.ps.setString(2, "TOTAL");
				this.ps.setDouble(3, this.cpuPerc.getUser());
				this.ps.setDouble(4, this.cpuPerc.getSoftIrq());
				this.ps.setDouble(5, this.cpuPerc.getIdle());
				this.ps.setDouble(6, this.cpuPerc.getWait());
				this.ps.setDouble(7, this.cpuPerc.getNice());
				this.ps.setDouble(8, this.cpuPerc.getCombined());
				this.ps.setDouble(9, this.cpuPerc.getIrq());
				
				this.ps.executeUpdate();
				
			} catch (Exception e) {
				throw e;
			}
			
			if (flag) log.debug("insert KANG.TB_CPUREC...");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void insertTbMemRec() throws SQLException {
		
		if (flag) {
			/*
			 * insert a current information to table KANG.TB_MEMREC
			 */
			try {
				this.ps = this.conn.prepareStatement(""
						+ "insert into KANG.TB_MEMREC "
						+ "( F_DTTM, F_RAM, F_TTL, F_FRE, F_USE, F_FREP, F_USEP, F_AFRE, F_AUSE, F_SWTTL, F_SWFRE, F_SWUSE, F_SWPGI, F_SWPGO )"
						+ " values "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ? )"
						);
				
				this.ps.setTimestamp(1, Timestamp.valueOf(this.dttm));
				this.ps.setLong(2, this.mem.getRam());
				this.ps.setLong(3, this.mem.getTotal());
				this.ps.setLong(4, this.mem.getFree());
				this.ps.setLong(5, this.mem.getUsed());
				this.ps.setDouble(6, this.mem.getFreePercent());
				this.ps.setDouble(7, this.mem.getUsedPercent());
				this.ps.setLong(8, this.mem.getActualFree());
				this.ps.setLong(9, this.mem.getActualUsed());
				this.ps.setLong(10, this.swap.getTotal());
				this.ps.setLong(11, this.swap.getFree());
				this.ps.setLong(12, this.swap.getUsed());
				this.ps.setLong(13, this.swap.getPageIn());
				this.ps.setLong(14, this.swap.getPageOut());
				
				this.ps.executeUpdate();
				
			} catch (Exception e) {
				throw e;
			}
			
			if (flag) log.debug("insert KANG.TB_MEMREC...");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private void insertTbDskRec() throws SQLException, SigarException {
		
		if (flag) {
			/*
			 * insert a current information to table KANG.TB_DSKREC
			 */
			try {
				this.ps = this.conn.prepareStatement(""
						+ "insert into KANG.TB_DSKREC "
						+ "( F_DTTM, F_DEVNM, F_DIRNM, F_SYSNM, F_TYPNM, F_TOT, F_USE, F_AVL, F_USEP )"
						+ " values "
						+ "( ?, ?, ?, ?, ?, ?, ?, ?, ? )"
						);

				for (int i=0; i < this.arrCpuPerc.length; i++) {
					if ("cdrom".equals(this.arrFileSystem[i].getSysTypeName())
							|| "dvd".equals(this.arrFileSystem[i].getSysTypeName()))
						continue;
					
					FileSystemUsage usage = this.sigar.getFileSystemUsage(this.arrFileSystem[i].getDirName());
					
					this.ps.setTimestamp(1, Timestamp.valueOf(this.dttm));
					this.ps.setString(2, this.arrFileSystem[i].getDevName());
					this.ps.setString(3, this.arrFileSystem[i].getDirName());
					this.ps.setString(4, this.arrFileSystem[i].getSysTypeName());
					this.ps.setString(5, this.arrFileSystem[i].getTypeName());
					this.ps.setLong(6, usage.getTotal());
					this.ps.setLong(7, usage.getTotal() - usage.getFree());
					this.ps.setLong(8, usage.getAvail());
					this.ps.setDouble(9, usage.getUsePercent());
					
					this.ps.executeUpdate();
				}
				
			} catch (Exception e) {
				throw e;
			}
			
			if (flag) log.debug("insert KANG.TB_DSKREC...");
		}
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
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static String getTimestamp(String format) {
		return new SimpleDateFormat(format).format(new Date());
	}
	
	private static String getTimestamp() {
		return getTimestamp("yyyy-MM-dd HH:mm:00.000");
	}
	
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
				
				if (!curTimestamp.equals(oldTimestamp)) {
					/*
					 * do job thread
					 */
					Thread thread = new Thread(new MainSetter());
					thread.start();
					thread.join();
					
					oldTimestamp = curTimestamp;
				}
				
				/*
				 * wait 10 seconds
				 */
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
