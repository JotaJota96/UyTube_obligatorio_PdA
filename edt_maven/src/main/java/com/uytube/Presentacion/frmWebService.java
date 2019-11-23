/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.uytube.Presentacion;
import java.util.ArrayList;
import com.uytube.Logica.DataType.DtUsuario;
import com.uytube.Logica.Fabrica;
import com.uytube.Logica.Interfaces.IAdmin;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmWebService extends javax.swing.JDialog {
    
    Fabrica f;
    public frmWebService(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        f = Fabrica.getInstancia();
        actualizarInformacion();
    }

    
    private void actualizarInformacion(){
        String textoBoton, textoInfo;
        if (f.WebServiceIsON()){
            textoInfo = "El Web Service se encuentra en ejecución";
            textoBoton = "Detener";
        }else{
            textoInfo = "El Web Service se encuentra detenido";
            textoBoton = "Iniciar";
        }
        btnAccion.setEnabled(true);
        btnAccion.setText(textoBoton);
        lbInfo.setText(textoInfo);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlFondo = new javax.swing.JPanel();
        lbInfo = new javax.swing.JLabel();
        btnCerrar = new javax.swing.JButton();
        btnAccion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Web Service");
        setResizable(false);

        pnlFondo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbInfo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbInfo.setText("Informacion sobre el estado del WebService");
        pnlFondo.add(lbInfo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        btnCerrar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnCerrar.setText("Cerrar");
        btnCerrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCerrarMouseClicked(evt);
            }
        });
        pnlFondo.add(btnCerrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 150, 300, 80));

        btnAccion.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAccion.setText("texto cambiante");
        btnAccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAccionActionPerformed(evt);
            }
        });
        pnlFondo.add(btnAccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 300, 80));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlFondo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCerrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCerrarMouseClicked
       dispose();
    }//GEN-LAST:event_btnCerrarMouseClicked

    private void btnAccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAccionActionPerformed
        // Boton Iniciar / Detener
        btnAccion.setEnabled(false);
        try {
            if (f.WebServiceIsON()) {
                // al detener
                btnAccion.setText("Deteniendo...");
                lbInfo.setText("Deteniendo el Web Service, por favor espere");
                f.desPublicarWebService();
                JOptionPane.showMessageDialog(
                        null,
                        "Se ha detenido el Web Service",
                        "Web Service detenido",
                        JOptionPane.INFORMATION_MESSAGE
                );
            } else {
                // al iniciar
                btnAccion.setText("iniciando...");
                lbInfo.setText("Iniciando el Web Service, por favor espere");
                String url = f.publicarWebService();
                JOptionPane.showMessageDialog(
                        null,
                        "Se ha publicado el Web Service en la ruta:\n" + url,
                        "Web Service publicado",
                        JOptionPane.INFORMATION_MESSAGE
                );
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    null, 
                    "Ha ocurrido un error\n" + e.getMessage(), 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE
            );
        }
        actualizarInformacion();
    }//GEN-LAST:event_btnAccionActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAccion;
    private javax.swing.JButton btnCerrar;
    private javax.swing.JLabel lbInfo;
    private javax.swing.JPanel pnlFondo;
    // End of variables declaration//GEN-END:variables
}
