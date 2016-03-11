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
package tain.kr.com.test.tokenizer.v01;

import java.util.Scanner;
import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StringTokenizerTestMain.java
 *   -. Package    : tain.kr.com.test.tokenizer.v01
 *   
 *   -. Comment    : 문자열이 특정 구분자로 연결되어 있을 경우 구분자를 기준으로 부분 문자열을 분리하기 위해서는
 *                   String의 split() 메서드를 사용하거나 StringTokenizer 클래스를 사용할 수 있습니다.
 *                   split()은 정규 표현식으로 구분하고, StringTokenizer는 문자로 구분한다는 차이점이 있습니다.
 *   
 *   -. Author     : taincokr
 *   -. First Date : 2016. 2. 1. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StringTokenizerTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StringTokenizerTestMain.class);

	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * String.split();
			 */
			
			String text = "네이버&블로그,부르곰-포스팅";
			
			String[] names = text.split("&|,|-");
			
			for (String name : names) {
				log.debug(">>>>> [" + name + "]");
			}
			
			System.out.println();
		}
		
		if (flag) {

			String text = "네이버/블로그/부르곰/포스팅";
			
			StringTokenizer st = new StringTokenizer(text, "/");
			int count = st.countTokens();
			
			for (int i=0; i < count; i++) {
				String token = st.nextToken();
				log.debug(">>>>> [" + token + "]");
			}
			
			System.out.println();
		}
		
		if (flag) {
			
			String text = "네이버/블로그/부르곰/포스팅";
			
			StringTokenizer st = new StringTokenizer(text, "/");
			
			while (st.hasMoreTokens()) {
				String token = st.nextToken();
				log.debug(">>>>> [" + token + "]");
			}
			
			System.out.println();
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			String URL = "a://a.b.c/d.e.f/f.g.t";
			
			StringTokenizer st = new StringTokenizer(URL, "://");   // delimiter -> :, /
			while (st.hasMoreTokens()) {
				log.debug(">>>>> " + st.nextToken());
			}
			
			System.out.println();
			
			String[] tokens = URL.split("://");     // delimiter -> '://'
			for (String token : tokens) {
				log.debug(">>>>> " + token);
			}
			
			System.out.println();
		}
	}
	
	private static void test03(String[] args) throws Exception {
	
		if (!flag) {
			/*
			 * Scanner
			 */
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			
			log.debug(">>>>> input a string..");
			
			String str = scan.nextLine();
			
			log.debug(">>>>> [" + str + "]");
		}
		
		if (flag) {
			/*
			 * Deploy Key
			 */
			
			@SuppressWarnings("resource")
			Scanner scan = new Scanner(System.in);
			
			System.out.println(">>>>> input the deploy key..");
			
			String str = scan.nextLine();
			
			System.out.println(">>>>> [" + str + "]");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (!flag) test02(args);
		if (flag) test03(args);
	}
}
