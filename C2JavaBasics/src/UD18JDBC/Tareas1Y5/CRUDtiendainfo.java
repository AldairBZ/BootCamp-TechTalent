package UD18JDBC.Tareas1Y5;

import java.sql.*;

public class CRUDTiendainfo {
    // Datos de conexión a la base de datos
    static final String URL = "jdbc:mysql://localhost:3306/tiendainfo";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try {
            // Establecer conexión con MySQL
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexión exitosa a la base de datos 'tiendainfo'");

            // Crear objeto Statement para ejecutar consultas SQL
            statement = conexion.createStatement();

            // Insertar registros en la tabla 'fabricantes'
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (1, 'Intel')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (2, 'AMD')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (3, 'NVIDIA')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (4, 'Samsung')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (5, 'Sony')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (6, 'LG')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (7, 'Corsair')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (8, 'Seagate')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (9, 'Western Digital')");
            statement.executeUpdate("INSERT INTO fabricantes (Codigo, Nombre) VALUES (10, 'Apple')");

            // Insertar registros en la tabla 'articulos'
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (1, 'Procesador i7', 300, 1)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (2, 'Tarjeta Gráfica RTX 3060', 500, 3)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (3, 'Memoria RAM 16GB', 120, 2)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (4, 'SSD 1TB', 150, 8)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (5, 'Monitor 27” 4K', 700, 5)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (6, 'Teclado mecánico', 100, 7)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (7, 'Mouse gaming', 80, 7)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (8, 'Auriculares inalámbricos', 200, 6)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (9, 'Disco duro externo 2TB', 130, 9)");
            statement.executeUpdate("INSERT INTO articulos (Codigo, Nombre, Precio, Fabricante) VALUES (10, 'Smartphone', 1000, 10)");

            // Actualizar un registro en 'fabricantes'
            statement.executeUpdate("UPDATE fabricantes SET Nombre = 'Intel Corporation' WHERE Codigo = 1");

            // Eliminar un registro de 'fabricantes'
            statement.executeUpdate("DELETE FROM fabricantes WHERE Codigo = 2");

            // Consultar y mostrar registros de 'fabricantes'
            ResultSet resultSetFabricantes = statement.executeQuery("SELECT * FROM fabricantes");
            System.out.println(" Registros en la tabla 'fabricantes':");
            while (resultSetFabricantes.next()) {
                System.out.println("Código: " + resultSetFabricantes.getInt("Codigo") +
                                   ", Nombre: " + resultSetFabricantes.getString("Nombre"));
            }

            // Consultar y mostrar registros de 'articulos'
            ResultSet resultSetArticulos = statement.executeQuery("SELECT * FROM articulos");
            System.out.println("\n Registros en la tabla 'articulos':");
            while (resultSetArticulos.next()) {
                System.out.println("Código: " + resultSetArticulos.getInt("Codigo") +
                                   ", Nombre: " + resultSetArticulos.getString("Nombre") +
                                   ", Precio: $" + resultSetArticulos.getDouble("Precio") +
                                   ", Fabricante ID: " + resultSetArticulos.getInt("Fabricante"));
            }

        } catch (SQLException e) {
            System.out.println(" Error al conectar con la base de datos: " + e.getMessage());
        } finally {
            try {
                if (statement != null) statement.close();
                if (conexion != null) conexion.close();
                System.out.println("\n Conexión cerrada");
            } catch (SQLException e) {
                System.out.println(" Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }
}