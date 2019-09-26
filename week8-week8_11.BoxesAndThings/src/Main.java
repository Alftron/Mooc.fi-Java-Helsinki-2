
public class Main {
    public static void main(String[] args) {
    Box isoBox = new Box(20); 
    Box laatikko = new Box(10); 
    isoBox.add(laatikko);
    laatikko.add( new Book("Horstman", "Core Java",5) );
    isoBox.weight();

        System.out.println(isoBox );
    }
}
