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
package tain.kr.com.test.designpattern.entrance.ch07Builder.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1Director.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch07Builder.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1Director {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Director.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final AbstBuilder builder;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Director(AbstBuilder builder) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.builder = builder;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Object construct() {
		this.builder.makeTitle("Greeting");
		this.builder.makeString("아침과 낮에");
		this.builder.makeItems(new String[] {
				"좋은 아침입니다.",
				"안녕하세요",
		});
		this.builder.makeString("밤에");
		this.builder.makeItems(new String[] {
				"안녕하세요",
				"안녕히 주무세요",
				"안녕히 계세요",
		});
		
		return this.builder.getResult();
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

}
