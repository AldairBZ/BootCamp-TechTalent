CREATE DATABASE IF NOT EXISTS compraventas;
USE compraventas;

-- 📌 Tabla CLIENTES (Vinculada con facturas de venta)
CREATE TABLE clientes (
    nif_dni VARCHAR(20) PRIMARY KEY,
    correo VARCHAR(100) NOT NULL UNIQUE,
    nombre VARCHAR(50) NOT NULL,
    telefono VARCHAR(15)
);

-- 📌 Tabla FACTURAS_VENTA (Vinculada con CLIENTES y VENTAS_COMPRAS)
CREATE TABLE facturas_venta (
    n_factura INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    nif_dni_cliente VARCHAR(20),
    FOREIGN KEY (nif_dni_cliente) REFERENCES clientes(nif_dni)
);

-- 📌 Tabla PROVEEDORES (Vinculada con facturas de compra)
CREATE TABLE proveedores (
    nif_dni VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    correo VARCHAR(100) NOT NULL UNIQUE,
    telefono VARCHAR(15)
);

-- 📌 Tabla FACTURAS_COMPRA (Vinculada con PROVEEDORES y VENTAS_COMPRAS)
CREATE TABLE facturas_compra (
    n_factura INT PRIMARY KEY AUTO_INCREMENT,
    fecha DATE NOT NULL,
    nif_dni_proveedor VARCHAR(20),
    FOREIGN KEY (nif_dni_proveedor) REFERENCES proveedores(nif_dni)
);

-- 📌 Tabla PRODUCTOS (Vinculada con pedidos y facturas)
CREATE TABLE productos (
    n_serie VARCHAR(20) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    inventario INT NOT NULL
);

-- 📌 Tabla VENTAS_COMPRAS (🔗 CONECTADA con clientes, proveedores, productos y facturas)
CREATE TABLE ventas_compras (
    n_pedido INT PRIMARY KEY AUTO_INCREMENT,
    n_factura_venta INT,
    n_factura_compra INT,
    nif_dni_cliente VARCHAR(20),
    nif_dni_proveedor VARCHAR(20),
    FOREIGN KEY (n_factura_venta) REFERENCES facturas_venta(n_factura),
    FOREIGN KEY (n_factura_compra) REFERENCES facturas_compra(n_factura),
    FOREIGN KEY (nif_dni_cliente) REFERENCES clientes(nif_dni),
    FOREIGN KEY (nif_dni_proveedor) REFERENCES proveedores(nif_dni)
);

-- 📌 Tabla SE_COMPONE (Relaciona pedidos con productos)
CREATE TABLE se_compone (
    cantidad INT NOT NULL,
    n_pedido INT,
    n_serie VARCHAR(20),
    PRIMARY KEY (n_pedido, n_serie),
    FOREIGN KEY (n_pedido) REFERENCES ventas_compras(n_pedido),
    FOREIGN KEY (n_serie) REFERENCES productos(n_serie)
);
