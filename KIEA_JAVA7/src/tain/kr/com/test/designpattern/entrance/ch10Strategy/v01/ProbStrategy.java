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
package tain.kr.com.test.designpattern.entrance.ch10Strategy.v01;

import java.util.Random;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ProbStrategy.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ProbStrategy implements Strategy {

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
	
	public ProbStrategy(long seed) {
		this.random = new Random(seed);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Hand nextHand() {
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
		
		return Hand.getHand(handValue);
	}
	
	@Override
	public void study(boolean won) {
		if (won) {
			this.history[this.prevHandValue][this.currentHandValue]++;
		} else {
			this.history[this.prevHandValue][(this.currentHandValue + 1) % 3]++;
			this.history[this.prevHandValue][(this.currentHandValue + 2) % 3]++;
		}
	}
	
	@Override
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

}
