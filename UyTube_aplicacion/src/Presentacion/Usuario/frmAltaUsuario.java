package Presentacion.Usuario;

import Logica.Clases.Canal;
import Logica.DataType.DtCanal;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmAltaUsuario extends javax.swing.JDialog {
    public frmAltaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoPrivacidad = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        btSeleccionar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNikname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        txtNombreCanal = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        btCargar = new javax.swing.JButton();
        rdPublico = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        pnlImagen = new javax.swing.JPanel();
        lbImagen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        rdPrivado = new javax.swing.JRadioButton();
        btCancelar = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta usuario");

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        btSeleccionar.setText("Selecionar");
        btSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 130, 70));

        jLabel1.setText("Nickname");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setText("Apellido");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Usuario");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel2.add(txtNikname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 270, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 270, -1));

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtApellidoKeyTyped(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 270, -1));
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 270, -1));

        jLabel9.setText("Seleccione la fecha de nacimiento");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Canal");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel12.setText("Nombre");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel13.setText("Descripción");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 410, 200));
        jPanel2.add(txtNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 290, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 10, 560));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("opcional *");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, -1));

        btCargar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btCargar.setText(" Cargar ");
        btCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCargarActionPerformed(evt);
            }
        });
        jPanel2.add(btCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 360, 60));

        rdPublico.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdPublico.setText("Publico");
        jPanel2.add(rdPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 350, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 980, 10));

        pnlImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        pnlImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pnlImagenMouseClicked(evt);
            }
        });
        pnlImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        pnlImagen.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        jPanel2.add(pnlImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 130, 110));

        jLabel10.setText("Imagen");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));

        rdPrivado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdPrivado.setText("Privado");
        jPanel2.add(rdPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, -1));

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 340, 60));

        jLabel42.setText("Email");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("opcional *");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, 70, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 100, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSeleccionarActionPerformed
        //Usiario->nuevo Usuario->seleccionar
        cargarImagen(lbImagen);
    }//GEN-LAST:event_btSeleccionarActionPerformed

    private void btCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCargarActionPerformed
        String nombre = txtNombre.getText();
        String nickname = txtNikname.getText();
        String apellido = txtApellido.getText();
        String email = txtEmail.getText();
        String descripcion = txtDescripcion.getText();
        String nombreCanal = txtNombreCanal.getText();
        Privacidad privacidad = Privacidad.PRIVADO; //Privacidad Privado por default 
        String imagen= "";
        //Verifica la opcion seleccionada por los radioButton (Privado o Publico)
        if(rdPublico.isSelected()){
            privacidad = Privacidad.PUBLICO;
        }
        java.sql.Date fecha = null;
        //Verifica que la fecha no sea nula
        if( jDateChooser1.getDate() != null){
            java.util.Date utilDate = jDateChooser1.getDate();//Obtiene la fecha del JDateChooser en formato Date        
            fecha = new java.sql.Date(utilDate.getTime());//Lo combierte al tipo Date sql
        }        
                
        if( nombre.isEmpty() || nombre.equals("")){
            txtNombre.setText("");
            //lblErrorNickname.setVisible(true);
        }
        //Icon icono = new ImageIcon(getClass().getResource("/Imagenes/icono.jpg"));
       
        
        Fabrica fabrica = Fabrica.getInstancia();//crea la fibrica si no esta creada
        IAdmin sys = fabrica.getIAdmin(); //Soliciata un controlador a la fabrica
        try {
            if(!sys.existeNickname(nickname) && !sys.existeEmail(email)){
                DtUsuario dtUsuario = new DtUsuario(nickname, nickname, nombre, apellido, email, fecha, imagen, 0);
                DtCanal dtCanal = new DtCanal(Canal.getNuevoId(), nombre, descripcion, privacidad);
                sys.altaUsuarioCanal(dtUsuario, dtCanal);
            }else{
                txtNikname.setText(nickname + " ya existe!");
                txtNikname.setForeground(Color.red);  
                txtNikname.setBorder(BorderFactory.createLineBorder(Color.RED, 1));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se produjo un error al intentar ingresar los datos.", "Alta de Usuario", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_btCargarActionPerformed

    private void pnlImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlImagenMouseClicked
        //cargar imagen en nuevo usuario
        //cargarImagen(jLabel34);
    }//GEN-LAST:event_pnlImagenMouseClicked

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        //usuario->nuevo usuario->cancelar
      
    }//GEN-LAST:event_btCancelarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        //Chequea que solo se puedan escribir Letras
        if ( ! Character.isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtApellidoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyTyped
        //Chequea que solo se puedan escribir Letras
        if ( ! Character.isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtApellidoKeyTyped

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
    private javax.swing.ButtonGroup GrupoPrivacidad;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btCargar;
    private javax.swing.JButton btSeleccionar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JPanel pnlImagen;
    private javax.swing.JRadioButton rdPrivado;
    private javax.swing.JRadioButton rdPublico;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtNikname;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCanal;
    // End of variables declaration//GEN-END:variables
}
