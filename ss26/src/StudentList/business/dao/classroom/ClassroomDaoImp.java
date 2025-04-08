package StudentList.business.dao.classroom;
import StudentList.business.config.ConnectionDB;
import StudentList.business.model.Classroom;
import StudentList.business.model.Student;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClassroomDaoImp implements ClassroomDao {

    @Override
    public List<Classroom> findAll() {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Classroom> listClassrooms = null;
        try {
            conn = (Connection) ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call find_all_classrooms()}");
            ResultSet rs = callSt.executeQuery();
            listClassrooms = new ArrayList<>();
            while (rs.next()) {
                Classroom classroom = new Classroom();
                classroom.setId(rs.getInt("classroom_id"));
                classroom.setName(rs.getString("classroom_name"));
                classroom.setCapacity(rs.getInt("capacity"));
                classroom.setStatus(rs.getBoolean("status"));
                listClassrooms.add(classroom);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return listClassrooms;
    }

    @Override
    public boolean save(Classroom classroom) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call create_classroom(?,?,?)}");
            callSt.setString(1, classroom.getName());
            callSt.setInt(2, classroom.getCapacity());
            callSt.setBoolean(3, classroom.isStatus());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public boolean update(Classroom classroom) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call update_classroom(?,?,?,?)}");
            callSt.setInt(1, classroom.getId());
            callSt.setString(2, classroom.getName());
            callSt.setInt(3, classroom.getCapacity());
            callSt.setBoolean(4, classroom.isStatus());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public boolean delete(Classroom classroom) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call delete_classroom(?)}");
            callSt.setInt(1, classroom.getId());
            callSt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public Classroom findById(int id) {
        Connection conn = null;
        CallableStatement callSt = null;
        Classroom classroom = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_classroom_by_id(?)}");
            callSt.setInt(1, id);
            ResultSet rs = callSt.executeQuery();
            if (rs.next()) {
                classroom = new Classroom();
                classroom.setId(rs.getInt("classroom_id"));
                classroom.setName(rs.getString("classroom_name"));
                classroom.setCapacity(rs.getInt("capacity"));
                classroom.setStatus(rs.getBoolean("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return classroom;
    }

    @Override
    public List<Student> getStudentsInClassroom(int classroomId) {
        Connection conn = null;
        CallableStatement callSt = null;
        List<Student> students = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call get_students_in_classroom(?)}");
            callSt.setInt(1, classroomId);
            ResultSet rs = callSt.executeQuery();
            students = new ArrayList<>();
            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getInt("student_id"));
                student.setName(rs.getString("student_name"));
                student.setAge(rs.getInt("student_age"));
                student.setStatus(rs.getBoolean("student_status"));
                student.setClassroomId(rs.getInt("classroom_id"));
                students.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
        return students;
    }

    @Override
    public int countStudentsByAgeRange(int classroomId, int minAge, int maxAge) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call count_students_by_age_range(?,?,?,?)}");
            callSt.setInt(1, classroomId);
            callSt.setInt(2, minAge);
            callSt.setInt(3, maxAge);
            callSt.registerOutParameter(4, Types.INTEGER);
            callSt.execute();
            return callSt.getInt(4);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }

    @Override
    public int countStudentsByStatus(int classroomId, boolean status) {
        Connection conn = null;
        CallableStatement callSt = null;
        try {
            conn = ConnectionDB.openConnection();
            callSt = conn.prepareCall("{call count_students_by_status(?,?,?)}");
            callSt.setInt(1, classroomId);
            callSt.setBoolean(2, status);
            callSt.registerOutParameter(3, Types.INTEGER);
            callSt.execute();
            return callSt.getInt(3);
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        } finally {
            ConnectionDB.closeConnection(conn, callSt);
        }
    }
}