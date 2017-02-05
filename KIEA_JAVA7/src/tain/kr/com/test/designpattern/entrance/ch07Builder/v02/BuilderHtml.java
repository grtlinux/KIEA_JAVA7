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
package tain.kr.com.test.designpattern.entrance.ch07Builder.v02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : BuilderHtml.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch07Builder.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class BuilderHtml extends AbstBuilder {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(BuilderHtml.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String fileName;
	private PrintWriter writer;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public BuilderHtml() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void makeTitle(String title) {
		
		this.fileName = "N:/" + title + ".html";
		try {
			this.writer = new PrintWriter(new FileWriter(this.fileName));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		this.writer.format("<html><head><title>%s</title></head><body>\n", title);
		
		this.writer.format("<h1>%s</h1>\n", title);
	}
	
	@Override
	public void makeString(String string) {
		this.writer.format("<p>%s</p>\n", string);
	}
	
	@Override
	public void makeItems(String[] items) {
		this.writer.println("<ul>");
		for (int i=0; i < items.length; i++) {
			this.writer.format("<li>%s</li>\n", items[i]);
		}
		this.writer.println("</ul>");
	}
	
	@Override
	public Object getResult() {
		this.writer.println("</body></html>\n");
		this.writer.close();
		
		return this.fileName;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
