import java.util.HashMap;
import java.util.ArrayList;

public class Dictionary {
    private HashMap<String, String> map;
    
    public Dictionary() {
        map = new HashMap<String, String>();
    }
    
    public String translate(String word) {
        if (map.containsKey(word)) {
            return map.get(word);
        } else {
            return null;
        }
    }
    
    public void add(String word, String translation) {
        map.put(word, translation);
    }
    
    public int amountOfWords() {
        return map.size();
    }
    
    public ArrayList<String> translationList() {
        ArrayList<String> words = new ArrayList<String>();
        for (String word : map.keySet()) {
            words.add(word + " = " + map.get(word));
        }
        return words;
    }
}
