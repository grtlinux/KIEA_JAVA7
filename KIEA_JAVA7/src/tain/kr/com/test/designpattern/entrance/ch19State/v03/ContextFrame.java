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
package tain.kr.com.test.designpattern.entrance.ch19State.v03;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ContextFrame.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ContextFrame extends Frame implements ImplContext {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ContextFrame.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("USE");
	private Button buttonAlarm = new Button("ALARM");
	private Button buttonPhone = new Button("PHONE");
	private Button buttonExit = new Button("EXIT");
	
	// initialize
	private ImplState state = StateDay.getInstance();
	private ImplContext context = this;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ContextFrame(String title) {
		
		super(title);
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName() + " - " + this.state);
		
		//////////////////////////////////////////////////////////////////////
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout());
		
		// textClock
		add(this.textClock, BorderLayout.NORTH);
		this.textClock.setEditable(false);
		
		// textScreen
		add(this.textScreen, BorderLayout.CENTER);
		this.textScreen.setEditable(false);
		
		// button in pane
		Panel panel = new Panel();
		panel.add(this.buttonUse);
		panel.add(this.buttonAlarm);
		panel.add(this.buttonPhone);
		panel.add(this.buttonExit);
		add(panel, BorderLayout.SOUTH);
		
		// show
		//pack();
		//show();
		setSize(300, 200);
		setVisible(true);
		
		// listener
		this.buttonUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				state.doUse(context);
			}
		});
		
		this.buttonAlarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				state.doAlarm(context);
			}
		});
		
		this.buttonPhone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				state.doPhone(context);
			}
		});
		
		this.buttonExit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				System.exit(0);
			}
		});
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void setClock(int hour) {
		
		String strClock = String.format("����ð��� %02d:00", hour);
		System.out.println(strClock);
		
		this.textClock.setText(strClock);
		this.state.doClock(this.context, hour);
	}
	
	@Override
	public void changeState(ImplState state) {
		
		String strMsg = String.format("���°� %s���� %s�� ���°� ��ȭ�߽��ϴ�.", this.state, state);
		System.out.println(strMsg);
		
		// System.out.format("���°� %s���� %s�� ���°� ��ȭ�߽��ϴ�.\n", this.state, state);
		
		this.state = state;
	}
	
	@Override
	public void callSecurityCenter(String msg) {
		
		this.textScreen.append("call! " + msg + "\n");
	}
	
	@Override
	public void recordLog(String msg) {
		
		this.textScreen.append("record ... " + msg + "\n");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
