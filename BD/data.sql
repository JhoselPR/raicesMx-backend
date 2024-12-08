USE raicesmx;

-- Tabla subscription
INSERT INTO subscription (subscription_type, benefits, price) VALUES
('Raíces Basic', 'Comida on demand.', 0),
('Raíces Gold', 'Envíos gratis, descuentos exclusivos y personalización de comida.', 79),
('Raíces Premium', 'Envíos gratis, descuentos exclusivos, soporte y atención prioritaria. Consulta nutricional con profesionales.', 2999);

-- Tabla user
INSERT INTO user (first_name, last_name, email, password, birthdate, address, role) VALUES
('Admin', 'RaícesMX', 'admin@admin.com', 'password123', '1990-03-15', 'Calle Reforma 123, Ciudad de México', 'admin'),
('Ana', 'Gómez', 'ana.gomez@example.com', 'securepass456', '1985-06-30', 'Av. Insurgentes 456, Ciudad de México', 'user'),
('Luis', 'Pérez', 'luis.perez@example.com', 'mypassword789', '1992-12-10', 'Paseo de la Reforma 789, Ciudad de México', 'user'),
('María', 'López', 'maria.lopez@example.com', 'pass321', '2000-01-25', 'Av. Universidad 321, Ciudad de México', 'user'),
('Elena', 'Rodríguez', 'elena.rodriguez@example.com', 'elena2023', '1995-07-14', 'Calle Independencia 2023, Ciudad de México', 'user');

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
INSERT INTO product (name, description, ingredients, meal_time, image, price, extras) VALUES
('Ensalada César', 'Ensalada fresca con aderezo César.', 'Lechuga, crutones, parmesano, pollo', 'almuerzo', 'image1.jpg', 120, 'Pollo extra'),
('Sándwich Vegano', 'Sándwich saludable con ingredientes veganos.', 'Pan integral, aguacate, hummus, espinaca', 'desayuno', 'image2.jpg', 80, NULL),
('Wrap de Pollo', 'Wrap relleno de pollo y vegetales.', 'Tortilla, pollo, lechuga, tomate', 'almuerzo', 'image3.jpg', 150, 'Aderezo extra'),
('Smoothie Tropical', 'Bebida refrescante de frutas tropicales.', 'Mango, piña, coco, plátano', 'bebida', 'image4.jpg', 60, NULL),
('Pasta Primavera', 'Pasta ligera con vegetales frescos.', 'Pasta, brócoli, zanahoria, calabacín', 'cena', 'image5.jpg', 180, 'Queso parmesano');

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