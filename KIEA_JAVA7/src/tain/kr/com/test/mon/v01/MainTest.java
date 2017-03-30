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
import org.hyperic.sigar.Cpu;
import org.hyperic.sigar.CpuInfo;
import org.hyperic.sigar.CpuPerc;
import org.hyperic.sigar.Sigar;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.mon.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 30. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
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
	
	/*
	 * dbms for derby
	 */
	private static void test00(String[] args) throws Exception {
		
		String driver = "org.apache.derby.jdbc.ClientDriver";
		String protocol = "jdbc:derby://localhost:1527/";
		String database = "taindb01";
		
		String user = "kang";
		String pass = "kang123!";
		
		Connection conn = null;
		
		try {
			Class.forName(driver).newInstance();
			
			Properties prop = new Properties();  // connection properties
			prop.put("user", user);
			prop.put("password", pass);
			
			conn = DriverManager.getConnection(protocol + database + ";create=true", prop);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (InstantiationException e) {
			e.printStackTrace();
			throw e;
		} catch (IllegalAccessException e) {
			e.printStackTrace();
			throw e;
		} catch (SQLException e) {
			e.printStackTrace();
			throw e;
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		
		if (flag) System.out.println("get a connection...");
		
		conn.setAutoCommit(false);
		
		if (flag) {
			/*
			 * sample for select
			 */
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
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
			
			resultSet.close();
			stmt.close();

			try { Thread.sleep(10 * 1000); } catch (InterruptedException e) {}
			
			conn.commit();
		}
		
		conn.close();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainTest();

		if (!flag) {
			/*
			 * Cpu
			 */
			Sigar sigar;
			Cpu cpu = new Cpu();
			//Cpu[] arrCpu = sigar.getCpuList();
			//CpuInfo[] arrCpuInfo = sigar.getCpuInfoList();
			//CpuPerc cpuPerc = sigar.getCpuPerc();
			//CpuPerc[] arrCpuPerc = sigar.getCpuPercList();
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				cpu.gather(sigar);
				
				System.out.printf("%d %d %d %d %d\n"
						, cpu.getIdle()
						, cpu.getSys()
						, cpu.getUser()
						, cpu.getWait()
						, cpu.getTotal()
						);
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
			}
		}
		
		if (!flag) {
			/*
			 * Cpu[]
			 */
			Sigar sigar;
			Cpu[] arrCpu;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				arrCpu = sigar.getCpuList();
				
				System.out.printf("arrCpu.length = %d\n", arrCpu.length);
				for (int idx=0; idx < arrCpu.length; idx++) {
					System.out.printf("\t[%d] %d %d %d %d %d\n"
							, idx
							, arrCpu[idx].getIdle()
							, arrCpu[idx].getSys()
							, arrCpu[idx].getUser()
							, arrCpu[idx].getWait()
							, arrCpu[idx].getTotal()
							);
				}
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
			}
		}
		
		if (!flag) {
			/*
			 * CpuInfo[]
			 */
			Sigar sigar;
			CpuInfo[] arrCpuInfo;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				arrCpuInfo = sigar.getCpuInfoList();
				
				System.out.printf("arrCpuInfo.length = %d\n", arrCpuInfo.length);  // -> 0
				for (int idx=0; idx < arrCpuInfo.length; idx++) {
					System.out.printf("\t[%d] %d %d %d %s %d %d %s\n"
							, idx
							, arrCpuInfo[idx].getCacheSize()
							, arrCpuInfo[idx].getCoresPerSocket()
							, arrCpuInfo[idx].getMhz()
							, arrCpuInfo[idx].getModel()
							, arrCpuInfo[idx].getTotalCores()
							, arrCpuInfo[idx].getTotalSockets()
							, arrCpuInfo[idx].getVendor()
							);
				}
				
				try { Thread.sleep(10000); } catch (InterruptedException e) {}
			}
		}
		
		if (!flag) {
			/*
			 * CpuPerc[]
			 */
			Sigar sigar;
			CpuPerc[] arrCpuPerc;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				arrCpuPerc = sigar.getCpuPercList();
				
				System.out.printf("arrCpuPerc.length = %d\n", arrCpuPerc.length);
				for (int idx=0; idx < arrCpuPerc.length; idx++) {
					System.out.printf("\t[%d] %f %f %f %f %f %f %f %f %f\n"
							, idx
							, arrCpuPerc[idx].getCombined()
							, arrCpuPerc[idx].getIdle()
							, arrCpuPerc[idx].getIrq()
							, arrCpuPerc[idx].getNice()
							, arrCpuPerc[idx].getSoftIrq()
							, arrCpuPerc[idx].getStolen()
							, arrCpuPerc[idx].getSys()
							, arrCpuPerc[idx].getUser()
							, arrCpuPerc[idx].getWait()
							);
				}
				
				try { Thread.sleep(10000); } catch (InterruptedException e) {}
			}
		}
		
		if (flag) {
			/*
			 * CpuPerc
			 */
			Sigar sigar;
			CpuPerc cpuPerc;
			
			for (int i=0; i < 1000; i++) {
				sigar = new Sigar();
				cpuPerc = sigar.getCpuPerc();
				
				System.out.printf("\t%f %f %f %f %f %f %f %f %f\n"
						, cpuPerc.getCombined()
						, cpuPerc.getIdle()
						, cpuPerc.getIrq()
						, cpuPerc.getNice()
						, cpuPerc.getSoftIrq()
						, cpuPerc.getStolen()
						, cpuPerc.getSys()
						, cpuPerc.getUser()
						, cpuPerc.getWait()
						);
				
				try { Thread.sleep(2000); } catch (InterruptedException e) {}
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

		if (flag) test00(args);  // dbms of derby
		
		if (!flag) test01(args);  // cpu information
		
		// disk information
		
		// network information
		
		// user information
		
		// processes information
		
		
		
	}
}
