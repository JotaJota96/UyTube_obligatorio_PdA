package Presentacion.Usuario;

import Logica.DataType.DtCanal;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Presentacion.ListaDeReproduccion.frmModificarListaDeReproduccion;
import Presentacion.Video.frmModificarVideo;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class frmModificarUsuario extends javax.swing.JDialog {

    IAdmin sys;
    DtUsuario user;
    String ruta;

    public frmModificarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        txtContraNueva1.setEnabled(false); // TODO add your handling code here:
        txtContraNueva2.setEnabled(false); // TODO add your handling code here:
        lbCN.setEnabled(false);
        lbRCN.setEnabled(false);
        btnVideo.setEnabled(false);
        btnListaReprodiccion.setEnabled(false);
        desactivarCampos();
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();

            // lista usuarios en el JList
            listarUsuarios(sys.listarUsuarios());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);
        }

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpPrivacidad = new javax.swing.ButtonGroup();
        lbMes = new javax.swing.JPanel();
        lbNombre = new javax.swing.JLabel();
        lbCorreo = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane50 = new javax.swing.JScrollPane();
        lstUsuarios = new javax.swing.JList<>();
        btnModificar = new javax.swing.JButton();
        btnSeleccionar = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        lbNombreC = new javax.swing.JLabel();
        txtNombreCanal = new javax.swing.JTextField();
        lbDescripcion = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        txtDescrpcion = new javax.swing.JTextArea();
        btnListaReprodiccion = new javax.swing.JButton();
        btnVideo = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        jpImagen = new javax.swing.JPanel();
        lbImg = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        txtApellido = new javax.swing.JTextField();
        lbApellido = new javax.swing.JLabel();
        lbRCN = new javax.swing.JLabel();
        lbCN = new javax.swing.JLabel();
        lbFecha = new javax.swing.JLabel();
        chkCambiarContra = new javax.swing.JCheckBox();
        rbPublico = new javax.swing.JRadioButton();
        rbPrivado = new javax.swing.JRadioButton();
        lbImagen1 = new javax.swing.JLabel();
        dcFecha = new com.toedter.calendar.JDateChooser();
        btnQuitarImagen = new javax.swing.JButton();
        txtContraNueva2 = new javax.swing.JPasswordField();
        txtContraNueva1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Modificar usuario");

        lbMes.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        lbNombre.setText("Nombre");
        lbMes.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        lbCorreo.setText("Correo");
        lbMes.add(lbCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 140, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel128.setText("Usuario");
        lbMes.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        lbMes.add(txtNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 230, -1));

        txtCorreo.setEnabled(false);
        lbMes.add(txtCorreo, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 140, 230, -1));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        lbMes.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 10, 560));

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel131.setText("Seleccionar usuario");
        lbMes.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        lstUsuarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuariosValueChanged(evt);
            }
        });
        jScrollPane50.setViewportView(lstUsuarios);

        lbMes.add(jScrollPane50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 420));

        btnModificar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });
        lbMes.add(btnModificar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 270, 50));

        btnSeleccionar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnSeleccionar.setText("Seleccionar imagen");
        btnSeleccionar.setToolTipText("");
        btnSeleccionar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeleccionarActionPerformed(evt);
            }
        });
        lbMes.add(btnSeleccionar, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, 170, 50));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        lbMes.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 10, 560));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel132.setText("Canal");
        lbMes.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        lbNombreC.setText("Nombre");
        lbMes.add(lbNombreC, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 60, -1, -1));
        lbMes.add(txtNombreCanal, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 200, -1));

        lbDescripcion.setText("Descripción");
        lbMes.add(lbDescripcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 100, -1, -1));

        txtDescrpcion.setColumns(20);
        txtDescrpcion.setRows(5);
        jScrollPane51.setViewportView(txtDescrpcion);

        lbMes.add(jScrollPane51, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 200, 160));

        btnListaReprodiccion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnListaReprodiccion.setText("Modificar lista de reproducción");
        btnListaReprodiccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListaReprodiccionActionPerformed(evt);
            }
        });
        lbMes.add(btnListaReprodiccion, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 340, 270, 50));

        btnVideo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnVideo.setText("Modificar video");
        btnVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVideoActionPerformed(evt);
            }
        });
        lbMes.add(btnVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 400, 270, 50));

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        lbMes.add(btnCancelar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 260, 50));

        jpImagen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jpImagen.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpImagen.add(lbImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(5, 5, 100, 100));

        lbMes.add(jpImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 370, 110, 110));
        lbMes.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 650, 20));
        lbMes.add(txtApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 230, -1));

        lbApellido.setText("Apellido");
        lbMes.add(lbApellido, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        lbRCN.setText("Repita contraseña");
        lbMes.add(lbRCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 300, -1, -1));

        lbCN.setText("Contraseña nueva");
        lbMes.add(lbCN, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 270, -1, -1));

        lbFecha.setText("Fecha de Nac.");
        lbMes.add(lbFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 180, -1, -1));

        chkCambiarContra.setText("Cambiar contraseña");
        chkCambiarContra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chkCambiarContraActionPerformed(evt);
            }
        });
        lbMes.add(chkCambiarContra, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, -1, -1));

        grpPrivacidad.add(rbPublico);
        rbPublico.setText("Publico");
        lbMes.add(rbPublico, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 270, -1, -1));

        grpPrivacidad.add(rbPrivado);
        rbPrivado.setText("Privado");
        lbMes.add(rbPrivado, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 270, -1, -1));

        lbImagen1.setText("Imagen (opcional)");
        lbMes.add(lbImagen1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, 20));
        lbMes.add(dcFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 170, 20));

        btnQuitarImagen.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnQuitarImagen.setText("Quitar imagen");
        btnQuitarImagen.setToolTipText("");
        btnQuitarImagen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btnQuitarImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarImagenActionPerformed(evt);
            }
        });
        lbMes.add(btnQuitarImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 430, 170, 50));

        txtContraNueva2.setText("jPasswordField1");
        lbMes.add(txtContraNueva2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 300, 170, -1));

        txtContraNueva1.setText("jPasswordField1");
        lbMes.add(txtContraNueva1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 270, 170, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 960, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(lbMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
 private void listarUsuarios(ArrayList<DtUsuario> ListaUsuarios) {
        DefaultListModel modelo = new DefaultListModel();
        for (DtUsuario it : ListaUsuarios) {
            modelo.addElement(it.getNickname());
        }
        lstUsuarios.setModel(modelo);

    }

    private void desactivarCampos() {
        txtNombre.setEnabled(false);
        txtContraNueva1.setEnabled(false);
        txtContraNueva2.setEnabled(false);
        txtDescrpcion.setEnabled(false);
        txtNombreCanal.setEnabled(false);
        txtApellido.setEnabled(false);
        dcFecha.setEnabled(false);
        lbImg.setEnabled(false);
        lbMes.setEnabled(false);
        lbNombre.setEnabled(false);
        lbApellido.setEnabled(false);
        lbNombreC.setEnabled(false);
        lbCorreo.setEnabled(false);
        lbDescripcion.setEnabled(false);
        lbFecha.setEnabled(false);
        chkCambiarContra.setEnabled(false);
        rbPublico.setEnabled(false);
        rbPrivado.setEnabled(false);
        btnModificar.setEnabled(false);
        btnSeleccionar.setEnabled(false);
        btnQuitarImagen.setEnabled(false);
        txtDescrpcion.setEnabled(false);

    }

    private void activarCampos() {

        txtNombre.setEnabled(true);
        txtDescrpcion.setEnabled(true);
        txtNombreCanal.setEnabled(true);
        txtApellido.setEnabled(true);
        dcFecha.setEnabled(true);
        lbImg.setEnabled(true);
        lbMes.setEnabled(true);
        lbNombre.setEnabled(true);
        lbApellido.setEnabled(true);
        lbNombreC.setEnabled(true);
        lbCorreo.setEnabled(true);
        lbDescripcion.setEnabled(true);
        lbFecha.setEnabled(true);
        chkCambiarContra.setEnabled(true);
        rbPublico.setEnabled(true);
        rbPrivado.setEnabled(true);
        btnModificar.setEnabled(true);
        btnSeleccionar.setEnabled(true);
        btnQuitarImagen.setEnabled(true);
        txtDescrpcion.setEnabled(true);
    }

    private String seleccionarImagen() {
        // Crea un JFileChooser
        JFileChooser JFC = new JFileChooser();
        // crea un filtro para aceptar solo algunas extensiones
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
        // Agrega el filtro al JFileChooser
        JFC.setFileFilter(filtroImagen);

        // archivo seleccionado
        File archivo;
        // para saber si se selecciono algo o se cancelo
        int resultado;

        while (true) {
            // muestra el JFileChooser
            resultado = JFC.showOpenDialog(this);

            // Si pasa algo que no sea el aceptar
            if (resultado != JFileChooser.APPROVE_OPTION) {
                return "";
            }

            // obtiene el archivo seleccionado
            archivo = JFC.getSelectedFile();

            // Si se selecciono algun archivo
            if (archivo != null) {
                // obtiene la ruta del archivo
                String rutaArchivo = archivo.getAbsolutePath();
                // obtiene el archivo como imagen a partir de la ruta
                Image img = new ImageIcon(rutaArchivo).getImage();

                // verifica que tanto se deformará la imagen al mostrarla en un cuadrado
                float deformacion;
                if (img.getHeight(null) > img.getWidth(null)) {
                    deformacion = img.getHeight(null) / img.getWidth(null);
                } else {
                    deformacion = img.getWidth(null) / img.getHeight(null);
                }

                if (deformacion < 1.3 && deformacion >= 1) {
                    // si no se deforma demasiado
                    // devuelve la ruta absoluta
                    return rutaArchivo;
                } else {
                    // si se deforma demasiado, lo avisa al usuario para que escoja otra
                    JOptionPane.showMessageDialog(null,
                            "La imagen es demasiado alta o demasiado ancha.\n" + img.getWidth(null) + "x" + img.getHeight(null),
                            "Problemas con la imagen",
                            JOptionPane.WARNING_MESSAGE
                    );
                }
            } else {
                // sino devuelve un string vacio
                return "";
            }
        }
    }

    private void cargarImagenEnJlabel(javax.swing.JLabel jLabelx, String Ruta) {
        jLabelx.setText(null);
        // Carga la imagen a la variable de tipo Image
        Image img = new ImageIcon(Ruta).getImage();
        // Crea un ImageIcon a partir de la imagen (obtiene las dimenciones del jLbel y escala la imagen para que entre en el mismo)
        ImageIcon icono = new ImageIcon(
                img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH)
        );
        // establece la imagen en el label
        jLabelx.setIcon(icono);
    }

    private boolean validarNombres(String _nombre) {
        Pattern patronNombres = Pattern.compile("^([A-Za-zÑñÁáÉéÍíÓóÚú]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú]+)\\s*([A-Za-zÑñÁáÉéÍíÓóÚú]+)$");
        Matcher mather = patronNombres.matcher(_nombre);
        if (mather.find() == true) {
            return true;
        }
        return false;
    }

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        try {

            if (lstUsuarios.isSelectionEmpty()) {
                JOptionPane.showMessageDialog(null, "Seleccione un usuario para modificar", "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                if (txtNombre.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El campo nombre no puede quedar vacío", "Error", JOptionPane.WARNING_MESSAGE);
                } else {
                    txtNombre.setText(txtNombre.getText().trim());
                    if (!validarNombres(txtNombre.getText())) {
                        JOptionPane.showMessageDialog(null, "El nombre tiene caracteres no válidos", "Error", JOptionPane.WARNING_MESSAGE);
                    } else {
                        if (txtApellido.getText().isEmpty()) {
                            JOptionPane.showMessageDialog(null, "El campo apellido no puede quedar vacío", "Error", JOptionPane.WARNING_MESSAGE);
                        } else {
                            txtApellido.setText(txtNombre.getText().trim());
                            if (!validarNombres(txtApellido.getText())) {
                                JOptionPane.showMessageDialog(null, "El apellido tiene caracteres no válidos", "Error", JOptionPane.WARNING_MESSAGE);
                            } else {
                                if (txtNombreCanal.getText().isEmpty()) {
                                    JOptionPane.showMessageDialog(null, "El campo nombre de canal no puede quedar vacío", "Error", JOptionPane.WARNING_MESSAGE);
                                } else {
                                    txtNombreCanal.setText(txtNombre.getText().trim());
                                    String pass = user.getContrasenia();
                                    if (chkCambiarContra.isSelected()) {

                                        if (!(txtContraNueva1.getText().equals("") && txtContraNueva2.getText().equals(""))) {

                                            if (txtContraNueva1.getText().equals(txtContraNueva2.getText())) {
                                                pass = txtContraNueva1.getText();
                                            } else {
                                                JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden, no se pudo efectuar el cambio de contraseña. Inténtelo de nuevo", "OK", JOptionPane.WARNING_MESSAGE);
                                                txtContraNueva1.setText("");
                                                txtContraNueva2.setText("");
                                                return;
                                            }

                                        } else {
                                            JOptionPane.showMessageDialog(null, "Ingrese la contraseña nueva", "OK", JOptionPane.WARNING_MESSAGE);
                                            return;
                                        }
                                    }
                                    java.sql.Date fecha = null; //casteo fecha
                                    if (dcFecha.getDate() != null) {
                                        java.util.Date utilDate = dcFecha.getDate();
                                        fecha = new java.sql.Date(utilDate.getTime());
                                    }
                                    DtUsuario u = new DtUsuario(user.getNickname(), pass, txtNombre.getText(), txtApellido.getText(), user.getCorreo(), fecha, ruta, PROPERTIES);
                                    Privacidad priv;
                                    if (rbPrivado.isSelected()) {
                                        priv = Privacidad.PRIVADO;
                                    } else {
                                        priv = Privacidad.PUBLICO;
                                    }
                                    DtCanal c = new DtCanal(0, txtNombreCanal.getText(), txtDescrpcion.getText(), priv);
                                    sys.modificarUsuarioYCanal(u, c);

                                    JOptionPane.showMessageDialog(null, "Datos modificados correctamente", "OK", JOptionPane.INFORMATION_MESSAGE);
                                    dispose();

                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeleccionarActionPerformed
        //cargarImagen(lbImagen);
        String rutaAnterior = ruta;
        ruta = seleccionarImagen();
        if (ruta.isEmpty()) {
            ruta = rutaAnterior;
        }
        cargarImagenEnJlabel(lbImg, ruta);
    }//GEN-LAST:event_btnSeleccionarActionPerformed

    private void btnListaReprodiccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListaReprodiccionActionPerformed
        new frmModificarListaDeReproduccion(this, true, lstUsuarios.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_btnListaReprodiccionActionPerformed

    private void btnVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVideoActionPerformed
        new frmModificarVideo(this, true, lstUsuarios.getSelectedValue()).setVisible(true);
    }//GEN-LAST:event_btnVideoActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        sys.liberarMemoriaUsuario();
        dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed
    private void cargarDatosDelUsuario(DtUsuario u) {
        txtNombre.setText(u.getNombre());
        txtApellido.setText(u.getApellido());
        txtCorreo.setText(u.getCorreo());
        dcFecha.setDate(u.getFechaNacimiento());
        cargarImagenEnJlabel(lbImg, u.getImagen());

    }

    private void cargarDatosDelCanal(DtCanal c) {
        txtNombreCanal.setText(c.getNombre());
        txtDescrpcion.setText(c.getDescripcion());
        if (c.getPrivacidad() == Privacidad.PUBLICO) {
            rbPublico.setSelected(true);
        } else {
            rbPrivado.setSelected(true);
        }
    }


    private void lstUsuariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuariosValueChanged
        try {
            if (!lstUsuarios.isSelectionEmpty()) {
                activarCampos();
            }
            btnVideo.setEnabled(true);
            btnListaReprodiccion.setEnabled(true);
            String nick = lstUsuarios.getSelectedValue();
            user = sys.seleccionarUsuario(nick);
            cargarDatosDelUsuario(user);
            DtCanal dtc = sys.obtenerCanalDeUsuario();
            cargarDatosDelCanal(dtc);
            ruta = user.getImagen();
            txtContraNueva1.setText("");
            txtContraNueva2.setText("");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error", "Error", JOptionPane.ERROR_MESSAGE);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_lstUsuariosValueChanged

    private void chkCambiarContraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chkCambiarContraActionPerformed
        if (chkCambiarContra.isSelected()) {
            txtContraNueva1.setEnabled(true);
            txtContraNueva2.setEnabled(true);
            lbCN.setEnabled(true);
            lbRCN.setEnabled(true);

        } else {
            txtContraNueva1.setEnabled(false);
            txtContraNueva2.setEnabled(false);
            lbCN.setEnabled(false);
            lbRCN.setEnabled(false);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_chkCambiarContraActionPerformed

    private void btnQuitarImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarImagenActionPerformed
        // Quitar imagen
        ruta = "";
        cargarImagenEnJlabel(lbImg, ruta);
    }//GEN-LAST:event_btnQuitarImagenActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnListaReprodiccion;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnQuitarImagen;
    private javax.swing.JButton btnSeleccionar;
    private javax.swing.JButton btnVideo;
    private javax.swing.JCheckBox chkCambiarContra;
    private com.toedter.calendar.JDateChooser dcFecha;
    private javax.swing.ButtonGroup grpPrivacidad;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JPanel jpImagen;
    private javax.swing.JLabel lbApellido;
    private javax.swing.JLabel lbCN;
    private javax.swing.JLabel lbCorreo;
    private javax.swing.JLabel lbDescripcion;
    private javax.swing.JLabel lbFecha;
    private javax.swing.JLabel lbImagen1;
    private javax.swing.JLabel lbImg;
    private javax.swing.JPanel lbMes;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbNombreC;
    private javax.swing.JLabel lbRCN;
    private javax.swing.JList<String> lstUsuarios;
    private javax.swing.JRadioButton rbPrivado;
    private javax.swing.JRadioButton rbPublico;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JPasswordField txtContraNueva1;
    private javax.swing.JPasswordField txtContraNueva2;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextArea txtDescrpcion;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNombreCanal;
    // End of variables declaration//GEN-END:variables
}
