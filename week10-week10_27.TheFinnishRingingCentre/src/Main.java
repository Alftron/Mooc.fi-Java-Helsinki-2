
public class Main {
    public static void main(String[] args) {
        RingingCentre rt = new RingingCentre();
        rt.observe( new Bird("Nebelkrähe", "Corvus corone cornix", 2000), "Berlin");
        rt.observations( new Bird("Nebelkrähe", "Corvus corone cornix", 2000) );
    }
}
