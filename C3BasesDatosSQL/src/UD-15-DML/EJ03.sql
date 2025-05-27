INSERT INTO cientificos (dni, nomApels) VALUES
('11111111', 'Laura Sánchez'),
('22222222', 'Miguel Torres'),
('33333333', 'Ana López'),
('44444444', 'Javier Ruiz'),
('55555555', 'Clara Gómez'),
('66666666', 'Daniel Martín'),
('77777777', 'Lucía Romero'),
('88888888', 'Carlos Navarro'),
('99999999', 'Sofía Ramos'),
('00000000', 'Andrés Vidal');

INSERT INTO proyectos (id, nombre, horas) VALUES
('P001', 'Desarrollo IA',            1200),
('P002', 'Estudio Genético',         800),
('P003', 'Simulación Física',        950),
('P004', 'Proyecto Espacial',       1500),
('P005', 'Análisis de Datos',        600),
('P006', 'Redes Neuronales',         720),
('P007', 'Bioinformática',           840),
('P008', 'Robótica Avanzada',       1100),
('P009', 'Criptografía Cuántica',    500),
('P010', 'Visión Artificial',        780);

INSERT INTO asignado_a (cientifico, proyecto) VALUES
('11111111', 'P001'),
('11111111', 'P005'),
('22222222', 'P002'),
('33333333', 'P003'),
('33333333', 'P004'),
('44444444', 'P006'),
('55555555', 'P007'),
('66666666', 'P008'),
('77777777', 'P009'),
('88888888', 'P010'),
('99999999', 'P001'),
('00000000', 'P002');