package Ex11.entity;

public class Student {
    private String id;
    private String name;
    private int age;
    private float mark;
    public Student(String id, String name, int age, float mark) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.mark = mark;
    }

    public Student(String id, String name, int age, int mark) {
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public float getMark() {
        return mark;
    }
    @Override
    public String toString() {
        return "Tên sinh viên: " + name + ", Mã sinh viên: " + id + ", Tuổi: " + age + ", Điểm trung bình: " + mark;
    }

    public int Comparator(Student student) {
        if (this.mark > student.mark) {
            return -1;
        } else if (this.mark < student.mark) {
            return 1;
        } else {
            return 0;
        }
    }
}
