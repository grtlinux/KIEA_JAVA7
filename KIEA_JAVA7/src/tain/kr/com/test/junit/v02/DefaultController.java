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
package tain.kr.com.test.junit.v02;

import java.util.HashMap;
import java.util.Map;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : DefaultController.java
 *   -. Package    : tain.kr.com.test.junit.v02
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 3. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class DefaultController implements Controller {

	private Map<String, RequestHandler> requestHandlers = new HashMap<String, RequestHandler>();

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public RequestHandler getHandler(Request request) {
	
		if (!this.requestHandlers.containsKey(request.getName())) {
			String message = "Cannot find hnalder for request name " + " [" + request.getName() + "]";
			throw new RuntimeException(message);
		}
		
		return this.requestHandlers.get(request.getName());
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public Response processRequest(Request request) {
		
		Response response;
		
		try {
			response = getHandler(request).process(request);
		} catch (Exception e) {
			response = new ErrorResponse(request, e);
		}
		
		return response;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void addHandler(Request request, RequestHandler requestHandler) {
		
		if (this.requestHandlers.containsKey(request.getName())) {
			String message = "A request handler has already been registered for request name " + " [" + request.getName() + "]";
			throw new RuntimeException(message);
		} else {
			this.requestHandlers.put(request.getName(), requestHandler);
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

}
