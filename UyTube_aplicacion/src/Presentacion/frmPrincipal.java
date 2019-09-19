package Presentacion;

import Presentacion.Categoria.*;
import Presentacion.ListaDeReproduccion.*;
import Presentacion.Usuario.*;
import Presentacion.Video.*;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
    
public class frmPrincipal extends javax.swing.JFrame {

    private boolean sesionIniciada;
    
    public frmPrincipal() {
        initComponents();
        // centra la ventana y se maximiza
        this.setLocationRelativeTo(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        //tienes que agregar esto nada mas
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        
        // carga la imagen de fondo
        this.lbFondo.setText(null);
        Image img3 = new ImageIcon("Imagenes/des.jpeg").getImage();
        ImageIcon img4 = new ImageIcon(img3.getScaledInstance(lbFondo.getWidth(), lbFondo.getHeight(), Image.SCALE_SMOOTH));
        lbFondo.setIcon(img4);
        
        //#######  Descomentar la siguiente linea ###### //
        activarBarraDeMenu(false); // listo...
        sesionIniciada = false;
        mitCerrarSesion.setEnabled(false);
    }

    public Image getTconImage() {
        Image retValue = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagenes/icono.jpg"));
        return retValue;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jScrollPane36 = new javax.swing.JScrollPane();
        jList27 = new javax.swing.JList<>();
        privacidad_nuevoUsuario = new javax.swing.ButtonGroup();
        privacidad_modUsuario = new javax.swing.ButtonGroup();
        privacidad_modVideo = new javax.swing.ButtonGroup();
        valorarVideo = new javax.swing.ButtonGroup();
        privacidad_NuevaLR = new javax.swing.ButtonGroup();
        privacidad_modListaR = new javax.swing.ButtonGroup();
        tipo_nLR = new javax.swing.ButtonGroup();
        pnlFondo = new javax.swing.JDesktopPane();
        lbFondo = new javax.swing.JLabel();
        barraDeMenu = new javax.swing.JMenuBar();
        menuSesion = new javax.swing.JMenu();
        mitIniciarSesion = new javax.swing.JMenuItem();
        mitCerrarSesion = new javax.swing.JMenuItem();
        menuUsuario = new javax.swing.JMenu();
        mitNuevoUsuario = new javax.swing.JMenuItem();
        mitConsultaUsuario = new javax.swing.JMenuItem();
        mitModificarUsuario = new javax.swing.JMenuItem();
        mitListarUsuarios = new javax.swing.JMenuItem();
        mitSeguirUsuario = new javax.swing.JMenuItem();
        mitSeguirUsuario1 = new javax.swing.JMenuItem();
        menuVideo = new javax.swing.JMenu();
        mitNuevoVideo = new javax.swing.JMenuItem();
        mitModificarVideo = new javax.swing.JMenuItem();
        mitConsultarVideo = new javax.swing.JMenuItem();
        mitComentarVideo = new javax.swing.JMenuItem();
        mitValorarVideo = new javax.swing.JMenuItem();
        menuListaDeReproduccion = new javax.swing.JMenu();
        mitNuevaListaDeReproduccion = new javax.swing.JMenuItem();
        mitModificarListaDeReproduccion = new javax.swing.JMenuItem();
        mitConsultarListaDeReproduccion = new javax.swing.JMenuItem();
        mitAgregarVideoAListaDeReproduccion = new javax.swing.JMenuItem();
        mitQuitarVideoDeListaDeReproduccion = new javax.swing.JMenuItem();
        menuCategoria = new javax.swing.JMenu();
        mitNuevaCategoria = new javax.swing.JMenuItem();
        mitConsultarCategoria = new javax.swing.JMenuItem();
        mitListarCategorias = new javax.swing.JMenuItem();
        menuAbout = new javax.swing.JMenu();
        mitAcercaDeNos = new javax.swing.JMenuItem();

        jMenuItem14.setText("jMenuItem14");

        jMenuItem21.setText("jMenuItem21");

        jList27.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane36.setViewportView(jList27);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UyTube");
        setIconImage(getTconImage());
        setLocationByPlatform(true);
        setMinimumSize(new java.awt.Dimension(800, 525));
        setPreferredSize(new java.awt.Dimension(800, 525));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        pnlFondo.setBackground(new java.awt.Color(0, 0, 26));
        pnlFondo.setLayout(new java.awt.GridLayout(1, 0));

        lbFondo.setFont(new java.awt.Font("Dialog", 0, 48)); // NOI18N
        lbFondo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbFondo.setText("(  >  ) UyTube");
        pnlFondo.add(lbFondo);

        getContentPane().add(pnlFondo, java.awt.BorderLayout.CENTER);

        barraDeMenu.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        menuSesion.setText("Sesión");
        menuSesion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        mitIniciarSesion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitIniciarSesion.setText("Iniciar sesión");
        mitIniciarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitIniciarSesionActionPerformed(evt);
            }
        });
        menuSesion.add(mitIniciarSesion);

        mitCerrarSesion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitCerrarSesion.setText("Cerrar sesión");
        mitCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitCerrarSesionActionPerformed(evt);
            }
        });
        menuSesion.add(mitCerrarSesion);

        barraDeMenu.add(menuSesion);

        menuUsuario.setText("Usuario");
        menuUsuario.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        mitNuevoUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitNuevoUsuario.setText("Nuevo Usuario");
        mitNuevoUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNuevoUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(mitNuevoUsuario);

        mitConsultaUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitConsultaUsuario.setText("Consultar Usuario");
        mitConsultaUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitConsultaUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(mitConsultaUsuario);

        mitModificarUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitModificarUsuario.setText("Modificar Usuario");
        mitModificarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitModificarUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(mitModificarUsuario);

        mitListarUsuarios.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitListarUsuarios.setText("Listar Usuarios");
        mitListarUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitListarUsuariosActionPerformed(evt);
            }
        });
        menuUsuario.add(mitListarUsuarios);

        mitSeguirUsuario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitSeguirUsuario.setText("Seguir Usuario");
        mitSeguirUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSeguirUsuarioActionPerformed(evt);
            }
        });
        menuUsuario.add(mitSeguirUsuario);

        mitSeguirUsuario1.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitSeguirUsuario1.setText("Dejar de seguir usuario");
        mitSeguirUsuario1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitSeguirUsuario1ActionPerformed(evt);
            }
        });
        menuUsuario.add(mitSeguirUsuario1);

        barraDeMenu.add(menuUsuario);

        menuVideo.setText("Video");
        menuVideo.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        mitNuevoVideo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitNuevoVideo.setText("Nuevo Video");
        mitNuevoVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNuevoVideoActionPerformed(evt);
            }
        });
        menuVideo.add(mitNuevoVideo);

        mitModificarVideo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitModificarVideo.setText("Modificar Video");
        mitModificarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitModificarVideoActionPerformed(evt);
            }
        });
        menuVideo.add(mitModificarVideo);

        mitConsultarVideo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitConsultarVideo.setText("Consultar Video");
        mitConsultarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitConsultarVideoActionPerformed(evt);
            }
        });
        menuVideo.add(mitConsultarVideo);

        mitComentarVideo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitComentarVideo.setText("Comentar Video");
        mitComentarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitComentarVideoActionPerformed(evt);
            }
        });
        menuVideo.add(mitComentarVideo);

        mitValorarVideo.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitValorarVideo.setText("Valorar Video");
        mitValorarVideo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitValorarVideoActionPerformed(evt);
            }
        });
        menuVideo.add(mitValorarVideo);

        barraDeMenu.add(menuVideo);

        menuListaDeReproduccion.setText("Lista de reproducción");
        menuListaDeReproduccion.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        mitNuevaListaDeReproduccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitNuevaListaDeReproduccion.setText("Nueva Lista");
        mitNuevaListaDeReproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNuevaListaDeReproduccionActionPerformed(evt);
            }
        });
        menuListaDeReproduccion.add(mitNuevaListaDeReproduccion);

        mitModificarListaDeReproduccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitModificarListaDeReproduccion.setText("Modificar Lista");
        mitModificarListaDeReproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitModificarListaDeReproduccionActionPerformed(evt);
            }
        });
        menuListaDeReproduccion.add(mitModificarListaDeReproduccion);

        mitConsultarListaDeReproduccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitConsultarListaDeReproduccion.setText("Consultar Lista");
        mitConsultarListaDeReproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitConsultarListaDeReproduccionActionPerformed(evt);
            }
        });
        menuListaDeReproduccion.add(mitConsultarListaDeReproduccion);

        mitAgregarVideoAListaDeReproduccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitAgregarVideoAListaDeReproduccion.setText("Agregar Video");
        mitAgregarVideoAListaDeReproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAgregarVideoAListaDeReproduccionActionPerformed(evt);
            }
        });
        menuListaDeReproduccion.add(mitAgregarVideoAListaDeReproduccion);

        mitQuitarVideoDeListaDeReproduccion.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitQuitarVideoDeListaDeReproduccion.setText("Quitar Video");
        mitQuitarVideoDeListaDeReproduccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitQuitarVideoDeListaDeReproduccionActionPerformed(evt);
            }
        });
        menuListaDeReproduccion.add(mitQuitarVideoDeListaDeReproduccion);

        barraDeMenu.add(menuListaDeReproduccion);

        menuCategoria.setText("Categoría");
        menuCategoria.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        mitNuevaCategoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitNuevaCategoria.setText("Nueva Categoría");
        mitNuevaCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitNuevaCategoriaActionPerformed(evt);
            }
        });
        menuCategoria.add(mitNuevaCategoria);

        mitConsultarCategoria.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitConsultarCategoria.setText("Consultar Categoría");
        mitConsultarCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitConsultarCategoriaActionPerformed(evt);
            }
        });
        menuCategoria.add(mitConsultarCategoria);

        mitListarCategorias.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitListarCategorias.setText("Listar Categoría");
        mitListarCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitListarCategoriasActionPerformed(evt);
            }
        });
        menuCategoria.add(mitListarCategorias);

        barraDeMenu.add(menuCategoria);

        menuAbout.setText("About");
        menuAbout.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N

        mitAcercaDeNos.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        mitAcercaDeNos.setText("Acerca de nos");
        mitAcercaDeNos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mitAcercaDeNosActionPerformed(evt);
            }
        });
        menuAbout.add(mitAcercaDeNos);

        barraDeMenu.add(menuAbout);

        setJMenuBar(barraDeMenu);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mitIniciarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitIniciarSesionActionPerformed
        //Sesion->iniciarSecion
        
        frmInicioSesion login = new frmInicioSesion(this, true);
        login.setVisible(true);
        sesionIniciada = login.seInicioLaSesion();
        
        if (sesionIniciada){
            activarBarraDeMenu(true);
        mitCerrarSesion.setEnabled(true);
        mitIniciarSesion.setEnabled(false);
        }else{
            activarBarraDeMenu(false);
        }
    }//GEN-LAST:event_mitIniciarSesionActionPerformed

    private void mitCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitCerrarSesionActionPerformed
        //Sesion->cerrar secion
        sesionIniciada = false;
        mitCerrarSesion.setEnabled(false);
        mitIniciarSesion.setEnabled(true);
        activarBarraDeMenu(false);
    }//GEN-LAST:event_mitCerrarSesionActionPerformed

    private void mitNuevoUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNuevoUsuarioActionPerformed
        //Usiario->nuevo Usuario
        new frmAltaUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_mitNuevoUsuarioActionPerformed

    private void mitComentarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitComentarVideoActionPerformed
        //Video->comentar video
        new frmComentarVideo(this, true).setVisible(true);
    }//GEN-LAST:event_mitComentarVideoActionPerformed
    
    private void mitConsultaUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitConsultaUsuarioActionPerformed
        //Usuario->consultar usuario
        new frmConsultaUsuario(this, true).setVisible(true);
        
        /* Este codigo puede reciclarse quizas...
        Consultar_Usuario.setVisible(true);
        //jList1.addListSelectionListener(listener);
        String[] usr = new String[3];
        usr[0] = "MCBOLSO";
        usr[1] = "Juan_96";
        usr[2] = "Pepe_85";

        jList1.setListData(usr);
        //JOptionPane.showMessageDialog(null, jList1.getSele); 
        menuUsuario.setEnabled(false);
        menuVideo.setEnabled(false);
        menuListaDeReproduccion.setEnabled(false);
        menuCategoria.setEnabled(false);
        menuSesion.setEnabled(false);
        menuAbout.setEnabled(false);
        */
    }//GEN-LAST:event_mitConsultaUsuarioActionPerformed
    
    private void mitModificarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitModificarUsuarioActionPerformed
        //Usuario->modificar usuario
        new frmModificarUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_mitModificarUsuarioActionPerformed

    private void mitAcercaDeNosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAcercaDeNosActionPerformed
        //About->Acerca de nos
        new frmAcercaDeNos(this, true).setVisible(true);
    }//GEN-LAST:event_mitAcercaDeNosActionPerformed

    private void mitListarUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListarUsuariosActionPerformed
        //Usuario->listar usuario
        new frmListarUsuarios(this, true).setVisible(true);
    }//GEN-LAST:event_mitListarUsuariosActionPerformed

    private void mitSeguirUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSeguirUsuarioActionPerformed
        //usuario->seruir usuario->acptar
        new frmSeguirUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_mitSeguirUsuarioActionPerformed

    private void mitNuevoVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNuevoVideoActionPerformed
        // video->nuevo video
        new frmAltaVideo(this, true).setVisible(true);
    }//GEN-LAST:event_mitNuevoVideoActionPerformed

    private void mitModificarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitModificarVideoActionPerformed
        // video->modificar video
        new frmModificarVideo(this, true).setVisible(true);
    }//GEN-LAST:event_mitModificarVideoActionPerformed

    private void mitConsultarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitConsultarVideoActionPerformed
        // video->consultar video
        new frmConsultaVideo(this, true).setVisible(true);
    }//GEN-LAST:event_mitConsultarVideoActionPerformed

    private void mitValorarVideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitValorarVideoActionPerformed
        //vieo->calorar video->aceptar
        new frmValorarVideo(this, true).setVisible(true);
    }//GEN-LAST:event_mitValorarVideoActionPerformed

    private void mitNuevaListaDeReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNuevaListaDeReproduccionActionPerformed
        //lista_rep->nueva_list_rep
        new frmAltaListaDeReproduccion(this, true).setVisible(true);
    }//GEN-LAST:event_mitNuevaListaDeReproduccionActionPerformed

    private void mitModificarListaDeReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitModificarListaDeReproduccionActionPerformed
        //lista_rep->modificar
        new frmModificarListaDeReproduccion(this, true).setVisible(true);
    }//GEN-LAST:event_mitModificarListaDeReproduccionActionPerformed

    private void mitConsultarListaDeReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitConsultarListaDeReproduccionActionPerformed
        //listaRep->consultarlitRep
        new frmConsultaListaDeReproduccion(this, true).setVisible(true);
    }//GEN-LAST:event_mitConsultarListaDeReproduccionActionPerformed

    private void mitAgregarVideoAListaDeReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitAgregarVideoAListaDeReproduccionActionPerformed
        //listaRep->agregarVideo
        new frmAgregarVideoAListaDeReproduccion(this, true).setVisible(true);
    }//GEN-LAST:event_mitAgregarVideoAListaDeReproduccionActionPerformed

    private void mitQuitarVideoDeListaDeReproduccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitQuitarVideoDeListaDeReproduccionActionPerformed
        //listaRep->quitarVideo
        new frmQuitarVideoDeListaDeReproduccion(this, true).setVisible(true);
    }//GEN-LAST:event_mitQuitarVideoDeListaDeReproduccionActionPerformed

    private void mitNuevaCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitNuevaCategoriaActionPerformed
        //categoria->nuevaCat
        new frmAltaCategoria(this, true).setVisible(true);
    }//GEN-LAST:event_mitNuevaCategoriaActionPerformed

    private void mitListarCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitListarCategoriasActionPerformed
        //categoria->lisatr categoria
        new frmListarCategorias(this, true).setVisible(true);
    }//GEN-LAST:event_mitListarCategoriasActionPerformed

    private void mitConsultarCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitConsultarCategoriaActionPerformed
        //categoria->consultarCategoria
        new frmConsultaCategoria(this, true).setVisible(true);
    }//GEN-LAST:event_mitConsultarCategoriaActionPerformed

    private void mitSeguirUsuario1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mitSeguirUsuario1ActionPerformed
        // TODO add your handling code here:
        new frmDejarDeSeguirUsuario(this, true).setVisible(true);
    }//GEN-LAST:event_mitSeguirUsuario1ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // al cerrar la ventana
        int exit = JOptionPane.showConfirmDialog(
                this, /* Ventana padre*/
                "¿Seguro que quieres salir?", /* mensaje */
                "¿Seguro?", /* Titulo */
                JOptionPane.YES_NO_OPTION,  /* opciones en botones */
                JOptionPane.QUESTION_MESSAGE /* tipo de icono */
        );
        if (exit == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_formWindowClosing

    
    private void activarBarraDeMenu(boolean b){
        menuUsuario.setEnabled(b);
        menuListaDeReproduccion.setEnabled(b);
        menuVideo.setEnabled(b);
        menuCategoria.setEnabled(b);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Metal".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmPrincipal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraDeMenu;
    private javax.swing.JList<String> jList27;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JLabel lbFondo;
    private javax.swing.JMenu menuAbout;
    private javax.swing.JMenu menuCategoria;
    private javax.swing.JMenu menuListaDeReproduccion;
    private javax.swing.JMenu menuSesion;
    private javax.swing.JMenu menuUsuario;
    private javax.swing.JMenu menuVideo;
    private javax.swing.JMenuItem mitAcercaDeNos;
    private javax.swing.JMenuItem mitAgregarVideoAListaDeReproduccion;
    private javax.swing.JMenuItem mitCerrarSesion;
    private javax.swing.JMenuItem mitComentarVideo;
    private javax.swing.JMenuItem mitConsultaUsuario;
    private javax.swing.JMenuItem mitConsultarCategoria;
    private javax.swing.JMenuItem mitConsultarListaDeReproduccion;
    private javax.swing.JMenuItem mitConsultarVideo;
    private javax.swing.JMenuItem mitIniciarSesion;
    private javax.swing.JMenuItem mitListarCategorias;
    private javax.swing.JMenuItem mitListarUsuarios;
    private javax.swing.JMenuItem mitModificarListaDeReproduccion;
    private javax.swing.JMenuItem mitModificarUsuario;
    private javax.swing.JMenuItem mitModificarVideo;
    private javax.swing.JMenuItem mitNuevaCategoria;
    private javax.swing.JMenuItem mitNuevaListaDeReproduccion;
    private javax.swing.JMenuItem mitNuevoUsuario;
    private javax.swing.JMenuItem mitNuevoVideo;
    private javax.swing.JMenuItem mitQuitarVideoDeListaDeReproduccion;
    private javax.swing.JMenuItem mitSeguirUsuario;
    private javax.swing.JMenuItem mitSeguirUsuario1;
    private javax.swing.JMenuItem mitValorarVideo;
    private javax.swing.JDesktopPane pnlFondo;
    public static javax.swing.ButtonGroup privacidad_NuevaLR;
    public static javax.swing.ButtonGroup privacidad_modListaR;
    public static javax.swing.ButtonGroup privacidad_modUsuario;
    public static javax.swing.ButtonGroup privacidad_modVideo;
    public static javax.swing.ButtonGroup privacidad_nuevoUsuario;
    public static javax.swing.ButtonGroup tipo_nLR;
    public static javax.swing.ButtonGroup valorarVideo;
    // End of variables declaration//GEN-END:variables
}

    /*
    public boolean isIntegerTF(javax.swing.JTextField TF) {
        try {
            Integer.parseInt(TF.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    */