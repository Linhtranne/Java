package Ex4;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String name;
    private LocalDate birthDate;
    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
    }
    public void printInfo(){
        System.out.println("Tên: " + name + ", Tuổi: " + Period.between(birthDate, LocalDate.now()).getYears());
    }
}
