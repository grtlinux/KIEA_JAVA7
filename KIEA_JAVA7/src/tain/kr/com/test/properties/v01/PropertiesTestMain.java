package tain.kr.com.test.properties.v01;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class PropertiesTestMain {

	private static boolean flag = true;
	
	private static void test01(String[] args) {
	
		if (flag) {
			if (flag) System.out.printf("\nSystem.getProperties()\n");
			
			Properties prop = System.getProperties();
			
			Set<String> setKeys = prop.stringPropertyNames();
			Iterator<String> iterKeys = setKeys.iterator();
			
			while (iterKeys.hasNext()) {
				String key = iterKeys.next();
				String value = prop.getProperty(key);
				
				if (flag) System.out.printf("[%s] -> [%s]\n", key, value);
			}
		}
		
		if (flag) {
			if (flag) System.out.printf("\nSystem.getenv('PATH')\n");
			if (flag) System.out.printf("[%s] -> [%s]\n", "PATH", System.getenv("PATH"));
		}
		
		if (flag) {
			if (flag) System.out.printf("\nSystem.getenv()\n");
			
			Map<String, String> map = System.getenv();
			
			Set<String> setKeys = map.keySet();
			Iterator<String> iterKeys = setKeys.iterator();
			
			while (iterKeys.hasNext()) {
				String key = iterKeys.next();
				String value = map.get(key);
				
				if (flag) System.out.printf("[%s] -> [%s]\n", key, value);
			}
		}
		
		if (flag) {
			if (flag) System.out.printf("\nSystem.getenv() - 2\n");
			
			Map<String, String> map = System.getenv();
			
			for (Map.Entry<String, String> entry : map.entrySet()) {
				String key = entry.getKey();
				String value = entry.getValue();
				
				if (flag) System.out.printf("[%s] -> [%s]\n", key, value);
			}
		}
		
		if (flag) {
			Properties prop = new Properties();
			
			FileInputStream fis = null;
			
			String fileName = "N:/WORK/GIT/GIT_DEPLOY1/TAIN_SYNKER/TAIN_SYNKER/synker/conf/Synker.properties";
			
			try {
				fis = new FileInputStream(fileName);
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if (fis != null) {
					try { fis.close(); } catch (Exception e) {}
				}
			}
			
			String val = prop.getProperty("tain.kr.synker.system.01.folder.01");
			if (flag) System.out.println("val = " + val);
		}
	}
	
	private static void test02(String[] args) {
		
		if (flag) {
			
			if (flag) System.out.printf("\nSystem.getProperties()\n");
			
			Properties prop = System.getProperties();
			
			String key = "tain.kr.main";
			String val = prop.getProperty(key, "NOT VALUE").toUpperCase();
			
			if (flag) System.out.printf("\n\n[%s] -> [%s]\n", key, val);
		}		
	}
	
	public static void main(String[] args) {
		if (flag) test01(args);
		if (flag) test02(args);
	}
}
