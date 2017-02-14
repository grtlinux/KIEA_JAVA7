package tain.kr.com.test.designpattern.javaThreads.ch10.v01.example2;

import tain.kr.com.test.designpattern.javaThreads.ch10.v01.SingleThreadAccess;
import tain.kr.com.test.designpattern.javaThreads.ch10.v01.Task;

public class SingleThreadTest {

    public static void main(String[] args) {
        int nTasks = Integer.parseInt(args[0]);
	int fib = Integer.parseInt(args[1]);
	SingleThreadAccess sta = new SingleThreadAccess();
	for (int i = 0; i < nTasks; i++)
	    sta.invokeLater(new Task(fib, "Task " + i));
	sta.shutdown();
    }
}
