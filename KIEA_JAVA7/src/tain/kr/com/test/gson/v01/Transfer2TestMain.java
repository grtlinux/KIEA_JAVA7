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

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Transfer2TestMain.java
 *   -. Package    : tain.kr.com.test.gson.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 10. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Transfer2TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Transfer2TestMain.class);

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
			String strJson = ""
					+ "{                                                                                                                                                                     "
					+ "    'name' : 'folder_name-1',                                                                                                                                         "
					+ "    'desc' : 'folder_desc-1',                                                                                                                                         "
					+ "    'fileEntries' : {                                                                                                                                                 "
					+ "       'tain-cosmarter-1.0.jar1' : { 'name':'tain-cosmarter-1.0.jar1', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }, "
					+ "       'tain-cosmarter-1.0.jar2' : { 'name':'tain-cosmarter-1.0.jar2', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }  "
					+ "    }                                                                                                                                                                 "
					+ "}                                                                                                                                                                     "
					;
			
			Gson gson = new Gson();
			FolderEntry entry = gson.fromJson(strJson, FolderEntry.class);
			entry.print();
			String str = gson.toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}
		
		if (flag) {
			String strJson = ""
					+ "{                                                                                                                                                                             "
					+ "    'name' : 'system_name-1',                                                                                                                                                 "
					+ "    'folderEntries' : {                                                                                                                                                       "
					+ "        'FILES' : {                                                                                                                                                           "
					+ "            'name' : 'folder_name-1',                                                                                                                                         "
					+ "            'desc' : 'folder_desc-1',                                                                                                                                         "
					+ "            'fileEntries' : {                                                                                                                                                 "
					+ "               'tain-cosmarter-1.0.jar1' : { 'name':'tain-cosmarter-1.0.jar1', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }, "
					+ "               'tain-cosmarter-1.0.jar2' : { 'name':'tain-cosmarter-1.0.jar2', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }  "
					+ "            }                                                                                                                                                                 "
					+ "        },                                                                                                                                                                    "
					+ "        'cfg' : {                                                                                                                                                             "
					+ "            'name' : 'folder_name-2',                                                                                                                                         "
					+ "            'desc' : 'folder_desc-2',                                                                                                                                         "
					+ "            'fileEntries' : {                                                                                                                                                 "
					+ "               'tain-cosmarter-1.0.jar3' : { 'name':'tain-cosmarter-1.0.jar3', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }, "
					+ "               'tain-cosmarter-1.0.jar4' : { 'name':'tain-cosmarter-1.0.jar4', 'path':'N:/TEMP/FILES', 'size':'1517398', 'date':'1462787084096', crc:'329886128', step:'1' }  "
					+ "            }                                                                                                                                                                 "
					+ "        }                                                                                                                                                                     "
					+ "    }                                                                                                                                                                         "
					+ "}                                                                                                                                                                             "
					;
			
			Gson gson = new Gson();
			SystemEntry entry = gson.fromJson(strJson, SystemEntry.class);
			entry.print();
			String str = gson.toJson(entry);
			System.out.println("> " + str);
			
			System.out.println("\n\n\n");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class FileEntry {
	private String name = null;
	private String path = null;

	private long size = 0;
	private long date = 0;
	private long crc = 0;
	
	private int step = 0;
	
	public void print() {
		String strPrint = String.format("[%s] [%s] [%d] [%d] [%d] [%d]"
				, name
				, path
				, size
				, date
				, crc
				, step
				);
		
		System.out.println(">>>>>>>>>>> " + strPrint);
	}
}

class FolderEntry {
	private String name = new String();
	private String desc = new String();
	private Map<String, FileEntry> fileEntries = new HashMap<String, FileEntry>();
	
	public void print() {
		
		System.out.println("FolderEntry.name = " + name);
		System.out.println("FolderEntry.desc = " + desc);
		
		for (Map.Entry<String, FileEntry> fileEntry : fileEntries.entrySet()) {
			String key = fileEntry.getKey();
			FileEntry val = fileEntry.getValue();
			
			System.out.println(">>>>> " + key);
			val.print();
		}
	}
}

class SystemEntry {
	private String name = new String();
	private Map<String, FolderEntry> folderEntries = new HashMap<String, FolderEntry>();
	
	public void print() {
		
		System.out.println("SystemEntry.name = " + name);

		for (Map.Entry<String, FolderEntry> folderEntry : folderEntries.entrySet()) {
			String key = folderEntry.getKey();
			FolderEntry val = folderEntry.getValue();
			
			System.out.println(">>> " + key);
			val.print();
		}
	}
}


