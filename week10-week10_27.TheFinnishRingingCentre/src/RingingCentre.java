import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class RingingCentre {
    
    private Map<Bird, List<String>> sightings;
    
    public RingingCentre() {
        sightings = new HashMap<Bird, List<String>>();
    }
    
    public void observe(Bird bird, String place) {
        if (sightings.containsKey(bird)) {
            sightings.get(bird).add(place);
        } else {
            List<String> places = new ArrayList<String>();
            places.add(place);
            sightings.put(bird, places);
        }
    }
    
    public void observations(Bird bird) {
        System.out.print(bird.toString() + " observations: ");
        if (!sightings.containsKey(bird)) {
            System.out.print("0");
        } else {
            System.out.println(sightings.get(bird).size());
            for (String place : sightings.get(bird)) {
                System.out.println(place);
            }
        }
    }
}
