
package dictionary;

import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class PersonalMultipleEntryDictionary implements MultipleEntryDictionary {
    
    private Map<String, ArrayList<String>> dictionary;
    
    public PersonalMultipleEntryDictionary() {
        this.dictionary = new HashMap<String, ArrayList<String>>();
    }
    
    @Override
    public void add(String word, String entry) {
        if (!this.dictionary.containsKey(word)) {
            this.dictionary.put(word, new ArrayList<String>());
        }
        this.dictionary.get(word).add(entry);
    }

    @Override
    public Set<String> translate(String word) {
        Set<String> translated = new HashSet<String>();
        if (!this.dictionary.containsKey(word)) {
            return null;
        }
        for (String s : this.dictionary.get(word)) {
            translated.add(s);
        }
        return translated;
    }

    @Override
    public void remove(String word) {
        this.dictionary.remove(word);
    }
}
