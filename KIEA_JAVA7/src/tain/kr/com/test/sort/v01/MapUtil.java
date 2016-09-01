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

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MapUtil.java
 *   -. Package    : tain.kr.com.test.sort.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 1. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MapUtil {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MapUtil.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
	
		List<Map.Entry<K, V>> list = new LinkedList<Map.Entry<K, V>>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<K, V>>() {

			@Override
			public int compare(Entry<K, V> o1, Entry<K, V> o2) {
				return (o1.getValue()).compareTo(o2.getValue()) * (-1);
			}
		});
		
		Map<K, V> result = new LinkedHashMap<K, V>();
		
		for (Map.Entry<K, V> entry : list) {
			result.put(entry.getKey(), entry.getValue());
		}
		
		return result;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static <K, V> void printMap(Map<K, V> map) {
		for (Map.Entry<K, V> entry : map.entrySet()) {
			System.out.println("printMap [" + entry.getKey() + "] => [" + entry.getValue() + "]");
		}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
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
			unsortMap.put("k", 7);
			unsortMap.put("j", 50);
			unsortMap.put("m", 2);
			unsortMap.put("f", 9);

			System.out.println("\nUnsort Map......");
			printMap(unsortMap);

			System.out.println("\nSorted Map......By Value");
			Map<String, Integer> sortedMap = sortByValue(unsortMap);
			printMap(sortedMap);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
