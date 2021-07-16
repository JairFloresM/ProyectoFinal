package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Login {

    public boolean nuevoLogin(String auth, String contraseña) {
        boolean resp = false;
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
                if (Integer.parseInt(respuesta.getString("cantidad_intentos")) >= 3) {
                    JOptionPane.showMessageDialog(null, "Ha alcanzado el límite de intentos, le hemos enviado un correo con instrucciones para reactivar su cuenta");
                    enviarCorreo(respuesta.getString("email"));
                    resp = false;
                } else {
                    if (respuesta.getString("contraseña").equals(contraseña)) {
                        JOptionPane.showMessageDialog(null, "Ha iniciado sesion con éxito");
                        resp = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden");
                        intentoFallido(auth);
                        resp = false;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "No existe este usuario o email");
                resp = false;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            resp = false;
        }
        return resp;
    }

    public void intentoFallido(String auth) {
        String sql;

        sql = "UPDATE administrador SET cantidad_intentos=cantidad_intentos+1 WHERE email=? OR nombre=?";

        ConectarBase con = new ConectarBase();

        try {
            con.conectarDB();
            PreparedStatement ps = con.conexion.prepareStatement(sql);

            ps.setString(1, auth);
            ps.setString(2, auth);
            ps.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void enviarCorreo(String recipient) {

        String sender = "michia0378@gmail.com";
        String host = "localhost";
        String subject = "Cuenta bloqueda por exceso de intentos al ingresar";
        String mensaje = "Su cuenta ha sido bloqueda porque se ha registrado mas de 3 intentos de login fallidos, porfavor "
                + "comuníquese con un administrador para reestablecer su cuenta";
        NuevoMail.enviar(recipient, sender, host, subject, mensaje);
    }
}
