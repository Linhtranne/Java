package Ex2.entity;

    import java.util.Optional;
    import java.util.Scanner;

    public class Customer implements IApp {
        private static int nextId = 1;
        private int id;
        private String name;
        private Optional<String> email;

        public Customer() {
            this.id = nextId++;
        }

        public Customer(String name, String email) {
            this.id = nextId++;
            this.name = name;
            this.email = Optional.ofNullable(email);
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public Optional<String> getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = Optional.ofNullable(email);
        }

        @Override
        public void inputData(Scanner scanner) {
            System.out.print("Nhập tên khách hàng: ");
            this.name = String.valueOf(scanner.nextLine());
            System.out.print("Nhập email khách hàng: ");
            this.email = Optional.ofNullable(scanner.nextLine());
        }

        @Override
        public String toString() {
            return "ID: " + id + " | Name: " + name + " | Email: " + email.orElse("Không có email");
        }
    }