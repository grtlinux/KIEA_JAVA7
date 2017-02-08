package tain.kr.com.test.threadLocal.v01;

import java.util.HashMap;
import java.util.Random;

class MapThreadLocal extends ThreadLocal<Object> {
	//Object 가 아니라 HashMap 를 값으로 갖는다. 
	protected Object initialValue() {
		return new HashMap<Object, Object>();
	}

	@SuppressWarnings("unchecked")
	public HashMap<Object, Object> getHashMap() {
		return (HashMap<Object, Object>) this.get();
	}
}

class GlobalMapThreadLocal extends ThreadLocal<Object> {

	// ThreadLocal 이  아니라 MapThreadLocal 을 저장소로 사용한다.  
	private static MapThreadLocal globalHashMapThreadLocalRef = new MapThreadLocal();

	public static Object get(String key) {
		return globalHashMapThreadLocalRef.getHashMap().get(key);
	}

	public static void set(String key, Object newValue) {
		globalHashMapThreadLocalRef.getHashMap().put(key, newValue);
	}

	public static HashMap<Object, Object> getHashMap() {
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
			new Thread(test4.new TestThread("T" + i), "쓰레드-T-" + i).start();
		}

	}

	// 구분을 위해 고유 값 threadIdValue 을 갖는 Thread 로 변경
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

			// GlobalMapThreadLocal 변수내에 전달 받은 값을 할당한다.
			GlobalMapThreadLocal.set(Util.GLOBAL_KEY1, "GMTL-1-" + value);
			GlobalMapThreadLocal.set(Util.GLOBAL_KEY2, "GMTL-2-" + value);

			// 현재 Thread 내에서 GlobalThrealLocal 변수내의 값을 출력한다.
			Util.printCurrentThreadLocalStatus(this);

			// Multi-Thread 환경을 흉내내기 위해 일정기간(Random) 동안 대기한다.
			Util.sleep_for_a_while();
			new ControlTier().execute();

		}

	}

	class ControlTier {

		public void execute() throws InterruptedException {

			// 현재 Thread 내에서 GlobalThrealLocal 변수내의 값을 출력한다.
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

		// 현재 Thread 내에서 설정된 GlobalThreadLocal 내의 값을 출력한다. 
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