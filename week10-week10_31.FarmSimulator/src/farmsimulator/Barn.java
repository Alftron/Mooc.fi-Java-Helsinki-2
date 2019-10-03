
package farmsimulator;

import java.util.Collection;

public class Barn {
    
    private BulkTank barnTank;
    private MilkingRobot barnRobot;
    
    public Barn(BulkTank tank) {
        barnTank = tank;
    }
    
    public BulkTank getBulkTank() {
        return barnTank;
    }
    
    public void installMilkingRobot(MilkingRobot milkingRobot) {
        barnRobot = milkingRobot;
        barnRobot.setBulkTank(barnTank);
    }
    
    public void takeCareOf(Cow cow) {
        if (barnRobot != null) {
            barnRobot.milk(cow);
        } else {
            throw new IllegalStateException("Milking robot not installed");
        }
    }
    
    public void takeCareOf(Collection<Cow> cows) {
        if (barnRobot != null) {
            for (Cow c : cows) {
                barnRobot.milk(c);
            }
        } else {
            throw new IllegalStateException("Milking robot not installed");
        }
    }
    
    @Override
    public String toString() {
        return barnTank.toString();
    }
    
}
