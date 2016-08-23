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
package tain.kr.com.test.map.v01;

import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TreeMapTestMain.java
 *   -. Package    : tain.kr.com.test.map.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TreeMapTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TreeMapTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * the first of TreeMap
			 */
			Map<String, String> map = new TreeMap<String, String>();
			
			map.put("A", "11");
			map.put("D", "30");
			map.put("E", "30");
			map.put("C", "33");
			map.put("B", "20");

			map.put("F", "20");
			map.remove("F");
			
			System.out.println("> " + map);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * the second of TreeMap
			 */
			Map<CName, String> map = new TreeMap<CName, String>();
			
			map.put(new CName("AAA", 14), "Pictures");
			map.put(new CName("CCC", 11), "City");
			map.put(new CName("BBB", 21), "City");
			
			System.out.println("> " + map);
			
			for (CName cname : map.keySet()) {
				System.out.format("%s => %s%n", cname, map.get(cname));
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test03(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * transfer from HashSet to TreeSet
			 */
			Set<String> setHash = new HashSet<String>();

			String[] arrStr = new String[] { "±ËªÒ∞´", "»´±Êµø", "√·«‚¿Ã", "¿Ãµµ∑…", "«‚¥‹¿Ã", "±Ë¿ØΩ≈" };
			
			for (String str : arrStr) {
				setHash.add(str);
			}
			
			System.out.println("HashSet >> " + setHash);
			
			Set<String> setTree = new TreeSet<String>();
			setTree.addAll(setHash);

			System.out.println("TreeSet >> " + setTree);
		}

		if (flag) {
			/*
			 * transfer from HashMap to TreeMap
			 */
			Map<String, Integer> mapHash = new HashMap<String, Integer>();

			String[] arrStr = new String[] { "±ËªÒ∞´", "»´±Êµø", "√·«‚¿Ã", "¿Ãµµ∑…", "«‚¥‹¿Ã", "±Ë¿ØΩ≈" };
			int[] arrInt   = { 4, 2, 3, 6, 1, 8, 9 };
			
			for (int i=0; i < arrStr.length; i++) {
				mapHash.put(arrStr[i], arrInt[i]);
			}
			
			System.out.println("HashMap >> " + mapHash);
			
			Map<String, Integer> mapTree = new TreeMap<String, Integer>();
			mapTree.putAll(mapHash);

			System.out.println("TreeMap >> " + mapTree);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test04(String[] args) throws Exception {
		
		Score[] arrScore = new Score[] {
			new Score(21, 22)	,
			new Score(61, 62)	,
			new Score(81, 82)	,
			new Score(11, 12)	,
			new Score(31, 32)	,
		};
		
		if (flag) {
			/*
			 * transfer from HashSet to TreeSet
			 */
			Set<Score> setHash = new HashSet<Score>();

			for (Score score : arrScore) {
				setHash.add(score);
			}
			
			System.out.println("HashSet >> " + setHash);
			
			Set<Score> setTree = new TreeSet<Score>(new Comparator<Score>() {

				@Override
				public int compare(Score o1, Score o2) {
					
					int ret = o1.getSum() - o2.getSum();
					
					return ret;
				}
			});
			setTree.addAll(setHash);

			System.out.println("TreeSet >> " + setTree);
		}

		if (flag) {
			/*
			 * transfer from HashMap to TreeMap
			 */
			Map<Score, String> mapHash = new HashMap<Score, String>();

			String[] arrStr = new String[] { "±ËªÒ∞´", "»´±Êµø", "√·«‚¿Ã", "¿Ãµµ∑…", "±Ë¿ØΩ≈" };
			
			for (int i=0; i < arrScore.length; i++) {
				mapHash.put(arrScore[i], arrStr[i]);
			}
			
			System.out.println("HashMap >> " + mapHash);
			
			Map<Score, String> mapTree = new TreeMap<Score, String>(new MyComparator<Score>());
			mapTree.putAll(mapHash);

			System.out.println("TreeMap >> " + mapTree);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args); System.out.println();
		if (flag) test02(args); System.out.println();
		if (flag) test03(args); System.out.println();
		if (flag) test04(args); System.out.println();
	}
}


/*
 * class CName
 */
@SuppressWarnings("rawtypes")
class CName implements Comparable {
	
	private final String name;
	private final int age;
	
	public CName(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public String toString() {
		return String.format("('%s', %d)", this.getName(), this.getAge());
	}

	@Override
	public int compareTo(Object o) {
		
		if (o instanceof CName) {
			
			CName obj = (CName) o;
			
			int val = this.getName().compareTo(obj.getName());
			if (val != 0) {
				return val; 
			}
			
			Integer src = new Integer(this.getAge());
			Integer tgt = new Integer(obj.getAge());
			
			val = src.compareTo(tgt);
			if (val != 0) {
				return val;
			}
			
			return val;
		}

		return 0;
	}
}


/*
 * Class Score
 */
class Score {
	private final int sub1;
	private final int sub2;
	
	public Score(int sub1, int sub2) {
		this.sub1 = sub1;
		this.sub2 = sub2;
	}
	
	public int getSum() {
		return (this.sub1 + this.sub2);
	}
	
	public String toString() {
		return String.format("SUM=%d <- (%d, %d)", this.getSum(), this.sub1, this.sub2);
	}
}

/*
 * Class my Comparator
 */
class MyComparator<T> implements Comparator<T> {

	@Override
	public int compare(T o1, T o2) {
		Score s1 = (Score) o1;
		Score s2 = (Score) o2;
		
		int ret = s1.getSum() - s2.getSum();
		
		return ret;
	}
}




