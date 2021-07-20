
package ModuloCliente;

import ModuloCliente.VistaCliente_Agregar;
import ModuloCliente.VistaCliente;
import ModuloCliente.VistaCliente_Eliminar;
import ModuloCliente.VistaCliente_FiltrarCliente;
import Main.VistaMenu;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class VistaCliente_EditarCliente extends javax.swing.JFrame {

    private ArrayList<String> datos = new ArrayList<String>();
    private int id;
    Cliente cliente = new Cliente();
    
    public VistaCliente_EditarCliente() {
        super("Editar Clientes");
        initComponents();
        
        setResizable(false);
        setSize(750, 480);
        this.setLocationRelativeTo(null);
        
        this.bloquearCampos();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        txt_nom = new javax.swing.JTextField();
        txt_dir = new javax.swing.JTextField();
        txt_tel = new javax.swing.JTextField();
        txt_fec = new javax.swing.JTextField();
        btn_buscar = new javax.swing.JButton();
        btn_actualizar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        imn_mostrar = new javax.swing.JMenuItem();
        imn_filtrar = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel7.setText("id_cliente");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 80, -1));

        jLabel2.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel2.setText("Nombre");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 90, 60, -1));

        jLabel3.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel3.setText("Dirección");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, 70, -1));

        jLabel4.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel4.setText("Telefono");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 190, 60, -1));

        jLabel5.setFont(new java.awt.Font("Gill Sans MT", 1, 14)); // NOI18N
        jLabel5.setText("Fecha de Nacimiento");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 240, 140, -1));
        jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 60, 209, -1));
        jPanel1.add(txt_nom, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 110, 209, -1));
        jPanel1.add(txt_dir, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 160, 209, -1));
        jPanel1.add(txt_tel, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 210, 209, -1));
        jPanel1.add(txt_fec, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 260, 209, -1));

        btn_buscar.setText("Buscar");
        btn_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_buscarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, 84, 20));

        btn_actualizar.setText("Actualizar");
        btn_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_actualizarActionPerformed(evt);
            }
        });
        jPanel1.add(btn_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, 20));

        jLabel1.setFont(new java.awt.Font("Gill Sans MT", 1, 24)); // NOI18N
        jLabel1.setText("EDITAR CLIENTES");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jLabel6.setIcon(new javax.swing.ImageIcon("C:\\Users\\Jonathan - David\\Desktop\\ProyectoFinal\\imagenes\\icons8-editar.gif")); // NOI18N
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 333, 780, -1));

        jPanel3.setBackground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 24, Short.MAX_VALUE)
        );

        jMenu1.setText("Menu Principal");

        jMenuItem1.setText("Regresar");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Opciones");

        imn_mostrar.setText("Mostrar Clientes");
        imn_mostrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imn_mostrarActionPerformed(evt);
            }
        });
        jMenu2.add(imn_mostrar);

        imn_filtrar.setText("Filtrar Clientes");
        imn_filtrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                imn_filtrarActionPerformed(evt);
            }
        });
        jMenu2.add(imn_filtrar);

        jMenuItem2.setText("Agregar Clientes");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuItem3.setText("Eliminar Clientes");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem3);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 739, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void imn_filtrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_imn_filtrarActionPerformed
        VistaCliente_FiltrarCliente fil = new VistaCliente_FiltrarCliente();
        fil.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_imn_filtrarActionPerformed

    
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

    private void btn_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_actualizarActionPerformed
        if(!txt_nom.getText().equals("")) {
            if(!txt_dir.getText().equals("")) {
                if(!txt_tel.getText().equals("")) {
                    if(!txt_fec.getText().equals("")) {
                        cliente.editarCliente(id, txt_nom.getText(), txt_dir.getText(), txt_tel.getText(), txt_fec.getText());
                        
                        txt_id.setEnabled(true);
                        vaciarCampos();
                        bloquearCampos();
                    } else {
                        JOptionPane.showMessageDialog(null, "El campo de la fecha esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "El campo del telefono esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }else {
                JOptionPane.showMessageDialog(null, "El campo de la direccion esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "El campo del nombre esta vacio", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_actualizarActionPerformed

    private void btn_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_buscarActionPerformed
        try {
            id = Integer.parseInt(txt_id.getText());
            datos = cliente.verificarCliente(id);
            if(datos.size() != 0) {
                
                activarCampos();
                setCampos();
                datos.clear();
            } else {
                JOptionPane.showMessageDialog(null, "No se ha encontrado el id " + id, "Error", JOptionPane.ERROR_MESSAGE);
            }
            
        } catch(NumberFormatException nfe) {
            JOptionPane.showMessageDialog(null, "El dato insertado en el campo ID no es un numero.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_buscarActionPerformed

    public void setCampos() {
        String []items = datos.get(0).split(";");
        txt_nom.setText(items[1]);
        txt_dir.setText(items[2]);
        txt_tel.setText(items[3]);
        txt_fec.setText(items[4]);
    }
    
    public void bloquearCampos() {
        txt_nom.setEnabled(false);
        txt_dir.setEnabled(false);
        txt_tel.setEnabled(false);
        txt_fec.setEnabled(false);
        txt_id.setEnabled(true);
    }
    
    public void activarCampos() {
        txt_nom.setEnabled(true);
        txt_dir.setEnabled(true);
        txt_tel.setEnabled(true);
        txt_fec.setEnabled(true);
        txt_id.setEnabled(false);
    }
    
    public void vaciarCampos() {
        txt_id.setText("");
        txt_nom.setText("");
        txt_dir.setText("");
        txt_tel.setText("");
        txt_fec.setText("");
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
            java.util.logging.Logger.getLogger(VistaCliente_EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCliente_EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCliente_EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCliente_EditarCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCliente_EditarCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_actualizar;
    private javax.swing.JButton btn_buscar;
    private javax.swing.JMenuItem imn_filtrar;
    private javax.swing.JMenuItem imn_mostrar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField txt_dir;
    private javax.swing.JTextField txt_fec;
    private javax.swing.JTextField txt_id;
    private javax.swing.JTextField txt_nom;
    private javax.swing.JTextField txt_tel;
    // End of variables declaration//GEN-END:variables
}
