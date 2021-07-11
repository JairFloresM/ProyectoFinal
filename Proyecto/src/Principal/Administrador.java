package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Administrador {

    private String nombre, email, contraseña;

    public Administrador(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
    }

    public boolean registrarAdministrador() {

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
                return false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

        return true;
    }

}
