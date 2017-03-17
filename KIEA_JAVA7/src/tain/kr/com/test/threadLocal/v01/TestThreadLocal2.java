package tain.kr.com.test.threadLocal.v01;

import java.util.Random;

public class TestThreadLocal2 {

	public static void main(String[] args) {
		TestThreadLocal2 test2 = new TestThreadLocal2();
		new Thread(test2.new TestThread(),"������-A").start();
		new Thread(test2.new TestThread(),"������-B").start();
		new Thread(test2.new TestThread(),"������-C").start();
	}

	class TestThread implements Runnable {

		@Override
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
			// ThrealLocal ������ �ϳ� �����Ѵ�. 
			ThreadLocal<Object> myThreadLocal = new ThreadLocal<Object>();
			
			// CMD_ThreadLocal �̶� String ���� �Ҵ��Ѵ�. 
			myThreadLocal.set("CMD_ThreadLocal");
			
			// ThrealLocal �������� ���� ����Ѵ�.  			
			Util.print_myThreadLocal(this, myThreadLocal);

			// Multi-Thread ȯ���� �䳻���� ���� �����Ⱓ(Random) ���� ����Ѵ�.    
			Util.sleep_for_a_while();
			new ControlTier().execute();

		}

	}
	
	class ControlTier {

		public void execute() throws InterruptedException {
			
			// ThrealLocal ������ �ϳ� �����Ѵ�. 
			ThreadLocal<Object> myThreadLocal = new ThreadLocal<Object>();
			
			// ThrealLocal �������� ���� ����Ѵ�.  	
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
		public static void print_myThreadLocal(Object caller, ThreadLocal<Object> myThreadLocal) {
			
			Util.print("[" + Util.getCaller(caller) + "]-��üThreadLocal:Reference["
					+ myThreadLocal + "]Value["+myThreadLocal.get()+"]");
		}
	}

}