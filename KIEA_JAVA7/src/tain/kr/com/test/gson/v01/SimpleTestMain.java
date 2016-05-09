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
package tain.kr.com.test.gson.v01;

import org.apache.log4j.Logger;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SimpleTestMain.java
 *   -. Package    : tain.kr.com.test.gson.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SimpleTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SimpleTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String[] name = new String[] { "Name", "Age" };
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			JsonObject obj1 = new JsonObject();
			obj1.addProperty(name[0], "AAAA");
			obj1.addProperty(name[1], "26");

			JsonObject obj2 = new JsonObject();
			obj2.addProperty(name[0], "BBBB");
			obj2.addProperty(name[1], "30");
			
			JsonArray arrObj = new JsonArray();
			arrObj.add(obj1);
			arrObj.add(obj2);
			
			JsonObject info = new JsonObject();
			info.add("information", arrObj);
			
			if (flag) log.debug(info);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
