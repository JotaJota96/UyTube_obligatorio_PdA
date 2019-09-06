package Presentacion.Usuario;

import Logica.DataType.DtCanal;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Presentacion.ListaDeReproduccion.frmModificarListaDeReproduccion;
import Presentacion.Video.frmModificarVideo;
import Presentacion.Video.frmValorarVideo;
import Presentacion.frmPrincipal;
import com.sun.org.apache.bcel.internal.generic.Select;
import java.awt.Image;
import java.io.File;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmModificarUsuario extends javax.swing.JDialog {
    
    IAdmin sys;
    DtUsuario user;

    public frmModificarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        txtContraNueva.setEnabled(false); // TODO add your handling code here:
        txtContraNueva1.setEnabled(false); // TODO add your handling code here:
        lbCN.setEnabled(false);
        lbRCN.setEnabled(false);
        btnVideo.setEnabled(false);
        btnListaReprodiccion.setEnabled(false);
        desactivarCampos();

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

        grpPrivacidad = new javax.swing.ButtonGroup();
        lbMes = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        lbImagen1 = new javax.swing.JLabel();
        spAnio = new javax.swing.JSpinner();
        spMes = new javax.swing.JSpinner();
        spDia = new javax.swing.JSpinner();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane50 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnModificar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        lbNombreC = new javax.swing.JLabel();
        txtNombreCanal = new javax.swing.JTextField();
        lbDescripcion = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        txtDescrpcion = new javax.swing.JTextArea();
        btnListaReprodiccion = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jpImagen = new javax.swing.JPanel();
        jSeparator6 = new javax.swing.JSeparator();
        lbAnio = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        lbDia = new javax.swing.JLabel();
        lbOpcional = new javax.swing.JLabel();
        lbImagen = new javax.swing.JLabel();
        txtContraNueva1 = new javax.swing.JTextField();
        txtContraNueva = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        lbRCN = new javax.swing.JLabel();
        lbCN = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        chkCambiarContra = new javax.swing.JCheckBox();
        rbPublico = new javax.swing.JRadioButton();
        rbPrivado = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar usuario");

        lbMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre.setText("Nombre");
        lbMes.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        lbCorreo.setText("Correo");
        lbMes.add(lbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel128.setText("Usuario");
        lbMes.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        lbMes.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 230, -1));

        txtCorreo.setEnabled(false);
        lbMes.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 230, -1));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        lbMes.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 10, 560));

        lbImagen1.setText("Imagen");
        lbMes.add(lbImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 400, -1, 20));
        lbMes.add(spAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 200, 60, -1));
        lbMes.add(spMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 200, 40, -1));
        lbMes.add(spDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 200, 40, -1));

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel131.setText("Seleccionar usuario");
        lbMes.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lstUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosValueChanged(evt);
            }
        });
        jScrollPane50.setViewportView(lstUsuarios);

        lbMes.add(jScrollPane50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 420));

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        lbMes.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 270, 50));

        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("");
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        lbMes.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 450, 120, 60));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        lbMes.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 10, 560));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel132.setText("Canal");
        lbMes.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        lbNombreC.setText("Nombre");
        lbMes.add(lbNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));
        lbMes.add(txtNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 200, -1));

        lbDescripcion.setText("Descripción");
        lbMes.add(lbDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        txtDescrpcion.setColumns(20);
        txtDescrpcion.setRows(5);
        jScrollPane51.setViewportView(txtDescrpcion);

        lbMes.add(jScrollPane51, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 200, 160));

        btnListaReprodiccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnListaReprodiccion.setText("Lista de reproduccion");
        btnListaReprodiccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaReprodiccionActionPerformed(evt);
            }
        });
        lbMes.add(btnListaReprodiccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 270, 50));

        btnVideo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnVideo.setText("Video");
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });
        lbMes.add(btnVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 270, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        lbMes.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 260, 50));

        jpImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        lbMes.add(jpImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 430, 140, 110));
        lbMes.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 650, 20));

        lbAnio.setText("Año");
        lbMes.add(lbAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        jLabel142.setText("Mes");
        lbMes.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 180, -1, -1));

        lbDia.setText("Dia");
        lbMes.add(lbDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 180, -1, -1));

        lbOpcional.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lbOpcional.setText("Opcional *");
        lbMes.add(lbOpcional, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 520, -1, -1));
        lbMes.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 140, 110));
        lbMes.add(txtContraNueva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 340, 160, -1));
        lbMes.add(txtContraNueva, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 310, 160, -1));
        lbMes.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 230, -1));

        lbApellido.setText("Apellido");
        lbMes.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        lbRCN.setText("Repita contraseña");
        lbMes.add(lbRCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        lbCN.setText("Contraseña nueva");
        lbMes.add(lbCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, -1, -1));

        lbFecha.setText("Fecha de Nac.");
        lbMes.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 200, -1, -1));

        chkCambiarContra.setText("Cambiar contraseña");
        chkCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCambiarContraActionPerformed(evt);
            }
        });
        lbMes.add(chkCambiarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, -1));

        grpPrivacidad.add(rbPublico);
        rbPublico.setText("Publico");
        lbMes.add(rbPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, -1, -1));

        grpPrivacidad.add(rbPrivado);
        rbPrivado.setText("Privado");
        lbMes.add(rbPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void listarUsuarios(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstUsuarios.setModel(modelo);
        
    }
 private void desactivarCampos(){
        txtNombre.setEnabled(false);
        txtContraNueva.setEnabled(false);
        txtContraNueva1.setEnabled(false);
        txtDescrpcion.setEnabled(false);
        txtNombreCanal.setEnabled(false);
        txtApellido.setEnabled(false);
        spAnio.setEnabled(false);
        spMes.setEnabled(false);
        spDia.setEnabled(false);
        lbImagen1.setEnabled(false);
        lbDia.setEnabled(false);
        lbMes.setEnabled(false);
        lbAnio.setEnabled(false);
        lbNombre.setEnabled(false);
        lbApellido.setEnabled(false);
        lbNombreC.setEnabled(false);
        lbCorreo.setEnabled(false);
        lbDescripcion.setEnabled(false);
        lbFecha.setEnabled(false);
        lbOpcional.setEnabled(false);
        chkCambiarContra.setEnabled(false);
        rbPublico.setEnabled(false);
        rbPrivado.setEnabled(false);
        btnModificar.setEnabled(false);
        btnSeleccionar.setEnabled(false);
        
        
        
    }
 private void activarCampos(){
//        txtNombre.setEnabled(true);
//        txtContraNueva.setEnabled(true);
//        txtContraNueva1.setEnabled(true);
//        txtDescrpcion.setEnabled(true);
//        txtNombreCanal.setEnabled(true);
//        txtApellido.setEnabled(true);
//        spAnio.setEnabled(true);
//        spMes.setEnabled(true);
//        spDia.setEnabled(true);
//        
  txtNombre.setEnabled(true);
        txtContraNueva.setEnabled(true);
        txtContraNueva1.setEnabled(true);
        txtDescrpcion.setEnabled(true);
        txtNombreCanal.setEnabled(true);
        txtApellido.setEnabled(true);
        spAnio.setEnabled(true);
        spMes.setEnabled(true);
        spDia.setEnabled(true);
        lbImagen1.setEnabled(true);
        lbDia.setEnabled(true);
        lbMes.setEnabled(true);
        lbAnio.setEnabled(true);
        lbNombre.setEnabled(true);
        lbApellido.setEnabled(true);
        lbNombreC.setEnabled(true);
        lbCorreo.setEnabled(true);
        lbDescripcion.setEnabled(true);
        lbFecha.setEnabled(true);
        lbOpcional.setEnabled(true);
        chkCambiarContra.setEnabled(true);
        rbPublico.setEnabled(true);
        rbPrivado.setEnabled(true);
        btnModificar.setEnabled(true);
        btnSeleccionar.setEnabled(true);
    }
 
 
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {
            if(lstUsuarios.isSelectionEmpty()){
                    JOptionPane.showMessageDialog(null, "Seleccione un usuario para modificar", "Error", JOptionPane.WARNING_MESSAGE);

            }else{
            int anio = (Integer) spAnio.getValue();
            int mes = (Integer) spMes.getValue();
            int dia = (Integer) spDia.getValue();
            String pass = user.getContrasenia();
            if (chkCambiarContra.isSelected()) {
                        
                if (!(txtContraNueva.getText().equals("") && txtContraNueva1.getText().equals(""))) {

                    if (txtContraNueva.getText().equals(txtContraNueva1.getText())) {
                        pass = txtContraNueva.getText();
                    } else {
                        JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, no se pudo efectuar el cambio de contraseña. Inténtelo de nuevo", "OK", JOptionPane.WARNING_MESSAGE);
                        return;
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "Ingrese la contraseña nueva", "OK", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }
        
                DtUsuario u = new DtUsuario(user.getNickname(), pass, txtNombre.getText(), txtApellido.getText(), user.getCorreo(), new Date(anio, mes, dia), "imagen", PROPERTIES);
                Privacidad priv;
                if(rbPrivado.isSelected()){
                    priv = Privacidad.PRIVADO;
                }else{
                    priv = Privacidad.PUBLICO;
                }
                DtCanal c = new DtCanal(0, txtNombreCanal.getText(), txtDescrpcion.getText(), priv);
                sys.modificarUsuarioYCanal(u, c);

                JOptionPane.showMessageDialog(null, "Datos modificados correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                dispose();
             
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        cargarImagen(lbImagen);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnListaReprodiccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaReprodiccionActionPerformed
        new frmModificarListaDeReproduccion(this,true,lstUsuarios.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_btnListaReprodiccionActionPerformed

    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed
        new frmModificarVideo(this, true, lstUsuarios.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_btnVideoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        sys.liberarMemoriaUsuario();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
 private void cargarDatosDelUsuario(DtUsuario u){
        txtNombre.setText(u.getNombre());
        txtApellido.setText(u.getApellido());
        txtCorreo.setText(u.getCorreo());        
        spAnio.setValue(u.getFechaNacimiento().getYear());
        spMes.setValue(u.getFechaNacimiento().getMonth());
        spDia.setValue(u.getFechaNacimiento().getDay());
        
    }
    private void cargarDatosDelCanal(DtCanal c){
        txtNombreCanal.setText(c.getNombre());
        txtDescrpcion.setText(c.getDescripcion());
        if (c.getPrivacidad() == Privacidad.PUBLICO){
            rbPublico.setSelected(true);
        }else{
          rbPrivado.setSelected(true);
        }
    }
    
    
    
    
    
    private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosValueChanged
         try {
             if(! lstUsuarios.isSelectionEmpty()){
                 activarCampos();
             }
             btnVideo.setEnabled(true);
             btnListaReprodiccion.setEnabled(true);
            String nick = lstUsuarios.getSelectedValue();
            user = sys.seleccionarUsuario(nick);
            cargarDatosDelUsuario(user);
            DtCanal dtc = sys.obtenerCanalDeUsuario();
            cargarDatosDelCanal(dtc);
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_lstUsuariosValueChanged

    private void chkCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCambiarContraActionPerformed
        if(chkCambiarContra.isSelected()){
            txtContraNueva.setEnabled(true);
            txtContraNueva1.setEnabled(true);
            lbCN.setEnabled(true);
            lbRCN.setEnabled(true);
        }else{
             txtContraNueva.setEnabled(false);
            txtContraNueva1.setEnabled(false);
            lbCN.setEnabled(false);
            lbRCN.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chkCambiarContraActionPerformed

  
    
    
    
    private void cargarImagen(javax.swing.JLabel jLabelx) {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(this);
        File archivo = jf.getSelectedFile();

        if (archivo != null) {
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
            jf.setFileFilter(filtroImagen);
            //jLabel4.setText(archivo.getAbsolutePath());
            Image img = new ImageIcon(archivo.getAbsolutePath()).getImage();
            float i = 0f;
            if (img.getHeight(null) > img.getWidth(null)) {
                i = img.getHeight(null) / img.getWidth(null);
            } else {
                i = img.getWidth(null) / img.getHeight(null);
            }
            if (i < 1.4 && i >= 1) {
                ImageIcon img2 = new ImageIcon(img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH));
                jLabelx.setIcon(img2);
                /*
                ImageIcon img3 = new ImageIcon(img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH));
                jLabelx.setIcon(img3);//cuidado!!
                jLabelx.setVisible(false);//cuidado!!*/
            } else {
                JOptionPane.showMessageDialog(null, "Imagen fuera de dimenciones " + img.getWidth(null) + " x " + img.getHeight(null));
            }
        }
    }
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListaReprodiccion;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVideo;
    private javax.swing.JCheckBox chkCambiarContra;
    private javax.swing.ButtonGroup grpPrivacidad;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel jpImagen;
    private javax.swing.JLabel lbAnio;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCN;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbDia;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbImagen1;
    private javax.swing.JPanel lbMes;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreC;
    private javax.swing.JLabel lbOpcional;
    private javax.swing.JLabel lbRCN;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JRadioButton rbPrivado;
    private javax.swing.JRadioButton rbPublico;
    private javax.swing.JSpinner spAnio;
    private javax.swing.JSpinner spDia;
    private javax.swing.JSpinner spMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtContraNueva;
    private javax.swing.JTextField txtContraNueva1;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDescrpcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCanal;
    // End of variables declaration//GEN-END:variables
}
