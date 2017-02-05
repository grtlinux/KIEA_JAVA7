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
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class MainTest {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public MainTest() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) new MainTest();
		
		if (flag) {
			String className = "tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02.FactoryList";
			
			AbstFactory factory = AbstFactory.getFactory(className);
			
			AbstItemLink joins = factory.createLink("중앙일보", "http://www.joins.com/");
			AbstItemLink hani = factory.createLink("한겨레 신문", "http://www.hani.co.kr/");

			AbstItemLink us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com");
			AbstItemLink kr_yahoo = factory.createLink("Yahoo!Korea", "http://www.yahoo.co.kr/");
			AbstItemLink excite = factory.createLink("Excite", "http://www.excite.com/");
			AbstItemLink google = factory.createLink("Google", "http://www.google.com/");
			
			AbstItemTray trayNews = factory.createTray("신문");
			trayNews.add(joins);
			trayNews.add(hani);
			
			AbstItemTray trayYahoo = factory.createTray("Yahoo!");
			trayYahoo.add(us_yahoo);
			trayYahoo.add(kr_yahoo);
			
			AbstItemTray traySearch = factory.createTray("서치엔진");
			traySearch.add(trayYahoo);
			traySearch.add(excite);
			traySearch.add(google);
			
			AbstPage page = factory.createPage("LinkPage", "홍길동");
			page.add(trayNews);
			page.add(traySearch);

			page.output("list");
		}
		
		if (flag) {
			String className = "tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02.FactoryTable";
			
			AbstFactory factory = AbstFactory.getFactory(className);
			
			AbstItemLink joins = factory.createLink("중앙일보", "http://www.joins.com/");
			AbstItemLink hani = factory.createLink("한겨레 신문", "http://www.hani.co.kr/");

			AbstItemLink us_yahoo = factory.createLink("Yahoo!", "http://www.yahoo.com");
			AbstItemLink kr_yahoo = factory.createLink("Yahoo!Korea", "http://www.yahoo.co.kr/");
			AbstItemLink excite = factory.createLink("Excite", "http://www.excite.com/");
			AbstItemLink google = factory.createLink("Google", "http://www.google.com/");
			
			AbstItemTray trayNews = factory.createTray("신문");
			trayNews.add(joins);
			trayNews.add(hani);
			
			AbstItemTray trayYahoo = factory.createTray("Yahoo!");
			trayYahoo.add(us_yahoo);
			trayYahoo.add(kr_yahoo);
			
			AbstItemTray traySearch = factory.createTray("서치엔진");
			traySearch.add(trayYahoo);
			traySearch.add(excite);
			traySearch.add(google);
			
			AbstPage page = factory.createPage("LinkPage", "홍길동");
			page.add(trayNews);
			page.add(traySearch);

			page.output("table");
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
