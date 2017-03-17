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
package tain.kr.com.test.designpattern.javaThreads.ch03.v01.example3;

import java.awt.Dimension;
import java.awt.Graphics;

import org.apache.log4j.Logger;

import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterDisplayCanvas;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterSource;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AnimatedCharacterDisplayCanvas.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch03.v01.example3
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 11. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(AnimatedCharacterDisplayCanvas.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private volatile boolean done = false;
	private int curX = 0;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
		
		super(cs);
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public AnimatedCharacterDisplayCanvas() {}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	protected synchronized void paintComponent(Graphics gc) {
		Dimension d = getSize();
		gc.clearRect(0, 0, d.width, d.height);
		if (tmpChar[0] == 0)
			return;
		@SuppressWarnings("unused")
		int charWidth = fm.charWidth(tmpChar[0]);
		gc.drawChars(tmpChar, 0, 1, curX++, fontHeight);
	}

	@Override
	public void run() {
		while (!done) {
			repaint();
			try {
				Thread.sleep(100);
			} catch (InterruptedException ie) {
				return;
			}
		}
	}

	public void setDone(boolean b) {
		done = b;
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new AnimatedCharacterDisplayCanvas();

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
