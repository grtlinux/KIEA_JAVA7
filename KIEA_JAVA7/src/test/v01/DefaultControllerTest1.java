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
package test.v01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import tain.kr.com.test.junit.v02.DefaultController;
import tain.kr.com.test.junit.v02.Request;
import tain.kr.com.test.junit.v02.RequestHandler;
import tain.kr.com.test.junit.v02.Response;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DefaultControllerTest.java
 *   -. Package    : test.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DefaultControllerTest1 {

	private class SampleRequest implements Request {
		@Override
		public String getName() {
			return "Test";
		}
	}
	
	private class SampleHandler implements RequestHandler {
		@Override
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}
	
	private class SampleResponse implements Response {

		@Override
		public String getName() {
			return "SampleResponse";
		}
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private DefaultController controller;
	
	@Before
	public void instantiate() throws Exception {
		this.controller = new DefaultController(); 
	}
	
	@Test
	public void testMethod() {
		// throw new RuntimeException("implement me");
	}
	
	@Test
	public void testAddHandler() {
		Request request = new SampleRequest();
		RequestHandler handler = new SampleHandler();
		controller.addHandler(request, handler);
		
		RequestHandler handler2 = controller.getHandler(request);
		
		assertSame("Handler we set in controller should be the same handler we get", handler2, handler);
	}
	
	@Test
	public void testProcessRequest() {
		Request request = new SampleRequest();
		RequestHandler handler = new SampleHandler();
		controller.addHandler(request, handler);
		
		Response response = controller.processRequest(request);
		
		assertNotNull("Must not return a null response", response);
		assertEquals("response should be of type SampleResponse", SampleResponse.class, response.getClass());
	}
}
