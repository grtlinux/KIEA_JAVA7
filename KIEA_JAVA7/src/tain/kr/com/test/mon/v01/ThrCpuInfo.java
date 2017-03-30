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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;
import org.hyperic.sigar.SigarException;

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
		
		if (flag) {
			/*
			 * sample for select
			 */
			Statement stmt = this.conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet resultSet = stmt.executeQuery("SELECT * FROM KANG.TB_CPUINFO");
			ResultSetMetaData meta = resultSet.getMetaData();
			
			if (flag) {
				/*
				 * row count
				 */
				int rowCount;
				resultSet.last();
				rowCount = resultSet.getRow();
				resultSet.beforeFirst();
				
				System.out.println("rowCount = " + rowCount);
			}
			
			if (flag) {
				/*
				 * print column info using meta data
				 */
				meta = resultSet.getMetaData();
				
				// column information
				for (int i=1; i <= meta.getColumnCount(); i++) {
					System.out.printf("\t[%d] [%s] [%s] [%d], [%s] [%s], [%d] [%s], [%s] [%s].\n"
							, i
							, meta.getCatalogName(i)
							, meta.getColumnClassName(i)
							, meta.getColumnDisplaySize(i)

							, meta.getColumnLabel(i)
							, meta.getColumnName(i)

							, meta.getColumnType(i)
							, meta.getColumnTypeName(i)

							, meta.getSchemaName(i)
							, meta.getTableName(i)
							);
				}
			}
			
			if (flag) {
				/*
				 * print row info
				 */
				while (resultSet.next()) {
					System.out.printf("[%s]\n", resultSet.getString("F_VNDR"));
				}
			}
			
			getTimestamp();
			
			resultSet.close();
			stmt.close();
		}
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

	private String getTimestamp() {
	
		return null;
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
			Thread thread = new Thread(new ThrCpuInfo());
			thread.start();
			thread.join();
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
