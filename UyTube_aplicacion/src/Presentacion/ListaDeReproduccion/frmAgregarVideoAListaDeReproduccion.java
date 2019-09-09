package Presentacion.ListaDeReproduccion;

import Logica.DataType.DtCanal;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;


public class frmAgregarVideoAListaDeReproduccion extends javax.swing.JDialog {
    IAdmin sys;
    ArrayList<DtVideo> listaDeVideos;
    ArrayList<DtListaDeReproduccion> listaDeListasRep;
    ArrayList<DtVideo> dtv;
    boolean liberarMemoria;
    public frmAgregarVideoAListaDeReproduccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
  
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();
           
            // lista usuarios en el JList
            listarUsuarios(sys.listarUsuarios());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }
    private void listarUsuarios(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstUsuariosV.setModel(modelo);
        lstUsuariosL.setModel(modelo);
        
    }
   
      private boolean habilitarAceptar(){
         if(!(lstListasRep.isSelectionEmpty() ||
            lstVideos.isSelectionEmpty() ||
            lstUsuariosL.isSelectionEmpty() ||
            lstUsuariosV.isSelectionEmpty()))
         {
             return true;
         }else{
             return false;
         }
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
        lstListasRep.setModel(modelo);
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel21 = new javax.swing.JPanel();
        jScrollPane40 = new javax.swing.JScrollPane();
        lstUsuariosL = new javax.swing.JList<>();
        jScrollPane41 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jScrollPane42 = new javax.swing.JScrollPane();
        lstListasRep = new javax.swing.JList<>();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        btnCancelar = new javax.swing.JButton();
        btnAceptar = new javax.swing.JButton();
        jScrollPane43 = new javax.swing.JScrollPane();
        lstUsuariosV = new javax.swing.JList<>();
        jLabel118 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Agregar video a lista de reproduccion");
        setResizable(false);

        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lstUsuariosL.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosLValueChanged(evt);
            }
        });
        jScrollPane40.setViewportView(lstUsuariosL);

        jPanel21.add(jScrollPane40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 220, 130));

        lstVideos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVideosValueChanged(evt);
            }
        });
        jScrollPane41.setViewportView(lstVideos);

        jPanel21.add(jScrollPane41, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 210, 290));

        lstListasRep.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstListasRepValueChanged(evt);
            }
        });
        jScrollPane42.setViewportView(lstListasRep);

        jPanel21.add(jScrollPane42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 240, 290));

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel115.setText("Seleccionar propietario de lista:");
        jPanel21.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel116.setText("Listas del usuario seleccionado:");
        jPanel21.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 20, -1, -1));

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117.setText("Videos del usuario seleccionado:");
        jLabel117.setToolTipText("");
        jPanel21.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel21.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 220, 40));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Agregar");
        btnAceptar.setEnabled(false);
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel21.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 240, 40));

        lstUsuariosV.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosVValueChanged(evt);
            }
        });
        jScrollPane43.setViewportView(lstUsuariosV);

        jPanel21.add(jScrollPane43, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 130));

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel118.setText("Seleccionar propietario del video:");
        jPanel21.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 790, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel21, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            if (lstUsuariosL.isSelectionEmpty() && lstUsuariosV.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "No ha indicado ningun usuario", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
            if (lstUsuariosL.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el usuario propietario de la lista", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                if (lstUsuariosV.isSelectionEmpty()) {
                    JOptionPane.showMessageDialog(null, "Debe seleccionar el usuario propietario del video", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    if (lstVideos.isSelectionEmpty()) {
                        JOptionPane.showMessageDialog(null, "Debe seleccionar un video para agregar", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (lstListasRep.isSelectionEmpty()) {
                            JOptionPane.showMessageDialog(null, "Debe seleccionar una lista para agregarle el video", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                             
                          
                            int idLista = listaDeListasRep.get(lstListasRep.getSelectedIndex()).getId();
                            String nombreVideo = listaDeVideos.get(lstVideos.getSelectedIndex()).getNombre();
                            String nombreLista = listaDeListasRep.get(lstListasRep.getSelectedIndex()).getNombre();
                            sys.agregarVideoAListaDeReproduccion(idLista);
                            JOptionPane.showMessageDialog(null, "Se ha añadido el video '" + nombreVideo + "' a la lista '" + nombreLista + "'", "Listo", JOptionPane.INFORMATION_MESSAGE);
                            DefaultListModel model = (DefaultListModel) lstListasRep.getModel();
                            model.clear();
                            DefaultListModel model1 = (DefaultListModel) lstVideos.getModel();
                            model1.clear();
                            lstUsuariosL.clearSelection();
                            lstUsuariosV.clearSelection();
                            if(liberarMemoria){
                            sys.liberarMemoriaUsuario();
                            }
                            
                            sys.liberarMemoriaUsuarioActual();
                            sys.liberarMemoriaVideo();
                        }
                    }
                }
            }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        //listaRep->agregarVideo->aceptar
    }//GEN-LAST:event_btnAceptarActionPerformed

    
    private void lstUsuariosVValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosVValueChanged
        if (evt.getValueIsAdjusting()) return;
        if (lstUsuariosV.getSelectedIndex()<0) return;

        try {
            String nick = lstUsuariosV.getSelectedValue();
            DtUsuario dtu = sys.seleccionarUsuario(nick);
            
            listaDeVideos = sys.listarVideosDeUsuario();
            listarVideos(listaDeVideos);
                    btnAceptar.setEnabled(habilitarAceptar());

            
            
                } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }       // TODO add your handling code heres:
    }//GEN-LAST:event_lstUsuariosVValueChanged

    private void lstUsuariosLValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosLValueChanged
if (evt.getValueIsAdjusting()) return;
        if (lstUsuariosL.getSelectedIndex()<0) return;

        try {
            String nick = lstUsuariosL.getSelectedValue();
            DtUsuario dtu = sys.seleccionarUsuarioActual(nick);
            DtCanal dtc = sys.obtenerCanalDeUsuario();
            
            listaDeListasRep = sys.listarListasDeReproduccionDeUsuario(nick);
            listarListassRep(listaDeListasRep);
                    btnAceptar.setEnabled(habilitarAceptar());

            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_lstUsuariosLValueChanged

    private void lstVideosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVideosValueChanged
         try {
             if(!(lstVideos.isSelectionEmpty())){
             int idVideo = listaDeVideos.get(lstVideos.getSelectedIndex()).getId();
                     btnAceptar.setEnabled(habilitarAceptar());

             sys.seleccionarVideo(idVideo);
             
             }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_lstVideosValueChanged

    private void lstListasRepValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstListasRepValueChanged
        btnAceptar.setEnabled(habilitarAceptar());
 
        
        // TODO add your handling code here:    }//GEN-LAST:event_lstListasRepValueChanged
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JList<String> lstListasRep;
    private javax.swing.JList<String> lstUsuariosL;
    private javax.swing.JList<String> lstUsuariosV;
    private javax.swing.JList<String> lstVideos;
    // End of variables declaration//GEN-END:variables
}
