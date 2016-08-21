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
package tain.kr.com.test.designpattern.entrance.ch04Factory.v01;

import java.util.Vector;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FactoryIDCard.java
 *   -. Package    : tain.kr.com.test.designpattern.entrance.ch04Factory.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 21. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class FactoryIDCard extends Factory {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final Vector<String> owners;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	protected FactoryIDCard() {
		this.owners = new Vector<String>();
	}
	
	public Vector<String> getOwners() {
		return this.owners;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	protected Product createProduct(String owner) {
		return new ProductIDCard(owner);
	}
	
	@Override
	protected void registerProduct(Product product) {
		this.owners.add(((ProductIDCard)product).getOwner());
	}
}
