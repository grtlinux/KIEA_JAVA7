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
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : Piped03Main.java
 *   -. Package    : tain.kr.com.test.piped.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 8. 9. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class Piped03Main {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Piped03Main.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			PipedOutputStream producer = new PipedOutputStream();
			PipedInputStream consumer = new PipedInputStream(producer);

			GetPipe getting = new GetPipe(consumer);
			PutPipe putting = new PutPipe(producer);

			getting.start();
			putting.start();
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}

class PutPipe extends Thread {
	private DataOutputStream out;

	public PutPipe(OutputStream o){
		out = new DataOutputStream (o);
	}

	@Override
	public void run(){
		int j=0;
		while(j<10){
			try{
				out.write(j);
				System.out.println("put:"+j);
			}catch(IOException e){
				System.out.println("IO error occured in Put");
			}
			j++;
		}
	}
}

class GetPipe extends Thread{
	private static boolean flag = true;
	private DataInputStream in;
	private PipedInputStream pis;
	int num;

	public GetPipe(InputStream i){
		in = new DataInputStream(i);
		pis = (PipedInputStream) i;
	}

	@Override
	public void run(){
		
		if (!flag) {
			int i=0;
			while(i<10){
				try{
					num = in.read();
					System.out.println("get:"+num);
				}catch(IOException e){
					System.out.println("IO error occured in Get");
				}
				i++;
			}
		}
		
		/*
		 * TODO : 2016.08.09
		 * LOGICAL ERROR : have to check the below code 
		 */
		if (flag) {
			try {
				while (pis.available() > 0) {
					num = pis.read();
					System.out.println("get : " + num);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}

