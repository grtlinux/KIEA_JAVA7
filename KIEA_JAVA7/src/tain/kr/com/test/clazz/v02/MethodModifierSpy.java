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

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.apache.log4j.Logger;

import static java.lang.System.out;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MethodModifierSpy.java
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
public class MethodModifierSpy {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MethodModifierSpy.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static int count;
	private static synchronized void inc() { count++; }
	private static synchronized int cnt() { return count; }

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : MethodModifierSpy
	 *   -. MethodName : main
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 8. 6. {time}
	 * </PRE>
	 *
	 * @param args
	 * 
	 * 
	 * $ java MethodModifierSpy java.lang.Object wait
	 * public final void java.lang.Object.wait() throws java.lang.InterruptedException
	 *   Modifiers:  public final
	 *   [ synthetic=false var_args=false bridge=false ]
	 * public final void java.lang.Object.wait(long,int)
	 *   throws java.lang.InterruptedException
	 *   Modifiers:  public final
	 *   [ synthetic=false var_args=false bridge=false ]
	 * public final native void java.lang.Object.wait(long)
	 *   throws java.lang.InterruptedException
	 *   Modifiers:  public final native
	 *   [ synthetic=false var_args=false bridge=false ]
	 * 3 matching overloads found
	 * 
	 * 
	 * $ java MethodModifierSpy java.lang.StrictMath toRadians
	 * public static double java.lang.StrictMath.toRadians(double)
	 *   Modifiers:  public static strictfp
	 *   [ synthetic=false var_args=false bridge=false ]
	 * 1 matching overload found
	 * 
	 * 
	 * $ java MethodModifierSpy MethodModifierSpy inc
	 * private synchronized void MethodModifierSpy.inc()
	 *   Modifiers: private synchronized
	 *   [ synthetic=false var_args=false bridge=false ]
	 * 1 matching overload found
	 * 
	 * 
	 * $ java MethodModifierSpy java.lang.Class getConstructor
	 * public java.lang.reflect.Constructor<T> java.lang.Class.getConstructor
	 *   (java.lang.Class<T>[]) throws java.lang.NoSuchMethodException,
	 *   java.lang.SecurityException
	 *   Modifiers: public transient
	 *   [ synthetic=false var_args=true bridge=false ]
	 * 1 matching overload found
	 * 
	 * 
	 * $ java MethodModifierSpy java.lang.String compareTo
	 * public int java.lang.String.compareTo(java.lang.String)
	 *   Modifiers: public
	 *   [ synthetic=false var_args=false bridge=false ]
	 * public int java.lang.String.compareTo(java.lang.Object)
	 *   Modifiers: public volatile
	 *   [ synthetic=true  var_args=false bridge=true  ]
	 * 2 matching overloads found
	 * 
	 * 
	 * 
	 */
	public static void main(String... args) {

		try {
			Class<?> c = Class.forName(args[0]);
			
			Method[] allMethods = c.getDeclaredMethods();
		
			for (Method m : allMethods) {
				if (!m.getName().equals(args[1])) {
					continue;
				}
				out.format("%s%n", m.toGenericString());
				out.format("  Modifiers:  %s%n", Modifier.toString(m.getModifiers()));
				out.format("  [ synthetic=%-5b var_args=%-5b bridge=%-5b ]%n", m.isSynthetic(), m.isVarArgs(), m.isBridge());
				inc();
			}
			
			out.format("%d matching overload%s found%n", cnt(), (cnt() == 1 ? "" : "s"));
	
			// production code should handle this exception more gracefully
		} catch (ClassNotFoundException x) {
			x.printStackTrace();
		}
	}
}
