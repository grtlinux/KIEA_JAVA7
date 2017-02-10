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
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch02.v01.example3
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
	private JButton stopButton;
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

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		handler = new CharacterEventHandler();
		displayCanvas = new CharacterDisplayCanvas();
		feedbackCanvas = new CharacterDisplayCanvas(this);
		quitButton = new JButton();
		startButton = new JButton();
		stopButton = new JButton();
		add(displayCanvas, BorderLayout.NORTH);
		add(feedbackCanvas, BorderLayout.CENTER);
		JPanel p = new JPanel();
		startButton.setLabel("Start");
		stopButton.setLabel("Stop");
		quitButton.setLabel("Quit");
		p.add(startButton);
		p.add(stopButton);
		p.add(quitButton);
		add(p, BorderLayout.SOUTH);

		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				quit();
			}
		});

		feedbackCanvas.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent ke) {
				char c = ke.getKeyChar();
				if (c != KeyEvent.CHAR_UNDEFINED)
					newCharacter((int) c);
			}
		});
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				producer = new RandomCharacterGenerator();
				displayCanvas.setCharacterSource(producer);
				producer.start();
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				feedbackCanvas.setEnabled(true);
				feedbackCanvas.requestFocus();
			}
		});
		stopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				producer.setDone();
				feedbackCanvas.setEnabled(false);
			}
		});
		quitButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				quit();
			}
		});
			

		pack();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void quit() {
		System.exit(0);
	}

	public void addCharacterListener(CharacterListener cl) {
		handler.addCharacterListener(cl);
	}

	public void removeCharacterListener(CharacterListener cl) {
		handler.removeCharacterListener(cl);
	}

	public void newCharacter(int c) {
		handler.fireNewCharacter(this, c);
	}

	public void nextCharacter() {
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
