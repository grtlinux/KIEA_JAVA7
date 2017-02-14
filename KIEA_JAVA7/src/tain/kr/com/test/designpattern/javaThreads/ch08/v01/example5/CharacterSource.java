package tain.kr.com.test.designpattern.javaThreads.ch08.v01.example5;

public interface CharacterSource {
    public void addCharacterListener(CharacterListener cl);
    public void removeCharacterListener(CharacterListener cl);
    public void nextCharacter();
}    
