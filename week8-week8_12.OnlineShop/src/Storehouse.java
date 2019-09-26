import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
        
public class Storehouse {
    private Map<String, Integer> products;
    private Map<String, Integer> stocks;
    
    public Storehouse() {
        products = new HashMap<String, Integer>();
        stocks = new HashMap<String, Integer>();
    }
    
    public void addProduct(String product, int price, int stock) {
        products.put(product, price);
        stocks.put(product, stock);
    }
    
    public int price(String product) {
        if (products.containsKey(product)) {
            return products.get(product);
        }
        return -99;
    }
    
    public int stock(String product) {
        if (stocks.containsKey(product)) {
            return stocks.get(product);
        }
        return 0;
    }
    
    public boolean take(String product) {
        if (stocks.containsKey(product)) {
            int stock = stocks.get(product);
            if (stock > 0) {
                stocks.put(product, stock - 1);
                return true;
            }
        }
        return false;
    }
    
    public Set<String> products() {
        Set<String> set = new HashSet<String>();
        for (String product : products.keySet()) {
            set.add(product);
        }
        return set;
    }
}
