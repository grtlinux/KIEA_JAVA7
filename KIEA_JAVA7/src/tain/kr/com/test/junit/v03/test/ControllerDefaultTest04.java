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

import org.junit.Before;
import org.junit.Test;

import tain.kr.com.test.junit.v03.ImpRequest;
import tain.kr.com.test.junit.v03.ImpRequestHandler;
import tain.kr.com.test.junit.v03.ImpResponse;


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

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequest#getName()
		 */
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private final class HandlerRequestTest implements ImpRequestHandler {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequestHandler#process(tain.kr.com.test.junit.v03.ImpRequest)
		 */
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private final class ResponseTest implements ImpResponse {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpResponse#getName()
		 */
		@Override
		public String getName() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
	
	private final class ExceptionHandler implements ImpRequestHandler {

		/* (non-Javadoc)
		 * @see tain.kr.com.test.junit.v03.ImpRequestHandler#process(tain.kr.com.test.junit.v03.ImpRequest)
		 */
		@Override
		public ImpResponse process(ImpRequest request) throws Exception {
			// TODO Auto-generated method stub
			return null;
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

	@Before
	public void initialize() throws Exception {
		
	}
	
	@Test
	public void testAddHandler() {
		
	}
	
	@Test
	public void testProcessResponse() {
		
	}
	
	@Test
	public void testProcessRequestAnswersErrorResponse() {
		
	}
	
	@Test ( expected = RuntimeException.class)
	public void testGetHandlerNotDefined() {
		
	}
	
	@Test ( expected = RuntimeException.class)
	public void testAddRequestDuplicateName() {
		
	}
}
