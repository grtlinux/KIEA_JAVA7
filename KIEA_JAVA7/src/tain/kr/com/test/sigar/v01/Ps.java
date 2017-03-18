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

import org.apache.log4j.Logger;
import org.hyperic.sigar.SigarException;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Ps.java
 *   -. Package    : tain.kr.com.test.sigar.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 17. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Ps extends SigarCommandBase {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Ps.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Ps(Shell shell) {
		super(shell);
		if (!flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	public Ps() {
		super();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected boolean validateArgs(String[] args) {
		return true;
	}
	
	public String getSyntaxArgs() {
		return "[pid|query]";
	}
	
	public String getUsageShort() {
		return "Show process status";
	}
	
	public boolean isPidCompleter() {
		return true;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void output(String[] args) throws SigarException {
		
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new Ps();

		if (flag) {
			/*
			 * begin
			 */
			new Ps().processCommand(args);
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
