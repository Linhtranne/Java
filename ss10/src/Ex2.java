public class Ex2 {
    /*
1. Kế thừa là gì? Nó giúp ích gì trong lập trình hướng đối tượng?
Kế thừa (Inheritance) là một cơ chế trong lập trình hướng đối tượng (OOP) cho phép một lớp (subclass - lớp con) kế thừa thuộc tính và phương thức của một lớp khác (superclass - lớp cha). Trong Java, kế thừa được thực hiện bằng từ khóa extends.

Lợi ích của kế thừa trong lập trình OOP:
Tái sử dụng mã nguồn: Lớp con có thể sử dụng lại mã nguồn của lớp cha mà không cần viết lại.
Tổ chức mã tốt hơn: Giúp xây dựng quan hệ cha-con giữa các lớp, làm cho chương trình dễ quản lý.
Tăng tính mở rộng: Có thể mở rộng tính năng của lớp cha bằng cách thêm hoặc ghi đè phương thức trong lớp con.
Dễ bảo trì: Khi có sự thay đổi ở lớp cha, tất cả lớp con sẽ được cập nhật theo.
2. Sự khác biệt giữa kế thừa (Inheritance) và đóng gói (Encapsulation) trong Java
|--------------|--------------------------------|-------------------------------------------|
|Đặc điểm      | Kế thừa (Inheritance)          |             Đóng gói (Encapsulation)      |
|--------------|--------------------------------|-------------------------------------------|
|Mục đích      | Cho phép lớp con kế thừa thuộc | Bảo vệ dữ liệu và kiểm soát quyền truy cập|
|              |tính và phương thức từ lớp cha. |                                           |
|--------------|--------------------------------|-------------------------------------------|
|Từ khóa       | extends (cho lớp) hoặc         |	private, protected, public.             |
|              |implements (cho interface).     |                                           |
|--------------|--------------------------------|-------------------------------------------|
|Tính chất     | Tạo quan hệ giữa các lớp để tái|	Che giấu dữ liệu và kiểm soát truy cập  |
|              | sử dụng mã nguồn.              |   qua getter/setter.                      |
|--------------|--------------------------------|-------------------------------------------|
|Lợi ích chính | Giúp tránh trùng lặp mã, dễ 	| Đảm bảo an toàn dữ liệu, tránh thay đổi   |
|              | dàng mở rộng hệ thống.         | dữ liệu ngoài mong muốn.                  |
|--------------|--------------------------------|-------------------------------------------|
     */
    //3. Ví dụ về kế thừa với từ khóa extends
    // Lớp cha (Super Class)
    class Animal {
        String name;

        void eat() {
            System.out.println(name + " is eating...");
        }
    }

    // Lớp con kế thừa từ lớp cha
    class Dog extends Animal {
        void bark() {
            System.out.println(name + " is barking...");
        }
    }

    // Chương trình chính
//    public class Main {
//        public static void main(String[] args) {
//            Dog dog = new Dog();
//            dog.name = "Buddy";  // Kế thừa thuộc tính từ Animal
//            dog.eat();           // Kế thừa phương thức từ Animal
//            dog.bark();          // Phương thức riêng của Dog
//        }
//    }
/*
4. Lợi ích và hạn chế của kế thừa trong Java
Lợi ích:
✅ Tái sử dụng mã nguồn → Lớp con có thể dùng lại các thuộc tính và phương thức từ lớp cha.
✅ Giảm thiểu trùng lặp mã → Không cần viết lại cùng một đoạn mã nhiều lần.
✅ Dễ bảo trì → Khi cần sửa đổi, chỉ cần thay đổi ở lớp cha, các lớp con tự động cập nhật.
✅ Tổ chức mã tốt hơn → Dễ dàng mở rộng và quản lý quan hệ giữa các lớp.

Hạn chế:
❌ Lớp con phụ thuộc vào lớp cha → Nếu thay đổi lớp cha, có thể ảnh hưởng đến tất cả lớp con.
❌ Không hỗ trợ kế thừa đa lớp → Java chỉ hỗ trợ kế thừa đơn (extends chỉ cho phép kế thừa từ một lớp cha duy nhất).
❌ Dễ gây rối nếu quá lạm dụng → Quá nhiều tầng kế thừa có thể làm cho mã khó đọc và khó bảo trì.
 */
}
