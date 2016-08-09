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
package tain.kr.com.test.clazz.v03;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ThreadDemoMain.java
 *   -. Package    : tain.kr.com.test.clazz.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ThreadDemoMain extends Thread {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ThreadDemoMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ThreadDemoMain(String name) throws Exception {
		
		if (flag) log.debug(">>>>> name = " + name);
	}
	
	public void run() {
		
		if (flag) log.debug(">>>>> run() method");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception
	{
		if (!flag) {
			/*
			 * execute thread
			 */
			Thread thr = new ThreadDemoMain("TESTING");
			thr.start();
		}
		
		if (flag) {
			/*
			 * use class
			 * elements class, constructor, run method
			 */
			
			// class
			Class<?> cls = Class.forName("tain.kr.com.test.clazz.v03.ThreadDemoMain");
			
			// constructor argument types
			Class<?>[] types = new Class[] { String.class };
			Object[] constructorArgs = new Object[] { "STRING_ARG" };

			// execute constructor
			Constructor<?> constructor = cls.getConstructor(types);
			Object instance = constructor.newInstance(constructorArgs);
			
			// execute run method of thread
			//Method method = cls.getMethod("run");
			Method method = cls.getMethod("start");
			method.invoke(instance);
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

