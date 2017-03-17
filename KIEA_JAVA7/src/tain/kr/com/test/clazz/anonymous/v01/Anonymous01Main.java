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
package tain.kr.com.test.clazz.anonymous.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Anonymous01Main.java
 *   -. Package    : tain.kr.com.test.clazz.anonymous.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Anonymous01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Anonymous01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void show(final int person) {
		
		if (flag) {
			
			/*
			 * Anonymous Class
			 * 
			 *    1. 익명 클래스는 지역 클래스와 같은 특징을 가지고 있으나 이름이 없다.
			 *    
			 *    2. 익명 클래스는 객체를 생성할 때 클래스의 구현을 동시에 해야 한다.
			 */
			Object tv = new Object() {
				int inch = 20;
				
				@Override
				public String toString() {
					return String.format("Anonymous Class [person:%d] [inch:%d]%n", person, inch);
				}
			};
			
			System.out.println(tv);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Anonymous01Main main = new Anonymous01Main();
			main.show(5);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
