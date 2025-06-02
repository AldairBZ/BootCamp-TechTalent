package UD19SwingAWT;

import java.sql.*;

import javax.swing.DefaultListModel;

public class HistorialBD {
    
    // Método para guardar una operación en la base de datos
	public static void guardarOperacion(String operacion, double resultado) {
	    String sql = "INSERT INTO historial_operaciones (operacion, resultado) VALUES (?, ?)";

	    try (Connection conexion = ConnexionBD.obtenerConexion();
	         PreparedStatement stmt = conexion.prepareStatement(sql)) {

	        stmt.setString(1, operacion);
	        stmt.setDouble(2, resultado);

	        int filasAfectadas = stmt.executeUpdate();
	        if (filasAfectadas > 0) {
	            System.out.println("✅ Operación guardada correctamente.");
	        } else {
	            System.out.println("⚠ No se insertó ninguna fila en la base de datos.");
	        }

	    } catch (SQLException e) {
	        System.out.println("Error al guardar la operación: " + e.getMessage());
	        e.printStackTrace();  // ✅ Agregamos esto para ver detalles del error
	    }
	}



    // Método para recuperar todas las operaciones desde la base de datos
    public static void mostrarHistorial() {
        String sql = "SELECT operacion, resultado, fecha FROM historial_operaciones ORDER BY fecha DESC";

        try (Connection conexion = ConnexionBD.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            System.out.println("Historial de operaciones:");
            while (rs.next()) {
                System.out.println(rs.getString("operacion") + " | Resultado: " + rs.getDouble("resultado") + " | Fecha: " + rs.getTimestamp("fecha"));
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar el historial: " + e.getMessage());
        }
    }
    
    public static DefaultListModel<String> obtenerHistorial() {
        DefaultListModel<String> modelo = new DefaultListModel<>();
        String sql = "SELECT operacion, resultado FROM historial_operaciones ORDER BY fecha DESC";

        try (Connection conexion = ConnexionBD.obtenerConexion();
             Statement stmt = conexion.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            
            while (rs.next()) {
                String operacion = rs.getString("operacion");
                double resultado = rs.getDouble("resultado");
                modelo.addElement(operacion + " = " + resultado);
            }
        } catch (SQLException e) {
            System.out.println("Error al recuperar el historial: " + e.getMessage());
        }

        return modelo;
    }

}