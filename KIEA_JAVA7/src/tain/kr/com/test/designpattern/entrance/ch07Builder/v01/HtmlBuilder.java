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

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : HtmlBuilder.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch07Builder.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class HtmlBuilder extends Builder {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String fileName;
	private PrintWriter writer;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void makeTitle(String title) {
		this.fileName = "N:/" + title + ".html";
		try {
			this.writer = new PrintWriter(new FileWriter(this.fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		writer.println("<html><head><title>" + title + "</title></head><body>");
		
		writer.println("<h1>" + title + "</h1>");
	}
	
	public void makeString(String string) {
		writer.println("<p>" + string + "</p>");
	}
	
	public void makeItems(String[] items) {
		writer.println("<ul>");
		for (int i=0; i < items.length; i++) {
			writer.println("<li>" + items[i] + "</li>");
		}
		writer.println("</ul>");
	}
	
	public Object getResult() {
		writer.println("</body></html>");
		writer.close();
		return this.fileName;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
