
package farmsimulator;

public class MilkingRobot {
    
    private BulkTank robotTank;
    
    public MilkingRobot() {
        
    }
    
    public BulkTank getBulkTank() {
        if (robotTank != null) {
            return robotTank;
        }
        return null;
    }
    
    public void setBulkTank(BulkTank tank) {
        robotTank = tank;
    }
    
    public void milk(Milkable milkable) {
        if (robotTank != null) {
            robotTank.addToTank(milkable.milk());
        } else {
            throw new IllegalStateException("The MilkingRobot hasn't been installed");
        }
    }
}
