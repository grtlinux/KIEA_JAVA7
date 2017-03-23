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
 *   -. FileName   : ControllerDefaultTest01.java
 *   -. Package    : tain.kr.com.test.junit.v03.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ControllerDefaultTest01 {

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

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpResponse#getName()
		 */
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return "TestResponse";
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

	@Before
	public void instantiate() throws Exception {
		this.controller = new ControllerDefault();
	}
	
	@Test
	public void testAddHandler() {
		ImpRequest request = new SimpleRequest();
		ImpRequestHandler handler = new SimpleHandler();
		this.controller.addHandler(request, handler);
		
		ImpRequestHandler handler2 = this.controller.getHandler(request);
		
		assertSame("Handler we set in controller should be the same handler we get", handler2, handler);
	}
	
	@Test
	public void testProcessRequest() {
		ImpRequest request = new SimpleRequest();
		ImpRequestHandler handler = new SimpleHandler();
		this.controller.addHandler(request, handler);
		
		ImpResponse response = this.controller.getResponse(request);
		
		assertNotNull("Must not return a null response", response);
		assertEquals("response should be of type SimpleResponse", SimpleResponse.class, response.getClass());
	}
}
