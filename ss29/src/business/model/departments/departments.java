package business.model.departments;

public class departments {
    private int id;
    private String name;
    private String description;
    private enum status {
        ACTIVE, INACTIVE
    }
    public departments(){

    }
    public departments(int id , String name, String description, status status) {
        this.id = id;
        this.name = name;
        this.description = description;
        status = departments.status.ACTIVE;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Phòng ban" + id
                + "\nTên phòng ban: " + name + "\nMô tả: " + description;

    }
}
