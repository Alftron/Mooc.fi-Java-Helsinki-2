import java.util.Scanner;

public class TextUserInterface {
    private Scanner input;
    private Dictionary words;
    
    public TextUserInterface(Scanner reader, Dictionary dictionary) {
        input = reader;
        words = dictionary;
    }
    
    public void start() {
        System.out.println("Statement:");
        System.out.println("  add - adds a word pair to the dictionary");
        System.out.println("  translate - asks a word and prints its translation");
        System.out.println("  quit - quit the text user intercace");
        
        while (true) {
            System.out.print("Statement: ");
            String in = input.nextLine();
            if (in.equals("quit")) {
                System.out.println("Cheers");
                break;
            } else if (in.equals("add")) {
                add();
            } else if (in.equals("translate")) {
                translate();
            } else {
                System.out.println("Unknown statement");
            }
        }

    }
    
    public void add() {
        System.out.print("In Finnish: ");
        String word = input.nextLine();
        System.out.print("Translation: ");
        String translation = input.nextLine();
        words.add(word, translation);
    }
    
    public void translate() {
        System.out.print("Give a word: ");
        String translateIn = input.nextLine();
        System.out.println("Translation: " + words.translate(translateIn));
    }
}
