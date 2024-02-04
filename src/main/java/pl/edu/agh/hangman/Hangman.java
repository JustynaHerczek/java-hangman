package pl.edu.agh.hangman;


import java.util.Scanner;

public class Hangman {

    public static final String[] HANGMANPICS = new String[]{
            "  +---+\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    "  |   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|   |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    "      |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " /    |\n" +
                    "      |\n" +
                    "=========",
            "  +---+\n" +
                    "  |   |\n" +
                    "  O   |\n" +
                    " /|\\  |\n" +
                    " / \\  |\n" +
                    "      |\n" +
                    "========"
    };

    public static void main(String[] args) {
        WordReader wordReader = new WordReader();
        wordReader.readFile();


        RandomWord randomWord = new RandomWord(wordReader.getUppercaseWords());

        String randomWordString = randomWord.getRandomWord();

        WordCrypter wordCrypter = new WordCrypter(randomWordString);

        //System.out.println(randomWordString);
        System.out.println("WITAJ W GRZE WIESIELEC!!!");
        System.out.println("Poniżej wyświetla się zakodowane słowo");
        System.out.println(wordCrypter.cryptWord());
        HangManPrinter hangManPrinter = new HangManPrinter(HANGMANPICS);
        WordChecker wordChecker = new WordChecker(randomWordString, wordCrypter.cryptWord());
        while (wordChecker.getHP() > 0 && wordChecker.getNumberOfLettersToGuess() > 0) {
            System.out.println("Podaj literkę: ");
            Scanner scan = new Scanner(System.in);
            String choosenLetter = scan.nextLine().toUpperCase();
            if (wordChecker.checkIfLetterUsedBefore(choosenLetter)) {
                System.out.println("Już użyłeś tej litery!!!");
            } else {
                wordChecker.checkUserChoice(choosenLetter);
                System.out.println("Pozostało Ci " + wordChecker.getHP() + " HP");
                System.out.println("Pozostało Ci " + wordChecker.getNumberOfLettersToGuess() + " liter do odgadnięcia");
                hangManPrinter.printHangMan(wordChecker.getHP());
                System.out.println(wordChecker.getWordCrypted());
            }
        }
        if (wordChecker.getHP() == 0) {
            System.out.println("Zginałeś frajerze!");

        } else if (wordChecker.getNumberOfLettersToGuess() == 0) {
            System.out.println("Wygrales!!!");

        }

    }
}
