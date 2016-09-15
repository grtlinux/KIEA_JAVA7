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
package tain.kr.com.test.designpattern.entrance.ch19State.v01;

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
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TestMain extends Frame implements ContextImpl {

	private static final long serialVersionUID = 1L;

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private TextField textClock = new TextField(60);
	private TextArea textScreen = new TextArea(10, 60);
	private Button buttonUse = new Button("USE");
	private Button buttonAlarm = new Button("ALARM");
	private Button buttonPhone = new Button("PHONE");
	private Button buttonExit = new Button("EXIT");
	
	private StateImpl state = DayState.getInstance();
	
	private ContextImpl context = this;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public TestMain(String title) {
		
		super(title);
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
		buttonUse.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				state.doUse(context);
			}
		});
		
		buttonAlarm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				state.doAlarm(context);
			}
		});
		
		buttonPhone.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(e);
				state.doPhone(context);
			}
		});
		
		buttonExit.addActionListener(new ActionListener() {
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
		
		StringBuffer sb = new StringBuffer();
		
		sb.append(String.format("현재시각은 %02d:00", hour));
		
		System.out.println(sb.toString());
		
		this.textClock.setText(sb.toString());
		this.state.doClock(context, hour);
	}
	
	@Override
	public void changeState(StateImpl state) {
		
		System.out.format("상태가 %s에서 %s로 상태가 변화했습니다.", this.state, state);
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

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			TestMain frame = new TestMain("State Sample");
			
			while (true) {
				
				for (int hour = 0; hour < 24; hour++) {
					frame.setClock(hour);
					
					try { Thread.sleep(1000); } catch (InterruptedException e) {}
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
