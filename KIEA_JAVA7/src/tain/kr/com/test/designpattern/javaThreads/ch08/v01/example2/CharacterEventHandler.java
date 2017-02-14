package tain.kr.com.test.designpattern.javaThreads.ch08.v01.example2;

import java.util.*;

@SuppressWarnings({"rawtypes", "unchecked"})
public class CharacterEventHandler {
    private ArrayList listeners = new ArrayList();

    public synchronized void addCharacterListener(CharacterListener cl) {
        listeners.add(cl);
    }

    public synchronized void removeCharacterListener(CharacterListener cl) {
        listeners.remove(cl);
    }

    public synchronized void fireNewCharacter(CharacterSource source, int c) {
        CharacterEvent ce = new CharacterEvent(source, c);
        CharacterListener[] cl = (CharacterListener[] )
                                 listeners.toArray(new CharacterListener[0]);
        for (int i = 0; i < cl.length; i++)
            cl[i].newCharacter(ce);
    }
}
