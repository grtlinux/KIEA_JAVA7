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

import java.util.Random;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DepGamer.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch18Memento.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DepGamer {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DepGamer.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int money;
	private Vector<String> fruits;
	
	private final Random random;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public DepGamer(int money) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.money = money;
		this.fruits = new Vector<String>();
		
		this.random = new Random();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getMoney() {
		return this.money;
	}
	
	private static String[] fruitsName = {
		"사과",
		"포도",
		"바나나",
		"귤",
	};
	
	public String getFruit() {
		String prefix = "";
		
		if (this.random.nextBoolean()) {
			prefix = "맛있다. ";
		}
		
		return prefix + fruitsName[this.random.nextInt(fruitsName.length)];
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void bet() {
		
		int dice = this.random.nextInt(6) + 1;
		
		if (dice == 1) {
			this.money += 100;
			System.out.println("돈이 증가했습니다.");
			
		} else if (dice == 2) {
			this.money /= 2;
			System.out.println("돈이 반으로 줄었습니다.");
			
		} else if (dice == 6) {
			String f = getFruit();
			this.fruits.add(f);
			System.out.println("과일(" + f + ")을 받았습니다.");
			
		} else {
			System.out.println("아무 일도 일어나지 않았습니다.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public DepMemento createMemento() {
		DepMemento memento = new DepMemento(this.money);
		
		for (String string : this.fruits) {
			if (string.startsWith("맛있다")) {
				memento.addFruit(string);
			}
		}
		
		return memento;
	}
	
	public void restoreMemento(DepMemento memento) {
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("[money = %d, fruits = %s]", this.money, this.fruits);
	}
}
