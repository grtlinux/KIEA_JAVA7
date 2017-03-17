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
package tain.kr.com.test.designpattern.javaThreads.ch02.v01.example2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterDisplayCanvas;
import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterEventHandler;
import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch02.v01.CharacterSource;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SwingTypeTester.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch02.v01.example2
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 10. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
@SuppressWarnings("deprecation")
public class SwingTypeTester extends JFrame implements CharacterSource {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SwingTypeTester.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
    
	protected RandomCharacterGenerator producer;
	private CharacterDisplayCanvas displayCanvas;
	private CharacterDisplayCanvas feedbackCanvas;
	private JButton quitButton;
	private JButton startButton;
	private CharacterEventHandler handler;

    ///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public SwingTypeTester() {
		
		initComponents();
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	private void initComponents() {
		
		handler = new CharacterEventHandler();
		displayCanvas = new CharacterDisplayCanvas();
		feedbackCanvas = new CharacterDisplayCanvas(this);
		quitButton = new JButton();
		startButton = new JButton();
		add(displayCanvas, BorderLayout.NORTH);
		add(feedbackCanvas, BorderLayout.CENTER);
		JPanel p = new JPanel();
		startButton.setLabel("Start");
		quitButton.setLabel("Quit");
		p.add(startButton);
		p.add(quitButton);
		add(p, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent evt) {
				quit();
			}
		});

		feedbackCanvas.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (c != KeyEvent.CHAR_UNDEFINED)
					newCharacter(c);
			}
		});
		startButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				producer = new RandomCharacterGenerator();
				displayCanvas.setCharacterSource(producer);
				producer.start();
				startButton.setEnabled(false);
				feedbackCanvas.setEnabled(true);
				feedbackCanvas.requestFocus();
			}
		});
		quitButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				quit();
			}
		});
		pack();
	}
	
	private void quit() {
		System.exit(0);
	}
	
	private void newCharacter(int c) {
		handler.fireNewCharacter(this, c);
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
		throw new IllegalStateException("We don't produce on demand");
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

		if (flag) {
			new SwingTypeTester().show();
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
