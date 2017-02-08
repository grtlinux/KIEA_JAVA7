import java.util.Random;

public class TestThreadLocal2 {

	public static void main(String[] args) {
		TestThreadLocal2 test2 = new TestThreadLocal2();
		new Thread(test2.new TestThread(),"쓰레드-A").start();
		new Thread(test2.new TestThread(),"쓰레드-B").start();
		new Thread(test2.new TestThread(),"쓰레드-C").start();
	}

	class TestThread implements Runnable {

		public void run() {
			try {
				Util.sleep_for_a_while();
				new CMDTier().execute();
			} catch (InterruptedException x) {
				// do nothing
			}
		}

	}

	class CMDTier {

		public void execute() throws InterruptedException {
			// ThrealLocal 변수를 하나 생성한다. 
			ThreadLocal myThreadLocal = new ThreadLocal();
			
			// CMD_ThreadLocal 이란 String 값을 할당한다. 
			myThreadLocal.set("CMD_ThreadLocal");
			
			// ThrealLocal 변수내의 값을 출력한다.  			
			Util.print_myThreadLocal(this, myThreadLocal);

			// Multi-Thread 환경을 흉내내기 위해 일정기간(Random) 동안 대기한다.    
			Util.sleep_for_a_while();
			new ControlTier().execute();

		}

	}
	
	class ControlTier {

		public void execute() throws InterruptedException {
			
			// ThrealLocal 변수를 하나 생성한다. 
			ThreadLocal myThreadLocal = new ThreadLocal();
			
			// ThrealLocal 변수내의 값을 출력한다.  	
			Util.print_myThreadLocal(this, myThreadLocal);			
			
 
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
		public static void print_myThreadLocal(Object caller,
				ThreadLocal myThreadLocal) {
			
			Util.print("[" + Util.getCaller(caller) + "]-자체ThreadLocal:Reference["
					+ myThreadLocal + "]Value["+myThreadLocal.get()+"]");
		}
	}

}