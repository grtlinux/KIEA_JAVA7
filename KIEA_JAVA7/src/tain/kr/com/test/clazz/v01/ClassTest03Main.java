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
package tain.kr.com.test.clazz.v01;

import java.lang.reflect.Method;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ClassTest03Main.java
 *   -. Package    : tain.kr.com.test.clazz.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 2. 16. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ClassTest03Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ClassTest03Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
		Class<?> argTypes[] = new Class[2];
		argTypes[0] = Integer.TYPE;
		argTypes[1] = Integer.TYPE;
		Method method = cls.getMethod("add", argTypes);
		
		UseMethod obj = new UseMethod();
		Object argList[] = new Object[2];
		argList[0] = new Integer(27);
		argList[1] = new Integer(47);
		Object ret = method.invoke(obj, argList);
		
		Integer retVal = (Integer) ret;
		
		if (flag) log.debug(">" + retVal);
		if (flag) log.debug("\n-----------------------------------------------\n");
	}
	
	private static void test02(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
		Class<?> argTypes[] = new Class[2];
		argTypes[0] = Integer.TYPE;
		argTypes[1] = Integer.TYPE;
		Method method = cls.getMethod("add", argTypes);
		
		Object argList[] = new Object[2];
		argList[0] = new Integer(27);
		argList[1] = new Integer(47);
		Object ret = method.invoke(new UseMethod(), argList);
		
		Integer retVal = (Integer) ret;
		
		if (flag) log.debug(">" + retVal);
		if (flag) log.debug("\n-----------------------------------------------\n");
	}
	
	private static void test03(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
		Class<?> argTypes[] = new Class[5];
		argTypes[0] = Integer.TYPE;
		argTypes[1] = Integer.TYPE;
		argTypes[2] = int.class;
		argTypes[3] = double.class;
		argTypes[4] = float.class;
		
		Method method = cls.getMethod("add2", argTypes);
		
		Object argList[] = new Object[] {
			new Integer(27),
			new Integer(47),
			123,
			234.56,
			10.3f,
		};
		Object ret = method.invoke(new UseMethod(), argList);
		
		Integer retVal = (Integer) ret;
		
		if (flag) log.debug(">" + retVal);
		if (flag) log.debug("\n-----------------------------------------------\n");
	}
	
	private static void test04(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
		Method method = cls.getMethod("add", new Class[] { Integer.TYPE, Integer.TYPE });
		
		Integer ret = (Integer) method.invoke(new UseMethod(), new Object[] { new Integer(27), new Integer(57), });
		
		if (flag) log.debug(">" + ret);
		if (flag) log.debug("\n-----------------------------------------------\n");
	}
	
	/*
	 * Object obj = [Class].newInstance();
	 * Class<?> cls = obj.getClass();
	 * cls.getMethod([methodName], [parameterClass]).invoke(obj, [parameterValue]);
	 * 
	 * parameterClass
	 *     Class[] argType = new Class[] { int.class, double.class };
	 *     
	 * parameterValue
	 *     Object[] argValue = new Object[] { 123, 1234.56 };
	 */
	private static void test05(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
		// Method method = cls.getMethod("arrString", String[].class);
		// Method method = cls.getMethod("arrString", new Class[] { String[].class });
		Method method = cls.getDeclaredMethod("arrString", new Class[] { String[].class });
		
		// String ret = (String) method.invoke(cls.newInstance(), new Object[] { "One", "Two", "Three" });                 // ERROR : IllegalArgumentException : wrong number of arguments
		// String ret = (String) method.invoke(cls.newInstance(), new String[] { "One", "Two", "Three" });                 // ERROR : IllegalArgumentException : wrong number of arguments
		
		String[] arg = { "One", "Two", "Three" };
		String ret = (String) method.invoke(cls.newInstance(), new Object[] { arg });                                      // CORRECT 
		//String ret = (String) method.invoke(cls.newInstance(), new Object[] { new String[] {"One", "Two", "Three"} });   // CORRECT

		if (flag) log.debug(">" + ret);
		if (flag) log.debug("\n-----------------------------------------------\n");
	}
	
	private static void test06(String[] args) throws Exception
	{
		Class<?> cls = Class.forName("tain.kr.com.test.clazz.v01.UseMethod");
		Method method = cls.getDeclaredMethod("strAdd", new Class[] { String[].class });
		
		String[] arg = { "One", "Two", "Three", "Four", "Five" };
		String ret = (String) method.invoke(cls.newInstance(), new Object[] { arg });                                      // CORRECT 

		if (flag) log.debug(">" + ret);
		if (flag) log.debug("\n-----------------------------------------------\n");
	}
	
	public static void main(String[] args) throws Exception
	{
		if (flag) test01(args);
		if (flag) test02(args);
		if (flag) test03(args);
		if (flag) test04(args);
		if (flag) test05(args);
		if (flag) test06(args);
	}
}

class UseMethod
{
	public int add(int a, int b)
	{
		System.out.println("Addition....");
		return a + b;
	}
	
	public int add2(int a, int b, int c, double d, float e)
	{
		System.out.println("Addition-2..." + c + "," + d + "," + e);
		return a + b;
	}
	
	public String arrString(String[] arrStr)
	{
		StringBuffer sb = new StringBuffer();
		
		for (String str : arrStr) {
			sb.append(str);
			sb.append(',');
		}
		
		return sb.toString();
	}
	
	public static String strAdd(String[] arrStr) throws Exception
	{
		StringBuffer sb = new StringBuffer();
		
		for (String str : arrStr) {
			sb.append(str);
			sb.append(',');
		}
		
		return sb.toString();
	}
}
