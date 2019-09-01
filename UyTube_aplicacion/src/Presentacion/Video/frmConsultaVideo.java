
package Presentacion.Video;

import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmConsultaVideo extends javax.swing.JDialog {

    IAdmin sys;
    
    public frmConsultaVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();

            // lista usuarios en el JList
            listarUsuarios(sys.listarUsuarios());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    private void listarUsuarios(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        ListaUsuarios.forEach((it) -> {
            modelo.addElement(it.getNickname());
            // a que te dejo re loco este for
        });
        lstDuenioVideo.setModel(modelo);
        
    }
    private void listarVideos(ArrayList<DtVideo> listaVideos){
        DefaultListModel modelo = new DefaultListModel();
        for (DtVideo it : listaVideos) {
            modelo.addElement(it.getNombre());
        }
        lstVideoUsuario.setModel(modelo);
    }
    private void mostrarDatosDeVideo(DtVideo v){
        lbNombre.setText(v.getNombre());
        lbDuracion.setText(v.getDuracion().toString());
        lbUrl.setText(v.getUrlVideoOriginal());
        lbPrivacidad.setText(v.getPrivacidad().toString());
        lbCategoria.setText(v.getCategoria());
        txtDescripcion.setText(v.getDescripcion());
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        lstDuenioVideo = new javax.swing.JList<>();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        lstVideoUsuario = new javax.swing.JList<>();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbDuracion = new javax.swing.JLabel();
        lbUrl = new javax.swing.JLabel();
        lbPrivacidad = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        lstLike = new javax.swing.JList<>();
        jScrollPane26 = new javax.swing.JScrollPane();
        lstDislike = new javax.swing.JList<>();
        jScrollPane27 = new javax.swing.JScrollPane();
        treeComentarios = new javax.swing.JTree();
        jLabel99 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar video");

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Dueño del video:");
        jPanel15.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstDuenioVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstDuenioVideoMouseClicked(evt);
            }
        });
        jScrollPane22.setViewportView(lstDuenioVideo);

        jPanel15.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, 300));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Comentarios:");
        jPanel15.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        lstVideoUsuario.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstVideoUsuarioMouseClicked(evt);
            }
        });
        jScrollPane23.setViewportView(lstVideoUsuario);

        jPanel15.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 160, 300));

        jLabel83.setText("Nombre:");
        jPanel15.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel84.setText("Duración:");
        jPanel15.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel85.setText("URL:");
        jPanel15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel86.setText("Descripción:");
        jPanel15.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane24.setViewportView(txtDescripcion);

        jPanel15.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 270, 130));

        jLabel87.setText("Privacidad:");
        jPanel15.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        jLabel88.setText("Categoria:");
        jPanel15.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        lbNombre.setText(" ");
        jPanel15.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 220, -1));

        lbDuracion.setText(" ");
        jPanel15.add(lbDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 170, -1));

        lbUrl.setText(" ");
        jPanel15.add(lbUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 180, -1));

        lbPrivacidad.setText(" ");
        jPanel15.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 170, -1));

        lbCategoria.setText(" ");
        jPanel15.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 170, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel15.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 480, 280, 60));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("Les gusto:");
        jPanel15.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("No les gusto:");
        jPanel15.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));

        jScrollPane25.setViewportView(lstLike);

        jPanel15.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 290, 140));

        jScrollPane26.setViewportView(lstDislike);

        jPanel15.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, 300, 140));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeComentarios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane27.setViewportView(treeComentarios);

        jPanel15.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 280, 420));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setText("Video del Usuario:");
        jPanel15.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       // boton aceptar
       
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lstDuenioVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstDuenioVideoMouseClicked
        // seleccionar usuario 
        try {
            lstVideoUsuario.clearSelection();
            String nick = lstDuenioVideo.getSelectedValue();
             sys.seleccionarUsuario(nick);
            listarVideos(sys.listarVideosDeUsuario());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstDuenioVideoMouseClicked

    private void lstVideoUsuarioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstVideoUsuarioMouseClicked
        // seleccionar video
        try {
            int idVideo = lstVideoUsuario.getSelectedIndex() +1;
            DtVideo dtv = sys.seleccionarVideo(idVideo);
            mostrarDatosDeVideo(dtv);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }    }//GEN-LAST:event_lstVideoUsuarioMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JList<String> lstDislike;
    private javax.swing.JList<String> lstDuenioVideo;
    private javax.swing.JList<String> lstLike;
    private javax.swing.JList<String> lstVideoUsuario;
    private javax.swing.JTree treeComentarios;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
