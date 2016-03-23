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
package tain.kr.com.test.randomaccessfile.v01;

import java.io.RandomAccessFile;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : RandomAccessFileTestMain.java
 *   -. Package    : tain.kr.com.test.randomaccessfile.v01
 *   -. Comment    :
 *   -. Author     : KangSeok
 *   -. First Date : 2016. 3. 23. {time}
 * </PRE>
 *
 * @author KangSeok
 *
 */
public class RandomAccessFileTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(RandomAccessFileTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private RandomAccessFileTestMain() throws Exception {
		if (flag) {
			
		}
	}
	
	public void execute() throws Exception {
		
		if (flag) {
			String fileName = "N:/TEMP/TEST/HANWA/send/DAT/20160323/OASPOS5101";
			
			RandomAccessFile raf = null;
			
			try {
				raf = new RandomAccessFile(fileName, "rw");
				
				String line = null;
				long pos = -1;
				
				while (true) {
					pos = raf.getFilePointer();
					line = raf.readLine();
					if (line == null)
						break;
					
					if (flag) log.debug(String.format("(%05d)[%3d:%s]", pos, line.length(), line));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (raf != null) try { raf.close(); } catch (Exception e) {}
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private static RandomAccessFileTestMain instance = null;
	
	public static synchronized RandomAccessFileTestMain getInstance() throws Exception {
		
		if (instance == null) {
			instance = new RandomAccessFileTestMain();
		}
		
		return instance;
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			RandomAccessFileTestMain.getInstance().execute();
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
	}
}
