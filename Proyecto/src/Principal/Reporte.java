package Principal;

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

    public void generar(ArrayList<String> datos) throws FileNotFoundException, DocumentException {
        try {
            String mensaje = "";
            String columnaID = "";
            String columnaFecha = "";
            String columnaDescripcion = "";
            String columnaCantidad = "";
            String columnaTotal = "";

            PdfPTable tabla = new PdfPTable(5);
            tabla.addCell("Id del cliente");
            tabla.addCell("Fecha");
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

                tabla.addCell(columnaID);
                tabla.addCell(columnaFecha);
                tabla.addCell(columnaDescripcion);
                tabla.addCell(columnaCantidad);
                tabla.addCell(columnaTotal);
            }
            mensaje = columnaID + "_" + columnaFecha;
            FileOutputStream archivo = new FileOutputStream(mensaje + " .pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            Paragraph parrafo = new Paragraph("Detalle de la  Factura del dia" + "");//se puede cambiar el mensaje, creo que es el titulo
            parrafo.setAlignment(1);//se alinea
            documento.add(parrafo);

            documento.add(Chunk.NEWLINE);

            documento.add(tabla);
            documento.close();
        } catch (FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, fnfe);
        }

    }

    public void abrir() {
        String mensaje = "Archivo_generado";
        File path = new File(mensaje + " .pdf");
        try {
            Desktop.getDesktop().open(path);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, ex, "Atencion", 2);
        }
    }

}
