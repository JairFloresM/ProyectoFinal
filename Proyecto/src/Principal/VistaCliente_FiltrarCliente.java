
package Principal;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class VistaCliente_FiltrarCliente extends javax.swing.JFrame {

    DefaultTableModel modeloTabla = new DefaultTableModel();
    Cliente cliente = new Cliente();
    
    public VistaCliente_FiltrarCliente() {
        super("Filtrado de Clientes");
        initComponents();
        
        setResizable(false);
        setSize(750, 480);
        this.setLocationRelativeTo(null);
        
        modeloTabla.addColumn("Id");
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirección");
        modeloTabla.addColumn("Teléfono");
        modeloTabla.addColumn("Fecha");
        tbl_clientes.setModel(modeloTabla);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grupoConsultas = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        opt_id = new javax.swing.JRadioButton();
        opt_fecha = new javax.swing.JRadioButton();
        opt_nombre = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        btn_consultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_clientes = new javax.swing.JTable();
        txt_entrada = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        imn_mostrar = new javax.swing.JMenuItem();
        imn_agregar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.LOWERED, java.awt.Color.gray, java.awt.Color.gray, java.awt.Color.white, java.awt.Color.white));

        grupoConsultas.add(opt_id);
        opt_id.setText("id");

        grupoConsultas.add(opt_fecha);
        opt_fecha.setText("fecha");

        grupoConsultas.add(opt_nombre);
        opt_nombre.setText("nombre");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opt_nombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opt_fecha)
                    .addComponent(opt_id, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(38, 38, 38))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(opt_id)
                .addGap(26, 26, 26)
                .addComponent(opt_nombre)
                .addGap(26, 26, 26)
                .addComponent(opt_fecha)
                .addGap(56, 56, 56))
        );

        jLabel1.setText("Datos a Buscar");

        btn_consultar.setText("Consultar");
        btn_consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_consultarActionPerformed(evt);
            }
        });

        tbl_clientes.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tbl_clientes);

        txt_entrada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_entradaActionPerformed(evt);
            }
        });

        jLabel2.setText("Opciones de Filtrado");

        jMenu3.setText("Menu Pricipal");

        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Clientes");

        imn_mostrar.setText("Mostrar Clientes");
        imn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imn_mostrarActionPerformed(evt);
            }
        });
        jMenu4.add(imn_mostrar);

        imn_agregar.setText("Editar Clientes");
        imn_agregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imn_agregarActionPerformed(evt);
            }
        });
        jMenu4.add(imn_agregar);

        jMenuItem2.setText("Agregar Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem2);

        jMenuItem3.setText("Eliminar Clientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem3);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(btn_consultar)
                                    .addGap(75, 75, 75))
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 453, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_entrada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)))
                .addComponent(btn_consultar)
                .addGap(16, 16, 16))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_consultarActionPerformed
        
        ArrayList<String> datos = new ArrayList<String>();
        String validarNombre = "^(([^\\s.,:;]+)\\s?)+$";
        String validarFecha = "^(19[0-9]{2}|2[0-9]{3})-(0[1-9]|1[012])-([123]0|[012][1-9]|31)$";

        limpiarTabla();
        
        if (opt_id.isSelected() || opt_nombre.isSelected() || opt_fecha.isSelected()) {
            if (opt_id.isSelected()) {
                try {
                    int val = Integer.parseInt(txt_entrada.getText());
                    datos = cliente.filtarDatosInt(val);
                } catch (NumberFormatException nfe) {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es un numero.", "Validar Entrada de Datos", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (opt_nombre.isSelected()) {
                if (Pattern.matches(validarNombre, txt_entrada.getText())) {
                    datos = cliente.filtarDatosString(txt_entrada.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es un nombre.", "Validar Entrada de Datos", JOptionPane.ERROR_MESSAGE);
                }
            }

            if (opt_fecha.isSelected()) {
                if (Pattern.matches(validarFecha, txt_entrada.getText())) {
                    datos = cliente.filtarDatosString(txt_entrada.getText());
                } else {
                    JOptionPane.showMessageDialog(null, "El valor ingresado no es una fecha.", "Validar Entrada de Datos", JOptionPane.ERROR_MESSAGE);
                }
            }
            
            if(datos.size() != 0) {
                llenarTabla(datos);
                datos.clear();
            }
            
        } else {
            JOptionPane.showMessageDialog(null, "No se ha elegido ningun tipo de filtro, por favor elija uno.", "Validar Entrada de Datos", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_btn_consultarActionPerformed

    public void llenarTabla(ArrayList<String> datos) {
        String[] filasDatos = null;
        for (int i = 0; i < datos.size(); i++) {
            filasDatos = datos.get(i).split(";");
            modeloTabla.addRow(new Object[]{filasDatos[0], filasDatos[1], filasDatos[2], filasDatos[3], filasDatos[4]});
        }
    }
    
    public void limpiarTabla() {
        for (int i = 0; i < tbl_clientes.getRowCount(); i++) {
            modeloTabla.removeRow(i);
            i -= 1;
        }
    }
    
    
    private void txt_entradaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_entradaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_entradaActionPerformed

    private void imn_agregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imn_agregarActionPerformed
        VistaCliente_EditarCliente agregar = new VistaCliente_EditarCliente();
        agregar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_imn_agregarActionPerformed

    private void imn_mostrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imn_mostrarActionPerformed
        VistaCliente mostrar = new VistaCliente();
        mostrar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_imn_mostrarActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        VistaMenu menu = new VistaMenu();
        menu.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        VistaCliente_Agregar agregar = new VistaCliente_Agregar();
        agregar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        VistaCliente_Eliminar eliminar = new VistaCliente_Eliminar();
        eliminar.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    
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
            java.util.logging.Logger.getLogger(VistaCliente_FiltrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCliente_FiltrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCliente_FiltrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCliente_FiltrarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCliente_FiltrarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_consultar;
    private javax.swing.ButtonGroup grupoConsultas;
    private javax.swing.JMenuItem imn_agregar;
    private javax.swing.JMenuItem imn_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton opt_fecha;
    private javax.swing.JRadioButton opt_id;
    private javax.swing.JRadioButton opt_nombre;
    private javax.swing.JTable tbl_clientes;
    private javax.swing.JTextField txt_entrada;
    // End of variables declaration//GEN-END:variables
}
