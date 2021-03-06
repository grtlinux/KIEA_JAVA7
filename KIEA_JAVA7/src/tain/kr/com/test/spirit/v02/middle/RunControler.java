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

import java.net.Socket;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v02.queue.QueueContent;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RunControl.java
 *   -. Package    : tain.kr.com.test.spirit.v02.middle
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class RunControler implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(RunControler.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String host = "127.0.0.1";
	private String port = "20002";

	@SuppressWarnings("unused")
	private final int idxThr;
	private final Socket socket1;
	private final Socket socket2;
	
	private final QueueContent reqQueue;
	private final QueueContent resQueue;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public RunControler(int idxThr, Socket socket1) throws Exception {
		
		this.idxThr = idxThr;
		this.socket1 = socket1;
		
		this.socket2 = new Socket(this.host, Integer.parseInt(this.port)); // connection

		this.reqQueue = new QueueContent();
		this.resQueue = new QueueContent();
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		try {
			if (flag) {
				/*
				 * ThrResSender
				 */
				new ThrResSender(this.socket1, this.resQueue).start();
			}

			if (flag) {
				/*
				 * ThrResRecver
				 */
				new ThrResRecver(this.socket2, this.resQueue).start();
			}
			
			if (flag) {
				/*
				 * ThrReqSender
				 */
				new ThrReqSender(this.socket2, this.reqQueue).start();
			}

			if (flag) {
				/*
				 * ThrReqRecver
				 */
				new ThrReqRecver(this.socket1, this.reqQueue).start();
			}
		} catch (Exception e) {
			e.printStackTrace();
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
