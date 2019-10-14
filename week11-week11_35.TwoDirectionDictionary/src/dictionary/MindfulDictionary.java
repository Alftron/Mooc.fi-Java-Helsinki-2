
package dictionary;

import java.util.Map;
import java.util.HashMap;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class MindfulDictionary {
    
    private Map<String, String> finnishToEnglish;
    private Map<String, String> englishToFinnish;
    private File file;
    
    public MindfulDictionary() {
        this.finnishToEnglish = new HashMap<String, String>();
        this.englishToFinnish = new HashMap<String, String>();
    }
    
    public MindfulDictionary(String file) {
        this();
        this.file = new File(file);
    }
    
    public boolean load() {
        try {
            Scanner reader = new Scanner(this.file);
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(":");
                this.add(parts[0], parts[1]);
            }
            return true;
        } catch (Exception FileNotFoundException) {
            return false;
        }
    }
    
    public boolean save() {
        try {
            FileWriter out = new FileWriter(this.file);
            for (String word : this.finnishToEnglish.keySet()) {
                out.write(word + ":" + this.finnishToEnglish.get(word) +"\n");
            }
            out.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public void add(String word, String translation) {
        // Adds a word to the dictionary. Each word has only one translation; if the same word is added twice, nothing happens.
        if (!this.finnishToEnglish.containsKey(word)) {
            this.finnishToEnglish.put(word, translation);
            this.englishToFinnish.put(translation, word);           
        }
    }
    
    public String translate(String word) {
        // Returns the word translation; if the word isn't recognised, it returns null
        if (this.finnishToEnglish.containsKey(word)) {
            return this.finnishToEnglish.get(word);
        }
        if (this.englishToFinnish.containsKey(word)) {
            return this.englishToFinnish.get(word);
        }
        return null;
    }
    
    public void remove(String word) {
        // Removes the given word and its translation from your dictionary.
        if (this.finnishToEnglish.containsKey(word)) {
            String translated = this.finnishToEnglish.get(word);
            this.finnishToEnglish.remove(word);
            this.englishToFinnish.remove(translated);
            
        } else if (this.englishToFinnish.containsKey(word)) {
            String translated = this.englishToFinnish.get(word);
            this.englishToFinnish.remove(word);
            this.finnishToEnglish.remove(translated);
        }
    }
    
}
