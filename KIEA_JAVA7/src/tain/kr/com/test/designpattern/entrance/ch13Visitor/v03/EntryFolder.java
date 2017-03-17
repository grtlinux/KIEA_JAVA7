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
package tain.kr.com.test.designpattern.entrance.ch13Visitor.v03;

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryFolder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch13Visitor.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class EntryFolder extends AbstAcceptorEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryFolder.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final Vector<AbstAcceptorEntry> entries;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public EntryFolder(String name) {
		
		this.name = name;
		this.entries = new Vector<AbstAcceptorEntry>();
		
		if (!flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch13Visitor.v03.ImplAcceptor#accept(tain.kr.com.test.designpattern.entrance.ch13Visitor.v03.AbstVisitor)
	 */
	@Override
	public void accept(AbstVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visit(this);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch13Visitor.v03.AbstAcceptorEntry#getName()
	 */
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch13Visitor.v03.AbstAcceptorEntry#getSize()
	 */
	@Override
	public int getSize() {
		// TODO Auto-generated method stub
		
		int size = 0;
		
		for (AbstAcceptorEntry entry : entries) {
			size += entry.getSize();
		}
		
		return size;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public AbstAcceptorEntry add(AbstAcceptorEntry entry) {
		this.entries.add(entry);
		return this;
	}
	
	public Vector<AbstAcceptorEntry> getEntries() {
		return this.entries;
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
