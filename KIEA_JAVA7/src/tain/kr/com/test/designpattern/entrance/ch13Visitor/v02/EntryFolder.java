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
package tain.kr.com.test.designpattern.entrance.ch13Visitor.v02;

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : EntryFolder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch13Visitor.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class EntryFolder extends AcceptorAbstEntry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(EntryFolder.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private final String name;
	private final Vector<AcceptorAbstEntry> folder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public EntryFolder(String name) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.name = name;
		this.folder = new Vector<AcceptorAbstEntry>();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getSize() {
		int size = 0;
		
		for (AcceptorAbstEntry entry : folder) {
			size += entry.getSize();
		}
		
		return size;
	}
	
	@Override
	public void accept(AbstVisitor visitor) {
		visitor.visit(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public AcceptorAbstEntry add(AcceptorAbstEntry entry) {
		this.folder.add(entry);
		return this;
	}
	
	public Vector<AcceptorAbstEntry> getVector() {
		return this.folder;
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
	///////////////////////////////////////////////////////////////////////////////////////////////

}
