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
package tain.kr.com.test.file.v04;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : FormatTransferTestMain.java
 *   -. Package    : tain.kr.com.test.file.v04
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 18. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class FormatTransferTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(FormatTransferTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		ResourceBundle rb = null;
		
		if (flag) {
			String clsName = new Object(){}.getClass().getEnclosingClass().getName();
			
			rb = ResourceBundle.getBundle(clsName.replace('.', '/'));
		}
		
		if (flag) {
			String inCharset = rb.getString("test01.in.file.charset");
			String inFileName = rb.getString("test01.in.file.path") + File.separator + rb.getString("test01.in.file.name");
			
			String outCharset = rb.getString("test01.out.file.charset");
			String outFileName = rb.getString("test01.out.file.path") + File.separator + rb.getString("test01.out.file.name");
			
			////////////////////////////////////////////////////
			
			File inFile = new File(inFileName);
			FileInputStream inFileStream = new FileInputStream(inFile);
			BufferedReader inReader = new BufferedReader(new InputStreamReader(inFileStream, inCharset));
			
			File outFile = new File(outFileName);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			OutputStreamWriter outWriter = new OutputStreamWriter(outFileStream, outCharset);
			PrintWriter writer = new PrintWriter(outWriter);
			
			String line = null;
			
			while ((line = inReader.readLine()) != null) {
				if (flag) log.debug("[" + line + "]");
				
				writer.println(line);
			}
			
			inReader.close();
			writer.close();
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		ResourceBundle rb = null;
		
		if (flag) {
			String clsName = new Object(){}.getClass().getEnclosingClass().getName();
			
			rb = ResourceBundle.getBundle(clsName.replace('.', '/'));
		}
		
		if (flag) {
			String inCharset = rb.getString("test02.in.file.charset");
			String inFileName = rb.getString("test02.in.file.path") + File.separator + rb.getString("test02.in.file.name");
			
			String outCharset = rb.getString("test02.out.file.charset");
			String outFileName = rb.getString("test02.out.file.path") + File.separator + rb.getString("test02.out.file.name");
			
			////////////////////////////////////////////////////
			
			File inFile = new File(inFileName);
			FileInputStream inFileStream = new FileInputStream(inFile);
			BufferedReader inReader = new BufferedReader(new InputStreamReader(inFileStream, inCharset));
			
			File outFile = new File(outFileName);
			FileOutputStream outFileStream = new FileOutputStream(outFile);
			OutputStreamWriter outWriter = new OutputStreamWriter(outFileStream, outCharset);
			PrintWriter writer = new PrintWriter(outWriter);
			
			String line = null;
			
			while ((line = inReader.readLine()) != null) {
				if (flag) log.debug("[" + line + "]");
				
				writer.println(line);
			}
			
			inReader.close();
			writer.close();
		}
	}

	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
