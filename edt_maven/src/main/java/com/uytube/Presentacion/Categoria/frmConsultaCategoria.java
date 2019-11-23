
package com.uytube.Presentacion.Categoria;

import com.uytube.Logica.DataType.*;
import com.uytube.Logica.Fabrica;
import com.uytube.Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmConsultaCategoria extends javax.swing.JDialog {
    Fabrica f = Fabrica.getInstancia();
    IAdmin Sys = f.getIAdmin();
    String CategoriaActual;
    public frmConsultaCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            ArrayList<String> ListaCategorias = Sys.listarCategorias();
            DefaultListModel modelo = new DefaultListModel();

            for (String it : ListaCategorias) {
                modelo.addElement(it);
            }
            lstCategorias.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel25 = new javax.swing.JPanel();
        cmdAceptar = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jScrollPane47 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        jLabel124 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        lstListaReproducion = new javax.swing.JList<>();
        jLabel125 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar categoria");
        setResizable(false);

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmdAceptar.setText("Aceptar");
        cmdAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cmdAceptarMouseClicked(evt);
            }
        });
        cmdAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAceptarActionPerformed(evt);
            }
        });
        jPanel25.add(cmdAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(543, 323, 220, 70));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel123.setText("Categorías:");
        jPanel25.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        lstCategorias.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstCategoriasValueChanged(evt);
            }
        });
        jScrollPane47.setViewportView(lstCategorias);

        jPanel25.add(jScrollPane47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 350));

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel124.setText("Videos:");
        jPanel25.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jScrollPane48.setViewportView(lstListaReproducion);

        jPanel25.add(jScrollPane48, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 240, 350));

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel125.setText("List. Reproducción:");
        jPanel25.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jScrollPane49.setViewportView(lstVideos);

        jPanel25.add(jScrollPane49, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 210, 280));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel25, javax.swing.GroupLayout.PREFERRED_SIZE, 410, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmdAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmdAceptarActionPerformed
       
    }//GEN-LAST:event_cmdAceptarActionPerformed

    private void cmdAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cmdAceptarMouseClicked
        dispose();
    }//GEN-LAST:event_cmdAceptarMouseClicked

    private void lstCategoriasValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstCategoriasValueChanged
       try {
            CategoriaActual = lstCategorias.getSelectedValue();
            
            //Lista la listas de reproduccion de la categoria seleccionada 
            ArrayList<DtListaDeReproduccion> ListaRDeCategoria = Sys.listarListasDeReproduccionEnCategoria(CategoriaActual);
            DefaultListModel modeloLR = new DefaultListModel();
        
            for (DtListaDeReproduccion it : ListaRDeCategoria) {
                modeloLR.addElement(it.getNombre());
            }
            lstListaReproducion.setModel(modeloLR);
            
            //Lista los Videos de la categoria
            ArrayList<DtVideo> VideosCategoria = Sys.listarVideosEnCategoria(CategoriaActual);
            DefaultListModel modeloV = new DefaultListModel();
        
            for (DtVideo it : VideosCategoria) {
                modeloV.addElement(it.getNombre());
            }
        lstVideos.setModel(modeloV);
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,(String)e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_lstCategoriasValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cmdAceptar;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JList<String> lstListaReproducion;
    private javax.swing.JList<String> lstVideos;
    // End of variables declaration//GEN-END:variables
}
