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

import java.io.DataInputStream;
import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v02.data.DataContent;
import tain.kr.com.test.spirit.v02.loop.LoopSleep;
import tain.kr.com.test.spirit.v02.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrReqRecver.java
 *   -. Package    : tain.kr.com.test.spirit.v02.middle
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrReqRecver extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrReqRecver.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Socket socket1;
	private final QueueContent reqQueue;
	private final DataInputStream dis;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrReqRecver(Socket socket1, QueueContent reqQueue) throws Exception {
		
		this.socket1 = socket1;
		this.reqQueue = reqQueue;
		this.dis = new DataInputStream(this.socket1.getInputStream());
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		DataContent content = new DataContent();
		byte[] bytData = content.getBytData();
		int len;
		
		LoopSleep loopSleep = new LoopSleep();
		
		while (true) {
			/*
			 * socket1 -> dis -> reqQueue
			 */
			try {
				len = 0;
				len = this.dis.read(bytData);
			} catch (Exception e) {
				e.printStackTrace();
				len = -1;
			}
			
			/*
			 * sleep
			 */
			if (len <= 0) {
				loopSleep.sleep2();
			} else {
				
				try {
					content.setSize(len);
					this.reqQueue.put(content);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				loopSleep.reset();
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
