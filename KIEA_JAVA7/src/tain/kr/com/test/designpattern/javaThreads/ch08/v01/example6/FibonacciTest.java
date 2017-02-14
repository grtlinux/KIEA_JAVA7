package tain.kr.com.test.designpattern.javaThreads.ch08.v01.example6;

import java.util.concurrent.ArrayBlockingQueue;

public class FibonacciTest {

    public static void main(String[] args) {

        ArrayBlockingQueue<Integer> queue;
        queue = new ArrayBlockingQueue<Integer>(10);
        new FibonacciProducer(queue);

        int nThreads = Integer.parseInt(args[0]);
        for (int i = 0; i < nThreads; i++)
            new FibonacciConsumer(queue);
    }
}
