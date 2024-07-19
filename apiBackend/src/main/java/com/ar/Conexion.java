package com.ar;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class Conexion {
    private String jdbcURL = "jdbc:mysql://localhost:3306/musicDatabase";
    private String jdbcUsername = "root";
    private String jdbcPassword = "12345";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException(e);
        }
        return DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
    }

    public List<Melody> getMelody() {
        List<Melody> melodies = new ArrayList<>();
        String sql = "SELECT * FROM melodies";

        try (Connection conn = getConnection();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Melody melody = new Melody();
                melody.setId(rs.getInt("id"));
                melody.setTitle(rs.getString("title"));
                melody.setGenre(rs.getString("genre"));
                melody.setDuration(rs.getString("duration"));
                melody.setImages(rs.getString("images"));
                melodies.add(melody);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return melodies;
    }

    public void addMelody(Melody melody) throws SQLException {
        String sql = "INSERT INTO melodies (title, genre, duration, images) VALUES (?, ?, ?, ?)";
        Connection conn = getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(sql)) {  
            stmt.setString(1, melody.getTitle());
            stmt.setString(2, melody.getGenre());
            stmt.setString(3, melody.getDuration());
            stmt.setString(4, melody.getImages());
            stmt.executeUpdate();
        } finally {
            conn.close();
        }
    }

    public void deleteMelody(int id) throws SQLException {
        String sql = "DELETE FROM melodies WHERE id = ?";
        Connection conn = getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } finally {
            conn.close();
        }
    }
}