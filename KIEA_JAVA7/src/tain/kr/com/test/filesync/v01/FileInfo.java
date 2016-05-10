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
	
	private int nStep = 0;   // 0:create 1:makeInfo, 2:compare, 3:error, 9:sync OK
	
	private File file = null;
	
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
		
		if (flag) makeInfo();
		if (!flag) print();
	}
	
	public FileInfo(String strName, String strPath) throws Exception {
		this(strName, null, strPath);
	}
	
	private void makeInfo() throws Exception {
		if (!flag) log.debug(">>>>> private function of FileInfo.makeInfo");
		
		if (flag) {
			// File Object
			this.file = new File(this.strPath + File.separator + this.strName);

			if (!flag) log.debug("* file = " + this.file.getCanonicalPath());
		}
		
		if (flag) {
			// file size
			this.lSize = this.file.length();
			
			if (!flag) log.debug("* size = " + this.lSize);
		}
		
		if (flag) {
			// date time of file modified
			this.lDate = this.file.lastModified();
			
			if (!flag) log.debug("* date time = " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate));
		}
		
		if (!flag) {
			// CRC value of file - 1
			FileInputStream fis = new FileInputStream(this.file);
			
			int n;
			long crc = 0;
			
			while ((n = fis.read()) >= 0) {
				crc += n;
			}
			
			fis.close();
			
			this.lCrc = crc;
			
			if (!flag) log.debug("* CRC-1 = " + this.lCrc);
		}
		
		if (flag) {
			// CRC value of file - 2
			FileInputStream fis = new FileInputStream(this.file);
			
			byte[] bytBuffer = new byte[1024];
			int n;
			long crc = 0;
			
			while ((n = fis.read(bytBuffer)) >= 0) {
				for (int i=0; i < n; i++) {
					crc += (int) (0xFF & bytBuffer[i]);
				}
			}
			
			fis.close();
			
			this.lCrc = crc;
			
			if (!flag) log.debug("* CRC-2 = " + this.lCrc);
		}
		
		if (flag) {
			// step of file to display the status of the file
			this.nStep = 1;  // makeInfo is OK!!!
			
			if (!flag) log.debug("* step = " + this.nStep);
		}
	}
	
	public int getStep() throws Exception {
		return this.nStep;
	}
	
	public void print() throws Exception {
		
		if (flag) {
			String strPrint = String.format("[%,15d][%19s][%,20d][%1d][%s]"
					, this.lSize
					, DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate)
					, this.lCrc
					, this.nStep
					, this.file.getCanonicalPath()
					);
			
			if (flag) System.out.println(strPrint);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private void check() throws Exception {
		
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

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			String strPath = "N:/TEMP/FILES";
			String strName = "tain-cosmarter-1.0.jar";
			
			FileInfo info = new FileInfo(strName, strPath);
			
			for (int i=0; i < 100; i++) {
				
				info.check();
				
				try { Thread.sleep(1000 * 5); } catch (InterruptedException e) {}
			}
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			String strPath = "N:/TEMP/FILES";
			String strName = "tain-cosmarter-1.0.jar";
			
			new FileInfo(strName, strPath);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
