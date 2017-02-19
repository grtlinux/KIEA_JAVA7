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

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v04.data.DataContent;
import tain.kr.com.test.spirit.v04.exception.ExpException;
import tain.kr.com.test.spirit.v04.exception.ExpIOException;
import tain.kr.com.test.spirit.v04.exception.ExpNullPointerException;
import tain.kr.com.test.spirit.v04.loop.LoopSleep;
import tain.kr.com.test.spirit.v04.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrRecver.java
 *   -. Package    : tain.kr.com.test.spirit.v04.controler
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrRecver extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrRecver.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String THR_NAME = "RECV";
	
	@SuppressWarnings("unused")
	private final ThreadGroup threadGroup;
	
	private ThrControler thrControler;
	private QueueContent recvQueue;
	private LoopSleep loopSleep;
	private DataContent content;
	
	private DataInputStream dis;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrRecver(ThreadGroup threadGroup, ThrControler thrControler) {
		
		super(threadGroup, String.format("%s_%s", threadGroup.getName(), THR_NAME));
		
		this.threadGroup = threadGroup;
		this.thrControler = thrControler;

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		if (flag) {
			/*
			 * base initialize
			 */
			this.recvQueue = this.thrControler.getRecvQueue();
			this.loopSleep = new LoopSleep();
			this.content = new DataContent();
			this.dis = this.thrControler.getDataInputStream();
		}
		
		if (flag) {
			/*
			 * validation
			 */
			try {
				validateQueue();    // validate queue
				validateIO();       // validate IO
			} catch (ExpException e) {
				e.printStackTrace();
				return;
			}
		}
		
		if (flag) {
			/*
			 * loop job start
			 */
			while (!this.thrControler.isFlagStop()) {
				
				if (flag) {
					/*
					 * InputStream, DataInputStream
					 */
					try {
						this.content.readFromInputStream(this.dis);
					} catch (ExpIOException e) {
						e.printStackTrace();
						this.loopSleep.sleep();
						break;
					}
				}
				
				DataContent content = null;
				if (flag) {
					/*
					 * clone
					 */
					content = this.content.createClone();
				}
				
				if (flag) {
					/*
					 * recvQueue
					 */
					try {
						this.recvQueue.put(content);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
				
				if (flag) log.debug(String.format("RECV(%3d): %s.", this.content.getSize(), this.content.getStrData()));

				this.loopSleep.reset();
			}
		}
		
		if (flag) {
			/*
			 * end job
			 */
			if (flag) log.debug(String.format("[%s] END", Thread.currentThread().getName()));
			
			if (!flag) this.thrControler.stopThread();
		}
	}
	
	private void validateQueue() throws ExpException {
		/*
		 * validate queue
		 */
		if (this.recvQueue == null) {
			throw new ExpNullPointerException("null point queue : recvQueue.");
		}
	}
	
	private void validateIO() throws ExpException {
		/*
		 * validate IO
		 */
		if (this.dis == null) {
			throw new ExpNullPointerException("null point DataInputStream.");
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
