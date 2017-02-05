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
package tain.kr.com.test.designpattern.entrance.ch16Mediator.v02;

import java.awt.CheckboxGroup;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MediatorLoginFrame.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch16Mediator.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MediatorLoginFrame extends Frame implements ActionListener, ImplMediator {

	private static final long serialVersionUID = 1L;
	
	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(MediatorLoginFrame.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private ColleagueCheckbox checkGuest;
	private ColleagueCheckbox checkLogin;
	private ColleagueTextField textUser;
	private ColleagueTextField textPass;
	private ColleagueButton buttonOk;
	private ColleagueButton buttonCancel;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@SuppressWarnings("deprecation")
	public MediatorLoginFrame(String title) {
		
		super(title);
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		setBackground(Color.LIGHT_GRAY);
		setLayout(new GridLayout(4, 2));
		
		createColleagues();
		
		add(this.checkGuest);
		add(this.checkLogin);
		add(new Label("Username:"));
		add(this.textUser);
		add(new Label("Password:"));
		add(this.textPass);
		add(this.buttonOk);
		add(this.buttonCancel);
		
		colleagueChanged(this.checkGuest);
		
		pack();
		show();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void createColleagues() {
		
		// get class
		CheckboxGroup group = new CheckboxGroup();
		this.checkGuest = new ColleagueCheckbox("Guest", group, true);
		this.checkLogin = new ColleagueCheckbox("Login", group, false);
		this.textUser = new ColleagueTextField("", 10);
		this.textPass = new ColleagueTextField("", 10);
		this.textPass.setEchoChar('*');
		this.buttonOk = new ColleagueButton("OK");
		this.buttonCancel = new ColleagueButton("Cancel");
		
		// setMediator
		this.checkGuest.setMediator(this);
		this.checkLogin.setMediator(this);
		this.textUser.setMediator(this);
		this.textPass.setMediator(this);
		this.buttonOk.setMediator(this);
		this.buttonCancel.setMediator(this);
		
		// listener
		this.checkGuest.addItemListener(this.checkGuest);
		this.checkLogin.addItemListener(this.checkLogin);
		this.textUser.addTextListener(this.textUser);
		this.textPass.addTextListener(this.textPass);
		this.buttonOk.addActionListener(this);
		this.buttonCancel.addActionListener(this);
	}
	
	@Override
	public void colleagueChanged(ImplColleague colleague) {
		
		if (colleague == this.checkGuest || colleague == this.checkLogin) {
			if (this.checkGuest.getState()) {
				this.textUser.setColleagueEnabled(false);
				this.textPass.setColleagueEnabled(false);
				this.buttonOk.setColleagueEnabled(true);
			} else {
				this.textUser.setColleagueEnabled(true);
				userpassChanged();
			}
		} else if (colleague == this.textUser || colleague == this.textPass) {
			userpassChanged();
		} else {
			System.out.println("colleagueChanged : unknown colleague = " + colleague);
		}
	}
	
	private void userpassChanged() {
		
		if (this.textUser.getText().length() > 0) {
			this.textPass.setColleagueEnabled(true);
			if (this.textPass.getText().length() > 0) {
				this.buttonOk.setColleagueEnabled(true);
			} else {
				this.buttonOk.setColleagueEnabled(false);
			}
		} else {
			this.textPass.setColleagueEnabled(false);
			this.buttonOk.setColleagueEnabled(false);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.format("[%s, %s]\n", e.getActionCommand(), e.getClass().getName());
		System.exit(0);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
