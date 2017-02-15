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
package tain.kr.com.test.threadGroup.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrThread.java
 *   -. Package    : tain.kr.com.test.threadGroup.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ThrThread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrThread.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrThread() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
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
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new ThrThread();

		if (flag) {
			
			ThreadGroup thrGroup = new ThreadGroup("THREAD_GROUP_00");
			
			new Thread(thrGroup, "THREAD_NAME_01") {
				@Override
				public void run() {
					
					String parentThreadGroupName = Thread.currentThread().getThreadGroup().getName();
					// String parentThreadGroupName = this.getThreadGroup().getName();
					
					try { Thread.sleep(2000); } catch (InterruptedException e) {}

					for (int i=0; i < 10; i++) {
						if (flag) System.out.printf("(%s) [%s] %d\n", parentThreadGroupName, this.getName(), i);
						
						try { Thread.sleep(1000); } catch (InterruptedException e) {}
					}
				}
			}.start();

			new Thread(thrGroup, "THREAD_NAME_02") {
				@Override
				public void run() {
					
					String parentThreadGroupName = Thread.currentThread().getThreadGroup().getName();
					// String parentThreadGroupName = this.getThreadGroup().getName();
					
					try { Thread.sleep(2000); } catch (InterruptedException e) {}

					for (int i=0; i < 10; i++) {
						if (flag) System.out.printf("(%s) [%s] %d\n", parentThreadGroupName, this.getName(), i);
						
						try { Thread.sleep(1000); } catch (InterruptedException e) {}
					}
				}
			}.start();

			new Thread(thrGroup, "THREAD_NAME_03") {
				@Override
				public void run() {
					
					String parentThreadGroupName = Thread.currentThread().getThreadGroup().getName();
					// String parentThreadGroupName = this.getThreadGroup().getName();
					
					try { Thread.sleep(2000); } catch (InterruptedException e) {}

					for (int i=0; i < 10; i++) {
						if (flag) System.out.printf("(%s) [%s] %d\n", parentThreadGroupName, this.getName(), i);
						
						try { Thread.sleep(1000); } catch (InterruptedException e) {}
					}
				}
			}.start();

			//
			//
			
			if (flag) System.out.printf("\t[%s] [%s]\n", thrGroup, thrGroup.getName());
			
			int sizeThread = thrGroup.activeCount();
			Thread[] listThread = new Thread[sizeThread];
			
			int count = thrGroup.enumerate(listThread);
			
			for (int i=0; i < count; i++) {
				if (flag) System.out.printf("\t[%s]\n", listThread[i].getName());
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
