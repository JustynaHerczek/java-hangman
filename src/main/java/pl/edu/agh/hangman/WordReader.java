package pl.edu.agh.hangman;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

public class WordReader {

    private List<String> uppercaseWords = new ArrayList<>();

    public void readFile() throws IOException {
        File file = new File("/home/students/k/a/kadlubic/java-hangman/src/main/resources/slowa.txt");
        String line;

        try (BufferedReader reader = Files.newBufferedReader(file.toPath())) {
            while ((line = reader.readLine()) != null)
                uppercaseWords.add(line.toUpperCase());
        } catch (IOException x) {
            System.err.format("IOException: %s", x);
        }
        for (String word : uppercaseWords)
            System.out.println(word);
    }
}
