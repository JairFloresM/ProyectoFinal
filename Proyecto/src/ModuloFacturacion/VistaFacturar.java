package ModuloFacturacion;

import ModuloFacturacion.Factura;
import Main.VistaMenu;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class VistaFacturar extends javax.swing.JFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    private Factura factura = new Factura();
    private ArrayList<String> datosTotales = new ArrayList<String>();
    private ArrayList<String> cantidadActual = new ArrayList<String>();

    public VistaFacturar() {
        initComponents();

        setResizable(false);
        setSize(750, 480);
        this.setLocationRelativeTo(null);

        modeloTabla.addColumn("Id Producto");
        modeloTabla.addColumn("Descripcion");
        modeloTabla.addColumn("Cantidad");
        modeloTabla.addColumn("Precio Unitario");
        modeloTabla.addColumn("Precio Total");

        tbl_detFact.setModel(modeloTabla);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_cliente = new javax.swing.JTextField();
        txt_cant = new javax.swing.JTextField();
        txt_prod = new javax.swing.JTextField();
        btn_agregar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_detFact = new javax.swing.JTable();
        btn_facturar = new javax.swing.JButton();
        btn_limpiar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(0, 102, 102));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("id Cliente");

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("id Producto");

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Cantidad");

        txt_cliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_clienteActionPerformed(evt);
            }
        });

        txt_cant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cantActionPerformed(evt);
            }
        });

        txt_prod.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_prodActionPerformed(evt);
            }
        });

        btn_agregar.setText("Agregar");
        btn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_agregarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jonathan - David\\Desktop\\ProyectoFinal\\Proyecto\\src\\Iconos\\icons8-factura-128.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addComponent(btn_agregar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(5, 5, 5)
                                .addComponent(txt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(20, 20, 20)
                                .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(46, 46, 46))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(txt_cliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txt_prod, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(txt_cant, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(btn_agregar))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 18)); // NOI18N
        jLabel4.setText("FACTURACIÓN DE PRODUCTO DE CLIENTES");

        tbl_detFact.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tbl_detFact);

        btn_facturar.setText("Facturar");
        btn_facturar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_facturarActionPerformed(evt);
            }
        });

        btn_limpiar.setText("Limpiar");
        btn_limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_limpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(btn_facturar)
                        .addGap(60, 60, 60)
                        .addComponent(btn_limpiar))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 408, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(49, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_facturar)
                    .addComponent(btn_limpiar))
                .addContainerGap(131, Short.MAX_VALUE))
        );

        jMenu1.setText("Menu Principal");

        jMenuItem2.setText("Regresar");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        jMenuItem1.setText("Facturas Totales");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txt_clienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_clienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_clienteActionPerformed

    private void txt_cantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cantActionPerformed

    private void txt_prodActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_prodActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_prodActionPerformed

    private void btn_facturarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_facturarActionPerformed
        int id = 0;
        String[] items = null;

        

        if (datosTotales.size() != 0) {
            id = factura.facturarProductos(datosTotales, Integer.parseInt(txt_cliente.getText()));
            if (id != 0) {
                factura.generarDetalleFactura(id, datosTotales);
                System.out.println(cantidadActual.size());
                try {
                    for (int i = 0; i < cantidadActual.size(); i++) {
                        items = datosTotales.get(i).split(";");
                        factura.actualizarCantidades(Integer.parseInt(items[items.length - 1]), Integer.parseInt(items[0]));
                    }
                } catch (IndexOutOfBoundsException IO) {}

                limpiarBotones();
                limpiarTabla();
                txt_cliente.setText("");
                datosTotales.clear();
                cantidadActual.clear();
                JOptionPane.showMessageDialog(null, "Cliente Facturado con exito", "Succes", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Ha ocurrido algun error en la factura", "Error", JOptionPane.ERROR_MESSAGE);
            }
            txt_cliente.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "No se ha detallado ningunna factura, Por favor llene la Tabla", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_facturarActionPerformed

    private void btn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_agregarActionPerformed
        ArrayList<String> datoProd = new ArrayList<String>();

        int cantA = 0;
        String[] cantProd = null;

        try {
            int idCliente = Integer.parseInt(txt_cliente.getText());

            try {
                int idProducto = Integer.parseInt(txt_prod.getText());

                try {
                    int cantidad = Integer.parseInt(txt_cant.getText());

                    if (factura.validarCliente(idCliente)) {
                        datoProd = factura.consultarProducto(idProducto);

                        if (datoProd.size() != 0) {
                            datoProd = factura.validarCantidad(datoProd, cantidad, cantidadActual);
                            menorCantidad(datoProd);
                            if (cantidadActual.size() == 0) {
                                cantidadActual.add(datoProd.get(0));
                            }

                            if (datoProd.size() != 0) {
                                datosTotales.add(datoProd.get(0));

                                llenarTabla(datoProd);
                                limpiarBotones();
                                datoProd.clear();
                                txt_cliente.setEnabled(false);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "El id ingresado en el Producto no existe, ingreselo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El id ingresado en el Cliente no existe, ingreselo nuevamente", "Error", JOptionPane.ERROR_MESSAGE);
                    }

                } catch (NumberFormatException nfe3) {
                    JOptionPane.showMessageDialog(null, "Ingrese la cantidad de Productos", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } catch (NumberFormatException nfe2) {
                JOptionPane.showMessageDialog(null, "Ingrese el id del Producto", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (NumberFormatException nfe1) {
            JOptionPane.showMessageDialog(null, "Ingrese el id del cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_agregarActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VistaMenu menu = new VistaMenu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VistaFactura vFactura = new VistaFactura();
        vFactura.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void btn_limpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_limpiarActionPerformed
        limpiarBotones();
        txt_cliente.setText("");
        txt_cliente.setEnabled(true);
        limpiarTabla();
    }//GEN-LAST:event_btn_limpiarActionPerformed

    public void llenarTabla(ArrayList<String> datos) {
        String[] filasDatos = null;
        for (int i = 0; i < datos.size(); i++) {
            filasDatos = datos.get(i).split(";");
            modeloTabla.addRow(new Object[]{filasDatos[0], filasDatos[1], filasDatos[2], filasDatos[3], filasDatos[4]});
        }
    }

    public void limpiarTabla() {
        for (int i = 0; i < tbl_detFact.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i -= 1;
        }
    }

    public void limpiarBotones() {
        txt_prod.setText("");
        txt_cant.setText("");
    }

    public void menorCantidad(ArrayList<String> prods) {
        String[] items1 = null;
        String[] items2 = null;

        try {
            items1 = prods.get(0).split(";");

            for (int i = 0; i < cantidadActual.size(); i++) {
                items2 = cantidadActual.get(i).split(";");
                if (items2[0].equals(items1[0])) {
                    cantidadActual.set(i, prods.get(0));
                } else {
                    cantidadActual.add(prods.get(0));

                }
            }
        } catch (IndexOutOfBoundsException ioobe) {

        }

    }

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VistaFacturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaFacturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaFacturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaFacturar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaFacturar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_agregar;
    private javax.swing.JButton btn_facturar;
    private javax.swing.JButton btn_limpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_detFact;
    private javax.swing.JTextField txt_cant;
    private javax.swing.JTextField txt_cliente;
    private javax.swing.JTextField txt_prod;
    // End of variables declaration//GEN-END:variables
}
