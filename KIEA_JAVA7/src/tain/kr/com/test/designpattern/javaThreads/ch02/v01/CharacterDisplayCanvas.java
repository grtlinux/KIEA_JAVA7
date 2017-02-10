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
package tain.kr.com.test.designpattern.javaThreads.ch02.v01;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Toolkit;

import javax.swing.JComponent;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : CharacterDisplayCanvas.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch02.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 10. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class CharacterDisplayCanvas extends JComponent implements CharacterListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(CharacterDisplayCanvas.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected FontMetrics fontMetrics;
	protected char[] tmpChar = new char[1];
	protected int fontHeight;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	@SuppressWarnings("deprecation")
	public CharacterDisplayCanvas() {
		
		setFont(new Font("Monospaced", Font.BOLD, 18));
		this.fontMetrics = Toolkit.getDefaultToolkit().getFontMetrics(getFont());
		this.fontHeight = fontMetrics.getHeight();
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public CharacterDisplayCanvas(CharacterSource cs) {
		this();
		setCharacterSource(cs);
	}
	
	private void setCharacterSource(CharacterSource cs) {
		cs.addCharacterListener(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dimension preferredSize() {
		return new Dimension(this.fontMetrics.getMaxAscent() + 10, this.fontMetrics.getMaxAdvance() + 10);
	}
	
	protected synchronized void paintComponent(Graphics gc) {
		Dimension d = getSize();
		gc.clearRect(0, 0, d.width, d.height);
		if (this.tmpChar[0] == 0) {
			return;
		}
		
		int charWidth = this.fontMetrics.charWidth((int) this.tmpChar[0]);
		gc.drawChars(this.tmpChar, 0, 1, (d.width - charWidth) / 2, this.fontHeight);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterListener#newCharacter(tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterEvent)
	 */
	@Override
	public synchronized void newCharacter(CharacterEvent ce) {
		// TODO Auto-generated method stub
		
		this.tmpChar[0] = (char) ce.character;
		repaint();
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
			new CharacterDisplayCanvas();

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
