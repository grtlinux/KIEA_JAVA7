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
package tain.kr.com.test.vfs.v01;

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
 *   -. FileName   : MainTest01.java
 *   -. Package    : tain.kr.com.test.vfs.v01
 *   -. Comment    :
 *   -. Author     : taincokr
 *   -. First Date : 2017. 4. 8. {time}
 * </PRE>
 *
 * @author taincokr
 *
 */
public final class MainTest01 extends Thread implements FileListener {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(MainTest01.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/*
	 * constructor
	 */
	public MainTest01() {
		if (flag)
			log.debug(">>>>> in class " + this.getClass().getSimpleName());
	}

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	@Override
	public void run() {
		
		if (flag) {
			try{
				FileSystemManager fsManager = VFS.getManager();
				FileObject listendir = fsManager.resolveFile("N:\\tain\\temp\\vfs");
				
				DefaultFileMonitor fm = new DefaultFileMonitor(new MainTest01());
				fm.setRecursive(true);
				fm.addFile(listendir);
				fm.start();
				
				for (int i=0;; i = ++i % 100) {
					System.out.println("#");
					
					try { Thread.sleep(1 * 1000); } catch (InterruptedException e) {}
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////////////////////////////////////////////////////////////

	/* (non-Javadoc)
	 * @see org.apache.commons.vfs2.FileListener#fileChanged(org.apache.commons.vfs2.FileChangeEvent)
	 */
	@Override
	public void fileChanged(FileChangeEvent fileChangeEvent) throws Exception {
		if (flag) log.info(String.format("File [%s] changed event from [%s]", fileChangeEvent.getFile().getName(), this));
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.vfs2.FileListener#fileCreated(org.apache.commons.vfs2.FileChangeEvent)
	 */
	@Override
	public void fileCreated(FileChangeEvent fileChangeEvent) throws Exception {
		if (flag) log.info(String.format("file created : %s.", fileChangeEvent.getFile().getName()));
	}

	/* (non-Javadoc)
	 * @see org.apache.commons.vfs2.FileListener#fileDeleted(org.apache.commons.vfs2.FileChangeEvent)
	 */
	@Override
	public void fileDeleted(FileChangeEvent fileChangeEvent) throws Exception {
		if (flag) log.info(String.format("file deleted : %s.", fileChangeEvent.getFile().getName()));
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
			Thread thread = null;
			if (thread == null)
				thread = new MainTest01();
			thread.run();
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
