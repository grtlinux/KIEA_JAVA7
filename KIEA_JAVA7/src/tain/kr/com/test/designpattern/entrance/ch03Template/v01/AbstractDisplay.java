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
 *   -. FileName   : AbstractDisplay.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch03Template.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 21. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbstractDisplay {

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract void open();
	public abstract void print();
	public abstract void close();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public final void display() {
		open();
		
		for (int i=0; i < 5; i++) {
			print();
		}
		
		close();
	}
}