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
package tain.kr.com.test.designpattern.entrance.ch06Prototype.v02;

import java.util.Hashtable;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Dep1Manager.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch06Prototype.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Dep1Manager {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Dep1Manager.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Hashtable<String, ImplProduct> showCase;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public Dep1Manager() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.showCase = new Hashtable<String, ImplProduct>();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public void register(String name, ImplProduct proto) {
		this.showCase.put(name, proto);
	}
	
	public ImplProduct create(String protoName) {
		ImplProduct product = (ImplProduct) this.showCase.get(protoName);
		return product.createClone();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}