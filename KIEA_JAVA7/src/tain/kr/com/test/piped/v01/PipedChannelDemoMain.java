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
package tain.kr.com.test.piped.v01;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : PipedChannelDemoMain.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class PipedChannelDemoMain {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(PipedChannelDemoMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private final static int BUFSIZE = 10;
	private final static int LIMIT = 3;
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			final Pipe pipe = Pipe.open();
			
			Runnable senderTask = new Runnable() {
				
				@Override
				public void run() {
					
					WritableByteChannel src = pipe.sink();
					ByteBuffer buffer = ByteBuffer.allocate(BUFSIZE);
					
					for (int i=0; i < LIMIT; i ++) {
						// clear
						buffer.clear();
						
						// put
						for (int j=0; j < BUFSIZE; j++) {
							buffer.put((byte)(Math.random() * 256));
						}
						// flip
						buffer.flip();
						
						try {
							while(src.write(buffer) > 0);
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
					
					try {
						src.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			Runnable receiverTask = new Runnable() {
				
				@Override
				public void run() {
					
					ReadableByteChannel dst = pipe.source();
					ByteBuffer buffer = ByteBuffer.allocate(BUFSIZE);
					
					try {
						while (dst.read(buffer) >= 0) {
							// flip
							buffer.flip();
							
							// get
							while (buffer.remaining() > 0) {
								System.out.println(buffer.get() & 255);
							}
							
							// clear
							buffer.clear();
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			};
			
			Thread sender = new Thread(senderTask);
			Thread receiver = new Thread(receiverTask);
			
			sender.start();
			receiver.start();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
