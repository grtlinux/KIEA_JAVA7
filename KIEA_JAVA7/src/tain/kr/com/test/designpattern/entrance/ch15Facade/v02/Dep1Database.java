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
package tain.kr.com.test.designpattern.entrance.ch15Facade.v02;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1Database.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch15Facade.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1Database {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Database.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1Database() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static Properties getProperties(String dbName) {
		
		String fileName = "N:/" + dbName + ".txt";
		
		Properties properties = new Properties();
		
		try {
			properties.load(new FileInputStream(fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return properties;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ResourceBundle getResourceBundle(String dbName) {
		
		String className = new Object(){}.getClass().getEnclosingClass().getName().replace('.',  '/');
		String baseName = String.format("%s/database/%s", className.substring(0, className.lastIndexOf('/')), dbName);
		
		ResourceBundle resourceBundle = ResourceBundle.getBundle(baseName);
		
		return resourceBundle;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) new Dep1Database();
		
		if (flag) {
			
			String className = new Object(){}.getClass().getEnclosingClass().getName();
			if (flag) System.out.format("[%s]\n", className);
			
			String pathName = String.format("%s.database.%s", className.substring(0, className.lastIndexOf('.')), "email");
			if (flag) System.out.format("[%s]\n", pathName);
		}
		
		if (flag) {
			ResourceBundle resourceBundle;
			
			resourceBundle = Dep1Database.getResourceBundle("database");
			if (flag) System.out.format("[%s]\n", resourceBundle.getString("tain.kr.com.file.name"));
			if (flag) System.out.format("[%s]\n", resourceBundle.getString("c1@youngjin.com"));

			resourceBundle = Dep1Database.getResourceBundle("email");
			if (flag) System.out.format("[%s]\n", resourceBundle.getString("tain.kr.com.file.name"));
			if (flag) System.out.format("[%s]\n", resourceBundle.getString("c1@youngjin.com"));
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
