
/**
 *
 * @author martinh
 */

public class Flight {
    
    private Plane plane;
    private String departCode;
    private String destCode;
    
    public Flight(Plane plane, String depart, String dest) {
        this.plane = plane;
        this.departCode = depart;
        this.destCode = dest;
    }
        
    @Override
    public String toString() {
      return this.plane + " (" + this.departCode + "-" + this.destCode +")";
    }
    
}
