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
 *   -. FileName   : ProgramNode.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 4. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ProgramNode extends Node {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ProgramNode.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Node commandListNode;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void parse(Context context) throws ParseException {
		
		if (!flag) log.debug(">>> in class " + this.getClass().getSimpleName());
		
		context.skipToken("PROGRAM");
	
		this.commandListNode = new CommandListNode();
		this.commandListNode.parse(context);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return String.format("[ program %s ]", this.commandListNode);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
