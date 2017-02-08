package tain.kr.com.test.threadLocal.v01;

import java.util.HashMap;
import java.util.Random;

class MapThreadLocal extends ThreadLocal<Object> {
	//Object �� �ƴ϶� HashMap �� ������ ���´�. 
	protected Object initialValue() {
		return new HashMap();
	}

	public HashMap getHashMap() {
		return (HashMap) this.get();
	}
}

class GlobalMapThreadLocal extends ThreadLocal {

	// ThreadLocal ��  �ƴ϶� MapThreadLocal �� ����ҷ� ����Ѵ�.  
	private static MapThreadLocal globalHashMapThreadLocalRef = new MapThreadLocal();

	public static Object get(String key) {
		return globalHashMapThreadLocalRef.getHashMap().get(key);
	}

	public static void set(String key, Object newValue) {
		globalHashMapThreadLocalRef.getHashMap().put(key, newValue);
	}

	public static HashMap getHashMap() {
		return globalHashMapThreadLocalRef.getHashMap();
	}

	public static MapThreadLocal getMapThreadLocal() {
		return globalHashMapThreadLocalRef;
	}
}

public class TestThreadLocal4 {

	public static void main(String[] args) {
		TestThreadLocal4 test4 = new TestThreadLocal4();
		int testThreadSize = 1000 ;
		for (int i = 0; i < testThreadSize; i++) {
			new Thread(test4.new TestThread("T" + i), "������-T-" + i).start();
		}

	}

	// ������ ���� ���� �� threadIdValue �� ���� Thread �� ����
	class TestThread implements Runnable {
		private String threadIdValue = "";
		public TestThread(String threadIdValue) {
			this.threadIdValue = threadIdValue;
		}
		public void run() {
			try {
				Util.sleep_for_a_while();
				new CMDTier().execute(this.threadIdValue);
			} catch (InterruptedException x) {
				// do nothing
			}
		}

	}

	class CMDTier {

		public void execute(Object value) throws InterruptedException {

			// GlobalMapThreadLocal �������� ���� ���� ���� �Ҵ��Ѵ�.
			GlobalMapThreadLocal.set(Util.GLOBAL_KEY1, "GMTL-1-" + value);
			GlobalMapThreadLocal.set(Util.GLOBAL_KEY2, "GMTL-2-" + value);

			// ���� Thread ������ GlobalThrealLocal �������� ���� ����Ѵ�.
			Util.printCurrentThreadLocalStatus(this);

			// Multi-Thread ȯ���� �䳻���� ���� �����Ⱓ(Random) ���� ����Ѵ�.
			Util.sleep_for_a_while();
			new ControlTier().execute();

		}

	}

	class ControlTier {

		public void execute() throws InterruptedException {

			// ���� Thread ������ GlobalThrealLocal �������� ���� ����Ѵ�.
			Util.printCurrentThreadLocalStatus(this);

		}

	}

	static class Util {
		public static String GLOBAL_KEY1 = "GK_1";
		public static String GLOBAL_KEY2 = "GK_2";

		private static Random seedRandom = new Random();
		private static int generateRandomNumber() {
			int randomNum = seedRandom.nextInt(5) * 1000;
			//print( ""+randomNum );
			return randomNum;
		}
		public static void sleep_for_a_while() throws InterruptedException {
			Thread.sleep(generateRandomNumber());
		}

		public static void print(String value) {
			String myThreadName = Thread.currentThread().getName();
			System.out.println("[" + myThreadName + "]-" + value);
		}

		public static String getCaller(Object caller) {
			return caller.getClass().getName();
		}

		// ���� Thread ������ ������ GlobalThreadLocal ���� ���� ����Ѵ�. 
		public static void printCurrentThreadLocalStatus(Object caller) {
			String key1 = (String) GlobalMapThreadLocal.get(GLOBAL_KEY1);
			String key2 = (String) GlobalMapThreadLocal.get(GLOBAL_KEY2);
			print("[" + getCaller(caller) + "]GlobalMapThreadLocal:Reference["
					+ GlobalMapThreadLocal.getMapThreadLocal() + "]Value:"
					+ GLOBAL_KEY1 + "[" + key1 + "]" + "]" + GLOBAL_KEY2 + "["
					+ key2 + "]");
		}
	}

}