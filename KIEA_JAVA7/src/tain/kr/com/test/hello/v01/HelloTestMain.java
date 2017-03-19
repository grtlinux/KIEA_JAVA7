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
				log.debug("ENABLE debug : " + "Hello, world!!! �ȳ��ϼ���.");
			}
		}
		
		if (flag) {
			System.out.println("Hello, world!!! �ȳ��ϼ���.");
			
			log.debug("debug : " + "Hello, world!!! �ȳ��ϼ���.");
			log.info ("info  : " + "Hello, world!!! �ȳ��ϼ���.");
			log.warn ("warn  : " + "Hello, world!!! �ȳ��ϼ���.");
			log.error("error : " + "Hello, world!!! �ȳ��ϼ���.");
			log.fatal("fatal : " + "Hello, world!!! �ȳ��ϼ���.");
		}
	}
}
