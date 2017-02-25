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
package tain.kr.com.test.network.v01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThrClient.java
 *   -. Package    : tain.kr.com.test.network.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 25. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ThrClient extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThrClient.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final String TYP_CHARSET = "euc-kr";

	private static final String CONNECT_HOST = "127.0.0.1";
	private static final String CONNECT_PORT = "20025";
	
	private final Socket socket;
	private final DataInputStream dis;
	private final DataOutputStream dos;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ThrClient() throws Exception {
		
		super("THREAD_CLIENT");
		
		this.socket = new Socket(CONNECT_HOST, Integer.parseInt(CONNECT_PORT));
		if (this.socket == null) {
			throw new IOException("socket is null pointer...(tain.co.kr)");
		}
		setSocketOptions();
		
		this.dis = new DataInputStream(this.socket.getInputStream());
		this.dos = new DataOutputStream(this.socket.getOutputStream());
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	private void setSocketOptions() throws Exception {
		
		if (flag) {
			/*
			 * print current socket options
			 */
			if (flag) System.out.printf("\tBefore) getTcpNoDelay()        = %s\n", this.socket.getTcpNoDelay());
			if (flag) System.out.printf("\tBefore) getSoTimeout()         = %d\n", this.socket.getSoTimeout());
			if (flag) System.out.printf("\tBefore) getSoLinger()          = %d\n", this.socket.getSoLinger());
			if (flag) System.out.printf("\tBefore) getReceiveBufferSize() = %d\n", this.socket.getReceiveBufferSize());
			if (flag) System.out.printf("\tBefore) getSendBufferSize()    = %d\n", this.socket.getSendBufferSize());
			if (flag) System.out.printf("\tBefore) getKeepAlive()         = %s\n", this.socket.getKeepAlive());
			if (flag) System.out.printf("\tBefore) getReuseAddress()      = %s\n", this.socket.getReuseAddress());
		}
		
		if (flag) {
			/*
			 * change socket options
			 */
			if (flag && this.socket.getTcpNoDelay() == false) {        // TCP_NODELAY
				this.socket.setTcpNoDelay(true);
			}
			
			if (flag && this.socket.getSoTimeout() == 0) {              // SO_TIMEOUT
				// this.socket.setSoTimeout(0);  // 0 -> timeout of infinity
				this.socket.setSoTimeout(2 * 1000);
			}
			
			if (flag && this.socket.getSoLinger() == -1) {              // SO_LINGER
				this.socket.setSoLinger(true, 0);
			}
			
			if (flag && this.socket.getReceiveBufferSize() < 10240) {   // SO_RCVBUF
				this.socket.setReceiveBufferSize(10240);
			}
			
			if (flag && this.socket.getSendBufferSize() < 10240) {      // SO_SNDBUF
				this.socket.setSendBufferSize(10240);
			}
			
			if (flag && this.socket.getKeepAlive() == false) {         // SO_KEEPALIVE
				this.socket.setKeepAlive(true);
			}
			
			if (flag && this.socket.getReuseAddress() == false) {      // SO_REUSEADDR
				this.socket.setReuseAddress(true);
			}
		}
		
		if (flag) {
			/*
			 * print socket options changed
			 */
			if (flag) System.out.printf("\tAfter) getTcpNoDelay()        = %s\n", this.socket.getTcpNoDelay());
			if (flag) System.out.printf("\tAfter) getSoTimeout()         = %d\n", this.socket.getSoTimeout());
			if (flag) System.out.printf("\tAfter) getSoLinger()          = %d\n", this.socket.getSoLinger());
			if (flag) System.out.printf("\tAfter) getReceiveBufferSize() = %d\n", this.socket.getReceiveBufferSize());
			if (flag) System.out.printf("\tAfter) getSendBufferSize()    = %d\n", this.socket.getSendBufferSize());
			if (flag) System.out.printf("\tAfter) getKeepAlive()         = %s\n", this.socket.getKeepAlive());
			if (flag) System.out.printf("\tAfter) getReuseAddress()      = %s\n", this.socket.getReuseAddress());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String strSend;
	private byte[] bytSend;
	private int nSend;
	
	private static final int SIZ_RECV = 1024;
	
	private String strRecv;
	private byte[] bytRecv;
	private int nRecv;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		if (flag) {
			/*
			 * start thread process
			 */
			this.bytRecv = new byte[SIZ_RECV];

			while (true) {
				if (flag) {
					/*
					 * recv
					 */
					try {
						this.nRecv = this.dis.read(this.bytRecv, 0, SIZ_RECV);
						if (this.nRecv == 0) {
							/*
							 * read data of 0 size
							 */
							if (flag) System.out.printf("%s [STATUS] read data of 0 size..\n", Thread.currentThread().getName());
						} else if (this.nRecv < 0) {
							/*
							 * EOF
							 */
							if (flag) System.out.printf("%s [STATUS] read data of EOF...\n", Thread.currentThread().getName());
							if (flag) printInfo();
							break;
						}
					} catch (SocketTimeoutException e) {
						/*
						 * SocketTimeoutException
						 */
						if (flag) System.out.printf("%s [STATUS] SocketTimeoutException...\n", Thread.currentThread().getName());
						if (flag) printInfo();
						continue;
					} catch (Exception e) {
						/*
						 * Exception
						 */
						if (flag) e.printStackTrace();
						if (flag) printInfo();
						break;
					}
					
					this.strRecv = new String(this.bytRecv, 0, this.nRecv, Charset.forName(TYP_CHARSET));
					
					if (flag) System.out.printf("%s [STATUS] RECV [%d:%s]\n"
							, Thread.currentThread().getName(), this.nRecv, this.strRecv);
				}
				
				if (flag) {
					/*
					 * send
					 */
					this.strSend = "OK!! How are you doing these days?~~";
					this.bytSend = this.strSend.getBytes(Charset.forName(TYP_CHARSET));
					this.nSend = this.bytSend.length;
					
					try {
						this.dos.write(this.bytSend, 0, this.nSend);
					} catch (IOException e) {
						e.printStackTrace();
						break;
					}
					
					if (flag) System.out.printf("%s [STATUS] SEND [%d:%s]\n"
							, Thread.currentThread().getName(), this.nSend, this.strSend);
				}
				
				if (flag) {
					/*
					 * sleep
					 */
					try { Thread.sleep(1 * 1000); } catch (InterruptedException e) {}
				}
			}
			
			if (flag) {
				/*
				 * close
				 */
				if (this.dos != null) try { this.dos.close(); } catch (IOException e) {}
				if (this.dis != null) try { this.dis.close(); } catch (IOException e) {}
				if (this.socket != null) try { this.socket.close(); } catch (IOException e) {}
			}
		}
	}
	
	private void printInfo() {
		/*
		 * print connection informations
		 */
		if (flag) {
			if (flag) System.out.printf("isBound()          = %s\n", this.socket.isBound());
			if (flag) System.out.printf("isClosed()         = %s\n", this.socket.isClosed());
			if (flag) System.out.printf("isConnected()      = %s\n", this.socket.isConnected());
			if (flag) System.out.printf("isInputShutdown()  = %s\n", this.socket.isInputShutdown());
			if (flag) System.out.printf("isOutputShutdown() = %s\n", this.socket.isOutputShutdown());
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new ThrClient();

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
