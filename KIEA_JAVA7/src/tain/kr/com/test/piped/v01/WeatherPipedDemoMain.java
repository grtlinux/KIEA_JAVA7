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

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Timer;
import java.util.TimerTask;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : WeatherPipedDemoMain.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class WeatherPipedDemoMain {

	private static boolean flag = true;

	private static final Logger log = Logger
			.getLogger(WeatherPipedDemoMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			PipedInputStream pis = new PipedInputStream();
			PipedOutputStream pos = new PipedOutputStream(pis);
			
			TimerTask task = new RandomWeather(pos);
			Thread viewer = new WeatherViewer(pis);
			
			Timer timer = new Timer();
			timer.schedule(task, 0, 4000);
			viewer.start();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}


class RandomWeather extends TimerTask {
	
	private static boolean flag = true;

	@SuppressWarnings("unused")
	private PipedOutputStream pos = null;
	private DataOutputStream dos = null;
	
	public RandomWeather(PipedOutputStream pos) {
		this.pos = pos;
		this.dos = new DataOutputStream(pos);
	}
	
	public void run() {
		
		try {
			
			if (flag) {
				int temp = (int)(Math.random() * 110);
				this.dos.writeInt(temp);
			}

			if (flag) {
				int random = (int)(Math.random() * 4);
				String condition;
				
				switch(random) {
				case 0 : condition = "SUNNY"; break;
				case 1 : condition = "RAINY"; break;
				case 2 : condition = "WINDY"; break;
				default: condition = "SNOWY"; break;
				}
				
				this.dos.writeUTF(condition);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class WeatherViewer extends Thread {
	
	private static boolean flag = true;

	@SuppressWarnings("unused")
	private PipedInputStream pis = null;
	private DataInputStream dis = null;
	
	public WeatherViewer(PipedInputStream pis) {
		this.pis = pis;
		this.dis = new DataInputStream(pis);
	}
	
	public void run() {
		
		try {
			//while (this.pis.available() > 0) {
			while (true) {
				
				if (flag) {
					int currentTemp = this.dis.readInt();
					System.out.println("\nThe Current Temp is " + currentTemp);
				}
				
				if (flag) {
					String condition = this.dis.readUTF();
					System.out.println("Condition is " + condition);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}