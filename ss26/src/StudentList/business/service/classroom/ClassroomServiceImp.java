package StudentList.business.service.classroom;

import StudentList.business.dao.classroom.ClassroomDao;
import StudentList.business.dao.classroom.ClassroomDaoImp;
import StudentList.business.model.Classroom;
import StudentList.business.model.Student;
import java.util.List;

public class ClassroomServiceImp implements ClassroomService {
    private final ClassroomDao classroomDao;

    public ClassroomServiceImp() {
        classroomDao = new ClassroomDaoImp();
    }

    @Override
    public List<Classroom> findAll() {
        return classroomDao.findAll();
    }

    @Override
    public boolean save(Classroom classroom) {
        return classroomDao.save(classroom);
    }

    @Override
    public boolean update(Classroom classroom) {
        return classroomDao.update(classroom);
    }

    @Override
    public boolean delete(Classroom classroom) {
        return classroomDao.delete(classroom);
    }

    @Override
    public Classroom findById(int id) {
        return classroomDao.findById(id);
    }

    @Override
    public List<Student> getStudentsInClassroom(int classroomId) {
        return classroomDao.getStudentsInClassroom(classroomId);
    }

    @Override
    public int countStudentsByAgeRange(int classroomId, int minAge, int maxAge) {
        return classroomDao.countStudentsByAgeRange(classroomId, minAge, maxAge);
    }

    @Override
    public int countStudentsByStatus(int classroomId, boolean status) {
        return classroomDao.countStudentsByStatus(classroomId, status);
    }
}