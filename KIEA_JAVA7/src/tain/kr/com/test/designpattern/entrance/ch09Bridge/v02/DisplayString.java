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
package tain.kr.com.test.designpattern.entrance.ch09Bridge.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DisplayString.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch09Bridge.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DisplayString extends AbstDisplay {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DisplayString.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String string;
	private final int width;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public DisplayString(String string) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.string = string;
		this.width = this.string.getBytes().length;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void rawOpen() {
		printLine();
	}
	
	@Override
	public void rawPrint() {
		System.out.println("|" + this.string + "|");
	}
	
	@Override
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
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
