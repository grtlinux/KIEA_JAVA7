package tain.kr.com.test.designpattern.javaThreads.ch04.v01.example3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterDisplayCanvas;
import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterEvent;
import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch04.v01.CharacterSource;

@SuppressWarnings("unused")
public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private boolean done = true;
    private int curX = 0;
    private Lock lock = new ReentrantLock();
    private Condition cv = lock.newCondition();
    private Thread timer = null;

    public AnimatedCharacterDisplayCanvas() {
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
    }

    @Override
	public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        tmpChar[0] = (char) ce.character;
        repaint();
    }

    @Override
	protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (tmpChar[0] == 0)
            return;
        int charWidth = fm.charWidth(tmpChar[0]);
        gc.drawChars(tmpChar, 0, 1,
                     curX++, fontHeight);
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
                        repaint();
                        cv.await(100, TimeUnit.MILLISECONDS);
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

            if (timer == null) {
                timer = new Thread(this);
                timer.start();
            }
            if (!done) cv.signal();
        } finally {
            lock.unlock();
        }
    }
 }
