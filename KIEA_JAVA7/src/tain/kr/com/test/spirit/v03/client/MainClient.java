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

import tain.kr.com.test.spirit.v03.data.AbstData;
import tain.kr.com.test.spirit.v03.data.DataContent;
import tain.kr.com.test.spirit.v03.queue.ImplQueue;
import tain.kr.com.test.spirit.v03.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainThrClient.java
 *   -. Package    : tain.kr.com.test.spirit.v03.client
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainClient {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainClient.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainClient() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
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

		if (flag)
			new MainClient();

		if (flag) {

			/*
			 * THREAD_CLIENT_MAIN
			 *     THREAD_0000
			 *         THREAD_0000_CNTL
			 *         THREAD_0000_SEND
			 *         THREAD_0000_RECV
			 * 
			 */
			ThreadGroup threadGroup = new ThreadGroup("THREAD_CLIENT_MAIN");
			
			for (int i=0; i < 1; i++) {
				
				ThreadGroup subThreadGroup = new ThreadGroup(threadGroup, String.format("THREAD_%04d", i));

				/*
				 * thread controller
				 */
				Thread thread = new ThrControler(subThreadGroup);
				
				((ThrControler) thread).setRecvQueue(new QueueContent());
				ImplQueue recvQueue = ((ThrControler) thread).getRecvQueue();
				ImplQueue sendQueue = ((ThrControler) thread).getSendQueue();
				
				/*
				 * run thread
				 */
				thread.start();
				
				/*
				 * do the job of processing
				 */
				final int CNT_IDX = 1;
				
				/*
				 * send data
				 */
				for (int idx=0; flag && idx < CNT_IDX; idx++) {
					String msgData = String.format("Hello, world....(%04d)", idx);
					
					AbstData content = new DataContent();
					((DataContent) content).setStrData(msgData);
					
					sendQueue.put(content);
					
					if (flag) System.out.printf("SEND: %s.\n", msgData);
				}
				
				/*
				 * recv data
				 */
				for (int idx=0; !flag && idx < CNT_IDX; idx++) {
					AbstData content = (AbstData) recvQueue.get();
					
					if (flag) System.out.printf("RECV: %s\n", ((DataContent) content).getStrData());
				}
				
				/*
				 * join thread
				 */
				thread.join();
				
				if (flag) System.out.println("END");
			}
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
