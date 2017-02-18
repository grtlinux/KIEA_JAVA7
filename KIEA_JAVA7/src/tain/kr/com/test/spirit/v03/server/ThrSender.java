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

import tain.kr.com.test.spirit.v03.data.DataContent;
import tain.kr.com.test.spirit.v03.loop.LoopSleep;
import tain.kr.com.test.spirit.v03.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrSender.java
 *   -. Package    : tain.kr.com.test.spirit.v03.server
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrSender extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrSender.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String THR_NAME = "SEND";

	private ThrControler thrControler;
	private QueueContent sendQueue;
	private DataContent content;
	private LoopSleep loopSleep;

	private QueueContent testQueue;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrSender(ThreadGroup threadGroup, ThrControler thrControler) {

		super(threadGroup, String.format("%s_%s", threadGroup.getName(), THR_NAME));

		this.thrControler = thrControler;
		this.loopSleep = new LoopSleep();

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void run() {

		this.sendQueue = this.thrControler.getSendQueue();
		this.testQueue = this.thrControler.getTestQueue();

		if (flag) {
			/*
			 * TEST  using test queue
			 * sendQueue -> get -> testQueue
			 */
			while (!this.thrControler.isFlagStop()) {
				/*
				 * sendQueue -> get
				 */
				try {
					this.content = (DataContent) this.sendQueue.get(this.loopSleep.getMSec());
					if (this.content == null)
						continue;
				} catch (Exception e) {
					e.printStackTrace();
				}

				try {
					this.testQueue.put(this.content);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (flag) log.debug(String.format("SEND(%3d): %s.", this.content.getSize(), this.content.getStrData()));

				this.loopSleep.reset();
			}
		}

		if (!flag) {
			/*
			 * REAL using socket
			 */
			while (!this.thrControler.isFlagStop()) {
				/*
				 * sendQueue -> get -> dos
				 */
				try {
					this.content = (DataContent) this.sendQueue.get(this.loopSleep.getMSec());
					if (this.content == null)
						continue;
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (flag) log.debug(String.format("SEND(%3d): %s.", this.content.getSize(), this.content.getStrData()));
			}
		}

		if (flag) log.debug(String.format("[%s] END", Thread.currentThread().getName()));
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
