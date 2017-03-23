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
import tain.kr.com.test.junit.v03.ResponseError;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ControllerDefaultTest04.java
 *   -. Package    : tain.kr.com.test.junit.v03.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 23. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ControllerDefaultTest04 {

	private final class RequestTest implements ImpRequest {

		private static final String DEFAULT_NAME = "Test";
		private String name;
		
		public RequestTest(String name) {
			this.name = name;
		}
		
		public RequestTest() {
			this(DEFAULT_NAME);
		}
		
		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequest#getName()
		 */
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}
	}
	
	private final class HandlerRequestTest implements ImpRequestHandler {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequestHandler#process(tain.kr.com.test.junit.v03.ImpRequest)
		 */
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			// TODO Auto-generated method stub
			return new ResponseTest();
		}
	}
	
	private final class ResponseTest implements ImpResponse {

		private static final String name = "Test";
		
		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpResponse#getName()
		 */
		@SuppressWarnings("static-access")
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return this.name;
		}
		
		public boolean equals(Object object) {
			
			boolean result = false;
			
			if (object instanceof ResponseTest) {
				result = ((ResponseTest) object).getName().equals(this.getName());
			}
			
			return result;
		}
		
		public int hashCode() {
			return name.hashCode();
		}
	}
	
	private final class ExceptionHandler implements ImpRequestHandler {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequestHandler#process(tain.kr.com.test.junit.v03.ImpRequest)
		 */
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			// TODO Auto-generated method stub
			throw new Exception("error processing request.");
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
		this.request = new RequestTest();
		this.handler = new HandlerRequestTest();
		this.controller.addHandler(this.request, this.handler);
	}
	
	@Test
	public void testAddHandler() {
		
		ImpRequestHandler handler2 = this.controller.getHandler(this.request);
		assertSame("Handler we get in controller should be the same handler we get.", handler2, this.handler);
	}
	
	@Test
	public void testProcessResponse() {
		
		ImpResponse response = this.controller.getResponse(this.request);
		
		assertNotNull("Must not return a null response", response);
		assertEquals("response shuold be of type of ResponseTest", ResponseTest.class, response.getClass());
	}
	
	@Test
	public void testProcessRequestAnswersErrorResponse() {
		
		RequestTest request = new RequestTest("testError");
		ExceptionHandler handler = new ExceptionHandler();
		this.controller.addHandler(request, handler);
		ImpResponse response = this.controller.getResponse(request);
		
		assertNotNull("Must not return a null response", response);
		assertEquals("response", ResponseError.class, response.getClass());
	}
	
	@Test ( expected = RuntimeException.class)
	public void testGetHandlerNotDefined() {
		
		RequestTest request = new RequestTest("testNotDefined");
		
		// occured the event RuntimeException
		this.controller.getHandler(request);
	}
	
	@Test ( expected = RuntimeException.class)
	public void testAddRequestDuplicateName() {
		
		RequestTest request = new RequestTest();
		HandlerRequestTest handler = new HandlerRequestTest();
		
		// occured the event RuntimeException
		this.controller.addHandler(request, handler);
	}
}
