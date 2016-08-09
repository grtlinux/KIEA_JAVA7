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
package tain.kr.com.test.gc.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MemoryCheckMain.java
 *   -. Package    : tain.kr.com.test.gc.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MemoryCheckMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MemoryCheckMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			long totalMemory0 = Runtime.getRuntime().totalMemory();
			long freeMemory0 = Runtime.getRuntime().freeMemory();
			long usedMemory0 = totalMemory0 - freeMemory0;
			
			System.out.format("[ Before System.gc() ] Used  Memory : %,15d\n", usedMemory0);
			System.out.format("[ Before System.gc() ] Free  Memory : %,15d\n", freeMemory0);
			System.out.format("[ Before System.gc() ] Total Memory : %,15d\n", totalMemory0);
			System.out.println();
			
			System.gc();
			
			long totalMemory1 = Runtime.getRuntime().totalMemory();
			long freeMemory1 = Runtime.getRuntime().freeMemory();
			long usedMemory1 = totalMemory1 - freeMemory1;

			System.out.format("[ After  System.gc() ] Used  Memory : %,15d\n", usedMemory1);
			System.out.format("[ After  System.gc() ] Free  Memory : %,15d\n", freeMemory1);
			System.out.format("[ After  System.gc() ] Total Memory : %,15d\n", totalMemory1);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
