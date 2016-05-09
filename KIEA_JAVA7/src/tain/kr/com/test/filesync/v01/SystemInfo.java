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
package tain.kr.com.test.filesync.v01;

import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SystemInfo.java
 *   -. Package    : tain.kr.com.test.filesync.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SystemInfo {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SystemInfo.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String KEY_SERVER_NAME = "tain.filesync.systeminfo.server.name";
	private static final String KEY_WAIT_TIME = "tain.filesync.systeminfo.wait.time";
	private static final String KEY_LOOP_TIME = "tain.filesync.systeminfo.loop.time";
	
	private String strServerName = null;
	private String strWaitTime = null;
	private String strLoopTime = null;
	
	private int nWaitTime = 0;
	private int nLoopTime = 0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private SystemInfo() throws Exception {
		
		if (flag) {
			String className = this.getClass().getName();
			ResourceBundle rb = ResourceBundle.getBundle(className.replace('.', '/'));
			
			this.strServerName = rb.getString(KEY_SERVER_NAME);
			this.strWaitTime = rb.getString(KEY_WAIT_TIME);
			this.strLoopTime = rb.getString(KEY_LOOP_TIME);
			
			this.nWaitTime = Integer.parseInt(this.strWaitTime);
			this.nLoopTime = Integer.parseInt(this.strLoopTime);
		}
		
		if (flag) {
			if (flag) log.debug("### server.name = " + this.strServerName);
			if (flag) log.debug("### wait time = " + this.nWaitTime);
			if (flag) log.debug("### loop time = " + this.nLoopTime);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static SystemInfo instance = null;
	
	public static synchronized SystemInfo getInstance() throws Exception {
		
		if (instance == null) {
			instance = new SystemInfo();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			SystemInfo.getInstance();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
