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
package tain.kr.com.test.Logger.v01;

import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : LoggerTestMain.java
 *   -. Package    : tain.kr.com.test.Logger.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2016. 3. 2. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public class LoggerTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(LoggerTestMain.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			
			String className = new Object(){}.getClass().getEnclosingClass().getName().replace('.', '/');

			java.util.logging.Logger testLog = java.util.logging.Logger.getLogger("TestLog.log");
			
			/*
			 * FileHandler(String pattern, int limit, int count, boolean append)
			 *    pattern : ��� ������ �̸����� ����
			 *    limit : ������ 1���� ���Ͽ� �����ϴ� �ִ� ����Ʈ��
			 *    count : ����ϴ� ���� ��
			 *    append : �߰� ��带 �����Ѵ�
			 */
			java.util.logging.FileHandler fileHandler = new java.util.logging.FileHandler(className + ".xml", 0, 1, true);
			
			testLog.addHandler(fileHandler);
			testLog.setLevel(java.util.logging.Level.INFO);
			
			/*
			 * Log ���
			 */
			testLog.log(java.util.logging.Level.INFO, "Hello, world!!!");
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			
			java.util.logging.Logger testLog = java.util.logging.Logger.getLogger("TestLog.log");
			
			testLog.severe("�ɰ���������");
			testLog.info("�Ϲ�����");
			testLog.warning("���޽����� ���⿡ �����.");
			testLog.config("ȯ�������� �����.");
			testLog.fine("�������� �����.");
			testLog.finest("���� ���ϰ� �α� ������ �����.");
			testLog.finer("finer�� ����Ѵ�.");
			
			try {
				System.out.println(10 / 0);
			} catch (Exception e) {
				testLog.severe("���� ���� ���� ���� �޽���" + e.getMessage());
				testLog.log(java.util.logging.Level.SEVERE, "���������ִ� �޽��� --> ������ ����:" + e);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (flag) log.debug(">>>>> " + new Object(){}.getClass().getEnclosingClass().getName());
		
		if (!flag) test01(args);
		if (flag) test02(args);
	}
}
