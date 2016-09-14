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

import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PageMaker.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch15Facade.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PageMaker {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private PageMaker() {}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void makeWelcomePage(String mailAddr, String fileName) {
		
		try {
			Properties mailProp = Database.getProperties("mailData");
			
			String userName = mailProp.getProperty(mailAddr);
			
			HtmlWriter writer = new HtmlWriter(new FileWriter(fileName));
			
			writer.title("Welcome to " + userName + "'s page!");
			writer.paragraph(userName + "의 페이지에 오신걸 환영합니다.");
			writer.paragraph("메일이 기다리고 있겠습니다.");
			writer.mailTo(mailAddr, userName);
			
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
