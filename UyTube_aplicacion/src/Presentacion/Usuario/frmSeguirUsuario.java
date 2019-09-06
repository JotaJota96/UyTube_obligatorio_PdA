package Presentacion.Usuario;

import Logica.DataType.DtUsuario;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmSeguirUsuario extends javax.swing.JDialog {

    private IAdmin Sys;
    public ArrayList<DtUsuario> ListaTodosUsuarios;

    public frmSeguirUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.setLocationRelativeTo(null);

            Fabrica f = Fabrica.getInstancia();
            Sys = f.getIAdmin();

            Sys.liberarMemoriaUsuarioActual();
            Sys.liberarMemoriaUsuario();

            ListaTodosUsuarios = Sys.listarUsuarios();

            DefaultListModel modelo = new DefaultListModel();
            for (DtUsuario it : ListaTodosUsuarios) {
                modelo.addElement(it.getNickname());
            }
            lstSeguidor.setModel(modelo);

            btnSeguir.setEnabled(false);
            lstNoSeguido.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        lstSeguidor = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        lstNoSeguido = new javax.swing.JList<>();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnSeguir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Seguir usuario");

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstSeguidor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSeguidorValueChanged(evt);
            }
        });
        jScrollPane11.setViewportView(lstSeguidor);

        jPanel12.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 330, 290));

        lstNoSeguido.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstNoSeguidoValueChanged(evt);
            }
        });
        jScrollPane12.setViewportView(lstNoSeguido);

        jPanel12.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 320, 290));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Usuarios:");
        jPanel12.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("No Seguidos:");
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        btnSeguir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeguir.setText("Seguir");
        btnSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguirActionPerformed(evt);
            }
        });
        jPanel12.add(btnSeguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 370, 190, 40));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel12.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 370, 120, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        //salir
        try {
            Sys.liberarMemoriaUsuarioActual();
            Sys.liberarMemoriaUsuario();
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSalirActionPerformed

    private void btnSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguirActionPerformed
        // TODO add your handling code here:
        try {
            Sys.seguirUsuario();// SEGUIR
            String NickName = lstSeguidor.getSelectedValue();

            DtUsuario user = Sys.seleccionarUsuario(NickName);
            lstNoSeguido.setEnabled(true);
            lstNoSeguido.clearSelection();

            ArrayList<DtUsuario> NoSeguidos = Sys.listarUsuarioNoSeguidos();
            
            DefaultListModel modelo = new DefaultListModel();
            for (DtUsuario it : NoSeguidos) {
                modelo.addElement(it.getNickname());
            }
            lstNoSeguido.setModel(modelo);
            Sys.seleccionarUsuarioActual(NickName);
            Sys.liberarMemoriaUsuario();
            //Sys.seguirUsuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnSeguirActionPerformed

    private void lstSeguidorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSeguidorValueChanged
        // SegidoRRR
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstSeguidor.getSelectedIndex() < 0) {
            return;
        }
        btnSeguir.setEnabled(false);

        String NickName = lstSeguidor.getSelectedValue();

        try {
            DtUsuario user = Sys.seleccionarUsuario(NickName);
            lstNoSeguido.setEnabled(true);
            lstNoSeguido.clearSelection();

            ArrayList<DtUsuario> NoSeguidos = Sys.listarUsuarioNoSeguidos();
            
            DefaultListModel modelo = new DefaultListModel();
            for (DtUsuario it : NoSeguidos) {
                modelo.addElement(it.getNickname());
            }
            lstNoSeguido.setModel(modelo);
            Sys.seleccionarUsuarioActual(NickName);
            Sys.liberarMemoriaUsuario();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstSeguidorValueChanged

    private void lstNoSeguidoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstNoSeguidoValueChanged
        // Segidoooo
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstNoSeguido.getSelectedIndex() < 0) {
            return;
        }

        String Nickname = lstNoSeguido.getSelectedValue();
        //lstVideos.setEnabled(true);

        try {
            DtUsuario user = Sys.seleccionarUsuario(Nickname);
            btnSeguir.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstNoSeguidoValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeguir;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JList<String> lstNoSeguido;
    private javax.swing.JList<String> lstSeguidor;
    // End of variables declaration//GEN-END:variables
}
