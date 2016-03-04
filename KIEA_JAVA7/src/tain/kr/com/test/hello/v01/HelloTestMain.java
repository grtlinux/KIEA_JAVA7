package tain.kr.com.test.hello.v01;

import org.apache.log4j.Logger;

public class HelloTestMain {

	final static Logger logger = Logger.getLogger(HelloTestMain.class);
	
	private static boolean flag = true;
	
	public static void main(String[] args) throws Exception {
		
		if (flag) {
			if (logger.isDebugEnabled()) {
				logger.debug("ENABLE debug : " + "Hello, world!!! �ȳ��ϼ���.");
			}
		}
		
		if (flag) {
			System.out.println("Hello, world!!! �ȳ��ϼ���.");
			
			logger.debug("debug : " + "Hello, world!!! �ȳ��ϼ���.");
			logger.info ("info  : " + "Hello, world!!! �ȳ��ϼ���.");
			logger.warn ("warn  : " + "Hello, world!!! �ȳ��ϼ���.");
			logger.error("error : " + "Hello, world!!! �ȳ��ϼ���.");
			logger.fatal("fatal : " + "Hello, world!!! �ȳ��ϼ���.");
		}
	}
}
