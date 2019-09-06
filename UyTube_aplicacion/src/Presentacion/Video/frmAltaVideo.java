
package Presentacion.Video;

import Logica.Clases.Fabrica;
import Logica.Clases.Video;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Interfaces.IAdmin;
import java.awt.Color;
import java.sql.Time;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

public class frmAltaVideo extends javax.swing.JDialog {
    
    public DefaultListModel listModelUsuario = new DefaultListModel();
    public DefaultListModel listModelCategoria = new DefaultListModel();
    Fabrica fabrica = Fabrica.getInstancia();
    IAdmin sys = fabrica.getIAdmin();    
    private String categoria = "";
    private String usrSeleccionado = "";
    Border bordeDefault;
    Color colorOK = new ColorUIResource(40,167,69);
    Color colorError = new ColorUIResource(220,53,69);
    // Patrón para validar el email
    Pattern patronURL = Pattern.compile("\"(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?\"");
    
    public frmAltaVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    private void limpiarCampos(){
        txtNombre.setText("");
        txtDescripcion.setText("");
        txtUrl.setText("");
        spHora.setValue(0);
        spMinuto.setValue(0);
        spSegundos.setValue(0);
        usrSeleccionado="";
        categoria = "";
        jDateChooser1.setDate(null);
    }
    
    private void limpiarListas(){
        listModelUsuario.clear();//Limpia la listaModeloUsuario
        lstDuenioVideo.setModel(listModelUsuario); //Borra todos los datos del JList DuenioVideo
        listModelCategoria.clear();//Limpia el modeo de Categorias
        lstAsignarCategoria.setModel(listModelCategoria);
    }
    
    private boolean validarFormatoURL(String _url){
        Matcher mather = patronURL.matcher(_url); 
        if (mather.find() == true) {
            return true;
        } 
        return false;        
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
        jLabel78 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        spSegundos = new javax.swing.JSpinner();
        spHora = new javax.swing.JSpinner();
        spMinuto = new javax.swing.JSpinner();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        lbMensajeNombre = new javax.swing.JLabel();
        lbMensajeUrl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta video");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowDeactivated(java.awt.event.WindowEvent evt) {
                formWindowDeactivated(evt);
            }
        });

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel71.setText("Dueño del video:");
        jPanel14.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstDuenioVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDuenioVideoMouseClicked(evt);
            }
        });
        jScrollPane16.setViewportView(lstDuenioVideo);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 370));

        jLabel72.setText("Nombre:");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 30, -1, -1));

        jLabel73.setText("Segundos");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 100, -1, -1));

        jLabel74.setText("URL:");
        jPanel14.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel75.setText("Descripción:");
        jPanel14.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 210, -1, -1));

        jLabel76.setText("Fecha publicación:");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 400, -1, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel77.setText("Asignar categoría:");
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        lstAsignarCategoria.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstAsignarCategoriaMouseClicked(evt);
            }
        });
        jScrollPane17.setViewportView(lstAsignarCategoria);

        jPanel14.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 260, 360));

        jLabel78.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        jLabel78.setText("(Opcional)");
        jPanel14.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, -1, -1));
        jPanel14.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, 330, -1));
        jPanel14.add(txtUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 170, 330, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane18.setViewportView(txtDescripcion);

        jPanel14.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 230, 330, 140));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel14.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 260, 70));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 290, 70));
        jPanel14.add(spSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 120, 60, -1));
        jPanel14.add(spHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 120, 60, -1));
        jPanel14.add(spMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 120, 60, -1));

        jLabel135.setText("Duración:");
        jPanel14.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 100, -1, -1));

        jLabel136.setText("Horas");
        jPanel14.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 100, -1, -1));

        jLabel137.setText("Minutos");
        jPanel14.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 100, -1, -1));
        jPanel14.add(jDateChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 400, 110, -1));

        lbMensajeNombre.setMaximumSize(new java.awt.Dimension(0, 15));
        lbMensajeNombre.setMinimumSize(new java.awt.Dimension(0, 15));
        jPanel14.add(lbMensajeNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 260, 15));
        jPanel14.add(lbMensajeUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, 330, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        String nombre = txtNombre.getText().trim();//Obtiene el nombre y quita los espacios de los extremos
        String descripcion = txtDescripcion.getText().trim();//Obtiene la descripcion y quita los espacios de los extremos
        String url = txtUrl.getText().trim();//Obtiene la url y quita los espacios de los extremos
        int horas = (Integer)spHora.getValue();
        int minutos = (Integer)spMinuto.getValue();
        int segundos = (Integer)spSegundos.getValue();
        Time duracion = new Time(horas, minutos, segundos);
        java.sql.Date fecha = null;
        //Verifica que la fecha no sea nula y la guarda en el formato correcto
        if( jDateChooser1.getDate() != null){
            java.util.Date utilDate = jDateChooser1.getDate();//Obtiene la fecha del JDateChooser en formato Date        
            fecha = new java.sql.Date(utilDate.getTime());//Lo combierte al tipo Date sql
        }        
        try {
            DtVideo dtVideo = new DtVideo(Video.getNuevoId(), nombre, descripcion, duracion, fecha, url, Privacidad.PRIVADO, categoria, 0, 0);
            int opcion=JOptionPane.showConfirmDialog(null, 
                        "Desea guardar el video con los siguientes datos?\n"+
                            "Usuario: "+usrSeleccionado+"\n"+
                            "Nombre: "+nombre+"\n"+
                            "Descripción: "+descripcion+"\n"+
                            "Duración: "+duracion+"\n"+
                            "fecha de publicacón: "+fecha
                        , "Confirmar alt de Video", JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE);
            if(opcion==0)
                sys.altaVideo(dtVideo);
                limpiarCampos();
                
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        limpiarListas();
        limpiarCampos();
        this.setVisible(false);//Oculta el formulario AltaVideo
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        // Obtengo todos los nickname y los cargo en el listDuenioVideo(Lista de dueños de videos)
        limpiarListas();
        if(!sys.listarUsuarios().isEmpty()){
            for (int i = 0; i < sys.listarUsuarios().size(); i++) {
                listModelUsuario.add(i,sys.listarUsuarios().get(i).getNickname());
            }
            lstDuenioVideo.setModel(listModelUsuario);                  
        }         
        // Obtengo todas las categorias de video y las muestro en la lista
        if(!sys.listarCategorias().isEmpty()){
            for(int i = 0; i < sys.listarCategorias().size(); i++){
                listModelCategoria.add(i, sys.listarCategorias().get(i));
            }
            lstAsignarCategoria.setModel(listModelCategoria);
        }               
    }//GEN-LAST:event_formWindowActivated

    private void lstDuenioVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDuenioVideoMouseClicked
        // El sistema selecciona al usuario actual con el nickname seleccionado de la lista 
        usrSeleccionado = lstDuenioVideo.getSelectedValue();
        sys.seleccionarUsuario(usrSeleccionado);
    }//GEN-LAST:event_lstDuenioVideoMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Al cerrar el formulario se borran todos los datos
        limpiarCampos();
        limpiarListas();
    }//GEN-LAST:event_formWindowClosing

    private void lstAsignarCategoriaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstAsignarCategoriaMouseClicked
        // Selecciona una categoria de la lista de categorias
        categoria = lstAsignarCategoria.getSelectedValue();
    }//GEN-LAST:event_lstAsignarCategoriaMouseClicked

    private void formWindowDeactivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowDeactivated
        // Al abrise el cuadro de dialogo se desactiva el formulario se limpian los datos de las listas
//        listModelUsuario.clear();//Limpia la listaModeloUsuario
//        lstDuenioVideo.setModel(listModelUsuario); //Borra todos los datos del JList DuenioVideo
//        listModelCategoria.clear();//Limpia el modeo de Categorias
//        lstAsignarCategoria.setModel(listModelCategoria);
    }//GEN-LAST:event_formWindowDeactivated
    
    
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
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JLabel lbMensajeNombre;
    private javax.swing.JLabel lbMensajeUrl;
    private javax.swing.JList<String> lstAsignarCategoria;
    private javax.swing.JList<String> lstDuenioVideo;
    private javax.swing.JSpinner spHora;
    private javax.swing.JSpinner spMinuto;
    private javax.swing.JSpinner spSegundos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
