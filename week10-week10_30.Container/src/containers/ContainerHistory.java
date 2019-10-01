
package containers;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class ContainerHistory {
    
    
    private List<Double> history;
    
    public ContainerHistory() {
        history = new ArrayList<Double>();
    }
    
    public void add(double situation) {
        history.add(situation);
    }
    
    public void reset() {
        history.clear();
    }
    
    public double maxValue() {
        if (history.size() > 0) {
            return Collections.max(history);
        } else {
            return 0.0;
        }
    }
    
    public double minValue() {
        if (history.size() > 0) {
            return Collections.min(history);
        } else {
            return 0.0;
        }
    }
    
    public double average() {
        if (history.size() > 0) {
            double total = 0.0;
            for (Double d : history) {
                total += d;
            }
            return total / history.size();
        } else {
            return 0.0;
        }
    }
    
    public double greatestFluctuation() {
        if (history.size() > 1) {
            double greatestFluctuation = 0;
            double prevVal = history.get(0);
            for (double d : history) {
                double fluctuation = Math.abs(d - prevVal);
                if (fluctuation > greatestFluctuation) {
                    greatestFluctuation = fluctuation;
                }
                prevVal = d;
            }
            return greatestFluctuation;
        } else {
            return 0.0;
        }
    }
    
    public double variance() {
        if (history.size() > 1) {
            double average = average();
            double tempSum = 0;
            for (double d : history)
            {
                tempSum += Math.pow((d - average), 2);
            }
            return tempSum / (history.size() - 1);
            
        } else {
            return 0.0;
        }
    }
    
    @Override
    public String toString() {
        return history.toString();
    }
    
}
