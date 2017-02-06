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
 *   -. FileName   : PrintableProxy.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch21Proxy.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PrintableProxy implements ImplPrintable {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(PrintableProxy.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	private PrintablePrinter realPrinter = null;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public PrintableProxy() {
		this("null");
	}
	
	public PrintableProxy(String name) {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.name = name;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private synchronized void realize() {
		
		if (this.realPrinter == null) {
			this.realPrinter = new PrintablePrinter(this.name);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch21Proxy.v03.ImplPrintable#setPrinterName(java.lang.String)
	 */
	@Override
	public void setPrinterName(String name) {
		// TODO Auto-generated method stub
		if (this.realPrinter != null) {
			this.realPrinter.setPrinterName(name);
		}
		
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
		realize();
		this.realPrinter.print(string);
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag)
			new PrintableProxy();

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
