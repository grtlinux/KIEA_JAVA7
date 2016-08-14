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
package tain.kr.com.test.finalize.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Test01Main.java
 *   -. Package    : tain.kr.com.test.finalize.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Test01Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Test01Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			MyName obj1 = new MyName("Instance-1");
			MyName obj2 = new MyName("Instance-2");

			System.out.format("[%s] [%s]%n", obj1.getName(), obj2.getName());
			
			obj1 = null;
			obj2 = null;
			
			System.out.println("프로그램을 종료합니다.");
			
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
			
			System.gc();
			System.runFinalization();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class MyName {
	
	private final String name;
	
	public MyName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		// this.name = name;
	}
	
	protected void finalized() throws Throwable {
		super.finalize();
		System.out.format("[%s] 객체가 소멸되었습니다.%n", this.name);
	}
}
