package Presentacion.Usuario;

import Logica.Clases.Canal;
import Logica.DataType.DtCanal;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import com.sun.glass.events.KeyEvent;
import java.awt.Color;
import java.awt.Image;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;


public class frmAltaUsuario extends javax.swing.JDialog {
    

    // Patrón para validar el email
    Pattern patronEmail = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
    
    Pattern patronNombres= Pattern.compile("^([A-Za-zÑñÁáÉéÍíÓóÚú]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú]+)$");
    IAdmin sys;       
    Border bordeDefault;
    Color colorOK = new ColorUIResource(40,167,69);
    Color colorError = new ColorUIResource(220,53,69);
    String nickname = new String();
    String email = new String();
    String nombre = new String();
    String apellido = new String();
    
    public frmAltaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        sys = Fabrica.getInstancia().getIAdmin();
        bordeDefault = txtNombre.getBorder();
        
    }
    
    private boolean validarFormatoEmail(String _email){
        Matcher mather = patronEmail.matcher(_email); 
        if (mather.find() == true) {
            return true;
        } 
        return false;        
    }
    
    private boolean validarNombres(String _nombre){
        Matcher mather = patronNombres.matcher(_nombre); 
        if (mather.find() == true) {
            return true;
        } else {
            return false;
        }
    }
    
    private boolean validarTxt(JTextField txt, int largo,JLabel lb,String nombreCampo){
        try{
            if(txt.getText().length() > largo){
                lb.setText(" El campo supera los "+largo+" caracteres");
                cambiarColoresError(txt, lb);
                return false;
            }
            else if(txt.getText().equals("")){
                lb.setText(" El campo "+nombreCampo+" es obligatorio");
                cambiarColoresError(txt, lb);
                return false;
            }
            else if(nombreCampo.equals("Nickname")){        
                if (sys.existeNickname(nickname)) {
                    lb.setText(" El nickname \"" + nickname + "\" ya existe");
                    cambiarColoresError(txt, lb);
                    return false;
                }    

            }
            else if(nombreCampo.equals("Nombre") ){
                if(!validarNombres(nombre)){
                    lb.setText(" El nombre \"" + nombre + "\" no es válido");
                    cambiarColoresError(txt, lb);
                    return false;
                }
            }
            else if(nombreCampo.equals("Apellido") ){
                if(!validarNombres(apellido)){
                    lb.setText(" El apellido \"" + apellido + "\" no es válido");
                    cambiarColoresError(txt, lb);
                    return false;
                }
            }
            else if(nombreCampo.equals("Email")){
                if(!validarFormatoEmail(email)){
                    lb.setText(" El Email no es válido");
                    cambiarColoresError(txt, lb);
                    System.out.println("Formato el email es "+email);
                    return false;                                        
                }      
                if(sys.existeEmail(email)){
                    lb.setText(" El Email ya existe");
                    cambiarColoresError(txt, lb);
                    System.out.println("Existe el email es "+email);
                    return false;
                }
            }                  
            else{
                txt.setBorder(bordeDefault);
                lb.setText("");
                lb.setOpaque(false);
            }
                   
        } catch (Exception e) {
                JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    private void cambiarColoresError(JTextField txt, JLabel lb){
        lb.setOpaque(true);
        lb.setForeground(Color.WHITE);
        lb.setBackground(colorError);  
        txt.setBorder(BorderFactory.createLineBorder(colorError, 1));
    }
    
    private void limpiarCampos(){
        txtNikname.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtEmail.setText("");
        txtDescripcion.setText("");
        txtNombreCanal.setText("");
        jDateChooser1.setDate(null);
        lbImagen.setIcon(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoPrivacidad = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        txtNikname = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        btSeleccionar = new javax.swing.JButton();
        txtNombreCanal = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        rdPrivado = new javax.swing.JRadioButton();
        btnCargar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        rdPublico = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        pnlImagen = new javax.swing.JPanel();
        lbImagen = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        lbMsjNikname = new javax.swing.JLabel();
        lbMsjNombre = new javax.swing.JLabel();
        lbMsjApellido = new javax.swing.JLabel();
        lbMsjEmail = new javax.swing.JLabel();
        lbMsjFecha = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta usuario");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNikname.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNiknameFocusGained(evt);
            }
        });
        txtNikname.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNiknameKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNiknameKeyPressed(evt);
            }
        });
        jPanel2.add(txtNikname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 270, -1));

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel2.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 270, -1));

        txtApellido.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtApellidoKeyPressed(evt);
            }
        });
        jPanel2.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 270, -1));

        txtEmail.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtEmailFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtEmailFocusLost(evt);
            }
        });
        txtEmail.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtEmailKeyTyped(evt);
            }
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtEmailKeyPressed(evt);
            }
        });
        jPanel2.add(txtEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 300, -1));
        jPanel2.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 230, 100, -1));

        btSeleccionar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btSeleccionar.setText("Selecionar");
        btSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSeleccionarActionPerformed(evt);
            }
        });
        jPanel2.add(btSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 160, 60));

        txtNombreCanal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreCanalKeyPressed(evt);
            }
        });
        jPanel2.add(txtNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 60, 280, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtDescripcion);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 120, 400, 190));

        GrupoPrivacidad.add(rdPrivado);
        rdPrivado.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        rdPrivado.setSelected(true);
        rdPrivado.setText("Privado");
        jPanel2.add(rdPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 350, -1, -1));

        btnCargar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCargar.setText(" Cargar ");
        btnCargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCargarActionPerformed(evt);
            }
        });
        jPanel2.add(btnCargar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 360, 60));

        btCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });
        jPanel2.add(btCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 340, 60));

        jLabel1.setText("Nickname");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setText("Apellido");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Usuario");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        jLabel9.setText("Seleccione la fecha de nacimiento");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel11.setText("Canal");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel12.setText("Nombre");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel13.setText("Descripción");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 10, 560));

        jLabel14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel14.setText("(Opcional)");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, -1));

        GrupoPrivacidad.add(rdPublico);
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

        jLabel42.setText("Email");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("(Opcional)");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 350, 90, -1));
        jPanel2.add(lbMsjNikname, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 70, 270, -1));
        jPanel2.add(lbMsjNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 270, -1));
        jPanel2.add(lbMsjApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 150, 270, -1));
        jPanel2.add(lbMsjEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 190, 300, -1));
        jPanel2.add(lbMsjFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 350, -1));

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

    private void btnCargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCargarActionPerformed
        nombre = txtNombre.getText().trim();
        nickname = txtNikname.getText().trim();
        apellido = txtApellido.getText().trim();
        email = txtEmail.getText().toLowerCase().trim();
        String descripcion = txtDescripcion.getText().trim();
        String nombreCanal = txtNombreCanal.getText().trim();
        Privacidad privacidad = Privacidad.PRIVADO; //Privacidad Privado por default 
        String imagen= "";
        //Verifica la opcion seleccionada por los radioButton (Privado o Publico)
        if(rdPublico.isSelected()){
            privacidad = Privacidad.PUBLICO;
        }
        java.sql.Date fecha = null;//Verifica que la fecha no sea nula
        if( jDateChooser1.getDate() != null){
            java.util.Date utilDate = jDateChooser1.getDate();//Obtiene la fecha del JDateChooser en formato Date        
            fecha = new java.sql.Date(utilDate.getTime());//Lo combierte al tipo Date sql
        }
        //Arrays para validaciones      
        JTextField v1[] = {txtNikname,txtNombre,txtApellido,txtEmail};
        int[] v2= {30,30,30,35};
        JLabel[] v3= {lbMsjNikname, lbMsjNombre, lbMsjApellido, lbMsjEmail};        
        String[] v4 ={"Nickname","Nombre","Apellido","Email"};
        int[] v5 ={0,0,0,0};

        for (int i = 0; i < v5.length; i++) {
            if (validarTxt(v1[i], v2[i], v3[i], v4[i])) {
                v5[i] = 1;
            }
        }    
        if(v5[0]==0 || v5[1]==0 || v5[2]==0 || v5[3]==0){
            return;
        }
        if (fecha == null) {
            lbMsjFecha.setText(" La fecha de nacimiento es obligatoria");
            lbMsjFecha.setOpaque(true);
            lbMsjFecha.setForeground(Color.WHITE);
            lbMsjFecha.setBackground(colorError);
            return;
        }
        if(txtNombreCanal.equals("")){
            nombreCanal = nickname;            
        }                
        try {    
            DtUsuario dtUsuario = new DtUsuario(nickname, nickname, nombre, apellido, email, fecha, imagen, 0);
            DtCanal dtCanal = new DtCanal(Canal.getNuevoId(), nombre, descripcion, privacidad);
            sys.altaUsuarioCanal(dtUsuario, dtCanal);
            JOptionPane.showMessageDialog(null, "Se ha creado el usuario "+nickname, "Error:", JOptionPane.INFORMATION_MESSAGE);
            limpiarCampos();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnCargarActionPerformed

    private void pnlImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pnlImagenMouseClicked
        //cargar imagen en nuevo usuario
        //cargarImagen(jLabel34);
    }//GEN-LAST:event_pnlImagenMouseClicked

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        //usuario->nuevo usuario->cancelar
        limpiarCampos();
        this.setVisible(false);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        limpiarCampos();
    }//GEN-LAST:event_formWindowClosed

    private void txtNiknameKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNiknameKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                txtNombre.requestFocus();                
        }
    }//GEN-LAST:event_txtNiknameKeyPressed

    private void txtNiknameFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNiknameFocusGained
        //Al recibir el foco restaura los valores
        txtNikname.setBorder(bordeDefault);
        lbMsjNikname.setText("");
        lbMsjNikname.setOpaque(false);        
    }//GEN-LAST:event_txtNiknameFocusGained

    private void txtNiknameKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNiknameKeyTyped
//        // al escribir
//        txtNikname.setBorder(bordeDefault);
//        lbMsjNikname.setText("");
//        lbMsjNikname.setOpaque(false);
    }//GEN-LAST:event_txtNiknameKeyTyped

    private void txtEmailFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusLost
        // Al perder el foco valida el email
             
    }//GEN-LAST:event_txtEmailFocusLost

    private void txtEmailFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtEmailFocusGained
        //Al recibir el foco restaura los valores
        txtEmail.setBorder(bordeDefault);
        lbMsjEmail.setText("");
        lbMsjEmail.setOpaque(false);
    }//GEN-LAST:event_txtEmailFocusGained

    private void txtEmailKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyTyped
        // Al presionar enter
        if(evt.getKeyChar() == KeyEvent.VK_ENTER){
            jDateChooser1.requestFocus();
        }
    }//GEN-LAST:event_txtEmailKeyTyped

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        //Al recibir el foco restaura los valores
        txtNombre.setBorder(bordeDefault);
        lbMsjNombre.setText("");
        lbMsjNombre.setOpaque(false);
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                txtApellido.requestFocus();                
        }
    }//GEN-LAST:event_txtNombreKeyPressed

    private void txtApellidoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtApellidoKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                txtEmail.requestFocus();                
        }
    }//GEN-LAST:event_txtApellidoKeyPressed

    private void txtEmailKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtEmailKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                jDateChooser1.requestFocus();                
        }
    }//GEN-LAST:event_txtEmailKeyPressed

    private void txtNombreCanalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreCanalKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
                txtDescripcion.requestFocus();                
        }
    }//GEN-LAST:event_txtNombreCanalKeyPressed

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
    private javax.swing.JButton btSeleccionar;
    private javax.swing.JButton btnCargar;
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
    private javax.swing.JLabel lbMsjApellido;
    private javax.swing.JLabel lbMsjEmail;
    private javax.swing.JLabel lbMsjFecha;
    private javax.swing.JLabel lbMsjNikname;
    private javax.swing.JLabel lbMsjNombre;
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
