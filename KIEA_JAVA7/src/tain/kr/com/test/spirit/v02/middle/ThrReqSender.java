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
package tain.kr.com.test.spirit.v02.middle;

import java.io.DataOutputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v02.data.DataContent;
import tain.kr.com.test.spirit.v02.loop.LoopSleep;
import tain.kr.com.test.spirit.v02.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrReqSender.java
 *   -. Package    : tain.kr.com.test.spirit.v02.middle
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrReqSender extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrReqSender.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Socket socket2;
	private final QueueContent reqQueue;
	private final DataOutputStream dos;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrReqSender(Socket socket2, QueueContent reqQueue) throws Exception {
		
		this.socket2 = socket2;
		this.reqQueue = reqQueue;
		this.dos = new DataOutputStream(this.socket2.getOutputStream());
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		DataContent content;
		byte[] bytData;
		
		LoopSleep loopSleep = new LoopSleep();
		
		while (true) {
			/*
			 * reqQueue -> dos -> socket2
			 */
			try {
				content = (DataContent) this.reqQueue.get();
				bytData = content.getBytData();
			} catch (Exception e) {
				e.printStackTrace();
				loopSleep.sleep2();
				continue;
			}
			
			try {
				this.dos.write(bytData, 0, content.getSize());
				loopSleep.reset();
			} catch (Exception e) {
				e.printStackTrace();
				loopSleep.sleep2();
			}
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
