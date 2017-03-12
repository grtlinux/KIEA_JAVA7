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
package tain.kr.com.test.processbuilder.v01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ProcessRunner.java
 *   -. Package    : tain.kr.com.test.processbuilder.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 12. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ProcessRunner {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ProcessRunner.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ProcessRunner() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void printStream(Process process) throws Exception {
		
		process.waitFor();
		try (InputStream psout = process.getInputStream()) {
			copy(psout, System.out);
		}
	}
	
	private void copy(InputStream is, OutputStream os) throws IOException {
		
		byte[] bytRead = new byte[1024];
		int nRead;
		
		while ((nRead = is.read(bytRead)) != -1) {
			os.write(bytRead, 0, nRead);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void byRuntime(String[] command) throws Exception {
		
		Runtime runtime = Runtime.getRuntime();
		Process process = runtime.exec(command);
		printStream(process);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void byProcessBuilder(String[] command) throws Exception {
		
		ProcessBuilder builder = new ProcessBuilder(new ArrayList<String>(Arrays.asList(command)));
		Process process = builder.start();
		printStream(process);
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

		if (flag)
			new ProcessRunner();

		if (flag) {
			/*
			 * begin
			 */
			String[] command = new String[] { "cmd", "/c", "echo", "%PATH%" };
			
			ProcessRunner runner = new ProcessRunner();
			runner.byRuntime(command);
			runner.byProcessBuilder(command);
			runner.byProcessBuilderRedirect(command);
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
