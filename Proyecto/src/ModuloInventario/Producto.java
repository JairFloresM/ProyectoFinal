package ModuloInventario;

import ModuloCliente.Cliente;
import ModuloLogin.ConectarBase;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Producto {
    
    private ConectarBase con = new ConectarBase();

    public void agregarProducto(String descripcion, int cant_disp, double precio) {
        
        try {
            con.conectarDB();
            String sql = "INSERT INTO producto (descripcion,cantidad_disponible,precio_unitario) VALUES (?,?,?)";
            PreparedStatement ps = con.conexion.prepareStatement(sql);
            ps.setString(1, descripcion);
            ps.setInt(2, cant_disp);
            ps.setDouble(3, precio);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarProducto(int id_producto) {
        
        try {
            con.conectarDB();
            String sql = "DELETE FROM producto WHERE id_producto=?;";
            PreparedStatement ps = con.conexion.prepareStatement(sql);
            ps.setInt(1, id_producto);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Producto eliminado exitosamente");
        } catch (SQLException ex) {
            Logger.getLogger(Producto.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public ArrayList<String> verificarProducto(int id) {
        ArrayList<String> datos = new ArrayList<String>();
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, id);
            
            ResultSet respuesta = estado.executeQuery();
            if(respuesta.next()) {
                datos.add(respuesta.getString("id_producto")+ ";" + respuesta.getString("descripcion")+ ";" + respuesta.getString("cantidad_disponible")+ ";" + respuesta.getString("precio_unitario"));
                return datos;
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        datos.clear();
        con.desconectarDB();
        return datos;
    }
    
    
    
    public void editarProductos(String desc, int cant, double prec, int id) {
        String sql = "UPDATE producto SET descripcion = ?, cantidad_disponible= ?, precio_unitario = ? WHERE id_producto = ?";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setString(1, desc);
            estado.setInt(2, cant);
            estado.setDouble(3, prec);
            estado.setInt(4, id);
            
            estado.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
