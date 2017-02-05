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
package tain.kr.com.test.designpattern.entrance.ch18Memento.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch18Memento.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
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
			Dep2Gamer gamer = new Dep2Gamer(100);
			
			Dep1Memento memento = gamer.createMemento();
			
			for (int i=0; i < 100; i++) {
				System.out.format("==== %d ==== 상태 : %s\n", i, gamer);
				
				gamer.bet();
				
				System.out.format("돈은 %d 원이 되었습니다.\n", gamer.getMoney());
				
				if (gamer.getMoney() > memento.getMoney()) {
					memento = gamer.createMemento();
					System.out.println("    (많이 증가했으니 현재의 상태를 보존해두자) " + memento);
					
				} else if (gamer.getMoney() < memento.getMoney() / 2) {
					gamer.restoreMemento(memento);
					System.out.println("    (많이 줄었으니 이전의 상태로 복귀하자) " + memento);
				}
				
				try { Thread.sleep(1000); } catch (InterruptedException e) {}
				
				System.out.println();
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
