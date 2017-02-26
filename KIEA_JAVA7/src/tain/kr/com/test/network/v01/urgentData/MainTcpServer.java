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
package tain.kr.com.test.network.v01.urgentData;

import java.net.ServerSocket;
import java.net.Socket;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTcpServer.java
 *   -. Package    : tain.kr.com.test.network.v01.urgentData
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 27. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainTcpServer {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTcpServer.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTcpServer() {
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
			new MainTcpServer();

		if (flag) {
			/*
			 * begin server  : related method -> void setOOBInline(boolean on), boolean getOOBInline()
			 * 
			 *     --> = from TCP client to TCP server
			 *     <-- = from TCP server to TCP client
			 *     
			 *     -->  [PSH, ACK, URG] (Seq=1, Ack=1)
			 *     <--  [ACK] (Seq=1, Ack=2)
			 *     
			 *     -->  [PSH, ACK, URG] (Seq=2, Ack=1)
			 *     <--  [ACK] (Seq=1, Ack=3)
			 *     
			 *     ...
			 *     
			 *     -->  [PSH, ACK, URG] (Seq=17, Ack=1)
			 *     <--  [RST, ACK] (Seq=1, Ack=18)
			 *     
			 *     [ERROR]
			 */
			ServerSocket serverSocket = new ServerSocket(Integer.parseInt("12345"));
			Socket socket = serverSocket.accept();
			
			if (flag) log.debug("CONNECTED..." + socket);
			
			int b;
			while ((b = socket.getInputStream().read()) != -1) {
				if (flag) log.debug("READ byte: " + b);
			}
			
			if (flag) log.debug("CLOSING.....");
			
			socket.close();
			serverSocket.close();
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
