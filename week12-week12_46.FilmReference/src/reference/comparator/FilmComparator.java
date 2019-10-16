
package reference.comparator;

import reference.domain.Film;
import reference.domain.Rating;

import java.util.Comparator;
import java.util.Map;
import java.util.List;

public class FilmComparator implements Comparator<Film> {
    
    private Map<Film, List<Rating>> films;
    
    public FilmComparator(Map<Film, List<Rating>> ratings) {
        this.films = ratings;
    }

    @Override
    public int compare(Film o1, Film o2) {
        double o1Ratings = 0;
        double o2Ratings = 0;
        
        for (Rating r : films.get(o1)) {
            o1Ratings += r.getValue();
        }
       
        for (Rating r : films.get(o2)) {
            o2Ratings += r.getValue();
        }
        
        o1Ratings /= films.size();
        o2Ratings /= films.size();
        
        if (o1Ratings == o2Ratings) {
            return 0;
        } else if (o1Ratings > o2Ratings) {
            return -1;
        } else {
            return 1;
        }
    }
}
