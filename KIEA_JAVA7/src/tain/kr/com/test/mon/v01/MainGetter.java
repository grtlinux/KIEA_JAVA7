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
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainGetter.java
 *   -. Package    : tain.kr.com.test.mon.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 30. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainGetter implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainGetter.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainGetter() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		if (flag) {
			try {
				if (flag) createConnection();
				
				if (flag) selectTbCpuInfo();
				if (flag) selectTbCpuRec();
				if (flag) selectTbMemRec();
				if (flag) selectTbDskRec();
				
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (flag) closeConnection();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void createConnection() throws Exception {
		
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
			this.stmt = this.conn.createStatement();
			
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
	
	private void closeConnection() {
		
		if (flag) {
			if (this.stmt != null) try { this.stmt.close(); } catch (Exception e) {}
			if (this.conn != null) try { this.conn.close(); } catch (Exception e) {}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void selectTbCpuInfo() {
		
		if (flag) {
			/*
			 * display the datas from the table KANG.TB_CPUINFO
			 */
			try {
				this.rs = this.stmt.executeQuery(""
						+ "select "
						+ "    F_VNDR       , "
						+ "    F_MDL        , "
						+ "    F_MHZ        , "
						+ "    F_TTL        , "
						+ "    F_PHS        , "
						+ "    F_CPC        , "
						+ "    F_YN         , "
						+ "    DTTM_REG       "
						+ "from "
						+ "    KANG.TB_CPUINFO "
						+ "order by "
						+ "    DTTM_REG desc "
						+ "offset 0 rows fetch next 10 rows only"
						);
				
				for (int i=0; this.rs.next(); i++) {
					if (flag) System.out.printf("(%4d) [%s] [%s] - [%d] [%d] [%d] [%d] - [%s] - [%s]\n"
							, i
							, this.rs.getString("F_VNDR")
							, this.rs.getString("F_MDL")
							, this.rs.getInt("F_MHZ")
							, this.rs.getInt("F_TTL")
							, this.rs.getInt("F_PHS")
							, this.rs.getInt("F_CPC")
							, this.rs.getString("F_YN")
							, this.rs.getTimestamp("DTTM_REG")
							);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void selectTbCpuRec() {
		
		if (flag) {
			/*
			 * display the datas from the table KANG.TB_CPUINFO
			 */
			try {
				this.rs = this.stmt.executeQuery(""
						+ "select "
						+ "    F_DTTM        , "
						+ "    F_CPUNM       , "
						+ "    F_USR         , "
						+ "    F_SYS         , "
						+ "    F_IDL         , "
						+ "    F_WAIT        , "
						+ "    F_NCE         , "
						+ "    F_CMB         , "
						+ "    F_IRQ         , "
						+ "    DTTM_REG        "
						+ "from "
						+ "    KANG.TB_CPUREC "
						+ "where "
						+ "    F_CPUNM = 'TOTAL' "
						+ "order by "
						+ "    F_DTTM desc "
						+ "offset 0 rows fetch next 10 rows only"
						);
				
				for (int i=0; this.rs.next(); i++) {
					if (flag) System.out.printf("(%4d) [%s] [%s] - [%f] [%f] [%f] [%f] [%f] [%f] [%f]\n"
							, i
							, this.rs.getTimestamp("F_DTTM")
							, this.rs.getString("F_CPUNM")
							, this.rs.getDouble("F_USR")
							, this.rs.getDouble("F_SYS")
							, this.rs.getDouble("F_IDL")
							, this.rs.getDouble("F_WAIT")
							, this.rs.getDouble("F_NCE")
							, this.rs.getDouble("F_CMB")
							, this.rs.getDouble("F_IRQ")
							);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void selectTbMemRec() {
		
		if (flag) {
			/*
			 * display the datas from the table KANG.TB_CPUINFO
			 */
			try {
				this.rs = this.stmt.executeQuery(""
						+ "select "
						+ "    F_DTTM        , "
						+ "    F_RAM         , "
						+ "    F_TTL         , "
						+ "    F_FRE         , "
						+ "    F_USE         , "
						+ "    F_FREP        , "
						+ "    F_USEP        , "
						+ "    F_AFRE        , "
						+ "    F_AUSE        , "
						+ "    F_SWTTL       , "
						+ "    F_SWFRE       , "
						+ "    F_SWUSE       , "
						+ "    F_SWPGI       , "
						+ "    F_SWPGO       , "
						+ "    DTTM_REG        "
						+ "from "
						+ "    KANG.TB_MEMREC "
						+ "order by "
						+ "    F_DTTM desc "
						+ "offset 0 rows fetch next 10 rows only"
						);
				
				for (int i=0; this.rs.next(); i++) {
					if (flag) System.out.printf("(%4d) [%s] - [%d] [%d] [%d] [%d] [%f] [%f] [%d] [%d] [%d] [%d] [%d] [%d] [%d]\n"
							, i
							, this.rs.getTimestamp("F_DTTM")
							, this.rs.getLong("F_RAM")
							, this.rs.getLong("F_TTL")
							, this.rs.getLong("F_FRE")
							, this.rs.getLong("F_USE")
							, this.rs.getDouble("F_FREP")
							, this.rs.getDouble("F_USEP")
							, this.rs.getLong("F_AFRE")
							, this.rs.getLong("F_AUSE")
							, this.rs.getLong("F_SWTTL")
							, this.rs.getLong("F_SWFRE")
							, this.rs.getLong("F_SWUSE")
							, this.rs.getLong("F_SWPGI")
							, this.rs.getLong("F_SWPGO")
							);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void selectTbDskRec() {
		
		if (flag) {
			/*
			 * display the datas from the table KANG.TB_CPUINFO
			 */
			try {
				this.rs = this.stmt.executeQuery(""
						+ "select "
						+ "    F_DTTM       , "
						+ "    F_DEVNM      , "
						+ "    F_DIRNM      , "
						+ "    F_SYSNM      , "
						+ "    F_TYPNM      , "
						+ "    F_TOT        , "
						+ "    F_USE        , "
						+ "    F_AVL        , "
						+ "    F_USEP       , "
						+ "    DTTM_REG       "
						+ "from "
						+ "    KANG.TB_DSKREC "
						+ "order by "
						+ "    F_DTTM desc "
						+ "offset 0 rows fetch next 10 rows only"
						);
				
				for (int i=0; this.rs.next(); i++) {
					if (flag) System.out.printf("(%4d) [%s] [%s] [%s] [%s] [%s] - [%d] [%d] [%d] [%f]\n"
							, i
							, this.rs.getTimestamp("F_DTTM")
							, this.rs.getString("F_DEVNM")
							, this.rs.getString("F_DIRNM")
							, this.rs.getString("F_SYSNM")
							, this.rs.getString("F_TYPNM")
							, this.rs.getLong("F_TOT")
							, this.rs.getLong("F_USE")
							, this.rs.getLong("F_AVL")
							, this.rs.getDouble("F_USEP")
							);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				
			}
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {
			/*
			 * begin
			 */
			for (int i=0; ; i = ++i % 1000) {
				
				if (flag) {
					/*
					 * do job thread
					 */
					Thread thread = new Thread(new MainGetter());
					thread.start();
					thread.join();
					
					if (flag) break;
				}
				
				/*
				 * waiting 10 seconds
				 */
				try { Thread.sleep(20 * 1000); } catch (InterruptedException e) {}
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
