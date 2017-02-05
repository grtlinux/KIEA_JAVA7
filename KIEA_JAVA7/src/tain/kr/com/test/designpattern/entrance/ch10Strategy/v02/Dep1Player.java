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
package tain.kr.com.test.designpattern.entrance.ch10Strategy.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1Player.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1Player {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Player.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private final ImplStrategy strategy;
	
	private int winCount = 0;
	private int loseCount = 0;
	private int gameCount = 0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Player(String name, ImplStrategy strategy) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.name = name;
		this.strategy = strategy;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Hand nextHand() {
		return this.strategy.nextHand();
	}
	
	public void win() {
		this.strategy.study(true);
		this.winCount ++;
		this.gameCount ++;
	}
	
	public void lose() {
		this.strategy.study(false);
		this.loseCount ++;
		this.gameCount ++;
	}
	
	public void even() {
		this.gameCount ++;
	}
	
	public String toString() {
		return String.format("[ %s : %d games, %d win, %d lose (%s) ]", this.name, this.gameCount, this.winCount, this.loseCount, this.strategy.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
