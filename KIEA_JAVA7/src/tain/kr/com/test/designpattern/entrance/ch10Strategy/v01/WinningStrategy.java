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
 *   -. FileName   : WinningStrategy.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class WinningStrategy implements Strategy {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Random random;
	private boolean won = false;
	private Hand prevHand;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public WinningStrategy(int seed) {
		this.random = new Random(seed);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Hand nextHand() {
		if (!this.won) {
			prevHand = Hand.getHand(random.nextInt(3));
		}
		
		return this.prevHand;
	}
	
	public void study(boolean win) {
		this.won = win;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
