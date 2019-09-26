
package mooc.ui;

public class TextUserInterface implements UserInterface {
    
    public TextUserInterface() {
        
    }
    
    @Override
    public void update() {
        System.out.println("Updating the user interface");
    }
}
