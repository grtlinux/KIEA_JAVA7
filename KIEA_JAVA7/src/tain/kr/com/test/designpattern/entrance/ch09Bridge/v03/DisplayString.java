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
package tain.kr.com.test.designpattern.entrance.ch09Bridge.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DisplayString.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch09Bridge.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 13. {time}
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
	 * @see tain.kr.com.test.designpattern.entrance.ch09Bridge.v03.AbstDisplay#open()
	 */
	@Override
	public void open() {
		// TODO Auto-generated method stub
		if (flag) System.out.print("<<");
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch09Bridge.v03.AbstDisplay#print()
	 */
	@Override
	public void print() {
		// TODO Auto-generated method stub
		if (flag) System.out.print(this);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch09Bridge.v03.AbstDisplay#close()
	 */
	@Override
	public void close() {
		// TODO Auto-generated method stub
		if (flag) System.out.println(">>");
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return String.format("this.string = '%s'", this.string);
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
