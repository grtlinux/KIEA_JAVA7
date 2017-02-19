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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v04.exception.ExpException;
import tain.kr.com.test.spirit.v04.exception.ExpIOException;
import tain.kr.com.test.spirit.v04.exception.ExpNullPointerException;
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
	
	private ThrSender thrSender = null;
	private ThrRecver thrRecver = null;

	private QueueContent sendQueue = null;
	private QueueContent recvQueue = null;
	
	private volatile boolean flagStop = false;
	
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
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
		
		if (flag) {
			/*
			 * validation
			 */
			try {
				validateThread();   // validate thread
				validateQueue();    // validate queue
				validateIO();       // validate IO
			} catch (ExpException e) {
				e.printStackTrace();
				return;
			}
		}
		
		if (flag) {
			/*
			 * start thread
			 */
			this.thrSender.start();
			this.thrRecver.start();
		}
		
		if (flag) this.threadGroup.getParent().list();
		
		if (flag) {
			/*
			 * thread join
			 */
			try {
				this.thrSender.join();
				this.thrRecver.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		if (flag) log.debug(String.format("[%s] END.", Thread.currentThread().getName()));
	}
	
	private void validateThread() throws ExpException {
		/*
		 * validate thread
		 */
		if (this.thrSender == null) {
			throw new ExpNullPointerException("null point thread : ThrSender.");
		} else if (this.thrRecver == null) {
			throw new ExpNullPointerException("null point thread : ThrRecver.");
		}
	}
	
	private void validateQueue() throws ExpException {
		/*
		 * validate queue
		 */
		if (this.sendQueue == null) {
			throw new ExpNullPointerException("null point queue : sendQueue.");
		} else if (this.recvQueue == null) {
			throw new ExpNullPointerException("null point queue : recvQueue.");
		}
	}
	
	private void validateIO() throws ExpException {
		/*
		 * validate queue
		 */
		if (this.dis == null) {
			throw new ExpNullPointerException("null point DataInputStream.");
		} else if (this.dos == null) {
			throw new ExpNullPointerException("null point DataOutputStream.");
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

	public QueueContent getRecvQueue() {
		return this.recvQueue;
	}

	public QueueContent getSendQueue() {
		return this.sendQueue;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setDataInputStream(InputStream is) {
		this.dis = (DataInputStream) is;
	}
	
	public void setDataOutputStream(OutputStream os) {
		this.dos = (DataOutputStream) os;
	}
	
	public DataInputStream getDataInputStream() {
		return this.dis;
	}
	
	public DataOutputStream getDataOutputStream() {
		return this.dos;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setSocket(Socket socket) throws ExpIOException {
		this.socket = socket;
		
		try {
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
		} catch (IOException e) {
			//
			e.printStackTrace();
			throw new ExpIOException();
		}
	}
	
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
