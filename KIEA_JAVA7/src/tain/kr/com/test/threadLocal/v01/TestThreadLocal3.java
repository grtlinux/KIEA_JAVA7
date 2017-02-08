package tain.kr.com.test.threadLocal.v01;

import java.util.Random;

class GlobalThreadLocal {
	private static ThreadLocal<Object> globalThreadLocalRef = new ThreadLocal<Object>();

	public static Object get() {
		return globalThreadLocalRef.get();
	}

	public static void set(Object newValue) {
		globalThreadLocalRef.set(newValue);
	}
	public static ThreadLocal<Object> getThreadLocal() {
		return globalThreadLocalRef;
	}
}

public class TestThreadLocal3 {

	public static void main(String[] args) {
		TestThreadLocal3 test3 = new TestThreadLocal3();
		new Thread(test3.new TestThread("AAA"), "쓰레드-A").start();
		new Thread(test3.new TestThread("BBB"), "쓰레드-B").start();
		new Thread(test3.new TestThread("CCC"), "쓰레드-C").start();
	}

	// 구분을 위해 고유 값 threadIdValue 을 갖는 Thread 로 변경
	class TestThread implements Runnable {
		private Object threadIdValue;
		public TestThread(Object threadIdValue) {
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

			// GlobalThrealLocal 변수내에 전달 받은 값을 할당한다.
			Util.save_value_to_GlobalThreadLocal(this, value);

			// 현재 Thread 내에서 GlobalThrealLocal 변수내의 값을 출력한다.
			Util.printCurrentThreadLocalStatus(this);

			ThreadLocal<Object> tl = GlobalThreadLocal.getThreadLocal();
			@SuppressWarnings("unused")
			Object val = tl.get();

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

		public static void save_value_to_GlobalThreadLocal(Object caller,
				Object value) {
			print("[" + Util.getCaller(caller) + "]GlobalThreadLocal에  저장  '"
					+ value + "'");
			GlobalThreadLocal.set(value);
		}

		// 현재 Thread 내에서 설정된 GlobalThreadLocal 내의 값을 출력한다. 
		public static void printCurrentThreadLocalStatus(Object caller) {

			print("[" + getCaller(caller) + "]GlobalThreadLocal:Reference["
					+ GlobalThreadLocal.getThreadLocal() + "]Value["
					+ GlobalThreadLocal.get() + "]");
		}
	}

}