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
package tain.kr.com.test.designpattern.entrance.ch14ChainofResponsibility.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AbstSupport.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch14ChainofResponsibility.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class AbstSupport {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(AbstSupport.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private AbstSupport next;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public AbstSupport(String name) {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
		
		this.name = name;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public AbstSupport setNext(AbstSupport next) {
		
		this.next = next;
		return next;
	}
	
	public String getName() {
		return this.name;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public final void support(Dep1Trouble trouble) {
		
		if (resolve(trouble)) {
			done(trouble);
		} else if (this.next != null) {
			this.next.support(trouble);
		} else {
			fail(trouble);
		}
	}
	
	protected abstract boolean resolve(Dep1Trouble trouble);
	
	protected void done(Dep1Trouble trouble) {
		System.out.println(trouble + " is resolved by " + this + ".");
	}
	
	protected void fail(Dep1Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public String toString() {
		return String.format("[%s]", this.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
