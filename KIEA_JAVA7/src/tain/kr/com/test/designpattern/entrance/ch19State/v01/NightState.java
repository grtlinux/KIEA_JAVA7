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


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : NightState.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class NightState implements StateImpl {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private NightState() {}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void doClock(ContextImpl context, int hour) {
		if (9 <= hour && hour < 17) {
			context.changeState(DayState.getInstance());
		}
	}
	
	@Override
	public void doUse(ContextImpl context) {
		context.recordLog("비상:야간의 금고사용");
	}
	
	@Override
	public void doAlarm(ContextImpl context) {
		context.callSecurityCenter("비상벨(야간)");
	}
	
	@Override
	public void doPhone(ContextImpl context) {
		context.callSecurityCenter("야간의 통화 녹음");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return "[야간]";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static NightState instance = null;
	
	public synchronized static NightState getInstance() {
		
		if (instance == null) {
			instance = new NightState();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
