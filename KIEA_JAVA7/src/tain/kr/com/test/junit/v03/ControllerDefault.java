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
package tain.kr.com.test.junit.v03;

import java.util.HashMap;
import java.util.Map;


/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : ControllerDefault.java
 *   -. Package    : tain.kr.com.test.junit.v03
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 22. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class ControllerDefault implements ImpController {

	private Map<String, ImpRequestHandler> requestHandlers = new HashMap<String, ImpRequestHandler>();
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see tain.kr.com.test.junit.v03.ImpController#addHandler(tain.kr.com.test.junit.v03.ImpRequest, tain.kr.com.test.junit.v03.ImpRequestHandler)
	 */
	@Override
	public void addHandler(ImpRequest request, ImpRequestHandler requestHandler) {

		if (this.requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException(String.format(
					"A request handler has already been registered for request name [%s]"
					, request.getName()));
		} else {
			this.requestHandlers.put(request.getName(), requestHandler);
		}
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.junit.v03.ImpController#getHandler(tain.kr.com.test.junit.v03.ImpRequest)
	 */
	@Override
	public ImpRequestHandler getHandler(ImpRequest request) {
		
		if (!this.requestHandlers.containsKey(request.getName())) {
			throw new RuntimeException(String.format(
					"Cannot find handler for request name [%s]"
					, request.getName()));
		}
		
		return this.requestHandlers.get(request.getName());
	}

	/* (non-Javadoc)
	 * @see tain.kr.com.test.junit.v03.ImpController#getResponse(tain.kr.com.test.junit.v03.ImpRequest)
	 */
	@Override
	public ImpResponse getResponse(ImpRequest request) {
		
		ImpResponse response;
		
		try {
			response = this.getHandler(request).process(request);
		} catch (Exception e) {
			response = new ResponseError(request, e);
		}
		
		return response;
	}
}