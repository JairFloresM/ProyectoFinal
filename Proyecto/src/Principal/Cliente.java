
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
    
    public ArrayList<String> filtarDatosString(String filtro) {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT * FROM cliente WHERE nombre REGEXP ? OR direccion REGEXP ? OR telefono REGEXP ? OR fecha_N REGEXP ?";
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setString(1, filtro);
            estado.setString(2, filtro);
            estado.setString(3, filtro);
            estado.setString(4, filtro);
            
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
    
    
    public ArrayList<String> verificarCliente(int id) {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, id);
            
            ResultSet respuesta = estado.executeQuery();
            if(respuesta.next()) {
                datos.add(respuesta.getString("id_cliente")+ ";" + respuesta.getString("nombre")+ ";" + respuesta.getString("direccion")+ ";" + respuesta.getString("telefono")+ ";" + respuesta.getString("fecha_N"));
                return datos;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        datos.clear();
        con.desconectarDB();
        return datos;
    }
    
    public void editarCliente(int id, String nom, String dir, String tel, String fec) {
        String sql = "UPDATE cliente SET nombre = ?, direccion = ?, telefono = ?, fecha_N = ? WHERE id_cliente = ?";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setString(1, nom);
            estado.setString(2, dir);
            estado.setString(3, tel);
            estado.setString(4, fec);
            estado.setInt(5, id);
            
            estado.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Se ha editado el cliente correctamente.", "Succes", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void agregarCliente(String nom, String dir, String tel, String fec) {
        ConectarBase con = new ConectarBase();
        String sql = "INSERT INTO cliente (nombre, direccion, telefono, fecha_N) VALUES(?, ?, ?, ?)";
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setString(1, nom);
            estado.setString(2, dir);
            estado.setString(3, tel);
            estado.setString(4, fec);

            estado.executeUpdate();

            JOptionPane.showMessageDialog(null, "El cliente se ha agregado correctamente.", "Succes", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (SQLException ex) {
//            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "El cliente se ha agregado correctamente.", "Succes", JOptionPane.INFORMATION_MESSAGE);
        }
        con.desconectarDB();
    }
    
    public void eliminarCliente(int id) {
        ConectarBase con = new ConectarBase();
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, id);
            estado.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectarDB();
    }
    
    
}
