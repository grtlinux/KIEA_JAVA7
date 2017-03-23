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
package tain.kr.com.test.junit.v03.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Test;

import tain.kr.com.test.junit.v03.ControllerDefault;
import tain.kr.com.test.junit.v03.ImpRequest;
import tain.kr.com.test.junit.v03.ImpRequestHandler;
import tain.kr.com.test.junit.v03.ImpResponse;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ControllerDefaultTest03.java
 *   -. Package    : tain.kr.com.test.junit.v03.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ControllerDefaultTest03 {

	private final class SimpleRequest implements ImpRequest {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequest#getName()
		 */
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "TestRequest";
		}
		
	}
	
	private final class SimpleHandler implements ImpRequestHandler {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequestHandler#process(tain.kr.com.test.junit.v03.ImpRequest)
		 */
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			// TODO Auto-generated method stub
			return new SimpleResponse();
		}
		
	}
	
	private final class SimpleResponse implements ImpResponse {

		private static final String name = "TestResponse";
		
		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpResponse#getName()
		 */
		@Override
		@SuppressWarnings("static-access")
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}
		
		public boolean equals(Object object) {
			
			boolean result = false;
			
			if (object instanceof SimpleResponse) {
				result = ((SimpleResponse) object).getName().equals(this.getName());
			}
			
			return result;
		}
		
		public int hashCode() {
			
			return name.hashCode();
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
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private ControllerDefault controller;
	private ImpRequest request;
	private ImpRequestHandler handler;
	
	@Before
	public void initialize() throws Exception {
		
		this.controller = new ControllerDefault();
		this.request = new SimpleRequest();
		this.handler = new SimpleHandler();
		this.controller.addHandler(this.request, this.handler);
	}
	
	@Test
	public void testAddHandler() {
		
		ImpRequestHandler handler2 = this.controller.getHandler(this.request);
		assertSame("Handler we set in controller should be the same handler we get", handler2, this.handler);
	}
	
	@Test
	public void testProcessResponse() {
		
		ImpResponse response = this.controller.getResponse(this.request);
		
		assertNotNull("Must not return a null response", response);
		assertEquals("response should be of type SimpleResponse", SimpleResponse.class, response.getClass());
	}
}
