package Ex7;

public class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;
    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }
    public int getAge() {
        return age;
    }
    public String getDepartment() {
        return department;
    }
    public double getSalary() {
        return salary;
    }
    public String getName() {
        return name;
    }
    public void printInfo(){
        System.out.println("Tên: " + name + ", Tuổi: " + age + ", Phòng ban: " + department + ", Lương: " + salary);
    }
}
