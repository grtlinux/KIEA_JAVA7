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
package tain.kr.com.test.process.v01;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.process.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 12. {time}
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
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainTest();

		if (!flag) {
			/*
			 * begin-1
			 */
			File workDir = new File("N:/");
			String[] env = new String[] { "FOLDER=PROG" };
			String cmd = "cmd /c dir %FOLDER%";
			// String[] cmd = new String[] { "/bin/sh", "-c", "dir %FOLDER%" };
			
			Runtime run = Runtime.getRuntime();
			Process process = run.exec(cmd, env, workDir);
			
			if (process.waitFor() == 0) {
				/*
				 * success
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.printf("OUT LINE:%s\n", line);
				}
			} else {
				/*
				 * error
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.printf("ERR LINE:%s\n", line);
				}
			}
			
			process.destroy();
		}
		
		if (!flag) {
			/*
			 * begin-2
			 */
			File workDir = new File("N:/");
			String[] env = new String[] { "" };
			String cmd = "netstat -n";
			
			Runtime run = Runtime.getRuntime();
			Process process = run.exec(cmd, env, workDir);
			
			if (process.waitFor() == 0) {
				/*
				 * success
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.printf("OUT LINE:%s\n", line);
				}
			} else {
				/*
				 * error
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line;
				while ((line = br.readLine()) != null) { 
					System.out.printf("ERR LINE:%s\n", line);
				}
			}
			
			process.destroy();
		}

		if (flag) {
			/*
			 * begin-3
			 */
			File workDir = new File("N:/");
			String[] env = new String[] { "PATH=C:\\Windows\\SysWOW64;%PATH%", "STR=DIR" };
			String cmd = "cmd /c dir | findstr %STR%";   // SUCCESS using a pipe
			// String cmd = "netstat -na | C:\\Windows\\SysWOW64\\findstr.exe 443";  // ERROR
			
			Runtime run = Runtime.getRuntime();
			Process process = run.exec(cmd, env, workDir);
			
			if (process.waitFor() == 0) {
				/*
				 * success
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.printf("OUT LINE:%s\n", line);
				}
			} else {
				/*
				 * error
				 */
				BufferedReader br = new BufferedReader(new InputStreamReader(process.getErrorStream()));
				String line;
				while ((line = br.readLine()) != null) {
					System.out.printf("ERR LINE:%s\n", line);
				}
			}
			
			process.destroy();
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
