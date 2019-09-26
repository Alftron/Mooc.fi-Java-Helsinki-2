
/**
 *
 * @author martinh
 */

import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class Airport {
    
    private Scanner input;
    private ArrayList<Flight> flights;
    private HashMap<String, Plane> planes;
    
    public Airport() {
        input = new Scanner(System.in);
        flights = new ArrayList<Flight>();
        planes = new HashMap<String, Plane>();
    }
    
    public void run() {
        airportPanel();
        flightPanel();
    }
    
    public void airportPanel() {
        System.out.println("Airport panel");
        System.out.println("--------------------");
        System.out.println("");
        while (true) {
            printAirportMenu();
            System.out.print("> ");
            String in = input.nextLine();
            if (in.equals("1")) {
                addPlane();
            } else if (in.equals("2")) {
                addFlight();
            } else if (in.equals("x")) {
                break;
            }
        }
    }
    
    public void printAirportMenu() {
        System.out.println("Choose operation:");
        System.out.println("[1] Add airplane");
        System.out.println("[2] Add flight");
        System.out.println("[x] Exit");
    }
    
    public void flightPanel() {
        System.out.println("");
        System.out.println("Flight service");
        System.out.println("------------");
        System.out.println("");
        while (true) {
            printFlightMenu();
            System.out.print("> ");
            String in = input.nextLine();
            if (in.equals("1")) {
                printPlanes();
            } else if (in.equals("2")) {
                printFlights();
            } else if (in.equals("3")) {
                printPlaneInfo();
            } else if (in.equals("x")) {
                break;
            }
        }
    }
    
    public void printFlightMenu() {
        System.out.println("Choose operation:");
        System.out.println("[1] Print planes");
        System.out.println("[2] Print flights");
        System.out.println("[3] Print plane info");
        System.out.println("[x] Quit");
    }
    
    public void addPlane() {
        System.out.print("Give plane ID: ");
        String id = input.nextLine();
        System.out.print("Give plane capacity: ");
        int size = Integer.parseInt(input.nextLine());
        this.planes.put(id, new Plane(id, size));
    }
    
    public void addFlight() {
        System.out.print("Give plane ID: ");
        String id = input.nextLine();
        System.out.print("Give departure airport code: ");
        String depart = input.nextLine();
        System.out.print("Give destination airport code: ");
        String dest = input.nextLine();
        
        Plane plane = planes.get(id);
        this.flights.add(new Flight(plane, depart, dest));
    }
    
    public void printPlanes() {
        for (Plane plane : planes.values()) {
            System.out.println(plane);
        }
    }
    
    public void printFlights() {
        for (Flight flight : flights) {
            System.out.println(flight);
        }
    }
    
    public void printPlaneInfo() {
        System.out.print("Give plane ID: ");
        String id = input.nextLine();
        Plane plane = planes.get(id);
        System.out.println(plane);
    }
}
