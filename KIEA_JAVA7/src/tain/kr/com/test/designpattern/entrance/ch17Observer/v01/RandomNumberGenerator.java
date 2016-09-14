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

import java.util.Date;
import java.util.Random;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RandomNumberGenerator.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch17Observer.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class RandomNumberGenerator extends NumberGenerator {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Random random;
	
	private int number;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public RandomNumberGenerator() {
		this.random = new Random(new Date().getTime());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public int getNumber() {
		return this.number;
	}
	
	@Override
	public void execute() {
		
		for (int i=0; i < 20; i++) {
			this.number = random.nextInt(50);
			notifyObservers();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
