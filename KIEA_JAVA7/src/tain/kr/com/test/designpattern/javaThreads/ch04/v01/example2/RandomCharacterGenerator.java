package tain.kr.com.test.designpattern.javaThreads.ch04.v01.example2;

import java.util.Random;

import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterEventHandler;
import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterSource;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static char[] chars;
    private static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    private Random random;
    private CharacterEventHandler handler;
    private boolean done = true;

    public RandomCharacterGenerator() {
        random = new Random();
        handler = new CharacterEventHandler();
    }

    public int getPauseTime() {
        return (int) (Math.max(1000, 5000 * random.nextDouble()));
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
	public synchronized void run() {
        while (true) {
            try {
                if (done) {
                    wait();
                } else {
                    nextCharacter();
                    wait(getPauseTime());
                }
	    } catch (InterruptedException ie) {
	        return;
	    }
	}
    }

    public synchronized void setDone(boolean b) {
        done = b;

        if (!done)
            notify();
    }
}
