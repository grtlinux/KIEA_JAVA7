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
package tain.kr.com.test.spirit.v03.loop;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : LoopSleepArrInt.java
 *   -. Package    : tain.kr.com.test.spirit.v03.loop
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class LoopSleepArrInt implements ImplLoop {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(LoopSleepArrInt.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final int[] defInfo = {
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
	
	private final int[] info;

	private final int indexLimit;
	private int index;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public LoopSleepArrInt(int[] info) {
		
		if (info == null) {
			this.info = defInfo;
		} else {
			this.info = info;
		}
		
		this.indexLimit = this.info.length - 1;
		this.index = 0;
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public LoopSleepArrInt() {
		this(null);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.loop.ImplLoop#reset()
	 */
	@Override
	public void reset() {
		this.index = 0;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.loop.ImplLoop#sleep()
	 */
	@Override
	public void sleep() {
		
		try {
			Thread.sleep(this.info[this.index]);
		} catch (InterruptedException e) {}
		
		if (this.index < this.indexLimit)
			this.index ++;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.spirit.v03.loop.ImplLoop#getMSec()
	 */
	@Override
	public long getMSec() {

		long msec = this.info[this.index];
		
		if (this.index < this.indexLimit)
			this.index ++;
		
		return msec;
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
