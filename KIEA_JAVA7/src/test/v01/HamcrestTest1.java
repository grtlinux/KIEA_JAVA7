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
package test.v01;

import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.matchers.JUnitMatchers.hasItem;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : HamcrestTest1.java
 *   -. Package    : test.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class HamcrestTest1 {

	private List<String> lst;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Before
	public void setList() {
		
		this.lst = new ArrayList<String>();
		this.lst.add("X");
		this.lst.add("Y");
		this.lst.add("Z");
	}
	
	@Test
	public void testList1() {
		
		//assertTrue(this.lst.contains("one") || this.lst.contains("two") || this.lst.contains("thrww"));
		assertTrue(this.lst.contains("X") || this.lst.contains("two") || this.lst.contains("thrww"));
	}
	
	@Test
	@SuppressWarnings("deprecation")
	public void testList2() {
		
		//assertThat(this.lst, hasItem(anyOf(equalTo("one"), equalTo("two"), equalTo("three"))));
		assertThat(this.lst, hasItem(anyOf(equalTo("Z"), equalTo("two"), equalTo("three"))));
	}
}
