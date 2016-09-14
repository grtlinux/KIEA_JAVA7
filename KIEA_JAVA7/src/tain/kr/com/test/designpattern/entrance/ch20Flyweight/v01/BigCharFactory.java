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
package tain.kr.com.test.designpattern.entrance.ch20Flyweight.v01;

import java.util.Hashtable;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BigCharFactory.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BigCharFactory {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Hashtable<String, BigChar> pool;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private BigCharFactory() {
		this.pool = new Hashtable<String, BigChar>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public synchronized BigChar getBigChar(char charName) {
		
		BigChar bc = this.pool.get("" + charName);
		if (bc == null) {
			bc = new BigChar(charName);
			this.pool.put("" + charName, bc);
		}
		
		return bc;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
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
	///////////////////////////////////////////////////////////////////////////////////////////////

}
