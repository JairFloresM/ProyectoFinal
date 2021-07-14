package Principal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Producto {

    private int codigo_p;
    private String descripcion;
    private int cant_disp;
    private double precio;

    public void agregarProducto(String descripcion, int cant_disp, double precio) {
        ConectarBase con = new ConectarBase();
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
        ConectarBase con = new ConectarBase();
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

}
