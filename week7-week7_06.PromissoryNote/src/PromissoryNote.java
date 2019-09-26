import java.util.HashMap;

public class PromissoryNote {
    private HashMap<String, Double> map;
    
    public PromissoryNote() {
        map = new HashMap<String, Double>();
    }
    
    public void setLoan(String toWhom, double amount) {
        map.put(toWhom, amount);
    }
    
    public double howMuchIsTheDebt(String whose) {
        if (map.containsKey(whose)) {
            return map.get(whose);
        }
        return 0;
    }
}
