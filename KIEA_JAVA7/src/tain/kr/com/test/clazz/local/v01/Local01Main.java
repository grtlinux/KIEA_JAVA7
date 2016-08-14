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
package tain.kr.com.test.clazz.local.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Local01Main.java
 *   -. Package    : tain.kr.com.test.clazz.local.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Local01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Local01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final int person = 5;
	
	public void show() {
		
		/*
		 * Local Class
		 * 
		 *    1. 지역 클래스는 메소드에서 선언되고 메소드에서만 사용할 수 있다. 즉 메소드에서 생성과
		 *       사용의 과정을 모두 거쳐야 하는 임시 클래스이므로 외부에서는 클래스를 생성하거나 사용할 수 없다.
		 *       
		 *    2. 지역 클래스는 자신의 멤버와 메소드 안의 지역 변수 중 반드시 final 키워드에 의해 상수화된 지역 변수만을 사용할 수 있다.
		 *    
		 *    3. 지역 클래스에는 다른 중첩 클래스나 멤버 클래스와는 달리 클래스 선언부에 접근 지정자를 붙일 수 없다.
		 */
		class Television {
			int inch = 20;
			
			public void show() {
				System.out.format("Local Class [person:%d] [inch:%d]%n", person, inch);
			}
		}
		
		Television tv = new Television();
		tv.show();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Local01Main main = new Local01Main();
			main.show();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
