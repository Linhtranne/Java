package JavaPractice.entity;

    import JavaPractice.util.Validator;
    import java.time.LocalDate;
    import java.time.format.DateTimeFormatter;
    import java.time.format.DateTimeParseException;
    import java.util.Scanner;

    public class Schedule {
        private static int idCounter = 1;
        private int scheduleId;
        private ClassRoom classRoom;
        private LocalDate scheduleDate; // Use LocalDate for specific dates
        private String timeSlot;

        public Schedule() {
            this.scheduleId = idCounter++;
        }

        public Schedule(ClassRoom classRoom, LocalDate scheduleDate, String timeSlot) {
            this.scheduleId = idCounter++;
            this.classRoom = classRoom;
            this.scheduleDate = scheduleDate;
            this.timeSlot = timeSlot;
        }

        public int getScheduleId() {
            return scheduleId;
        }

        public ClassRoom getClassRoom() {
            return classRoom;
        }

        public void setClassRoom(ClassRoom classRoom) {
            this.classRoom = classRoom;
        }

        public LocalDate getScheduleDate() {
            return scheduleDate;
        }

        public void setScheduleDate(LocalDate scheduleDate) {
            this.scheduleDate = scheduleDate;
        }

        public String getTimeSlot() {
            return timeSlot;
        }

        public void setTimeSlot(String timeSlot) {
            this.timeSlot = timeSlot;
        }

        public void inputData(Scanner scanner) {
            System.out.println("Nhập thông tin lịch học:");
            System.out.println("Nhập thông tin lớp học:");
            ClassRoom classRoom = new ClassRoom();
            classRoom.inputData(scanner);
            this.classRoom = classRoom;
            while (true) {
                System.out.print("Nhập ngày học (định dạng yyyy-MM-dd): ");
                String input = scanner.nextLine();
                try {
                    LocalDate date = LocalDate.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                    this.scheduleDate = date;
                    break;
                } catch (DateTimeParseException e) {
                    System.err.println("Ngày không hợp lệ. Vui lòng nhập lại.");
                }
            }
            while (true) {
                System.out.print("Nhập khung giờ học (e.g., 08:00-10:00): ");
                String input = scanner.nextLine();
                if (Validator.validateTimeSlot(input)) {
                    this.timeSlot = input;
                    break;
                } else {
                    System.err.println("Khung giờ không hợp lệ. Vui lòng nhập lại.");
                }
            }
        }

        @Override
        public String toString() {
            return "Khung giờ học{" +
                    "scheduleId" + scheduleId +
                    ", Lớp" + classRoom +
                    ", Ngày học" + scheduleDate +
                    ", Thời gian" + timeSlot + '\'' +
                    '}';
        }
    }