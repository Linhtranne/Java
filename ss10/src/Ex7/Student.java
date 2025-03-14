package Ex7;
public class Student {
    private String name;
    private String id;
    private double gpa;

    public Student(String name, String id, double gpa) {
        if (name == null || name.isEmpty() || id == null || id.isEmpty() || gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("Invalid input");
        }
        this.name = name;
        this.id = id;
        this.gpa = gpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Invalid name");
        }
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("Invalid id");
        }
        this.id = id;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        if (gpa < 0.0 || gpa > 4.0) {
            throw new IllegalArgumentException("Invalid gpa");
        }
        this.gpa = gpa;
    }

    public void getDetails() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("GPA: " + gpa);
    }
}
