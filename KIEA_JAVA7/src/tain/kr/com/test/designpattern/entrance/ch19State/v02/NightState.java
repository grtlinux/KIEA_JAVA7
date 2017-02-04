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
package tain.kr.com.test.designpattern.entrance.ch19State.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : NightState.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class NightState implements StateImpl {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(NightState.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private NightState() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void doClock(ContextImpl context, int hour) {
		
	}
	
	@Override
	public void doUse(ContextImpl context) {
		
	}
	
	@Override
	public void doAlarm(ContextImpl context) {
		
	}
	
	@Override
	public void doPhone(ContextImpl context) {
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return "[¾ß°£]";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static NightState instance = null;
	
	public synchronized static NightState getInstance() {
		
		if (instance == null) {
			instance = new NightState();
		}
		
		return instance;
	}
}
