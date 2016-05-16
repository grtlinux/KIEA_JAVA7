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

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FolderEntry.java
 *   -. Package    : tain.kr.com.test.filesync.v02.entry
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FolderEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FolderEntry.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private String name = new String();
	private String desc = new String();
	private Map<String, FileEntry> fileEntries = new HashMap<String, FileEntry>();
	
	public void print() {
		
		if (flag) {
			log.debug("FolderEntry.name = " + name);
			log.debug("FolderEntry.desc = " + desc);
			
			for (Map.Entry<String, FileEntry> fileEntry : fileEntries.entrySet()) {
				String key = fileEntry.getKey();
				FileEntry val = fileEntry.getValue();
				
				log.debug(">>>>> " + key);
				val.print();
			}
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
