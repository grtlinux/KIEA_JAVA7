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
package tain.kr.com.test.spirit.v03.client;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v03.queue.ImplQueue;
import tain.kr.com.test.spirit.v03.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrClient.java
 *   -. Package    : tain.kr.com.test.spirit.v03.client
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrControler extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrControler.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final ThreadGroup threadGroup;

	private final Thread thrSender;
	private final Thread thrRecver;
	
	private ImplQueue recvQueue;
	private ImplQueue sendQueue;
	
	private volatile boolean flagStop = false;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrControler(ThreadGroup threadGroup) {
		
		super(threadGroup, String.format("%s_CNTL", threadGroup.getName()));
		
		this.threadGroup = threadGroup;
		
		this.thrSender = new ThrSender(this.threadGroup, this);
		this.thrRecver = new ThrRecver(this.threadGroup, this);
		
		setSendQueue();
		
		//this.threadGroup.getParent().list();

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		this.thrSender.start();
		this.thrRecver.start();
		
		// try { Thread.sleep(10 * 1000); } catch (InterruptedException e) {}
		
		this.threadGroup.getParent().list();
		
		try {
			this.thrSender.join();
			this.thrRecver.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (flag) System.out.printf("[%s] END", Thread.currentThread().getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setRecvQueue(ImplQueue queue) {
		this.recvQueue = queue;
		((ThrRecver) this.thrRecver).setQueue(queue);
	}

	public void setRecvQueue() {
		setRecvQueue(new QueueContent());
	}
	
	public void setSendQueue(ImplQueue queue) {
		this.sendQueue = queue;
		((ThrSender) this.thrSender).setQueue(queue);
	}
	
	public void setSendQueue() {
		setSendQueue(new QueueContent());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ImplQueue getRecvQueue() {
		return this.recvQueue;
	}
	
	public ImplQueue getSendQueue() {
		return this.sendQueue;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean isStop() {
		return this.flagStop;
	}
	
	public boolean setStop() {
		this.flagStop = true;
		return this.flagStop;
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
