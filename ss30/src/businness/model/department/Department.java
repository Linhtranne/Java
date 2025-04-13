package businness.model.department;

public class Department {
    private int id;
    private String departmentName;
    private String descrition ;
    private DepartmentStatus status;

    public Department(int id, String departmentName, String descrition, DepartmentStatus status) {
        this.id = id;
        this.departmentName = departmentName;
        this.descrition = descrition;
        this.status = status;
    }
    public Department() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDescrition() {
        return descrition;
    }

    public void setDescrition(String descrition) {
        this.descrition = descrition;
    }

    public DepartmentStatus getStatus() {
        return status;
    }

    public void setStatus(DepartmentStatus status) {
        this.status = status;
    }
    @Override
    public String toString() {
        return "Phòng ban " + id +
                ", Tên phòng ban " + departmentName + '\'' +
                ", Mô tả " + descrition + '\'' +
                ", Trạng thái " + status
                ;
    }
}
