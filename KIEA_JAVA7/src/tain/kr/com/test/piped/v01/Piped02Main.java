/**
 * Copyright 2014, 2015, 2016 TAIN, Inc. all rights reserved.
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
 * Copyright 2014, 2015, 2016 TAIN, Inc.
 *
 */
package tain.kr.com.test.piped.v01;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Piped02Main.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Piped02Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Piped02Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static PipedInputStream pis = null;
	private static PipedOutputStream pos = null;

	//private static InputStream is = null;
	//private static OutputStream os = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			pis = new PipedInputStream();
			pos = new PipedOutputStream(pis);
		}
		
		if (flag) {
			
			System.out.println("Thread-1");
			
			Thread thr1 = new Thread() {
				@Override
				public void run() {
					try {
						for (int i=1; i < 51; i++) {  // finish
						//for (int i=1; i < 501; i++) {  // finish
						//for (int i=1; i < 5001; i++) {  // finish
							pos.write(i);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr1.start();
			thr1.join();
			
			System.out.println("Thread-2");

			Thread thr2 = new Thread() {
				@Override
				public void run() {
					try {
						for (int i=51; i < 101; i++) {  // finish
						//for (int i=501; i < 1001; i++) {   // finish
						//for (int i=5001; i < 10001; i++) {   // waiting for pipe reading
							pos.write(i);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr2.start();
			thr2.join();
			
			int sum = 0;
			
			while (pis.available() > 0) {
				sum += pis.read();
			}
			
			System.out.println("SUM = " + sum);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			pis = new PipedInputStream();
			pos = new PipedOutputStream(pis);
		}
		
		if (flag) {
			
			System.out.println("Thread-1");
			
			Thread thr1 = new Thread() {
				@Override
				public void run() {
					
					int sum1 = 0;
					
					try {
						for (int i=1; i <= 50; i++)
							sum1 += i;
						
						pos.write((sum1 + "\n").getBytes());
						
						System.out.println("[Thread-1] sum1 = " + sum1);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr1.start();
			// thr1.join();
			
			System.out.println("Thread-2");

			Thread thr2 = new Thread() {
				@Override
				public void run() {
					
					int sum1 = 0;
					int sum2 = 0;
					
					try {
						for (int i=51; i <= 100; i++) {
							sum2 += i;
						}
						
						BufferedReader br = new BufferedReader(new InputStreamReader(pis));
						String line = null;
						if ((line = br.readLine()) != null) {
							sum1 = Integer.parseInt(line);
							System.out.println("[Thread-2] sum1 = " + sum1);
						} else {
							return;
						}
						
						System.out.println("[Thread-2] sum2 = " + sum2);
						System.out.println("[Thread-2] sum1 + sum2 = " + (sum1 + sum2));
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr2.start();
			// thr2.join();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (!flag) test02(args);
	}
}
