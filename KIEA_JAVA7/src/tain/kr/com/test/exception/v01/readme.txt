
[ 예외의 종류 ]

	그럼 위에서 이야기한 것을 개념적으로 정리해보자. 우선 중요한 예외 클래스들은 아래와 같다.
	
		Throwable
		Error
		Exception
		Runtime Exception

	이 클래스 간의 상속 관계를 그림으로 나타내면 아래와 같다.

Throwable  --- Error
               Exception  --- IOException
                              RuntimeException --- ArithmeticException				
		
	Throwable
		클래스 Throwable은 범 예외 클래스들의 공통된 조상이다. 모든 예외 클래스들이 가지고 있는 
		공통된 메소드를 정의하고 있다. 중요한 역할을 하는 클래스임에는 틀림없지만 이 클래스를 
		직접 사용하지는 않기 때문에 우리에게는 중요하지 않다.
	
	Error
		에러는 여러분의 애플리케이션의 문제가 아니라 그 애플리케이션이 동작하는 가상머신에 
		문제가 생겼을 때 발생하는 예외다. 애플리케이션을 구동시키기에는 메모리가 부족한 
		경우가 이에 속한다. 이런 경우는 애플리케이션 개발자가 할 수 있는 것이 없다. 
		따라서 예외처리를 하지 말고 그냥 에러로 인해서 애플리케이션이 중단되도록 내버려둔다. 
		대신 자신의 애플리케이션이 메모리를 과도하게 사용하고 있다면 로직을 변경하거나 자바 
		가상머신에서 사용하는 메모리의 제한을 변경하는 등의 대응을 한다.
	
	Exception
		결국 우리의 관심사는 Exception 클래스와 RuntimeException 클래스로 좁혀진다. 
		우선 Exception 클래스의 하위 클래스들의 목록을 살펴보자. 아래 클래스들은 모두 
		Exception 클래스를 상속한 예외 클래스다.
	
		필자가 강조 표시한 부분을 보자. 저 많은 클래스 중의 하나가 RuntimeException이다. 
		도대체 RuntimeException 클래스는 어떤 특이점이 있길래 부모 클래스인 Exception 
		클래스와 함께 언급되는 것일까? RuntimeException을 제외한 Exception 클래스의 
		하위 클래스들과 RuntimeException 클래스의 차이를 자바에서는 checked와 unckecked라고 부른다. 
		관계를 정리하면 아래와 같다.
	
			checked 예외 - RuntimeException을 제외한 Exception의 하위 클래스
			
				java.lang.Object
					java.lang.Throwable
						java.lang.Exception
							java.io.IOException
			
			unchecked 예외 - RuntimeException의 하위 클래스
	
				java.lang.Object
					java.lang.Throwable
						java.lang.Exception
							java.lang.RuntimeException
								java.lang.ArithmeticException
		
		강조 표시한 부분을 주의 깊게 살펴보자. ArithmeticException의 부모 중에 RuntimeException이 있다. 
		반면에 IOException은 Exception의 자식이지만 RuntimeException의 자식은 아니다. 이런 이유로 
		IOException은 checked이고 ArithmeticException은 unchekced이다. (Error도 unchecked이다)
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	