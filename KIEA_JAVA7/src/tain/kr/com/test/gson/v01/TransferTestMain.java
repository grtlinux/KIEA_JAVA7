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
package tain.kr.com.test.gson.v01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TransferTestMain.java
 *   -. Package    : tain.kr.com.test.gson.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 5. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TransferTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(TransferTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			String jsonFile = "{ 'name':'È«±æµ¿', 'age':'25', 'favoriteFood':['±èÄ¡ººÀ½¹ä','ºÎ´ëÂî°³','ºñºö¹ä'], 'etc':{'email':'abc@naver.com','address':'xxx'} }";
			
			Gson gson = new Gson();
			Person person = gson.fromJson(jsonFile, Person.class);
			person.print();
		}
	}
	
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			Obj obj = new Obj();
			obj.setA(10);
			obj.setB(123);
			obj.setStr("Hello World...");
			
			Gson gson = new Gson();
			String strGson = gson.toJson(obj);
			System.out.println(">" + strGson);
			
			Obj objGson = gson.fromJson(strGson, Obj.class);
			System.out.println(">" + objGson.getStr());
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
}

class Person {
	private String name = new String();
	private int age;
	private List<String> favoriteFood = new ArrayList<String>();
	private Map<String, String> etc = new HashMap<String, String>();
	
	public void print() {
		System.out.println("name = " + this.name);
		System.out.println("age = " + this.age);
		System.out.println("favoriteFood = " + this.favoriteFood);
		System.out.println("etc = " + this.etc);
	}
}

class Obj {
	private int a;
	private int b;
	private String str;
	
	public int getA() {
		return a;
	}
	public int getB() {
		return b;
	}
	public String getStr() {
		return str;
	}
	public void setA(int a) {
		this.a = a;
	}
	public void setB(int b) {
		this.b = b;
	}
	public void setStr(String str) {
		this.str = str;
	}
}

