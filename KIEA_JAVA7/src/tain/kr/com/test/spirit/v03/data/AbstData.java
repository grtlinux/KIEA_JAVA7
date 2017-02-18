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
package tain.kr.com.test.spirit.v03.data;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AbstData.java
 *   -. Package    : tain.kr.com.test.spirit.v03.data
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbstData {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(AbstData.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected final int[] defInfo = {
			10,   10,   10,   10,   10, 
			10,   10,   10,   10,   10,    // 10 * 10
			50,   50,   50,   50,   50,
			50,   50,   50,   50,   50,    // 10 * 50
			100,  100,  100,  100,  100, 
			100,  100,  100,  100,  100,   // 10 * 100
			500,  500,  500,  500,  500,
			500,  500,  500,  500,  500,   // 10 * 500
			1000, 1000, 1000, 1000, 1000, 
			1000, 1000, 1000, 1000, 1000,  // 10 * 100
			
			2000,                          // last
	};
	
	protected final int[] info;

	protected final int lastIndex;
	protected int index;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	protected AbstData(int[] info) {

		if (info == null)
			this.info = defInfo;
		else
			this.info = info;
		
		this.lastIndex = this.info.length - 1;
		this.index = 0;

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	protected AbstData() {
		this(null);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void reset() {
		this.index = 0;
	}
	
	public void sleep() {
		
		try {
			Thread.sleep((long) this.info[this.index]);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		if (this.index < this.lastIndex)
			this.index ++;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void sleep2() {
		
		long msec = (this.index / 10 + 1) * 100;
		
		try {
			Thread.sleep((long) msec);
		} catch (InterruptedException e) {
			// TODO: handle exception
		}
		
		if (this.index < 100)
			this.index ++;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {

		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
