package pl.edu.agh.hangman;

import java.util.Random;

public class RandomWord {
    private String[] words;

    public RandomWord(String[] wordList) {
        this.words = wordList;
    }

    public String getRandomWord() {
        if (words == null || words.length == 0) {
            return null;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(words.length);

        return words[randomIndex];
    }
}
