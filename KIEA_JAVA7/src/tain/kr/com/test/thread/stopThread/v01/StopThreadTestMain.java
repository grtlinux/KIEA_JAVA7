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
package tain.kr.com.test.thread.stopThread.v01;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : StopThreadTestMain.java
 *   -. Package    : tain.kr.com.test.thread.stopThread.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 4. 19. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class StopThreadTestMain {

	//private static boolean flag = true;

	//private static final Logger log = Logger.getLogger(StopThreadTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		final CanStop stoppable = new CanStop();
		stoppable.start();
		
		new Timer(true).schedule(new TimerTask() {
			public void run() {
				System.out.println("Requesting stop");
				stoppable.requestStop();
			}
		}, 10000);
	}
}


class CanStop extends Thread {
	
	private volatile boolean stop = false;
	private int counter = 0;
	
	public void run() {
		while (!stop && counter < 10000) {
			System.out.println(counter++);
			
			try { Thread.sleep(100); } catch (InterruptedException e) {}
		}
		
		if (stop)
			System.out.println("Detected stop");
	}
	
	public void requestStop() {
		this.stop = true;
	}
}