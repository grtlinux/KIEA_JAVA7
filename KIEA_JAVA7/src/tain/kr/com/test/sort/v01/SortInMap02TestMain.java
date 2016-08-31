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
package tain.kr.com.test.sort.v01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SortInMap02TestMain.java
 *   -. Package    : tain.kr.com.test.sort.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 31. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SortInMap02TestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SortInMap02TestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 1. Native Method
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMap02TestMain
	 *   -. MethodName : test01
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 8. 31. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 */
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			Map<String, Integer> map = new HashMap<String, Integer>();

			map.put("a", 10);
			map.put("b", 30);
			map.put("c", 50);
			map.put("d", 40);
			map.put("e", 20);

			TreeMap<String, Integer> sortedMap = sortMapByValue(map);
			System.out.println(sortedMap);
		}
	}
	
	private static TreeMap<String, Integer> sortMapByValue(Map<String, Integer> map) {
		
		Comparator<String> comparator = new ValueComparator(map);
		// TreeMap is a map sorted by its keys
		// The comparator is used to sort the TreeMap by keys
		TreeMap<String, Integer> result = new TreeMap<String, Integer>(comparator);
		result.putAll(map);
		return result;
	}
	
	private static class ValueComparator implements Comparator<String> {
	
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		
		public ValueComparator(Map<String, Integer> map) {
			this.map.putAll(map);
		}
		
		@Override
		public int compare(String s1, String s2) {
			if (map.get(s1) >= map.get(s2)) {
				return -1;
			} else {
				return 1;
			}
		}
	}

	/**
	 * 2. More General Solution
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMap02TestMain
	 *   -. MethodName : test02
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 9. 1. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 */
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			
			Map<String, Integer> map = new HashMap<String, Integer>();

			map.put("a", 10);
			map.put("b", 30);
			map.put("c", 50);
			map.put("d", 40);
			map.put("e", 20);
			System.out.println(map);
			
			Map<String, Integer> sortedMap = sortByValue(map);
			System.out.println(sortedMap);
		}
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortedMap) {
		Map<String, Integer> sortedMap = new TreeMap<String, Integer>(new ValueComparator2(unsortedMap));
		sortedMap.putAll(unsortedMap);
		return sortedMap;
	}
	
	private static class ValueComparator2 implements Comparator<Object> {
		
		Map<String, Integer> map;
		
		public ValueComparator2(Map<String, Integer> map) {
			this.map = map;
		}
		
		@Override
		@SuppressWarnings({ "rawtypes", "unchecked" })
		public int compare(Object o1, Object o2) {
			Comparable val1 = (Comparable) this.map.get(o1);
			Comparable val2 = (Comparable) this.map.get(o2);
			return val2.compareTo(val1);
		}
	}
	
	/**
	 * 3. Using Generic Type
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMap02TestMain
	 *   -. MethodName : test03
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 9. 1. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 */
	private static void test03(String[] args) throws Exception {
		
		if (flag) {
			
		}
	}
	
	/**
	 * main method
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMap02TestMain
	 *   -. MethodName : main
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 9. 1. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);  // 1. Native Method
		
		if (!flag) test02(args);  // 2. More General Solution
		
		if (flag) test03(args);  // 3. Using Generic Type
	}
}
