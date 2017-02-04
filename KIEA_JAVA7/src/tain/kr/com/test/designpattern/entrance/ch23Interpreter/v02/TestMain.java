/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.test.designpattern.entrance.ch23Interpreter.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 4. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public TestMain() {
		
		if (!flag) log.debug("1. class is " + this.getClass().getName());
		if (flag) log.debug("2. class is " + this.getClass().getSimpleName());
		if (!flag) log.debug("3. class is " + this.getClass().getCanonicalName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
	
		if (!flag) new TestMain();
		
		if (flag) {
			String[] programs = new String[] {
					"program end",
					"program go end",
					"program go right go right go right go right end",
					"program repeat 4 go right end end",
					"program repeat 4 repeat 3 go right go left end right end end",
			};
			
			for (String program : programs) {
				if (flag) log.debug("PROGRAM >>> " + program);
				
				Node node = new ProgramNode();
				node.parse(new Context(program));
				
				if (flag) log.debug("NODE >>> " + node);
				
				if (flag) System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>>  " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
