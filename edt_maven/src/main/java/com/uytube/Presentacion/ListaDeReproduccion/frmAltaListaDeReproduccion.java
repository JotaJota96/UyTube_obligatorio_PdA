package com.uytube.Presentacion.ListaDeReproduccion;

import com.uytube.Logica.DataType.*;
import com.uytube.Logica.Enumerados.Privacidad;
import com.uytube.Logica.Enumerados.TipoListaDeReproduccion;
import com.uytube.Logica.Fabrica;
import com.uytube.Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmAltaListaDeReproduccion extends javax.swing.JDialog {

    Fabrica f = Fabrica.getInstancia();
    IAdmin Sys = f.getIAdmin();

    public frmAltaListaDeReproduccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);

        try {
            initComponents();
            this.setLocationRelativeTo(null);
            ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();
            DefaultListModel modeloUsuario = new DefaultListModel();
            for (DtUsuario it : ListaUsuarios) {
                modeloUsuario.addElement(it.getNickname());
            }
            lstUsuarios.setModel(modeloUsuario);
            ArrayList<String> ListaCategoria = Sys.listarCategorias();
            DefaultListModel modeloCategoria = new DefaultListModel();
            for (String it : ListaCategoria) {
                modeloCategoria.addElement(it);
            }
            lstCategorias.setModel(modeloCategoria);
            lstCategorias.setSelectedValue("UNDEFINED", true);
            rbParticular.setSelected(true);
            rbPublica.setSelected(true);

            btnAceptar.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoTipo = new javax.swing.ButtonGroup();
        GrupoPublicoPrivado = new javax.swing.ButtonGroup();
        jPanel17 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        rbPublica = new javax.swing.JRadioButton();
        rbPrivada = new javax.swing.JRadioButton();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlTipo = new javax.swing.JPanel();
        rbPorDefecto = new javax.swing.JRadioButton();
        rbParticular = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva lista de reproduccion");
        setResizable(false);

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setText("Nombre:");
        jPanel17.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
        });
        jPanel17.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 310, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setText("Usuarios:");
        jPanel18.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jScrollPane31.setViewportView(lstCategorias);

        jPanel18.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 340, 180));

        GrupoPublicoPrivado.add(rbPublica);
        rbPublica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPublica.setText("Pública");
        rbPublica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPublicaActionPerformed(evt);
            }
        });
        jPanel18.add(rbPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        GrupoPublicoPrivado.add(rbPrivada);
        rbPrivada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPrivada.setText("Privada");
        jPanel18.add(rbPrivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel102.setText("Categoría:");
        jPanel18.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        lstUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosValueChanged(evt);
            }
        });
        jScrollPane32.setViewportView(lstUsuarios);

        jPanel18.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 320, 180));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 750, 270));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel17.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 370, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel17.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 50));

        pnlTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        pnlTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlTipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GrupoTipo.add(rbPorDefecto);
        rbPorDefecto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPorDefecto.setText("Por defecto");
        rbPorDefecto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rbPorDefectoItemStateChanged(evt);
            }
        });
        pnlTipo.add(rbPorDefecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        GrupoTipo.add(rbParticular);
        rbParticular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbParticular.setText("Particular");
        pnlTipo.add(rbParticular, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel17.add(pnlTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 10, 330, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        try {
            Sys.liberarMemoriaUsuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked

    private void rbPorDefectoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rbPorDefectoItemStateChanged
        if (rbPorDefecto.isSelected() == true) {
            txtNombre.setText("");
            rbPublica.setEnabled(false);
            rbPrivada.setSelected(true);
            lstUsuarios.setEnabled(false);
            lstCategorias.setEnabled(false);
            lstCategorias.setSelectedValue("UNDEFINED", true);
            lstUsuarios.clearSelection();
            btnAceptar.setEnabled(false);
        } else {
            txtNombre.setText("");
            rbPublica.setEnabled(true);
            lstUsuarios.setEnabled(true);
            lstCategorias.setEnabled(true);
            lstCategorias.clearSelection();
            lstUsuarios.clearSelection();
            lstCategorias.setSelectedValue("UNDEFINED", true);
            btnAceptar.setEnabled(false);
        }
    }//GEN-LAST:event_rbPorDefectoItemStateChanged

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        // mientras se escrbe el nombre de la lista
        habilitarDeshabilitarBotonAceptar();
    }//GEN-LAST:event_txtNombreKeyReleased

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        DtListaDeReproduccion lst = null;
        Privacidad Priv = null;

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de la lista de reproduccion no puede ser vacio", "Avertencia:", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (rbPrivada.isSelected() == true) {
            Priv = Privacidad.PRIVADO;
        }
        if (rbPublica.isSelected() == true) {
            Priv = Privacidad.PUBLICO;
        }

        try {

            if (rbParticular.isSelected() == true) {

                if (lstUsuarios.getSelectedValue().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario para continuar", "Avertencia:", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                Sys.seleccionarUsuario(lstUsuarios.getSelectedValue());
                
                if (Sys.obtenerCanalDeUsuario().getPrivacidad() == Privacidad.PRIVADO && rbPublica.isSelected() == true) {
                    JOptionPane.showMessageDialog(null, "Un canal privado no puede tener una lista de reproducion publica", "Avertencia:", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                lst = new DtListaDeReproduccion(0, txtNombre.getText(), Priv, TipoListaDeReproduccion.PARTICULAR, lstCategorias.getSelectedValue());
                

                if (!Sys.validarNuevaListaParticular(lst.getNombre())) {
                    JOptionPane.showMessageDialog(null, "El usuario ya posee una lista de reproduccion con ese nombre", "Avertencia:", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Sys.altaListaDeReproduccionParticular(lst);
                JOptionPane.showMessageDialog(null, "Lista particular creada", "Informacion:", JOptionPane.INFORMATION_MESSAGE);
            }

            if (rbPorDefecto.isSelected() == true) {

                lst = new DtListaDeReproduccion(0, txtNombre.getText(), Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED");

                if (!Sys.validarNuevaListaPorDefecto(lst.getNombre())) {
                    JOptionPane.showMessageDialog(null, "El nombre para la lista de reproduccion ya esta usado", "Avertencia:", JOptionPane.WARNING_MESSAGE);
                    return;
                }

                Sys.altaListaDeReproduccionPorDefecto(lst);
                JOptionPane.showMessageDialog(null, "Lista por defecto creada", "Informacion:", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        try {
            Sys.liberarMemoriaUsuario();
            txtNombre.setText("");
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosValueChanged
        // al seleccionar un usuario
        habilitarDeshabilitarBotonAceptar();
    }//GEN-LAST:event_lstUsuariosValueChanged

    private void rbPublicaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPublicaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPublicaActionPerformed

    private void habilitarDeshabilitarBotonAceptar(){
        // si se selecciono para crear lista particular
        if (rbParticular.isSelected()) {
            if (lstUsuarios.getSelectedIndex() < 0 || lstCategorias.getSelectedIndex() < 0 || txtNombre.getText().isEmpty()) {
                btnAceptar.setEnabled(false);
                return;
            }
            btnAceptar.setEnabled(true);
        } else { // si se selecciono para crear lista particular
            if (txtNombre.getText().isEmpty()) {
                btnAceptar.setEnabled(false);
                return;
            }
            btnAceptar.setEnabled(true);
        }
    }
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoPublicoPrivado;
    private javax.swing.ButtonGroup GrupoTipo;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JPanel pnlTipo;
    public static javax.swing.JRadioButton rbParticular;
    public static javax.swing.JRadioButton rbPorDefecto;
    public static javax.swing.JRadioButton rbPrivada;
    protected static javax.swing.JRadioButton rbPublica;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
