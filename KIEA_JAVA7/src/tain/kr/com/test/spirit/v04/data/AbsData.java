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
package tain.kr.com.test.spirit.v04.data;

import java.io.InputStream;
import java.io.OutputStream;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v04.exception.ExpException;
import tain.kr.com.test.spirit.v04.exception.ExpIOException;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AbstData.java
 *   -. Package    : tain.kr.com.test.spirit.v04.data
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbsData  implements Cloneable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(AbsData.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	protected static final int SIZ_BYTDATA = 4096;
	// private static final int SIZ_BYTDATA = 20;
	
	protected final byte[] bytData;
	protected int size = 0;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public AbsData(int size) {
		
		this.bytData = new byte[size];
		
		if (!flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public AbsData() {
		this(SIZ_BYTDATA);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public byte[] getBytData() {
		return this.bytData;
	}

	public int getSize() {
		return this.size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public abstract int readFromInputStream(InputStream is) throws ExpIOException;
	public abstract void writeToOutputStream(OutputStream os) throws ExpException;
	public abstract DataContent createClone();

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
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {

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
