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
package tain.kr.com.test.classLoader.v01;

import java.io.DataInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MyClassLoader.java
 *   -. Package    : tain.kr.com.test.classLoader.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MyClassLoader extends ClassLoader {

	private static boolean flag = true;

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MyClassLoader(ClassLoader classLoader) {
		super(classLoader);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Class<?> loadClass(String name) throws ClassNotFoundException {
		
		if (flag) System.out.println("로드 시작(" + name + ")");
		
		if (name.startsWith("tain.kr.com.test.classLoader.v01")) {
			if (flag) System.out.println("\t\t--> by MyClassLoader");
			return getClass(name);
		}
		
		return super.loadClass(name);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Class<?> getClass(String name) throws ClassNotFoundException {
		
		String file = name.replace('.', File.separatorChar) + ".class";
		byte[] buf = null;
		try {
			buf = loadBytes(file);
			Class<?> cls = defineClass(name, buf, 0, buf.length);
			resolveClass(cls);
			return cls;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private byte[] loadBytes(String name) throws IOException {
		
		InputStream is = getClass().getClassLoader().getResourceAsStream(name);
		
		int size = is.available();
		byte[] buff = new byte[size];
		
		DataInputStream dis = new DataInputStream(is);
		dis.readFully(buff);
		dis.close();
		
		return buff;
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
}
