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

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Vector;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ItemPage.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class ItemPage {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String title;
	private final String author;
	
	private final Vector<Item> content;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public ItemPage(String title, String author) {
		this.title = title;
		this.author = author;
		this.content = new Vector<Item>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getTitile() {
		return this.title;
	}
	
	public String getAuthor() {
		return this.author;
	}
	
	public Vector<Item> getContent() {
		return this.content;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void add(Item item) {
		this.content.add(item);
	}
	
	public void output() {
		try {
			String fileName = "N:/" + title + ".html";
			Writer writer = new FileWriter(fileName);
			writer.write(this.makeHtml());
			writer.close();
			
			System.out.println(fileName + " 파일을 작성했습니다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public abstract String makeHtml();
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
