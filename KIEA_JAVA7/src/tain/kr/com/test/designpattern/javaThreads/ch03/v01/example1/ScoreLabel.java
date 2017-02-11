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
package tain.kr.com.test.designpattern.javaThreads.ch03.v01.example1;

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
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch03.v01.example1
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
	
	public ScoreLabel() {
		this(null, null);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public synchronized void resetGenerator(CharacterSource newGenerator) {
		if (generator != null)
			generator.removeCharacterListener(this);

		generator = newGenerator;

		if (generator != null)
			generator.addCharacterListener(this);
	}

	public synchronized void resetTypist(CharacterSource newTypist) {
		if (typist != null)
			typist.removeCharacterListener(this);

		typist = newTypist;

		if (typist != null)
			typist.addCharacterListener(this);
	}

	public synchronized void resetScore() {
		score = 0;
		char2type = -1;
		setScore();
	}

	private void setScore() {
		// This method will be explained later in chapter 7
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				setText(Integer.toString(score));
			}
		});
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterListener#newCharacter(tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterEvent)
	 */
	@Override
	public void newCharacter(CharacterEvent ce) {
		// Previous character not typed correctly - 1 point penalty
		if (ce.source == generator) {
			if (char2type != -1) {
				score--;
				setScore();
			}
			char2type = ce.character;
		}

		// If character is extraneous - 1 point penalty
		// If character does not match - 1 point penalty
		else {
			if (char2type != ce.character) {
				score--;
			} else {
				score++;
				char2type = -1;
			}
			setScore();
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
