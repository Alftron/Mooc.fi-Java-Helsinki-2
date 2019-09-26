
package wordinspection;

import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class WordInspection {
    private File fileToAnalyse;
    
    public WordInspection(File file) {
        fileToAnalyse = file;
    }
    
    public int wordCount() throws Exception {
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        int wordCount = 0;
        while (reader.hasNextLine()) {
            wordCount++;
            reader.nextLine();
        }
        return wordCount;
    }
    
    public List<String> wordsContainingZ() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            if (line.contains("z")) {
                words.add(line);
            }
        }
        return words;
    }
    
    public List<String> wordsEndingInL() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            char lastLetter = line.charAt(line.length()-1);
            if (lastLetter == 'L' || lastLetter == 'l') {
                words.add(line);
            }
        }
        return words;
    }
    
    public List<String> palindromes() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String lineReverse = "";
            for (int i = line.length() - 1; i >= 0; i--) {
                lineReverse += line.charAt(i);
            }
            if (line.equals(lineReverse)) {
                words.add(line);
            }
        }
        return words;
    }
    
    public List<String> wordsWhichContainAllVowels() throws Exception {
        List<String> words = new ArrayList<String>();
        Scanner reader = new Scanner(fileToAnalyse, "UTF-8");
        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String vowels = "aeiouyäö";
            boolean validWord = true;
            for (char c : vowels.toCharArray()) {
                if (line.indexOf(c) == -1) {
                    validWord = false;
                    break;
                }
            }
            if (validWord) {
                words.add(line);
            }
        }
        return words;
    }
}
