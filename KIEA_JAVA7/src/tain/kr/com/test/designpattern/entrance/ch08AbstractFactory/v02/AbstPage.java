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

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AbstPage.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbstPage {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(AbstPage.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String title;
	private final String author;
	
	private final Vector<AbstItem> content;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public AbstPage(String title, String author) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.title = title;
		this.author = author;
		this.content = new Vector<AbstItem>();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getTitle() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public Vector<AbstItem> getContent() {
		return this.content;
	}
	
	public void add(AbstItem item) {
		this.content.add(item);
	}
	
	public void output() {
		output("???");
	}
	
	public void output(String subTitle) {
		try {
			String fileName = "N:/" + title + "_" + subTitle + ".html";
			Writer writer = new FileWriter(fileName);
			writer.write(this.makeHtml());
			writer.close();
			
			System.out.println(fileName + " 파일을 작성했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract String makeHtml();
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
