import java.util.Map;
import java.util.HashMap;

public class ShoppingBasket {
    private Map<String, Purchase> items;
    
    public ShoppingBasket() {
        items = new HashMap<String, Purchase>();
    }
    
    public void add(String product, int price) {
        if (items.containsKey(product)) {
            items.get(product).increaseAmount();
        }
        else {
            items.put(product, new Purchase(product, 1, price));
        }
    }
    
    public int price() {
        int price = 0;
        for (Purchase values : items.values()) {
            price += values.price();
        }
        return price;
    }
    
    public void print() {
        for (Purchase values : items.values()) {
            System.out.println(values.toString());
        }
    }
    
}
