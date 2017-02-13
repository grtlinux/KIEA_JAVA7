package tain.kr.com.test.designpattern.javaThreads.ch06.v01;

public class DeadlockDetectedException extends RuntimeException {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	public DeadlockDetectedException(String s) {
	super(s);
    }
}
