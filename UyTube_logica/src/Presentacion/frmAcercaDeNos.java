package Presentacion;
import java.awt.Image;
import javax.swing.ImageIcon;

public class frmAcercaDeNos extends javax.swing.JDialog {
    boolean aburrido = false;
    
    public frmAcercaDeNos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
        lbImagen.setText(null);
        Image img7 = new ImageIcon("Imagenes/about.png").getImage();
        ImageIcon img8 = new ImageIcon(img7.getScaledInstance(lbImagen.getWidth(), lbImagen.getHeight(), Image.SCALE_SMOOTH));
        lbImagen.setIcon(img8);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel10 = new javax.swing.JPanel();
        lbImagen = new javax.swing.JLabel();
        btnAceptar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Acerca de nos");
        setResizable(false);

        jPanel10.setBackground(new java.awt.Color(20, 20, 20));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbImagen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImagenMouseClicked(evt);
            }
        });
        jPanel10.add(lbImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 430));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.setBorderPainted(false);
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel10.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 420, 110, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 570, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 460, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, 460, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // Boton Acptar
        dispose();
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        dispose();
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void lbImagenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImagenMouseClicked
        if ((!aburrido) && evt.getClickCount() == 42) {
            // aburrido
            // muy aburrido
            int rango = 300;
            int xInicial = this.getX();
            int yInicial = this.getY();

            for (int i = 0; i < 3; i++) {
                for (int x = this.getX(); x < xInicial + rango; x++) {
                    this.setLocation(x, yInicial);
                }
                for (int x = this.getX(); x > xInicial - rango; x--) {
                    this.setLocation(x, yInicial);
                }
                for (int x = this.getX(); x < xInicial; x++) {
                    this.setLocation(x, yInicial);
                }
            }
            aburrido = true;
        }else if (aburrido && evt.getClickCount() == 42) {
            int respuesta = javax.swing.JOptionPane.showConfirmDialog(
                    null,
                    "¿En serio estás tan aburrido?",
                    "¿Aburrido?",
                    javax.swing.JOptionPane.YES_OPTION,
                    javax.swing.JOptionPane.QUESTION_MESSAGE
            );
            if (respuesta == javax.swing.JOptionPane.YES_OPTION){
                javax.swing.JOptionPane.showMessageDialog(null, 
                    "Se nota...",
                    "La verdad...",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }else if (respuesta == javax.swing.JOptionPane.NO_OPTION){
                javax.swing.JOptionPane.showMessageDialog(null,
                    "Pues no parece...",
                    "¿Ah no?",
                    javax.swing.JOptionPane.INFORMATION_MESSAGE);
            }
            dispose();
        }
    }//GEN-LAST:event_lbImagenMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JLabel lbImagen;
    // End of variables declaration//GEN-END:variables
}
