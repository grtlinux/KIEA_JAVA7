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
package tain.kr.com.test.designpattern.entrance.ch21Proxy.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PrintablePrinter.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch21Proxy.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PrintablePrinter implements ImplPrintable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(PrintablePrinter.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public PrintablePrinter() {
		this("null");
	}
	
	public PrintablePrinter(String name) {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.name = name;
		
		heavyJob("Printer의 인스턴스(" + this.name + ")를 생성중");
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private void heavyJob(String msg) {
		
		System.out.print(msg);
		
		for (int i=0; i < 5; i++) {
			try { Thread.sleep(1000); } catch (InterruptedException e) {}
			System.out.print('.');
		}
		System.out.println("완료.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch21Proxy.v03.ImplPrintable#setPrinterName(java.lang.String)
	 */
	@Override
	public void setPrinterName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch21Proxy.v03.ImplPrintable#getPrinterName()
	 */
	@Override
	public String getPrinterName() {
		// TODO Auto-generated method stub
		return this.name;
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch21Proxy.v03.ImplPrintable#print(java.lang.String)
	 */
	@Override
	public void print(String string) {
		// TODO Auto-generated method stub
		System.out.println("=== " + this.name + " ===");
		System.out.println(string);
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

		if (flag)
			new PrintablePrinter();

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
