
package Presentacion.Categoria;

import Logica.DataType.DtCategoria;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.border.Border;
import javax.swing.plaf.ColorUIResource;

public class frmAltaCategoria extends javax.swing.JDialog {
    
    Fabrica fabrica = Fabrica.getInstancia();
    IAdmin sys = fabrica.getIAdmin();
    Border bordeDefault;
    Color colorOK = new ColorUIResource(40,167,69);
    Color colorError = new ColorUIResource(220,53,69);

    public frmAltaCategoria(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        bordeDefault = txtNombre.getBorder();
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
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
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
        String nuevaCategoria = txtNombre.getText().trim();
        if(!nuevaCategoria.equals("") && nuevaCategoria.length()<31){
            //Recorre todas las categorias existentes
            boolean existe = false;//Variable 
            try{
                for(String item : sys.listarCategorias()) {
                    //Si la categoria ya existe avisa al administrador
                    if(nuevaCategoria.equals(item)){
                        existe = true;
                        lbMensaje.setText(" "+nuevaCategoria + " ya existe");//mensaje de error al adminstrador
                        lbMensaje.setBackground(colorError);
                        lbMensaje.setOpaque(true);
                        lbMensaje.setForeground(Color.WHITE);  //texto en rojo
                        txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
                        nuevaCategoria = "";
                        break;
                    }
                }
                //Si la categoria no existe se agrega
                if(!existe){
                    sys.altaCategoria(nuevaCategoria);
                    txtNombre.setText("");
                    lbMensaje.setForeground(Color.white);  //texto en rojo
                    lbMensaje.setBackground(colorOK);
                    lbMensaje.setText(" Categoría \""+nuevaCategoria +"\" ingresada. OK");//
                    lbMensaje.setOpaque(true);
                    txtNombre.setBorder(bordeDefault); //Pone el borde con sus valores por default
                    nuevaCategoria = "";
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Se produjo un error al intentar ingresar la nueva categoría.", "Alta de Categoría", JOptionPane.WARNING_MESSAGE);
            }      
        }else if(nuevaCategoria.equals("")){
            lbMensaje.setText(" El campo nombre está vacío");//mensaje de error al adminstrador
            lbMensaje.setBackground(colorError);
            lbMensaje.setOpaque(true);
            lbMensaje.setForeground(Color.WHITE);  //texto en rojo
            txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
        }else if(nuevaCategoria.length() > 30){
            lbMensaje.setText(" El nombre excede los 30 caracteres");//mensaje de error al adminstrador
            lbMensaje.setBackground(colorError);
            lbMensaje.setOpaque(true);
            lbMensaje.setForeground(Color.WHITE);  //texto en rojo
            txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        txtNombre.setText("");
        lbMensaje.setText("");
        lbMensaje.setOpaque(false);
        this.setVisible(false);
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        // Solo letras
        if ( ! Character.isLetter(evt.getKeyChar())) {
            getToolkit().beep();
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtNombreFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtNombreFocusGained
        // Cuando obtiene el foco los colores se resetean
        txtNombre.setText("");
        lbMensaje.setText("");
        lbMensaje.setOpaque(false);
        txtNombre.setBorder(bordeDefault);
        
    }//GEN-LAST:event_txtNombreFocusGained

    private void txtNombreKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyPressed
        // Al presionar ENTER
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String nuevaCategoria = txtNombre.getText().trim();
            if(!nuevaCategoria.equals("") && nuevaCategoria.length()<31){
                //Recorre todas las categorias existentes
                boolean existe = false;//Variable 
                try{
                    for(String item : sys.listarCategorias()) {
                        //Si la categoria ya existe avisa al administrador
                        if(nuevaCategoria.equals(item)){
                            existe = true;
                            lbMensaje.setText(" "+nuevaCategoria + " ya existe");//mensaje de error al adminstrador
                            lbMensaje.setBackground(colorError);
                            lbMensaje.setOpaque(true);
                            lbMensaje.setForeground(Color.WHITE);  //texto en rojo
                            txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
                            nuevaCategoria = "";
                            break;
                        }
                    }
                    //Si la categoria no existe se agrega
                    if(!existe){
                        sys.altaCategoria(nuevaCategoria);
                        txtNombre.setText("");
                        lbMensaje.setForeground(Color.white);  //texto en rojo
                        lbMensaje.setBackground(colorOK);
                        lbMensaje.setText(" Categoría \""+nuevaCategoria +"\" ingresada. OK");//
                        lbMensaje.setOpaque(true);
                        txtNombre.setBorder(bordeDefault); //Pone el borde con sus valores por default
                        nuevaCategoria = "";
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Se produjo un error al intentar ingresar la nueva categoría.", "Alta de Categoría", JOptionPane.WARNING_MESSAGE);
                }      
            }else if(nuevaCategoria.equals("")){
                lbMensaje.setText(" El campo nombre está vacío");//mensaje de error al adminstrador
                lbMensaje.setBackground(colorError);
                lbMensaje.setOpaque(true);
                lbMensaje.setForeground(Color.WHITE);  //texto en rojo
                txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
            }else if(nuevaCategoria.length() > 30){//Cheque el largo del campo
                lbMensaje.setText(" El nombre excede los 30 caracteres");//mensaje de error al adminstrador
                lbMensaje.setBackground(colorError);
                lbMensaje.setOpaque(true);
                lbMensaje.setForeground(Color.WHITE);  //texto en rojo
                txtNombre.setBorder(BorderFactory.createLineBorder(colorError, 1));//color del borde rojo
            }
            btnAceptar.requestFocus();
        }else if(evt.getKeyCode() == KeyEvent.VK_TAB){
            btnAceptar.requestFocus();//Al presionar tabulador cambia el foco al boton aceptar
            System.out.println("Hola mundo");
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
