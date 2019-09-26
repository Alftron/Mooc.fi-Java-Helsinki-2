
public class Calculator {
    private Reader input;
    private int totalCalculations;
    
    public Calculator() {
        input = new Reader();
        totalCalculations = 0;
    }
    
    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = input.readString();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("sum")) {
                sum();
            } else if (command.equals("difference")) {
                difference();
            } else if (command.equals("product")) {
                product();
            }
        }
        statistics();
    }
    
    private void sum() {
        System.out.print("value1: ");
        int value1 = input.readInteger();
        System.out.print("value2: ");
        int value2 = input.readInteger();
        System.out.println("Sum of the values " + (value1 + value2));
        this.totalCalculations++;
    }
    
    private void difference() {
        System.out.print("value1: ");
        int value1 = input.readInteger();
        System.out.print("value2: ");
        int value2 = input.readInteger();
        System.out.println("Difference of the values " + (value1 - value2));
        this.totalCalculations++;
    }
    
    private void product() {
        System.out.print("value1: ");
        int value1 = input.readInteger();
        System.out.print("value2: ");
        int value2 = input.readInteger();
        System.out.println("Product of the values " + (value1 * value2));
        this.totalCalculations++;
    }
    
    private void statistics() {
        System.out.println("Calculations done " + this.totalCalculations);
    }
}
