package model;

import java.sql.*;
import java.util.*;

public class VideoDAO {
    private Connection conn = Conexion.conectar();

    public void insertar(Video video) {
        String sql = "INSERT INTO video (titulo, director, id_cliente) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, video.getTitulo());
            stmt.setString(2, video.getDirector());
            stmt.setInt(3, video.getIdCliente());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Video> listar() {
        List<Video> lista = new ArrayList<>();
        String sql = "SELECT * FROM video";
        try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new Video(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("director"),
                    rs.getInt("id_cliente")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void actualizar(Video video) {
        String sql = "UPDATE video SET titulo=?, director=?, id_cliente=? WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, video.getTitulo());
            stmt.setString(2, video.getDirector());
            stmt.setInt(3, video.getIdCliente());
            stmt.setInt(4, video.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM video WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Video buscarPorId(int id) {
        String sql = "SELECT * FROM video WHERE id=?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new Video(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("director"),
                    rs.getInt("id_cliente")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}