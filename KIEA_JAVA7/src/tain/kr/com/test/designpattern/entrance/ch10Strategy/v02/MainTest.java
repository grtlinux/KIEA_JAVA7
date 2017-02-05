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

import java.util.Date;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch10Strategy.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MainTest() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) new MainTest();
		
		if (flag) {
			long seed1 = new Date().getTime() + 123;
			long seed2 = new Date().getTime();
			
			Dep1Player player1 = new Dep1Player("È«±æµ¿", new StrategyWinning(seed1));
			Dep1Player player2 = new Dep1Player("ÀÓ²©Á¤", new StrategyProb(seed2));
			
			for (int i=0; i < 1000; i++) {
				Dep1Hand nextHand1 = player1.nextHand();
				Dep1Hand nextHand2 = player2.nextHand();
				
				if (nextHand1.isStrongerThan(nextHand2)) {
					System.out.println("Winner:" + player1);
					player1.win();
					player2.lose();
				} else if (nextHand2.isStrongerThan(nextHand1)) {
					System.out.println("Winner:" + player2);
					player2.win();
					player1.lose();
				} else {
					System.out.println("Even...");
					player1.even();
					player2.even();
				}
			}
			
			System.out.println("Total result:");
			System.out.println(player1);
			System.out.println(player2);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
