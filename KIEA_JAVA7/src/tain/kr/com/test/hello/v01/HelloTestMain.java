package tain.kr.com.test.hello.v01;

import org.apache.log4j.Logger;

import tain.kr.com.test.version.v01.Version;

public class HelloTestMain {

	private static boolean flag = true;

	private static final Logger log = Logger.getLogger(Version.class);

	///////////////////////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
		
		if (flag) {
			if (log.isDebugEnabled()) {
				log.debug("ENABLE debug : " + "Hello, world!!! æ»≥Á«œººø‰.");
			}
		}
		
		if (flag) {
			System.out.println("Hello, world!!! æ»≥Á«œººø‰.");
			
			log.debug("debug : " + "Hello, world!!! æ»≥Á«œººø‰.");
			log.info ("info  : " + "Hello, world!!! æ»≥Á«œººø‰.");
			log.warn ("warn  : " + "Hello, world!!! æ»≥Á«œººø‰.");
			log.error("error : " + "Hello, world!!! æ»≥Á«œººø‰.");
			log.fatal("fatal : " + "Hello, world!!! æ»≥Á«œººø‰.");
		}
	}
}
