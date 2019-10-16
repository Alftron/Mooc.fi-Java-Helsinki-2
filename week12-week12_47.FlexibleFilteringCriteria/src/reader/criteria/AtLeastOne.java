
package reader.criteria;

import java.util.List;
import java.util.ArrayList;

public class AtLeastOne implements Criterion {
    
    List<Criterion> criteria;
    
    public AtLeastOne(Criterion... criteria) {
        this.criteria = new ArrayList<Criterion>();
        for (int x = 0; x < criteria.length; x++) {
            this.criteria.add(criteria[x]);
        }
    }

    @Override
    public boolean complies(String line) {
        for (Criterion c : criteria) {
            if (c.complies(line)) {
                return true;
            }
        }
        return false;
    }
    
}
