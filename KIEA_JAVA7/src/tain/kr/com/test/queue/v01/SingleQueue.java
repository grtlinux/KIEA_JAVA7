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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SingleQueue.java
 *   -. Package    : tain.kr.com.test.queue.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 7. 29. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SingleQueue {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SingleQueue.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private Object   queue;

	public SingleQueue() {
		
		this.queue = null;
	}

	public int put(Object object) {
		
		// TODO 2016.07.28 : for ticket logic
		for (int i=0; i < Integer.MAX_VALUE && this.queue != null; i++) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {}
		}

		synchronized (this) {
			try {
				if (object != null) {
					
					this.queue = object;
					
					notifyAll();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return 1;
	}
	
	public synchronized Object get() throws Exception {
		
		Object object = null;
		
		try {
			for (int i=0; i < 1; i++) {

				try {
					wait();
				} catch (InterruptedException e) {}
			}
			
			object = this.queue;
			this.queue = null;
	
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
			for (int i=0; i < 100; i++) {

				try {
					wait(timeout);
				} catch (InterruptedException e) {}
				
				if (this.queue != null)
					break;
			}
			
			object = this.queue;
			this.queue = null;
		
		//} catch (InterruptedException e) {
		//	throw new InterruptedException("[HANDLE] interrupted Exception by Kang Seok");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return object;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final int CNT_THREAD = 3;
	
	private static SingleQueue que = new SingleQueue();
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			if (flag) {

				List<Thread> lstGetThr = new ArrayList<Thread>();
				
				for (int idx=1; idx <= CNT_THREAD; idx++) {
					
					Thread thr = new Thread("GET_THR_" + String.format("%03d", idx)) {
						
						Random rand = new Random(new Date().getTime());
						
						@Override
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
							//waitTime = 1000;
							
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

					@Override
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
						waitTime = 1000;
						
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
