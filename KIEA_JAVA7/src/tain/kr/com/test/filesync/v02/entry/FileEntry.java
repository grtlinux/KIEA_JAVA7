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
package tain.kr.com.test.filesync.v02.entry;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FileEntry.java
 *   -. Package    : tain.kr.com.test.filesync.v02.entry
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FileEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FileEntry.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private String name = null;   // file name
	private String path = null;   // file path

	private long size = 0;        // file size
	private long date = 0;        // file mdate
	private long crc = 0;         // file crc value
	
	private int step = 0;         // step
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public FileEntry() {}

	public String getName() {
		return name;
	}

	public String getPath() {
		return path;
	}

	public long getSize() {
		return size;
	}

	public long getDate() {
		return date;
	}

	public long getCrc() {
		return crc;
	}

	public int getStep() {
		return step;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPath(String path) {
		this.path = path;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public void setCrc(long crc) {
		this.crc = crc;
	}

	public void setStep(int step) {
		this.step = step;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public void print() {
		
		if (flag) {
			String strPrint = String.format("[%s] [%s] [%d] [%d] [%d] [%d]"
					, name
					, path
					, size
					, date
					, crc
					, step
					);
			
			log.debug(">>>>>>>>>>> FileEntry : " + strPrint);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String strJson = "{ 'name':'tain-cosmarter-1.0.jar', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }";
			
			Gson gson = new Gson();
			FileEntry entry = gson.fromJson(strJson, FileEntry.class);
			entry.print();
			String str = gson.toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}

		if (flag) {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
