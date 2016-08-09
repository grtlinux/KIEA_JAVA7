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
 *
 *
 *
 *     -------------- 클래스의 모든 method ------------------------------------------------------------------
 *
 *     Class<?> cl = Class.forName(className);
 *      while(cl != null) {
 *        for(Method m : cl.getDeclaredMethods()) {
 *          System.out.println(
 *            Mofifier.toString(m.getModifiers()) + " " +
 *            m.getReturnType().getCannonicalName() + " " +
 *            m.getName() +
 *            Arrays.toString(m.getParameters()));
 *        }
 *        cl.getSuperclass();
 *      }
 *
 *     ---------------- 클래스의 모든 필드 ----------------------------------------------------------------
 *
 *     Object obj = ...;
 *      for (Field f : obj.getClass().getDeclaredFields()) {
 *        f.setAccessible(true);
 *        Object value = f.get(obj);
 *        System.out.println(f.getName() + ":" + value);
 *      }
 *
 *     --------------------------------------------------------------------------------
 *
 *      Field f = obj.getDeclaredField("salary");
 *      f.setAccessible(true);
 *      double value = f.getDouble(obj);
 *      f.setDouble(obj, value * 1.1);
 *
 *     --------------------------------------------------------------------------------
 *
 *     Person p = ...;
 *      Method m = p.getClass().getMethod("setName", String.class);
 *      p.invoke(obj, "*******");
 *
 *     --------------------------------------------------------------------------------
 *
 *     정적 메서드를 호출할 때는 invoke 메서드의 첫 번째 인자에 null을 전달한다
 *
 *     --------------------------------------------------------------------------------
 *
 *     인자 없는 생성자가 포함된 객체를 생성하려면 Class 객체에서 newInstance만 호출하면 된다
 *
 *     Class<?> cl = ...;
 *      Object obj = cl.newInstance();
 *
 *     --------------------------------------------------------------------------------
 *
 *     또 다른 생성자를 호출하려면 먼저 Contructor 객체를 찾은 다음에 해당 객체의 newInstance 메서드를 호출해야 한다. 
 *     예를 들어, 어떤 클래스에 int 파리미터를 받는 공개 생성자가 이용하여 인스턴스를 다음과 같이 생성할 수 있다
 *
 *       Constructor constr = cl.getConstructor(int.class);
 *      Object obj = constr.newInstance(42);
 *
 *     --------------------------------------------------------------------------------
 *
 *     [출처] [Java] 리플렉션(Reflection) 사용하기 |작성자 zzozzo
 *
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

