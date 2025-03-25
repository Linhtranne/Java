package Ex10;

class Employees {
    private static int idCounter = 1;
    private int id;
    private String name;
    private double salary;

    public Employees(String name, double salary) {
        this.id = idCounter++;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employees{id=" + id + ", name='" + name + "', salary=" + salary + "}";
    }
}

