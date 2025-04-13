DROP DATABASE IF EXISTS company;
    CREATE DATABASE company;
    USE company;

    CREATE TABLE account (
        id INT AUTO_INCREMENT PRIMARY KEY,
        username VARCHAR(50) NOT NULL,
        password VARCHAR(20) NOT NULL,
        status ENUM('ACTIVE', 'INACTIVE') NOT NULL DEFAULT 'ACTIVE'
    );

    CREATE TABLE department (
        id INT AUTO_INCREMENT PRIMARY KEY,
        departmentName VARCHAR(100) NOT NULL UNIQUE CHECK (CHAR_LENGTH(departmentName) BETWEEN 10 AND 100),
        descrition VARCHAR(255),
        status ENUM('ACTIVE', 'INACTIVE') NOT NULL
    );

    CREATE TABLE employees (
        employeesId VARCHAR(5) PRIMARY KEY
        employeesName VARCHAR(150) NOT NULL CHECK (CHAR_LENGTH(employeesName) BETWEEN 15 AND 150),
        email VARCHAR(50) NOT NULL UNIQUE
        phoneNumber VARCHAR(10) NOT NULL UNIQUE
        sex ENUM('MALE', 'FEMALE', 'OTHER') NOT NULL,
        salaryGrade INT NOT NULL CHECK (salaryGrade > 0),
        salary DECIMAL(10,2) NOT NULL CHECK (salary > 0),
        birthDate DATE NOT NULL,
        address VARCHAR(100) NOT NULL,
        status ENUM('ACTIVE', 'INACTIVE', 'ONLEAVE', 'POLICYLEAVE') NOT NULL DEFAULT 'ACTIVE',
        departmentId INT NOT NULL,
        FOREIGN KEY (departmentId) REFERENCES department(id),
        CHECK (email REGEXP '^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$'),
        CHECK (phoneNumber REGEXP '^(0[3|5|7|8|9])[0-9]{8}$'),
        CHECK (employeesId REGEXP '^E[0-9]{4}$')
    );

    INSERT INTO account (username, password) VALUES ('linhtranne', '123456');
    INSERT INTO department (departmentName, descrition, status) VALUES
    ('Phòng Nhân Sự', 'Phòng nhân sự của công ty', 'ACTIVE'),
    ('Phòng IT của công ty', 'Phòng công nghệ thông tin', 'ACTIVE'),
    ('Phòng Marketing', 'Phòng tiếp thị và quảng cáo', 'ACTIVE'),
    ('Phòng Kinh Doanh', 'Phòng kinh doanh và bán hàng', 'ACTIVE'),
    ('Phòng Hành Chính', 'Phòng hành chính tổng hợp', 'ACTIVE'),
    ('Phòng Sản Xuất', 'Phòng sản xuất và vận hành', 'ACTIVE'),
    ('Phòng Nghiên Cứu', 'Phòng nghiên cứu và phát triển', 'ACTIVE'),
    ('Phòng Pháp Chế', 'Phòng pháp chế và tuân thủ', 'ACTIVE'),
    ('Phòng Tài Chính', 'Phòng tài chính và kế toán', 'ACTIVE'),
    ('Phòng Dịch Vụ', 'Phòng dịch vụ khách hàng', 'ACTIVE');

    INSERT INTO employees (employeesId, employeesName, email, phoneNumber, sex, salaryGrade, salary, birthDate, address, status, departmentId) VALUES
('E0001', 'Nguyễn Văn An hehehehe', 'nguyenvana@gmail.com', '0351234567', 'MALE', 2, 8000000.00, '1990-01-01', 'Hanoi', 'ACTIVE', 1),
('E0002', 'Trần Thị Bích hehehehe  ', 'tranthib@gmail.com', '0387654321', 'FEMALE', 3, 10000000.00, '1992-02-02', 'HCM', 'ACTIVE', 2),
('E0003', 'Lê Văn Cường hehehehe', 'levanc@gmail.com', '0376543210', 'MALE', 1, 7000000.00, '1995-03-03', 'Danang', 'ACTIVE', 3),
('E0004', 'Phạm Thị Dung hehehehe', 'phamthid@gmail.com', '0398765432', 'FEMALE', 4, 12000000.00, '1993-04-04', 'Hanoi', 'ACTIVE', 4),
('E0005', 'Hoàng Văn Đức hehehehe', 'hoangvane@gmail.com', '0365432109', 'MALE', 2, 8500000.00, '1991-05-05', 'HCM', 'ACTIVE', 5),
('E0006', 'Vũ Thị Hạnh hehehehe', 'vuthif@gmail.com', '0345678901', 'FEMALE', 3, 9500000.00, '1994-06-06', 'Danang', 'ACTIVE', 6),
('E0007', 'Đỗ Văn Hùng hehehehe', 'dovang@gmail.com', '0334567890', 'MALE', 5, 15000000.00, '1990-07-07', 'Hanoi', 'ACTIVE', 7),
('E0008', 'Nguyễn Thị Hoa hehehehe', 'nguyenthih@gmail.com', '0323456789', 'FEMALE', 2, 8000000.00, '1996-08-08', 'HCM', 'ACTIVE', 8),
('E0009', 'Trần Văn Minh hehehehe', 'tranvani@gmail.com', '0312345678', 'MALE', 4, 11000000.00, '1993-09-09', 'Danang', 'ACTIVE', 9),
('E0010', 'Lê Thị Ngọc hehehehe', 'lethij@gmail.com', '0301234567', 'FEMALE', 3, 9000000.00, '1992-10-10', 'Hanoi', 'ACTIVE', 10);
    DELIMITER //

    CREATE PROCEDURE login(
        IN a_username VARCHAR(50),
        IN a_password VARCHAR(20),
        OUT loginResult INT
    )
    BEGIN
        DECLARE userStatus ENUM('ACTIVE', 'INACTIVE');

        SELECT status INTO userStatus
        FROM account
        WHERE username = a_username AND password = a_password
        LIMIT 1;

        IF userStatus IS NOT NULL THEN
            IF userStatus = 'ACTIVE' THEN
                SET loginResult = 1;
            ELSE
                SET loginResult = 2;
            END IF;
        ELSE
            SET loginResult = 0;
        END IF;
    END //

    DELIMITER //

    CREATE PROCEDURE getPageDepartment()
    BEGIN
        SELECT CEIL(COUNT(department.id) / 5.0) AS totalPage
        FROM department;
    END //

    CREATE PROCEDURE getDepartmentByPage(
        IN a_page INT
    )
    BEGIN
        DECLARE pageSize INT DEFAULT 5;
        DECLARE offset INT;

        SET offset = (a_page - 1) * pageSize;

        SELECT *
        FROM department
        LIMIT pageSize OFFSET offset;
    END //

    DELIMITER //

    CREATE PROCEDURE addDepartment(
        IN a_departmentName VARCHAR(100),
        IN a_descrition VARCHAR(255)
    )
    BEGIN
        DECLARE duplicateCount INT;

        SELECT COUNT(*) INTO duplicateCount
        FROM department
        WHERE departmentName = a_departmentName;
        IF duplicateCount > 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên phòng ban đã tồn tại';
        ELSE
            INSERT INTO department (departmentName, descrition)
            VALUES (a_departmentName, a_descrition);
        END IF;
    END //

    DELIMITER //

    CREATE PROCEDURE getDepartmentById(
        IN a_id INT
    )
    BEGIN
        SELECT *
        FROM department
        WHERE id = a_id;
    END //

    CREATE PROCEDURE updateDepartmentByName(
        IN a_id INT,
        IN a_departmentName VARCHAR(100)
    )
    BEGIN
        DECLARE duplicateCount INT;

        SELECT COUNT(*) INTO duplicateCount
        FROM department
        WHERE departmentName = a_departmentName;
        IF duplicateCount > 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Tên phòng ban đã tồn tại';
        ELSE
            UPDATE department
            SET departmentName = a_departmentName
            WHERE id = a_id;
        END IF;
    END //

    CREATE PROCEDURE updateDepartmentByDescrition(
        IN a_id INT,
        IN a_descrition VARCHAR(255)
    )
    BEGIN
        UPDATE department
        SET descrition = a_descrition
        WHERE id = a_id;
    END //

    CREATE PROCEDURE updateDepartmentByStatus(
        IN a_id INT,
        IN a_status ENUM('ACTIVE', 'INACTIVE')
    )
    BEGIN
        UPDATE department
        SET status = a_status
        WHERE id = a_id;
    END //

    DELIMITER //

    CREATE PROCEDURE deleteDepartment(
        IN a_id INT
    )
    BEGIN
        DECLARE employeeCount INT;

        SELECT COUNT(*) INTO employeeCount
        FROM employees
        WHERE departmentId = a_id;

        IF employeeCount > 0 THEN
            SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Không thể xóa phòng ban có nhân viên';
        ELSE
            DELETE FROM department
            WHERE id = a_id;
        END IF;
    END //

    DELIMITER //

    CREATE PROCEDURE searchDepartmentByName(
        IN a_departmentName VARCHAR(100)
    )
    BEGIN
        SELECT *
        FROM department
        WHERE departmentName LIKE CONCAT('%', a_departmentName, '%');
    END //

    DELIMITER //