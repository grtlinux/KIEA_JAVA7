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
package tain.kr.com.test.clazz.nested.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Nested01Main.java
 *   -. Package    : tain.kr.com.test.clazz.nested.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Nested01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Nested01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static int person = 5;
	
	/*
	 * Nested Class
	 * 
	 *   1. ��øŬ������ �ν��Ͻ��� �� Ŭ������ �����ϰ� �ִ� Ŭ������ �ν��Ͻ��� ������ �������� ����.
	 *   
	 *   2. ��øŬ������ �޼ҵ�� �ڽ��� ����� �� Ŭ������ �����ϰ� �ִ� Ŭ������ �������(static)���� ������ �� �ִ�.
	 */
	static class Television {
		private int inch = 20;
		
		public void show() {
			System.out.format("Nested Class [person:%d] [inch:%d]%n", person, inch);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Nested01Main.Television tv = new Nested01Main.Television();
			tv.show();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
