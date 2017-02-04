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
package tain.kr.com.test.designpattern.entrance.ch20Flyweight.v02;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BigChar.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch20Flyweight.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 4. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BigChar {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(BigChar.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final char charName;
	private String fontData;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BigChar(char charName) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName() + " (" + charName + ")");
		
		this.charName = charName;
		
		try {
			StringBuffer sb = new StringBuffer();
			
			String path = "N:/chars";
			// String path = this.getClass().getEnclosingClass().getName().replace('.', '/') + "/chars";
			//String path = "tain.kr.com.test.designpattern.entrance.ch20Flyweight.v02".replace('.', '/') + "/chars";
			//if (flag) log.debug(">>>>> " + path);
			
			BufferedReader reader = new BufferedReader(new FileReader(path + "/big" + this.charName + ".txt"));
			String line;
			while ((line = reader.readLine()) != null) {
				sb.append(line + "\n");
			}
			reader.close();
			
			this.fontData = sb.toString();
			
		} catch (IOException e) {
			this.fontData = charName + "?\n";
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void print() {
		System.out.print(this.fontData);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
