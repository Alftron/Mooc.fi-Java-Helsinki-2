
package personnel;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Employees {
    
    private List<Person> employees;
    
    public Employees() {
        employees = new ArrayList<Person>();
    }
    
    public void add(Person person) {
        employees.add(person);
    }
    
    public void add(List<Person> persons) {
        for (Person p : persons) {
            employees.add(p);
        }
    }
    
    public void print() {
        Iterator<Person> people = employees.iterator();
        while (people.hasNext()) {
            System.out.println(people.next());
        }
    }
    
    public void print(Education education) {
        Iterator<Person> people = employees.iterator();
        while (people.hasNext()) {
            Person person = people.next();
            if (person.getEducation() == education) {
                System.out.println(person);
            }
        }
    }
    
    public void fire(Education education) {
        Iterator<Person> people = employees.iterator();
        while (people.hasNext()) {
            if (people.next().getEducation() == education) {
                people.remove();
            }
        }
    }
    
}
