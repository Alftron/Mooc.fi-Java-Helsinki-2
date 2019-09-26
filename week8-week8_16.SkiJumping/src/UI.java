import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class UI {

    private Scanner reader;
    private List<Participant> jumpers;

    public UI() {
        this.reader = new Scanner(System.in);
        this.jumpers = new ArrayList<Participant>();
    }

    public void start() {
        System.out.println("Kumpula ski jumping week\n");
        askNames();
        tournament();
        tournamentResults();
    }

    public void askNames() {
        System.out.println("Write the names of the participants one at a time; an empty string brings you to the jumping phase.");

        while (true) {
            System.out.println("  Participant name: ");
            String name = reader.nextLine();

            if (name.equals("")) {
                break;
            }

            this.jumpers.add(new Participant(name));
        }
        System.out.println("");
    }

    public void tournament() {
        int round = 1;
        while (true) {
            System.out.println("The tournament begins!\n"
                    + "\n"
                    + "Write \"jump\" to jump; otherwise you quit: ");
            String command = reader.nextLine();

            if (!command.equals("jump")) {
                break;
            }

            System.out.println("\nRound " + round + "\n");

            jumpingOrder(round);
            roundResults(round);
            round++;
        }
        System.out.println("\nThanks!\n");
    }

    public void jumpingOrder(int round) {
        System.out.println("Jumping order:");
        int order = 1;
        for (Participant jumper : this.jumpers) {
            System.out.println("  " + order + ". " + jumper.printJumperResults());
            jumper.jump(round);
            order++;
        }
        System.out.println("");
    }

    public void roundResults(int round) {
        System.out.println("Results of round " + round);
        for (Participant jumper : this.jumpers) {
            System.out.println("  " + jumper.getName());
            System.out.println(jumper.getPoints(round));
        }
        System.out.println("");
        Collections.sort(this.jumpers);
    }

    public void tournamentResults() {
        System.out.println("Tournament results:\n"
                + "Position    Name");
        int order = 1;
        Collections.reverse(this.jumpers);
        for (Participant jumper : this.jumpers) {
            System.out.println(order + "" + jumper);
            order++;
        }
    }
}