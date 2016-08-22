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
package tain.kr.com.test.array.v01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : String2ListTestMain.java
 *   -. Package    : tain.kr.com.test.array.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 4. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class String2ListTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(String2ListTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			List<String> list1 = new ArrayList<String>();
			
			list1.add("str-1");
			list1.add("str-2");
			list1.add("str-3");
			
			if (flag) {
				for (String str : list1) {
					log.debug("1 > " + str);
				}
				
				System.out.println("OK > " + list1);
				log.debug("OK > " + list1);
			}
			
			String[] strArr = list1.toArray(new String[list1.size()]);
			
			if (flag) {
				for (String str : strArr) {
					log.debug("2 > " + str);
				}

				System.out.println("ERROR > " + strArr);
				log.debug("ERROR > " + strArr);
			}
			
			List<String> list2 = new ArrayList<String>(Arrays.asList(strArr));
			
			if (flag) {
				for (String str : list2) {
					log.debug("3 > " + str);
				}

				System.out.println("OK > " + list2);
				log.debug("OK > " + list2);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
