package Presentacion.Usuario;
public class frmConsultaUsuario extends javax.swing.JDialog {
    
    public frmConsultaUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        lstImagen = new javax.swing.JLabel();
        lbFechaN = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbApellido = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbUsuario = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        lbPrivacidad = new javax.swing.JLabel();
        lbNombreCanal = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        lstSeguidos = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        lstSeguidores = new javax.swing.JList<>();
        btnAceptar = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        lstListaReproduccion = new javax.swing.JList<>();
        jLabel51 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consulta usuario");

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Eliga un usuario:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(lstUsuarios);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 170, 250));

        jLabel18.setText("Usuario:");
        jPanel6.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 70, -1, -1));

        jLabel19.setText("Nombre:");
        jPanel6.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 100, -1, -1));

        jLabel20.setText("Apellido:");
        jPanel6.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 130, -1, -1));

        jLabel21.setText("Email:");
        jPanel6.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, -1, -1));

        jLabel22.setText("Fecha n:");
        jPanel6.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 190, -1, -1));

        jLabel23.setText("Imagen:");
        jPanel6.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 220, -1, -1));

        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(lstImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 90));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 100, 90));
        jPanel6.add(lbFechaN, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 210, 20));

        lbEmail.setText(" ");
        jPanel6.add(lbEmail, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 260, 20));

        lbApellido.setText(" ");
        jPanel6.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, -1));

        lbNombre.setText(" ");
        jPanel6.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 260, -1));

        lbUsuario.setText(" ");
        jPanel6.add(lbUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 260, -1));
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 550, 10));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Canal:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel32.setText("Descripcion:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        txtDescripcion.setColumns(20);
        txtDescripcion.setRows(5);
        jScrollPane5.setViewportView(txtDescripcion);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 290, 100));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 10, 560));

        lbPrivacidad.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        lbPrivacidad.setText(" ");
        jPanel6.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 120, 40));

        lbNombreCanal.setText(" ");
        jPanel6.add(lbNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 110, -1));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 440, 10));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Segidores:");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Segidos:");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jScrollPane8.setViewportView(lstSeguidos);

        jPanel6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 160, 150));

        jScrollPane9.setViewportView(lstSeguidores);

        jPanel6.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 160, 150));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 480, 360, 50));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("Videos:");
        jPanel6.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, -1));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("Listas de Reproduccion:");
        jPanel6.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, -1, -1));

        jScrollPane20.setViewportView(lstVideos);

        jPanel6.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 160, 190));

        jScrollPane21.setViewportView(lstListaReproduccion);

        jPanel6.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 272, 160, 190));

        jLabel51.setBorder(javax.swing.BorderFactory.createTitledBorder("Privacidad"));
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 170, 110));

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

    private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosValueChanged

    }//GEN-LAST:event_lstUsuariosValueChanged

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        
    }//GEN-LAST:event_btnAceptarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbFechaN;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreCanal;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbUsuario;
    private javax.swing.JLabel lstImagen;
    private javax.swing.JList<String> lstListaReproduccion;
    private javax.swing.JList<String> lstSeguidores;
    private javax.swing.JList<String> lstSeguidos;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JList<String> lstVideos;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
