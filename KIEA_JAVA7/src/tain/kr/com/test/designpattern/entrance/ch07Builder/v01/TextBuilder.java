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
package tain.kr.com.test.designpattern.entrance.ch07Builder.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TestBuilder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch07Builder.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TextBuilder extends Builder {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final StringBuffer buffer;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public TextBuilder() {
		this.buffer = new StringBuffer();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void makeTitle(String title) {
		buffer.append("=========================================================\n");
		buffer.append("<" + title + ">\n");
		buffer.append("\n");
	}
	
	public void makeString(String string) {
		buffer.append("*" + string + "\n");
		buffer.append("\n");
	}
	
	public void makeItems(String[] items) {
		for (int i=0; i < items.length; i++) {
			buffer.append("-" + items[i] + "\n");
		}
		buffer.append("\n");
	}
	
	public Object getResult() {
		buffer.append("=========================================================\n");
		return buffer.toString();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
