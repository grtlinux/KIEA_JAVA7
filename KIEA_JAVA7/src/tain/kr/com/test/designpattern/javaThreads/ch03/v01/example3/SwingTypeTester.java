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

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Font;
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

import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterDisplayCanvas;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterEventHandler;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch03.v01.CharacterSource;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SwingTypeTester.java
 *   -. Package    : tain.kr.com.test.designpattern.javaThreads.ch03.v01.example3
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 11. {time}
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
	private AnimatedCharacterDisplayCanvas displayCanvas;
	private CharacterDisplayCanvas feedbackCanvas;
	private JButton quitButton;
	private JButton startButton;
	private JButton stopButton;
	private CharacterEventHandler handler;
	private ScoreLabel score;

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
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void initComponents() {
		handler = new CharacterEventHandler();
		displayCanvas = new AnimatedCharacterDisplayCanvas();
		feedbackCanvas = new CharacterDisplayCanvas(this);
		quitButton = new JButton();
		startButton = new JButton();
		stopButton = new JButton();
		score = new ScoreLabel(null, this);

		Container pane = getContentPane();
		pane.add(displayCanvas, BorderLayout.NORTH);
		pane.add(feedbackCanvas, BorderLayout.CENTER);

		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		score.setText("     ");
		score.setFont(new Font("MONOSPACED", Font.BOLD, 30));
		p1.add(score, BorderLayout.CENTER);

		JPanel p2 = new JPanel();
		startButton.setLabel("Start");
		stopButton.setLabel("Stop");
		stopButton.setEnabled(false);
		quitButton.setLabel("Quit");
		p2.add(startButton);
		p2.add(stopButton);
		p2.add(quitButton);
		p1.add(p2, BorderLayout.EAST);
		pane.add(p1, BorderLayout.SOUTH);

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
				score.resetGenerator(producer);
				producer.start();
				displayCanvas.setDone(false);
				Thread t = new Thread(displayCanvas);
				t.start();
				startButton.setEnabled(false);
				stopButton.setEnabled(true);
				feedbackCanvas.setEnabled(true);
				feedbackCanvas.requestFocus();
				score.resetScore();
			}
		});
		stopButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				startButton.setEnabled(true);
				stopButton.setEnabled(false);
				producer.setDone();
				displayCanvas.setDone(true);
				feedbackCanvas.setEnabled(false);
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

	@Override
	public void addCharacterListener(CharacterListener cl) {
		handler.addCharacterListener(cl);
	}

	@Override
	public void removeCharacterListener(CharacterListener cl) {
		handler.removeCharacterListener(cl);
	}

	public void newCharacter(int c) {
		handler.fireNewCharacter(this, c);
	}

	@Override
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
