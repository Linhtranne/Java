package Ex4;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList <Person> list = new ArrayList<>();
        list.add(  new Person("Quý", java.time.LocalDate.of(2000, 1, 1)));
        list.add(  new Person("Lan", java.time.LocalDate.of(1998, 7, 10)));
        list.add(new Person("Minh", java.time.LocalDate.of(2005, 12, 1)));
        list.add(new Person("Linh", java.time.LocalDate.of(2005, 10, 10)));
        list.forEach(Person::printInfo);
    }

}
