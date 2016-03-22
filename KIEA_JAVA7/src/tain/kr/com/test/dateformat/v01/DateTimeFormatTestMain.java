package tain.kr.com.test.dateformat.v01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.apache.log4j.Logger;

public class DateTimeFormatTestMain {

	final static Logger log = Logger.getLogger(DateTimeFormatTestMain.class);
	
	private static boolean flag = true;
	
	private static void test01(String[] args) throws Exception {
		
		if (flag) {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS");
			log.debug("> " + dtf.format(new Date(0L)));
		}
		
		if (flag) {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.KOREA);
			log.debug("> " + dtf.format(new Date(0L)));
		}
		
		if (flag) {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.KOREA);
			log.debug("> " + dtf.format(new Date(59999L)));
		}
	}
	
	private static void test02(String[] args) throws Exception {
		
		if (flag) {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss.SSS", Locale.KOREA);
			log.debug("> " + dtf.format(new Date()));
		}
		
		if (flag) {
			SimpleDateFormat dtf = new SimpleDateFormat("yyyy/MM/dd", Locale.KOREA);
			log.debug("> " + dtf.format(new Date()));
		}
	}
	
	private static void test03(String[] args) throws Exception {
		
		if (flag) {
			log.debug(">" + new SimpleDateFormat("yyyyMMdd HHmmss", Locale.KOREA).format(new Date()));
		}
	}
	
	private static void test04(String[] args) throws Exception {
		
		if (flag) {
			Long tm = new Date().getTime() + 1000 * 60 * 60 * 24 * 10;
			
			log.debug(">" + new SimpleDateFormat("yyyy/MM/dd HH:mm:ss", Locale.KOREA).format(new Date(tm)));
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		if (!flag) test01(args);
		if (!flag) test02(args);
		if (!flag) test03(args);
		if (flag) test04(args);
	}
}
