
package Principal;

import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Factura {
    
    ConectarBase con = new ConectarBase();
    
    public boolean validarCliente(int id) {
        String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, id);
            
            ResultSet resultado = estado.executeQuery();
            
            if(resultado.next()) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconectarDB();
        return false;
    }
    
    public ArrayList<String> consultarProducto(int id) {
        ArrayList<String> dato  = new ArrayList<String>(); 
        String sql = "SELECT * FROM producto WHERE id_producto = ?";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, id);
            
            ResultSet resultado = estado.executeQuery();
            
            if(resultado.next()) {
                dato.add(resultado.getString("id_producto") + ";" + resultado.getString("descripcion") + ";" + resultado.getString("cantidad_disponible") + ";" + resultado.getString("precio_unitario"));
                return dato;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectarDB();
        return dato;
    }
    
    public ArrayList<String> validarCantidad(ArrayList<String> dato, int cantS, ArrayList<String> cantidades) {
        String[] prods = dato.get(0).split(";");
        String[] cants = null;
        boolean filtro = false;
        double neuvaCant;
        int cantT = 0, cantA = 0;

        if (cantS > 0) {
            for(int i=0; i<cantidades.size(); i++) {
                cants = cantidades.get(i).split(";");
                if(prods[0].equals(cants[0])) {
                    filtro = true;
                    break;
                } 
            }
            
            if(filtro) {
                cantT = Integer.parseInt(cants[cants.length - 1]);
                cantA = cantT - cantS;
            } else {
                cantT = Integer.parseInt(prods[prods.length - 2]);
                cantA = cantT - cantS;
            }
            
            
            if (!(cantA <= 0) || cantA == 0) {
                double precioT = cantS * Double.parseDouble(prods[prods.length - 1]);
                dato.set(0, prods[0] + ";" + prods[1] + ";" + cantS + ";" + prods[prods.length - 1] + ";" + precioT + ";" + cantA);
                
                return dato;
            }
            
            

            if ((cantA < 0) && cantT != 0) {
                JOptionPane.showMessageDialog(null, "Solo se encuentran disponible " + cantT + " Productos.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "No hay mas productos disponibles", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese un numero mayor que 0", "Error", JOptionPane.ERROR_MESSAGE);
        }

        dato.clear();
        return dato;
    } 
    
    public int facturarProductos(ArrayList<String> datos, int id_cliente) {
        double precioTotal = 0;
        String []items = null;
        String sql = "INSERT INTO factura (id_cliente, fecha, precio_total) VALUES (?, ?, ?)";
        int id_fact;
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            
            estado.setInt(1, id_cliente);
            estado.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
            estado.setDouble(3, precioTotal);
            
            estado.executeUpdate();
            ResultSet respuesta = estado.getGeneratedKeys();
            
            if (respuesta.next()) {
                return id_fact = respuesta.getInt(1);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return 0;
    }
    
    public void generarDetalleFactura(int id_fact, ArrayList<String> datos) {
        String sql = "INSERT INTO detalle_factura( id_factura, id_producto, cantidad_producto, precio_unitario) VALUES (?, ?, ?, ?)";
        String []items = null;
        double precioTotal = 0;
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            
            for (int i = 0; i < datos.size(); i++) {
                items = datos.get(i).split(";");
                estado.setInt(1, id_fact);
                estado.setInt(2, Integer.parseInt(items[0]));
                estado.setInt(3, Integer.parseInt(items[2]));
                estado.setDouble(4, Double.parseDouble(items[items.length-2]));
                estado.addBatch();
            }
            
            estado.executeBatch();

        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        con.desconectarDB();
    }
    
    void actualizarCantidades(int cantidad, int id) {
        String sql = "UPDATE producto SET cantidad_disponible = ?  WHERE id_producto = ?";
    
        try {
            con.conectarDB();
            
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            estado.setInt(1, cantidad);
            estado.setInt(2, id);
            
            estado.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.desconectarDB();
    }
    
    public ArrayList<String> consultarFacturas() {
        ArrayList<String> facts = new ArrayList<String>();
        
        String sql = "SELECT * FROM factura";
        
        try {
            con.conectarDB();
            PreparedStatement estado = con.conexion.prepareStatement(sql);
            
            ResultSet respuesta = estado.executeQuery();
            
            while(respuesta.next()) {
                facts.add(respuesta.getString("id_factura") + ";" + respuesta.getString("id_cliente") + ";" + respuesta.getString("fecha") + ";" + respuesta.getString("precio_total") + ";");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Factura.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return facts;
    }
}
