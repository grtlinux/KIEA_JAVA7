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
package tain.kr.com.test.gson.v02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest01.java
 *   -. Package    : tain.kr.com.test.gson.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest01 {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest01.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest01() {
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
	
	public static class Person {
		private String name = new String();
		private int age;
		private List<String> favoriteFood = new ArrayList<String>();
		private Map<String, String> etc = new HashMap<String, String>();
		
		public void print() {
			System.out.println();

			System.out.printf("\t[name]         = [%s]\n", this.name);
			System.out.printf("\t[age]          = [%s]\n", this.age);
			System.out.printf("\t[favoriteFood] = [%s]\n", this.favoriteFood);
			System.out.printf("\t[etc]          = [%s]\n", this.etc);
			
			System.out.println();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static class Obj {
		private int a;
		private int b;
		private String str;
		
		public int getA() {
			return this.a;
		}
		public int getB() {
			return this.b;
		}
		public String getStr() {
			return this.str;
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
			new MainTest01();

		if (flag) {
			/*
			 * TEST-1
			 */
			if (flag) log.debug(">>>>> >>>>> >>>>> TEST -1 <<<<< <<<<< <<<<<");
			
			String[] name = new String[] { "Name", "Age" };
			
			JsonObject obj1 = new JsonObject();
			obj1.addProperty(name[0], "AAAA");
			obj1.addProperty(name[1], "26");
			
			JsonObject obj2 = new JsonObject();
			obj2.addProperty(name[0], "BBBB");
			obj2.addProperty(name[1], "30");
			
			JsonArray arrObj = new JsonArray();
			arrObj.add(obj1);
			arrObj.add(obj2);
			
			JsonObject info = new JsonObject();
			info.add("information", arrObj);
			
			if (flag) System.out.printf("\n[%s]\n\n", info);
		}
		
		if (flag) {
			/*
			 * TEST-2
			 */
			if (flag) log.debug(">>>>> >>>>> >>>>> TEST -2 <<<<< <<<<< <<<<<");
			
			String jsonInfo = "{ 'name':'ȫ�浿', 'age':'25', 'favoriteFood':['��ġ������','�δ��','�����'], 'etc':{'email':'abc@naver.com','address':'xxx'} }";
			
			Gson gson = new Gson();
			Person person = gson.fromJson(jsonInfo, Person.class);
			person.print();
		}
		
		
		
		
		
		if (flag) {
			/*
			 * TEST-0
			 */
			if (flag) log.debug(">>>>> >>>>> >>>>> TEST -0 <<<<< <<<<< <<<<<");
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
