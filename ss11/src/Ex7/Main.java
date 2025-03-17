package Ex7;

public class Main {
    public static void main(String[] args) {
        PartTimeEmployee Ptime = new PartTimeEmployee(20, "Linhtranne", 80);
        System.out.println(Ptime.calculateSalary());
        Ptime.setPaymentPerHour(50);
        System.out.println(Ptime.calculateSalary());
        FullTimeEmployee fulTim = new FullTimeEmployee("LinhMongMer", 30);
        System.out.println(fulTim.calculateSalary());
        fulTim.setPaymentPerHour(50);
        System.out.println(fulTim.calculateSalary());
    }
}
