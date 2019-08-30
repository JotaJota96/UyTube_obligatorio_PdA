package Presentacion.Usuario;

public class frmModificarUsuario extends javax.swing.JDialog {

   
    public frmModificarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel7 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel130 = new javax.swing.JLabel();
        spAnio = new javax.swing.JSpinner();
        spMes = new javax.swing.JSpinner();
        spDia = new javax.swing.JSpinner();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane50 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnModificar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        txtNombreCanal = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        txtDescrpcion = new javax.swing.JTextArea();
        rbPublico = new javax.swing.JRadioButton();
        rbPrivado = new javax.swing.JRadioButton();
        btnListaReprodiccion = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        lbImagen = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setText("Nombre");
        jPanel7.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel127.setText("Apellido");
        jPanel7.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel128.setText("Usuario");
        jPanel7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        jPanel7.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 230, -1));
        jPanel7.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 230, -1));

        jLabel129.setText("Fecha de nacimiento");
        jPanel7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 10, 560));

        jLabel130.setText("Imagen");
        jPanel7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 20));
        jPanel7.add(spAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 60, -1));
        jPanel7.add(spMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 40, -1));
        jPanel7.add(spDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 40, -1));

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel131.setText("Seleccionar usuario");
        jPanel7.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane50.setViewportView(lstUsuarios);

        jPanel7.add(jScrollPane50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 420));

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel7.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 270, 50));

        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar");
        btnSeleccionar.setToolTipText("");
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        jPanel7.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 120, 60));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 10, 560));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel132.setText("Canal");
        jPanel7.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel133.setText("Nombre");
        jPanel7.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));
        jPanel7.add(txtNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 60, 210, -1));

        jLabel134.setText("Descripción");
        jPanel7.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        txtDescrpcion.setColumns(20);
        txtDescrpcion.setRows(5);
        jScrollPane51.setViewportView(txtDescrpcion);

        jPanel7.add(jScrollPane51, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 100, 210, 160));

        rbPublico.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rbPublico.setText("Publico");
        jPanel7.add(rbPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(730, 280, 110, 40));

        rbPrivado.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        rbPrivado.setText("Privado");
        rbPrivado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbPrivadoActionPerformed(evt);
            }
        });
        jPanel7.add(rbPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 280, 110, 40));

        btnListaReprodiccion.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnListaReprodiccion.setText("Lista de reproduccion");
        btnListaReprodiccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaReprodiccionActionPerformed(evt);
            }
        });
        jPanel7.add(btnListaReprodiccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 270, 50));

        btnVideo.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnVideo.setText("Video");
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });
        jPanel7.add(btnVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 420, 270, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel7.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 260, 50));

        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 110));

        jPanel7.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 140, 110));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 650, 20));

        jLabel141.setText("Año");
        jPanel7.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel142.setText("Mes");
        jPanel7.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jLabel143.setText("Dia");
        jPanel7.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Opcional *");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        
       
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
      
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnListaReprodiccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaReprodiccionActionPerformed
       
    }//GEN-LAST:event_btnListaReprodiccionActionPerformed

    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed
        
    }//GEN-LAST:event_btnVideoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void rbPrivadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbPrivadoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbPrivadoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListaReprodiccion;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVideo;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JLabel lbImagen;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JRadioButton rbPrivado;
    private javax.swing.JRadioButton rbPublico;
    private javax.swing.JSpinner spAnio;
    private javax.swing.JSpinner spDia;
    private javax.swing.JSpinner spMes;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextArea txtDescrpcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCanal;
    // End of variables declaration//GEN-END:variables
}
