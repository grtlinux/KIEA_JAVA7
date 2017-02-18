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

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainServer.java
 *   -. Package    : tain.kr.com.test.spirit.v03.server
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainServer {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainServer.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String SERVER_PORT = "7412";
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainServer() {
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
			new MainServer();

		if (flag) {
			/*
			 * THREAD_SERVER_MAIN
			 *     THREAD_SERVER_0000
			 *         THREAD_SERVER_0000_CNTL
			 *         THREAD_SERVER_0000_SEND
			 *         THREAD_SERVER_0000_RECV
			 * 
			 */
			ThreadGroup threadGroup = new ThreadGroup("THREAD_SERVER_GROUP");
			
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt(SERVER_PORT));
			if (flag) log.debug(String.format("SERVER : listening by port %s [%s]", SERVER_PORT, serverSocket.toString()));
			
			for (int idxThr=0; ;idxThr = ++idxThr % 10000) {
				/*
				 * connection socket
				 */
				Socket socket = serverSocket.accept();
				if (flag) log.debug(String.format("SERVER : accept the connection(idxThr=%d)", idxThr));
				
				ThreadGroup subThreadGroup = new ThreadGroup(threadGroup, String.format("THREAD_SERVER_%04d", idxThr));
				
				/*
				 * thread controler
				 */
				Thread thread = new ThrControler(subThreadGroup, socket);
				thread.start();
				
				thread.join();
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
