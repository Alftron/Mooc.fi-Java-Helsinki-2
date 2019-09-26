
package tools;

import java.util.Set;
import java.util.HashSet;

public class PersonalDuplicateRemover implements DuplicateRemover {
    private Set<String> uniqueWords;
    private int numDuplicates;
    
    public PersonalDuplicateRemover() {
        this.uniqueWords = new HashSet<String>();
        this.numDuplicates = 0;
    }
    
    @Override
    public void add(String characterString) {
        if (this.uniqueWords.contains(characterString)) {
            this.numDuplicates++;
        } else {
            this.uniqueWords.add(characterString);
        }
    }

    @Override
    public int getNumberOfDetectedDuplicates() {
        return this.numDuplicates;
    }

    @Override
    public Set<String> getUniqueCharacterStrings() {
        return this.uniqueWords;
    }

    @Override
    public void empty() {
        this.uniqueWords.clear();
        this.numDuplicates = 0;
    }
}
