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
package tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PageTable.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PageTable extends AbstPage {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(PageTable.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public PageTable(String title, String author) {
		
		super(title, author);
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String makeHtml() {
		
		StringBuffer buffer = new StringBuffer();
		
		buffer.append("<html><head><title>" + this.getTitle() + "</title></head><body>\n");
		
		buffer.append("<h1>" + this.getTitle() + "</h1>");
		
		buffer.append("<table width='80%' border='3'>\n");
		
		for (AbstItem item : this.getContent()) {
			buffer.append("<tr>" + item.makeHtml() + "</tr>");
		}
		
		buffer.append("</table>\n");
		
		buffer.append("<hr><address>" + this.getAuthor() + "</address>\n");
		
		buffer.append("</body></html>\n");
		
		return buffer.toString();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
