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
package tain.kr.com.test.designpattern.thread.ch08WorkerThread.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1Channel.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch08WorkerThread.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Dep1Channel {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Channel.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final int MAX_CONTENT = 100;
	private final AbstData[] dataQueue;
	private int tail;  // put index
	private int head;  // take index
	private int count; // data count
	
	private final Thr1Worker[] threadPool;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Dep1Channel(int threads) {
		
		this.dataQueue = new DataContent[MAX_CONTENT];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		
		this.threadPool = new Thr1Worker[threads];
		for (int i=0; i < this.threadPool.length; i++) {
			this.threadPool[i] = new Thr1Worker("Thr1Worker-" + i, this);
		}
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void startWorkers() {
		
		for (int i=0; i < this.threadPool.length; i++) {
			this.threadPool[i].start();
		}
	}
	
	public synchronized void put(AbstData data) {
		
		while (this.count >= this.dataQueue.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {
			}
		}
		
		this.dataQueue[this.tail] = data;
		this.tail = (this.tail + 1) % this.dataQueue.length;
		this.count ++;
		
		this.notifyAll();
	}
	
	public synchronized AbstData take() {
		
		while (this.count <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {}
		}
		
		AbstData data = this.dataQueue[this.head];
		this.head = (this.head + 1) % this.dataQueue.length;
		this.count --;
		
		this.notifyAll();
		
		return data;
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
