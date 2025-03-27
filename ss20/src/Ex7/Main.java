package Ex7;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Quý", 26, "IT", 2500),
                new Employee("Lan", 24, "IT", 2100),
                new Employee("Minh", 30, "HR", 3000),
                new Employee("Huyền", 28, "IT", 2000),
                new Employee("Long", 32, "IT", 3100),
                new Employee("Trang", 25, "Marketing", 2200),
                new Employee("Việt", 27, "IT", 2500)

        );
        employees.stream().filter(employee -> employee.getSalary() > 2000).filter(employee -> employee.getAge() >= 25).filter(employee -> employee.getDepartment().equals("IT")).sorted((a, b) -> {
            if (a.getSalary() != b.getSalary()) {
                return (int) (b.getSalary() - a.getSalary());
            } else {
                return a.getName().compareTo(b.getName());
            }
        }).forEach(Employee::printInfo);
    }
}
