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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

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
 *   -. FileName   : DefaultControllerTest3.java
 *   -. Package    : test.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DefaultControllerTest3 {

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private class SampleRequest implements Request {
		@Override
		public String getName() {
			return "Test";
		}
	}
	
	public class SampleHandler implements RequestHandler {
		@Override
		public Response process(Request request) throws Exception {
			return new SampleResponse();
		}
	}
	
	private class SampleResponse implements Response {
		
		private static final String name = "Test";
		
		@Override
		@SuppressWarnings("static-access")
		public String getName() {
			return this.name;
		}
		
		public boolean equals(Object object) {
			boolean result = false;
			
			if (object instanceof SampleResponse) {
				result = ((SampleResponse) object).getName().equals(this.getName());
			}
			
			return result;
		}
		
		public int hashCode() {
			return name.hashCode();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	private DefaultController controller;
	private Request request;
	private RequestHandler handler;
	
	@Before
	public void initialize() throws Exception {
		
		this.controller = new DefaultController();
		this.request = new SampleRequest();
		this.handler = new SampleHandler();
		this.controller.addHandler(request, handler);
	}
	
	@Test
	public void testAddHandler() {
		
		RequestHandler handler2 = this.controller.getHandler(request);
		assertSame("Handler we set in controller should be the same handler we get", handler2, this.handler);
	}
	
	@Test
	public void testProcessResponse() {
		
		Response response = controller.processRequest(request);
		
		assertNotNull("Must not return a null response", response);
		assertEquals("response should be of type SampleResponse", SampleResponse.class, response.getClass());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
}
