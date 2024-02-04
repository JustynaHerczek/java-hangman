package pl.edu.agh.hangman;

import java.util.ArrayList;
import java.util.Random;

public class RandomWord {
    private final ArrayList<String> words;

    public RandomWord(ArrayList<String> wordList) {
        this.words = wordList;
    }

    public String getRandomWord() {

        if (words == null || words.size() == 0) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }
}
