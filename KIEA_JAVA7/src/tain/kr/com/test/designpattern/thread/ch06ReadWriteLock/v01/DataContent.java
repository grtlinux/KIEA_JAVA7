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
package tain.kr.com.test.designpattern.thread.ch06ReadWriteLock.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DataContent.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch06ReadWriteLock.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class DataContent extends AbstData {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DataContent.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final char[] buffer;
	private final FinlReadWriteLock lock = new FinlReadWriteLock();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public DataContent(int size) {
		
		this.buffer = new char[size];
		
		for (int i=0; i < buffer.length; i++) {
			buffer[i] = '*';
		}
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public char[] read() throws InterruptedException {
		
		lock.readLock();
		
		try {
			return doRead();
		} finally {
			lock.readUnlock();
		}
	}
	
	@Override
	public void write(char c) throws InterruptedException {
		
		lock.writeLock();
		
		try {
			doWrite(c);
		} finally {
			lock.writeUnlock();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private char[] doRead() {
		
		char[] newBuf = new char[this.buffer.length];
		for (int i=0; i < this.buffer.length; i++) {
			newBuf[i] = this.buffer[i];
		}
		
		slowly();
		
		return newBuf;
	}
	
	private void doWrite(char c) {
		
		for (int i=0; i < this.buffer.length; i++) {
			this.buffer[i] = c;
			
			slowly();
		}
	}
	
	private void slowly() {
		
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
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
