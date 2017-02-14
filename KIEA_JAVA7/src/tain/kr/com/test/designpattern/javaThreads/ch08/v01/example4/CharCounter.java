package tain.kr.com.test.designpattern.javaThreads.ch08.v01.example4;

import java.util.HashMap;

import javax.swing.table.AbstractTableModel;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CharCounter {
    public HashMap correctChars = new HashMap();
    public HashMap incorrectChars = new HashMap();
    private AbstractTableModel atm;

    public void correctChar(int c) {
        synchronized(correctChars) {
            Integer key = new Integer(c);
            Integer num = (Integer) correctChars.get(key);
            if (num == null)
                correctChars.put(key, new Integer(1));
            else correctChars.put(key, new Integer(num.intValue() + 1));
            if (atm != null)
                atm.fireTableDataChanged();
        }
    }

    public int getCorrectNum(int c) {
        synchronized(correctChars) {
            Integer key = new Integer(c);
            Integer num = (Integer) correctChars.get(key);
            if (num == null)
                return 0;
            return num.intValue();
        }
    }

    public void incorrectChar(int c) {
        synchronized(incorrectChars) {
            Integer key = new Integer(c);
            Integer num = (Integer) incorrectChars.get(key);
            if (num == null)
                incorrectChars.put(key, new Integer(-1));
            else incorrectChars.put(key, new Integer(num.intValue() - 1));
            if (atm != null)
                atm.fireTableDataChanged();
        }
    }

    public int getIncorrectNum(int c) {
        synchronized(incorrectChars) {
            Integer key = new Integer(c);
            Integer num = (Integer) incorrectChars.get(key);
            if (num == null)
                return 0;
            return num.intValue();
        }
    }

    public void addModel(AbstractTableModel atm) {
        this.atm = atm;
    }
}
