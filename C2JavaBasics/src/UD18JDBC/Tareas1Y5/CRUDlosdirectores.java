package UD18JDBC.Tareas1Y5;

import java.sql.*;

public class CRUDlosdirectores {
    
    static final String URL = "jdbc:mysql://localhost:3306/losdirectores";
    static final String USER = "root";
    static final String PASSWORD = "";

    public static void main(String[] args) {
        Connection conexion = null;
        Statement statement = null;

        try {
            // Establecer conexión con MySQL
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println(" Conexión exitosa a la base de datos 'losdirectores'");

            // Crear objeto Statement para ejecutar consultas SQL
            statement = conexion.createStatement();

            // Eliminar primero la tabla 'directores' antes de borrar 'despachos'
            statement.executeUpdate("DELETE FROM directores");
            statement.executeUpdate("DELETE FROM despachos");

            // Insertar registros en la tabla despachos
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (101, 3)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (102, 4)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (103, 5)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (104, 2)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (105, 3)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (106, 4)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (107, 6)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (108, 2)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (109, 4)");
            statement.executeUpdate("INSERT INTO despachos (Numero, Capacidad) VALUES (110, 3)");

            // Primero insertamos los directores que no tienen jefe
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('98765432', 'María López', NULL, 104)");

            // Luego insertamos los directores con jefe existente
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('12345678', 'Luis García', '98765432', 101)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('87654321', 'Ana Rodríguez', '12345678', 102)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('56789012', 'Carlos Pérez', '87654321', 103)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('34567890', 'Javier Fernández', '56789012', 105)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('23456789', 'Paula Martínez', '34567890', 106)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('67890123', 'Sergio Ramírez', '23456789', 107)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('45678901', 'Beatriz Gómez', '67890123', 108)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('78901234', 'Manuel Torres', '45678901', 109)");
            statement.executeUpdate("INSERT INTO directores (DNI, NomApels, DNIJefe, Despacho) VALUES ('90123456', 'Carmen Vázquez', '78901234', 110)");

            // Actualizar un registro en 'directores'
            statement.executeUpdate("UPDATE directores SET NomApels = 'Luis García López' WHERE DNI = '12345678'");

            // Primero eliminamos los directores que tienen como jefe a '87654321'
            statement.executeUpdate("UPDATE directores SET DNIJefe = NULL WHERE DNIJefe = '87654321'");

            // Luego eliminamos el director '87654321'
            statement.executeUpdate("DELETE FROM directores WHERE DNI = '87654321'");

            // Consultar y mostrar registros de 'despachos'
            ResultSet resultSetDespachos = statement.executeQuery("SELECT * FROM despachos");
            System.out.println(" Registros en la tabla 'despachos':");
            while (resultSetDespachos.next()) {
                System.out.println("Número: " + resultSetDespachos.getInt("Numero") +
                                   ", Capacidad: " + resultSetDespachos.getInt("Capacidad"));
            }

            // Consultar y mostrar registros de 'directores'
            ResultSet resultSetDirectores = statement.executeQuery("SELECT * FROM directores");
            System.out.println("\n Registros en la tabla 'directores':");
            while (resultSetDirectores.next()) {
                System.out.println("DNI: " + resultSetDirectores.getString("DNI") +
                                   ", Nombre: " + resultSetDirectores.getString("NomApels") +
                                   ", DNI Jefe: " + resultSetDirectores.getString("DNIJefe") +
                                   ", Despacho: " + resultSetDirectores.getInt("Despacho"));
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