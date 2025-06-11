package com.tetrisgame;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PuntuacionDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/tetris";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public void guardarPuntuacion(String jugador, int puntuacion) {
        String sql = "INSERT INTO puntuaciones (jugador, puntuacion) VALUES (?, ?)";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, jugador);
            stmt.setInt(2, puntuacion);
            stmt.executeUpdate();

            System.out.println("Puntuación guardada correctamente.");

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al guardar la puntuación.");
        }
    }
    public int obtenerMaxPuntuacion() {
        String sql = "SELECT MAX(puntuacion) AS max_puntuacion FROM puntuaciones";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                return rs.getInt("max_puntuacion");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener la máxima puntuación.");
        }
        return 0; // Si no hay registros o error, devuelve 0
    }
    public List<String> obtenerTop10() {
        String sql = "SELECT jugador, puntuacion FROM puntuaciones ORDER BY puntuacion DESC LIMIT 10";
        List<String> top10 = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(sql);
             var rs = stmt.executeQuery()) {

            int posicion = 1;
            while (rs.next()) {
                String jugador = rs.getString("jugador");
                int puntuacion = rs.getInt("puntuacion");
                top10.add(posicion + ". " + jugador + " - " + puntuacion);
                posicion++;
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.err.println("Error al obtener el Top 10.");
        }

        return top10;
    }
}
