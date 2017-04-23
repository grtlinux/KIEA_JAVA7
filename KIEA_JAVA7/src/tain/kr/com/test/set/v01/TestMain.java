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
package tain.kr.com.test.set.v01;

import java.util.Date;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestMain.java
 *   -. Package    : tain.kr.com.test.set.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public TestMain() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
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

		if (flag)
			new TestMain();

		if (flag) {
			/*
			 * begin
			 */
			Set<Integer> setNum = new TreeSet<Integer>();
			
			Random random = new Random(new Date().getTime());
			
			for (int i=0; i < 24; i++) {
				setNum.add(random.nextInt(24));
			}
			
			if (flag) {
				/*
				 * use the for loop
				 */
				int i = 0;
				System.out.println("---------------------- use the for loop ---------------------------");
				for (Integer num : setNum) {
					System.out.printf("%2d [%02d]\n", ++i, num);
				}
				System.out.println("-------------------------------------------------");
			}
			
			if (flag) {
				/*
				 * use the iterator loop
				 */
				Iterator<Integer> iter = setNum.iterator();
				int i = 0;
				System.out.println("---------------------- use the iterator loop ---------------------------");
				while (iter.hasNext()) {
					System.out.printf("%2d [%02d]\n", ++i, iter.next());
				}
				System.out.println("-------------------------------------------------");
			}
			
			if (flag) {
				/*
				 * use the array
				 */
				Integer[] num = setNum.toArray(new Integer[setNum.size()]);
				
				System.out.println("---------------------- use the array ---------------------------");
				for (int i=0; i < num.length; i++) {
					System.out.printf("%2d [%02d]\n", i+1, num[i]);
				}
				System.out.println("-------------------------------------------------");
			}
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
