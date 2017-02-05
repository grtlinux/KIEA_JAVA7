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

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AbstItemTray.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch08AbstractFactory.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbstItemTray extends AbstItem {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(AbstItemTray.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Vector<AbstItem> tray;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public AbstItemTray(String caption) {
		
		super(caption);
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.tray = new Vector<AbstItem>();
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Vector<AbstItem> getItems() {
		return this.tray;
	}
	
	public void add(AbstItem item) {
		this.tray.addElement(item);
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
