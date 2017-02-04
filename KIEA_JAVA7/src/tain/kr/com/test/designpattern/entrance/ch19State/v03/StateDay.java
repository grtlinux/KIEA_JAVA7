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
 *   -. FileName   : StateDay.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StateDay implements ImplState {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StateDay.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private StateDay() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void doClock(ImplContext context, int hour) {
		if (hour < 9 || 17 <= hour) {
			context.changeState(StateNight.getInstance());
		}
	}
	
	@Override
	public void doUse(ImplContext context) {
		context.recordLog("금고사용(주간)");
	}
	
	@Override
	public void doAlarm(ImplContext context) {
		context.callSecurityCenter("비상벨(주간)");
	}
	
	@Override
	public void doPhone(ImplContext context) {
		context.callSecurityCenter("일반통화(주간)");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return "[주간]";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static StateDay instance = null;
	
	public synchronized static StateDay getInstance() {
		
		if (instance == null) {
			instance = new StateDay();
		}
		
		return instance;
	}
}
