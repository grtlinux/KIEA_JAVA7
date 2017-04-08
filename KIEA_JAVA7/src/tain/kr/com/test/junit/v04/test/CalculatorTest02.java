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

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import tain.kr.com.test.junit.v04.Calculator;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CalculatorTest02.java
 *   -. Package    : tain.kr.com.test.junit.v04.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
@RunWith ( value = Parameterized.class )
public final class CalculatorTest02 {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private double expected;
	private double value1;
	private double value2;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public CalculatorTest02(double expected, double value1, double value2) {
		this.expected = expected;
		this.value1 = value1;
		this.value2 = value2;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test
	public void sum() {
		Calculator calc = new Calculator();
		assertEquals(this.expected, calc.add(value1, value2), 0);
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
	
	@Parameters
	public static Collection<Integer[]> getTestParameters() {
		Collection<Integer[]> col = Arrays.asList(new Integer[][] {
				{ 2,  1,  1, },
				{ 3,  2,  1, },
				{ 4,  3,  1, },
				{ 7,  3,  4, },
				{ 2,  3, -1, },
		});
		
		return col;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
}
