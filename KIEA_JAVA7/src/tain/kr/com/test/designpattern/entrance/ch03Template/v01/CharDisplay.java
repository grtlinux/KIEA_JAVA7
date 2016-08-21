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
package tain.kr.com.test.designpattern.entrance.ch03Template.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CharDisplay.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch03Template.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 21. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CharDisplay extends AbstractDisplay {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final char ch;
	
	public CharDisplay(char ch) {
		this.ch = ch;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void open() {
		System.out.print("<<");
	}
	
	@Override
	public void print() {
		System.out.print(this.ch);
	}
	
	@Override
	public void close() {
		System.out.println(">>");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
