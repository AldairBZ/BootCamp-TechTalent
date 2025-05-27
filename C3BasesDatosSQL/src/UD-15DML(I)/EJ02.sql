INSERT INTO proveedores (id, nombre) VALUES
('P001', 'Proveedor Alfa'),
('P002', 'Proveedor Beta'),
('P003', 'Proveedor Gamma'),
('P004', 'Proveedor Delta'),
('P005', 'Proveedor Épsilon'),
('P006', 'Proveedor Zeta'),
('P007', 'Proveedor Eta'),
('P008', 'Proveedor Theta'),
('P009', 'Proveedor Iota'),
('P010', 'Proveedor Kappa');


INSERT INTO piezas (codigo, nombre) VALUES
(1001, 'Tornillo M4'),
(1002, 'Tuerca M4'),
(1003, 'Arandela 10mm'),
(1004, 'Perno 8cm'),
(1005, 'Pasador metálico'),
(1006, 'Rodamiento 6202'),
(1007, 'Eje 20cm'),
(1008, 'Polea 2 canales'),
(1009, 'Engranaje 24T'),
(1010, 'Cable acero 1m');

INSERT INTO suministra (codigoPieza, idProveedor) VALUES
(1001, 'P001'),
(1002, 'P001'),
(1003, 'P002'),
(1004, 'P003'),
(1005, 'P004'),
(1006, 'P005'),
(1007, 'P006'),
(1008, 'P007'),
(1009, 'P008'),
(1010, 'P009'),
(1001, 'P010'),
(1002, 'P003'),
(1003, 'P004'),
(1004, 'P005'),
(1005, 'P006');