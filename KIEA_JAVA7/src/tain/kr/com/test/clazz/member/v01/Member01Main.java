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
package tain.kr.com.test.clazz.member.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Member01Main.java
 *   -. Package    : tain.kr.com.test.clazz.member.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Member01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Member01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int person = 5;
	
	/*
	 * Member Class
	 * 
	 *    1. 멤버 클래스의 모든 인스턴스는 그 클래스를 포함하고 있는 클래스의 인스턴스를과 내부적으로 연관되어 있다.
	 *       즉, 멤버 클래스는 그 클래스를 포함하고 있는 클래스의 멤버이다.
	 *       
	 *    2. 멤버 클래스의 메소드는 자신의 멤버 뿐 아니라 그 클래스를 포함하고 있는 클래스의 모든 멤버를 참조할 수 있다.
	 */
	public class Television {
		
		int inch = 20;
		
		public void show() {
			System.out.format("Memger Class [person:%d] [inch:%d]%n", person, inch);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Member01Main member = new Member01Main();
			Member01Main.Television tv = member.new Television();
			
			tv.show();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
