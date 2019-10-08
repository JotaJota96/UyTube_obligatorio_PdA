package Presentacion.Video;

import java.util.ArrayList;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.Enumerados.TipoValoracion;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmValorarVideo extends javax.swing.JDialog {

    private IAdmin sys;
    ArrayList<DtUsuario> ListaUsuarios;
    private ArrayList<DtVideo> VideosDelUser;

    public frmValorarVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.setLocationRelativeTo(null);

            Fabrica f = Fabrica.getInstancia();
            sys = f.getIAdmin();

            ListaUsuarios = sys.listarUsuarios();
            mostrarListadoDeUsuarios(ListaUsuarios);

            mostrarValoracionEnRadioButtons();

            lstUsuarioValoradoR.setEnabled(false);
            lstVideoAValorar.setEnabled(false);
            btnValorar.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        lstUsuarioValoradoR = new javax.swing.JList<>();
        jScrollPane29 = new javax.swing.JScrollPane();
        lstVideoAValorar = new javax.swing.JList<>();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        lstUsuarioValorado = new javax.swing.JList<>();
        jLabel98 = new javax.swing.JLabel();
        rbMeGusta = new javax.swing.JRadioButton();
        rbNoMeGusta = new javax.swing.JRadioButton();
        btnValorar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        rbQuitar = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Valorar video");
        setResizable(false);

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstUsuarioValoradoR.setToolTipText("Seleccione usuario que realizara la valoracion");
        lstUsuarioValoradoR.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuarioValoradoRValueChanged(evt);
            }
        });
        jScrollPane28.setViewportView(lstUsuarioValoradoR);

        jPanel16.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 50, 200, 310));

        lstVideoAValorar.setToolTipText("Seleccione el video a valorar");
        lstVideoAValorar.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVideoAValorarValueChanged(evt);
            }
        });
        jScrollPane29.setViewportView(lstVideoAValorar);

        jPanel16.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 50, 330, 310));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel96.setText("Usuario valorador:");
        jPanel16.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 20, -1, -1));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setText("Video a valorar:");
        jPanel16.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 20, -1, -1));

        lstUsuarioValorado.setToolTipText("Seleccione el uruaio que realizara la valoracion ");
        lstUsuarioValorado.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuarioValoradoValueChanged(evt);
            }
        });
        jScrollPane30.setViewportView(lstUsuarioValorado);

        jPanel16.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 200, 310));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel98.setText("Usuario valorado:");
        jPanel16.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        buttonGroup1.add(rbMeGusta);
        rbMeGusta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMeGusta.setText("Me gusta");
        rbMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbMeGustaActionPerformed(evt);
            }
        });
        jPanel16.add(rbMeGusta, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 390, -1, -1));

        buttonGroup1.add(rbNoMeGusta);
        rbNoMeGusta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbNoMeGusta.setText("No me gusta");
        rbNoMeGusta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbNoMeGustaActionPerformed(evt);
            }
        });
        jPanel16.add(rbNoMeGusta, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        btnValorar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnValorar.setText("Valorar");
        btnValorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValorarActionPerformed(evt);
            }
        });
        jPanel16.add(btnValorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 380, 200, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.setToolTipText("Se perderan todos los Items seleccionados");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel16.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, 200, 50));

        buttonGroup1.add(rbQuitar);
        rbQuitar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbQuitar.setText("Quitar");
        rbQuitar.setEnabled(false);
        rbQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbQuitarActionPerformed(evt);
            }
        });
        jPanel16.add(rbQuitar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        //CANCELAR
        try {
            sys.liberarMemoriaVideo();
            sys.liberarMemoriaUsuarioActual();
            sys.liberarMemoriaUsuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            dispose();
        }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lstUsuarioValoradoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuarioValoradoValueChanged
        // Seleccionar usuario duenio de video
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstUsuarioValorado.getSelectedIndex() < 0) {
            return;
        }

        try {
            int indiceSeleccionado = lstUsuarioValorado.getSelectedIndex();
            String nick = ListaUsuarios.get(indiceSeleccionado).getNickname();
            sys.seleccionarUsuario(nick);
            VideosDelUser = sys.listarVideosDeUsuario();
            mostrarListadoDeVideos(VideosDelUser);
            mostrarValoracionEnRadioButtons();

            lstVideoAValorar.setEnabled(true);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_lstUsuarioValoradoValueChanged

    private void lstVideoAValorarValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVideoAValorarValueChanged
        // Al seleccionar un video
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstVideoAValorar.getSelectedIndex() < 0) {
            mostrarValoracionEnRadioButtons();
            return;
        }

        try {
            int indiceSeleccionado = lstVideoAValorar.getSelectedIndex();
            int idVideo = VideosDelUser.get(indiceSeleccionado).getId();
            sys.seleccionarVideo(idVideo);
            mostrarValoracionEnRadioButtons();

            lstUsuarioValoradoR.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstVideoAValorarValueChanged

    private void lstUsuarioValoradoRValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuarioValoradoRValueChanged
        // al seleccionar usuario que va a valorar
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstUsuarioValoradoR.getSelectedIndex() < 0) {
            return;
        }

        try {
            int indiceSeleccionado = lstUsuarioValoradoR.getSelectedIndex();
            String nick = ListaUsuarios.get(indiceSeleccionado).getNickname();
            sys.seleccionarUsuarioActual(nick);
            mostrarValoracionEnRadioButtons();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstUsuarioValoradoRValueChanged

    private void btnValorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValorarActionPerformed
        // Clic en boton Valorar
        
        // validaciones
        if (lstUsuarioValorado.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un usuario propietario del video", "¡Atención!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (lstVideoAValorar.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un video", "¡Atención!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (lstUsuarioValoradoR.getSelectedIndex() < 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar el usuario que realizará la valoración", "¡Atención!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if ( ! (rbMeGusta.isSelected() || rbNoMeGusta.isSelected() || rbQuitar.isSelected())) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar la opcion de valoración", "¡Atención!", JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        try {
            String nick;
            int indiceSeleccionado;

            indiceSeleccionado = lstUsuarioValorado.getSelectedIndex();
            nick = ListaUsuarios.get(indiceSeleccionado).getNickname();
            sys.seleccionarUsuario(nick);

            indiceSeleccionado = lstVideoAValorar.getSelectedIndex();
            int idVideo = VideosDelUser.get(indiceSeleccionado).getId();
            sys.seleccionarVideo(idVideo);

            indiceSeleccionado = lstUsuarioValoradoR.getSelectedIndex();
            nick = ListaUsuarios.get(indiceSeleccionado).getNickname();
            sys.seleccionarUsuarioActual(nick);

            if (rbMeGusta.isSelected()) {
                sys.altaValoracion(new DtValoracion(TipoValoracion.LIKE, "hola"));
            } else if (rbNoMeGusta.isSelected()) {
                sys.altaValoracion(new DtValoracion(TipoValoracion.DISLIKE, "hola"));
            } else {
                sys.altaValoracion(null);
            }

            sys.liberarMemoriaVideo();
            sys.liberarMemoriaUsuarioActual();
            sys.liberarMemoriaUsuario();
            JOptionPane.showMessageDialog(null, "Video valorado exitosamente\n", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnValorarActionPerformed

    private void rbMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbMeGustaActionPerformed
        btnValorar.setEnabled(true);
    }//GEN-LAST:event_rbMeGustaActionPerformed

    private void rbNoMeGustaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbNoMeGustaActionPerformed
        btnValorar.setEnabled(true);
    }//GEN-LAST:event_rbNoMeGustaActionPerformed

    private void rbQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbQuitarActionPerformed
        btnValorar.setEnabled(true);
    }//GEN-LAST:event_rbQuitarActionPerformed

    ////////////////////////////////////////////////////////////////////////////////////////////
    private void mostrarListadoDeUsuarios(ArrayList<DtUsuario> l) {
        DefaultListModel modelo1 = new DefaultListModel();
        DefaultListModel modelo2 = new DefaultListModel();
        for (DtUsuario it : l) {
            modelo1.addElement(it.getNickname());
            modelo2.addElement(it.getNickname());
        }
        lstUsuarioValorado.setModel(modelo1);
        lstUsuarioValoradoR.setModel(modelo2);
    }

    private void mostrarListadoDeVideos(ArrayList<DtVideo> l) {
        DefaultListModel modelo1 = new DefaultListModel();
        for (DtVideo it : l) {
            modelo1.addElement(it.getNombre());
        }
        lstVideoAValorar.setModel(modelo1);
        lstVideoAValorar.updateUI();
    }

    private void mostrarValoracionEnRadioButtons() {
        try {
            if (lstUsuarioValorado.isSelectionEmpty()
                    || lstVideoAValorar.isSelectionEmpty()
                    || lstUsuarioValoradoR.isSelectionEmpty()) {
                buttonGroup1.clearSelection();
                rbMeGusta.setEnabled(false);
                rbNoMeGusta.setEnabled(false);
                rbQuitar.setEnabled(false);
                btnValorar.setEnabled(false);
                return;
            }
            rbMeGusta.setEnabled(true);
            rbNoMeGusta.setEnabled(true);

            DtValoracion dtv = sys.obtenerValoracionDada();

            if (dtv == null) {
                buttonGroup1.clearSelection();
                btnValorar.setEnabled(false);
                rbQuitar.setEnabled(false);
                //rbMeGusta.setSelected(false);
                //rbNoMeGusta.setSelected(false);
            } else {
                if (dtv.getVal() == TipoValoracion.LIKE) {
                    rbMeGusta.setSelected(true);
                    rbNoMeGusta.setSelected(false);
                } else {
                    rbMeGusta.setSelected(false);
                    rbNoMeGusta.setSelected(true);
                }
                rbQuitar.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnValorar;
    public static javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JList<String> lstUsuarioValorado;
    private javax.swing.JList<String> lstUsuarioValoradoR;
    private javax.swing.JList<String> lstVideoAValorar;
    private javax.swing.JRadioButton rbMeGusta;
    private javax.swing.JRadioButton rbNoMeGusta;
    private javax.swing.JRadioButton rbQuitar;
    // End of variables declaration//GEN-END:variables
}
