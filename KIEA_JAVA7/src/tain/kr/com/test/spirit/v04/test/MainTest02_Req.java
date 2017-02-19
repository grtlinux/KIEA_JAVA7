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
package tain.kr.com.test.spirit.v04.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v04.controler.ThrControler;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest02_Req.java
 *   -. Package    : tain.kr.com.test.spirit.v04.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest02_Req {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest02_Req.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest02_Req() {
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
			new MainTest02_Req();

		if (flag) {
			/*
			 * ThreadGroup > ThrControler
			 */
			final ThreadGroup threadGroup0 = new ThreadGroup("TEST_0000");
			final ThrControler thrControler0 = new ThrControler(threadGroup0);
			
			final ThreadGroup threadGroup1 = new ThreadGroup("TEST_0001");
			final ThrControler thrControler1 = new ThrControler(threadGroup1);

			if (flag) {
				/*
				 * initialize
				 */
				if (flag) {
					/*
					 * set the recvQueue -> Joint logic
					 */
					thrControler0.setRecvQueue(thrControler1.getSendQueue());   // 0_R ( 1_S )
					thrControler1.setRecvQueue(thrControler0.getSendQueue());   // 1_R ( 0_S )
				}
				
				if (flag) {
					/*
					 * 0 : DataInputStream / DataOutputStream
					 */
					String strData = ""
							+ "ABCDEFGHIJ0000000000"
							+ "ABCDEFGHIJ0000000001"
							+ "ABCDEFGHIJ0000000002"
							+ "ABCDEFGHIJ0000000003"
							+ "ABCDEFGHIJ0000000004"
							+ "ABCDEFGHIJ0000000005"
							+ "ABCDEFGHIJ0000000006"
							+ "ABCDEFGHIJ0000000007"
							+ "ABCDEFGHIJ0000000008"
							+ "ABCDEFGHIJ0000000009"
							+ "ABCDEFGHIJ0000000010"
							+ "ABCDEFGHIJ0000000011"
							+ "ABCDEFGHIJ0000000012"
							+ "ABCDEFGHIJ0000000013"
							+ "ABCDEFGHIJ0000000014"
							+ "ABCDEFGHIJ0000000015"
							+ "ABCDEFGHIJ0000000016"
							+ "ABCDEFGHIJ0000000017"
							+ "ABCDEFGHIJ0000000018"
							+ "ABCDEFGHIJ0000000019"
							+ "ABCDEFGHIJ0000000020";
					byte[] bytData = strData.getBytes(Charset.forName("euc-kr"));
					
					DataInputStream dis0 = new DataInputStream(new ByteArrayInputStream(bytData));
					DataOutputStream dos0 = new DataOutputStream(new ByteArrayOutputStream(1024));
					
					thrControler0.setDataInputStream(dis0);
					thrControler0.setDataOutputStream(dos0);
				}
				
				if (flag) {
					/*
					 * 1 : DataInputStream / DataOutputStream
					 */
					String strData = ""
							+ "ABCDEFGHIJ0000777000"
							+ "ABCDEFGHIJ0000777001"
							+ "ABCDEFGHIJ0000777019"
							+ "ABCDEFGHIJ0000777020";
					byte[] bytData = strData.getBytes(Charset.forName("euc-kr"));
					
					DataInputStream dis1 = new DataInputStream(new ByteArrayInputStream(bytData));
					DataOutputStream dos1 = new DataOutputStream(new ByteArrayOutputStream(1024));

					thrControler1.setDataInputStream(dis1);
					thrControler1.setDataOutputStream(dos1);
				}
			}
			
			thrControler1.start();
			thrControler0.start();

			
			/*
			 * response thread
			 */
//			Thread resThread = new Thread() {
//				@Override
//				public void run() {
//					
//					ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
//					
//					byte[] bytRead = new byte[20];
//					int nRead = 0;
//					
//					try {
//						while ((nRead = bais.read(bytRead)) != -1) {
//							baos.write(bytRead, 0, nRead);
//							
//							System.out.println(new String(baos.toByteArray()));
//						}
//						
//						bais.close();
//						baos.close();
//						
//					} catch (Exception e) {
//						e.printStackTrace();
//					}
//				}
//			};
//			
//			resThread.start();
//			reqThread.start();
			
			thrControler1.join();
			thrControler0.join();
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
