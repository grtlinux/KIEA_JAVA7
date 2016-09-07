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
package tain.kr.com.test.designpattern.entrance.ch09Bridge.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StringDisplayImpl.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch09Bridge.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StringDisplayImpl extends DisplayImpl {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String string;
	private final int width;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public StringDisplayImpl(String string) {
		this.string = string;
		this.width = this.string.getBytes().length;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void rawOpen() {
		printLine();
	}
	
	public void rawPrint() {
		System.out.println("|" + this.string + "|");
	}
	
	public void rawClose() {
		printLine();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void printLine() {
		System.out.print("+");
		for (int i=0; i < this.width; i++) {
			System.out.print("-");
		}
		System.out.println("+");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
