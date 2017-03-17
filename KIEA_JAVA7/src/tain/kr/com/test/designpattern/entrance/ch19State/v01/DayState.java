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
 *   -. FileName   : DayState.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DayState implements StateImpl {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private DayState() {}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void doClock(ContextImpl context, int hour) {
		if (hour < 9 || 17 <= hour) {
			context.changeState(NightState.getInstance());
		}
	}
	
	@Override
	public void doUse(ContextImpl context) {
		context.recordLog("�ݰ���(�ְ�)");
	}
	
	@Override
	public void doAlarm(ContextImpl context) {
		context.callSecurityCenter("���(�ְ�)");
	}
	
	@Override
	public void doPhone(ContextImpl context) {
		context.callSecurityCenter("�Ϲ���ȭ(�ְ�)");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return "[�ְ�]";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static DayState instance = null;
	
	public synchronized static DayState getInstance() {
		
		if (instance == null) {
			instance = new DayState();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
