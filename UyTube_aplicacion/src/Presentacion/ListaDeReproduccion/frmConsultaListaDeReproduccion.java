package Presentacion.ListaDeReproduccion;

import Logica.DataType.*;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Presentacion.Video.frmConsultaVideo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmConsultaListaDeReproduccion extends javax.swing.JDialog {

    Fabrica f = Fabrica.getInstancia();
    IAdmin Sys = f.getIAdmin();
    ArrayList<DtListaDeReproduccion> ListasDeReproducion;
    ArrayList<DtVideo> Listavideos;
    boolean liberarMemoria;
    
    public frmConsultaListaDeReproduccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        liberarMemoria = true;
        try {
            initComponents();
            this.setLocationRelativeTo(null);

            ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();
            DefaultListModel modeloUsuario = new DefaultListModel();

            for (DtUsuario it : ListaUsuarios) {
                modeloUsuario.addElement(it.getNickname());
            }
            lstUsuarios.setModel(modeloUsuario);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public frmConsultaListaDeReproduccion(javax.swing.JDialog parent, boolean modal,String nickname, int idListaVideo) {
        super(parent, modal);
        liberarMemoria = false;
        try {
            initComponents();
            this.setLocationRelativeTo(null);

            ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();
            DefaultListModel modeloUsuario = new DefaultListModel();

            for (DtUsuario it : ListaUsuarios) {
                modeloUsuario.addElement(it.getNickname());
            }
            lstUsuarios.setModel(modeloUsuario);

            lstUsuarios.setSelectedValue(nickname, true);

            lstListasRep.setSelectedValue(Sys.seleccionarListaDeReproduccion(idListaVideo).getNombre(), true);
            lstListasRep.setEnabled(false);
            lstUsuarios.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel20 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        jScrollPane38 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        lstListasRep = new javax.swing.JList<>();
        lbTipo = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbPrivacidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar lista de reproduccion");
        setResizable(false);

        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        jPanel20.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 380, 240, 60));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("Usuario");
        jPanel20.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel107.setText("Listas de Reproduccion:");
        jPanel20.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        lstUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosValueChanged(evt);
            }
        });
        jScrollPane37.setViewportView(lstUsuarios);

        jPanel20.add(jScrollPane37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 320));

        lstVideos.setToolTipText("Doble clic para ver mas informacion de video");
        lstVideos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstVideosMouseClicked(evt);
            }
        });
        jScrollPane38.setViewportView(lstVideos);

        jPanel20.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 240, 320));

        jLabel108.setText("Categoria:");
        jPanel20.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel109.setText("Privacidad:");
        jPanel20.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel110.setText("Tipo:");
        jPanel20.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("Videos:");
        jPanel20.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        lstListasRep.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstListasRepValueChanged(evt);
            }
        });
        jScrollPane39.setViewportView(lstListasRep);

        jPanel20.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 260, 320));

        lbTipo.setText(" ");
        jPanel20.add(lbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 150, -1));

        lbCategoria.setText(" ");
        jPanel20.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 200, -1));

        lbPrivacidad.setText(" ");
        jPanel20.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 150, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        if (liberarMemoria){
            Sys.liberarMemoriaUsuario();
        }
        Sys.liberarMemoriaListaDeReproduccion();
        Sys.liberarMemoriaVideo();

        lstListasRep.clearSelection();
        lstUsuarios.clearSelection();
        lstVideos.clearSelection();
        lbCategoria.setText("");
        lbPrivacidad.setText("");
        lbTipo.setText("");

        dispose();

    }//GEN-LAST:event_btnAceptarMouseClicked

    private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosValueChanged
        //Cuando se seleccione algo el lstUsuarios
        if (evt.getValueIsAdjusting()) return;
        if (lstUsuarios.getSelectedIndex()<0) return;
        lstVideos.setModel(new DefaultListModel());
        try {
            DtUsuario dtUsu = Sys.seleccionarUsuario(lstUsuarios.getSelectedValue());

            ListasDeReproducion = Sys.listarListasDeReproduccionDeUsuario(dtUsu.getNickname());

            DefaultListModel modelo = new DefaultListModel();

            for (DtListaDeReproduccion it : ListasDeReproducion) {
                modelo.addElement(it.getNombre());
            }
            lstListasRep.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstUsuariosValueChanged

    private void lstListasRepValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstListasRepValueChanged
        if (evt.getValueIsAdjusting()) return;
        if (lstListasRep.getSelectedIndex()<0) return;
        
        
        try {

            DtListaDeReproduccion dtLista = ListasDeReproducion.get(lstListasRep.getSelectedIndex());
            int IDLista = dtLista.getId();
            Sys.seleccionarListaDeReproduccion(IDLista);
            lbCategoria.setText("  " + dtLista.getCategoria());
            lbPrivacidad.setText("  " + dtLista.getPrivacidad().toString());
            if (dtLista.getTipo().toString() == "POR_DEFECTO") {
                lbTipo.setText("  " + "POR DEFECTO");
            }
            if (dtLista.getTipo().toString() == "PARTICULAR") {
                lbTipo.setText("  " + "PARTICULAR");
            }

            Listavideos = Sys.listarVideosDeListaDeReproduccion();
            DefaultListModel modelo = new DefaultListModel();
            for (DtVideo it : Listavideos) {
                modelo.addElement(it.getNombre());
            }
            lstVideos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, (String) e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstListasRepValueChanged

    private void lstVideosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstVideosMouseClicked
        if (evt.getClickCount() != 2) return;
        if (lstVideos.getSelectedIndex()<0) return;

        int indexSeleccionado = lstVideos.getSelectedIndex();
        int idVideo = Listavideos.get(indexSeleccionado).getId();
        
        new frmConsultaVideo(this, true, lstUsuarios.getSelectedValue(), idVideo).setVisible(true);
    }//GEN-LAST:event_lstVideosMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JList<String> lstListasRep;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JList<String> lstVideos;
    // End of variables declaration//GEN-END:variables
}
