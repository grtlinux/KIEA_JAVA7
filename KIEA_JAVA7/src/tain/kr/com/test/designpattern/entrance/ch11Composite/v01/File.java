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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : File.java
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
public class File extends Entry {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(File.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	private int size;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public File(String name, int size) {
		
		this.name = name;
		this.size = size;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getSize() {
		return this.size;
	}
	
	protected void printList(String prefix) {
		System.out.println(prefix + "/" + this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
