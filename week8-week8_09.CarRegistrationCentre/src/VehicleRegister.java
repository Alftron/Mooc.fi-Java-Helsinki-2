
/**
 *
 * @author martinh
 */

import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class VehicleRegister {
    private Map<RegistrationPlate, String> owners;
    
    public VehicleRegister() {
        owners = new HashMap<RegistrationPlate, String>();
    }
    
    public boolean add(RegistrationPlate plate, String owner) {
        if (owners.get(plate) == null) {
            owners.put(plate, owner);
            return true;
        } else {
            return false;
        }
    }
    
    public String get(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            return owners.get(plate);
        } else {
            return null;
        }
    }
    
    public boolean delete(RegistrationPlate plate) {
        if (owners.containsKey(plate)) {
            owners.remove(plate);
            return true;
        } else {
            return false;
        }
    }
    
    public void printRegistrationPlates() {
        for (RegistrationPlate plate : owners.keySet()) {
            System.out.println(plate);
        }
    }
    
    public void printOwners() {
        ArrayList<String> owner = new ArrayList<String>();
        for (RegistrationPlate plate : owners.keySet()) {
            if (!owner.contains(owners.get(plate))) {
                owner.add(owners.get(plate));
            }
        }
        
        for (String s : owner) {
            System.out.println(s);
        }
    }
}
