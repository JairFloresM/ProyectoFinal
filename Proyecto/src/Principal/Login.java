package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login {

    /* Login(String auth, String contraseña) {
    
    String sql;
    sql = "SELECT * FROM administrador WHERE nombre=? OR email=?";
    ConectarBase con = new ConectarBase();
    PreparedStatement ps;
    try {
    ps = con.conexion.prepareStatement(sql);
    ps.setString(1, auth);
    ps.setString(2, auth);
    ResultSet respuesta = ps.executeQuery();
    
    if (respuesta.next()) {
    
    if (respuesta.getString("contraseña").equals(contraseña)) {
    JOptionPane.showMessageDialog(null, "Ha iniciado sesion con éxito");
    } else {
    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
    }
    
    } else {
    JOptionPane.showMessageDialog(null, "No existe este usuario o email");
    }
    } catch (SQLException ex) {
    Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
    }
    
    }*/
    public void metodo2(String auth, String contraseña) {

        String sql;
       
        sql = "SELECT * FROM administrador WHERE nombre=? OR email=?";

        ConectarBase con = new ConectarBase();
       
        try {
            con.conectarDB();
            PreparedStatement ps = con.conexion.prepareStatement(sql);
            
            ps.setString(1, auth);
            ps.setString(2, auth);
            ResultSet respuesta = ps.executeQuery();

            if (respuesta.next()) {

                if (respuesta.getString("contraseña").equals(contraseña)) {
                    JOptionPane.showMessageDialog(null, "Ha iniciado sesion con éxito");
                } else {
                    JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No existe este usuario o email");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
