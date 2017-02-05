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
package tain.kr.com.test.designpattern.entrance.ch15Facade.v02;

import java.io.IOException;
import java.io.Writer;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1HtmlWriter.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch15Facade.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1HtmlWriter {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1HtmlWriter.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Writer writer;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep1HtmlWriter(Writer writer) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
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
		
		this.writer.write(sb.toString());
	}
	
	public void paragraph(String msg) throws IOException {
		
		this.writer.write("<p>" + msg + "</p>\n");
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
		
		this.writer.write(sb.toString());
		
		this.writer.close();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
