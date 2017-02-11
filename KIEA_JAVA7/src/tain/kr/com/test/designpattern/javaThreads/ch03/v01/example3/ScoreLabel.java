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

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.JLabel;
import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterEvent;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterSource;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ScoreLabel.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch03.v01.example3
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 11. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ScoreLabel extends JLabel implements CharacterListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ScoreLabel.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private volatile int score = 0;
	private int char2type = -1;
	private CharacterSource generator = null, typist = null;
	private Lock scoreLock = new ReentrantLock();

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public ScoreLabel(CharacterSource generator, CharacterSource typist) {

		this.generator = generator;
		this.typist = typist;

		if (generator != null)
			generator.addCharacterListener(this);

		if (typist != null)
			typist.addCharacterListener(this);

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public ScoreLabel () {
		this(null, null);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void resetGenerator(CharacterSource newGenerator) {
		try {
			scoreLock.lock();

			if (generator != null)
				generator.removeCharacterListener(this);

			generator = newGenerator;

			if (generator != null)
				generator.addCharacterListener(this);
		} finally {
			scoreLock.unlock();
		}
	}

	public void resetTypist(CharacterSource newTypist) {
		try {
			scoreLock.lock();

			if (typist != null)
				typist.removeCharacterListener(this);

			typist = newTypist;

			if (typist != null)
				typist.addCharacterListener(this);
		} finally {
			scoreLock.unlock();
		}
	}

	public void resetScore() {
		try {
			scoreLock.lock();
			score = 0;
			char2type = -1;
			setScore();
		} finally {
			scoreLock.unlock();
		}
	}

	private void setScore() {
		// This method will be explained later in chapter 7
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setText(Integer.toString(score));
			}
		});
	}

	public void newCharacter(CharacterEvent ce) {
		if (ce.source == generator) {
			try {
				scoreLock.lock();
				// Previous character not typed correctly - 1 point penalty
				if (char2type != -1) {
					score--;
					setScore();
				}
				char2type = ce.character;
			} finally {
				scoreLock.unlock();
			}
		}
		// If character is extraneous - 1 point penalty
		// If character does not match - 1 point penalty
		else {
			try {
				scoreLock.lock();
				if (char2type != ce.character) {
					score--;
				} else {
					score++;
					char2type = -1;
				}
				setScore();
			} finally {
				scoreLock.unlock();
			}
		}
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
			new ScoreLabel();

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
