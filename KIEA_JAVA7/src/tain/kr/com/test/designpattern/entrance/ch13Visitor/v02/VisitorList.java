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
package tain.kr.com.test.designpattern.entrance.ch13Visitor.v02;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : VisitorList.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch13Visitor.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 2. 6. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class VisitorList extends AbstVisitor {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(VisitorList.class);

	///////////////////////////////////////////////////////////////////////////////////////////////

	private String currentFolder = "";
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public VisitorList() {
		
		if (flag) log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public void visit(EntryFile file) {
		// print file info
		System.out.println(this.currentFolder + "/" + file);
	}
	
	@Override
	public void visit(EntryFolder folder) {
		// print folder info
		System.out.println(this.currentFolder + "/" + folder);
		
		String saveFolder = this.currentFolder;
		
		this.currentFolder = this.currentFolder + "/" + folder.getName();
		
		for (AcceptorAbstEntry entry : folder.getVector()) {
			entry.accept(this);
		}
		
		this.currentFolder = saveFolder;
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

}
