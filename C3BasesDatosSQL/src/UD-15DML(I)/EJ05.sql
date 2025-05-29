INSERT INTO facultad (codigo, nombre) VALUES
(1, 'Facultad de Ingeniería'),
(2, 'Facultad de Ciencias'),
(3, 'Facultad de Medicina'),
(4, 'Facultad de Derecho'),
(5, 'Facultad de Psicología'),
(6, 'Facultad de Economía'),
(7, 'Facultad de Arquitectura'),
(8, 'Facultad de Informática'),
(9, 'Facultad de Biología'),
(10, 'Facultad de Química');

INSERT INTO investigadores (dni, nomApels, facultad) VALUES
('11111111', 'Laura Sánchez',       1),
('22222222', 'Miguel Torres',       2),
('33333333', 'Ana López',           3),
('44444444', 'Javier Ruiz',         4),
('55555555', 'Clara Gómez',         5),
('66666666', 'Daniel Martín',       6),
('77777777', 'Lucía Romero',        7),
('88888888', 'Carlos Navarro',      8),
('99999999', 'Sofía Ramos',         9),
('00000000', 'Andrés Vidal',       10);

INSERT INTO equipos (numSerie, nombre, facultad) VALUES
('E001', 'Microscopio Óptico',        9),
('E002', 'Centrífuga de Laboratorio', 10),
('E003', 'Servidor HPC',               8),
('E004', 'Impresora 3D',              1),
('E005', 'Equipo de Resonancia',      3),
('E006', 'Estación Meteorológica',    2),
('E007', 'Escáner Cerebral',          5),
('E008', 'Simulador Jurídico',        4),
('E009', 'Plotter Arquitectónico',    7),
('E010', 'Sistema Económico',         6);


INSERT INTO reserva (dni, numSerie, comienzo, fin) VALUES
('11111111', 'E004', '2025-01-10 09:00:00', '2025-01-10 12:00:00'),
('22222222', 'E006', '2025-02-15 14:00:00', '2025-02-15 16:00:00'),
('33333333', 'E005', '2025-03-20 08:30:00', '2025-03-20 11:00:00'),
('44444444', 'E008', '2025-04-01 10:00:00', '2025-04-01 13:00:00'),
('55555555', 'E007', '2025-01-25 15:00:00', '2025-01-25 18:00:00'),
('66666666', 'E010', '2025-03-05 09:00:00', '2025-03-05 12:00:00'),
('77777777', 'E009', '2025-02-10 10:00:00', '2025-02-10 13:00:00'),
('88888888', 'E003', '2025-04-18 11:00:00', '2025-04-18 14:00:00'),
('99999999', 'E001', '2025-05-22 08:00:00', '2025-05-22 10:00:00'),
('00000000', 'E002', '2025-06-30 14:30:00', '2025-06-30 17:30:00');