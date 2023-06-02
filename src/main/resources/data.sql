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