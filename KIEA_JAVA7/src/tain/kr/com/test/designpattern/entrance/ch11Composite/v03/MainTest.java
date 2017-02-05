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
package tain.kr.com.test.designpattern.entrance.ch11Composite.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTest.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch11Composite.v03
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
			
			System.out.println("Making root entries...");
			
			AbstEntry rootdir = new EntryFolder("root");
			AbstEntry bindir = new EntryFolder("bin");
			AbstEntry tmpdir = new EntryFolder("tmp");
			AbstEntry usrdir = new EntryFolder("usr");
			
			rootdir.add(bindir);
			rootdir.add(tmpdir);
			rootdir.add(usrdir);
			
			bindir.add(new EntryFile("vi", 10000));
			bindir.add(new EntryFile("latex", 20000));
			
			rootdir.printList();
			
			System.out.println();
			
			System.out.println("Making user entries...");
			
			AbstEntry kim = new EntryFolder("kim");
			AbstEntry lee = new EntryFolder("lee");
			AbstEntry kang = new EntryFolder("kang");
			
			usrdir.add(kim);
			usrdir.add(lee);
			usrdir.add(kang);
			
			kim.add(new EntryFile("diary.html", 100));
			kim.add(new EntryFile("Composite.java", 200));
			lee.add(new EntryFile("memo.txt", 300));
			kang.add(new EntryFile("game.doc", 400));
			kang.add(new EntryFile("junk.mail", 500));
			
			rootdir.printList();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
