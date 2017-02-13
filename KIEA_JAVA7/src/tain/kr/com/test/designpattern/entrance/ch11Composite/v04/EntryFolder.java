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
package tain.kr.com.test.designpattern.entrance.ch11Composite.v04;

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryFolder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch11Composite.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 13. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class EntryFolder extends AbstEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryFolder.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final Vector<AbstEntry> folder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public EntryFolder(String name) {
		
		this.name = name;
		this.folder = new Vector<AbstEntry>();
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch11Composite.v04.AbstEntry#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch11Composite.v04.AbstEntry#getSize()
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		
		int size = 0;
		
		for (AbstEntry entry : this.folder) {
			size += entry.getSize();
		}
		
		return size;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch11Composite.v04.AbstEntry#printList(java.lang.String)
	 */
	@Override
	protected void printList(String prefix) {
		// TODO Auto-generated method stub
		
		if (flag) System.out.printf("%s/%s\n", prefix, this);
		
		for (AbstEntry entry : this.folder) {
			entry.printList(prefix + "/" + this.name);
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public AbstEntry add(AbstEntry entry) {
		this.folder.add(entry);
		return this;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {

		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
