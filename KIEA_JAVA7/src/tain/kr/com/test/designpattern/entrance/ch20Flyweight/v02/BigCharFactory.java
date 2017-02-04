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
package tain.kr.com.test.designpattern.entrance.ch20Flyweight.v02;

import java.util.Hashtable;

import org.apache.log4j.Logger;

import tain.kr.com.test.designpattern.entrance.ch20Flyweight.v01.BigChar;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BigCharFactory.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch20Flyweight.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 4. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BigCharFactory {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(BigCharFactory.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Hashtable<String, BigChar> pool;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private BigCharFactory() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.pool = new Hashtable<String, BigChar>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public synchronized BigChar getBigChar(char charName) {
		
		BigChar bigChar = this.pool.get("" + charName);
		if (bigChar == null) {
			bigChar = new BigChar(charName);
			this.pool.put("" + charName, bigChar);
		}
		
		return bigChar;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static BigCharFactory instance = null;
	
	public static synchronized BigCharFactory getInstance() {
		
		if (instance == null) {
			instance = new BigCharFactory();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
