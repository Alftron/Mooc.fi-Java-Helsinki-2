
package moving.domain;

public class Item implements Thing, Comparable<Item>{
    private String name;
    private int volume;
    
    public Item(String itemName, int volume) {
        this.name = itemName;
        this.volume = volume;
    }
    
    public String getName() {
        return this.name;
    }
    
    @Override
    public int getVolume() {
        return this.volume;
    }
    
    @Override
    public String toString() {
        return this.getName() + " (" + this.getVolume() + " dm^3)";
    }
    
    @Override
    public int compareTo(Item other) {
        return this.getVolume() - other.getVolume();
    }
    
}
