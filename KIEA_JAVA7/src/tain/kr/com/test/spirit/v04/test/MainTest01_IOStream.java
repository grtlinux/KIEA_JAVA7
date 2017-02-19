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
import java.io.DataOutputStream;
import java.io.PrintWriter;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestIOStream.java
 *   -. Package    : tain.kr.com.test.spirit.v04.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest01_IOStream {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest01_IOStream.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest01_IOStream() {
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
			new MainTest01_IOStream();

		if (!flag) {
			/*
			 * ByteArrayInputStream Thread
			 */
			String strData = "ABCDEFGHIJ0000000000"
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
			
			ByteArrayInputStream is = new ByteArrayInputStream(bytData);
			PrintWriter pw = new PrintWriter(System.out);
			
			byte[] bytRead = new byte[20];
			int nRead = 0;
			String strRead;
			
			while (true) {
				nRead = is.read(bytRead);
				if (nRead <= 0)
					break;
				
				strRead = new String(bytRead, 0, nRead, Charset.forName("euc-kr"));
				
				if (flag) pw.printf("> [%s]\n", strRead);
				//if (flag) System.out.printf("<[%s]\n", strRead);
			}
			
			is.close();
			pw.close();
		}

		if (!flag) {
			/*
			 * ByteArrayOutputStream Thread
			 */
			ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
			DataOutputStream dos = new DataOutputStream(bos);
			
			for (int i=0; i < 2; i++)
				dos.writeDouble(Math.random());
				
			byte[] ba = bos.toByteArray();
			
			System.out.println();
			
			for (int i=0; i < ba.length; i++) {
				System.out.print(" " + (ba[i] & 0xff));
			}
		}
		
		if (!flag) {
			byte[] arr = { (byte)'j', (byte)'a', (byte)'v', (byte)'a', (byte)'O', (byte)'K' };
			
			ByteArrayInputStream bais = new ByteArrayInputStream(arr);
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			
			int n;
			while ((n = bais.read()) != -1) {
				baos.write(n);
			}
			
			System.out.println(baos.toString());
			
			bais.close();
			baos.close();
		}
		
		if (flag) {
			/*
			 * request thread
			 */
			Thread thread = new Thread() {
				@Override
				public void run() {
					
					String strData = "ABCDEFGHIJ0000000000"
							+ "ABCDEFGHIJ0000000001"
							+ "ABCDEFGHIJ0000000002"
							+ "ABCDEFGHIJ0000000003"
							+ "ABCDEFGHIJ0000000004"
							+ "ABCDEFGHIJ0000000005"
//							+ "ABCDEFGHIJ0000000006"
//							+ "ABCDEFGHIJ0000000007"
//							+ "ABCDEFGHIJ0000000008"
//							+ "ABCDEFGHIJ0000000009"
//							+ "ABCDEFGHIJ0000000010"
//							+ "ABCDEFGHIJ0000000011"
//							+ "ABCDEFGHIJ0000000012"
//							+ "ABCDEFGHIJ0000000013"
//							+ "ABCDEFGHIJ0000000014"
//							+ "ABCDEFGHIJ0000000015"
//							+ "ABCDEFGHIJ0000000016"
//							+ "ABCDEFGHIJ0000000017"
//							+ "ABCDEFGHIJ0000000018"
//							+ "ABCDEFGHIJ0000000019"
							+ "ABCDEFGHIJ0000000020";
					byte[] bytData = strData.getBytes(Charset.forName("euc-kr"));
					
					ByteArrayInputStream bais = new ByteArrayInputStream(bytData);
					ByteArrayOutputStream baos = new ByteArrayOutputStream(4096);
					
					byte[] bytRead = new byte[20];
					int nRead = 0;
					
					try {
						while ((nRead = bais.read(bytRead)) != -1) {
							baos.write(bytRead, 0, nRead);
							
							System.out.println(new String(baos.toByteArray()));
						}
						
						bais.close();
						baos.close();
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thread.start();
			thread.join();
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
