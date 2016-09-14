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
package tain.kr.com.test.designpattern.entrance.ch15Facade.v01;

import java.io.IOException;
import java.io.Writer;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : HtmlWriter.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch15Facade.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class HtmlWriter {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Writer writer;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public HtmlWriter(Writer writer) {
		this.writer = writer;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void title(String title) throws IOException {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("<html>\n");
		sb.append("<head>\n");
		sb.append("<title>" + title + "</title>\n");
		sb.append("</head>\n");
		sb.append("<body>\n");
		sb.append("<h1>" + title + "</h1>\n");
		
		writer.write(sb.toString());
	}
	
	public void paragraph(String msg) throws IOException {
		
		writer.write("<p>" + msg + "</p>\n");
	}
	
	public void link(String href, String caption) throws IOException {
		
		paragraph("<a href='" + href + "'>" + caption + "</a>");
	}
	
	public void mailTo(String mailAddr, String userName) throws IOException {
		
		link("mailto:" + mailAddr, userName);
	}
	
	public void close() throws IOException {
		
		StringBuffer sb = new StringBuffer();
		
		sb.append("</body>\n");
		sb.append("</html>\n");
		
		writer.write(sb.toString());
		
		writer.close();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
