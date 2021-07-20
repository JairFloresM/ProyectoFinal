package ModuloAdmin;

import ModuloLogin.ConectarBase;
import ModuloLogin.PasswordAuthentication;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Administrador {

    private ConectarBase con = new ConectarBase();
    
    public boolean registrarAdministrador(String nombre,String contraseña,String email) {
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
    
    public ArrayList<String> consultarAdmins() {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT id_administrador, nombre, email, cantidad_intentos FROM administrador";
        
        try {
            con.conectarDB();
            
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            ResultSet respuesta = estado.executeQuery();
            
            while(respuesta.next()) {
                datos.add(respuesta.getString("id_administrador") + ";" + respuesta.getString("nombre") + ";" + respuesta.getString("email") + ";" + respuesta.getString("cantidad_intentos"));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Administrador.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Consulta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        return datos;
    }
    
    
    public boolean validarAdmin(String admin) {
        String sql = "SELECT * FROM administrador WHERE nombre = ?  ";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setString(1, admin);
            
            ResultSet respuesta = estado.executeQuery();
            
            if(respuesta.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        
        return false;
    }

}
