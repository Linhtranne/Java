package Ex3;

public class User {
    private String name;
    private String phoneNumber;
    public User(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    public void printInfo(){
        System.out.println("Tên: " + name + ", SĐT: " + java.util.Optional.ofNullable(phoneNumber).orElse("Không có"));
    }
}

