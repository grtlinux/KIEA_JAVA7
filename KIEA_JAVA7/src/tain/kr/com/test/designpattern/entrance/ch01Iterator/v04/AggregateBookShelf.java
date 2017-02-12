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
package tain.kr.com.test.designpattern.entrance.ch01Iterator.v04;

import java.util.Vector;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : AggregateBookShelf.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch01Iterator.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 12. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class AggregateBookShelf implements ImplAggregate {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(AggregateBookShelf.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Vector<Dep1Book> books;
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public AggregateBookShelf() {
		
		this.books = new Vector<Dep1Book>();
		
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch01Iterator.v04.ImplAggregate#add(tain.kr.com.test.designpattern.entrance.ch01Iterator.v04.Dep1Book)
	 */
	@Override
	public void add(Dep1Book book) {
		// TODO Auto-generated method stub
		this.books.add(book);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch01Iterator.v04.ImplAggregate#get(int)
	 */
	@Override
	public Dep1Book get(int index) {
		// TODO Auto-generated method stub
		return this.books.get(index);
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch01Iterator.v04.ImplAggregate#length()
	 */
	@Override
	public int length() {
		// TODO Auto-generated method stub
		return this.books.size();
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch01Iterator.v04.ImplAggregate#iterator()
	 */
	@Override
	public ImplIterator iterator() {
		// TODO Auto-generated method stub
		return new IteratorBookShelf(this);
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
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {

		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
