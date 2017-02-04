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
package tain.kr.com.test.designpattern.entrance.ch16Mediator.v01;

import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ColleagueCheckbox.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch16Mediator.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ColleagueCheckbox extends Checkbox implements ItemListener, Colleague {

	private static final long serialVersionUID = 1L;
	
	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ColleagueCheckbox.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Mediator mediator;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ColleagueCheckbox(String caption, CheckboxGroup group, boolean state) {
		super(caption, group, state);
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}
	
	public void setColleagueEnabled(boolean enabled) {
		setEnabled(enabled);
	}
	
	public void itemStateChanged(ItemEvent e) {
		mediator.colleagueChanged(this);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
