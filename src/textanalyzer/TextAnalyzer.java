package textanalyzer;

import java.io.*;
import java.util.*;

/**
 * This class performs a simple text analysis, returning the number of characters, the number of words and the
 * cardinality of each word within the file.
 */
public class TextAnalyzer {

    private String fileContent;

    public TextAnalyzer(String filePath) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            var stringBuilder = new StringBuilder();
            var line = reader.readLine();
            stringBuilder.append(line).append("\n");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }
            this.fileContent = stringBuilder.toString();
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("File " + filePath + " not found!");
        } catch (IOException e) {
            System.out.println("Error occurred while reading the file: " + filePath);
        }
    }

    /**
     * This method performs the counting of the characters within the file
     * @return an integer representing the number of chars in the file
     */
    public int charCounter() {
        return fileContent.replace(" ", "").length();
    }

    /**
     * This method returns the number of words in the file
     * @return an integer representing the number of words within the file
     */
    public int wordCounter() {
        return fileContent.split(" ").length;
    }

    /**
     * This method returns a map representing the frequency of each word within the file
     * @return a hash map representing the frequency of each word within the file.
     */
    public HashMap<String, Integer> returnWordFrequencies() {
        HashMap<String, Integer> wordCountMap = new HashMap<>();
        Set<String> wordsArray =
                new LinkedHashSet<String>(
                        Arrays.stream(this.fileContent.split(" ")).toList());

        ArrayList<String> words = new ArrayList<>(wordsArray);

        for (String word: words) {
            wordCountMap.put(word, returnWordCountInFile(word));
        }

        return wordCountMap;
    }

    /**
     * This method returns the cardinality of the word passed as argument in the file.
     * @param word: the word of which return the cardinality
     * @return an integer representing the cardinality passed as argument
     */
    private int returnWordCountInFile(String word) {
        var sum = 0;
        for (String wordContent: Arrays.stream(this.fileContent.split(" ")).toList()) {
            if (word.equals(wordContent)) {
                sum += 1;
            }
        }

        return sum;
    }

}
