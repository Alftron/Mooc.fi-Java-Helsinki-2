
package reader.criteria;

public class EndsWithQuestionOrExclamationMark implements Criterion {

    @Override
    public boolean complies(String line) {
        if (line.isEmpty()) {
            return false;
        }
        
        int lastCharacterIndex = line.length()-1;
        if (line.charAt(lastCharacterIndex) == '?' || line.charAt(lastCharacterIndex) == '!') {
            return true;
        }

        return false;
    }
    
}
