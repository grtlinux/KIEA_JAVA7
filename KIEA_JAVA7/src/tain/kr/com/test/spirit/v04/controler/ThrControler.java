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
package tain.kr.com.test.spirit.v04.controler;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v04.exception.ExpException;
import tain.kr.com.test.spirit.v04.exception.ExpNullPointException;
import tain.kr.com.test.spirit.v04.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrIOControler.java
 *   -. Package    : tain.kr.com.test.spirit.v04.controler
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrControler extends Thread implements ImpControler {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrControler.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String THR_NAME = "CNTL";
	
	private final ThreadGroup threadGroup;
	
	private final ThrSender thrSender;
	private final ThrRecver thrRecver;

	private QueueContent sendQueue;
	private QueueContent recvQueue;
	
	private volatile boolean flagStop = false;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrControler(ThreadGroup threadGroup) {
		
		super(threadGroup, String.format("%s_%s", threadGroup.getName(), THR_NAME));
		
		this.threadGroup = threadGroup;
		
		this.thrSender = new ThrSender(this.threadGroup, this);
		this.thrRecver = new ThrRecver(this.threadGroup, this);
		
		this.sendQueue = new QueueContent();
		this.recvQueue = null;
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		/*
		 * validation
		 */
		try {
			validateThread();   // validate thread
			validateQueue();    // validate queue
		} catch (ExpException e) {
			e.printStackTrace();
			return;
		}
		
		/*
		 * start thread
		 */
		this.thrSender.start();
		this.thrRecver.start();
		
		if (flag) this.threadGroup.getParent().list();
		
		try {
			this.thrSender.join();
			this.thrRecver.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (flag) log.debug(String.format("[%s] END.", Thread.currentThread().getName()));
	}
	
	private void validateThread() throws ExpException {
		/*
		 * validate thread
		 */
		if (this.thrSender == null) {
			throw new ExpNullPointException("null point thread : ThrSender.");
		} else if (this.thrRecver == null) {
			throw new ExpNullPointException("null point thread : ThrRecver.");
		}
	}
	
	private void validateQueue() throws ExpException {
		/*
		 * validate queue
		 */
		if (this.sendQueue == null) {
			throw new ExpNullPointException("null point queue : sendQueue.");
		} else if (this.recvQueue == null) {
			throw new ExpNullPointException("null point queue : recvQueue.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected boolean isFlagStop() {
		return this.flagStop;
	}
	
	public void stopThread() {
		this.flagStop = true;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean setRecvQueue(QueueContent recvQueue) {

		if (recvQueue != null) {
			this.recvQueue = recvQueue;
			return true;
		}

		return false;
	}

	protected QueueContent getRecvQueue() {
		return this.recvQueue;
	}

	protected QueueContent getSendQueue() {
		return this.sendQueue;
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
