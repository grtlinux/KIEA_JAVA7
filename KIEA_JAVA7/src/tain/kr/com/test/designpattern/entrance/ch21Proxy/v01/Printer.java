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
 *   -. FileName   : Printer.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch21Proxy.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Printer implements Printable {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String name;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Printer() {
		heavyJob("Printer의 인스턴스를 생성중");
	}
	
	public Printer(String name) {
		this.name = name;
		heavyJob("Printer의 인스턴스(" + this.name + ")를 생성중");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void setPrinterName(String name) {
		this.name = name;
	}
	
	@Override
	public String getPrinterName() {
		return this.name;
	}
	
	@Override
	public void print(String string) {
		System.out.println("=== " + this.name + " ===");
		System.out.println(string);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private void heavyJob(String msg) {
		System.out.print(msg);
		
		for (int i=0; i < 5; i++) {
			try { Thread.sleep(100); } catch (InterruptedException e) {}
			System.out.print(".");
		}
		
		System.out.println("완료.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
}
