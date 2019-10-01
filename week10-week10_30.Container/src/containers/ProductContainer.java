
package containers;

public class ProductContainer extends Container {
    
    private String name;
    
    public ProductContainer(String productName, double capacity) {
        super(capacity);
        this.name = productName;    
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    @Override
    public String toString() {
        return getName() + ": " + super.toString();
    }
}
