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
package tain.kr.com.test.param.v01;

import java.util.MissingResourceException;
import java.util.Properties;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Param.java
 *   -. Package    : tain.kr.com.test.param.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 11. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class Param {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Param.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected static final String FILE_NAME_RESOURCES = "resources/resources";

	protected final Properties prop;
	protected final ResourceBundle resourceBundle;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	private Param() {
		
		this.prop = System.getProperties();
		this.resourceBundle = ResourceBundle.getBundle(FILE_NAME_RESOURCES);

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String getStringFromSystem(String key) {
		return this.prop.getProperty(key);
	}
	
	private String getStringFromResourceBundle(String key) {
		
		String strValue = null;
		
		try {
			strValue = this.resourceBundle.getString(key);
		} catch (MissingResourceException e) {}
		
		return strValue;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getString(String key) {
		
		String value;
		
		value = getStringFromSystem(key);
		if (value != null)
			return value;
		
		value = getStringFromResourceBundle(key);
		
		return value;
	}
	
	public String getString(String key, String defaultValue) {
		
		String value = getString(key);
		if (value == null)
			return defaultValue;
		
		return value;
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
	
	private static Param instance = null;
	
	public static synchronized Param getInstance() throws Exception {
		
		if (Param.instance == null) {
			Param.instance = new Param();
		}
		
		return Param.instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {
			/*
			 * tain.project = CoSmarter version 1.02
			 * tain.company = TAIN, Inc.
			 * tain.copyright = Copyright 2014, 2015, 2016, 2017 TAIN, Inc. all rights reserved.
			 * tain.version = ver1.02
			 * tain.serial.key = 918X942YAAAZAA2K94C8
			 */
			
			if (flag) System.out.printf("[%s] = [%s]\n", "tain.project", Param.getInstance().getString("tain.project"));
			if (flag) System.out.printf("[%s] = [%s]\n", "tain.company", Param.getInstance().getString("tain.company"));
			if (flag) System.out.printf("[%s] = [%s]\n", "tain.copyright", Param.getInstance().getString("tain.copyright"));
			if (flag) System.out.printf("[%s] = [%s]\n", "tain.version", Param.getInstance().getString("tain.version"));
			if (flag) System.out.printf("[%s] = [%s]\n", "tain.serial.key", Param.getInstance().getString("tain.serial.key"));
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
