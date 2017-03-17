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
package tain.kr.com.test.redirection.v01;

import java.io.BufferedOutputStream;
import java.io.FileDescriptor;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SystemOutTestMain.java
 *   -. Package    : tain.kr.com.test.redirection.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SystemOutTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SystemOutTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			MyPrintStream myStream = new MyPrintStream(System.err);

			System.out.println("LOG-STRING") ;

			System.setOut(myStream);
			System.out.println("LOG-STRING") ;
			System.out.println(System.out);

			FileOutputStream fdOut = new FileOutputStream(FileDescriptor.out);
			PrintStream pureStream = new PrintStream(new BufferedOutputStream(fdOut, 128), true);

			System.setOut(pureStream);
			System.out.println ( "LOG-STRING") ;
			pureStream.println ( "LOG-STRING") ;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class MyPrintStream extends PrintStream {

	public MyPrintStream(OutputStream out) {
		super(out);
	}

	public MyPrintStream(OutputStream out, boolean autoFlush) {
		super(out, autoFlush);
	}

	public MyPrintStream(OutputStream out, boolean autoFlush, String encoding) throws UnsupportedEncodingException {
		super(out, autoFlush, encoding);
	}

	@Override
	public void println(String x) {
		super.println(" MY STREAM : "+ x);
	}
}
