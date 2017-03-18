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
package tain.kr.com.test.sigar.v01;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Runner.java
 *   -. Package    : tain.kr.com.test.sigar.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 17. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Runner {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Runner.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static HashMap wantedJars = new HashMap();
	private static final String JAR_EXT = ".jar";

	static {
		wantedJars.put("junit", Boolean.FALSE);
		wantedJars.put("log4j", Boolean.FALSE);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Runner() {
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

		if (flag) {
			/*
			 * begin
			 */
			if (args.length < 1) {
				args = new String[] { "Shell" };
			} else {
				//e.g. convert
				//          "ifconfig", "eth0"
				//   to:
				// "Shell", "ifconfig", "eth0"
				if (Character.isLowerCase(args[0].charAt(0))) {
					String[] nargs = new String[args.length + 1];
					System.arraycopy(args, 0, nargs, 1, args.length);
					nargs[0] = "Shell";
					args = nargs;
				}
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
