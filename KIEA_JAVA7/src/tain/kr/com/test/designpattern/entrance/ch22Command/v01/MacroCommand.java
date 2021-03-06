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
package tain.kr.com.test.designpattern.entrance.ch22Command.v01;

import java.util.Stack;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MacroCommand.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch22Command.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MacroCommand implements CommandImpl {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Stack<CommandImpl> commands;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MacroCommand() {
		this.commands = new Stack<CommandImpl>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void execute() {
		
		for (CommandImpl command : this.commands) {
			command.execute();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void append(CommandImpl command) {
		
		if (command != this) {
			this.commands.push(command);
		}
	}
	
	public void undo() {
		
		if (!this.commands.empty()) {
			this.commands.pop();
		}
	}
	
	public void clear() {
		this.commands.clear();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
