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


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Factory.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 7. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class ItemFactory {

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static ItemFactory getFactory(String className) {
		ItemFactory factory = null;
		
		try {
			factory = (ItemFactory) Class.forName(className).newInstance();
		} catch (ClassNotFoundException e) {
			System.out.println("클래스 " + className + "이 발견되지 않습니다.");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return factory;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public abstract ItemLink createLink(String caption, String url);
	public abstract ItemTray createTray(String caption);
	public abstract ItemPage createPage(String title, String author);
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
