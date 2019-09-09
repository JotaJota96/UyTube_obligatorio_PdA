package Presentacion.Usuario;

import Presentacion.ListaDeReproduccion.*;
import Logica.DataType.DtCanal;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Presentacion.Video.frmConsultaVideo;
import java.awt.Image;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class frmConsultaUsuario extends javax.swing.JDialog {

    IAdmin sys;
    ArrayList<DtVideo> listaDeVideos;
    ArrayList<DtListaDeReproduccion> listaDeListasRep;
    
    public frmConsultaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            cargarImagenEnJlabel(lbImagen, "");
            lbImagen.setEnabled(false);
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

        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lbImagen = new javax.swing.JLabel();
        lbFechaN = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbCantSeguidores = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        lbPrivacidad = new javax.swing.JLabel();
        lbNombreCanal = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstSeguidos = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstSeguidores = new javax.swing.JList<>();
        btnAceptar = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        lstListaReproduccion = new javax.swing.JList<>();
        lbNickName = new javax.swing.JLabel();
        lbCantSeguidos = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta usuario");
        setResizable(false);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Seleccione un usuario:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstUsuarios);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, 250));

        jLabel18.setText("Usuario:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 60, -1, -1));

        jLabel19.setText("Nombre:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 90, -1, -1));

        jLabel20.setText("Apellido:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 120, -1, -1));

        jLabel21.setText("Email:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 150, -1, -1));

        jLabel22.setText("Nacimiento: ");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 180, -1, -1));

        jLabel23.setText("Imágen:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 100, 100));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 215, 110, 110));
        jPanel6.add(lbFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 180, 200, 20));

        lbEmail.setText(" ");
        jPanel6.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 150, 200, 20));

        lbApellido.setText(" ");
        jPanel6.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 120, 200, -1));

        lbNombre.setText(" ");
        jPanel6.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 90, 200, -1));

        lbCantSeguidores.setText(" ");
        jPanel6.add(lbCantSeguidores, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 20, 100, -1));
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 530, 10));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Canal:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel32.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel32.setText("Descripción:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane5.setViewportView(txtDescripcion);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 430, 390, 100));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 0, 10, 560));

        lbPrivacidad.setText(" ");
        jPanel6.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 390, 110, -1));

        lbNombreCanal.setText(" ");
        jPanel6.add(lbNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 360, 110, -1));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 230, 460, 10));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Seguidores:");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Seguidos:");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        jScrollPane8.setViewportView(lstSeguidos);

        jPanel6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 180, 150));

        jScrollPane9.setViewportView(lstSeguidores);

        jPanel6.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 190, 150));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 480, 410, 50));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("Videos:");
        jPanel6.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 240, -1, -1));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("Listas de Reproducción:");
        jPanel6.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 240, -1, -1));

        lstVideos.setToolTipText("Doble clic para ver mas informacion del video");
        lstVideos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstVideosMouseClicked(evt);
            }
        });
        jScrollPane20.setViewportView(lstVideos);

        jPanel6.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 270, 200, 190));

        lstListaReproduccion.setToolTipText("Doble clic para ver mas informacion de la lista");
        lstListaReproduccion.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstListaReproduccionMouseClicked(evt);
            }
        });
        jScrollPane21.setViewportView(lstListaReproduccion);

        jPanel6.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 272, 190, 190));

        lbNickName.setText(" ");
        jPanel6.add(lbNickName, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 60, 200, -1));

        lbCantSeguidos.setText(" ");
        jPanel6.add(lbCantSeguidos, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 20, 100, -1));

        jLabel31.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel31.setText("Privacidad:");
        jPanel6.add(jLabel31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosValueChanged
        // Al seleccionar un usuario
        if (evt.getValueIsAdjusting()) return;
        if (lstUsuarios.getSelectedIndex()<0) return;

        try {
            String nick = lstUsuarios.getSelectedValue();
            DtUsuario dtu = sys.seleccionarUsuario(nick);
            cargarLabelsConDatosDelUsuario(dtu);
            DtCanal dtc = sys.obtenerCanalDeUsuario();
            cargarLabelsConDatosDelCanal(dtc);
            
            listaDeVideos = sys.listarVideosDeUsuario();
            listarVideos(listaDeVideos);
            listaDeListasRep = sys.listarListasDeReproduccionDeUsuario(nick);
            listarListassRep(listaDeListasRep);
            listarUsuariosSeguidores(sys.listarUsuarioSeguidores());
            listarUsuariosSeguidos(sys.listarUsuarioSeguidos());
            
             sys.liberarMemoriaUsuario();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_lstUsuariosValueChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
         try {
             sys.liberarMemoriaUsuario();
             dispose();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lstVideosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstVideosMouseClicked
        // Doble clic en la lista de videos
        if (evt.getClickCount() != 2) return;
        if (lstVideos.getSelectedIndex()<0) return;

        int indexSeleccionado = lstVideos.getSelectedIndex();
        int idVideo = listaDeVideos.get(indexSeleccionado).getId();
        new frmConsultaVideo(this, true, lstUsuarios.getSelectedValue(), idVideo).setVisible(true);
    }//GEN-LAST:event_lstVideosMouseClicked

    private void lstListaReproduccionMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstListaReproduccionMouseClicked
        // Doble clic en la lista de Listas de reproduccion
        if (evt.getClickCount() != 2) return;
        if (lstListaReproduccion.getSelectedIndex()<0) return;

        int indexSeleccionado = lstListaReproduccion.getSelectedIndex();
        int idLista = listaDeListasRep.get(indexSeleccionado).getId();
        new frmConsultaListaDeReproduccion(this, true, lstUsuarios.getSelectedValue(), idLista).setVisible(true);
    }//GEN-LAST:event_lstListaReproduccionMouseClicked
    
    ///////////////////////////////////////////////////////////////////////////////////////////
    private void listarUsuarios(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstUsuarios.setModel(modelo);
        
    }
    private void listarVideos(ArrayList<DtVideo> ListaVideos){
        DefaultListModel modelo = new DefaultListModel();
        for (DtVideo it : ListaVideos) {
            modelo.addElement(it.getNombre());
        }
        lstVideos.setModel(modelo);
    }
    private void listarListassRep(ArrayList<DtListaDeReproduccion> listaListasRep){
        DefaultListModel modelo = new DefaultListModel();
        for (DtListaDeReproduccion it : listaListasRep) {
            modelo.addElement(it.getNombre());
        }
        lstListaReproduccion.setModel(modelo);
    }
    
    private void listarUsuariosSeguidos(ArrayList<DtUsuario> ListaUsuarios){
        lbCantSeguidos.setText(String.valueOf(ListaUsuarios.size()));
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstSeguidos.setModel(modelo);
    }
    private void listarUsuariosSeguidores(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstSeguidores.setModel(modelo);
    }
    private void cargarLabelsConDatosDelUsuario(DtUsuario u){
        lbNickName.setText(u.getNickname());
        lbNombre.setText(u.getNombre());
        lbApellido.setText(u.getApellido());
        lbEmail.setText(u.getCorreo());
        lbFechaN.setText(new SimpleDateFormat("dd-MM-yyyy").format(u.getFechaNacimiento()));
        lbCantSeguidores.setText(String.valueOf(u.getCantSeguidores()));
        cargarImagenEnJlabel(lbImagen, u.getImagen());
        lbImagen.setEnabled(true);
    }
    private void cargarLabelsConDatosDelCanal(DtCanal c){
        lbNombreCanal.setText(c.getNombre());
        txtDescripcion.setText(c.getDescripcion());
        if (c.getPrivacidad() == Privacidad.PUBLICO){
            lbPrivacidad.setText("Publico");
        }else{
            lbPrivacidad.setText("Privado");
        }
    }
    private void cargarImagenEnJlabel(javax.swing.JLabel jLabelx, String Ruta){
        jLabelx.setText(null);
        if (Ruta == null || Ruta.isEmpty()){
            Ruta = "Imagenes\\ukp.png";
        }
        // Carga la imagen a la variable de tipo Image
        Image img = new ImageIcon(Ruta).getImage();
        // Crea un ImageIcon a partir de la imagen (obtiene las dimenciones del jLbel y escala la imagen para que entre en el mismo)
        ImageIcon icono = new ImageIcon(
                img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH)
        );
        // establece la imagen en el label
        jLabelx.setIcon(icono);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCantSeguidores;
    private javax.swing.JLabel lbCantSeguidos;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFechaN;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JLabel lbNickName;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreCanal;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JList<String> lstListaReproduccion;
    private javax.swing.JList<String> lstSeguidores;
    private javax.swing.JList<String> lstSeguidos;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JList<String> lstVideos;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
