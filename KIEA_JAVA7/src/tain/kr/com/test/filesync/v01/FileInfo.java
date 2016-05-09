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
import java.io.FileInputStream;
import java.util.Date;

import org.apache.log4j.Logger;

import tain.kr.com.test.filesync.v01.util.DateTime;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileInfo.java
 *   -. Package    : tain.kr.com.test.filesync.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileInfo {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileInfo.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String strName = null;
	private String strDesc = null;
	private String strPath = null;

	private long lSize = 0;
	private long lDate = 0;
	private long lCrc = 0;
	
	private int nStep = 0;   // 1, 2, 3, 9
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public FileInfo(String strName, String strDesc, String strPath) throws Exception {
		
		if (flag) {
			this.strName = strName;
			this.strDesc = strDesc;
			this.strPath = strPath;
		}
		
		if (flag) {
			if (this.strDesc == null)
				this.strDesc = "FolderDesc";
		}
		
		if (flag) {
			if (this.strName == null)
				throw new Exception("ERROR : wrong file name.");

			if (this.strPath == null)
				throw new Exception("ERROR : wrong file path name.");
		}
	}
	
	public FileInfo(String strName, String strPath) throws Exception {
		this(strName, null, strPath);
	}
	
	public void check() throws Exception {
		
		System.out.println();
		
		if (flag) log.debug(">>>>> current    : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss"));
		
		if (flag) {
			File file = new File(this.strPath + File.separator + this.strName);
			
			if (flag) {
				this.lSize = file.length();
				if (flag) log.debug(">>>>> file size   : " + this.lSize);
			}
			
			if (flag) {
				this.lDate = file.lastModified();
				if (flag) log.debug(">>>>> file mdate 1 : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate));
				
				this.lDate = new Date().getTime();
				file.setLastModified(this.lDate);

				this.lDate = file.lastModified();
				if (flag) log.debug(">>>>> file mdate 2 : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate));
			}
			
			if (flag) {
				FileInputStream fis = new FileInputStream(file);
				
				int n;
				long crc = 0;
				
				while ((n = fis.read()) >= 0) {
					crc += n;
				}
				
				fis.close();
				
				this.lCrc = crc;
				if (flag) log.debug(">>>>> file lcrc    : " + this.lCrc);
			}
			
			if (flag) {
				if (flag) log.debug(">>>>> file step    : " + this.nStep);
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String strPath = "N:/TEMP/FILES";
			String strName = "tain-cosmarter-1.0.jar";
			
			FileInfo info = new FileInfo(strName, strPath);
			
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
