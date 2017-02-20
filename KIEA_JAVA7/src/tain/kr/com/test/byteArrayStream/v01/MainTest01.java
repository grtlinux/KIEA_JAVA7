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
package tain.kr.com.test.byteArrayStream.v01;

import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest01.java
 *   -. Package    : tain.kr.com.test.byteArrayStream.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 20. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest01 {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest01.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest01() {
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
			new MainTest01();

		if (!flag) {
			/*
			 * new DataInputStream(new ByteArrayInputStream(...))
			 */
			StringBuffer sb = new StringBuffer();
			byte[] bytStream = null;
			
			if (flag) {
				/*
				 * make byte array
				 */
				for (int i=0; i < 100; i++) {
					sb.append(String.format("ABCDEFGHIJ%010d", i));
				}
				
				if (flag) sb.append("abcdefghij");
				
				bytStream = sb.toString().getBytes(Charset.forName("euc-kr"));
			}
			
			if (flag) {
				/*
				 * read
				 */
				DataInputStream dis = new DataInputStream(new ByteArrayInputStream(bytStream));
				byte[] bytRead = new byte[20];
				int nRead = -1;
				
				while ((nRead = dis.read(bytRead)) != -1) {
					if (flag) System.out.printf("(%02d) [%s]\n"
							, nRead, new String(bytRead, 0, nRead, Charset.forName("euc-kr")));
				}
				
				dis.close();
			}
		}
		
		if (flag) {
			/*
			 * new BufferedInputStream(new ByteArrayInputStream(...))
			 */
			StringBuffer sb = new StringBuffer();
			byte[] bytStream = null;
			
			if (flag) {
				/*
				 * make byte array
				 */
				for (int i=0; i < 100; i++) {
					sb.append(String.format("ABCDEFGHIJ%010d", i)).append("\n");
				}
				
				if (flag) sb.append("abcdefghij");
				
				bytStream = sb.toString().getBytes(Charset.forName("euc-kr"));
			}
			
			if (flag) {
				/*
				 * read
				 */
				BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(bytStream));
				byte[] bytRead = new byte[1024];
				int nRead = -1;
				
				while ((nRead = bis.read(bytRead)) != -1) {
					if (flag) System.out.printf("(%02d) [%s]\n"
							, nRead, new String(bytRead, 0, nRead, Charset.forName("euc-kr")));
				}
				
				bis.close();
			}
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
