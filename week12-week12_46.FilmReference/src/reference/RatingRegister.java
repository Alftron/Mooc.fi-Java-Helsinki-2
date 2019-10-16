
package reference;

import reference.domain.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

public class RatingRegister {
    
    private Map<Film, List<Rating>> filmRatings;
    private Map<Person, Map<Film, Rating>> personRatings;
    
    public RatingRegister() {
        filmRatings = new HashMap<Film, List<Rating>>();
        personRatings = new HashMap<Person, Map<Film, Rating>>();
    }
    
    public void addRating(Film film, Rating rating) {
        if (!filmRatings.containsKey(film)) {
            filmRatings.put(film, new ArrayList<Rating>());
        }
        
        filmRatings.get(film).add(rating);
    }
    
    public void addRating(Person person, Film film, Rating rating) {
        if (!personRatings.containsKey(person)) {
            personRatings.put(person, new HashMap<Film, Rating>());
            personRatings.get(person).put(film, rating);
            addRating(film, rating);
        } else if (!personRatings.get(person).containsKey(film)) {
            personRatings.get(person).put(film, rating);
            addRating(film, rating);
        }
    }
    
    public Rating getRating(Person person, Film film) {
        if (personRatings.get(person).containsKey(film)) {
            return personRatings.get(person).get(film);
        }
        return Rating.NOT_WATCHED;
    }
    
    public List<Rating> getRatings(Film film) {
        return filmRatings.get(film);
    }
    
    public Map<Film, Rating> getPersonalRatings(Person person) {
        if (!reviewers().contains(person)) {
            return new HashMap();
        }
        return personRatings.get(person);
    }
    
    public Map<Film, List<Rating>> filmRatings() {
        return filmRatings;
    }
    
    public List<Person> reviewers() {
        return new ArrayList<Person>(personRatings.keySet());
    }
    
}
