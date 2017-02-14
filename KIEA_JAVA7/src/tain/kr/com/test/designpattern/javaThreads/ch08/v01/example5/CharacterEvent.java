package tain.kr.com.test.designpattern.javaThreads.ch08.v01.example5;

public class CharacterEvent {
    public CharacterSource source;
    public int character;

    public CharacterEvent(CharacterSource cs, int c) {
        source = cs;
        character = c;
    }
}
