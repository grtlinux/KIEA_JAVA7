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
package tain.kr.com.test.spirit.v03.server;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v03.server.ThrRecver;
import tain.kr.com.test.spirit.v03.server.ThrSender;
import tain.kr.com.test.spirit.v03.data.DataContent;
import tain.kr.com.test.spirit.v03.exception.ExpDefaultException;
import tain.kr.com.test.spirit.v03.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrControl.java
 *   -. Package    : tain.kr.com.test.spirit.v03.server
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrControler extends Thread implements ImplControler {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrControler.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String THR_NAME = "CNTL";
	
	private final ThreadGroup threadGroup;

	private final ThrSender thrSender;
	private final ThrRecver thrRecver;
	
	private QueueContent recvQueue;
	private QueueContent sendQueue;
	private QueueContent testQueue;
	
	private volatile boolean flagStop = false;
	

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

		this.testQueue = new QueueContent();

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
		if (flag) this.threadGroup.getParent().list();

		try {
			this.thrSender.join();
			this.thrRecver.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		if (flag) log.debug(String.format("[%s] END", Thread.currentThread().getName()));
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	protected boolean isFlagStop() {
		return this.flagStop;
	}

	protected QueueContent getRecvQueue() {
		return this.recvQueue;
	}

	protected QueueContent getSendQueue() {
		return this.sendQueue;
	}

	protected QueueContent getTestQueue() {
		return this.testQueue;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.client.ImplControler#sendContent(tain.kr.com.test.spirit.v03.data.DataContent)
	 */
	@Override
	public boolean sendContent(DataContent content) throws ExpDefaultException {

		if (content != null) {
			try {
				this.sendQueue.put(content);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				throw new ExpDefaultException();
			}
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.client.ImplControler#setRecvQueue(tain.kr.com.test.spirit.v03.queue.QueueContent)
	 */
	@Override
	public boolean setRecvQueue(QueueContent recvQueue) throws ExpDefaultException {

		if (recvQueue != null) {
			this.recvQueue = recvQueue;
			return true;
		}

		return false;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.client.ImplControler#stopThread()
	 */
	@Override
	public void stopThread() {
		this.flagStop = true;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.client.ImplControler#getContent()
	 */
	@Override
	public DataContent getContent() throws ExpDefaultException {

		DataContent content = null;

		try {
			content = (DataContent) this.recvQueue.get();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExpDefaultException();
		}

		return content;
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
