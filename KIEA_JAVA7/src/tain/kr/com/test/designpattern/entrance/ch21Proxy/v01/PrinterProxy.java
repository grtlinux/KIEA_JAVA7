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
package tain.kr.com.test.designpattern.entrance.ch21Proxy.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PrinterProxy.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch21Proxy.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PrinterProxy implements Printable {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	private Printer real;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public PrinterProxy() {
	}
	
	public PrinterProxy(String name) {
		this.name = name;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public synchronized void setPrinterName(String name) {
		if (this.real != null) {
			this.real.setPrinterName(name);
		}
		this.name = name;
	}
	
	@Override
	public String getPrinterName() {
		return this.name;
	}
	
	@Override
	public void print(String string) {
		realize();
		this.real.print(string);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private synchronized void realize() {
		if (this.real == null) {
			this.real = new Printer(this.name);
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
