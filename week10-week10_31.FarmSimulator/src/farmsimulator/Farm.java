
package farmsimulator;

import java.util.List;
import java.util.ArrayList;

public class Farm implements Alive{
    
    private String owner;
    private Barn barn;
    private List<Cow> cows;
    
    public Farm(String owner, Barn barn) {
        this.owner = owner;
        this.barn = barn;
    }
    
    public String getOwner() {
        return owner;
    }
    
    public void addCow(Cow cow) {
        if (cows == null) {
            cows = new ArrayList<Cow>();
        }
        cows.add(cow);
    }
    
    public void manageCows() {
        barn.takeCareOf(cows);
    }
    
    public void installMilkingRobot(MilkingRobot robot) {
        barn.installMilkingRobot(robot);
    }

    @Override
    public void liveHour() {
        for (Cow c : cows) {
            c.liveHour();
        }
    }
    
    @Override
    public String toString() {
        String output = "Farm owner: " + getOwner() + "\n" +
                "Barn bulk tank: " + barn.getBulkTank() + "\n";
        if (cows == null || cows.isEmpty()) {
            output += "No cows.";
        } else {
            output += "Animals:";
            for (Cow c : cows) {
                output += "\n        " + c.toString();
            }
        }

        return output;
    }
    
}
