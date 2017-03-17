package tain.kr.com.test.designpattern.javaThreads.ch05.v01.example3;

import java.util.Random;
import java.util.concurrent.atomic.AtomicBoolean;

import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterEventHandler;
import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterSource;

public class RandomCharacterGenerator extends Thread implements CharacterSource {
    private static char[] chars;
    private static String charArray = "abcdefghijklmnopqrstuvwxyz0123456789";
    static {
        chars = charArray.toCharArray();
    }

    private Random random;
    private CharacterEventHandler handler;
    private AtomicBoolean done = new AtomicBoolean(true);

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
        while (true) {
            try {
                if (done.get()) {
                    Thread.sleep(100);
                } else {
                    nextCharacter();
                    Thread.sleep(getPauseTime());
                }
            } catch (InterruptedException ex) {
                return;
            }
        }
    }

    public void setDone(boolean b) {
        done.set(b);
    }
}
