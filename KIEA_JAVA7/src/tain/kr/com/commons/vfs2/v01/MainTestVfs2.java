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
package tain.kr.com.commons.vfs2.v01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.vfs2.FileChangeEvent;
import org.apache.commons.vfs2.FileListener;
import org.apache.commons.vfs2.FileObject;
import org.apache.commons.vfs2.FileSystemManager;
import org.apache.commons.vfs2.VFS;
import org.apache.commons.vfs2.impl.DefaultFileMonitor;
import org.apache.log4j.Logger;

/**
 * Code Templates > Comments > Types
 *
 * <PRE>
 *   -. FileName   : MainTestVfs2.java
 *   -. Package    : tain.kr.com.commons.vfs2.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 11. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainTestVfs2 {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTestVfs2.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTestVfs2() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	public void execute() throws Exception {
		
		if (flag) {
			/*
			 * print progress
			 */
			try {
				new Thread(new ThrProgress()).start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if (flag) {
			/*
			 * event listener
			 */
			try {
				FileSystemManager fileSystemManager = VFS.getManager();
				FileObject listenFolder = fileSystemManager.resolveFile("N:/tain/products/LucyCron/test");
				
				DefaultFileMonitor fileMonitor = new DefaultFileMonitor(new FolderListener());   // monitor
				fileMonitor.setRecursive(true);
				fileMonitor.addFile(listenFolder);    // file for monitor
				fileMonitor.start();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final class ThrProgress implements Runnable {
		
		private static final long SLEEP_LOOP = 10 * 1000;
		private static final int LOOP_BASE = 24 * 60 * 6;
		
		@Override
		public void run() {
			
			if (flag) {
				
				String oldTime = "";
				String curTime = null;
				
				for (int i=0; ; i = ++i % LOOP_BASE) {
					curTime = DateFormat.getTime();
					if (!curTime.equals(oldTime)) {
						System.out.printf("[%s]\n", curTime);
						oldTime = curTime;
					}
					
					try { Thread.sleep(SLEEP_LOOP); } catch (InterruptedException e) {}
				}
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final class FolderListener implements FileListener {
		
		@Override
		public void fileChanged(FileChangeEvent fileChangeEvent) throws Exception {
			if (flag) System.out.printf("[%s] STATUS: the file [%s] has a changed event from [%s].\n"
					, DateFormat.getTime("HH:mm:ss")
					, fileChangeEvent.getFile().getName()
					, this);
		}
		
		@Override
		public void fileCreated(FileChangeEvent fileChangeEvent) throws Exception {
			if (flag) System.out.printf("[%s] STATUS: create the file [%s].\n"
					, DateFormat.getTime("HH:mm:ss")
					, fileChangeEvent.getFile().getName());
		}
		
		@Override
		public void fileDeleted(FileChangeEvent fileChangeEvent) throws Exception {
			if (flag) System.out.printf("[%s] STATUS: delete the file [%s].\n"
					, DateFormat.getTime("HH:mm:ss")
					, fileChangeEvent.getFile().getName());
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	
	private final static class DateFormat {
		
		public final static String getTime(String format) {
			return new SimpleDateFormat(format, Locale.KOREA).format(new Date());
		}
		
		public final static String getTime() {
			return getTime("HH:mm");
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

	/*
	 * static test method
	 */
	private static void test01(String[] args) throws Exception {

		if (flag) {
			/*
			 * begin
			 */
			new MainTestVfs2().execute();
		}
	}

	/*
	 * main method
	 */
	public static void main(String[] args) throws Exception {

		if (flag)
			log.debug(">>>>> " + new Object() {
			}.getClass().getEnclosingClass().getName());

		if (flag)
			test01(args);
	}
}
