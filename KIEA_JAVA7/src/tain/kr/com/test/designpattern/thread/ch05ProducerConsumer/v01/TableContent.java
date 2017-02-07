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
package tain.kr.com.test.designpattern.thread.ch05ProducerConsumer.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TableContent.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch05ProducerConsumer.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class TableContent extends AbstTable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TableContent.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String[] buffer;    // circuler queue
	private int head;
	private int tail;
	private int count;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public TableContent(int size) {
		
		this.buffer = new String[size];
		this.head = 0;
		this.tail = 0;
		this.count = 0;
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.thread.ch05ProducerConsumer.v01.AbstTable#put(java.lang.String)
	 */
	@Override
	public synchronized void put(String cake) throws InterruptedException {
		// TODO Auto-generated method stub
		
		if (flag) System.out.printf("%s puts %s.\n", Thread.currentThread().getName(), cake);
		
		while (this.count >= this.buffer.length) {
			wait();
		}
		
		this.buffer[this.tail] = cake;
		this.tail = (this.tail + 1) % this.buffer.length;
		this.count ++;
		
		notifyAll();
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.thread.ch05ProducerConsumer.v01.AbstTable#take()
	 */
	@Override
	public synchronized String take() throws InterruptedException {
		// TODO Auto-generated method stub
		
		while (this.count <= 0) {
			wait();
		}
		
		String cake = this.buffer[this.head];
		this.head = (this.head + 1) % this.buffer.length;
		this.count --;
		
		notify();
		
		if (flag) System.out.printf("%s takes %s.\n", Thread.currentThread().getName(), cake);
		
		return cake;
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
