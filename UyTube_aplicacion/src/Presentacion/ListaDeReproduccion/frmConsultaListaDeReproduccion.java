package Presentacion.ListaDeReproduccion;

import Logica.DataType.*;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmConsultaListaDeReproduccion extends javax.swing.JDialog {
    Fabrica f = Fabrica.getInstancia();
    IAdmin Sys = f.getIAdmin();
    ArrayList<DtListaDeReproduccion> ListasDeReproducion;
    public frmConsultaListaDeReproduccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();
        DefaultListModel modeloUsuario = new DefaultListModel();
        
        for (DtUsuario it : ListaUsuarios) {
            modeloUsuario.addElement(it.getNickname());
        }
        lstUsuarios.setModel(modeloUsuario);
        
        
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
        btnConsultarVideo = new javax.swing.JButton();
        lbTipo = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbPrivacidad = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar lista de reproduccion");

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

        lstUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstUsuariosMouseClicked(evt);
            }
        });
        jScrollPane37.setViewportView(lstUsuarios);

        jPanel20.add(jScrollPane37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 320));

        jScrollPane38.setViewportView(lstVideos);

        jPanel20.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 240, 320));

        jLabel108.setText("Nombre:");
        jPanel20.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel109.setText("Privacidad:");
        jPanel20.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel110.setText("Tipo:");
        jPanel20.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("Videos:");
        jPanel20.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        lstListasRep.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstListasRepMouseClicked(evt);
            }
        });
        jScrollPane39.setViewportView(lstListasRep);

        jPanel20.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 260, 320));

        btnConsultarVideo.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        btnConsultarVideo.setText("Consultar video");
        btnConsultarVideo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnConsultarVideoMouseClicked(evt);
            }
        });
        jPanel20.add(btnConsultarVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 380, 200, 60));

        lbTipo.setText(" ");
        jPanel20.add(lbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 380, 150, -1));

        lbNombre.setText(" ");
        jPanel20.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 200, -1));

        lbPrivacidad.setText(" ");
        jPanel20.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 420, 150, -1));

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
       Sys.liberarMemoriaListaDeReproduccion();
       Sys.liberarMemoriaUsuario();
       Sys.liberarMemoriaVideo();
       
       lstListasRep.clearSelection();
       lstUsuarios.clearSelection();
       lstVideos.clearSelection();
       lbNombre.setText("");
       lbPrivacidad.setText("");
       lbTipo.setText("");
       
       dispose();
               
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void btnConsultarVideoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnConsultarVideoMouseClicked
        
        dispose();
    }//GEN-LAST:event_btnConsultarVideoMouseClicked

    private void lstUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstUsuariosMouseClicked
         try {
            DtUsuario dtUsu = Sys.seleccionarUsuario(lstUsuarios.getSelectedValue());
            
            ListasDeReproducion = Sys.listarListasDeReproduccionDeUsuario(dtUsu.getNickname());
            
            DefaultListModel modelo = new DefaultListModel();

            for (DtListaDeReproduccion it : ListasDeReproducion) {
                modelo.addElement(it.getNombre());
            }
            lstListasRep.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(String)e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstUsuariosMouseClicked

    private void lstListasRepMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstListasRepMouseClicked
         try {
            
            DtListaDeReproduccion dtLista = ListasDeReproducion.get(lstListasRep.getSelectedIndex());
            int IDLista = dtLista.getId();
            Sys.seleccionarListaDeReproduccion(IDLista);
            lbNombre.setText("  "+dtLista.getNombre());
            lbPrivacidad.setText("  "+dtLista.getPrivacidad().toString());
            lbTipo.setText("  "+dtLista.getTipo().toString());
            
            ArrayList<DtVideo> Listavideos = Sys.listarVideosDeListaDeReproduccion();
            DefaultListModel modelo = new DefaultListModel();
            for (DtVideo it : Listavideos) {
                modelo.addElement(it.getNombre());
            }
            lstVideos.setModel(modelo);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(String)e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstListasRepMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnConsultarVideo;
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
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JList<String> lstListasRep;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JList<String> lstVideos;
    // End of variables declaration//GEN-END:variables
}
