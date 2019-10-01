
public class Bird {

    private String name;
    private String latinName;
    private int ringingYear;

    public Bird(String name, String latinName, int ringingYear) {
        this.name = name;
        this.latinName = latinName;
        this.ringingYear = ringingYear;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null) {
            return false;
        }
        
        if (getClass() != other.getClass()) {
            return false;
        }
        
        Bird compared = (Bird)other;
        if (latinName.equals(compared.latinName) && this.ringingYear == compared.ringingYear) {
            return true;
        } else {
            return false;
        }
    }
    
    @Override
    public int hashCode() {
        if (this.name == null) {
            return 7;
        }
        return latinName.hashCode() + ringingYear;
    }
    
    @Override
    public String toString() {
        return this.latinName + " (" + this.ringingYear + ")";
    }
}


