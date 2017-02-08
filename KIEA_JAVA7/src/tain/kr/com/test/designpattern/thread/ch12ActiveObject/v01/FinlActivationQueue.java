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
package tain.kr.com.test.designpattern.thread.ch12ActiveObject.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FinlActivationQueue.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch12ActiveObject.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class FinlActivationQueue {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(FinlActivationQueue.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final int MAX_METHOD_REQUEST = 100;
	private final AbstRequest[] queue;
	private int tail;
	private int head;
	private int count;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public FinlActivationQueue() {
		
		this.queue = new AbstRequest[MAX_METHOD_REQUEST];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public synchronized void put(AbstRequest request) {
		
		while (this.count >= this.queue.length) {
			try {
				this.wait();
			} catch (InterruptedException e) {}
		}
		
		this.queue[this.tail] = request;
		this.tail = (this.tail + 1) % this.queue.length;
		this.count ++;
		
		this.notifyAll();
	}
	
	public synchronized AbstRequest take() {
		
		while (this.count <= 0) {
			try {
				this.wait();
			} catch (InterruptedException e) {}
		}
		
		AbstRequest request = this.queue[this.head];
		this.head = (this.head + 1) % this.queue.length;
		this.count --;
		
		this.notifyAll();
		
		return request;
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

		if (flag)
			new FinlActivationQueue();

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
