package Ex10;

class Company {
    Employee[] employees;
    int count;

    public Company() {
        employees = new Employee[10];
        count = 0;
    }

    public static void main(String[] args) {
        Company company = new Company();

        // Khởi tạo nhân viên mặc định
        company.employees[company.count++] = new Manager("A", 5000);
        company.employees[company.count++] = new Manager("B", 6000);
        company.employees[company.count++] = new Developer("C", 7000);
        company.employees[company.count++] = new Developer("D", 8000);
        company.employees[company.count++] = new Developer("E", 9000);
        for (int i = 0; i < company.count; i++) {
            System.out.println(company.employees[i].work());
        }
        for (int i = 0; i < company.count; i++) {
            System.out.println(company.employees[i].takeVacation());
        }
        for (int i = 0; i < company.count; i++) {
            if (company.employees[i] instanceof AttendMeeting) {
                System.out.println(( company.employees[i]).attendMeeting());
            }
        }
    }
}

