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
package tain.kr.com.test.designpattern.entrance.ch01Iterator.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : IteratorBookShelf.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch01Iterator.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 5. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class IteratorBookShelf implements ImplIterator {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(IteratorBookShelf.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final ImplAggregate aggregate;
	private int index;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public IteratorBookShelf(ImplAggregate aggregate) {
		
		if (flag) log.debug(">>>>> " + this.getClass().getSimpleName());
		
		this.aggregate = aggregate;
		this.index = 0;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public boolean hasNext() {

		if (this.index < this.aggregate.length()) {
			return true;
		}
		return false;
	}

	@Override
	public Object next() {
		
		Dep1Book book = this.aggregate.get(this.index);
		this.index ++;
		return book;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
