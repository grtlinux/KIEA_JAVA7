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

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PipedInoutOutputDemoMain.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */

class PipedInputOutput extends Thread {
	
	private InputStream is = null;
	private OutputStream os = null;
	
	public PipedInputOutput(InputStream is, OutputStream os) {
		this.is = is;
		this.os = os;
	}
	
	@Override
	public void run() {
		
		byte[] buf = new byte[100];
		
		int len = 0;
		
		try {
			for (;;) {
				len = is.read(buf);
				
				if (len == -1) {
					break;
				}
				
				os.write(buf, 0, len);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

public class PipedInoutOutputDemoMain {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(PipedInoutOutputDemoMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			PipedInputStream pis = new PipedInputStream();
			PipedOutputStream pos = new PipedOutputStream(pis); // connect pipe
			
			PipedInputOutput thr1 = new PipedInputOutput(System.in, pos);
			PipedInputOutput thr2 = new PipedInputOutput(pis, System.out);
			
			thr1.start();
			thr2.start();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
