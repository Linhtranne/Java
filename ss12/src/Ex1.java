/*
+------------------------+---------------------------------------------+---------------------------------------------+
| Tiêu chí               | Overloading (Nạp chồng)                     | Overriding (Ghi đè)                        |
+------------------------+---------------------------------------------+---------------------------------------------+
| Khái niệm              | Cho phép nhiều phương thức cùng tên trong   | Ghi đè phương thức của lớp cha trong lớp   |
|                        | một lớp với danh sách tham số khác nhau.    | con để thay đổi hành vi của phương thức.   |
+------------------------+---------------------------------------------+---------------------------------------------+
| Thời điểm quyết định   | Xác định trong thời gian biên dịch          | Xác định trong thời gian chạy              |
|                        | (compile-time).                             | (runtime).                                 |
+------------------------+---------------------------------------------+---------------------------------------------+
| Sự liên quan đến đối   | Chỉ liên quan đến lớp, không liên quan đến  | Liên quan đến tính đa hình runtime, cho    |
| tượng                 | đa hình runtime.                            | phép ghi đè hành vi của phương thức.       |
+------------------------+---------------------------------------------+---------------------------------------------+
| Số lượng tham số       | Phải khác nhau (số lượng, kiểu dữ liệu,     | Phải giống nhau hoàn toàn.                 |
|                        | hoặc thứ tự tham số).                      |                                             |
+------------------------+---------------------------------------------+---------------------------------------------+
| Mục đích sử dụng      | Tăng tính linh hoạt bằng cách sử dụng cùng  | Cho phép lớp con cung cấp cách triển khai  |
|                        | tên phương thức với các tham số khác nhau. | riêng cho phương thức của lớp cha.         |
+------------------------+---------------------------------------------+---------------------------------------------+
*/