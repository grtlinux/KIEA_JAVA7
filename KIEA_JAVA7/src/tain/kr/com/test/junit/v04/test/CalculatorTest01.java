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
package tain.kr.com.test.junit.v04.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tain.kr.com.test.junit.v04.Calculator;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CalculatorTest01.java
 *   -. Package    : tain.kr.com.test.junit.v04.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 24. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CalculatorTest01 {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void testAdd() {
		Calculator calc = new Calculator();
		double result = calc.add(10, 50);
		
		assertEquals(60, result, 0);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
