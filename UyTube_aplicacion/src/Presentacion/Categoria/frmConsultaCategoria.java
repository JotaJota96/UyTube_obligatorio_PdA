
package Presentacion.Categoria;

public class frmConsultaCategoria extends javax.swing.JDialog {

    public frmConsultaCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
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

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cmdAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        cmdAceptar.setText("Aceptar");
        cmdAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmdAceptarActionPerformed(evt);
            }
        });
        jPanel25.add(cmdAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 343, 210, 50));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel123.setText("Categorias:");
        jPanel25.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jScrollPane47.setViewportView(lstCategorias);

        jPanel25.add(jScrollPane47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 350));

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel124.setText("Videos:");
        jPanel25.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jScrollPane48.setViewportView(lstListaReproducion);

        jPanel25.add(jScrollPane48, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 240, 350));

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel125.setText("List. Reproduccion:");
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
