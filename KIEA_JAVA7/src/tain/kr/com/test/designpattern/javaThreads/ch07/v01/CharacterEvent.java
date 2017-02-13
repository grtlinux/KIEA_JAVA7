package tain.kr.com.test.designpattern.javaThreads.ch07.v01;

public class CharacterEvent {
    public CharacterSource source;
    public int character;

    public CharacterEvent(CharacterSource cs, int c) {
        source = cs;
        character = c;
    }
}
