
package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class Cliente {

    ConectarBase con = new ConectarBase();

    public ArrayList<String> consultarClientes() {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT * FROM cliente";
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            
            ResultSet respuesta = estado.executeQuery();
            
            while(respuesta.next()) {
                datos.add(respuesta.getString("id_cliente")+ ";" + respuesta.getString("nombre")+ ";" + respuesta.getString("direccion")+ ";" + respuesta.getString("telefono")+ ";" + respuesta.getString("fecha_N"));
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Consulta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        con.desconectarDB();
        
        return datos;
    }
    
    public ArrayList<String> filtarDatosInt(int filtro) {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, filtro);
            ResultSet respuesta = estado.executeQuery();
            while(respuesta.next()) {
                datos.add(respuesta.getString("id_cliente")+ ";" + respuesta.getString("nombre")+ ";" + respuesta.getString("direccion")+ ";" + respuesta.getString("telefono")+ ";" + respuesta.getString("fecha_N"));
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Consulta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        con.desconectarDB();
        
        return datos;
    }
    
    public ArrayList<String> filtarDatosString(String filtro) {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT * FROM cliente WHERE nombre = ? OR fecha_N = ?";
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setString(1, filtro);
            estado.setString(2, filtro);
            
            ResultSet respuesta = estado.executeQuery();
            
            while(respuesta.next()) {
                datos.add(respuesta.getString("id_cliente")+ ";" + respuesta.getString("nombre")+ ";" + respuesta.getString("direccion")+ ";" + respuesta.getString("telefono")+ ";" + respuesta.getString("fecha_N"));
            }  
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error en la Consulta", "Error", JOptionPane.ERROR_MESSAGE);
        }
        con.desconectarDB();
        return datos;
    }
    
}
