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

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : InvokeMain.java
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
public class InvokeMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(InvokeMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/**
	 * 
	 * Code Templates > Comments > Methods
	 *
	 * <PRE>
	 *   -. ClassName  : InvokeMain
	 *   -. MethodName : main
	 *   -. Comment    :
	 *   -. Author     : taincokr
	 *   -. First Date : 2016. 8. 6. {time}
	 * </PRE>
	 *
	 * @param args
	 * @throws Exception
	 * 
	 * 
	 * $ java InvokeMain Deet Deet ja JP JP
	 * 
	 * invoking Deet.main()
	 * invoking testDeet()
	 * Local = Japaness (Japen.JP),
	 * ISO Language Code = jpn
	 * testDeet() returned true
	 * 
	 * 
	 */
	public static void main(String... args) throws Exception {
		
		String className = "";

		try {
			Class<?> c = Class.forName(className);
			
			@SuppressWarnings("rawtypes")
			Class[] argTypes = new Class[] { String[].class };
			
			Method main = c.getDeclaredMethod("main", argTypes);

			String[] mainArgs = Arrays.copyOfRange(args, 1, args.length);
			
			System.out.format("invoking %s.main()%n", c.getName());
			
			main.invoke(null, (Object) mainArgs);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
