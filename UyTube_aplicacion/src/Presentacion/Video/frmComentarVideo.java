package Presentacion.Video;

import Logica.DataType.DtComentario;
import Logica.DataType.DtUsuario;
import Logica.DataType.DtVideo;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import java.sql.Date;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

public class frmComentarVideo extends javax.swing.JDialog {

    private IAdmin Sys;
    private ArrayList<DtVideo> VideosDelUser;
    private ArrayList<DtComentario> ComentariosDelVideo;

    public frmComentarVideo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        try {
            initComponents();
            this.setLocationRelativeTo(null);
            Fabrica f = Fabrica.getInstancia();
            Sys = f.getIAdmin();

            Sys.liberarMemoriaVideo();
            Sys.liberarMemoriaUsuarioActual();
            Sys.liberarMemoriaUsuario();

            // quita el icono de carpetas en el JTree de comentarios
            javax.swing.tree.DefaultTreeCellRenderer render = (javax.swing.tree.DefaultTreeCellRenderer) ArbolComentarios.getCellRenderer();
            render.setLeafIcon(null);
            render.setOpenIcon(null);
            render.setClosedIcon(null);

            ArrayList<DtUsuario> ListaUsuarios = Sys.listarUsuarios();

            DefaultListModel modelo = new DefaultListModel();
            DefaultListModel modelo2 = new DefaultListModel();
            for (DtUsuario it : ListaUsuarios) {
                modelo.addElement(it.getNickname());
                modelo2.addElement(it.getNickname());
            }
            lstUsuario.setModel(modelo);
            lstUsuarioComentador.setModel(modelo2);
            
            limpiarComponentesComentario(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel6 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        AreaComentario = new javax.swing.JTextArea();
        btnComentar = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        ArbolComentarios = new javax.swing.JTree();
        btnAceptar = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        lstUsuario = new javax.swing.JList<>();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane52 = new javax.swing.JScrollPane();
        lstVideos = new javax.swing.JList<>();
        jLabel150 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstUsuarioComentador = new javax.swing.JList<>();
        jLabel50 = new javax.swing.JLabel();
        DateCh = new com.toedter.calendar.JDateChooser();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Comentar video");

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        AreaComentario.setColumns(20);
        AreaComentario.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        AreaComentario.setRows(5);
        AreaComentario.setToolTipText("Ingrese aqui nuevo comentario");
        jScrollPane3.setViewportView(AreaComentario);

        jPanel6.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 280, 310, 90));

        btnComentar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnComentar.setText("Comentar");
        btnComentar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnComentarActionPerformed(evt);
            }
        });
        jPanel6.add(btnComentar, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 460, 210, 60));

        ArbolComentarios.setFont(new java.awt.Font("Dialog", 0, 12)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        ArbolComentarios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        ArbolComentarios.setToolTipText("");
        ArbolComentarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane4.setViewportView(ArbolComentarios);

        jPanel6.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 400, 380));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel6.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 460, 210, 60));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Comentarios:");
        jPanel6.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Texto del comentario:");
        jPanel6.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, -1, -1));

        lstUsuario.setToolTipText("");
        lstUsuario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuarioValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(lstUsuario);

        jPanel6.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 150, 150));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Usuario que comenta:");
        jPanel6.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 250, -1, -1));

        lstVideos.setToolTipText("");
        lstVideos.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVideosValueChanged(evt);
            }
        });
        jScrollPane52.setViewportView(lstVideos);

        jPanel6.add(jScrollPane52, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 50, 310, 150));

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel150.setText("Videos:");
        jPanel6.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 20, -1, -1));

        lstUsuarioComentador.setToolTipText("Seleccione usuario que realizara el nuevo comentario");
        lstUsuarioComentador.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsuarioComentadorValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstUsuarioComentador);

        jPanel6.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 280, 150, 150));

        jLabel50.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel50.setText("Propietario del video:");
        jPanel6.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));
        jPanel6.add(DateCh, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 390, 150, 30));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Fecha del comentario:");
        jPanel6.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 390, -1, -1));

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
    

    private boolean isSelected(TreePath d) {
        boolean b;
        try {
            DefaultMutableTreeNode l = (DefaultMutableTreeNode) d.getLastPathComponent();
            b = true;
        } catch (Exception e) {
            b = false;
        }
        return b;
    }

    private void agregarNodoATree(ArrayList<DtComentario> l, int e, DefaultMutableTreeNode nodoPadre) {
        // si el array vacio, no hay nada que hacer
        if (e == l.size()) {
            return;
        }
        // guardo el nivel del prmer comentario con el que se trabajara (no siempre sera el primer elemento del array)
        int nivelActual = l.get(e).getNivelSubComentario();
        // Variable para el nuevo comentario a procesar
        DefaultMutableTreeNode nodoComentario = null;
        // sera true si se ebe llamar a la recursividad
        boolean llamarRecursividad = false;

        // recorre los elementos desde el indice pasado como parametro hasta el final del array
        for (; e < l.size(); e++) {
            // variable del comentario para trabajar en esta iteracion del for
            DtComentario coment = l.get(e);

            if (coment.getNivelSubComentario() == nivelActual) {
                // Si el coment esta al nivel a partir del cual se procesara
                // extrae los datos en un string
                String textoAMostrar = coment.getNickname() + ": " + coment.getTexto();
                //String textoAMostrar = coment.getNickname() + ": " + coment.getTexto() +coment.getFecha().toString();
                // instancia el nodo con los datos
                nodoComentario = new DefaultMutableTreeNode(textoAMostrar);
                // lo agrega como hijo del nodo padre recibido como parametro
                nodoPadre.add(nodoComentario);
                // activa la recursividad en caso de que se encuentren hijos del comentario
                llamarRecursividad = true;
            } else if (coment.getNivelSubComentario() > nivelActual) {
                // Si el comentario de esta iteracion es menor que el nivel a procesar

                // si hay que llamar recursividd
                if (llamarRecursividad) {
                    // llama a recursividad pero pasando como nodo padre al comentario recien creado
                    agregarNodoATree(l, e, nodoComentario);
                    // en este punto ya se han agregado todos los hijos y nietos del comentario recien creado
                    // asi que ya no hay que llamar recursividad hasta agregar otro nodo en el primer if
                    llamarRecursividad = false;
                }
            } else {
                // si se encuentra un comentario de menor nivel al que se esta procesando
                // debe salir, esa es otra familia de comentarios
                return;
            }
        }
    }

    private int obtenerIndexComentarioSeleccionadoEnJTree(javax.swing.JTree arbol) {
        // Jtree auxiliar
        javax.swing.JTree aux = new javax.swing.JTree(arbol.getModel());
        // expande los nodos del JTree auxiliar
        for (int i = 0; i < aux.getRowCount(); i++) {
            aux.expandRow(i);
        }
        // Obtiene el numero de fila del elemento seleccionado
        // basandose en la ruta hasta el elemento
        return aux.getRowForPath(arbol.getSelectionPath()) - 1;
    }
    private void btnComentarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnComentarActionPerformed
        //Video->comentar video->comentar
        try {
            if (lstUsuarioComentador.getSelectedIndex() < 0){
                JOptionPane.showMessageDialog(null, "No ha seleccionado el usuario que realizará el comentario!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (AreaComentario.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "No ha escrito el comentario!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            if (DateCh.getDate() == null) {
                JOptionPane.showMessageDialog(null, "No ha seleccionado el usuario que realizará el comentario!", "¡Atención!", JOptionPane.WARNING_MESSAGE);
                return;
            }
            
            java.sql.Date fecha = null;
            java.util.Date utilDate = DateCh.getDate();//Obtiene la fecha del JDateChooser en formato Date
            fecha = new java.sql.Date(utilDate.getTime());//Lo combierte al tipo Date sql

            DtComentario dtc = new DtComentario(WIDTH, "", fecha, AreaComentario.getText(), 0);

            int index = obtenerIndexComentarioSeleccionadoEnJTree(ArbolComentarios);
            if (index < 0) {
                Sys.altaComentario(dtc);
            } else {
                ComentariosDelVideo = Sys.listarComentariosDeVideo();
                int comPad = ComentariosDelVideo.get(index).getId();
                Sys.altaComentario(dtc, comPad);
            }
            mostrarComentarios(Sys.listarComentariosDeVideo());
            AreaComentario.setText(""); //hacer esto en una funcion no seas desprolijo!
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnComentarActionPerformed

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        try {
            if (!AreaComentario.getText().isEmpty()) {
                int resp = JOptionPane.showConfirmDialog(null, "No se ha realizado el comentario\n¿Seguro que desea salir?", "¿Seguro que desea salir?", JOptionPane.YES_NO_OPTION);//yes 0, no 1.
                if (resp == 0) {
                    Sys.liberarMemoriaVideo();
                    Sys.liberarMemoriaUsuarioActual();
                    Sys.liberarMemoriaUsuario();
                    dispose();
                }
            } else {
                Sys.liberarMemoriaVideo();
                Sys.liberarMemoriaUsuarioActual();
                Sys.liberarMemoriaUsuario();
                dispose();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnAceptarActionPerformed
    
    private void mostrarComentarios(ArrayList<DtComentario> ComentariosDelVideo) {

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Comentarios:");
        agregarNodoATree(ComentariosDelVideo, 0, raiz);
        TreeModel datos = new DefaultTreeModel(raiz);
        ArbolComentarios.setModel(datos);
        for (int i = 0; i < ArbolComentarios.getRowCount(); i++) {//expande los nodos
            ArbolComentarios.expandRow(i);
        }
    }
    
    private void limpiarComponentesComentario(boolean habilitado){

        lstUsuarioComentador.clearSelection();
        lstUsuarioComentador.setEnabled(habilitado);
        
        AreaComentario.setText("");
        AreaComentario.setEnabled(habilitado);
        
        DateCh.setEnabled(habilitado);
        btnComentar.setEnabled(habilitado);
        
        java.util.Date hoyAhora = new java.util.Date();
        DateCh.setDate(hoyAhora);

        mostrarComentarios(new ArrayList<>());
        ArbolComentarios.setEnabled(habilitado);
    }
    
    private void lstUsuarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuarioValueChanged
        // Usuario seleccionado
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstUsuario.getSelectedIndex() < 0) {
            return;
        }

        lstVideos.clearSelection();
        String Nickname = lstUsuario.getSelectedValue();
        //lstVideos.setEnabled(true);

        try {
            DtUsuario user = Sys.seleccionarUsuario(Nickname);
            VideosDelUser = Sys.listarVideosDeUsuario();

            DefaultListModel modelo = new DefaultListModel();
            for (DtVideo it : VideosDelUser) {
                modelo.addElement(it.getNombre());
            }
            lstVideos.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstUsuarioValueChanged

    private void lstVideosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVideosValueChanged
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstVideos.getSelectedIndex() < 0) {
            limpiarComponentesComentario(false);
            return;
        }
        limpiarComponentesComentario(true);
        try {
            //lstUsuarioValoradoR.clearSelection();
            int VideoIndex = lstVideos.getSelectedIndex();
            int IDvideo = VideosDelUser.get(VideoIndex).getId();
            Sys.seleccionarVideo(IDvideo);

            mostrarComentarios(Sys.listarComentariosDeVideo());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstVideosValueChanged

    private void lstUsuarioComentadorValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstUsuarioComentadorValueChanged
        // Usuario seleccionado
        if (evt.getValueIsAdjusting()) {
            return;
        }
        if (lstUsuarioComentador.getSelectedIndex() < 0) {
            return;
        }

        String Nickname = lstUsuarioComentador.getSelectedValue();

        try {
            DtUsuario user = Sys.seleccionarUsuarioActual(Nickname);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error \n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstUsuarioComentadorValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTree ArbolComentarios;
    private javax.swing.JTextArea AreaComentario;
    private com.toedter.calendar.JDateChooser DateCh;
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnComentar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JList<String> lstUsuario;
    private javax.swing.JList<String> lstUsuarioComentador;
    private javax.swing.JList<String> lstVideos;
    // End of variables declaration//GEN-END:variables
}
