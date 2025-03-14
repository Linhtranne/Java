public class Ex1 {
    /*
    1. Tính đóng gói là gì? Tại sao tính đóng gói lại quan trọng trong lập trình đối tượng?
Tính đóng gói (Encapsulation) là một trong bốn nguyên lý quan trọng của lập trình hướng đối tượng (OOP), giúp bảo vệ dữ liệu bên trong một đối tượng bằng cách giới hạn quyền truy cập trực tiếp vào dữ liệu đó từ bên ngoài.

Tính đóng gói quan trọng vì:

Bảo vệ dữ liệu: Ngăn chặn dữ liệu bị thay đổi trực tiếp ngoài ý muốn.
Kiểm soát quyền truy cập: Chỉ cho phép truy cập dữ liệu thông qua các phương thức cụ thể (getter, setter).
Dễ bảo trì và mở rộng: Giúp thay đổi logic bên trong mà không ảnh hưởng đến mã bên ngoài.
Đảm bảo tính toàn vẹn của dữ liệu: Có thể kiểm tra giá trị đầu vào trước khi gán vào thuộc tính.
    2. Làm thế nào để áp dụng tính đóng gói trong Java?
Trong Java, tính đóng gói được thực hiện bằng cách:

Khai báo các thuộc tính của lớp với phạm vi truy cập private để ngăn chặn truy cập trực tiếp từ bên ngoài.
Cung cấp các phương thức getter và setter với phạm vi public để truy xuất và cập nhật dữ liệu một cách có kiểm soát.
Cách sử dụng getter và setter:

Getter: Phương thức dùng để lấy giá trị của thuộc tính.
Setter: Phương thức dùng để gán giá trị cho thuộc tính và có thể thêm logic kiểm tra hợp lệ.
     */
    // 3. Cho ví dụ về cách sử dụng tính đóng gói trong một lớp có thuộc tính name, age (thuộc tính private), và phương thức getter và setter để truy xuất và thay đổi giá trị của chúng.
    public class Person {
        private String name;  // Thuộc tính private
        private int age;

        // Getter cho name
        public String getName() {
            return name;
        }

        // Setter cho name
        public void setName(String name) {
            this.name = name;
        }

        // Getter cho age
        public int getAge() {
            return age;
        }

        // Setter cho age (có kiểm tra hợp lệ)
        public void setAge(int age) {
            if (age > 0) { // Kiểm tra tuổi hợp lệ
                this.age = age;
            } else {
                System.out.println("Tuổi phải lớn hơn 0!");
            }
        }
    }

/*
4. Lợi ích của việc sử dụng tính đóng gói trong việc bảo vệ dữ liệu và kiểm soát quyền truy cập
Ngăn chặn truy cập trái phép: Dữ liệu không thể bị thay đổi trực tiếp từ bên ngoài.
Bảo vệ tính toàn vẹn của dữ liệu: Có thể thêm logic kiểm tra trong setter để tránh dữ liệu không hợp lệ.
Dễ bảo trì và mở rộng: Có thể thay đổi cách xử lý dữ liệu bên trong mà không làm ảnh hưởng đến các phần khác của chương trình.
Tăng tính linh hoạt: Có thể điều chỉnh quyền truy cập bằng các mức private, protected, public.
Ví dụ: Nếu chúng ta không sử dụng tính đóng gói và khai báo public int age, người dùng có thể gán person.age = -5; mà không có bất kỳ kiểm soát nào, dẫn đến dữ liệu không hợp lệ.
 */
}
