USE raicesmx;

-- Tabla subscription
INSERT INTO subscription (subscription_type, benefits, price) VALUES
('Raíces Basic', 'Comida on demand.', 0),
('Raíces Gold', 'Envíos gratis, descuentos exclusivos y personalización de comida.', 79),
('Raíces Premium', 'Envíos gratis, descuentos exclusivos, soporte y atención prioritaria. Consulta nutricional con profesionales.', 2999);

-- Tabla user
INSERT INTO user (first_name, last_name, email, password, birthdate, address, phone, role) VALUES
('Admin', 'RaícesMX', 'admin@admin.com', 'password123', '1990-03-15', 'Calle Reforma 123, Ciudad de México', '5551234567', 'admin'),
('Ana', 'Gómez', 'ana.gomez@example.com', 'securepass456', '1985-06-30', 'Av. Insurgentes 456, Ciudad de México', '5559876543', 'user'),
('Luis', 'Pérez', 'luis.perez@example.com', 'mypassword789', '1992-12-10', 'Paseo de la Reforma 789, Ciudad de México', '5554567890', 'user'),
('María', 'López', 'maria.lopez@example.com', 'pass321', '2000-01-25', 'Av. Universidad 321, Ciudad de México', '5553456789', 'user'),
('Elena', 'Rodríguez', 'elena.rodriguez@example.com', 'elena2023', '1995-07-14', 'Calle Independencia 2023, Ciudad de México', '5552345678', 'user');

-- Tabla orders
INSERT INTO orders (date_time, notes, quantity, status, user_id_fk) VALUES
('2024-12-01 10:30:00', 'Sin picante', 2, 'en preparación', 1),
('2024-12-02 14:15:00', NULL, 1, 'en camino', 2),
('2024-12-02 18:45:00', 'Extra queso', 3, 'entregado', 3),
('2024-12-03 09:20:00', 'Sin cebolla', 4, 'en preparación', 4),
('2024-12-03 12:00:00', NULL, 1, 'entregado', 5);

-- Tabla user_subscription
INSERT INTO user_subscription (user_id, subscription_id, start_date, end_date, is_active) VALUES
(1, 2, '2024-11-01', '2025-11-01', TRUE),
(2, 3, '2024-10-15', '2025-10-15', TRUE),
(3, 1, '2024-12-01', NULL, TRUE),
(4, 2, '2024-11-20', '2025-11-20', TRUE),
(5, 1, '2024-12-03', NULL, TRUE);

-- Tabla product
INSERT INTO product (name, description, ingredients, meal_time, image, price, extras, stock) VALUES
('Ensalada César', 'Ensalada fresca con aderezo César.', 'Lechuga, crutones, parmesano, pollo', 'comida', 'https://raicesmx-images.s3.us-east-1.amazonaws.com/Ejemplo.webp', 120, 'Pollo extra', 10),
('Sándwich Vegano', 'Sándwich saludable con ingredientes veganos.', 'Pan integral, aguacate, hummus, espinaca', 'desayuno', 'https://raicesmx-images.s3.us-east-1.amazonaws.com/Ejemplo.webp', 80, NULL, 10),
('Wrap de Pollo', 'Wrap relleno de pollo y vegetales.', 'Tortilla, pollo, lechuga, tomate', 'comida', 'https://raicesmx-images.s3.us-east-1.amazonaws.com/Ejemplo.webp', 150, 'Aderezo extra', 10),
('Smoothie Tropical', 'Bebida refrescante de frutas tropicales.', 'Mango, piña, coco, plátano', 'desayuno', 'https://raicesmx-images.s3.us-east-1.amazonaws.com/Ejemplo.webp', 60, NULL, 10),
('Pasta Primavera', 'Pasta ligera con vegetales frescos.', 'Pasta, brócoli, zanahoria, calabacín', 'cena', 'https://raicesmx-images.s3.us-east-1.amazonaws.com/Ejemplo.webp', 180, 'Queso parmesano', 10);

-- Tabla order_has_product
INSERT INTO order_has_product (order_id_fk, product_id_fk, quantity) VALUES
(1, 1, 2),
(1, 4, 1),
(2, 2, 1),
(3, 3, 3),
(4, 5, 2);

-- Tabla diet
INSERT INTO diet (diet_type, additional_info) VALUES
('Vegetariana', 'Excluye productos cárnicos.'),
('Vegana', 'Excluye todos los productos de origen animal.'),
('Keto', 'Alta en grasas saludables y baja en carbohidratos.'),
('Sin gluten', 'Apta para personas con intolerancia al gluten.'),
('Baja en sodio', 'Controla el consumo de sal.');

-- Tabla diet_has_product
INSERT INTO diet_has_product (diet_id_fk, product_id_fk) VALUES
(1, 1),
(2, 2),
(3, 3),
(4, 5),
(5, 4);

SELECT * FROM user;
SELECT * FROM product;
SELECT * FROM orders;
SELECT * FROM subscription;
SELECT * FROM diet;

-- Calcular promedios de stock de productos
SELECT AVG(stock) AS average_stock
FROM product;
-- Calcular el total de stock de productos
SELECT SUM(stock) AS total_stock
FROM product;
-- Calcular el promedio de precio de los productos
SELECT AVG(price) AS average_price
FROM product;
-- Calcular el promedio de precio de la suscripción
SELECT AVG(price) AS average_price
FROM subscription;

-- Inner Join para saber las órdenes de cada usuario (fecha y hora)
SELECT orders.date_time, orders.status, user.first_name, user.last_name
FROM orders
INNER JOIN user ON orders.user_id_fk = user.user_id;

INSERT INTO orders(date_time, notes, quantity, status, user_id_fk) VALUES
('2024-12-03 09:20:00', 'Sin cebolla', 4, 'entregado', 1);