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
public class Dep2Gamer {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep2Gamer.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private int money;
	private Vector<String> fruits;
	
	private final Random random;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep2Gamer(int money) {
		
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
		"���",
		"����",
		"�ٳ���",
		"��",
	};
	
	public String getFruit() {
		String prefix = "";
		
		if (this.random.nextBoolean()) {
			prefix = "���ִ� ";
		}
		
		return prefix + fruitsName[this.random.nextInt(fruitsName.length)];
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void bet() {
		
		int dice = this.random.nextInt(6) + 1;
		
		if (dice == 1) {
			this.money += 100;
			System.out.println("���� �����߽��ϴ�.");
			
		} else if (dice == 2) {
			this.money /= 2;
			System.out.println("���� ������ �پ����ϴ�.");
			
		} else if (dice == 6) {
			String f = getFruit();
			this.fruits.add(f);
			System.out.println("����(" + f + ")�� �޾ҽ��ϴ�.");
			
		} else {
			System.out.println("�ƹ� �ϵ� �Ͼ�� �ʾҽ��ϴ�.");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Memento createMemento() {
		Dep1Memento memento = new Dep1Memento(this.money);
		
		for (String string : this.fruits) {
			if (string.startsWith("���ִ�")) {
				memento.addFruit(string);
			}
		}
		
		return memento;
	}
	
	public void restoreMemento(Dep1Memento memento) {
		this.money = memento.getMoney();
		this.fruits = memento.getFruits();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("[money = %d, fruits = %s]", this.money, this.fruits);
	}
}
