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
package tain.kr.com.test.designpattern.entrance.ch14ChainofResponsibility.v01;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Support.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch14ChainofResponsibility.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 9. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public abstract class Support {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final String name;
	private Support next;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Support(String name) {
		this.name = name;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public Support setNext(Support next) {
		this.next = next;
		return next;
	}
	
	public String getName() {
		return this.name;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public final void support(Trouble trouble) {
		
		if (resolve(trouble)) {
			done(trouble);
		} else if (next != null) {
			next.support(trouble);
		} else {
			fail(trouble);
		}
	}
	
	protected abstract boolean resolve(Trouble trouble);
	
	protected void done(Trouble trouble) {
		System.out.println(trouble + " is resolved by " + this + ".");
	}
	
	protected void fail(Trouble trouble) {
		System.out.println(trouble + " cannot be resolved.");
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public String toString() {
		return String.format("[%s]", this.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

}
