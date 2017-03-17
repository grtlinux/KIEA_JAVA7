package tain.kr.com.test.designpattern.javaThreads.ch11.v01;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings({"deprecation"})
public class CharacterDisplayCanvas extends JComponent implements CharacterListener {
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	protected FontMetrics fm;
    protected char[] tmpChar = new char[1];
    protected int fontHeight;

    public CharacterDisplayCanvas(CharacterSource cs) {
        setFont(new Font("Monospaced", Font.BOLD, 18));
        fm = Toolkit.getDefaultToolkit().getFontMetrics(getFont());
        fontHeight = fm.getHeight();
        cs.addCharacterListener(this);
    }

    public void setCharacterListener(CharacterSource cs) {
        cs.addCharacterListener(this);
    }

    @Override
	public Dimension preferredSize() {
        return new Dimension(fm.getMaxAscent() + 10,
                             fm.getMaxAdvance() + 10);
    }

    @Override
	public void newCharacter(CharacterEvent ce) {
        tmpChar[0] = (char) ce.character;
        repaint();
    }

    @Override
	protected void paintComponent(Graphics gc) {
        if (tmpChar[0] == 0)
            return;
        Dimension d = getSize();
        int charWidth = fm.charWidth((int) tmpChar[0]);
        gc.clearRect(0, 0, d.width, d.height);
        gc.drawChars(tmpChar, 0, 1,
                     (d.width - charWidth) / 2, fontHeight);
    }
}
