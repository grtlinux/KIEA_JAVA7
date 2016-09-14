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
package tain.kr.com.test.designpattern.entrance.ch17Observer.v01;

import java.util.Vector;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : NumberGenerator.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch17Observer.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class NumberGenerator {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Vector<Observer> observers;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public NumberGenerator() {
		this.observers = new Vector<Observer>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public final Vector<Observer> getObservers() {
		return this.observers;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public final void addObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public final void deleteObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	public final void notifyObservers() {
		for (Observer observer : this.observers) {
			observer.update(this);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract int getNumber();
	public abstract void execute();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
