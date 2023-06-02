DELETE
FROM products;

-- Inserting sample data for Desktops
INSERT INTO products (serial_number, manufacturer, price, quantity, product_type, form_factor)
VALUES ('D001', 'ASUS', 1000.00, 10, 'Desktop', 'DESKTOP');


-- Inserting sample data for Laptops
INSERT INTO products (serial_number, manufacturer, price, quantity, product_type, size)
VALUES ('L001', 'IBM', 1500.00, 8, 'Laptop', 'SIZE_15');
