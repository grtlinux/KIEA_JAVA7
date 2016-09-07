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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Hand.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Hand {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Hand.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static final int HANDVALUE_GUU = 0;  // ÁÖ¸Ô
	private static final int HANDVALUE_CHO = 1;  // °¡À§
	private static final int HANDVALUE_PAA = 2;  // º¸
	
	private static final Hand[] hand = {
		new Hand(HANDVALUE_GUU),
		new Hand(HANDVALUE_CHO),
		new Hand(HANDVALUE_PAA),
	};
	
	private static final String[] name = {
		"ÁÖ¸Ô",
		"°¡À§",
		"º¸",
	};
	
	private final int handValue;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Hand(int handValue) {
		this.handValue = handValue;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public boolean isStrongerThan(Hand h) {
		return fight(h) == 1;
	}
	
	public boolean isWeakerThan(Hand h) {
		return fight(h) == -1;
	}
	
	private int fight(Hand h) {
		if (this == h) {
			return 0;
		} else if ((this.handValue + 1) % 3 == h.handValue) {
			return 1;
		} else {
			return -1;
		}
	}
	
	public String toString() {
		return name[handValue];
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Hand getHand(int handValue) {
		return hand[handValue];
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Hand hand0 = Hand.getHand(HANDVALUE_GUU);
			Hand hand1 = Hand.getHand(HANDVALUE_CHO);
			Hand hand2 = Hand.getHand(HANDVALUE_PAA);
			
			if (hand0.isStrongerThan(hand1)) {
				System.out.format("%s is stronger than %s\n", name[0], name[1]);
			} else {
				System.out.format("%s is stronger than %s\n", name[1], name[0]);
			}
			
			if (hand1.isStrongerThan(hand2)) {
				System.out.format("%s is stronger than %s\n", name[1], name[2]);
			} else {
				System.out.format("%s is stronger than %s\n", name[2], name[1]);
			}
			
			if (hand2.isStrongerThan(hand0)) {
				System.out.format("%s is stronger than %s\n", name[2], name[0]);
			} else {
				System.out.format("%s is stronger than %s\n", name[0], name[2]);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
