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
package tain.kr.com.test.designpattern.entrance.ch13Visitor.v03;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : VisitorList.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch13Visitor.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 14. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class VisitorList extends AbstVisitor {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(VisitorList.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public VisitorList() {
		if (!flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private String currentFolder = "";
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.designpattern.entrance.ch13Visitor.v03.AbstVisitor#visit(tain.kr.com.test.designpattern.entrance.ch13Visitor.v03.AbstAcceptorEntry)
	 */
	@Override
	public void visit(AbstAcceptorEntry entry) {
		// TODO Auto-generated method stub
		
		if (entry instanceof EntryFile) {
			EntryFile entryFile = (EntryFile) entry;
			
			System.out.printf("%s/%s\n", this.currentFolder, entryFile);
			
		} else if (entry instanceof EntryFolder) {
			EntryFolder entryFolder = (EntryFolder) entry;

			System.out.printf("%s/%s\n", this.currentFolder, entryFolder);
			
			String saveFolder = this.currentFolder;
			
			this.currentFolder = this.currentFolder + "/" + entryFolder.getName();
			
			for (AbstAcceptorEntry ent : entryFolder.getEntries()) {
				ent.accept(this);
			}
			
			this.currentFolder = saveFolder;
		} else {
			throw new ExpFileTreatmentException();
		}
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
