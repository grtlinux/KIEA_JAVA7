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
package tain.kr.com.test.designpattern.thread.ch00Introduction.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Thr1Runnable.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch00Introduction.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Thr1Runnable implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Thr1Runnable.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Thr1Runnable(String name) {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.name = name;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void run() {
		
		System.out.println("Runnable-2 start thread...[name=" + this.name + "]");
		try { Thread.sleep(1000); } catch (InterruptedException e) {}
		System.out.println("Runnable-2 end   thread...[name=" + this.name + "]");
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
			/*
			 * Runnable Thread
			 */
			new Thread(new Thr1Runnable("RUNNABLE")).start();
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