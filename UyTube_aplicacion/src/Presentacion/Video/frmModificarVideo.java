
package Presentacion.Video;

public class frmModificarVideo extends javax.swing.JDialog {

    public frmModificarVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel14 = new javax.swing.JPanel();
        btnModificar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        lstDuenioVideo = new javax.swing.JList<>();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        lstVideoUsuario = new javax.swing.JList<>();
        jLabel72 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        txtURL = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        spAnio = new javax.swing.JSpinner();
        spMes = new javax.swing.JSpinner();
        spDia = new javax.swing.JSpinner();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        rbPublico = new javax.swing.JRadioButton();
        rbPrivado = new javax.swing.JRadioButton();
        spHora = new javax.swing.JSpinner();
        jLabel144 = new javax.swing.JLabel();
        spMinuto = new javax.swing.JSpinner();
        jLabel145 = new javax.swing.JLabel();
        spSegundos = new javax.swing.JSpinner();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnModificar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        jPanel14.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 390, 70));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel14.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 473, 390, 70));

        jScrollPane16.setViewportView(lstDuenioVideo);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, 400));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Dueño del video:");
        jPanel14.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane17.setViewportView(lstVideoUsuario);

        jPanel14.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 180, 400));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setText("Video del Usuario:");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        jPanel14.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 210, -1));

        jLabel73.setText("Nombre:");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel74.setText("Duración:");
        jPanel14.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jLabel75.setText("URL:");
        jPanel14.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, -1, -1));
        jPanel14.add(txtURL, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 140, 210, -1));

        jLabel76.setText("Descripción:");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane18.setViewportView(txtDescripcion);

        jPanel14.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 180, 210, 120));

        jLabel77.setText("Fecha publicación:");
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, -1));
        jPanel14.add(spAnio, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 330, 60, -1));
        jPanel14.add(spMes, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 330, 50, -1));
        jPanel14.add(spDia, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 330, 50, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setText("Asignar categoría:");
        jPanel14.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        jScrollPane19.setViewportView(lstCategorias);

        jPanel14.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 180, 400));

        rbPublico.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPublico.setText("Publico");
        jPanel14.add(rbPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        rbPrivado.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        rbPrivado.setText("Privado");
        jPanel14.add(rbPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, -1));
        jPanel14.add(spHora, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 60, -1));

        jLabel144.setText("Horas");
        jPanel14.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));
        jPanel14.add(spMinuto, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 50, -1));

        jLabel145.setText("Minutos");
        jPanel14.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));
        jPanel14.add(spSegundos, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, -1));

        jLabel146.setText("Segundos");
        jPanel14.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jLabel147.setText("Año");
        jPanel14.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 310, -1, -1));

        jLabel148.setText("Mes");
        jPanel14.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 310, -1, -1));

        jLabel149.setText("Dia");
        jPanel14.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 310, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 980, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, 550, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
       
    }//GEN-LAST:event_btnCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
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
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JList<String> lstDuenioVideo;
    private javax.swing.JList<String> lstVideoUsuario;
    private javax.swing.JRadioButton rbPrivado;
    private javax.swing.JRadioButton rbPublico;
    private javax.swing.JSpinner spAnio;
    private javax.swing.JSpinner spDia;
    private javax.swing.JSpinner spHora;
    private javax.swing.JSpinner spMes;
    private javax.swing.JSpinner spMinuto;
    private javax.swing.JSpinner spSegundos;
    private javax.swing.JTextArea txtDescripcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtURL;
    // End of variables declaration//GEN-END:variables
}
