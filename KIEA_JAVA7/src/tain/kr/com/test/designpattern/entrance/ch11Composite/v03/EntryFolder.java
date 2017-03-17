/**
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016, 2017 TAIN, Inc.
 *
 */
package tain.kr.com.test.designpattern.entrance.ch11Composite.v03;

import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryFolder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch11Composite.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class EntryFolder extends AbstEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryFolder.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private final String name;
	private final Vector<AbstEntry> folder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public EntryFolder(String name) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());

		this.name = name;
		this.folder = new Vector<AbstEntry>();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getSize() {
		int size = 0;
		
		Iterator<AbstEntry> it = this.folder.iterator();
		while (it.hasNext()) {
			AbstEntry entry = it.next();
			size += entry.getSize();
		}
		
		return size;
	}
	
	@Override
	public AbstEntry add(AbstEntry entry) {
		folder.addElement(entry);
		return this;
	}

	@Override
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
		
		Iterator<AbstEntry> it = folder.iterator();
		while (it.hasNext()) {
			AbstEntry entry = it.next();
			entry.printList(prefix + "/" + name);
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
	///////////////////////////////////////////////////////////////////////////////////////////////

}
