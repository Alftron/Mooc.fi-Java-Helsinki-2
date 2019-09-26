import java.util.HashMap;
import java.util.Map;

public class Participant implements Comparable<Participant>{

    private Map<Integer, Points> points;
    private String name;

    public Participant(String name) {
        this.name = name;
        this.points = new HashMap<Integer, Points>();
    }

    public void jump(int round) {
        this.points.put(round, new Points());
    }

    public String getName() {
        return this.name;
    }

    public Points getPoints(int round) {
        return this.points.get(round);
    }

    public int getTotalPoints() {
        int totalPoints = 0;
        for (Points points : this.points.values()) {
            totalPoints += points.getPoints();
        }
        return totalPoints;
    }

    public String printJumperResults() {
        return this.name + " (" + this.getTotalPoints() + " points)";
    }

    public String printLengths() {
        String printLengths = "";
        for (Points points : this.points.values()) {
            printLengths += " " + points.getLength() + " m,";
        }
        printLengths = printLengths.substring(0, printLengths.length() - 1);
        return printLengths;
    }

    @Override
    public int compareTo(Participant jumper) {
        return this.getTotalPoints() - jumper.getTotalPoints();
    }

    @Override
    public String toString() {
        String results = "           " + this.printJumperResults() + "\n            jump lengths:" + this.printLengths();
        return results;
    }
}
