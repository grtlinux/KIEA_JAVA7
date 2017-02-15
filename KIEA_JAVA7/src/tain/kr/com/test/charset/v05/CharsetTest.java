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
package tain.kr.com.test.charset.v05;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CharsetTest.java
 *   -. Package    : tain.kr.com.test.charset.v05
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class CharsetTest {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(CharsetTest.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public CharsetTest() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	// unicode
	//private final static String strMsg = "가나다라마바사 string ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private final static String strMsg = "가나다라마바사아자차";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void saveToFileEuckr() throws Exception {
		
		String fileName = "N:/FILE_EUCKR.txt";
		//String fileName = "result/FILE_EUCKR.txt";
		
		FileOutputStream outStream = new FileOutputStream(fileName);
		
		byte[] bytString = strMsg.getBytes(Charset.forName("euc-kr"));
		
		outStream.write(bytString);
		
		outStream.close();
		
		if (flag) System.out.printf("saveFileEuckr() size = %d%n", bytString.length);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void saveToFileUtf8() throws Exception {
		
		String fileName = "N:/FILE_UTF8.txt";
		//String fileName = "result/FILE_UTF8.txt";
		
		FileOutputStream outStream = new FileOutputStream(fileName);
		
		byte[] bytString = strMsg.getBytes(Charset.forName("utf-8"));
		
		outStream.write(bytString);
		
		outStream.close();
		
		if (flag) System.out.printf("saveFileUtf8() size = %d%n", bytString.length);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void readFromFileEuckr() throws Exception {
		
		String fileName = "N:/FILE_EUCKR.txt";
		//String fileName = "result/FILE_EUCKR.txt";
		
		FileInputStream inStream = new FileInputStream(fileName);
		
		byte[] bytString = new byte[1024];
		
		int length = inStream.read(bytString);
		
		inStream.close();

		String strRet = new String(bytString, 0, length, Charset.forName("euc-kr"));
		
		if (flag) System.out.printf("readFromFileEuckr() string = %s%n", strRet);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void readFromFileUtf8() throws Exception {
		
		String fileName = "N:/FILE_UTF8.txt";
		//String fileName = "result/FILE_UTF8.txt";
		
		FileInputStream inStream = new FileInputStream(fileName);
		
		byte[] bytString = new byte[1024];
		
		int length = inStream.read(bytString);
		
		inStream.close();

		String strRet = new String(bytString, 0, length, Charset.forName("utf-8"));
		
		if (flag) System.out.printf("readFromFileUtf8() string = %s%n", strRet);
	}
	
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
			new CharsetTest();

		if (flag) {
			// save file euc-kr
			saveToFileEuckr();
			
			// save file utf-8
			saveToFileUtf8();
		}
		
		if (flag) {
			// save file euc-kr
			readFromFileEuckr();
			
			// save file utf-8
			readFromFileUtf8();
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
