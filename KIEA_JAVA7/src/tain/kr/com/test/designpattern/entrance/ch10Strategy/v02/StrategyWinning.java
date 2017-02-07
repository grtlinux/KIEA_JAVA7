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

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StrategyWinning.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StrategyWinning implements ImplStrategy {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StrategyWinning.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private final Random random;
	private boolean won = false;
	private Dep1Hand prevHand;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public StrategyWinning(long seed) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());

		this.random = new Random(seed);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public Dep1Hand nextHand() {
		if (!this.won) {
			prevHand = Dep1Hand.getHand(random.nextInt(3));
		}
		
		return this.prevHand;
	}
	
	public void study(boolean win) {
		this.won = win;
	}
	
	public String getName() {
		return "WinningStrategy";
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