
[ ������ ���� ]

	�׷� ������ �̾߱��� ���� ���������� �����غ���. �켱 �߿��� ���� Ŭ�������� �Ʒ��� ����.
	
		Throwable
		Error
		Exception
		Runtime Exception

	�� Ŭ���� ���� ��� ���踦 �׸����� ��Ÿ���� �Ʒ��� ����.

Throwable  --- Error
               Exception  --- IOException
                              RuntimeException --- ArithmeticException				
		
	Throwable
		Ŭ���� Throwable�� �� ���� Ŭ�������� ����� �����̴�. ��� ���� Ŭ�������� ������ �ִ� 
		����� �޼ҵ带 �����ϰ� �ִ�. �߿��� ������ �ϴ� Ŭ�����ӿ��� Ʋ�������� �� Ŭ������ 
		���� ��������� �ʱ� ������ �츮���Դ� �߿����� �ʴ�.
	
	Error
		������ �������� ���ø����̼��� ������ �ƴ϶� �� ���ø����̼��� �����ϴ� ����ӽſ� 
		������ ������ �� �߻��ϴ� ���ܴ�. ���ø����̼��� ������Ű�⿡�� �޸𸮰� ������ 
		��찡 �̿� ���Ѵ�. �̷� ���� ���ø����̼� �����ڰ� �� �� �ִ� ���� ����. 
		���� ����ó���� ���� ���� �׳� ������ ���ؼ� ���ø����̼��� �ߴܵǵ��� �������д�. 
		��� �ڽ��� ���ø����̼��� �޸𸮸� �����ϰ� ����ϰ� �ִٸ� ������ �����ϰų� �ڹ� 
		����ӽſ��� ����ϴ� �޸��� ������ �����ϴ� ���� ������ �Ѵ�.
	
	Exception
		�ᱹ �츮�� ���ɻ�� Exception Ŭ������ RuntimeException Ŭ������ ��������. 
		�켱 Exception Ŭ������ ���� Ŭ�������� ����� ���캸��. �Ʒ� Ŭ�������� ��� 
		Exception Ŭ������ ����� ���� Ŭ������.
	
		���ڰ� ���� ǥ���� �κ��� ����. �� ���� Ŭ���� ���� �ϳ��� RuntimeException�̴�. 
		����ü RuntimeException Ŭ������ � Ư������ �ֱ淡 �θ� Ŭ������ Exception 
		Ŭ������ �Բ� ��޵Ǵ� ���ϱ�? RuntimeException�� ������ Exception Ŭ������ 
		���� Ŭ������� RuntimeException Ŭ������ ���̸� �ڹٿ����� checked�� unckecked��� �θ���. 
		���踦 �����ϸ� �Ʒ��� ����.
	
			checked ���� - RuntimeException�� ������ Exception�� ���� Ŭ����
			
				java.lang.Object
					java.lang.Throwable
						java.lang.Exception
							java.io.IOException
			
			unchecked ���� - RuntimeException�� ���� Ŭ����
	
				java.lang.Object
					java.lang.Throwable
						java.lang.Exception
							java.lang.RuntimeException
								java.lang.ArithmeticException
		
		���� ǥ���� �κ��� ���� ��� ���캸��. ArithmeticException�� �θ� �߿� RuntimeException�� �ִ�. 
		�ݸ鿡 IOException�� Exception�� �ڽ������� RuntimeException�� �ڽ��� �ƴϴ�. �̷� ������ 
		IOException�� checked�̰� ArithmeticException�� unchekced�̴�. (Error�� unchecked�̴�)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	