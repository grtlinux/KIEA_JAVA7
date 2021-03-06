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

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Context.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 4. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Context {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Context.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final StringTokenizer tokenizer;
	private String currentToken;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Context(String text) {
		
		if (!flag) log.debug("-> " + text);
		
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
		
		if (!token.equalsIgnoreCase(this.currentToken)) {
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
	///////////////////////////////////////////////////////////////////////////////////////////////

}
