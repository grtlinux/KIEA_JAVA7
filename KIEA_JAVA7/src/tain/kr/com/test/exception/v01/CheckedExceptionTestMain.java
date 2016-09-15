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
package tain.kr.com.test.exception.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CheckedExceptionTestMain.java
 *   -. Package    : tain.kr.com.test.exception.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CheckedExceptionTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(CheckedExceptionTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) {
		
		if (flag) {
			double a = 10;
			double b = 0;
			
			if (b == 0) {
				try {
					throw new CheckedException("0으로 나누는 것은 허용되지 않습니다.");
				} catch (CheckedException e) {
					e.printStackTrace();
				}
			}
			
			System.out.println("ret = " + (a / b));
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			double a = 10;
			double b = 0;
			
			if (b == 0) {
				throw new CheckedException("0으로 나누는 것은 허용되지 않습니다.");
			}
			
			System.out.println("ret = " + (a / b));
		}
	}

	public static void main(String[] args) {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		
		try {
			if (flag) test02(args);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

/*
 * CheckedException
 */
class CheckedException extends Exception {
	
	private static final long serialVersionUID = 1L;

	public CheckedException() {
		super();
	}
	
	public CheckedException(String msg) {
		super(msg);
	}
}