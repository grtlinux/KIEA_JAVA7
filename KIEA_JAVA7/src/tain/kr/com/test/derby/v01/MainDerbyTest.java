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
package tain.kr.com.test.derby.v01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainDerbyTest.java
 *   -. Package    : tain.kr.com.test.derby.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 29. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainDerbyTest {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainDerbyTest.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String framework = "embedded";
	private String driver = "org.apache.derby.jdbc.EmbeddedDriver";
	private String protocol = "jdbc:derby:";
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainDerbyTest() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public final void go(String[] args) {
		
		// parse the arguments to determine which framework is desired
		parseArguments(args);
		
		System.out.println("MainDerbyTest starting in " + this.framework + " mode");
		
		// load the desired JDBC driver
		loadDriver();
		
		Connection conn = null;
		
		List<Statement> statements = new ArrayList<Statement>(); // list of Statements, PreparedStatements
		PreparedStatement psInsert = null;
		PreparedStatement psUpdate = null;
		Statement s = null;
		ResultSet rs = null;
		
		try {
			Properties prop = new Properties();  // connection properties
			// providing a user name and password is optional in the embedded
			// and derbyclient frameworks
			prop.put("user", "kang");
			prop.put("password", "kang123!");
			
			// the name of the database
			String dbName = "taindb01";
			
			conn = DriverManager.getConnection(this.protocol + dbName + ";create=true", prop);
			System.out.println("Connected to and created database " + dbName);
			
			conn.setAutoCommit(false);
			
			// Creating a statement object that we can use for running various SQL statements command against the database.
			s = conn.createStatement();
			statements.add(s);
			
			// we now create a table...
			s.execute("create table location (num int, addr varchar(40))");
			System.out.println("Create table location");
			
			// and add a few rows...
			psInsert = conn.prepareStatement("insert into location values (?, ?)");
			statements.add(psInsert);
			
			psInsert.setInt(1, 1956);
			psInsert.setString(2, "Webster St.");
			psInsert.executeUpdate();
			System.out.println("Inserted 1956 Webster");

			psInsert.setInt(1, 1910);
			psInsert.setString(2, "Union St.");
			psInsert.executeUpdate();
			System.out.println("Inserted 1910 Union");
			
			psUpdate = conn.prepareStatement("update location set num=?, addr=? where num=?");
			statements.add(psUpdate);
			
			psUpdate.setInt(1, 180);
			psUpdate.setString(2, "Grand Ave.");
			psUpdate.setInt(3, 1956);
			psUpdate.executeUpdate();
			System.out.println("Update 1956 Webster to 180 Grand.");
			
			psUpdate.setInt(1, 300);
			psUpdate.setString(2, "Lakeshore Ave.");
			psUpdate.setInt(3, 180);
			psUpdate.executeUpdate();
			System.out.println("Update 180 Grand to 300 Lakeshore.");
			
			rs = s.executeQuery("select num, addr from location order by num");
			
			int number;   // street number retreived from the location
			boolean failure = false;
			
			if (!rs.next()) {
				failure = true;
				reportFailure("No rows in ResultSet");
			}
			
			if ((number = rs.getInt(1)) != 300) {
				failure = true;
				reportFailure("Wrong row returned, excepted num=300, get " + number);
			}
			
			if (!rs.next()) {
				failure = true;
				reportFailure("Too few rows");
			}
			
			if ((number = rs.getInt(1)) != 1910) {
				failure = true;
				reportFailure("Wrong row returned, excepted num=1910, get " + number);
			}
			
			if (rs.next()) {
				failure = true;
				reportFailure("Too many rows");
			}
			
			if (!failure) {
				System.out.println("Verified the rows");
			}
			
			// delete the table
			s.execute("drop table location");
			System.out.println("Dropped table location");
			
			// we commit the transitions. any changes will be persisted to the database now.
			conn.commit();
			System.out.println("Committed the transitions.");
			
			if (this.framework.equalsIgnoreCase("embedded")) {
				try {
					// the shutdown=true attribute shuts down Derby
					DriverManager.getConnection("jdbc:derby:;shutdown=true");
				} catch (SQLException e) {
					if ((e.getErrorCode() == 50000) && ("XJ015".equals(e.getSQLState()))) {
						// we get the expected exception
						System.out.println("Derby shut down normally");
						// Note that for single database shutdown, the expected SQL state is "08006", and the error code is 45000.
					} else {
						// if the error code or SQLState is different, we have an unexpected exception (shutdown failed)
						System.err.println("Derby did not shut down normally.");
						MainDerbyTest.printSQLException(e);
					}
				}
			}
			
			
		} catch (SQLException e) {
			MainDerbyTest.printSQLException(e);
		} finally {
			// release all open resources to avoid unnecessary memory usage
			
			// ResultSet
			try {
				if (rs != null) {
					rs.close();
					rs = null;
				}
			} catch (SQLException e) {
				MainDerbyTest.printSQLException(e);
			}
			
			// Statements and PreparedStatements
			for (Statement statement : statements) {
				try {
					if (statement != null) {
						statement.close();
						statement = null;
					}
				} catch (SQLException e) {
					MainDerbyTest.printSQLException(e);
				}
			}
			
			// Connection
			try {
				if (conn != null) {
					conn.close();
					conn = null;
				}
			} catch (SQLException e) {
				MainDerbyTest.printSQLException(e);
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final void loadDriver() {
		
		try {
			Class.forName(this.driver).newInstance();
			System.out.println("Loaded the appropriate driver");
		} catch (ClassNotFoundException e) {
			System.err.println("\nUnable to load the JDBC driver " + this.driver);
			System.err.println("Please check your CLASSPATH.");
			e.printStackTrace(System.err);
		} catch (InstantiationException e) {
			System.err.println("\nUnable to instantiate the JDBC driver " + this.driver);
			e.printStackTrace(System.err);
		} catch (IllegalAccessException e) {
			System.err.println("\nNot allowed to access the JDBC driver " + this.driver);
			e.printStackTrace(System.err);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final void reportFailure(String message) {
		
		System.err.println("\nData verification failed:");
		System.err.println("\t" + message);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final void parseArguments(String[] args) {
		
		if (args.length > 0) {
			if ("jccjdbcclient".equalsIgnoreCase(args[0])) {
				this.framework = "jccjdbc";
				this.driver = "com.ibm.db2.jcc.DB2Driver";
				this.protocol = "jdbc:derby:net://localhost:1527/";
			} else if ("derbyclient".equalsIgnoreCase(args[0])) {
				this.framework = "derbyclient";
				this.driver = "org.apache.derby.jdbc.ClientDriver";
				this.protocol = "jdbc:derby://localhost:1527/";
			}
		} else {
			/*
			 * Framework = embedded
			 * Driver = org.apache.derby.jdbc.EmbeededDriver
			 * 
			 * VM arguments : -Dderby.system.home=[Database Folder]
			 *  e.g) -Dderby.system.home=N:/tain/data/derbyDB
			 * 
			 */
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final void printSQLException(SQLException e) {
		
		// Unwraps the entire exception chain to unveil the real cause of the Exception
		while (e != null) {
			System.err.println("\n----- SQLException -----");
			System.err.println("   SQL State  : " + e.getSQLState());
			System.err.println("   Error Code : " + e.getErrorCode());
			System.err.println("   Message    : " + e.getMessage());
			// for stack traces, refer to derby.log or uncomment this;
			// e.printStackTrace(System.err);
			e = e.getNextException();
		}
	}
	
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

		if (!flag) {
			args = new String[] { "derbyclient" };
		}
		
		if (flag) {
			new MainDerbyTest().go(args);
			if (flag) log.debug(String.format("DESC: MainDerbyTest finished."));
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
