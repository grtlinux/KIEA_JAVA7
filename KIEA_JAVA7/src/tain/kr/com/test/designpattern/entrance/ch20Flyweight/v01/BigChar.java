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
package tain.kr.com.test.designpattern.entrance.ch20Flyweight.v01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BigChar.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch19State.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 15. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BigChar {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final char charName;
	private String fontData;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BigChar(char charName) {
		
		this.charName = charName;
		
		try {
			BufferedReader reader = new BufferedReader(new FileReader("N:/chars/" + "big" + this.charName + ".txt"));
			
			StringBuffer sb = new StringBuffer();
			
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			
			this.fontData = sb.toString();
			
		} catch (IOException e) {
			this.fontData = charName + "?";
		}
	}
	
	public void print() {
		System.out.print(this.fontData);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
