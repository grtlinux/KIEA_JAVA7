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

import tain.kr.com.test.spirit.v03.data.DataContent;
import tain.kr.com.test.spirit.v03.loop.LoopSleep;
import tain.kr.com.test.spirit.v03.queue.ImplQueue;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrSender.java
 *   -. Package    : tain.kr.com.test.spirit.v03.client
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

	private ThrControler thrControler;
	private ImplQueue queue;
	private DataContent content;
	
	private LoopSleep loopSleep;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrSender(ThreadGroup threadGroup, ThrControler thrControler) {

		super(threadGroup, String.format("%s_SEND", threadGroup.getName()));

		this.thrControler = thrControler;

		this.loopSleep = new LoopSleep();
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		while (!this.thrControler.isStop()) {
			/*
			 * sendQueue -> get -> dos
			 */
			try {
				this.content = (DataContent) this.queue.get(loopSleep.getMSec());
			} catch (Exception e) {
				e.printStackTrace();
			}

			if (this.content == null)
				continue;
			
			if (flag) log.debug(String.format("SEND(%3d): %s.\n", this.content.getSize(), this.content.getStrData()));
		}

		if (flag) System.out.printf("[%s] END", Thread.currentThread().getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setQueue(ImplQueue queue) {
		this.queue = queue;
	}
	
	public ImplQueue getQueue() {
		return this.queue;
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
