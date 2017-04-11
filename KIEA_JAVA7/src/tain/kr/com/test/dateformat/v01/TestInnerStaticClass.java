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
package tain.kr.com.test.dateformat.v01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestInnerStaticClass.java
 *   -. Package    : tain.kr.com.test.dateformat.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 12. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class TestInnerStaticClass {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(TestInnerStaticClass.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public TestInnerStaticClass() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public void execute() {
		
		if (flag) {
			/*
			 * print static inner class
			 */
			System.out.printf("1. [%s]\n", DateFormat.get());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final static class DateFormat {
		
		private final static String DEFAULT_FORMAT = "HH:mm";
		
		public final static String get(String format) {
			return new SimpleDateFormat(format, Locale.KOREA).format(new Date());
		}
		
		public final static String get() {
			return get(DEFAULT_FORMAT);
		}
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new TestInnerStaticClass();

		if (flag) {
			/*
			 * begin
			 */
			new TestInnerStaticClass().execute();
		}
		
		if (flag) {
			/*
			 * static inner class
			 */
			System.out.printf("2. [%s]\n", DateFormat.get());
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
