
package Presentacion.Categoria;

import Logica.DataType.DtCategoria;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

public class frmAltaCategoria extends javax.swing.JDialog {
    
    IAdmin sys;
    Border bordeDefault;
    Color colorOK = new ColorUIResource(40,167,69);
    Color colorError = new ColorUIResource(220,53,69);
    Pattern patronCategoria= Pattern.compile("^([A-Za-zÑñÁáÉéÍíÓóÚú\\d\\-_]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú\\d\\-_]+)\\s*"
            + "([A-Za-zÑñÁáÉéÍíÓóÚú\\d\\-_]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú\\d\\-_]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú\\d\\-_]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú\\d\\-_]+)$");
    String nuevaCategoria = new String();
    
    public frmAltaCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        bordeDefault = txtNombre.getBorder();
        sys = Fabrica.getInstancia().getIAdmin();
    }
    
    private boolean validarCategoria(){
        nuevaCategoria = txtNombre.getText().trim().toUpperCase();
        if(nuevaCategoria.equals("")){
            lbMensaje.setText(" El campo nombre está vacío");//mensaje de error al adminstrador
            cambiarColoresError();
            return false;
        }else if(nuevaCategoria.length() > 30){
            lbMensaje.setText(" El nombre excede los 30 caracteres");//mensaje de error al adminstrador
            cambiarColoresError();
            return false;
        }
        else if(!validarFormatoCategoria(nuevaCategoria)){
            lbMensaje.setText(" El fomrato es alfanumérico");//mensaje de error al adminstrador
            cambiarColoresError();
            return false;
        }
        else{
            //Recorre todas las categorias existentes 
            try{
                for(String item : sys.listarCategorias()) {
                    //Si la categoria ya existe avisa al administrador
                    if(nuevaCategoria.equals(item)){
                        lbMensaje.setText(" "+nuevaCategoria + " ya existe");//mensaje de error al adminstrador
                        cambiarColoresError();
                        nuevaCategoria = "";
                        return false;
                    }
                }                
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }      
        }
        return true;
    }
    
    private boolean validarFormatoCategoria(String cat){
        Matcher mather = patronCategoria.matcher(cat); 
        if (mather.find() == true) {
            return true;
        } 
        return false;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel23 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        lbMensaje = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel122 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Alta categoria");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtNombre.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNombre.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                txtNombreFocusGained(evt);
            }
        });
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtNombreKeyPressed(evt);
            }
        });
        jPanel23.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 290, 30));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel23.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 150, 120, 40));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        jPanel23.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 150, 120, 40));

        lbMensaje.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel23.add(lbMensaje, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 120, 290, 20));

        jLabel1.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        jLabel1.setText("Alta Categoría");
        jPanel23.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel122.setText("Ingrese una nueva Categoría:");
        jPanel23.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel23, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        //Si la categoria supera la validacion la ingresa
        if (validarCategoria()) {
            try {
                sys.altaCategoria(nuevaCategoria);
                txtNombre.setText("");
                cambiarColoresOK();
                nuevaCategoria = "";
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText("");
        lbMensaje.setText("");
        lbMensaje.setOpaque(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // Cuando obtiene el foco los colores se resetean
        txtNombre.setText("");
        lbMensaje.setText("");
        lbMensaje.setOpaque(false);
        txtNombre.setBorder(bordeDefault);        
    }//GEN-LAST:event_txtNombreFocusGained
    
    private void cambiarColoresOK(){
        lbMensaje.setForeground(Color.white);  //texto en rojo
        lbMensaje.setBackground(colorOK);
        lbMensaje.setText(" Categoría \"" + nuevaCategoria + "\" ingresada. OK");//
        lbMensaje.setOpaque(true);
        txtNombre.setBorder(bordeDefault); //Pone el borde con sus valores por default
    }
  
    private void cambiarColoresError() {
        lbMensaje.setBackground(colorError);
        lbMensaje.setOpaque(true);
        lbMensaje.setForeground(Color.WHITE);  //texto en rojo
        txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
    }
    
    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // Al presionar ENTER
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            //Si la categoria supera la validacion la ingresa
        if (validarCategoria()) {
            try {
                sys.altaCategoria(nuevaCategoria);
                txtNombre.setText("");
                cambiarColoresOK();
                nuevaCategoria = "";
            } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        }    
    }//GEN-LAST:event_txtNombreKeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // Al cerrar el formulario se limpian los campos
        txtNombre.setText("");
        lbMensaje.setText("");
        lbMensaje.setOpaque(false);
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JLabel lbMensaje;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
