
package Presentacion.Video;

public class frmValorarVideo extends javax.swing.JDialog {

    public frmValorarVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel16 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        lstUsuario = new javax.swing.JList<>();
        jScrollPane29 = new javax.swing.JScrollPane();
        lstVideoAValorar = new javax.swing.JList<>();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        lstUsuarioValorado = new javax.swing.JList<>();
        jLabel98 = new javax.swing.JLabel();
        rbMeGusta = new javax.swing.JRadioButton();
        rbNoMeGusta = new javax.swing.JRadioButton();
        btnValorar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane28.setViewportView(lstUsuario);

        jPanel16.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 260, 310));

        jScrollPane29.setViewportView(lstVideoAValorar);

        jPanel16.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 250, 310));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel96.setText("Usuario valorador:");
        jPanel16.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setText("Video a valorar:");
        jPanel16.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jScrollPane30.setViewportView(lstUsuarioValorado);

        jPanel16.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 220, 310));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel98.setText("Usuario valorado:");
        jPanel16.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        rbMeGusta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbMeGusta.setText("Me gusta");
        jPanel16.add(rbMeGusta, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 390, -1, -1));

        rbNoMeGusta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbNoMeGusta.setText("No me gusta");
        jPanel16.add(rbNoMeGusta, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 390, -1, -1));

        btnValorar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnValorar.setText("Valorar");
        btnValorar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnValorarActionPerformed(evt);
            }
        });
        jPanel16.add(btnValorar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 260, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel16.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 383, 220, 50));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 850, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 850, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 450, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 450, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnValorarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnValorarActionPerformed
        
    }//GEN-LAST:event_btnValorarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnValorar;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JList<String> lstUsuario;
    private javax.swing.JList<String> lstUsuarioValorado;
    private javax.swing.JList<String> lstVideoAValorar;
    private javax.swing.JRadioButton rbMeGusta;
    private javax.swing.JRadioButton rbNoMeGusta;
    // End of variables declaration//GEN-END:variables
}
