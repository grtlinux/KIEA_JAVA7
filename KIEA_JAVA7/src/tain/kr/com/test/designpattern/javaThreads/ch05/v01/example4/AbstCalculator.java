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
package tain.kr.com.test.designpattern.javaThreads.ch05.v01.example4;

import java.util.HashMap;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AbstCalculator.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch05.v01.example4
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbstCalculator {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(AbstCalculator.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public AbstCalculator() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static ThreadLocal<HashMap<Object, Object>> results = new ThreadLocal<HashMap<Object, Object>>() {
		protected HashMap<Object, Object> initialValue() {
			return new HashMap<Object, Object>();
		}
	};
	
	public Object calculate(Object param) {
		
		HashMap<Object, Object> map = results.get();
		
		Object val = map.get(param);
		if (val != null) {
			return val;
		}
		
		val = doLocalCalculate(param);
		map.put(param, val);
		
		return val;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected abstract Object doLocalCalculate(Object param);
	
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

		if (flag) {

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
