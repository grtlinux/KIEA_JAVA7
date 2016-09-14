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
package tain.kr.com.test.designpattern.entrance.ch13Visitor.v01;

import java.util.Vector;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Folder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch13Visitor.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Folder extends Entry {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final Vector<Entry> folder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Folder(String name) {
		this.name = name;
		this.folder = new Vector<Entry>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String getName() {
		return this.name;
	}
	
	@Override
	public int getSize() {
		int size = 0;
		
		for (Entry entry : folder) {
			size += entry.getSize();
		}
		
		return size;
	}
	
	public void accept(Visitor visitor) {
		visitor.visit(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Entry add(Entry entry) {
		this.folder.add(entry);
		return this;
	}
	
	public Vector<Entry> getVector() {
		return this.folder;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}