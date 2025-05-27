INSERT INTO despachos (numero, capacidad) VALUES
(1, 2),
(2, 3),
(3, 1),
(4, 2),
(5, 4),
(6, 2),
(7, 3),
(8, 1),
(9, 2),
(10, 5);
    

INSERT INTO directores (dni, nomApels, dniJefe, despacho) VALUES
('12345678', 'Ana Pérez',         NULL,        1),
('23456789', 'Luis Martínez',     '12345678',  2),
('34567890', 'Carlos Ruiz',       '12345678',  3),
('45678901', 'Marta Gómez',       '23456789',  4),
('56789012', 'José Ramírez',      NULL,        5),
('67890123', 'Lucía Fernández',   '56789012',  6),
('78901234', 'Raúl Díaz',         '56789012',  7),
('89012345', 'Elena Torres',      '67890123',  8),
('90123456', 'Pablo Navarro',     '67890123',  9),
('01234567', 'Carmen Morales',    '78901234', 10);