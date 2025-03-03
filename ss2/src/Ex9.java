import java.util.Scanner;

public class Ex9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập ngày:");
        int day = scanner.nextInt();
        System.out.println("Nhập tháng:");
        int month = scanner.nextInt();
        System.out.println("Nhập năm:");
        int year = scanner.nextInt();

        boolean isValid = true;
        if (month < 1 || month > 12 || day < 1 || year < 1) {
            isValid = false;
        } else {
            int maxDays = 31;
            if (month == 2) {
                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    maxDays = 29;
                } else {
                    maxDays = 28;
                }
            } else if (month == 4 || month == 6 || month == 9 || month == 11) {
                maxDays = 30;
            }
            if (day > maxDays) {
                isValid = false;
            }
        }

        if (!isValid) {
            System.out.println("Ngày đã nhập không hợp lệ.");
            return;
        }

        int nextDay = day + 1;
        int nextMonth = month;
        int nextYear = year;

        if (month == 2) {
            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) { // Năm nhuận
                if (nextDay > 29) {
                    nextDay = 1;
                    nextMonth++;
                }
            } else {
                if (nextDay > 28) {
                    nextDay = 1;
                    nextMonth++;
                }
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) { // Các tháng có 30 ngày
            if (nextDay > 30) {
                nextDay = 1;
                nextMonth++;
            }
        } else {
            if (nextDay > 31) {
                nextDay = 1;
                nextMonth++;
            }
        }

        if (nextMonth > 12) {
            nextMonth = 1;
            nextYear++;
        }

        System.out.println("Ngày tiếp theo là: " + nextDay + "/" + nextMonth + "/" + nextYear);
        System.out.println("Nhập ngày thứ nhất (dd mm yyyy):");
        int day1 = scanner.nextInt();
        int month1 = scanner.nextInt();
        int year1 = scanner.nextInt();

        System.out.println("Nhập ngày thứ hai (dd mm yyyy):");
        int day2 = scanner.nextInt();
        int month2 = scanner.nextInt();
        int year2 = scanner.nextInt();

        boolean isValid1 = true, isValid2 = true;
        if (month1 < 1 || month1 > 12 || day1 < 1 || year1 < 1) {
            isValid1 = false;
        } else {
            int maxDays1 = 31;
            if (month1 == 2) {
                if ((year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0)) {
                    maxDays1 = 29;
                } else {
                    maxDays1 = 28;
                }
            } else if (month1 == 4 || month1 == 6 || month1 == 9 || month1 == 11) {
                maxDays1 = 30;
            }
            if (day1 > maxDays1) {
                isValid1 = false;
            }
        }

        if (month2 < 1 || month2 > 12 || day2 < 1 || year2 < 1) {
            isValid2 = false;
        } else {
            int maxDays2 = 31;
            if (month2 == 2) {
                if ((year2 % 4 == 0 && year2 % 100 != 0) || (year2 % 400 == 0)) {
                    maxDays2 = 29;
                } else {
                    maxDays2 = 28;
                }
            } else if (month2 == 4 || month2 == 6 || month2 == 9 || month2 == 11) {
                maxDays2 = 30;
            }
            if (day2 > maxDays2) {
                isValid2 = false;
            }
        }

        if (!isValid1 || !isValid2) {
            System.out.println("Một trong hai ngày không hợp lệ.");
            return;
        }
        int totalDays1 = day1;
        int totalDays2 = day2;
        for (int i = 1; i < year1; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                totalDays1 += 366;
            } else {
                totalDays1 += 365;
            }
        }

        for (int i = 1; i < year2; i++) {
            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                totalDays2 += 366;
            } else {
                totalDays2 += 365;
            }
        }
        for (int i = 1; i < month1; i++) {
            if (i == 2) {
                if ((year1 % 4 == 0 && year1 % 100 != 0) || (year1 % 400 == 0)) {
                    totalDays1 += 29;
                } else {
                    totalDays1 += 28;
                }
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                totalDays1 += 30;
            } else {
                totalDays1 += 31;
            }
        }

        for (int i = 1; i < month2; i++) {
            if (i == 2) {
                if ((year2 % 4 == 0 && year2 % 100 != 0) || (year2 % 400 == 0)) {
                    totalDays2 += 29;
                } else {
                    totalDays2 += 28;
                }
            } else if (i == 4 || i == 6 || i == 9 || i == 11) {
                totalDays2 += 30;
            } else {
                totalDays2 += 31;
            }
        }

        int daysBetween = totalDays2 - totalDays1;
        if (daysBetween < 0) {
            daysBetween = -daysBetween;
        }

        System.out.println("Số ngày giữa hai ngày là: " + daysBetween);
    }
}