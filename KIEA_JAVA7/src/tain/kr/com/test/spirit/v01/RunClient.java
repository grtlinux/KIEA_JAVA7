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
package tain.kr.com.test.spirit.v01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RunClient.java
 *   -. Package    : tain.kr.com.test.spirit.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class RunClient implements Runnable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(RunClient.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String host = "127.0.0.1";
	private String port = "7412";
	
	private Socket socket = null;
	private DataInputStream dis = null;
	private DataOutputStream dos = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public RunClient() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		/*
		 * connection
		 */
		if (!connect())
			return;
		
		/*
		 * data
		 */
		String strSend = "Hello, world!!!!!";
		byte[] bytSend = strSend.getBytes(Charset.forName("euc-kr"));

		byte[] bytRecv = new byte[1024];
		String strRecv = null;
		int len = 0;
		
		if (flag) {
			try {
				/*
				 * send data to server
				 */
				this.dos.write(bytSend, 0, bytSend.length);
				if (flag) log.debug(String.format("SEND : %s\n", strSend));
				
				/*
				 * recv data from server
				 */
				len = this.dis.read(bytRecv);
				strRecv = new String(bytRecv, 0, len, Charset.forName("euc-kr"));
				if (flag) log.debug(String.format("RECV : %s\n", strRecv));
				
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				/*
				 * close
				 */
				try {
					this.dos.close();
					this.dis.close();
					this.socket.close();
				} catch (Exception e) {}
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean connect() {
	
		try {
			this.socket = new Socket(this.host, Integer.parseInt(this.port));
			this.dis = new DataInputStream(this.socket.getInputStream());
			this.dos = new DataOutputStream(this.socket.getOutputStream());
			
			if (flag) System.out.printf("%s %s Connection (%s:%s)\n"
					, Thread.currentThread().getThreadGroup().getName()
					, Thread.currentThread().getName()
					, this.host, this.port);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		
		return true;
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

		if (flag)
			new RunClient();

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
