/*
   Tính trừu tượng trong lập trình hướng đối tượng là kỹ thuật che giấu các chi tiết triển khai và chỉ cung cấp những chức năng cần thiết cho người dùng.
   Điều này giúp đơn giản hóa việc sử dụng các đối tượng mà không cần quan tâm đến cách chúng hoạt động bên trong. Trong Java, tính trừu tượng có thể được
    thực hiện thông qua lớp trừu tượng (abstract class) và giao diện (interface).
    Nó giúp lập trình viên thiết kế các hệ thống phần mềm dễ bảo trì, mở rộng và tái sử dụng.

    Tại sao cần tính trừu tượng trong phần mềm phức tạp?

    Trong các phần mềm lớn, việc quản lý các chi tiết triển khai phức tạp có thể gây khó khăn và làm giảm khả năng bảo trì.
    Tính trừu tượng giúp chia nhỏ hệ thống thành các thành phần dễ hiểu hơn, giúp lập trình viên chỉ tập trung vào cách sử dụng mà không cần lo lắng về cách hoạt động bên trong.
    Nó làm cho mã nguồn trở nên linh hoạt, dễ mở rộng và giảm sự phụ thuộc giữa các thành phần.
    - Sự khác biệt giữa lớp trừu tượng và giao diện trong Java :
+--------------------------+--------------------------------------------+--------------------------------------------+
| Tiêu chí                 | Lớp trừu tượng (Abstract Class)            | Giao diện (Interface)                      |
+--------------------------+--------------------------------------------+--------------------------------------------+
| Tính chất               | Có thể chứa cả phương thức có triển khai   | Chỉ chứa phương thức trừu tượng (trước    |
|                          | và phương thức trừu tượng.                 | Java 8), từ Java 8 có thể có phương thức  |
|                          |                                            | mặc định (default).                        |
+--------------------------+--------------------------------------------+--------------------------------------------+
| Mục đích sử dụng        | Dùng khi các lớp con có một số hành vi      | Dùng để định nghĩa một tập hợp hành vi    |
|                          | chung.                                      | mà các lớp phải thực hiện.                 |
+--------------------------+--------------------------------------------+--------------------------------------------+
| Từ khóa sử dụng         | abstract class                              | interface                                  |
+--------------------------+--------------------------------------------+--------------------------------------------+
| Đa kế thừa              | Không hỗ trợ đa kế thừa (một lớp chỉ có thể | Hỗ trợ đa kế thừa (một lớp có thể triển   |
|                          | kế thừa một lớp trừu tượng).               | khai nhiều interface).                     |
+--------------------------+--------------------------------------------+--------------------------------------------+

    - Lấy ví dụ minh họa từ đời sống
        -Dịch vụ đặt đồ ăn trực tuyến (như GrabFood, ShopeeFood).
        Người dùng chỉ cần mở ứng dụng, chọn món ăn, đặt hàng và thanh toán
        mà không cần biết chi tiết hệ thống xử lý đơn hàng, tính phí giao hàng hay cách
        nhà hàng nhận và chuẩn bị đơn hàng. Toàn bộ quá trình xử lý phức tạp được ẩn đi
        , giúp người dùng có trải nghiệm đơn giản và thuận tiện.

* */