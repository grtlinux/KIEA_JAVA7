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
import java.io.FileFilter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

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
	
	private static final String KEY_CHECK_TIME = "tain.filesync.folderinfo.check.time";
	
	private String strCheckTime = null;
	
	private String strName = null;
	private String strDesc = null;
	private String strPath = null;
	
	private long lDate = 0;
	private long lCheckTime = 0;
	
	private Map<String, FileInfo> fileInfos = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public FolderInfo(String strName, String strDesc, String strPath) throws Exception {
		
		if (flag) {
			String className = this.getClass().getName();
			ResourceBundle rb = ResourceBundle.getBundle(className.replace('.', '/'));
			
			this.strCheckTime = rb.getString(KEY_CHECK_TIME);
			
			this.lCheckTime = Long.parseLong(this.strCheckTime);
		}

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
		
		if (flag) {
			this.fileInfos = new HashMap<String, FileInfo>();
		}
		
		if (flag) makeInfo();
		if (flag) print();
	}
	
	public FolderInfo(String strPath) throws Exception {
		this(null, null, strPath);
	}
	
	private void makeInfo() throws Exception {
		if (flag) log.debug(">>>>> private function of FolderInfo.makeInfo");
		
		File folder = new File(this.strPath);

		File[] files = null;
		
		try {
			// select files for checking
			files = folder.listFiles(new FileFilter() {
				@Override
				public boolean accept(File file) {

					if (flag) {
						// only files
						if (file.isDirectory())
							return false;
					}
					
					if (flag) {
						// get name of file
						// String name = file.getName();
					}
					
					if (flag) {
						// check the last modified datetime
						long lDelta = Math.abs(new Date().getTime() - file.lastModified());
						if (lCheckTime > 0 && lCheckTime < lDelta) {
							return false;
						}
					}

					return true;
				}
			});
			
			if (flag) {
				// make fileinfos Map
				for (File file : files) {
					try {
						String fileName = file.getName();
						String filePath = file.getParent();
						
						FileInfo fileInfo = new FileInfo(fileName, filePath);
						
						this.fileInfos.put(fileName, fileInfo);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			
		}
	}
	
	public void print() throws Exception {
		
		if (flag) {
			String strPrint = String.format("[%s] [%s] [%s] [%s]"
					, this.strName
					, this.strDesc
					, this.strPath
					, DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate)
					);
			System.out.println(strPrint);
			System.out.println();
		}
		
		if (flag) {
			for (Map.Entry<String, FileInfo> entry : this.fileInfos.entrySet()) {
				entry.getValue().print();
				System.out.println();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private void check() throws Exception {
		
		if (flag) log.debug(">>>>> current    : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss"));
		
		if (flag) {
			File path = new File(this.strPath);
			this.lDate = path.lastModified();
			if (flag) log.debug(">>>>> path mdate : " + DateTime.getInstance().get("yyyy/MM/dd HH:mm:ss", this.lDate));
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			String strPath = "N:/TEMP/FILES";
			
			// FolderInfo info = new FolderInfo(strPath);
			FolderInfo info = new FolderInfo("FILES", null, strPath);
			
			for (int i=0; i < 100; i++) {
				
				info.check();
				
				try { Thread.sleep(1000 * 5); } catch (InterruptedException e) {}
			}
		}

		if (flag) {
			String strPath = "N:/TEMP/FILES";
			
			// new FolderInfo(strPath);
			new FolderInfo("FILES", null, strPath);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
