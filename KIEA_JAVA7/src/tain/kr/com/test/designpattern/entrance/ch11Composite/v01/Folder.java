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
package tain.kr.com.test.designpattern.entrance.ch11Composite.v01;

import java.util.Iterator;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Folder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch11Composite.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
@SuppressWarnings("unused")
public class Folder extends Entry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Folder.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	private Vector<Entry> folder = new Vector<Entry>();
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Folder(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSize() {
		int size = 0;
		
		Iterator<Entry> it = folder.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			size += entry.getSize();
		}
		
		return size;
	}
	
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
		Iterator<Entry> it = folder.iterator();
		while (it.hasNext()) {
			Entry entry = it.next();
			entry.printList(prefix + "/" + name);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Entry add(Entry entry) {
		folder.addElement(entry);
		return this;
	}
}
