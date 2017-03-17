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
package tain.kr.com.test.designpattern.entrance.ch18Memento.v01;

import java.util.Random;
import java.util.Vector;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Gamer.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch18Memento.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Gamer {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int money;
	
	private Vector<String> fruits;
	private final Random random;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Gamer(int money) {
		this.money = money;
		
		this.fruits = new Vector<String>();
		this.random = new Random();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getMoney() {
		return this.money;
	}
	
	public void bet() {
		
		int dice = random.nextInt(6) + 1;
		if (dice == 1) {
			money += 100;
			System.out.println("���� �����߽��ϴ�.");
		} else if (dice == 2) {
			money /= 2;
			System.out.println("���� ������ �پ����ϴ�.");
		} else if (dice == 6) {
			String f = getFruit();
			System.out.println("����(" + f + ")�� �޾ҽ��ϴ�.");
			fruits.add(f);
		} else {
			System.out.println("�ƹ��ϵ� �Ͼ�� �ʾҽ��ϴ�.");
		}
	}
	
	private static String[] fruitsName = {
		"���",
		"����",
		"�ٳ���",
		"��",
	};
	
	private String getFruit() {
		String prefix = "";
		
		if (random.nextBoolean()) {
			prefix = "���ִ�";
		}
		
		return prefix + fruitsName[this.random.nextInt(fruitsName.length)];
	}
	
	public Memento createMemento() {
		
		Memento m = new Memento(money);
		
		for (String string : fruits) {
			if (string.startsWith("���ִ�")) {
				m.addFruit(string);
			}
		}
		
		return m;
	}
	
	public void restoreMemento(Memento memento) {
		
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
	
		return String.format("[money = %d, fruits = %s]", this.money, this.fruits);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
