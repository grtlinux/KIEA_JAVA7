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
 *   -. FileName   : StrategyProb.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StrategyProb implements ImplStrategy {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StrategyProb.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Random random;
	private int prevHandValue = 0;
	private int currentHandValue = 0;
	
	private int[][] history = {
			{ 1, 1, 1, },
			{ 1, 1, 1, },
			{ 1, 1, 1, },
	};
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public StrategyProb(long seed) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.random = new Random(seed);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Hand nextHand() {
		int bet = this.random.nextInt(getSum(this.currentHandValue));
		int handValue = 0;
		
		if (bet < this.history[this.currentHandValue][0]) {
			handValue = 0;
		} else if (bet < this.history[this.currentHandValue][0] + this.history[this.currentHandValue][1]) {
			handValue = 1;
		} else {
			handValue = 2;
		}
		
		this.prevHandValue = this.currentHandValue;
		this.currentHandValue = handValue;
		
		return Dep1Hand.getHand(handValue);
	}
	
	public void study(boolean won) {
		if (won) {
			this.history[this.prevHandValue][this.currentHandValue]++;
		} else {
			this.history[this.prevHandValue][(this.currentHandValue + 1) % 3]++;
			this.history[this.prevHandValue][(this.currentHandValue + 2) % 3]++;
		}
	}
	
	public String getName() {
		return "ProbStrategy";
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int getSum(int hv) {
		int sum = 0;
		
		for (int i=0; i < 3; i++) {
			sum += this.history[hv][i];
		}
		
		return sum;
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
