import java.util.Random;

class GlobalThreadLocal {
	private static ThreadLocal globalThreadLocalRef = new ThreadLocal();

	public static Object get() {
		return globalThreadLocalRef.get();
	}

	public static void set(Object newValue) {
		globalThreadLocalRef.set(newValue);
	}
	public static ThreadLocal getThreadLocal() {
		return globalThreadLocalRef;
	}
}

public class TestThreadLocal3 {

	public static void main(String[] args) {
		TestThreadLocal3 test3 = new TestThreadLocal3();
		new Thread(test3.new TestThread("AAA"), "������-A").start();
		new Thread(test3.new TestThread("BBB"), "������-B").start();
		new Thread(test3.new TestThread("CCC"), "������-C").start();
	}

	// ������ ���� ���� �� threadIdValue �� ���� Thread �� ����
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

			// GlobalThrealLocal �������� ���� ���� ���� �Ҵ��Ѵ�.
			Util.save_value_to_GlobalThreadLocal(this, value);

			// ���� Thread ������ GlobalThrealLocal �������� ���� ����Ѵ�.
			Util.printCurrentThreadLocalStatus(this);

			ThreadLocal tl = GlobalThreadLocal.getThreadLocal();
			Object val = tl.get();

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
			print("[" + Util.getCaller(caller) + "]GlobalThreadLocal��  ����  '"
					+ value + "'");
			GlobalThreadLocal.set(value);
		}

		// ���� Thread ������ ������ GlobalThreadLocal ���� ���� ����Ѵ�. 
		public static void printCurrentThreadLocalStatus(Object caller) {

			print("[" + getCaller(caller) + "]GlobalThreadLocal:Reference["
					+ GlobalThreadLocal.getThreadLocal() + "]Value["
					+ GlobalThreadLocal.get() + "]");
		}
	}

}