package textanalyzer;

import java.io.*;
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

    public int charCounter() {
        return fileContent.replace(" ", "").length();
    }

    public int wordCounter() {
        return fileContent.split(" ").length;
    }

    public String returnWordFrequencies() {
        return null;
    }

}
