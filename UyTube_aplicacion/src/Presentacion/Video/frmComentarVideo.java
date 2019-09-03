
package Presentacion.Video;

public class frmComentarVideo extends javax.swing.JDialog {

    public frmComentarVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtComentario = new javax.swing.JTextArea();
        btnComentar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstComentarios = new javax.swing.JTree();
        btnAceptar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstUsuario = new javax.swing.JList<>();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane52 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jLabel150 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        spAnio = new javax.swing.JSpinner();
        spMes = new javax.swing.JSpinner();
        spDia = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comentar video");
        setResizable(false);

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtComentario.setColumns(20);
        txtComentario.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        txtComentario.setRows(5);
        jScrollPane3.setViewportView(txtComentario);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 410, 170));

        btnComentar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnComentar.setText("Comentar");
        btnComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarActionPerformed(evt);
            }
        });
        jPanel6.add(btnComentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 210, 60));

        lstComentarios.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        lstComentarios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        lstComentarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(lstComentarios);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 370, 260));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 210, 60));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Comentarios:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Ingrese comentario");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        lstUsuario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuarioValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(lstUsuario);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 240, 380));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Eliga un usuario:");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane52.setViewportView(lstVideos);

        jPanel6.add(jScrollPane52, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 250, 260));

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel150.setText("Videos:");
        jPanel6.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel46.setText("Ingrese Fecha del comentario:");
        jPanel6.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, -1, -1));
        jPanel6.add(spAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 70, -1));
        jPanel6.add(spMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 50, -1));
        jPanel6.add(spDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 50, -1));

        jLabel47.setText("Dia");
        jPanel6.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, -1, -1));

        jLabel48.setText("Mes");
        jPanel6.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, -1, -1));

        jLabel49.setText("Año");
        jPanel6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarActionPerformed
        
    }//GEN-LAST:event_btnComentarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lstUsuarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuarioValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_lstUsuarioValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnComentar;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTree lstComentarios;
    private javax.swing.JList<String> lstUsuario;
    private javax.swing.JList<String> lstVideos;
    private javax.swing.JSpinner spAnio;
    private javax.swing.JSpinner spDia;
    private javax.swing.JSpinner spMes;
    private javax.swing.JTextArea txtComentario;
    // End of variables declaration//GEN-END:variables
}
