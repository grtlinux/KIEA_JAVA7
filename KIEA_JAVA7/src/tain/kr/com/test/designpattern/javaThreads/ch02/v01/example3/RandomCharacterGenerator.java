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
package tain.kr.com.test.designpattern.javaThreads.ch02.v01.example3;

import java.util.Random;

import org.apache.log4j.Logger;

import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterEventHandler;
import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterSource;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RandomCharacterGenerator.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch02.v01.example3
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 10. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class RandomCharacterGenerator extends Thread implements CharacterSource {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(RandomCharacterGenerator.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	static char[] chars;
	static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
	static {
		chars = charArray.toCharArray();
	}

	Random random;
	CharacterEventHandler handler;

	private volatile boolean done = false;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public RandomCharacterGenerator() {
		
		this.random = new Random();
		this.handler = new CharacterEventHandler();

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		while (!done) {
			nextCharacter();
			try {
				Thread.sleep(getPauseTime());
			} catch (InterruptedException ie) {
				return;
			}
		}
	}

	public int getPauseTime() {
		return (int) (Math.max(1000, 5000 * random.nextDouble()));
	}

	public void setDone() {
		done = true;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterSource#addCharacterListener(tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterListener)
	 */
	@Override
	public void addCharacterListener(CharacterListener cl) {
		// TODO Auto-generated method stub
		handler.addCharacterListener(cl);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterSource#removeCharacterListener(tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterListener)
	 */
	@Override
	public void removeCharacterListener(CharacterListener cl) {
		// TODO Auto-generated method stub
		handler.removeCharacterListener(cl);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterSource#nextCharacter()
	 */
	@Override
	public void nextCharacter() {
		// TODO Auto-generated method stub
		handler.fireNewCharacter(this, chars[random.nextInt(chars.length)]);
	}

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

		if (flag)
			new RandomCharacterGenerator();

		if (flag) {

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
