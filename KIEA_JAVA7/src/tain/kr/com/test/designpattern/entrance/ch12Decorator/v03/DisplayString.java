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
package tain.kr.com.test.designpattern.entrance.ch12Decorator.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DisplayString.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch12Decorator.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class DisplayString extends AbstDisplay {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DisplayString.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String string;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public DisplayString(String string) {
		
		this.string = string;
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch12Decorator.v03.AbstDisplay#getColumns()
	 */
	@Override
	public int getColumns() {
		// TODO Auto-generated method stub
		return this.string.getBytes().length;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch12Decorator.v03.AbstDisplay#getRows()
	 */
	@Override
	public int getRows() {
		// TODO Auto-generated method stub
		return 1;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch12Decorator.v03.AbstDisplay#getRowTest(int)
	 */
	@Override
	public String getRowTest(int row) {
		// TODO Auto-generated method stub
		
		if (row == 0) {
			return this.string;
		}
		
		return null;
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
