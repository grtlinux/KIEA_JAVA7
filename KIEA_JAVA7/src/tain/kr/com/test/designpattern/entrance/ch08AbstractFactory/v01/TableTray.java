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
package tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : TableTray.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class TableTray extends ItemTray {

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public TableTray(String caption) {
		super(caption);
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String makeHtml() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<td>\n");
		
		buffer.append("<table width='100%' border='1'><tr>\n");
		
		buffer.append("<td bgcolor='#cccccc' align='center' colspan='" + this.getItems().size() + "'><b>" + this.getCaption() + "</b></td>\n");
		buffer.append("</tr><tr>\n");
		
		for (Item item : this.getItems()) {
			buffer.append(item.makeHtml());
		}
		
		buffer.append("</tr></table>\n");
		
		buffer.append("</td>\n");
		
		return buffer.toString();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
