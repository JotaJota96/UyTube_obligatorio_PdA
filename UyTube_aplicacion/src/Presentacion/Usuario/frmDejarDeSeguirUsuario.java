package Presentacion.Usuario;

import Logica.DataType.DtUsuario;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmDejarDeSeguirUsuario extends javax.swing.JDialog {

    private IAdmin Sys;

    public frmDejarDeSeguirUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.setLocationRelativeTo(null);

            Fabrica f = Fabrica.getInstancia();
            Sys = f.getIAdmin();

            Sys.liberarMemoriaUsuarioActual();
            Sys.liberarMemoriaUsuario();

            ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();

            DefaultListModel modelo = new DefaultListModel();

            for (DtUsuario it : ListaUsuarios) {
                modelo.addElement(it.getNickname());

            }
            lstSeguidor.setModel(modelo);

            btnDejarDeSeguir.setEnabled(false);
            lstSeguido.setEnabled(false);
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
        lstSeguido = new javax.swing.JList<>();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnSalir = new javax.swing.JButton();
        btnDejarDeSeguir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Dejar de seguir usuario");

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstSeguidor.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSeguidorValueChanged(evt);
            }
        });
        jScrollPane11.setViewportView(lstSeguidor);

        jPanel12.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 330, 290));

        lstSeguido.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstSeguidoValueChanged(evt);
            }
        });
        jScrollPane12.setViewportView(lstSeguido);

        jPanel12.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 320, 290));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Usuarios:");
        jPanel12.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("Seguidos:");
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel12.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 120, 40));

        btnDejarDeSeguir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDejarDeSeguir.setText("Dejar de Seguir");
        btnDejarDeSeguir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDejarDeSeguirActionPerformed(evt);
            }
        });
        jPanel12.add(btnDejarDeSeguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, 200, 40));

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

    private void btnDejarDeSeguirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDejarDeSeguirActionPerformed

        try {
            Sys.seguirUsuario();//DEJA de SEGUIR
            Sys.seleccionarUsuario(lstSeguidor.getSelectedValue());
            mostrarSeguidos(Sys.listarUsuarioSeguidos());
            Sys.seleccionarUsuarioActual(lstSeguidor.getSelectedValue());
            Sys.liberarMemoriaUsuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnDejarDeSeguirActionPerformed
    private void mostrarSeguidos(ArrayList<DtUsuario> Seguidos) {
        try {
            Seguidos = Sys.listarUsuarioSeguidos();
            DefaultListModel modelo = new DefaultListModel();
            for (DtUsuario it : Seguidos) {
                modelo.addElement(it.getNickname());
            }
            lstSeguido.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void lstSeguidorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSeguidorValueChanged
        // SegidoRRR 
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstSeguidor.getSelectedIndex() < 0) {
            return;
        }
        btnDejarDeSeguir.setEnabled(false);

        String Nickname = lstSeguidor.getSelectedValue();

        try {
            DtUsuario user = Sys.seleccionarUsuario(Nickname);
            lstSeguido.setEnabled(true);
            lstSeguido.clearSelection();

            mostrarSeguidos(Sys.listarUsuarioSeguidos());

            Sys.liberarMemoriaUsuario();

            Sys.seleccionarUsuarioActual(Nickname);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstSeguidorValueChanged

    private void lstSeguidoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstSeguidoValueChanged
        // Segidoooo
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstSeguido.getSelectedIndex() < 0) {
            return;
        }

        String SegidOOO = lstSeguido.getSelectedValue();
        //lstVideos.setEnabled(true);

        try {
            DtUsuario user = Sys.seleccionarUsuario(SegidOOO);
            btnDejarDeSeguir.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstSeguidoValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDejarDeSeguir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JList<String> lstSeguido;
    private javax.swing.JList<String> lstSeguidor;
    // End of variables declaration//GEN-END:variables
}
