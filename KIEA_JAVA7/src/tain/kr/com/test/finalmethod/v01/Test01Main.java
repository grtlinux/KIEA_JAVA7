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
package tain.kr.com.test.finalmethod.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Test01Main.java
 *   -. Package    : tain.kr.com.test.finalmethod.v01
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
			B11 b = new B11();
			b.set(12345);
			System.out.format("super.n = %d%n", b.get());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class A11 {
	
	private int n;
	
	public final void setValue(int n) {
		this.n = n;
	}
	
	public final int getValue() {
		return this.n;
	}
}

/*
 * final class 는 최종 클래스, 최후에 구현된 클래스이므로 더이상 상속 구현이 불가능한 클래스를 의미한다.
 * 
 *     (X)   class C11 extends B11   <- 이렇게 구현이 않된다.
 */
final class B11 extends A11 {
	/*
	 * final method는 상속하지 못하므로 super를 통해서 접근할 수 있다.
	 */
	
	public void set(int n) {
		super.setValue(n);
	}
	
	public int get() {
		return super.getValue();
	}
}
