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

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
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
	
	private static final int CNT_THREAD = 3;
	
	private static Queue que = new Queue();
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			if (flag) {

				List<Thread> lstGetThr = new ArrayList<Thread>();
				
				for (int idx=1; idx <= CNT_THREAD; idx++) {
					
					Thread thr = new Thread("GET_THR_" + String.format("%03d", idx)) {
						
						Random rand = new Random(new Date().getTime());
						
						public void run() {
							String name = this.getName();
							if (flag) log.debug("[" + name + "]: START");
							
							try {
								for (int i=0; i<10000; i++) {
									
									// GET
									Integer val = (Integer) que.get();
									if (val != null) {
										// print value
										if (flag) log.debug("\t\t\t\t\t[" + name + "]: get () = " + val.intValue());
									}

									waitLoop();
								}
							} catch (Exception e) {
								e.printStackTrace();
							} finally {
							}
						}
						
						private void waitLoop() throws Exception {
							
							long waitTime = (3 + rand.nextInt(5)) * 1000;
							
							try { Thread.sleep(waitTime); } catch (InterruptedException e) {}
						}
					};
					
					thr.start();
					
					lstGetThr.add(thr);
				}
			}

			if (flag) {

				Thread putThr = new Thread("PUT_THR") {

					Random rand = new Random(new Date().getTime());

					public void run() {
						String name = this.getName();
						if (flag) log.debug("[" + name + "]: START");

						try {
							for (int i=0; i < 50; i++) {
								
								// PUT
								int size = que.put(Integer.valueOf(i));
								
								if (flag) log.debug("[" + name + "]: put (" + i + "), size = " + size);
								
								
								waitLoop();
							}
						} catch (Exception e) {
							e.printStackTrace();
						} finally {
						}
					}

					private void waitLoop() throws Exception {
						
						long waitTime = (1 + rand.nextInt(1)) * 1000;
						
						try { Thread.sleep(waitTime); } catch (InterruptedException e) {}
					}
				};
				
				putThr.start();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
