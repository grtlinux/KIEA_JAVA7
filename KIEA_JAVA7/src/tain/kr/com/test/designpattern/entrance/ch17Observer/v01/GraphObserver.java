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

import java.util.Arrays;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : GraphObserver.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch17Observer.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class GraphObserver implements Observer {

	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void update(NumberGenerator generator) {
		
		if (!flag) {
			
			System.out.print("GraphObserver : ");
			
			int number = generator.getNumber();
			
			for (int i=0; i < number; i++) {
				System.out.print("#");
			}
			
			System.out.println();
			
			try { Thread.sleep(100); } catch (InterruptedException e) {}
		}
		
		if (flag) {
			
			int number = generator.getNumber();
			
			byte[] bytGraph = new byte[number];
			
			Arrays.fill(bytGraph, (byte) '#');
			
			System.out.println("GraphObserver : " + new String(bytGraph));

			try { Thread.sleep(100); } catch (InterruptedException e) {}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
