package ModuloFacturacion;

import ModuloLogin.ConectarBase;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Reporte {

    public ArrayList<String> consultarDetalle() {
        ArrayList<String> datos = new ArrayList<String>();
        ConectarBase con = new ConectarBase();
        String sql;
        try {
            con.conectarDB();

            sql = "SELECT f.id_cliente, f.fecha, p.descripcion, da.cantidad_producto, da.precio_unitario FROM detalle_factura da INNER JOIN factura f ON da.id_factura = f.id_factura INNER JOIN producto p ON da.id_producto = p.id_producto ORDER BY f.id_cliente, f.fecha";
            PreparedStatement ps = con.conexion.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                datos.add(resultado.getString("id_cliente") + ";" + resultado.getString("fecha") + ";" + resultado.getString("descripcion") + ";" + resultado.getString("cantidad_producto") + ";" + resultado.getString("precio_unitario"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }
    
    public ArrayList<String> consultarFactura() {
        ArrayList<String> datos = new ArrayList<String>();
        ConectarBase con = new ConectarBase();
        String sql;
        try {
            con.conectarDB();

            sql = "SELECT * FROM factura";
            PreparedStatement ps = con.conexion.prepareStatement(sql);

            ResultSet resultado = ps.executeQuery();
            while (resultado.next()) {
                datos.add(resultado.getString("id_factura") + ";" + resultado.getString("id_cliente") + ";" + resultado.getString("fecha") + ";" + resultado.getString("precio_total"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
        }
        return datos;
    }

    public void generarDetalle(ArrayList<String> datos) throws FileNotFoundException, DocumentException {
        try {
            String rutaPrincipal = "";
            String mensaje = "";
            String columnaID = "";
            String columnaFecha = "";
            String columnaDescripcion = "";
            String columnaCantidad = "";
            String columnaTotal = "";

            PdfPTable tabla = new PdfPTable(3);
            
            tabla.addCell("Descripcion");
            tabla.addCell("Cantidad");
            tabla.addCell("Total");
            String[] items = null;
            for (int i = 0; i < datos.size(); i++) {
                items = datos.get(i).split(";");
                columnaID = items[0];
                columnaFecha = items[1];
                columnaDescripcion = items[2];
                columnaCantidad = items[3];
                columnaTotal = items[4];
                
                
                tabla.addCell(columnaDescripcion);
                tabla.addCell(columnaCantidad);
                tabla.addCell(columnaTotal);
            }
            mensaje = columnaID + "_" + columnaFecha;
            rutaPrincipal = validarRutas(columnaFecha);
            
            FileOutputStream archivo = new FileOutputStream(rutaPrincipal+ "\\" +mensaje + " .pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            
            Paragraph parrafo = new Paragraph("Empresa EGPH\n\n");//se puede cambiar el mensaje, creo que es el titulo
            parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
            parrafo.add("Detalle de la  Factura con fecha " + columnaFecha);
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);//se alinea
            
            
            documento.open();
            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.close();
            
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, fnfe);
        }
    }
    
    public void generarFactuar(ArrayList<String> datos) throws FileNotFoundException, DocumentException {
        try {
            String rutaPricipal = System.getProperty("user.home") + "\\Desktop\\ReportePrograma\\TotalVentas";
            String columnaID = "";
            String columnaFecha = "";
            String columnaTotal = "";
            double total = 0;

            PdfPTable tabla = new PdfPTable(3);
            
            tabla.addCell("Id Cliente");
            tabla.addCell("Fecha");
            tabla.addCell("Total");
            String[] items = null;
            for (int i = 0; i < datos.size(); i++) {
                items = datos.get(i).split(";");
                columnaID = items[1];
                columnaFecha = items[2];
                columnaTotal = items[3];
                total += Double.parseDouble(columnaTotal);
                
                tabla.addCell(columnaID);
                tabla.addCell(columnaFecha);
                tabla.addCell(columnaTotal);
            }
            tabla.addCell("");
            tabla.addCell("");
            tabla.addCell(String.valueOf(total));
            
            
            FileOutputStream archivo = new FileOutputStream(rutaPricipal+ " .pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            
            Paragraph parrafo = new Paragraph("Empresa EGPH\n\n");//se puede cambiar el mensaje, creo que es el titulo
            parrafo.setAlignment(Paragraph.ALIGN_RIGHT);
            parrafo.add("Total de Ventas");
            parrafo.setAlignment(Paragraph.ALIGN_CENTER);//se alinea
            
            
            documento.open();
            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);
            documento.add(tabla);
            documento.close();
            
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, fnfe);
        }
    }
    
    public String validarRutas(String fecha) {
        String rutaPadre = "";
        try {
            rutaPadre =  System.getProperty("user.home");
            rutaPadre = rutaPadre + "\\Desktop\\ReportePrograma";
            File archivoReporte = new File(rutaPadre);
            
            rutaPadre = rutaPadre + "\\DetallesFactura";
            File detalleFactura = new File(rutaPadre);
            
            rutaPadre = rutaPadre + "\\" + fecha;
            File archivosFechas = new File(rutaPadre);
            
            
            if(!archivoReporte.exists()) {
                archivoReporte.mkdirs();
            }
            
            if(!detalleFactura.exists()) {
                detalleFactura.mkdirs();
            }
            
            if(!archivosFechas.exists()) {
                archivosFechas.mkdirs();
            }
            
        } catch(Exception ex) {}
        
        return rutaPadre;
    }

    public void abrirCarpeta() {
        String rutaPadre = "";
        rutaPadre = System.getProperty("user.home");
        rutaPadre += "\\Desktop\\ReportePrograma";

        File archivoPadre = new File(rutaPadre);
        
        if(!archivoPadre.exists()) {
            JOptionPane.showMessageDialog(null, "Aun no se ha generado ningun reporte.", "Informacion de Reportes", JOptionPane.INFORMATION_MESSAGE);
        }else {
            try {
                Desktop.getDesktop().open(archivoPadre);
            } catch (IOException ex) {
                Logger.getLogger(Reporte.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
