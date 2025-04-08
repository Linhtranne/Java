package JavaPractice.business;

    import JavaPractice.entity.ClassRoom;
    import JavaPractice.entity.Student;
    import JavaPractice.entity.Teacher;
    import JavaPractice.util.Validator;

    import java.util.Collections;
    import java.util.Comparator;
    import java.util.List;
    import java.util.Scanner;

    public class ClassRoomManagement {
        private List<ClassRoom> classRooms;
        private List<Teacher> teachers;
        private List<Student> students;

        public ClassRoomManagement(List<ClassRoom> classRooms, List<Teacher> teachers, List<Student> students) {
            this.classRooms = classRooms;
            this.teachers = teachers;
            this.students = students;
        }

        // 1. List classrooms sorted by creation date (descending)
        public void listClassRooms() {
            classRooms.sort(Comparator.comparing(ClassRoom::getClassId).reversed());
            classRooms.forEach(System.out::println);
        }

        // 2. Add a new classroom
        public void addClassRoom(Scanner scanner) {
            ClassRoom classRoom = new ClassRoom();
            classRoom.inputData(scanner);
            classRooms.add(classRoom);
            System.out.println("Lớp học đã được thêm thành công.");
        }

        // 3. Update classroom information (only if status is not CLOSE)
        public void updateClassRoom(Scanner scanner) {
            System.out.print("Nhập ID lớp học cần cập nhật: ");
            int id = Integer.parseInt(scanner.nextLine());
            ClassRoom classRoom = findClassRoomById(id);
            if (classRoom != null) {
                if (!"CLOSE".equalsIgnoreCase(classRoom.getStatus())) {
                    classRoom.inputData(scanner);
                    System.out.println("Thông tin lớp học đã được cập nhật.");
                } else {
                    System.out.println("Không thể cập nhật lớp học có trạng thái CLOSE.");
                }
            } else {
                System.out.println("Không tìm thấy lớp học với ID đã nhập.");
            }
        }

        // 4. Delete a classroom (only if it has no students or teacher)
        public void deleteClassRoom(Scanner scanner) {
            System.out.print("Nhập ID lớp học cần xóa: ");
            int id = Integer.parseInt(scanner.nextLine());
            ClassRoom classRoom = findClassRoomById(id);
            if (classRoom != null) {
                if (classRoom.getStudents().isEmpty() && classRoom.getTeacher() == null) {
                    classRooms.remove(classRoom);
                    System.out.println("Lớp học đã được xóa thành công.");
                } else {
                    System.out.println("Không thể xóa lớp học đã có sinh viên hoặc giảng viên.");
                }
            } else {
                System.out.println("Không tìm thấy lớp học với ID đã nhập.");
            }
        }

        // 5. Assign a teacher to a classroom
        public void assignTeacher(Scanner scanner) {
            System.out.print("Nhập ID lớp học: ");
            int classId = Integer.parseInt(scanner.nextLine());
            ClassRoom classRoom = findClassRoomById(classId);
            if (classRoom != null) {
                System.out.print("Nhập ID giảng viên: ");
                int teacherId = Integer.parseInt(scanner.nextLine());
                Teacher teacher = findTeacherById(teacherId);
                if (teacher != null) {
                    classRoom.setTeacher(teacher);
                    System.out.println("Giảng viên đã được phân công cho lớp học.");
                } else {
                    System.out.println("Không tìm thấy giảng viên với ID đã nhập.");
                }
            } else {
                System.out.println("Không tìm thấy lớp học với ID đã nhập.");
            }
        }

        // 6. Add students to a classroom
        public void addStudentsToClassRoom(Scanner scanner) {
            System.out.print("Nhập ID lớp học: ");
            int classId = Integer.parseInt(scanner.nextLine());
            ClassRoom classRoom = findClassRoomById(classId);
            if (classRoom != null) {
                while (true) {
                    System.out.print("Nhập ID sinh viên cần thêm (hoặc nhập 0 để thoát): ");
                    int studentId = Integer.parseInt(scanner.nextLine());
                    if (studentId == 0) break;
                    Student student = findStudentById(studentId);
                    if (student != null) {
                        classRoom.getStudents().add(student);
                        System.out.println("Sinh viên đã được thêm vào lớp học.");
                    } else {
                        System.out.println("Không tìm thấy sinh viên với ID đã nhập.");
                    }
                }
            } else {
                System.out.println("Không tìm thấy lớp học với ID đã nhập.");
            }
        }

        // 7. Update classroom status
        public void updateClassRoomStatus(Scanner scanner) {
            System.out.print("Nhập ID lớp học cần cập nhật trạng thái: ");
            int id = Integer.parseInt(scanner.nextLine());
            ClassRoom classRoom = findClassRoomById(id);
            if (classRoom != null) {
                System.out.print("Nhập trạng thái mới (PENDING, PROGRESS, CLOSE): ");
                String status = scanner.nextLine();
                if (Validator.validateName(status)) {
                    classRoom.setStatus(status);
                    System.out.println("Trạng thái lớp học đã được cập nhật.");
                } else {
                    System.out.println("Trạng thái không hợp lệ.");
                }
            } else {
                System.out.println("Không tìm thấy lớp học với ID đã nhập.");
            }
        }

        // Helper methods
        private ClassRoom findClassRoomById(int id) {
            return classRooms.stream().filter(c -> c.getClassId() == id).findFirst().orElse(null);
        }

        private Teacher findTeacherById(int id) {
            return teachers.stream().filter(t -> t.getTeacherId() == id).findFirst().orElse(null);
        }

        private Student findStudentById(int id) {
            return students.stream()
                    .filter(s -> s.getStudentId().equals(String.valueOf(id)))
                    .findFirst()
                    .orElse(null);
        }
    }