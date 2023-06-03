DELETE
FROM products;

-- Inserting sample data for Desktops
INSERT INTO products (serial_number, manufacturer, price, quantity, product_type, form_factor, DTYPE)
VALUES ('D001', 'ASUS', 789.00, 17, 'Desktop', 'DESKTOP', 'Desktop'),
       ('D002', 'KINGDEL', 567.00, 5, 'Desktop', 'NETTOP', 'Desktop'),
       ('D003', 'MICRO-STAR', 912.00, 26, 'Desktop', 'MONOBLOCK', 'Desktop');

-- Inserting sample data for Laptops
INSERT INTO products (serial_number, manufacturer, price, quantity, product_type, size, DTYPE)
VALUES ('L001', 'IBM', 1500.00, 8, 'Laptop', 'SIZE_15', 'Laptop'),
       ('L002', 'LENOVO', 1210.00, 16, 'Laptop', 'SIZE_13', 'Laptop'),
       ('L003', 'ASUS', 1720.00, 2, 'Laptop', 'SIZE_17', 'Laptop');

-- Inserting sample data for Monitors
INSERT INTO products (serial_number, manufacturer, price, quantity, product_type, diagonal, DTYPE)
VALUES ('M001', 'DELL', 500.00, 41, 'Monitor', 24.00, 'Monitor'),
       ('M002', 'Apple', 810.00, 6, 'Monitor', 25.00, 'Monitor'),
       ('M003', 'ASUS', 520.00, 22, 'Monitor', 27.00, 'Monitor');

-- Inserting sample data for Hard Drives
INSERT INTO products (serial_number, manufacturer, price, quantity, product_type, capacity, DTYPE)
VALUES ('H001', 'Western Digital', 370.00, 8, 'Hard Drive', '1000 GB', 'HardDrive'),
       ('H002', 'IBM', 710.00, 5, 'Hard Drive', '1500 GB', 'HardDrive'),
       ('H003', 'DELL', 420.00, 4, 'Hard Drive', '2000 GB', 'HardDrive');