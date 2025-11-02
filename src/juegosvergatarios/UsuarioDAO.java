package juegosvergatarios;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UsuarioDAO {

    public boolean registrarUsuario(String nombre, String apellido, String correo, String contrasena) {
        String sql = "INSERT INTO usuarios (nombre, apellido, correo_electronico, contrasena_hash, rol) VALUES (?, ?, ?, ?, 'cliente')";

        try (Connection conn = ConexionDB.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            if (conn == null) {
                return false;
            }

            pstmt.setString(1, nombre);
            pstmt.setString(2, apellido);
            pstmt.setString(3, correo);
            
            pstmt.setString(4, contrasena); 

            int filasAfectadas = pstmt.executeUpdate();

            return filasAfectadas > 0;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}