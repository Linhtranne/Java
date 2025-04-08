package StudentList.business.service.classroom;
import StudentList.business.model.Classroom;
import StudentList.business.model.Student;
import StudentList.business.service.AppService;

import java.util.List;

public interface ClassroomService extends AppService<Classroom> {
    Classroom findById(int id);

    List<Student> getStudentsInClassroom(int classroomId);

    int countStudentsByAgeRange(int classroomId, int minAge, int maxAge);

    int countStudentsByStatus(int classroomId, boolean status);
}