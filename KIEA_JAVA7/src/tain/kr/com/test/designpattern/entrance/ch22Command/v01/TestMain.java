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
package tain.kr.com.test.designpattern.entrance.ch22Command.v01;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch22Command.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TestMain extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final MacroCommand history;
	private final CanvasDraw canvas;
	private final JButton clearButton;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public TestMain(String title) {
		super(title);
		
		// final private member
		this.history = new MacroCommand();
		this.canvas = new CanvasDraw(400, 400, this.history);
		this.clearButton = new JButton("clear");
		
		// listener
		this.addWindowListener(this);
		this.canvas.addMouseMotionListener(this);
		this.clearButton.addActionListener(this);
		
		// layout
		Box buttonBox = new Box(BoxLayout.X_AXIS);
		buttonBox.add(this.clearButton);
		Box mainBox = new Box(BoxLayout.Y_AXIS);
		mainBox.add(buttonBox);
		mainBox.add(this.canvas);
		getContentPane().add(mainBox);
		
		pack();
		setVisible(true);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * ActionListener
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.clearButton) {
			this.history.clear();
			this.canvas.repaint();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * MouseMotionListener
	 */
	public void mouseMoved(MouseEvent e) {}
	
	public void mouseDragged(MouseEvent e) {
		CommandImpl command = new DrawCommand(this.canvas, e.getPoint());
		this.history.append(command);
		command.execute();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/*
	 * WindowListener
	 */
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public void windowActivated(WindowEvent e) {}
	public void windowClosed(WindowEvent e) {}
	public void windowDeactivated(WindowEvent e) {}
	public void windowDeiconified(WindowEvent e) {}
	public void windowIconified(WindowEvent e) {}
	public void windowOpened(WindowEvent e) {}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			new TestMain("Command Pattern Sample");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
