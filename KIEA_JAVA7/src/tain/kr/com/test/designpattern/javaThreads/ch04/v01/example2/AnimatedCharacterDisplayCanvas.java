package tain.kr.com.test.designpattern.javaThreads.ch04.v01.example2;

import java.awt.Dimension;
import java.awt.Graphics;

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
    private Thread timer = null;
    private Object doneLock = new Object();

    public AnimatedCharacterDisplayCanvas() {
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
    }

    public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        tmpChar[0] = (char) ce.character;
        repaint();
    }

    protected synchronized void paintComponent(Graphics gc) {
        Dimension d = getSize();
        gc.clearRect(0, 0, d.width, d.height);
        if (tmpChar[0] == 0)
            return;
        int charWidth = fm.charWidth(tmpChar[0]);
        gc.drawChars(tmpChar, 0, 1,
                     curX++, fontHeight);
    }

    public void run() {
	synchronized(doneLock) {
            while (true) {
                try {
                    if (done) {
                        doneLock.wait();
                    } else {
                        repaint();
                        doneLock.wait(100);
                    }
                } catch (InterruptedException ie) {
                    return;
                }
            }
	}
    }

    public void setDone(boolean b) {
	synchronized(doneLock) {
            done = b;

            if (timer == null) {
                timer = new Thread(this);
                timer.start();
            }
            if (!done)
                doneLock.notify();
	}
    }
 }
