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

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainRunMiddle.java
 *   -. Package    : tain.kr.com.test.spirit.v02.middle
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainRunMiddle {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainRunMiddle.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainRunMiddle() {
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

	private static final String PORT = "20001";

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new MainRunMiddle();

		if (flag) {
			/*
			 * Runnable thread
			 */
			ThreadGroup threadGroup = new ThreadGroup("SERVER_GROUP");
			
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(PORT));
			if (flag) log.debug(String.format("SERVER : listening by port %s [%s]", PORT, serverSocket.toString()));
			
			for (int idxThr=0;; idxThr++) {
				if (idxThr > 10000000)
					idxThr = 0;
				
				Socket socket = serverSocket.accept();
				if (flag) log.debug(String.format("SERVER : accept the connection(idxThr=%d)", idxThr));
				
				Thread thread = new Thread(threadGroup, new RunControler(idxThr, socket), String.format("SERVER_RUNNABLE_%05d", idxThr));
				
				thread.start();
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