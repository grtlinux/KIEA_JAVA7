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
package tain.kr.com.test.designpattern.entrance.ch12Decorator.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BorderSide.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch12Decorator.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BorderSide extends DisplayAbstBorder {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(BorderSide.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private final char borderChar;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BorderSide(AbstDisplay display, char borderChar) {
		
		super(display);
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.borderChar = borderChar;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int getColumns() {
		return 1 + super.getDisplay().getColumns() + 1;
	}
	
	@Override
	public int getRows() {
		return super.getDisplay().getRows();
	}
	
	@Override
	public String getRowText(int row) {
		return borderChar + super.getDisplay().getRowText(row) + borderChar;
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
