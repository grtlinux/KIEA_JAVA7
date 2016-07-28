/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.test.queue.v01;

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Queue.java
 *   -. Package    : tain.kr.com.test.queue.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 7. 29. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Queue {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Queue.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private final Vector<Object>   queue;
	private int                    count;

	public Queue() {
		
		this.queue = new Vector<Object> (5, 5);
		this.count = 0;
	}

	public synchronized int put(Object object) {
		
		try {
			if (object != null) {
				
				this.queue.addElement(object);
				this.count ++;
				
				notifyAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return this.count;
	}
	
	public synchronized Object get() throws Exception {
		
		Object object = null;
		
		try {
			for (int i=0; i < 1 && this.count <= 0; i++) {

				try {
					wait();
				} catch (InterruptedException e) {}
			}
			
			if (this.count <= 0) {
				return object;
			}
			
			object = this.queue.elementAt(0);
			this.queue.remove(0);
			this.count --;
		
		//} catch (InterruptedException e) {
		//	throw new InterruptedException("[HANDLE] interrupted Exception by Kang Seok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}
	
	public synchronized Object get(long timeout) throws Exception {
		
		Object object = null;
		
		try {
			for (int i=0; i < 10 && this.count <= 0; i++) {

				try {
					wait(timeout);
				} catch (InterruptedException e) {}
			}
			
			if (this.count <= 0) {
				return object;
			}
			
			object = this.queue.elementAt(0);
			this.queue.remove(0);
			this.count --;
		
		//} catch (InterruptedException e) {
		//	throw new InterruptedException("[HANDLE] interrupted Exception by Kang Seok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}
	
	public synchronized void clear() {
		
		this.queue.removeAllElements();
		this.count = 0;
	}
	
	public int getSize() {
		
		return this.count;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object().getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
