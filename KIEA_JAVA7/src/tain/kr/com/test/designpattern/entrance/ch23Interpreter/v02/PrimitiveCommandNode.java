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
package tain.kr.com.test.designpattern.entrance.ch23Interpreter.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PrimitiveCommandNode.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 4. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PrimitiveCommandNode extends Node {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(PrimitiveCommandNode.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void parse(Context context) throws ParseException {
		
		if (!flag) log.debug(">>> in class " + this.getClass().getName());
		
		this.name = context.currentToken();
		context.skipToken(this.name);
		
		if (!this.name.equalsIgnoreCase("GO")
				&& !this.name.equalsIgnoreCase("RIGHT")
				&& !this.name.equalsIgnoreCase("LEFT")) {
			throw new ParseException(this.name + " is undefined..");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return String.format("%s", this.name);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
