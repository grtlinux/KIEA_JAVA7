package tain.kr.com.test.charset.v01;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;

import tain.kr.com.test.ftp.v01.FtpTransfer;

public class CheckCharSetTestMain {

	final static Logger log = Logger.getLogger(CheckCharSetTestMain.class);
	
	private static boolean flag = true;
	
	/////////////////////////////////////////////////////////////////////////////
	
	private static String BinToHex(byte[] buf) throws Exception {
		
		String res = "";
		String token = "";
		
		for (int i=0; i < buf.length; i++) {
			token = Integer.toHexString(buf[i]);
			
			if (token.length() >= 2) {
				token = token.substring(token.length() - 2);
			} else {
				for (int j=0; j < 2-token.length(); j++)
					token = "0" + token;
			}
			
			res += " " + token;
		}
		
		return res.toUpperCase();
	}
	
	private static void test01(String[] args) throws Exception {
		
		if (!flag) {
			// editor charSet : EUC-KR
			System.out.println("default characterSet : " + System.getProperty("file.encoding"));
			System.out.println();
			
			String name = new String("�ѹ�ȣ");  // EUC-KR
			
			byte[] bytes = name.getBytes();
			System.out.println("length : " + bytes.length);
			System.out.println("Hex    : " + BinToHex(bytes));
			System.out.println("Value  : " + new String(bytes));
			System.out.println();
			
			bytes = name.getBytes("utf-8");
			System.out.println("length : " + bytes.length);
			System.out.println("Hex    : " + BinToHex(bytes));
			System.out.println("Value  : " + new String(bytes, "utf-8"));
			System.out.println();
		
			name = new String(bytes, "utf-8");
			bytes = name.getBytes();
			System.out.println("length : " + bytes.length);
			System.out.println("Hex    : " + BinToHex(bytes));
			System.out.println("Value  : " + name);
			System.out.println();
			
			String convert = new String(name.getBytes("euc-kr"), "utf-8");
			System.out.println(convert);
			
			bytes = convert.getBytes();
			System.out.println("length : " + bytes.length);
			System.out.println("utf-8  Hex : " + BinToHex(bytes));
			
			bytes = convert.getBytes("euc-kr");
			System.out.println("length : " + bytes.length);
			System.out.println("euc-kr Hex  : " + BinToHex(bytes));
			System.out.println();
		}

		if (!flag) {
			// editor charSet : UTF-8
			System.setProperty("file.encoding", "EUC-KR");
			System.out.println("default characterSet : " + System.getProperty("file.encoding"));
			System.out.println();
			
			String name = new String("�ѹ�ȣ");  // UTF-8
			
			byte[] bytes = name.getBytes();
			System.out.println("length : " + bytes.length);
			System.out.println("Hex    : " + BinToHex(bytes));
			System.out.println("Value  : " + new String(bytes));
			System.out.println();
			
			bytes = name.getBytes("EUC-KR");
			System.out.println("length : " + bytes.length);
			System.out.println("Hex    : " + BinToHex(bytes));
			System.out.println("Value  : " + new String(bytes, "EUC-KR"));
			System.out.println("Value  : " + new String(bytes, "UTF-8"));
			System.out.println();
		
			name = new String(bytes, "EUC-KR");
			bytes = name.getBytes();
			System.out.println("length : " + bytes.length);
			System.out.println("Hex    : " + BinToHex(bytes));
			System.out.println("Value  : " + name);
			System.out.println();
			
			String convert = new String(name.getBytes("utf-8"), "euc-kr");
			System.out.println(convert);
			
			bytes = convert.getBytes();
			System.out.println("length : " + bytes.length);
			System.out.println("euc-kr Hex : " + BinToHex(bytes));
			
			bytes = convert.getBytes("utf-8");
			System.out.println("length : " + bytes.length);
			System.out.println("utf-8 Hex  : " + BinToHex(bytes));
			System.out.println();
		}
		
		if (flag) {
			System.out.println("default characterSet : " + System.getProperty("file.encoding"));
			
			String name = "�ѱ�";
			
			byte[] by1 = null;
			byte[] by2 = null;
			byte[] by3 = null;
			
			String str1 = null;
			String str2 = null;
			String str3 = null;

			by1 = name.getBytes();
			by2 = name.getBytes("utf-8");
			by3 = name.getBytes("euc-kr");

			System.out.println(name);
			System.out.println("null   : by1 = " + BinToHex(by1));
			System.out.println("utf-8  : by2 = " + BinToHex(by2));
			System.out.println("euc-kr : by3 = " + BinToHex(by3));
			System.out.println();
			
			str1 = new String(by1);
			str2 = new String(by2);
			str3 = new String(by3);

			System.out.println("new String(by)");
			System.out.println("1.null   : str1 = " + str1);
			System.out.println("2.utf-8  : str2 = " + str2);
			System.out.println("3.euc-kr : str3 = " + str3);
			System.out.println();

			str1 = new String(by1, "utf-8");
			str2 = new String(by2, "utf-8");
			str3 = new String(by3, "utf-8");

			System.out.println("new String(by, utf-8)");
			System.out.println("1.null   : str1 = " + str1);
			System.out.println("2.utf-8  : str2 = " + str2);
			System.out.println("3.euc-kr : str3 = " + str3);
			System.out.println();
			
			str1 = new String(by1, "euc-kr");
			str2 = new String(by2, "euc-kr");
			str3 = new String(by3, "euc-kr");

			System.out.println("new String(by, euc-kr)");
			System.out.println("1.null   : str1 = " + str1);
			System.out.println("2.utf-8  : str2 = " + str2);
			System.out.println("3.euc-kr : str3 = " + str3);
			System.out.println();
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	private static void test02(String[] args) throws Exception {

		StringBuffer sb = new StringBuffer();
		
		if (flag) {
			String name = "�ѱ�" + "                                                                     ";

			String str = new String(name.getBytes("euc-kr"), 0, 10, "euc-kr");
			
			sb.append(String.format("[%s]", str));
		}
		
		if (flag) {
			Integer cnt = new Integer(123);
			Long size = new Long(12345);
			Double amt = new Double(12345678.12);
			
			sb.append(String.format("[%-10s][%-10s][%-10s][%-20d][%-20.0f]", cnt.toString(), size.toString(), amt.toString(), size, amt));
			
			if (flag) System.out.println(sb.toString());
		}
		
		if (!flag) {
			// ftp content file
			Map<String, String> ftpMap = new HashMap<String, String>();
			
			ftpMap.put("host", "174.100.67.129");
			ftpMap.put("port", "21");
			ftpMap.put("user", "cmpn");
			ftpMap.put("pass", "cmpn12#");
			// ftpMap.put("rpath", "/home/cmpn/" + "SMS" + "/RECV");
			ftpMap.put("rpath", "/home/cmpn/");
			ftpMap.put("rfile", "TEST_SMS");
			ftpMap.put("rencode", "EUC-KR");
			ftpMap.put("filecont", sb.toString());
			
			if (flag) System.out.println(ftpMap);
			
			FtpTransfer.getInstance().transfer(ftpMap);
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	private static void test03(String[] args) throws Exception {
		
		if (flag) {
			Date dt = new Date();
			System.out.println(dt);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss", Locale.KOREA);
			System.out.println(dateFormat.format(new Date()));
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	private static void test04(String[] args) throws Exception {
		
		if (flag) {
			String str = "(����)����%CHANGEWORD1%\r\n��02-2200-1234\r\n������Űź�080-850-6743               ";
			System.out.println(str);
			
			System.out.println("----------------------------");
			
			String str2 = str.replace("\r", "").replace("\n", "\\n");
			System.out.println(str2);
		}
	}

	/////////////////////////////////////////////////////////////////////////////
	
	private static byte[] getNBytes(String str, int no) throws Exception {
		
		if (flag) {
			//
			byte[] tgtby = new byte[no];
			Arrays.fill(tgtby, (byte) '.');
			
			byte[] srcby = str.getBytes("EUC-KR");
			
			int i;
			
			// ��Ī��Ų��.
			for (i=0; i < no && i < srcby.length; i++) {
				
				tgtby[i] = srcby[i];
				
				if (srcby[i] >>> 7 > 0) {
					i++;
					
					try {
						tgtby[i] = srcby[i];
					} catch (ArrayIndexOutOfBoundsException e) {
						// e.printStackTrace();
						
						tgtby[--i] = ' ';
					}
				}
			}

			// ������ ������ space�� ä���.
			for (; i < no; i++) {
				tgtby[i] = ' ';
			}
			
			return tgtby;
		}
		
		return null;
	}
	
	private static String getNString(String str, int no) throws Exception {
		return new String(getNBytes(str, no), "EUC-KR");
	}
	
	private static void test05(String[] args) throws Exception {
		
		if (flag) {
			//String str = "(����)����%CHANGEWORD1%\r\n��02-2200-1234\r\n������Űź�080-850-6743               ";
			String str = "(����)����%CHANGEWORD1%��02-2200-1234������Űź�080-850-6743               ";

			for (int i=1; i < 100; i++) {
				System.out.println("[" + getNString(str, i) + "]");
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	private static void test06(String[] args) throws Exception {
		
		if (flag) {
			
			Random rand = new Random(new Date().getTime());
			
			String[] str_nm = { "����", "��������", "������", "�սʸ���" };
			
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("APP01", "�ֿ�����(%d)");     // ����seq
			map.put("APP02", "��������[%s]");   // ������
			map.put("APP03", "���������[%s]");   // ������
			map.put("APP04", "�̸�Ʈ(%s)");       // ��������
			map.put("APP05", "(�����)");
			map.put("APP06", "(�����)");
			map.put("APP07", "(�����)");
			map.put("APP08", "(�����)");
			map.put("APP09", "(�����)");
			map.put("APP10", "(�����)");
			
			String strMsg = "�̹��� %APP04%���� ��縦 �����մϴ�. ������ %APP02% ~ %APP03% �̸� ��Ҵ� %APP01%�Դϴ�. - %APP04%-";
			
			for (int i=0; i < 10; i++) {
				String app01 = String.format(String.valueOf(map.get("APP01")), rand.nextInt(100) + 123);
				String app02 = String.format(String.valueOf(map.get("APP02")), "2015-11-25");
				String app03 = String.format(String.valueOf(map.get("APP03")), "2015-11-30");
				String app04 = String.format(String.valueOf(map.get("APP04")), str_nm[rand.nextInt(str_nm.length)]);
				
				String msg = strMsg
						.replaceAll("%APP01%", app01)
						.replaceAll("%APP02%", app02)
						.replaceAll("%APP03%", app03)
						.replaceAll("%APP04%", app04);
				
				System.out.println("> [" + msg + "]");
			}
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	
	private static void test07(String[] args) throws Exception {
		
		if (flag) {
			String str = "��";
			
			byte[] by1 = str.getBytes();
			byte[] by2 = str.getBytes("euc-kr");
			byte[] by3 = str.getBytes("utf-8");
			
			if (flag) {
				log.debug(BinToHex(by1));
				log.debug(BinToHex(by2));
				log.debug(BinToHex(by3));
			}

			String hex1 = BinToHex(by1);
			String hex2 = BinToHex(by2);
			String hex3 = BinToHex(by3);

			if (hex1.equals(hex2)) {
				log.debug("��Ŭ������ Editor�� encoding�� EUC-KR �̴�.");
			} else if (hex1.equals(hex3)) {
				log.debug("��Ŭ������ Editor�� encoding�� UTF-8 �̴�.");
			} else {
				log.debug("��Ŭ������ Editor�� encoding�� �𸥴�.");
			}
			
			if (flag) log.debug(Integer.toBinaryString(by2[0] & 0xFF));
			if (flag) log.debug(Integer.toBinaryString(by3[0] & 0xFF));
		}
	}
	
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////////////////////////////////////////////////
	
	public static void main(String[] args) throws Exception {
	
		if (!flag) test01(args);
		if (!flag) test02(args);
		if (!flag) test03(args);
		if (!flag) test04(args);
		if (!flag) test05(args);
		if (!flag) test06(args);
		if (flag) test07(args);
	}
}
