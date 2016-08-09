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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : KieaPipedDemoMain.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class KieaPipedDemoMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(KieaPipedDemoMain.class);

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
		
		if (!flag) {
			
			System.out.println("Thread-1");
			
			Thread thr1 = new Thread() {
				@Override
				public void run() {
					try {
						for (int i=1; i < 51; i++) {
							pos.write(i);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr1.start();
			thr1.join();
			
			while (pis.available() > 0) {
				int val = pis.read();
				System.out.println("> " + val);
			}
			
			System.out.println("Finish");
		}
		
		if (!flag) {
			
			System.out.println("Thread-1");
			
			Thread thr1 = new Thread() {
				@Override
				public void run() {
					try {
						for (int i=1; i < 1000; i++) {  // TODO 2016.08.08 : ERROR in Piped stream
							pos.write(i);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr1.start();

			try {
				int val = 0;
				
				while (true) {
					val = pis.read();
					System.out.println("> " + val);
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
			System.out.println("Finish");
		}
		
		if (flag) {
			
			System.out.println("Thread-1");
			
			Thread thr1 = new Thread() {
				@Override
				public void run() {
					
					DataOutputStream dos = new DataOutputStream(pos);
					
					try {
						for (int i=1; i < 1000000; i++) {
							dos.writeInt(i);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			thr1.start();

			try {
				
				DataInputStream dis = new DataInputStream(pis);
				
				int val = 0;
				
				while (true) {
					val = dis.readInt();
					System.out.println("> " + val);
				}
			} catch (Exception e) {
				//e.printStackTrace();
			}
			
			System.out.println("Finish");
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
