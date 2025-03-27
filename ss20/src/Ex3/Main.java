package Ex3;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList <User> list = new ArrayList<>();
        list.add(  new User("Quý", "0987654321"));
        list.add(  new User("Lan", null));
        list.add(new User("Minh", "0933222111"));
        list.add(new User("Huyền", null));
        list.forEach(User::printInfo);
    }
}
