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

import java.net.Socket;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTcpClient.java
 *   -. Package    : tain.kr.com.test.network.v01.urgentData
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 27. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTcpClient {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTcpClient.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTcpClient() {
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
			new MainTcpClient();

		if (flag) {
			/*
			 * begin client  : related method -> void setOOBInline(boolean on), boolean getOOBInline()
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
			final Socket socket = new Socket("192.168.0.11", Integer.parseInt("12345"));
			
			if (flag) log.debug("CONNECTED..." + socket);
			
			Timer urgentDataTimer = new Timer(true);
			
			urgentDataTimer.scheduleAtFixedRate(new TimerTask() {
				int n = 0;
				
				@Override
				public void run() {
					try {
						if (flag) System.out.printf("SENDING URGENT DATA (%d)..\n", ++n);
						socket.sendUrgentData(1);
						if (flag) System.out.printf("SENT URGENT DATA...\n");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}, 1000, 2000);
			
			int b;
			while ((b = socket.getInputStream().read()) != -1) {
				System.out.println("READ byte: " + b);
			}
			
			if (flag) log.debug("CLOSING.....");

			urgentDataTimer.cancel();
			
			socket.close();
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
