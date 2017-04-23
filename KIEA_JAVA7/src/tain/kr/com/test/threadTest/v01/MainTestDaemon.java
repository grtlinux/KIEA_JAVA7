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
package tain.kr.com.test.threadTest.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTestDaemon.java
 *   -. Package    : tain.kr.com.test.threadTest.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTestDaemon {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTestDaemon.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTestDaemon() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static Thread thrController;
	private static Thread thrDaemon;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static class ThrController extends Thread {
		
		public ThrController(String thrName) {
			super(thrName);
		}
		
		@Override
		public void run() {
			
			if (Thread.currentThread().isDaemon()) {
				System.out.println(Thread.currentThread().getName() + " daemon thread");
			} else {
				System.out.println(Thread.currentThread().getName() + " user thread");
			}

			for (int i=0; i < 5; i++) {
				
				try { Thread.sleep(5000); } catch (InterruptedException e) {}
				
				System.out.printf("\n[%s][thrDaemon.isAlive=%s]\n"
						, Thread.currentThread().getName(), MainTestDaemon.thrDaemon.isAlive());
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static class ThrDaemon implements Runnable {
	
		@Override
		public void run() {
			
			if (Thread.currentThread().isDaemon()) {
				System.out.println(Thread.currentThread().getName() + " daemon thread #");
			} else {
				System.out.println(Thread.currentThread().getName() + " user thread #");
			}
			
			while (true) {
				System.out.print(".");
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
			}
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainTestDaemon();

		if (flag) {
			/*
			 * begin
			 */
			if (flag) {
				/*
				 * run daemon thread
				 */
				MainTestDaemon.thrDaemon = new Thread(new ThrDaemon(), "THR_DAEMON");
				MainTestDaemon.thrDaemon.setDaemon(true);
				MainTestDaemon.thrDaemon.start();
			}
			
			if (flag) {
				/*
				 * run controller thread
				 */
				MainTestDaemon.thrController = new ThrController("THR_CONTROLLER");
				MainTestDaemon.thrController.start();
				MainTestDaemon.thrController.join();
			}
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
