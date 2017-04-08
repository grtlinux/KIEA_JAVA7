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
package tain.kr.com.test.junit.v04.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import tain.kr.com.test.junit.v04.Controller;
import tain.kr.com.test.junit.v04.ErrorResponse;
import tain.kr.com.test.junit.v04.ImpRequest;
import tain.kr.com.test.junit.v04.ImpRequestHandler;
import tain.kr.com.test.junit.v04.ImpResponse;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ControllerDefaultTest05.java
 *   -. Package    : tain.kr.com.test.junit.v04.test
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class ControllerDefaultTest05 {

	private final class RequestTest implements ImpRequest {
		
		private static final String DEFAULT_NAME = "Test";
		private String name;
		
		public RequestTest(String name) {
			this.name = name;
		}
		
		public RequestTest() {
			this(DEFAULT_NAME);
		}
		
		@Override
		public String getName() {
			return this.name;
		}
		
		public int hashCode() {
			return this.name.hashCode();
		}
	}
	
	private final class ResponseTest implements ImpResponse {
		
		private final String name = "Test";
		
		@Override
		public String getName() {
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
			return this.name.hashCode();
		}
	}
	
	private final class RequestHandlerTest implements ImpRequestHandler {
		
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			return new ResponseTest();
		}
	}
	
	private final class ExceptionHandler implements ImpRequestHandler {
		
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			throw new Exception("error processing request..");
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
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Test public void testTest() {}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private Controller controller;
	private RequestTest request;
	private RequestHandlerTest handler;
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Before
	public void initialize() throws Exception {
		
		this.controller = new Controller();
		this.request = new RequestTest();
		this.handler = new RequestHandlerTest();
		this.controller.addHandler(this.request, this.handler);
	}
	
	@Test
	public void testAddHandler() {
		
		ImpRequestHandler handler2 = this.controller.getHandler(this.request);
		
		assertSame("handler we get in controller should be the same controller we get.", handler2, this.handler);
	}
	
	@Test
	public void testProcessResponse() {
		
		ImpResponse response = this.controller.getResponse(this.request);
		
		assertNotNull("must not return a null response.", response);
		assertEquals("response should be of type ResponseTest", ResponseTest.class, response.getClass());
	}
	
	@Test
	public void testProcessRequestAnswerErrorResponse() {
		
		ImpRequest request = new RequestTest("testError");
		ImpRequestHandler handler = new ExceptionHandler();
		this.controller.addHandler(request, handler);
		ImpResponse response = this.controller.getResponse(request);
		
		assertNotNull("must not return a null response.", response);
		assertEquals("equals", ErrorResponse.class, response.getClass());
	}
	
	@Test ( expected = RuntimeException.class )
	public void testGetHandlerNotDefined() {
		
		ImpRequest request = new RequestTest("testNotDefined");
		
		// occured the event RuntimeException
		this.controller.getHandler(request);
	}
	
	@Test ( expected = RuntimeException.class )
	public void testAddRequestDuplication() {
		
		ImpRequest request = new RequestTest();
		ImpRequestHandler handler = new RequestHandlerTest();
		
		// occured the event RuntimeException
		this.controller.addHandler(request, handler);
	}
	
	@Test ( timeout = 10 )    // milliseconds
	//@Ignore ( value = "Skip for now" )
	@Ignore
	public void testProcessMultipleRequestsTimeout() {
		
		ImpRequest request;
		ImpResponse response = new ResponseTest();
		ImpRequestHandler handler = new RequestHandlerTest();
		
		for (int i=0; i < 99999; i++) {
			request = new RequestTest(String.valueOf(i));
			this.controller.addHandler(request, handler);
			response = this.controller.getResponse(request);
			
			assertNotNull(response);
			assertNotSame(ErrorResponse.class, response.getClass());
		}
	}
}
