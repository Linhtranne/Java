package StudentList.business.service.student;

import StudentList.business.model.Student;
import StudentList.business.service.AppService;

public interface StudentService extends AppService<Student> {
    Student findById(int id);

    int getCountStudentByStatus(boolean status);
}