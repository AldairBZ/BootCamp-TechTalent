package UD19SwingAWT;

import java.sql.*;

public class HistorialBD {
    
    // Guardar operación en la base de datos
    public static void guardarOperacion(String operacion, double resultado) {
        String sql = "INSERT INTO historial_operaciones (operacion, resultado) VALUES (?, ?)";

        try (Connection conexion = ConnexionBD.obtenerConexion();
             PreparedStatement stmt = conexion.prepareStatement(sql)) {
            
            if (conexion == null) {
                System.out.println("No hay conexión a la base de datos para guardar.");
                return;
            }

            stmt.setString(1, operacion);
            stmt.setDouble(2, resultado);
            stmt.executeUpdate();
            
            System.out.println("Operación guardada correctamente.");
        } catch (SQLException e) {
            System.out.println("Error al guardar la operación: " + e.getMessage());
        }
    }

    // Mostrar historial (opcional, si quieres llenar la lista desde BD)
    public static void mostrarHistorial() {
        String sql = "SELECT operacion, resultado, fecha FROM historial_operaciones ORDER BY fecha DESC";

        try (Connection conexion = ConnexionBD.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("Historial de operaciones:");
            while (rs.next()) {
                System.out.println(rs.getString("operacion") + " = " + rs.getDouble("resultado") + " (" + rs.getTimestamp("fecha") + ")");
            }
        } catch (SQLException e) {
            System.out.println("Error al mostrar historial: " + e.getMessage());
        }
    }
}
