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
package tain.kr.com.test.designpattern.thread.ch10TwoPhaseTermination.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Thr1Countup.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch10TwoPhaseTermination.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Thr1Countup extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Thr1Countup.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private long counter = 0;
	
	private volatile boolean shutdownRequested = false;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Thr1Countup() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void shutdownRequest() {
		this.shutdownRequested = true;
		interrupt();
	}
	
	public boolean isShutdownRequested() {
		return this.shutdownRequested;
	}
	
	@Override
	public void run() {
		
		try {
			while (!this.shutdownRequested) {
				doWork();
			}
		} catch (InterruptedException e) {
		} finally {
			doShutdown();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void doWork() throws InterruptedException {
		
		this.counter++;
		if (flag) System.out.println("doWork: counter = " + this.counter);
		Thread.sleep(500);
	}
	
	private void doShutdown() {
		
		if (flag) System.out.println("doShutdown: counter = " + this.counter);
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
			new Thr1Countup();

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
