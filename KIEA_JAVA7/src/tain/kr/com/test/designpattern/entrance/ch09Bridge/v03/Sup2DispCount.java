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
 *   -. FileName   : Sup2DispCount.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch09Bridge.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 13. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Sup2DispCount extends Sup1Disp {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Sup2DispCount.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Sup2DispCount(AbstDisplay display) {
		
		super(display);
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void displayCount(int count) {
		
		for (int i=0; i < count; i++) {
			display();
		}
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
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {
			Sup2DispCount display = new Sup2DispCount(new DisplayString("Hello, world..."));
			display.displayCount(10);
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
