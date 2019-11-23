
package com.uytube.Presentacion.Video;

import com.uytube.Logica.Fabrica;
import com.uytube.Logica.Clases.Video;
import com.uytube.Logica.DataType.DtVideo;
import com.uytube.Logica.Enumerados.Privacidad;
import com.uytube.Logica.Interfaces.IAdmin;
import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

public class frmAltaVideo extends javax.swing.JDialog {
    
    private ArrayList<String> indexDuenioVideo = new ArrayList();
    private ArrayList<String> indexCategorias = new ArrayList(); 
    private IAdmin sys;  
    private String categoria = "";
    private String usrSeleccionado = "";   
    private Border bordeDefault;
    private Color colorOK = new ColorUIResource(40,167,69);
    private Color colorError = new ColorUIResource(220,53,69);
    private String nombre = new String();
    private String url = new String();
    private String descripcion = new String();
    int anioActual,diaActual,mesActual;
    
    // Patrón para validar el email
    Pattern patronURL = Pattern.compile("^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))(%[0-9A-Fa-f]{2}|[-()_.!~*’;/?:@&=+$, A-Za-z0-9])+)([).!’;/?:, ][[:blank:]])?$");
    
    Pattern patronNombre= Pattern.compile("^([A-Za-zÑñÁáÉéÍíÓóÚú0-9]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú0-9]+)\\s*"
            + "([A-Za-zÑñÁáÉéÍíÓóÚú0-9]+)$");
    public frmAltaVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        sys = Fabrica.getInstancia().getIAdmin();
        bordeDefault = txtNombre.getBorder();
        nombre = "";
        url = "";
        descripcion = "";
    }
    
    private boolean validarDuracion(int s, int m, int h){
        if ( s > 0 || m > 0 || h > 0) {             
            return true;
        }
        lbMsjDuracion.setOpaque(true);
        lbMsjDuracion.setForeground(Color.WHITE);
        lbMsjDuracion.setBackground(colorError);
        lbMsjDuracion.setText(" El campo duración es obligatorio");
        return false;                   
    }
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtUrl.setText("");
        spHoras.setValue(0);
        spMinutos.setValue(0);
        spSegundos.setValue(0);
        usrSeleccionado="";
        categoria = "";
        jDateChooser1.setDate(null);
    }
    
    private void limpiarLstDuenios(){
        DefaultListModel modelo = new DefaultListModel();
        lstDuenioVideo.setModel(modelo);
        indexDuenioVideo.clear();        
    }
    
    private void limpiarLstCategorias(){
        DefaultListModel modelo = new DefaultListModel();
        lstAsignarCategoria.setModel(modelo);
        indexCategorias.clear();   
    }
    
    private boolean validarFormatoURL(String _url){
        Matcher mather = patronURL.matcher(_url); 
        if (mather.find() == true) {
            return true;
        } 
        return false;        
    }
    
    private boolean validarNombres(String _nombre){
        Matcher mather = patronNombre.matcher(_nombre); 
        if (mather.find() == true) {
            return true;
        } 
        return false;        
    }
    
    private boolean validarTxt(JTextField txt, int max,JLabel lb,String nombreCampo){
        try{
            if(txt.getText().length() > max ){
                lb.setText(" El campo supera los "+max+" caracteres");
                cambiarColoresError(txt, lb);
                return false;
            }
            else if(txt.getText().equals("")){
                lb.setText(" El campo "+nombreCampo+" es obligatorio");
                cambiarColoresError(txt, lb);
                return false;
            }            
            else if(nombreCampo.equals("Nombre") ){                
                for (DtVideo video : sys.listarVideosDeUsuario()) {
                    if(video.getNombre().equals(nombre)){
                        lb.setText(" El nombre del video ya existe");
                        cambiarColoresError(txt, lb);
                        return false;
                    }
                }
            }            
            else if(nombreCampo.equals("URL")){
                if(!validarFormatoURL(url)){
                    lb.setText(" El formato de la URI no es válido");
                    cambiarColoresError(txt, lb);
                    return false;                                        
                }
            }            
            else{                
                txt.setBorder(bordeDefault);
                lb.setText("");
                lb.setOpaque(false);
            }
                   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return true;
    }
    
    private void cambiarColoresError(JTextField txt, JLabel lb){
        lb.setOpaque(true);
        lb.setForeground(Color.WHITE);
        lb.setBackground(colorError);  
        txt.setBorder(BorderFactory.createLineBorder(colorError, 1));
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        lstDuenioVideo = new javax.swing.JList<>();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        lstAsignarCategoria = new javax.swing.JList<>();
        txtNombre = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        spSegundos = new javax.swing.JSpinner();
        spHoras = new javax.swing.JSpinner();
        spMinutos = new javax.swing.JSpinner();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lbMsjNombre = new javax.swing.JLabel();
        lbMsjUrl = new javax.swing.JLabel();
        lbMsjFecha = new javax.swing.JLabel();
        lbMsjDescripcion = new javax.swing.JLabel();
        lbMsjDuracion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta video");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setText("Dueño del video:");
        jPanel14.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstDuenioVideo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDuenioVideoValueChanged(evt);
            }
        });
        jScrollPane16.setViewportView(lstDuenioVideo);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 360));

        jLabel72.setText("Nombre:");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jLabel73.setText("Segundos");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jLabel74.setText("URL:");
        jPanel14.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 160, -1, -1));

        jLabel75.setText("Descripción:");
        jPanel14.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 220, -1, -1));

        jLabel76.setText("Fecha publicación:");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 380, -1, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setText("Asignar categoría:");
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        lstAsignarCategoria.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstAsignarCategoriaValueChanged(evt);
            }
        });
        jScrollPane17.setViewportView(lstAsignarCategoria);

        jPanel14.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 260, 360));

        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        jPanel14.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 330, -1));

        txtUrl.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtUrlFocusGained(evt);
            }
        });
        jPanel14.add(txtUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 180, 330, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane18.setViewportView(txtDescripcion);

        jPanel14.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 240, 330, 120));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel14.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 440, 260, 70));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, 290, 70));

        spSegundos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spSegundos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spSegundosStateChanged(evt);
            }
        });
        jPanel14.add(spSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 60, -1));

        spHoras.setModel(new javax.swing.SpinnerNumberModel(0, 0, 15, 1));
        spHoras.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spHorasStateChanged(evt);
            }
        });
        jPanel14.add(spHoras, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 60, -1));

        spMinutos.setModel(new javax.swing.SpinnerNumberModel(0, 0, 59, 1));
        spMinutos.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                spMinutosStateChanged(evt);
            }
        });
        jPanel14.add(spMinutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 60, -1));

        jLabel135.setText("Duración:");
        jPanel14.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel136.setText("Horas");
        jPanel14.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jLabel137.setText("Minutos");
        jPanel14.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));

        jDateChooser1.setMaxSelectableDate(new java.util.Date(2524622503000L));
        jDateChooser1.setMinSelectableDate(new java.util.Date(-2208971613000L));
        jPanel14.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 380, 190, -1));

        lbMsjNombre.setMaximumSize(new java.awt.Dimension(0, 15));
        lbMsjNombre.setMinimumSize(new java.awt.Dimension(0, 15));
        jPanel14.add(lbMsjNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 70, 330, 15));
        jPanel14.add(lbMsjUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, 330, 15));
        jPanel14.add(lbMsjFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 250, 15));
        jPanel14.add(lbMsjDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 370, 330, 15));
        jPanel14.add(lbMsjDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 140, 330, 15));

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
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, 535, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        jDateChooser1.setBorder(bordeDefault);
        lbMsjFecha.setText("");
        lbMsjFecha.setOpaque(false); 
        nombre = txtNombre.getText().trim();//Obtiene el nombre y quita los espacios de los extremos
        descripcion = txtDescripcion.getText().trim();//Obtiene la descripcion y quita los espacios de los extremos
        url = txtUrl.getText().trim();//Obtiene la url y quita los espacios de los extremos
        int horas = (Integer)spHoras.getValue();
        int minutos = (Integer)spMinutos.getValue();
        int segundos = (Integer)spSegundos.getValue();
        Time duracion = new Time(horas, minutos, segundos);
        java.sql.Date fecha = null;
        //Verifica que la fecha no sea nula y la guarda en el formato correcto
        if( jDateChooser1.getDate() != null){
            java.util.Date utilDate = jDateChooser1.getDate();//Obtiene la fecha del JDateChooser en formato Date        
            fecha = new java.sql.Date(utilDate.getTime());//Lo combierte al tipo Date sql
        }        
        //Arrays para validaciones campos de texto   
        JTextField v1[] = {txtNombre,txtUrl}; //campos a validar
        int[] v2= {100,2083}; //Largos maximos de los campos Nombre y URL
        JLabel[] v3= { lbMsjNombre, lbMsjUrl}; //labels para mostrar mensajes       
        String[] v4 ={"Nombre","URL","Descricion"};//Nombre del campo
        boolean[] v5 ={false,false,false};//Estado inicial de las validaciones, cada elemento es una validacion de un campo especifico
        for (int i = 0; i < v5.length-1; i++) {
            if (validarTxt(v1[i], v2[i], v3[i], v4[i])) {
                v5[i] = true;
            }
        }         
        if(validarDuracion(segundos, minutos, horas)){
           v5[2] = true;
        }        
        if (fecha == null) {
            jDateChooser1.setBorder(BorderFactory.createLineBorder(colorError, 1));
            lbMsjFecha.setText(" La fecha es obligatoria");
            lbMsjFecha.setOpaque(true);
            lbMsjFecha.setForeground(Color.WHITE);
            lbMsjFecha.setBackground(colorError);
        }
        if(v5[0]==false|| v5[1]==false || v5[2]==false){
            return;            
        }        
        try {
            DtVideo dtVideo = new DtVideo(0, nombre, descripcion, duracion, fecha, url, Privacidad.PRIVADO, categoria, 0, 0);
            int opcion=JOptionPane.showConfirmDialog(null, 
                        "¿Desea guardar el video \""+nombre+"\"?"
                        , "Confirmar alta de Video", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opcion==0){
                sys.altaVideo(dtVideo);
                limpiarCampos();
            }
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarLstDuenios();
        limpiarLstCategorias();
        limpiarCampos();
        this.setVisible(false);//Oculta el formulario AltaVideo
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        DefaultListModel modeloDuenio = new DefaultListModel();
        DefaultListModel modeloCategoria = new DefaultListModel();
        Calendar c = new GregorianCalendar();//Objeto de tipo calendario con la fecha actual
        java.util.Date fechaActual = new Date(c.get(Calendar.YEAR)-1900,c.get(Calendar.MONTH),c.get(Calendar.DATE));//Obtiene la fecha actual del calendario     
        jDateChooser1.setDate(fechaActual);//Setea el JDateChooser con la fecha actual
        try {
            // Obtengo todos los nickname y los cargo en el listDuenioVideo(Lista de dueños de videos)
            limpiarLstCategorias();
            limpiarLstDuenios();
            if (!sys.listarUsuarios().isEmpty()) {
                for (int i = 0; i < sys.listarUsuarios().size(); i++) {
                    modeloDuenio.add(i, sys.listarUsuarios().get(i).getNickname());
                }
                lstDuenioVideo.setModel(modeloDuenio);
                lstDuenioVideo.setSelectedIndex(0);//Setea la lista en el primer usuario
                usrSeleccionado = lstDuenioVideo.getSelectedValue();
                sys.seleccionarUsuario(usrSeleccionado);
            }
            // Obtengo todas las categorias de video y las muestro en la lista
            if (!sys.listarCategorias().isEmpty()) {
                for (int i = 0; i < sys.listarCategorias().size(); i++) {
                    modeloCategoria.add(i, sys.listarCategorias().get(i));
                    indexCategorias.add(i, sys.listarCategorias().get(i));//Alamacena cada categoria obtenida en el mismo orde
                }
                lstAsignarCategoria.setModel(modeloCategoria);
                //Setea la lista Categoria en el elemento UNDEFINE
                for (int i = 0; i < indexCategorias.size(); i++) {
                    if( indexCategorias.get(i).equals("UNDEFINED") ){
                        lstAsignarCategoria.setSelectedIndex(i);
                        categoria = lstAsignarCategoria.getSelectedValue();
                        break;
                    }                    
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_formWindowActivated

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Al cerrar el formulario se borran todos los datos
        limpiarCampos();
        limpiarLstCategorias();
        limpiarLstDuenios();
    }//GEN-LAST:event_formWindowClosing

    private void lstDuenioVideoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDuenioVideoValueChanged
        if (evt.getValueIsAdjusting()) return;
        if (lstDuenioVideo.getSelectedIndex()<0) return;
        try {
            // El sistema selecciona al usuario actual con el nickname seleccionado de la lista 
            usrSeleccionado = lstDuenioVideo.getSelectedValue();
            sys.seleccionarUsuario(usrSeleccionado);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstDuenioVideoValueChanged

    private void lstAsignarCategoriaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstAsignarCategoriaValueChanged
        if (evt.getValueIsAdjusting()) return;
        if (lstAsignarCategoria.getSelectedIndex()<0) return;
        try {
            // Selecciona una categoria de la lista de categorias
            categoria = lstAsignarCategoria.getSelectedValue();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstAsignarCategoriaValueChanged

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        //Al recibir el foco restaura los valores
        txtNombre.setBorder(bordeDefault);
        lbMsjNombre.setText("");
        lbMsjNombre.setOpaque(false);         
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtUrlFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtUrlFocusGained
        //Al recibir el foco restaura los valores
        txtUrl.setBorder(bordeDefault);
        lbMsjUrl.setText("");
        lbMsjUrl.setOpaque(false); 
    }//GEN-LAST:event_txtUrlFocusGained

    private void spSegundosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spSegundosStateChanged
        // Al cambiar el valor verifica y restaura los valores
        if(validarDuracion((Integer)spSegundos.getValue(),(Integer)spMinutos.getValue(),(Integer)spHoras.getValue())){
            lbMsjDuracion.setText("");
            lbMsjDuracion.setOpaque(false);
        }
    }//GEN-LAST:event_spSegundosStateChanged

    private void spMinutosStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spMinutosStateChanged
        // Al cambiar el valor verifica y restaura los valores
        if(validarDuracion((Integer)spSegundos.getValue(),(Integer)spMinutos.getValue(),(Integer)spHoras.getValue())){
            lbMsjDuracion.setText("");
            lbMsjDuracion.setOpaque(false);
        }
    }//GEN-LAST:event_spMinutosStateChanged

    private void spHorasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_spHorasStateChanged
        // Al cambiar el valor verifica y restaura los valores
        if(validarDuracion((Integer)spSegundos.getValue(),(Integer)spMinutos.getValue(),(Integer)spHoras.getValue())){
            lbMsjDuracion.setText("");
            lbMsjDuracion.setOpaque(false);
        }
    }//GEN-LAST:event_spHorasStateChanged
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JLabel lbMsjDescripcion;
    private javax.swing.JLabel lbMsjDuracion;
    private javax.swing.JLabel lbMsjFecha;
    private javax.swing.JLabel lbMsjNombre;
    private javax.swing.JLabel lbMsjUrl;
    private javax.swing.JList<String> lstAsignarCategoria;
    private javax.swing.JList<String> lstDuenioVideo;
    private javax.swing.JSpinner spHoras;
    private javax.swing.JSpinner spMinutos;
    private javax.swing.JSpinner spSegundos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
