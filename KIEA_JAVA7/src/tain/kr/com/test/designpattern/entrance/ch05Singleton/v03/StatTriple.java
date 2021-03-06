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
package tain.kr.com.test.designpattern.entrance.ch05Singleton.v03;

import java.util.Date;
import java.util.Random;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StatTriple.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch05Singleton.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StatTriple {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(StatTriple.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int id;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private StatTriple(int id) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName() + " - " + id);
		
		this.id = id;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public int getId() {
		return this.id;
	}
	
	@Override
	public String toString() {
		return String.format("[Triple id=%d]", this.id);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final int STAT_CNT = 3;
	private static StatTriple[] triple = null;
	private static Random random = new Random(new Date().getTime());
	
	public static StatTriple getInstance() {
		return getInstance(random.nextInt(STAT_CNT));
	}
	
	public static synchronized StatTriple getInstance(int id) {
		
		if (triple == null) {
			
			if (flag) {
				/*
				 * method 1
				 */
				triple = new StatTriple[] {
					new StatTriple(0),
					new StatTriple(1),
					new StatTriple(2),
				};
			} else {
				/*
				 * method 2
				 */
				triple = new StatTriple[STAT_CNT];
				
				for (int i=0; i < STAT_CNT; i++) {
					triple[i] = new StatTriple(i);
				}
			}
		}
		
		return triple[id];
	}
}
