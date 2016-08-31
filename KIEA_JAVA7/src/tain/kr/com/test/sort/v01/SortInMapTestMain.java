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

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : SortInMapTestMain.java
 *   -. Package    : tain.kr.com.test.sort.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 31. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class SortInMapTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(SortInMapTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("printMap [" + entry.getKey() + "] => [" + entry.getValue() + "]");
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * ##### sort by key of map
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMapTestMain
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
			Map<String, String> map = new HashMap<String, String>();
			
			map.put("Z", "z");
			map.put("B", "b");
			map.put("A", "a");
			map.put("C", "c");
			map.put("D", "d");
			map.put("E", "e");
			map.put("Y", "y");
			map.put("N", "n");
			map.put("J", "j");
			map.put("M", "m");
			map.put("F", "f");
			
			/*
			 * HashMap
			 */
			System.out.println("##### HashMap #####");
			if (flag) printMap(map);
			
			if (!flag) {
				for (Entry<String, String> entry : map.entrySet()) {
					System.out.format("[%s] => [%s]%n", entry.getKey(), entry.getValue());
				}
			}
			
			/*
			 * TreeMap
			 */
			Map<String, String> treeMap = new TreeMap<String, String>(map);
			
			System.out.println("##### TreeMap #####");
			if (flag) printMap(treeMap);
			
			if (!flag) {
				for (Entry<String, String> entry : treeMap.entrySet()) {
					System.out.format("[%s] => [%s]%n", entry.getKey(), entry.getValue());
				}
			}
		}
		
		if (flag) {
			Map<Integer, String> map = new HashMap<Integer, String>();
			
			map.put(10, "z");
			map.put(5, "b");
			map.put(6, "a");
			map.put(20, "c");
			map.put(1, "d");
			map.put(7, "e");
			map.put(8, "y");
			map.put(99, "n");
			map.put(50, "j");
			map.put(2, "m");
			map.put(9, "f");
			
			/*
			 * HashMap
			 */
			System.out.println("##### HashMap #####");
			if (flag) printMap(map);
			
			if (!flag) {
				for (Entry<Integer, String> entry : map.entrySet()) {
					System.out.format("[%d] => [%s]%n", entry.getKey(), entry.getValue());
				}
			}
			
			/*
			 * TreeMap
			 */
			Map<Integer, String> treeMap = new TreeMap<Integer, String>(
					new Comparator<Integer>() {
						@Override
						public int compare(Integer o1, Integer o2) {
							return o2.compareTo(o1);
						}
					});
			treeMap.putAll(map);
			
			System.out.println("##### TreeMap #####");
			if (flag) printMap(treeMap);
			
			if (!flag) {
				for (Entry<Integer, String> entry : treeMap.entrySet()) {
					System.out.format("[%d] => [%s]%n", entry.getKey(), entry.getValue());
				}
			}
		}
	}
	
	/**
	 * ##### sort by value of map
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMapTestMain
	 *   -. MethodName : test02
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 8. 31. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 */
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			Map<String, Integer> unsortMap = new HashMap<String, Integer>();
			unsortMap.put("z", 10);
			unsortMap.put("b", 5);
			unsortMap.put("a", 6);
			unsortMap.put("c", 20);
			unsortMap.put("d", 1);
			unsortMap.put("e", 7);
			unsortMap.put("y", 8);
			unsortMap.put("n", 99);
			unsortMap.put("j", 50);
			unsortMap.put("m", 2);
			unsortMap.put("f", 9);

			System.out.println("\n\nUnsort Map......");
			printMap(unsortMap);

			System.out.println("\nSorted Map......By Value");
			Map<String, Integer> sortedMap = sortByValue(unsortMap);
			printMap(sortedMap);
		}
	}
	
	private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {

		// 1. Convert Map to List of Map
		List<Map.Entry<String, Integer>> list = new LinkedList<Map.Entry<String, Integer>>(unsortMap.entrySet());

		// 2. Sort list with Collections.sort(), provide a custom Comparator
		//    Try switch the o1 o2 position for a different order
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
			public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// 3. Loop the sorted list and put it into a new insertion order Map LinkedHashMap
		Map<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Map.Entry<String, Integer> entry : list) {
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/*
		//classic iterator example
		for (Iterator<Map.Entry<String, Integer>> it = list.iterator(); it.hasNext(); ) {
			Map.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}*/

		return sortedMap;
	}

	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue2(Map<K, V> unsortMap) {

		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(unsortMap.entrySet());

		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
			public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		Map<K, V> result = new LinkedHashMap<K, V>();
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}

		return result;
	}

	/**
	 * main method
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : SortInMapTestMain
	 *   -. MethodName : main
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 8. 31. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
