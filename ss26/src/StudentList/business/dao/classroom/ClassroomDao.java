package StudentList.business.dao.classroom;

import StudentList.business.dao.AppDao;
import StudentList.business.model.Classroom;
import StudentList.business.model.Student;

import java.util.List;

public interface ClassroomDao extends AppDao<Classroom> {
    Classroom findById(int id);

    List<Student> getStudentsInClassroom(int classroomId);

    int countStudentsByAgeRange(int classroomId, int minAge, int maxAge);

    int countStudentsByStatus(int classroomId, boolean status);
}