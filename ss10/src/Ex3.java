

public class Ex3 {
    public static class Car {
        private String make;
        private String model;
        private int year;
        public Car(String make, String model, int year) {
            this.make = make;
            this.model = model;
            setYear(year);
        }
        public String getMake() {
            return make;
        }
        public void setMake(String make) {
            this.make = make;
        }
        public String getModel() {
            return model;
        }
        public void setModel(String model) {
            this.model = model;
        }
        public int getYear() {
            return year;
        }
        public void setYear(int year) {
            int currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
            if (year > currentYear) {
                throw new IllegalArgumentException("Năm sản xuất không được lớn hơn năm hiện tại.");
            }
            this.year = year;
        }
    }
    public static void main(String[] args) {
        Car car = new Car("Toyota", "Corolla", 2020);

        System.out.println("Make: " + car.getMake());
        System.out.println("Model: " + car.getModel());
        System.out.println("Year: " + car.getYear());
        car.setMake("Honda");
        car.setModel("Civic");
        try {
            car.setYear(2025);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Updated Make: " + car.getMake());
        System.out.println("Updated Model: " + car.getModel());
        System.out.println("Updated Year: " + car.getYear());
    }
}