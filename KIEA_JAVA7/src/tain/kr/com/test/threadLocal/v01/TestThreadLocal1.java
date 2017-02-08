class TestObject {
	public String testMember1;
	public String testMember2;
	public String toString() {
		return ("TestObject.testMember1[" + testMember1 + "]testMember2["
				+ testMember2 + "]");
	}
}

public class TestThreadLocal1 {

	public static void main(String[] args) {

		// ThrealLocal ������ �ϳ� �����Ѵ�. 
		ThreadLocal myThreadLocal = new ThreadLocal();  
		myThreadLocal.set("ThreadLocal����");

		System.out.println("��üThreadLocal:Reference[" + myThreadLocal
				+ "]Value[" + myThreadLocal.get() + "]");

		// ThrealLocal ������ ���� TestObject�� �ϳ� �����Ѵ�. 		
		TestObject testObj = new TestObject();
		testObj.testMember1 = "testMember1_value";
		testObj.testMember2 = "testMember2_value";
		myThreadLocal.set(testObj);

		System.out.println("��üThreadLocal:Reference[" + myThreadLocal
				+ "]Value[" + myThreadLocal.get() + "]");

		// ���ο� ThrealLocal ������ �ϳ� �����Ѵ�. 
		myThreadLocal = new ThreadLocal();
		myThreadLocal.set("NEW_ThreadLocal����");
		System.out.println("��üThreadLocal:Reference[" + myThreadLocal
				+ "]Value[" + myThreadLocal.get() + "]");

	}
}