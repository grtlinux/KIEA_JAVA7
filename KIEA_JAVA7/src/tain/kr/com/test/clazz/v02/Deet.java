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
package tain.kr.com.test.clazz.v02;

import static java.lang.System.err;
import static java.lang.System.out;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.Locale;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Deet.java
 *   -. Package    : tain.kr.com.test.clazz.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 *
 * http://docs.oracle.com/javase/tutorial/reflect/member/index.html
 * 
 */
@SuppressWarnings("unused")
public class Deet<T> {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Deet.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private boolean testDeet(Locale l) {
		// geISO3Language() may throw a missingResourceException
		out.format("Local = %s, ISO Language Code = %s%n", l.getDisplayName(), l.getISO3Language());
		return true;
	}
	
	private int testFoo(Locale l) {
		return 0;
	}
	
	private boolean testBar() {
		return true;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : Deet
	 *   -. MethodName : main
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 8. 6. {time}
	 * </PRE>
	 *
	 * @param args
	 * 
	 * 
	 * $ java Deet Deet ja JP JP
	 * invoking testDeet()
	 * Locale = Japanese (Japan,JP),
	 * ISO Language Code = jpn
	 * testDeet() returned true
	 * 
	 * 
	 * $ java Deet Deet xx XX XX
	 * invoking testDeet()
	 * invocation of testDeet failed:
	 * Couldn't find 3-letter language code for xx
	 * 
	 * 
	 */
	public static void main(String... args) {
		
		if (args.length != 4) {
			err.format("Usage: java Deet <classname> <language> <country> <variant>%n");
			// return;
			System.exit(0);
		}
		
		try {
			Class<?> c = Class.forName(args[0]);
			Object t = c.newInstance();
			
			Method[] allMethods = c.getDeclaredMethods();
			
			for (Method m : allMethods) {
				String mName = m.getName();
				
				if (!mName.startsWith("test") || (m.getGenericReturnType() != boolean.class)) {
					continue;
				}
				
				Type[] pType = m.getGenericParameterTypes();
				if ((pType.length != 1) || Locale.class.isAssignableFrom(pType[0].getClass())) {
					continue;
				}
				
				out.format("invoking %s()%n", mName);
				
				try {
					m.setAccessible(true);
					Object o = m.invoke(t, new Locale(args[1], args[2], args[3]));
					out.format("%s() returned %b%n", mName, o);
					
					// Handle any exceptions thrown by method to be invoked.
				} catch (InvocationTargetException e) {
					Throwable cause = e.getCause();
					err.format("invocation of %s failed: %s%n", mName, cause.getMessage());
				}
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
