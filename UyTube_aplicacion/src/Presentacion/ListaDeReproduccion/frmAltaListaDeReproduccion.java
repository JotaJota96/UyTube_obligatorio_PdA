package Presentacion.ListaDeReproduccion;

import Logica.DataType.*;
import Logica.Clases.*;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

public class frmAltaListaDeReproduccion extends javax.swing.JDialog {
    Fabrica f = Fabrica.getInstancia();
    IAdmin Sys = f.getIAdmin();
    public frmAltaListaDeReproduccion(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        
      
        
        ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();
                
        
        DefaultListModel modeloUsuario = new DefaultListModel();
        
        for (DtUsuario it : ListaUsuarios) {
            modeloUsuario.addElement(it.getNickname());
        }
        lstUsuarios.setModel(modeloUsuario);
        
        
         ArrayList<String> ListaCategoria = Sys.listarCategorias();
                
        
        DefaultListModel modeloCategoria = new DefaultListModel();
        
        for (String it : ListaCategoria) {
            modeloCategoria.addElement(it);
        }
        lstCategorias.setModel(modeloCategoria);
        
        lstCategorias.setSelectedIndex(0);
        rbParticular.setSelected(true);
        rbPublica.setSelected(true);
        }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GrupoTipo = new javax.swing.ButtonGroup();
        GrupoPublicoPrivado = new javax.swing.ButtonGroup();
        jPanel17 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        lstCategorias = new javax.swing.JList<>();
        rbPublica = new javax.swing.JRadioButton();
        rbPrivada = new javax.swing.JRadioButton();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        pnlTipo = new javax.swing.JPanel();
        rbPorDefecto = new javax.swing.JRadioButton();
        rbParticular = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nueva lista de reproduccion");

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setText("Nombre:");
        jPanel17.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));

        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });
        jPanel17.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 310, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setText("Usuarios:");
        jPanel18.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jScrollPane31.setViewportView(lstCategorias);

        jPanel18.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 340, 180));

        GrupoPublicoPrivado.add(rbPublica);
        rbPublica.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPublica.setText("Publica");
        jPanel18.add(rbPublica, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        GrupoPublicoPrivado.add(rbPrivada);
        rbPrivada.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPrivada.setText("Privada");
        jPanel18.add(rbPrivada, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 230, -1, -1));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel102.setText("Categoria:");
        jPanel18.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jScrollPane32.setViewportView(lstUsuarios);

        jPanel18.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 320, 180));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 750, 270));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAceptarMouseClicked(evt);
            }
        });
        jPanel17.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 370, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnCancelarMouseClicked(evt);
            }
        });
        jPanel17.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 50));

        pnlTipo.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        pnlTipo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        pnlTipo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        GrupoTipo.add(rbPorDefecto);
        rbPorDefecto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbPorDefecto.setText("Por defecto");
        rbPorDefecto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbPorDefectoMouseClicked(evt);
            }
        });
        pnlTipo.add(rbPorDefecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        GrupoTipo.add(rbParticular);
        rbParticular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        rbParticular.setText("Particular");
        rbParticular.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rbParticularMouseClicked(evt);
            }
        });
        pnlTipo.add(rbParticular, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel17.add(pnlTipo, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 10, 330, 60));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 810, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 810, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 430, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbParticularMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbParticularMouseClicked
        if (rbParticular.isSelected()== true) {
            txtNombre.setText("");
            rbPublica.setEnabled(true);
            lstUsuarios.setEnabled(true);
            lstCategorias.setEnabled(true);
            lstCategorias.clearSelection();
            lstUsuarios.clearSelection();
        }
    }//GEN-LAST:event_rbParticularMouseClicked

    private void rbPorDefectoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbPorDefectoMouseClicked
        if (rbPorDefecto.isSelected()== true) {
            txtNombre.setText("");
            rbPublica.setEnabled(false);
            rbPrivada.setSelected(true);
            lstUsuarios.setEnabled(false);
            lstCategorias.setEnabled(false);
            lstCategorias.clearSelection();
            lstUsuarios.clearSelection();
        }
        
    }//GEN-LAST:event_rbPorDefectoMouseClicked

    private void btnAceptarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAceptarMouseClicked
        DtListaDeReproduccion lst = null;
        Privacidad Priv = null;
        
        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null,"El nombre de la lista de reproduccion no puede ser vacio", "Avertencia:", JOptionPane.WARNING_MESSAGE);
        }
        
        if (rbPrivada.isSelected() == true) {
            Priv = Privacidad.PRIVADO;
        }
        if (rbPublica.isSelected() == true) {
            Priv = Privacidad.PUBLICO;
        }
        
        if (rbParticular.isSelected()==true) {
            lst = new DtListaDeReproduccion(ListaDeReproduccion.getNuevoId(), txtNombre.getText(), Priv, TipoListaDeReproduccion.PARTICULAR , lstCategorias.getSelectedValue());
            
            try {
                
                Sys.seleccionarUsuario(lstUsuarios.getSelectedValue());
                
                if (!Sys.validarNuevaListaParticular(lst.getNombre())){
                    JOptionPane.showMessageDialog(null, "El nombre para la lista de reproduccion ya esta usado", "Error:", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                Sys.altaListaDeReproduccionParticular(lst);
                JOptionPane.showMessageDialog(null,"Lista particular creada", "Informacion:", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,(String)e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        
        if (rbPorDefecto.isSelected() == true) {
            lst = new DtListaDeReproduccion(ListaDeReproduccion.getNuevoId(), txtNombre.getText(), Priv, TipoListaDeReproduccion.POR_DEFECTO ,"UNDEFINED");
            
            try {
                if (!Sys.validarNuevaListaPorDefecto(lst.getNombre())){
                    JOptionPane.showMessageDialog(null, "El nombre para la lista de reproduccion ya esta usado", "Error:", JOptionPane.WARNING_MESSAGE);
                    return;
                }
                
                Sys.altaListaDeReproduccionParticular(lst);
                JOptionPane.showMessageDialog(null,"Lista por defecto creada", "Informacion:", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,(String)e.getMessage(), "Error:", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        Sys.liberarMemoriaUsuario();
        txtNombre.setText("");
        dispose();
    }//GEN-LAST:event_btnAceptarMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
       if (!(Character.isDigit(evt.getKeyChar()) || Character.isLetter(evt.getKeyChar()))) {
	getToolkit().beep();
	evt.consume();
}
    }//GEN-LAST:event_txtNombreKeyTyped

    private void btnCancelarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnCancelarMouseClicked
        txtNombre.setText("");
        dispose();
    }//GEN-LAST:event_btnCancelarMouseClicked
  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup GrupoPublicoPrivado;
    private javax.swing.ButtonGroup GrupoTipo;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JList<String> lstCategorias;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JPanel pnlTipo;
    public static javax.swing.JRadioButton rbParticular;
    public static javax.swing.JRadioButton rbPorDefecto;
    public static javax.swing.JRadioButton rbPrivada;
    protected static javax.swing.JRadioButton rbPublica;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
