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

import java.util.StringTokenizer;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Context.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Context {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final StringTokenizer tokenizer;
	private String currentToken;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Context(String text) {
		
		this.tokenizer = new StringTokenizer(text);
		nextToken();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String nextToken() {
		
		if (this.tokenizer.hasMoreTokens()) {
			this.currentToken = this.tokenizer.nextToken();
		} else {
			this.currentToken = null;
		}
		
		return this.currentToken;
	}
	
	public String currentToken() {
		return this.currentToken;
	}
	
	public void skipToken(String token) throws ParseException {
		
		if (!token.equals(currentToken)) {
			throw new ParseException("Warning: " + token + " is expected, but " + this.currentToken + " is found.");
		}
		
		nextToken();
	}
	
	public int currentNumber() throws ParseException {
		
		int number = 0;
		
		try {
			number = Integer.parseInt(this.currentToken);
		} catch (NumberFormatException e) {
			throw new ParseException("Warning: " + e);
		}
		
		return number;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
