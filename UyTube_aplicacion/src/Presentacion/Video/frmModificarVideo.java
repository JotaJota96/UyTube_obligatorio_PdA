
package Presentacion.Video;

import Logica.DataType.DtCanal;
import Logica.DataType.DtCategoria;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Presentacion.DatosDePrueba;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class frmModificarVideo extends javax.swing.JDialog {
    IAdmin sys;
    DefaultListModel s = new DefaultListModel();
    public frmModificarVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
     
        
        
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();

            // lista usuarios en el JList
            listarUsuarios(sys.listarUsuarios());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel14 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        lstDuenioVideo = new javax.swing.JList<>();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        lstVideoUsuario = new javax.swing.JList<>();
        jLabel72 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        jLabel78 = new javax.swing.JLabel();
        rbPublico = new javax.swing.JRadioButton();
        rbPrivado = new javax.swing.JRadioButton();
        spHora = new javax.swing.JSpinner();
        jLabel144 = new javax.swing.JLabel();
        spMinuto = new javax.swing.JSpinner();
        jLabel145 = new javax.swing.JLabel();
        spSegundos = new javax.swing.JSpinner();
        jLabel146 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar video");

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 390, 70));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 473, 390, 70));

        lstDuenioVideo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDuenioVideoValueChanged(evt);
            }
        });
        jScrollPane16.setViewportView(lstDuenioVideo);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, 400));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Dueño del video:");
        jPanel14.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstVideoUsuario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVideoUsuarioValueChanged(evt);
            }
        });
        jScrollPane17.setViewportView(lstVideoUsuario);

        jPanel14.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 180, 400));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setText("Video del Usuario:");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        jPanel14.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 210, -1));

        jLabel73.setText("Nombre:");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel74.setText("Duración:");
        jPanel14.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jLabel75.setText("URL:");
        jPanel14.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));
        jPanel14.add(txtURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 210, -1));

        jLabel76.setText("Descripción:");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 80, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane18.setViewportView(txtDescripcion);

        jPanel14.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 210, 120));

        jLabel77.setText("Fecha publicación:");
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setText("Asignar categoría:");
        jPanel14.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        buttonGroup1.add(rbPublico);
        rbPublico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPublico.setText("Publico");
        jPanel14.add(rbPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        buttonGroup1.add(rbPrivado);
        rbPrivado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPrivado.setText("Privado");
        rbPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPrivadoActionPerformed(evt);
            }
        });
        jPanel14.add(rbPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, -1));
        jPanel14.add(spHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 60, -1));

        jLabel144.setText("Horas");
        jPanel14.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));
        jPanel14.add(spMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 50, -1));

        jLabel145.setText("Minutos");
        jPanel14.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));
        jPanel14.add(spSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, -1));

        jLabel146.setText("Segundos");
        jPanel14.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jScrollPane19.setViewportView(lstCategorias);

        jPanel14.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 180, 400));
        jPanel14.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 330, 170, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
private void listarUsuarios(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstDuenioVideo.setModel(modelo);
        
    }
private void listarCategorias(ArrayList<String> ListaCategorias){
        DefaultListModel modelo2 = new DefaultListModel();
        for(int i = 0; i<sys.listarCategorias().size(); i++){
            modelo2.add(i, sys.listarCategorias().get(i));
        }
            lstCategorias.setModel(modelo2);
    }
        
    
private void listarVideos(ArrayList<DtVideo> ListaVideos){
        DefaultListModel modelo1 = new DefaultListModel();
        for (DtVideo it : ListaVideos) {
            modelo1.addElement(it.getNombre());
        }
        lstVideoUsuario.setModel(modelo1);
        
    }
private void cargarDatosDeVideo(DtVideo v){
        int hora,minuto,segundo;
        txtNombre.setText(v.getNombre());
        txtDescripcion.setText(v.getDescripcion());
        txtURL.setText(v.getUrlVideoOriginal());
        jDateChooser1.setDate(v.getFechaPublicacion());
        
        spHora.setValue(v.getDuracion().getHours());
        spMinuto.setValue(v.getDuracion().getMinutes());
        spSegundos.setValue(v.getDuracion().getSeconds());
        
        if (v.getPrivacidad() == Privacidad.PUBLICO){
            rbPublico.setSelected(true);
        }else{
            rbPrivado.setSelected(true);
        }
}



    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if (lstVideoUsuario.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un video para modificar", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                if (txtNombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El nombre de video no puede ser vacío", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    if (lstCategorias.isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(null, "Seleccione una categoría", "Error", JOptionPane.ERROR_MESSAGE);
                    } else {
                        if (txtURL.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "La URL del video no puede ser vacía", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {

                            int hora = (Integer) spHora.getValue();
                            int minuto = (Integer) spMinuto.getValue();
                            int segundo = (Integer) spSegundos.getValue();
                            Privacidad priv = Privacidad.PRIVADO;
                            if (rbPrivado.isSelected() && !(rbPublico.isSelected())) {
                                priv = Privacidad.PRIVADO;
                            } else if (rbPublico.isSelected() && !(rbPrivado.isSelected())) {
                                priv = Privacidad.PUBLICO;
                            } else {
                                JOptionPane.showMessageDialog(null, "Seleccione privacidad del video", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            java.sql.Date fecha = null;
                            if (jDateChooser1.getDate() != null) {
                                java.util.Date utilDate = jDateChooser1.getDate();
                                fecha = new java.sql.Date(utilDate.getTime());
                            }
                            DtVideo video = new DtVideo(WIDTH, txtNombre.getText(), txtDescripcion.getText(), new Time(hora, minuto, segundo), fecha, txtURL.getText(), priv, lstCategorias.getSelectedValue(), ALLBITS, PROPERTIES);
                            if (sys.obtenerCanalDeUsuario().getPrivacidad() == Privacidad.PRIVADO && rbPublico.isSelected()) {
                                JOptionPane.showMessageDialog(null, "No es posible hacer público un video si su canal es privado", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                            sys.modificarVideo(video);
                            sys.liberarMemoriaListaDeReproduccion();
                            sys.liberarMemoriaUsuario();
                            sys.liberarMemoriaVideo();

                            JOptionPane.showMessageDialog(null, "Se han efectuado los cambios", "OK", JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
            try{
                    sys.liberarMemoriaListaDeReproduccion();
                    sys.liberarMemoriaUsuario();
                    sys.liberarMemoriaVideo();
                    dispose();
                } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        
            }
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void lstDuenioVideoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDuenioVideoValueChanged
        if (evt.getValueIsAdjusting()) return;
        if (lstDuenioVideo.getSelectedIndex()<0) return;
        txtDescripcion.setText("");
        txtNombre.setText("");
        txtURL.setText("");
        spHora.setValue(0);
        spMinuto.setValue(0);
        spSegundos.setValue(0);
        String nick = lstDuenioVideo.getSelectedValue();
        sys.seleccionarUsuario(nick);
        listarVideos(sys.listarVideosDeUsuario());
    }//GEN-LAST:event_lstDuenioVideoValueChanged

    private void lstVideoUsuarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVideoUsuarioValueChanged
        if (evt.getValueIsAdjusting()) return;
        if (lstVideoUsuario.getSelectedIndex()<0) return;

        try {
            String nombre = lstVideoUsuario.getSelectedValue();
            ArrayList<DtVideo> arr = sys.listarVideosDeUsuario();
            int idVideo = arr.get(lstVideoUsuario.getSelectedIndex()).getId();
            DtVideo dtv = sys.seleccionarVideo(idVideo);
            
            listarCategorias(sys.listarCategorias());
            cargarDatosDeVideo(dtv);
        }catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_lstVideoUsuarioValueChanged

    private void rbPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPrivadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPrivadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.ButtonGroup buttonGroup1;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JList<String> lstDuenioVideo;
    private javax.swing.JList<String> lstVideoUsuario;
    public static javax.swing.JRadioButton rbPrivado;
    public static javax.swing.JRadioButton rbPublico;
    private javax.swing.JSpinner spHora;
    private javax.swing.JSpinner spMinuto;
    private javax.swing.JSpinner spSegundos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
