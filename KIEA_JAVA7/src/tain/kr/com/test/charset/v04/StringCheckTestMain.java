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
package tain.kr.com.test.charset.v04;

import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StringCheckTestMain.java
 *   -. Package    : tain.kr.com.test.charset.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StringCheckTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StringCheckTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			if (flag) System.out.println();
			
			// unicode
			String hello = "¾È³çÇÏ¼¼¿ä...¤¡¤¤¤§";
			if (flag) System.out.println("hello : " + hello);
			
			if (flag) System.out.println();
			
			// euc-kr
			byte[] euckrHello = hello.getBytes(Charset.forName("euc-kr"));
			if (flag) System.out.println("euc-kr - length : " + euckrHello.length);
			
			String decodeFromEuckr = new String(euckrHello, "euc-kr");
			if (flag) System.out.println("String from euc-kr : " + decodeFromEuckr);
			
			if (flag) System.out.println();
			
			// utf-8
			byte[] utf8Hello = decodeFromEuckr.getBytes("utf-8");
			if (flag) System.out.println("utf-8 - length : " + utf8Hello.length);
			
			String decodeFromUtf8 = new String(utf8Hello, "utf-8");
			if (flag) System.out.println("String from utf-8 : " + decodeFromUtf8);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
