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

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.apache.log4j.Logger;

import tain.kr.com.test.spirit.v04.exception.ExpException;
import tain.kr.com.test.spirit.v04.exception.ExpIOException;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DataContent.java
 *   -. Package    : tain.kr.com.test.spirit.v04.data
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class DataContent extends AbsData {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DataContent.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private static final String TYP_CHARSET = "euc-kr";

	private String strData;

	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public DataContent() {

		super();

		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public DataContent(String strData) {
		this();

		setStrData(strData);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	public void setStrData(String strData) {
		this.strData = strData;

		byte[] bytSrc = this.strData.getBytes(Charset.forName(TYP_CHARSET));
		this.size = bytSrc.length;

		System.arraycopy(bytSrc, 0, this.bytData, 0, this.size);
	}

	public void setStrData() {
		this.strData = new String(this.bytData, 0, this.size, Charset.forName(TYP_CHARSET));
	}
	
	public String getStrData() {
		return this.strData;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public int readFromInputStream(InputStream is) throws ExpIOException {

		try {
			this.size = is.read(this.bytData);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ExpIOException();
		}

		if (this.size < 0) {
			throw new ExpIOException();
		}

		setStrData();
		
		return this.size;
	}

	@Override
	public void writeToOutputStream(OutputStream os) throws ExpException {

		try {
			os.write(this.bytData, 0, this.size);
			os.flush();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ExpException();
		}
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
