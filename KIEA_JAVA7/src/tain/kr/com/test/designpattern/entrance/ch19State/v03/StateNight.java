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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StateNight.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StateNight implements ImplState {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StateNight.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private StateNight() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void doClock(ImplContext context, int hour) {
		if (9 <= hour && hour < 17) {
			context.changeState(StateDay.getInstance());
		}
	}
	
	@Override
	public void doUse(ImplContext context) {
		context.recordLog("비상:야간의 금고사용");
	}
	
	@Override
	public void doAlarm(ImplContext context) {
		context.callSecurityCenter("비상벨(야간)");
	}
	
	@Override
	public void doPhone(ImplContext context) {
		context.callSecurityCenter("야간의 통화 녹음");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return "[야간]";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static StateNight instance = null;
	
	public synchronized static StateNight getInstance() {
		
		if (instance == null) {
			instance = new StateNight();
		}
		
		return instance;
	}
}
