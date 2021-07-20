package ModuloLogin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ConectarBase {

    public Connection conexion;

    public void conectarDB() throws SQLException {
        final String controlador = "com.mysql.jdbc.Driver";
        try {
            Class.forName(controlador);
            final String url_db = "jdbc:mysql://localhost:3306/egph_juegos";
            conexion = DriverManager.getConnection(url_db, "utp2021", "12345");
            //JOptionPane.showMessageDialog(null,"Conexion exitosa");
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ConectarBase.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error en la conexion", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void desconectarDB() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException ex) {
                //Logger.getLogger(ConectarBasedeDatos.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, ex.getMessage(), "No es posible la desconexion", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}