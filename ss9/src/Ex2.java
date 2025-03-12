public class Ex2 {
    public static class  Employee{
        private String name;
        private String id;
        private String department;
        private double salary;
        public  Employee(String name, String id, String department, double salary) {
            this.name = name;
            this.id = id;
            this.department = department;
            this.salary = salary;
        }
        public void displayInfo(){
            System.out.println("Mã "+ id);
            System.out.println("Tên: "+ name);
            System.out.println("Phòng ban: "+ department);
        }
        public double getterSalary(){
            return this.salary;
        }
        public  void  setterSalary(double salary){
            this.salary = salary;
        }
        public void increaseSalary(double percentage){
            this.salary+=this.salary*percentage;
            System.out.println("Tăng lương thành công");
        }

    }
    public static void main(String[] args){
        Employee emp= new Employee("Abc","1234","Nhân sự",999999);
        emp.increaseSalary(10);
        emp.displayInfo();
    }
}