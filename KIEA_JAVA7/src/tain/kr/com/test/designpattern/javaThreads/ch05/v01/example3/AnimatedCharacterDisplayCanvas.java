package tain.kr.com.test.designpattern.javaThreads.ch05.v01.example3;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterDisplayCanvas;
import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterEvent;
import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch05.v01.CharacterSource;

@SuppressWarnings("unused")
public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas implements CharacterListener, Runnable {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private AtomicBoolean done = new AtomicBoolean(true);
    private AtomicInteger curX = new AtomicInteger(0);
    private AtomicInteger tempChar = new AtomicInteger(0);
    private Thread timer = null;

    public AnimatedCharacterDisplayCanvas() {
        startAnimationThread();
    }

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
        startAnimationThread();
    }

    private void startAnimationThread() {
        if (timer == null) {
            timer = new Thread(this);
            timer.start();
        }
    }

    public void newCharacter(CharacterEvent ce) {
        curX.set(0);
        tempChar.set(ce.character);
        repaint();
    }

	protected void paintComponent(Graphics gc) {
        char[] localTmpChar = new char[1];
        localTmpChar[0] = (char) tempChar.get();
        int localCurX = curX.get();

        Dimension d = getSize();
        int charWidth = fm.charWidth(localTmpChar[0]);
        gc.clearRect(0, 0, d.width, d.height);
        if (localTmpChar[0] == 0)
            return;

        gc.drawChars(localTmpChar, 0, 1,
                     localCurX, fontHeight);
        curX.getAndIncrement();
    }

    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
                if (!done.get()) {
                    repaint();
                }
            } catch (InterruptedException ie) {
                return;
            }
        }
    }

    public void setDone(boolean b) {
        done.set(b);
    }
}
