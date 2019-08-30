
package Presentacion.Video;

public class frmAltaVideo extends javax.swing.JDialog {

    public frmAltaVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane16 = new javax.swing.JScrollPane();
        lstDueñoVideo = new javax.swing.JList<>();
        jLabel72 = new javax.swing.JLabel();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        jLabel77 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        lstAsignarCategoria = new javax.swing.JList<>();
        jLabel78 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtUrl = new javax.swing.JTextField();
        spAnio = new javax.swing.JSpinner();
        spMes = new javax.swing.JSpinner();
        spDia = new javax.swing.JSpinner();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        spSegundos = new javax.swing.JSpinner();
        spHora = new javax.swing.JSpinner();
        spMinuto = new javax.swing.JSpinner();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Dueño del video:");
        jPanel14.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane16.setViewportView(lstDueñoVideo);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 390));

        jLabel72.setText("Nombre:");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel73.setText("Segundos");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel74.setText("URL:");
        jPanel14.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel75.setText("Descripción:");
        jPanel14.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel76.setText("Fecha publicación:");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jLabel77.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel77.setText("Asignar categoría:");
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jScrollPane17.setViewportView(lstAsignarCategoria);

        jPanel14.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 260, 390));

        jLabel78.setText("Opcional *");
        jPanel14.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));
        jPanel14.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 240, -1));
        jPanel14.add(txtUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 240, -1));
        jPanel14.add(spAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 70, -1));
        jPanel14.add(spMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 60, -1));
        jPanel14.add(spDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 60, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane18.setViewportView(txtDescripcion);

        jPanel14.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 240, 160));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel14.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 260, 70));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 290, 70));
        jPanel14.add(spSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 60, -1));
        jPanel14.add(spHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 60, -1));
        jPanel14.add(spMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 60, -1));

        jLabel135.setText("Duración:");
        jPanel14.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel136.setText("Horas");
        jPanel14.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jLabel137.setText("Minutos");
        jPanel14.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        jLabel138.setText("Año");
        jPanel14.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        jLabel139.setText("Mes");
        jPanel14.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, -1));

        jLabel140.setText("Dia");
        jPanel14.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 980, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 550, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       
    }//GEN-LAST:event_btnCancelarActionPerformed

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JList<String> lstAsignarCategoria;
    private javax.swing.JList<String> lstDueñoVideo;
    private javax.swing.JSpinner spAnio;
    private javax.swing.JSpinner spDia;
    private javax.swing.JSpinner spHora;
    private javax.swing.JSpinner spMes;
    private javax.swing.JSpinner spMinuto;
    private javax.swing.JSpinner spSegundos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtUrl;
    // End of variables declaration//GEN-END:variables
}
