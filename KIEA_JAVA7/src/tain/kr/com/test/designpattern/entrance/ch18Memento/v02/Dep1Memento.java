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

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DepMemento.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch18Memento.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1Memento {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Memento.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int money;
	private final Vector<String> fruites;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Memento(int money) {
		
		if (!flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.money = money;
		this.fruites = new Vector<String>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getMoney() {
		return this.money;
	}
	
	public Vector<String> getFruits() {
		return this.fruites;
	}
	
	public void addFruit(String fruit) {
		this.fruites.add(fruit);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public String toString() {
		return String.format("Memento ##### [money = %d, fruits = %s]", this.money, this.fruites);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
