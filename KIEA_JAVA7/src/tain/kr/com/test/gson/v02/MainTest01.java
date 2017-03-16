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
			System.out.printf("\t[favoriteFood] = %s\n", this.favoriteFood);
			System.out.printf("\t[etc]          = %s\n", this.etc);
			
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
		
		public String toString() {
			return String.format("{ %d, %d, '%s' }", a, b, str);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static abstract class AbsEntry {
		private String name = new String();
		
		public AbsEntry(String name) {
			this.name = name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public abstract void add(AbsEntry entry) throws Exception;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static class SystemEntry extends AbsEntry {
		private List<AbsEntry> lstEntry = new ArrayList<AbsEntry>();
		
		public SystemEntry(String name) {
			super(name);
		}
		
		public void setLstEntry(List<AbsEntry> lstEntry) {
			this.lstEntry = lstEntry;
		}
		
		public List<AbsEntry> getLstEntry() {
			return this.lstEntry;
		}
		
		@Override
		public void add(AbsEntry entry) throws Exception {
			this.lstEntry.add(entry);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static class FolderEntry extends AbsEntry {
		private String desc = new String();
		private List<AbsEntry> lstEntry = new ArrayList<AbsEntry>();
		
		public FolderEntry(String name, String desc) {
			super(name);
			this.desc = desc;
		}
		
		public FolderEntry(String name) {
			this(name, "NO_DESC");
		}
		
		public void setDesc(String desc) {
			this.desc = desc;
		}
		
		public void setLstEntry(List<AbsEntry> lstEntry) {
			this.lstEntry = lstEntry;
		}
		
		public String getDesc() {
			return this.desc;
		}
		
		public List<AbsEntry> getLstEntry() {
			return this.lstEntry;
		}
		
		@Override
		public void add(AbsEntry entry) throws Exception {
			this.lstEntry.add(entry);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static class FileEntry extends AbsEntry {
		private long size = 0;
		private long date = 0;
		
		public FileEntry(String name, long size, long date) {
			super(name);
			
			this.size = size;
			this.date = date;
		}
		
		public void setSize(long size) {
			this.size = size;
		}
		
		public void setDate(long date) {
			this.date = date;
		}
		
		public long getSize() {
			return this.size;
		}
		
		public long getDate() {
			return this.date;
		}
		
		@Override
		public void add(AbsEntry entry) throws Exception {
			throw new Exception("couldn't do the action method 'add'");
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
			
			String jsonInfo = "{ 'name':'È«±æµ¿', 'age':'25', 'favoriteFood':['±èÄ¡ººÀ½¹ä','ºÎ´ëÂî°³','ºñºö¹ä'], 'etc':{'email':'abc@naver.com','address':'xxx'} }";
			
			Gson gson = new Gson();
			Person person = gson.fromJson(jsonInfo, Person.class);
			person.print();
		}
		
		if (flag) {
			/*
			 * TEST-3
			 */
			if (flag) log.debug(">>>>> >>>>> >>>>> TEST -3 <<<<< <<<<< <<<<<");
			
			if (flag) System.out.println();
			
			Obj obj = new Obj();
			obj.setA(10);
			obj.setB(123);
			obj.setStr("Hello, World...");
			
			Gson gson = new Gson();
			String strGson = gson.toJson(obj);
			if (flag) System.out.printf("\t%s\n\n", strGson);
			
			Obj objGson = gson.fromJson(strGson, Obj.class);
			if (flag) System.out.printf("\t%s\n\n", objGson);
		}
		
		if (flag) {
			/*
			 * TEST-4
			 */
			if (flag) log.debug(">>>>> >>>>> >>>>> TEST -4 <<<<< <<<<< <<<<<");
			
			AbsEntry kang   = new FileEntry("kang", 2025, 100);
			AbsEntry kim    = new FileEntry("kim",  2025, 100);
			AbsEntry java   = new FileEntry("java", 2025, 100);
			AbsEntry apache = new FileEntry("apache", 2025, 100);
			AbsEntry maven  = new FileEntry("maven", 2025, 100);
			AbsEntry tty    = new FileEntry("tty", 2025, 100);
			AbsEntry dev    = new FileEntry("dev", 2025, 100);
			AbsEntry test01 = new FileEntry("test01", 2025, 100);
			
			AbsEntry root = new FolderEntry("root", "root desc");
			AbsEntry home = new FolderEntry("home", "home desc");
			AbsEntry usr  = new FolderEntry("usr", "usr desc");
			AbsEntry var  = new FolderEntry("var", "var desc");
			AbsEntry tmp  = new FolderEntry("tmp", "tmp desc");
			
			AbsEntry system = new SystemEntry("system");
			
			/*
			 * do jobs
			 */
			system.add(root);
			
			root.add(home);
			root.add(usr);
			root.add(var);
			root.add(tmp);
			
			home.add(kang);
			home.add(kim);
			
			usr.add(java);
			usr.add(apache);
			usr.add(maven);
			
			var.add(tty);
			var.add(dev);
			
			tmp.add(test01);
			
			/*
			 * Gson
			 */
			Gson gson = new Gson();
			String strGson = gson.toJson(system);
			if (flag) System.out.printf("%s\n\n", strGson);
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
