package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Administrador {

    public boolean registrarAdministrador(String nombre,String contraseña,String email) {

        ConectarBase con = new ConectarBase();
        String sql = "INSERT INTO administrador (nombre, email, contraseña) VALUES (?, ?, ?)";

        try {
            con.conectarDB();
            try {

                contraseña = PasswordAuthentication.hashearContra(contraseña);
                PreparedStatement estado = con.conexion.prepareStatement(sql);
                estado.setString(1, nombre);
                estado.setString(2, email);
                estado.setString(3, contraseña);

                estado.executeUpdate();

            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                con.desconectarDB();
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            con.desconectarDB();
            return false;
        }

        return true;

    }

    public void reiniciarIntentos(int id) {
        ConectarBase con = new ConectarBase();
        String sql = "UPDATE administrador SET cantidad_intentos=0 WHERE id_administrador=?";

        try {
            con.conectarDB();
            try {

                PreparedStatement estado = con.conexion.prepareStatement(sql);
                estado.setInt(1, id);
                estado.executeUpdate();
                JOptionPane.showMessageDialog(null, "Se ha reiniciado con exito");
                con.desconectarDB();
            } catch (SQLException ex) {
                Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
                con.desconectarDB();

            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            con.desconectarDB();

        }

    }

}
