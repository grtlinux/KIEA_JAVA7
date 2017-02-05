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

import java.io.FileWriter;
import java.io.IOException;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep2PageMaker.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch15Facade.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep2PageMaker {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep2PageMaker.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Dep2PageMaker() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void makeWelcomePage(String mailAddr, String fileName) {
		
		try {
			ResourceBundle resourceBundle = Dep1Database.getResourceBundle("email");
			
			String userName = resourceBundle.getString(mailAddr);
			
			Dep1HtmlWriter writer = new Dep1HtmlWriter(new FileWriter(fileName));
			
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

}
