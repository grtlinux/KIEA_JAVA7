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
package tain.kr.com.test.designpattern.entrance.ch23Interpreter.v03;

import java.util.StringTokenizer;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1Context.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch23Interpreter.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1Context {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Context.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final StringTokenizer tokenizer;
	private String currentToken;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public Dep1Context(String text) {
		if (!flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
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
	
	public void skipToken(String token) throws Exp1ParseException {
		if (!token.equalsIgnoreCase(this.currentToken)) {
			throw new Exp1ParseException(String.format("Warning: %s is expected, but %s is found..", token, this.currentToken));
		}
		
		nextToken();
	}
	
	public String currentToken() {
		return this.currentToken;
	}
	
	public int currentNumber() throws Exp1ParseException {
		
		int number = 0;
		
		try {
			number = Integer.parseInt(this.currentToken);
		} catch (NumberFormatException e) {
			throw new Exp1ParseException("Warning: " + e);
		}
		
		return number;
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
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {
			Dep1Context context = new Dep1Context("program    repeat   4   repeat 3 go right go left     end right end end");
			
			do {
				System.out.format("> [%s]\n", context.currentToken());
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
				
			} while (context.nextToken() != null);
		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
