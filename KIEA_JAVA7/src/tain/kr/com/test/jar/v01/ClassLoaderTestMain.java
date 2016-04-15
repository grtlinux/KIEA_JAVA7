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
package tain.kr.com.test.jar.v01;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.Properties;
import java.util.jar.JarFile;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ClassLoaderTestMain.java
 *   -. Package    : tain.kr.com.test.jar.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 4. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ClassLoaderTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ClassLoaderTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static String getProperty(String filePath, String keyName) {
		String value = null;
		
		try {
			Properties props = new Properties();
			FileInputStream fis = new FileInputStream(filePath);
			props.load(new BufferedInputStream(fis));
			value = props.getProperty(keyName).trim();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return value;
	}
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			ClassLoader classLoader = null;
			classLoader = Thread.currentThread().getContextClassLoader();
			if (flag) log.debug(">>>>> " + classLoader);
			if (flag) log.debug(">>>>> " + classLoader.getResource("."));

			classLoader = classLoader.getParent();
			if (flag) log.debug(">>>>> " + classLoader);
			if (flag) log.debug(">>>>> " + classLoader.getResource("."));

			classLoader = classLoader.getParent();
			if (flag) log.debug(">>>>> " + classLoader);
			if (flag) log.debug(">>>>> " + classLoader.getResource("."));

			//classLoader = classLoader.getParent();              // ERROR
			//if (flag) log.debug(">>>>> " + classLoader);
			
			classLoader = ClassLoader.getSystemClassLoader();
			if (flag) log.debug(">>>>> " + classLoader);
		}
		
		if (!flag) {
			String filePath = "";
			ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
			
			if (classLoader == null) {
				classLoader = ClassLoader.getSystemClassLoader();
				
				URL url = classLoader.getResource("board.properties");
				if (url == null) {
					System.out.println("null");
				} else {
					filePath = url.getPath();
					System.out.println("PATH = " + filePath);
				}
				
				String info = getProperty(filePath, "datasource");
				System.out.println("INFO = " + info);
			}
		}
		
		if (!flag) {
			ClassLoader classLoader = null;
			classLoader = Thread.currentThread().getContextClassLoader();
			if (flag) log.debug(">>>>> " + classLoader);
			if (flag) log.debug(">>>>> " + classLoader.getResource("."));
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			/*
			 * 16.04.15
			 */
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("META-INF/MANIFEST.MF");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				log.debug(">>> " + url.toString());
			}

			System.out.println();
		}
		
		if (flag) {
			/*
			 * 16.04.15
			 */
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("META-INF");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				log.debug(">>> " + url.toString());
			}

			System.out.println();
		}

		if (flag) {
			/*
			 * 16.04.15
			 */
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources("WebPageInfo.properties");
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				log.debug(">>> " + url.toString());
			}

			System.out.println();
		}

		if (flag) {
			/*
			 * 16.04.15
			 */
			Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(JarFile.MANIFEST_NAME);   // META-INF/MANIFEST.MF
			while (urls.hasMoreElements()) {
				URL url = urls.nextElement();
				log.debug(">>> " + url.toString());
			}

			System.out.println();
		}

		if (flag) {
			/*
			 * 16.04.15
			 */
			Class<ClassLoaderTestMain> clazz = ClassLoaderTestMain.class;
			
			URL url = clazz.getResource(".");
			if (flag) log.debug(">>>>> " + url);
			
			ClassLoader classLoader = clazz.getClassLoader();
			Enumeration<URL> urls = classLoader.getResources(".");
			while (urls.hasMoreElements()) {
				url = urls.nextElement();
				if (flag) log.debug(">>>>> " + url);
			}

			System.out.println();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (flag) test02(args);
	}
}
