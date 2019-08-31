/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion.Usuario;
import java.util.ArrayList;
import Logica.DataType.DtUsuario;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import javax.swing.DefaultListModel;

public class frmListarUsuarios extends javax.swing.JDialog {
    public frmListarUsuarios(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        Fabrica f = Fabrica.getInstancia();
        IAdmin Sys = f.getIAdmin();
        
        ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();
                
        
        DefaultListModel modelo = new DefaultListModel();
        
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstListaDeUsuario.setModel(modelo);
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbListarUasario = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        lstListaDeUsuario = new javax.swing.JList<>();
        jLabel60 = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Listar usuarios");

        lbListarUasario.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane10.setViewportView(lstListaDeUsuario);

        lbListarUasario.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 250));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Usuarios:");
        lbListarUasario.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        lbListarUasario.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 140, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbListarUasario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbListarUasario, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JPanel lbListarUasario;
    private javax.swing.JList<String> lstListaDeUsuario;
    // End of variables declaration//GEN-END:variables
}
