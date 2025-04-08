package StudentList.business.dao.student;

import StudentList.business.dao.AppDao;
import StudentList.business.model.Student;

public interface StudentDao extends AppDao<Student> {
    int getCountStudentByStatus(boolean status);
    Student findById(int id);
}