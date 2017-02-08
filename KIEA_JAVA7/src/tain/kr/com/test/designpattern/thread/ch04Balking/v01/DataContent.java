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
package tain.kr.com.test.designpattern.thread.ch04Balking.v01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DataContent.java
 *   -. Package    : tain.kr.com.test.designpattern.thread.ch04Balking.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class DataContent extends AbstData {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(DataContent.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String fileName;
	private String content;
	private boolean changed;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public DataContent(String fileName, String content) {
		
		this.fileName = fileName;
		this.content = content;
		this.changed = true;
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.thread.ch04Balking.v01.AbstData#change(java.lang.String)
	 */
	@Override
	public synchronized void change(String content) {
		// TODO Auto-generated method stub
		this.content = content;
		this.changed = true;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.thread.ch04Balking.v01.AbstData#save()
	 */
	@Override
	public synchronized void save() throws IOException {
		// TODO Auto-generated method stub
		if (!this.changed) {
			return;
		}
		
		doSave();
		
		this.changed = false;
	}

	private void doSave() throws IOException {
		
		if (flag) System.out.printf("%s calls doSave(), content = %s\n", Thread.currentThread().getName(), this.content);
		
		Writer writer = new FileWriter("result/" + this.fileName);
		writer.write(this.content);
		writer.close();
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