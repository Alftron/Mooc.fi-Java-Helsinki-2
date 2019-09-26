
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class UserInterface {
    private Scanner input;
    private Phonebook phonebook;
    
    public UserInterface() {
        input = new Scanner(System.in);
        phonebook = new Phonebook();
    }
    
    public void run() {
        printMenu();
        String command = getCommand();
        while (!command.equals("x") && !command.equals("X")) {
            if (command.equals("1")) {
                // Add a number
                addNumber();
            } else if (command.equals("2")) {
                // Search for a number
                searchByName();
            } else if (command.equals("3")) {
                // Search for a person by phone number
                searchByNumber();
            } else if (command.equals("4")) {
                // Add an address
                addAddress();
            } else if (command.equals("5")) {
                // Search for personal information
                searchPersonalInformation();
            } else if (command.equals("6")) {
                // Delete personal information
                deletePersonalInformation();
            } else if (command.equals("7")) {
                // Filtered listing
            } else {
                // Unrecognised command
                System.out.println("Incorrect command!");
            }
            // Keep asking for the command in the loop
            command = getCommand();
        }
        // Fall here and quit if x or X is found to be the command
    }
    
    public void printMenu() {
        System.out.println("phone search");
        System.out.println("available operations:");
        System.out.println(" 1 add a number");
        System.out.println(" 2 search for a number");
        System.out.println(" 3 search for a person by phone number");
        System.out.println(" 4 add an address");
        System.out.println(" 5 search for personal information");
        System.out.println(" 6 delete personal information");
        System.out.println(" 7 filtered listing");
        System.out.println(" x quit");
    }
    
    public String getCommand() {
        System.out.println("");
        System.out.print("Command: ");
        String in = input.nextLine();
        return in;
    }
    
    public void addNumber() {
        System.out.print("whose number: ");
        String name = input.nextLine();
        System.out.print("number: ");
        String number = input.nextLine();
        this.phonebook.addNumber(name, number);
    }
    
    public void searchByName() {
        System.out.print("whose number: ");
        String name = input.nextLine();
        this.phonebook.searchByName(name);
    }
    
    public void searchByNumber() {
        System.out.print("number: ");
        String number = input.nextLine();
        this.phonebook.searchByNumber(number);
    }
    
    public void addAddress() {
        System.out.print("whose address: ");
        String name = input.nextLine();
        System.out.print("street: ");
        String street = input.nextLine();
        System.out.print("city: ");
        String city = input.nextLine();
        this.phonebook.addAddress(name, street, city);
    }
    
    public void searchPersonalInformation() {
        System.out.print("whose information: ");
        String name = input.nextLine();
        this.phonebook.searchPersonalInformation(name);
    }
    
    public void deletePersonalInformation() {
        System.out.print("whose information: ");
        String name = input.nextLine();
        this.phonebook.deletePersonalInformation(name);
    }
}
