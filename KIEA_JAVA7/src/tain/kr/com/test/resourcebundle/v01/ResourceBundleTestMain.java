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
package tain.kr.com.test.resourcebundle.v01;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ResourceBundleTestMain.java
 *   -. Package    : tain.kr.com.test.resourcebundle.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ResourceBundleTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ResourceBundleTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private ResourceBundle rb = null;
	
	public ResourceBundleTestMain() {
	
		if (flag) {
			String name = this.getClass().getName().replace('.', '/');
			if (flag) log.debug(">>>>> " + name);
			
			this.rb = ResourceBundle.getBundle(name);
		}
	}
	
	public String get(String key) throws Exception {
		
		String ret = null;
		
		if (flag) {
			ret = this.rb.getString(key);
		}
		
		return ret;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String name = new Object(){}.getClass().getEnclosingClass().getName().replace('.', '/');
			
			ResourceBundle rb = ResourceBundle.getBundle(name);
			
			if (flag) log.debug("1> [" + rb.getString("tain.list") + "]");
			if (flag) log.debug("1> [" + rb.getString("tain.lists") + "]");
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			ResourceBundleTestMain testMain = new ResourceBundleTestMain();
			
			if (flag) log.debug("2> [" + testMain.get("tain.list") + "]");
			if (flag) log.debug("2> [" + testMain.get("tain.lists") + "]");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">" + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
