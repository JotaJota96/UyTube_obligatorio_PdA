
package Presentacion.Usuario;

public class frmSeguirUsuario extends javax.swing.JDialog {

    public frmSeguirUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        lstSeguidor = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        lstSeguido = new javax.swing.JList<>();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        btnSeguir = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        btnDejarDeSeguir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane11.setViewportView(lstSeguidor);

        jPanel12.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 330, 290));

        jScrollPane12.setViewportView(lstSeguido);

        jPanel12.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 320, 290));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Seguidor:");
        jPanel12.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("Seguido:");
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        btnSeguir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeguir.setText("Seguir");
        jPanel12.add(btnSeguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 190, 40));

        btnSalir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSalir.setText("salir");
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });
        jPanel12.add(btnSalir, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 120, 40));

        btnDejarDeSeguir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnDejarDeSeguir.setText("Dejar de Seguir");
        jPanel12.add(btnDejarDeSeguir, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 200, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 770, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel12, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        
    }//GEN-LAST:event_btnSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDejarDeSeguir;
    private javax.swing.JButton btnSalir;
    private javax.swing.JButton btnSeguir;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JList<String> lstSeguido;
    private javax.swing.JList<String> lstSeguidor;
    // End of variables declaration//GEN-END:variables
}
