package JavaPractice.util;

import java.util.regex.Pattern;

public class Validator {

    public static boolean validateCourseId(String courseId) {
        return courseId != null && courseId.matches("^C\\w{4}$");
    }

    public static boolean validateCourseName(String courseName) {
        return courseName != null && courseName.length() >= 20 && courseName.length() <= 100;
    }

    public static boolean validateBoolean(String input) {
        return input != null && (input.equalsIgnoreCase("true") || input.equalsIgnoreCase("false"));
    }

    public static boolean validateName(String name) {
        return name != null && name.length() <= 150;
    }

    public static boolean validateAge(int age) {
        return age >= 18;
    }

    public static boolean validateAddress(String address) {
        return address != null && !address.trim().isEmpty();
    }

    public static boolean validatePhone(String phone) {
        return phone != null && phone.matches("^0[3|5|7|8|9]\\d{8}$");
    }

    public static boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        return email != null && Pattern.matches(emailRegex, email);
    }
    public static boolean validateStudentId(String studentId) {
        return studentId != null && studentId.matches("^SV\\w{3}$");
    }

    public static boolean validateGpa(double gpa) {
        return gpa >= 0.0 && gpa <= 4.0;
    }
    public static boolean validateSubject(String subject) {
        return subject != null && !subject.trim().isEmpty();
    }
    public static boolean validateTimeSlot(String timeSlot) {
        return timeSlot != null && timeSlot.matches("^\\d{2}:\\d{2}-\\d{2}:\\d{2}$");
    }
}