package tain.kr.com.test.designpattern.javaThreads.ch07.v01.example2;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tain.kr.com.test.designpattern.javaThreads.ch07.v01.CharacterEventHandler;
import tain.kr.com.test.designpattern.javaThreads.ch07.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch07.v01.CharacterSource;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static char[] chars;
    private static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    private Random random;
    private CharacterEventHandler handler;
    private boolean done = true;
    private Lock lock = new ReentrantLock();
    private Condition cv = lock.newCondition();

    public RandomCharacterGenerator() {
        random = new Random();
        handler = new CharacterEventHandler();
    }

    public int getPauseTime(int minTime, int maxTime) {
        return (int) (minTime + ((maxTime-minTime)*random.nextDouble()));
    }

    public int getPauseTime() {
        return getPauseTime(2000, 5500);
    }

    @Override
	public void addCharacterListener(CharacterListener cl) {
        handler.addCharacterListener(cl);
    }

    @Override
	public void removeCharacterListener(CharacterListener cl) {
        handler.removeCharacterListener(cl);
    }

    @Override
	public void nextCharacter() {
        handler.fireNewCharacter(this,
                                chars[random.nextInt(chars.length)]);
    }

    @Override
	public void run() {
        try {
            lock.lock();
            while (true) {
                try {
                    if (done) {
                        cv.await();
                    } else {
                        nextCharacter();
                        cv.await(getPauseTime(), TimeUnit.MILLISECONDS);
                    }
                } catch (InterruptedException ie) {
                    return;
                }
            }
        } finally {
            lock.unlock();
        }
    }

    public void setDone(boolean b) {
        try {
            lock.lock();
            done = b;

            if (!done) cv.signal();
        } finally {
            lock.unlock();
        }
    }
}
