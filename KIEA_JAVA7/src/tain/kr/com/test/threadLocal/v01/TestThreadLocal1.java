package tain.kr.com.test.threadLocal.v01;

class TestObject {
	public String testMember1;
	public String testMember2;
	@Override
	public String toString() {
		return ("TestObject.testMember1[" + testMember1 + "]testMember2["
				+ testMember2 + "]");
	}
}

public class TestThreadLocal1 {

	public static void main(String[] args) {

		// ThrealLocal 변수를 하나 생성한다. 
		ThreadLocal<Object> myThreadLocal = new ThreadLocal<Object>();  
		myThreadLocal.set("ThreadLocal변수");

		System.out.println("자체ThreadLocal:Reference[" + myThreadLocal
				+ "]Value[" + myThreadLocal.get() + "]");

		// ThrealLocal 변수에 담을 TestObject를 하나 생성한다. 		
		TestObject testObj = new TestObject();
		testObj.testMember1 = "testMember1_value";
		testObj.testMember2 = "testMember2_value";
		myThreadLocal.set(testObj);

		System.out.println("자체ThreadLocal:Reference[" + myThreadLocal
				+ "]Value[" + myThreadLocal.get() + "]");

		// 새로운 ThrealLocal 변수를 하나 생성한다. 
		myThreadLocal = new ThreadLocal<Object>();
		myThreadLocal.set("NEW_ThreadLocal변수");
		System.out.println("자체ThreadLocal:Reference[" + myThreadLocal
				+ "]Value[" + myThreadLocal.get() + "]");

	}
}