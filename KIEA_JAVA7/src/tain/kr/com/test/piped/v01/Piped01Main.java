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

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Piped01Main.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Piped01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Piped01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			PipedInputStream pis = new PipedInputStream();
			PipedOutputStream pos = new PipedOutputStream(pis);
			
			FirstThread first = new FirstThread(pos);
			SecondThread second = new SecondThread(pis);
			
			second.start();
			first.start();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class FirstThread extends Thread {

	//private String fileName = "N:/___dos.bat";
	private String fileName = "N:/PrintStream.txt";
	private DataOutputStream dos = null;
	
	public FirstThread(OutputStream os) {
		this.dos = new DataOutputStream(new BufferedOutputStream(os));
	}
	
	@Override
	public void run() {
		
		try {
			
			// file open
			FileInputStream fis = new FileInputStream(fileName);
			
			// baos open
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			while (true) {
				int x = fis.read();
				if (x < 0) {
					break;
				}
				
				baos.write(x);
			}
			
			// file close
			fis.close();
			
			// redirection
			baos.writeTo(dos);
			
			dos.flush();
			
			dos.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class SecondThread extends Thread {
	
	private DataInputStream dis = null;
	
	public SecondThread(InputStream is) {
		this.dis = new DataInputStream(new BufferedInputStream(is));
	}
	
	@Override
	public void run() {
		
		try {
			while (true) {
				int x = dis.read();
				if (x < 0) {
					break;
				}
				
				System.out.print((char) x);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

