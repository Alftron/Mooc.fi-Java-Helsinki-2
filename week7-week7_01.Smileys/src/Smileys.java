
public class Smileys {

    public static void main(String[] args) {
        // Test your method at least with the following
        printWithSmileys("Method");
        printWithSmileys("Beerbottle");
        printWithSmileys("Interface");
    }
    
    private static void printWithSmileys(String characterString) {
        int length = characterString.length();
        String smiley = ":)";
        if (length % 2 == 0) {
            // even
            length = (length + 6) / 2;
            printSmileyRow(length, smiley);
            System.out.println(smiley + " " + characterString + " " + smiley);
            printSmileyRow(length, smiley);
        } else {
            // odd
            length = (length + 7) / 2;
            printSmileyRow(length, smiley);
            System.out.println(smiley + " " + characterString + "  " + smiley);
            printSmileyRow(length, smiley);
        }
    }
    
    private static void printSmileyRow(int length, String smiley) {
        for (int i = 0; i < length; i++) {
            System.out.print(smiley);
        }
        System.out.println();
    }
    

}
