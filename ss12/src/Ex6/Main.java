package Ex6;

public class Main {
    public static void main(String[] args) {
        Employee[] employees = new Employee[100];

        employees[0] = new FullTimeEmployee("A", 18, 3000000, 500000);
        employees[1] = new PartTimeEmployee("B", 20, 5000000, 50);
        employees[2] = new Intern("C", 24, 9000000);

        for (Employee emp : employees) {
            emp.showInfo();
        }
    }
}
