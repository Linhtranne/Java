package JavaPractice.presentation;

import JavaPractice.business.*;
import JavaPractice.entity.*;
import java.util.Scanner;

public class UniversityManager {
    private final CourseManagement courseManagement;
    private final TeacherManagement teacherManagement;
    private final StudentManagement studentManagement;
    private final CourseRegistrationManagement courseRegistrationManagement;
    private final ClassRoomManagement classRoomManagement;
    private final DashboardManagement dashboardManagement;

    public UniversityManager(CourseManagement courseManagement, TeacherManagement teacherManagement,
                             StudentManagement studentManagement, CourseRegistrationManagement courseRegistrationManagement,
                             ClassRoomManagement classRoomManagement, DashboardManagement dashboardManagement) {
        this.courseManagement = courseManagement;
        this.teacherManagement = teacherManagement;
        this.studentManagement = studentManagement;
        this.courseRegistrationManagement = courseRegistrationManagement;
        this.classRoomManagement = classRoomManagement;
        this.dashboardManagement = dashboardManagement;
    }

    public void displayMenu(Scanner scanner) {
        int choice = 0;
        do {
            System.out.println("\n************************* UNIVERSITY MENU **********************");
            System.out.println("1. Quản lý khóa học");
            System.out.println("2. Quản lý giảng viên");
            System.out.println("3. Quản lý sinh viên");
            System.out.println("4. Đăng ký khóa học");
            System.out.println("5. Quản lý lớp học");
            System.out.println("6. Thống kê");
            System.out.println("7. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        manageCourses(scanner);
                        break;
                    case 2:
                        manageTeachers(scanner);
                        break;
                    case 3:
                        manageStudents(scanner);
                        break;
                    case 4:
                        manageCourseRegistrations(scanner);
                        break;
                    case 5:
                        manageClassRooms(scanner);
                        break;
                    case 6:
                        manageDashboard(scanner);
                        break;
                    case 7:
                        System.out.println("Thoát chương trình...");
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ.");
            }
        } while (choice != 7);
    }

    private void manageCourses(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************************* COURSE MENU *************************");
            System.out.println("1. Danh sách khóa học sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới khóa học");
            System.out.println("3. Cập nhật khóa học");
            System.out.println("4. Xóa khóa học theo ID");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    courseManagement.listCourses();
                    break;
                case 2:
                    courseManagement.addCourse(scanner);
                    break;
                case 3:
                    courseManagement.updateCourse(scanner);
                    break;
                case 4:
                    courseManagement.deleteCourse(scanner);
                    break;
                case 5:
                    System.out.println("Thoát COURSE MENU...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);
    }

    private void manageTeachers(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************************* TEACHER MENU *************************");
            System.out.println("1. Danh sách giảng viên sắp xếp theo mã giảm dần");
            System.out.println("2. Thêm mới giảng viên");
            System.out.println("3. Cập nhật giảng viên");
            System.out.println("4. Xóa giảng viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    teacherManagement.listTeachers();
                    break;
                case 2:
                    teacherManagement.addTeacher(scanner);
                    break;
                case 3:
                    teacherManagement.updateTeacher(scanner);
                    break;
                case 4:
                    teacherManagement.deleteTeacher(scanner);
                    break;
                case 5:
                    System.out.println("Thoát TEACHER MENU...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);
    }

    private void manageStudents(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************************* STUDENT MENU *************************");
            System.out.println("1. Danh sách sinh viên sắp xếp theo tên tăng dần");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Cập nhật sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    studentManagement.listStudents();
                    break;
                case 2:
                    studentManagement.addStudent(scanner);
                    break;
                case 3:
                    studentManagement.updateStudent(scanner);
                    break;
                case 4:
                    studentManagement.deleteStudent(scanner);
                    break;
                case 5:
                    System.out.println("Thoát STUDENT MENU...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);
    }

    private void manageCourseRegistrations(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n******************* COURSE REGISTRATION MENU *****************");
            System.out.println("1. Đăng ký khóa học cho sinh viên");
            System.out.println("2. Hủy đăng ký học cho sinh viên");
            System.out.println("3. Duyệt đăng ký học sinh viên");
            System.out.println("4. Xem danh sách sinh viên đăng ký từng khóa học");
            System.out.println("5. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    courseRegistrationManagement.registerCourse(scanner);
                    break;
                case 2:
                    courseRegistrationManagement.cancelRegistration(scanner);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    System.out.println("Thoát COURSE REGISTRATION MENU...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);
    }

    private void manageClassRooms(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n********************** CLASS ROOM MENU **********************");
            System.out.println("1. Danh sách lớp học sắp xếp theo ngày tạo giảm dần");
            System.out.println("2. Thêm mới lớp học");
            System.out.println("3. Cập nhật thông tin lớp học");
            System.out.println("4. Xóa lớp học");
            System.out.println("5. Phân công giảng viên cho lớp");
            System.out.println("6. Thêm sinh viên vào lớp");
            System.out.println("7. Tạo lịch học cho lớp");
            System.out.println("8. Cập nhật trạng thái lớp");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    classRoomManagement.listClassRooms();
                    break;
                case 2:
                    classRoomManagement.addClassRoom(scanner);
                    break;
                case 3:
                    classRoomManagement.updateClassRoom(scanner);
                    break;
                case 4:
                    classRoomManagement.deleteClassRoom(scanner);
                    break;
                case 5:
                    classRoomManagement.assignTeacher(scanner);
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    System.out.println("Thoát CLASS ROOM MENU...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 9);
    }

    private void manageDashboard(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n************************** DASHBOARD **************************");
            System.out.println("1. Thống kê số sinh viên, giảng viên, khóa học, lớp học");
            System.out.println("2. Top 3 khóa học có nhiều sinh viên nhất");
            System.out.println("3. Top 3 lớp học có nhiều sinh viên nhất");
            System.out.println("4. Top 3 giảng viên dạy nhiều sinh viên nhất");
            System.out.println("5. Top 3 sinh viên đăng ký học nhiều nhất");
            System.out.println("6. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    dashboardManagement.displayStatistics();
                    break;
                case 2:
                    dashboardManagement.displayTopCourses();
                    break;
                case 3:
                    dashboardManagement.displayTopClasses();
                    break;
                case 4:
                    dashboardManagement.displayTopTeachers();
                    break;
                case 5:
                    dashboardManagement.displayTopStudents();
                    break;
                case 6:
                    System.out.println("Thoát DASHBOARD...");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 6);
    }
}