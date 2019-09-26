
public class Change {
    public char fromChar;
    public char toChar;
    
    public Change(char fromCharacter, char toCharacter) {
        this.fromChar = fromCharacter;
        this.toChar = toCharacter;
    }
    
    public String change(String characterString) {
        String changedWord = "";
        for (int i = 0; i < characterString.length() ; i++) {
            if (characterString.charAt(i) == this.fromChar) {
                changedWord += this.toChar;
            } else {
                changedWord += characterString.charAt(i);
            }
        }
        return changedWord;
    }
    
}
