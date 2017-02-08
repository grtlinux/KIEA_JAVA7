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
package tain.kr.com.test.designpattern.javaThreads.ch05.v01.example4;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Thr1Calculator.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch05.v01.example4
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Thr1Calculator extends AbstCalculator implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Thr1Calculator.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Thr1Calculator() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for (int i=0; i < 30; i++) {
			Integer param = new Integer(i % 5);
			this.calculate(param);
		}
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.javaThreads.ch05.v01.example4.AbstCalculator#doLocalCalculate(java.lang.Object)
	 */
	@Override
	protected Object doLocalCalculate(Object param) {
		
		if (flag) System.out.println("Doing calculation of " + param + " in thread " + Thread.currentThread());
		
		return param;
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new Thr1Calculator();

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
