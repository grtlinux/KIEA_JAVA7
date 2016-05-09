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

import java.io.File;

import org.apache.log4j.Logger;

import tain.kr.com.test.filesync.v01.util.DateTime;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FolderInfo.java
 *   -. Package    : tain.kr.com.test.filesync.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FolderInfo {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FolderInfo.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String strName = null;
	private String strDesc = null;
	private String strPath = null;
	
	private long lDate = 0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public FolderInfo(String strName, String strDesc, String strPath) throws Exception {
		
		if (flag) {
			this.strName = strName;
			this.strDesc = strDesc;
			this.strPath = strPath;
		}
		
		if (flag) {
			if (this.strName == null) 
				this.strName = "FolderName";
			
			if (this.strDesc == null)
				this.strDesc = "FolderDesc";
		}
		
		if (flag) {
			if (this.strPath == null)
				throw new Exception("ERROR : wrong path name.");
		}
	}
	
	public FolderInfo(String strPath) throws Exception {
		this(null, null, strPath);
	}
	
	public void check() throws Exception {
		
		if (flag) log.debug(">>>>> current    : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss"));
		
		if (flag) {
			File path = new File(this.strPath);
			this.lDate = path.lastModified();
			if (flag) log.debug(">>>>> path mdate : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate));
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String strPath = "N:/TEMP/FILES";
			
			FolderInfo info = new FolderInfo(strPath);
			
			for (int i=0; i < 100; i++) {
				
				info.check();
				
				try { Thread.sleep(1000 * 5); } catch (InterruptedException e) {}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
