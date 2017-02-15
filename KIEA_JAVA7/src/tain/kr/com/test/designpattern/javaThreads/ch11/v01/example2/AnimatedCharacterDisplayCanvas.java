package tain.kr.com.test.designpattern.javaThreads.ch11.v01.example2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import tain.kr.com.test.designpattern.javaThreads.ch11.v01.CharacterDisplayCanvas;
import tain.kr.com.test.designpattern.javaThreads.ch11.v01.CharacterEvent;
import tain.kr.com.test.designpattern.javaThreads.ch11.v01.CharacterListener;
import tain.kr.com.test.designpattern.javaThreads.ch11.v01.CharacterSource;

public class AnimatedCharacterDisplayCanvas extends CharacterDisplayCanvas
             implements ActionListener, CharacterListener {

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private int curX;
    private Timer timer;

    public AnimatedCharacterDisplayCanvas(CharacterSource cs) {
        super(cs);
	timer = new Timer(100, this);
    }

    public synchronized void newCharacter(CharacterEvent ce) {
        curX = 0;
        tmpChar[0] = (char) ce.character;
        repaint();
    }

    public synchronized void paintComponent(Graphics gc) {
        if (tmpChar[0] == 0)
            return;
        Dimension d = getSize();
        int charWidth = fm.charWidth(tmpChar[0]);
        gc.clearRect(0, 0, d.width, d.height);
        gc.drawChars(tmpChar, 0, 1, curX++, fontHeight);
        if (curX > d.width - charWidth)
            curX = 0;
    }

    public void actionPerformed(ActionEvent ae) {
        repaint();
    }

    public void setDone(boolean b) {
        if (!b)
           timer.start();
        else timer.stop();
    }
}
