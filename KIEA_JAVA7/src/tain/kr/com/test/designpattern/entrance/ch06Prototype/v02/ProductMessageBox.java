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
package tain.kr.com.test.designpattern.entrance.ch06Prototype.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ProductMessageBox.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch06Prototype.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ProductMessageBox implements ImplProduct {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(ProductMessageBox.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final char decoChar;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public ProductMessageBox(char decoChar) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.decoChar = decoChar;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void use(String string) {
		
		int length = string.getBytes().length;
		
		for (int i=0; i < length + 4; i++) {
			System.out.print(this.decoChar);
		}
		System.out.println();
		
		System.out.format("%c %s %c\n", this.decoChar, string, this.decoChar);
		
		for (int i=0; i < length + 4; i++) {
			System.out.print(this.decoChar);
		}
		System.out.println();
	}
	
	@Override
	public ImplProduct createClone() {
		
		ImplProduct product = null;
		
		try {
			product = (ImplProduct) clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		
		return product;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
