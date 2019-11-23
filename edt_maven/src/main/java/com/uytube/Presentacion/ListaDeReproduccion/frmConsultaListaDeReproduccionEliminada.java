package com.uytube.Presentacion.ListaDeReproduccion;

import com.uytube.Logica.DataType.*;
import com.uytube.Logica.Enumerados.TipoListaDeReproduccion;
import com.uytube.Logica.Enumerados.TipoValoracion;
import com.uytube.Logica.Fabrica;
import com.uytube.Logica.Interfaces.IAdmin;
import com.uytube.Presentacion.Video.frmConsultaVideo;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmConsultaListaDeReproduccionEliminada extends javax.swing.JDialog {

    Fabrica f = Fabrica.getInstancia();
    IAdmin Sys = f.getIAdmin();
    ArrayList<DtVideo> Listavideos;
    
    public frmConsultaListaDeReproduccionEliminada(javax.swing.JDialog parent, boolean modal, int idLista) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        try {
            // obtiene los datos de la lista a mostrar
            DtListaDeReproduccion dtLista = Sys.seleccionarListaDeReproduccion(idLista);
            ArrayList<DtVideo> listaVideos = Sys.listarVideosDeListaDeReproduccion();
            
            // Lista los videos que contiene la lista de reproduccion
            DefaultListModel modeloUsuario = new DefaultListModel();
            for (DtVideo it : listaVideos) {
                modeloUsuario.addElement(it.getNombre());
            }
            lstVideos.setModel(modeloUsuario);

            // carga los datos de la lista en los labels
            lbNombre.setText(dtLista.getNombre());
            lbCategoria.setText(dtLista.getCategoria());
            lbPrivacidad.setText(dtLista.getPrivacidad().toString());
            if (dtLista.getTipo() == TipoListaDeReproduccion.POR_DEFECTO) {
                lbTipo.setText("POR DEFECTO");
            }
            if (dtLista.getTipo() == TipoListaDeReproduccion.PARTICULAR) {
                lbTipo.setText("PARTICULAR");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel20 = new javax.swing.JPanel();
        btnAceptar = new javax.swing.JButton();
        jScrollPane38 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        lbTipo = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        lbPrivacidad = new javax.swing.JLabel();
        jLabel112 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();

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
        jPanel20.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 290, 60));

        lstVideos.setToolTipText("Doble clic para ver mas informacion de video");
        jScrollPane38.setViewportView(lstVideos);

        jPanel20.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 290, 210));

        jLabel108.setText("Categoría:");
        jPanel20.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel109.setText("Privacidad:");
        jPanel20.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, -1, -1));

        jLabel110.setText("Nombre:");
        jPanel20.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("Videos de la lista:");
        jPanel20.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbTipo.setText(" ");
        jPanel20.add(lbTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 40, 210, -1));

        lbCategoria.setText(" ");
        jPanel20.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 80, 210, -1));

        lbPrivacidad.setText(" ");
        jPanel20.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 60, 210, -1));

        jLabel112.setText("Tipo:");
        jPanel20.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, -1));

        lbNombre.setText(" ");
        jPanel20.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 20, 210, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel20, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        dispose();
    }//GEN-LAST:event_btnAceptarMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbTipo;
    private javax.swing.JList<String> lstVideos;
    // End of variables declaration//GEN-END:variables
}
