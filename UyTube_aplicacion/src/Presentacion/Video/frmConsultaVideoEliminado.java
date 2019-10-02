
package Presentacion.Video;

import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import javax.swing.JOptionPane;

public class frmConsultaVideoEliminado extends javax.swing.JDialog {

    private IAdmin sys;
    private String enlace = "";
    
    public frmConsultaVideoEliminado(javax.swing.JDialog parent, boolean modal, int idVideo) {
        // Constructor para abrir ventana desde otro caso de uso
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarElementosDeVentana();
        
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();

            // El sistema ya tiene un usuario seleccionado
            mostrarDatosDeVideo(sys.seleccionarVideo(idVideo));
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextArea();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        lbNombre = new javax.swing.JLabel();
        lbDuracion = new javax.swing.JLabel();
        lbUrl = new javax.swing.JLabel();
        lbPrivacidad = new javax.swing.JLabel();
        lbCategoria = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        lbCantDisLikes = new javax.swing.JLabel();
        lbCantLikes = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        lbFechaPublicacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar video");
        setResizable(false);

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel83.setText("Nombre:");
        jPanel15.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel84.setText("Duración:");
        jPanel15.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel85.setText("URL:");
        jPanel15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel86.setText("Descripción:");
        jPanel15.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane24.setViewportView(txtDescripcion);

        jPanel15.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 380, 130));

        jLabel87.setText("Privacidad:");
        jPanel15.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, -1, -1));

        jLabel88.setText("Categoría:");
        jPanel15.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        lbNombre.setText(" ");
        jPanel15.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 20, 390, -1));

        lbDuracion.setText(" ");
        jPanel15.add(lbDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 390, -1));

        lbUrl.setText(" ");
        lbUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbUrlMousePressed(evt);
            }
        });
        jPanel15.add(lbUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, 390, -1));

        lbPrivacidad.setText(" ");
        jPanel15.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 140, 390, -1));

        lbCategoria.setText(" ");
        jPanel15.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 380, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel15.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 460, 60));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("Les gustó:");
        jPanel15.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, -1, -1));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("No les gustó:");
        jPanel15.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, -1, -1));

        lbCantDisLikes.setText(" ");
        jPanel15.add(lbCantDisLikes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 370, 370, 20));

        lbCantLikes.setText(" ");
        jPanel15.add(lbCantLikes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 340, 370, 20));

        jLabel89.setText("Publicación:");
        jPanel15.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, -1, -1));

        lbFechaPublicacion.setText(" ");
        jPanel15.add(lbFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 390, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 505, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 489, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 489, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       // boton aceptar
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lbUrlMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbUrlMousePressed
        // al cloquear sobre la URL del video
        if (lbUrl.getText().isEmpty() || enlace.isEmpty()) return;
        
        // Fuente:
        // http://www.forosdelweb.com/f45/jlabel-como-hipervinculo-netbeans-948388/
        try {
            if (java.awt.Desktop.isDesktopSupported()) {
                java.awt.Desktop desktop = java.awt.Desktop.getDesktop();
                if (desktop.isSupported(java.awt.Desktop.Action.BROWSE)) {
                    desktop.browse(new java.net.URI(enlace));
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lbUrlMousePressed

    ///////////////////////////////////////////////////////////////////////////////////////////
    private void mostrarDatosDeVideo(DtVideo v){
        lbNombre.setText(v.getNombre());
        lbDuracion.setText(v.getDuracion().toString());
        lbUrl.setText(obtenerTextoComoEnlace(v.getUrlVideoOriginal(), v.getUrlVideoOriginal()));
        enlace = v.getUrlVideoOriginal();
        lbPrivacidad.setText(v.getPrivacidad().toString());
        lbCategoria.setText(v.getCategoria());
        txtDescripcion.setText(v.getDescripcion());
        lbCantLikes.setText(String.valueOf(v.getCantLikes()));
        lbCantDisLikes.setText(String.valueOf(v.getCantDisLikes()));
        lbFechaPublicacion.setText(v.getFechaPublicacion().toString());
    }
    private void limpiarElementosDeVentana(){
        enlace = "";
        // limpieza de labels
        lbNombre.setText("");
        lbDuracion.setText("");
        lbUrl.setText("");
        lbPrivacidad.setText("");
        lbCategoria.setText("");
        txtDescripcion.setText("");
        lbCantLikes.setText("");
        lbCantDisLikes.setText("");
        lbFechaPublicacion.setText("");
    }
    public String obtenerTextoComoEnlace(String enlace, String texto) {
        // Extraido de
        // http://www.forosdelweb.com/f45/jlabel-como-hipervinculo-netbeans-948388/
        return"<html><a href=" + '"' + enlace + '"'+ ">" + texto + "</a></html>";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JLabel lbCantDisLikes;
    private javax.swing.JLabel lbCantLikes;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbFechaPublicacion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
