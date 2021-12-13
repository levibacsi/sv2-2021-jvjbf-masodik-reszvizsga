package algorithms;

import java.util.ArrayList;
import java.util.List;

public class Words {


    private List<String> words = new ArrayList<>();

    public void addWord(String word){
        if (word.contains(" ")){
            throw new IllegalArgumentException("It should be one word!");
        }

        char[] charactersInWord = word.toCharArray();
        for (Character c: charactersInWord){
            if (c >= 97 && c <= 122) {
                words.add(word);
            } else throw new IllegalArgumentException("Word should be lower case!");
        }
    }

    public boolean isThereAWordTwice(){
        List<String> wordsUsed = new ArrayList<>();
        for (String word: words){
            if (wordsUsed.contains(word)){
                return true;
            } else {
                wordsUsed.add(word);
            }
        }
        return false;
    }

    public List<String> getWords() {
        return words;
    }
}

