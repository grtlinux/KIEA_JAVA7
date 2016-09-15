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
package tain.kr.com.test.designpattern.entrance.ch23Interpreter.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RepeatCommandNode.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class RepeatCommandNode extends Node {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int number;
	private Node commandListNode;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void parse(Context context) throws ParseException {
		
		context.skipToken("REPEAT");
		
		this.number = context.currentNumber();
		context.nextToken();
		
		this.commandListNode = new CommandListNode();
		this.commandListNode.parse(context);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return String.format("[ repeat %d %s ]", this.number, this.commandListNode);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
