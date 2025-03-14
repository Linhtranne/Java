package Ex9;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Linh", 1, 1000000000);
        Manager manager = new Manager("Linhh",2,123456,1234);
        Developer developer = new Developer("Ling",3,100000000,"Java,C#");

        System.out.println("Lương của nhân viên: "+employee.getSalary());
        System.out.println("Lương của quản lí: "+manager.getSalary());
        System.out.println("Lương của lập trình viên: "+developer.getSalary());

        System.out.println("Thông tin chi tiết về nhân viên: "+employee.toString());
        System.out.println("Thông tin chi tiết về quản lí: "+developer.toString());
        System.out.println("Thông tin chi tiết về lập trình viên: "+manager.toString());

        employee.increaseSalary(1111);
        System.out.println("Lương của nhân viên sau khi tăng lương: "+employee.toString());
        manager.increaseSalary(2222);
        System.out.println("Lương của quản lí sau khi tăng lương: "+manager.toString());
        developer.increaseSalary(3333);
        System.out.println("Lương của lập trình viên sau khi tăng lương: "+developer.toString());
    }
}