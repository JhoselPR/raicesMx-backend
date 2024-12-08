USE raicesmx;

SELECT * FROM user;

INSERT INTO subscription (subscription_type, benefits, price)
VALUES
('Raíces Basic', 'Comida on demand.', 0),
('Raíces Gold', 'Envíos gratis, descuentos exclusivos y personalización de comida.', 79),
('Raíces Premium', 'Envíos gratis, descuentos exclusivos, soporte y atención prioritaria. Consulta nutricional con profesionales.', 2999);