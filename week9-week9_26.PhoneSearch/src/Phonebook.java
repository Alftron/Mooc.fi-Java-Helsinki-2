import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Phonebook {
    
    private Map<String, Set<String>> numberByName;
    private Map<String, String> nameByNumber;
    private Map<String, Address> addressByName;
    
    public Phonebook() {
        this.numberByName = new HashMap<String, Set<String>>();
        this.nameByNumber = new HashMap<String, String>();
        this.addressByName = new HashMap<String, Address>();
    }
    
    public void addNumber(String person, String number) {
        if (!this.numberByName.containsKey(person)) {
            numberByName.put(person, new HashSet<String>());
        }
        numberByName.get(person).add(number);
        
        if (!this.nameByNumber.containsKey(number)) {
            nameByNumber.put(number, person);
        }
    }
    
    public void searchByName(String name) {
        if (this.numberByName.containsKey(name)) {
            for (String number : numberByName.get(name)) {
                System.out.println(" " + number);
            }
        } else {
            System.out.println("  not found");
        }
    }
    
    public void searchByNumber(String number) {
        if (this.nameByNumber.containsKey(number)) {
            System.out.println(" " + nameByNumber.get(number));
        } else {
            System.out.println("  not found");
        }
    }
    
    public void addAddress(String name, String street, String city) {
        this.addressByName.put(name, new Address(street, city));
    }
    
    public void searchPersonalInformation(String name) {
        if (!this.addressByName.containsKey(name) && !this.numberByName.containsKey(name)) {
            System.out.println("  not found");
        } else {
            if (addressByName.containsKey(name)) {
                System.out.println("  address: " + addressByName.get(name));
            } else {
                System.out.println("  address unknown");
            }
            
            if (numberByName.containsKey(name)) {
                System.out.println("  phone numbers: " + numberByName.get(name));
                for (String number : numberByName.get(name)) {
                    System.out.println("   " + number);
                }
            } else {
                System.out.println("  phone number not found");
            }
        }
    }
    
    public void deletePersonalInformation(String name) {
        if (this.numberByName.containsKey(name)) {
            Set<String> number = numberByName.get(name);
            for (String s : number) {
                this.nameByNumber.remove(s);
            }
            this.numberByName.remove(name);
        } else {
            System.out.println("not found");
        }
        
        if (this.addressByName.containsKey(name)) {
            this.addressByName.remove(name);
        } else {
            System.out.println("not found");
        }
    }
    
    public void searchFilteredListing(String name) {
        
    }
}
