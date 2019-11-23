
package com.uytube.Presentacion.Video;

import com.uytube.Logica.DataType.DtComentario;
import com.uytube.Logica.DataType.DtUsuario;
import com.uytube.Logica.DataType.DtValoracion;
import com.uytube.Logica.DataType.DtVideo;
import com.uytube.Logica.Enumerados.TipoValoracion;
import com.uytube.Logica.Fabrica;
import com.uytube.Logica.Interfaces.IAdmin;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeModel;

public class frmConsultaVideo extends javax.swing.JDialog {

    private IAdmin sys;
    private ArrayList<DtVideo> listaDeVideos;
    private String enlace = "";
    private boolean liberarMemoria;
    
    public frmConsultaVideo(java.awt.Frame parent, boolean modal) {
        // Constructor para abrir ventana desde la ventana principal
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarElementosDeVentana();
        liberarMemoria = true;
        
        // quita el icono de carpetas en el JTree de comentarios
        javax.swing.tree.DefaultTreeCellRenderer render = (javax.swing.tree.DefaultTreeCellRenderer) treeComentarios.getCellRenderer();
        render.setLeafIcon(null);
        render.setOpenIcon(null);
        render.setClosedIcon(null);
        
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();

            // lista usuarios en el JList
            mostrarListaDeUsuarios(sys.listarUsuarios());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        
    }
    
    public frmConsultaVideo(javax.swing.JDialog parent, boolean modal, String nickname, int idVideo) {
        // Constructor para abrir ventana desde otro caso de uso
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(null);
        limpiarElementosDeVentana();
        liberarMemoria = false;
        
        // quita el icono de carpetas en el JTree de comentarios
        javax.swing.tree.DefaultTreeCellRenderer render = (javax.swing.tree.DefaultTreeCellRenderer) treeComentarios.getCellRenderer();
        render.setLeafIcon(null);
        render.setOpenIcon(null);
        render.setClosedIcon(null);
        
        try {
            // obtiene la instancia de sistema
            sys = Fabrica.getInstancia().getIAdmin();

            // El sistema ya tiene un usuario seleccionado
            // El sistema ya tiene un video seleccionado
            
            // lista usuarios en el JList
            mostrarListaDeUsuarios(sys.listarUsuarios());
            lstDuenioVideo.setSelectedValue(nickname, true);
            lstVideoUsuario.setSelectedValue(sys.seleccionarVideo(idVideo).getNombre(), true);
            //mostrarListaDeVideos(sys.listarVideosDeUsuario());
            
            lstDuenioVideo.setEnabled(false);
            lstVideoUsuario.setEnabled(false);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            dispose();
        }
        
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel15 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        lstDuenioVideo = new javax.swing.JList<>();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        lstVideoUsuario = new javax.swing.JList<>();
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
        jScrollPane25 = new javax.swing.JScrollPane();
        lstLike = new javax.swing.JList<>();
        jScrollPane26 = new javax.swing.JScrollPane();
        lstDislike = new javax.swing.JList<>();
        jScrollPane27 = new javax.swing.JScrollPane();
        treeComentarios = new javax.swing.JTree();
        jLabel99 = new javax.swing.JLabel();
        lbCantDisLikes = new javax.swing.JLabel();
        lbCantLikes = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        lbFechaPublicacion = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Consultar video");
        setResizable(false);

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Dueño del video:");
        jPanel15.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        lstDuenioVideo.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstDuenioVideoValueChanged(evt);
            }
        });
        jScrollPane22.setViewportView(lstDuenioVideo);

        jPanel15.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, 300));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Comentarios:");
        jPanel15.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 220, -1, -1));

        lstVideoUsuario.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstVideoUsuarioValueChanged(evt);
            }
        });
        jScrollPane23.setViewportView(lstVideoUsuario);

        jPanel15.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 160, 300));

        jLabel83.setText("Nombre:");
        jPanel15.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel84.setText("Duración:");
        jPanel15.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel85.setText("URL:");
        jPanel15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel86.setText("Descripción:");
        jPanel15.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 230, -1, -1));

        txtDescripcion.setEditable(false);
        txtDescripcion.setColumns(20);
        txtDescripcion.setLineWrap(true);
        txtDescripcion.setRows(5);
        jScrollPane24.setViewportView(txtDescripcion);

        jPanel15.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 250, 270, 130));

        jLabel87.setText("Privacidad:");
        jPanel15.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jLabel88.setText("Categoría:");
        jPanel15.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        lbNombre.setText(" ");
        jPanel15.add(lbNombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 50, 580, -1));

        lbDuracion.setText(" ");
        jPanel15.add(lbDuracion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, 580, -1));

        lbUrl.setText(" ");
        lbUrl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                lbUrlMousePressed(evt);
            }
        });
        jPanel15.add(lbUrl, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 580, -1));

        lbPrivacidad.setText(" ");
        jPanel15.add(lbPrivacidad, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 170, 580, -1));

        lbCategoria.setText(" ");
        jPanel15.add(lbCategoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 200, 580, -1));

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        btnAceptar.setText("Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        jPanel15.add(btnAceptar, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 510, 380, 60));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("Les gustó:");
        jPanel15.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("No les gustó:");
        jPanel15.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 400, -1, -1));

        jScrollPane25.setViewportView(lstLike);

        jPanel15.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 430, 290, 140));

        jScrollPane26.setViewportView(lstDislike);

        jPanel15.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 430, 300, 140));

        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        treeComentarios.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane27.setViewportView(treeComentarios);

        jPanel15.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 250, 380, 230));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setText("Video del Usuario:");
        jPanel15.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        lbCantDisLikes.setText(" ");
        jPanel15.add(lbCantDisLikes, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 400, 200, 20));

        lbCantLikes.setText(" ");
        jPanel15.add(lbCantLikes, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 400, 200, 20));

        jLabel89.setText("Publicación:");
        jPanel15.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        lbFechaPublicacion.setText(" ");
        jPanel15.add(lbFechaPublicacion, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 140, 580, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1069, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 1069, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
       // boton aceptar
        try {
            if (liberarMemoria){
                sys.liberarMemoriaUsuario();
            }
            sys.liberarMemoriaVideo();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }finally{
            dispose();
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void lstDuenioVideoValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstDuenioVideoValueChanged
        // seleccionar usuario 
        if (evt.getValueIsAdjusting()) return;
        if (lstDuenioVideo.getSelectedIndex()<0) return;
        try {
            String nick = lstDuenioVideo.getSelectedValue();
             sys.seleccionarUsuario(nick);
             listaDeVideos = sys.listarVideosDeUsuario();
            mostrarListaDeVideos(listaDeVideos);
            limpiarElementosDeVentana();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstDuenioVideoValueChanged

    private void lstVideoUsuarioValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstVideoUsuarioValueChanged
        // seleccionar video
        if (evt.getValueIsAdjusting()) return;
        if (lstVideoUsuario.getSelectedIndex()<0) return;
        try {
            int indexSeleccionado = lstVideoUsuario.getSelectedIndex();
            int idVideo = listaDeVideos.get(indexSeleccionado).getId();
            DtVideo dtv = sys.seleccionarVideo(idVideo);
            mostrarDatosDeVideo(dtv);
            mostrarListasDrValoraciones(sys.obtenerValoracionesDeVideo());
            mostrarListaDeComentarios(sys.listarComentariosDeVideo());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ha ocurrido un error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_lstVideoUsuarioValueChanged

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
    private void mostrarListaDeUsuarios(ArrayList<DtUsuario> ListaUsuarios){
        DefaultListModel modelo = new DefaultListModel();
        ListaUsuarios.forEach((it) -> {
            modelo.addElement(it.getNickname());
            // a que te dejo re loco este for
        });
        lstDuenioVideo.setModel(modelo);
        
    }
    private void mostrarListaDeVideos(ArrayList<DtVideo> listaVideos){
        DefaultListModel modelo = new DefaultListModel();
        for (DtVideo it : listaVideos) {
            modelo.addElement(it.getNombre());
        }
        lstVideoUsuario.setModel(modelo);
    }
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
    private void mostrarListasDrValoraciones(ArrayList<DtValoracion> lVal){
        DefaultListModel modeloLikes = new DefaultListModel();
        DefaultListModel modeloDisLikes = new DefaultListModel();
        for (DtValoracion it : lVal){
            if (it.getVal() == TipoValoracion.LIKE){
            modeloLikes.addElement(it.getNickname());
            }else{
            modeloDisLikes.addElement(it.getNickname());
            }
        }
        lstLike.setModel(modeloLikes);
        lstDislike.setModel(modeloDisLikes);
    }
    private void mostrarListaDeComentarios(ArrayList<DtComentario> lCom){
        // crea el nodo raiz
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Comentarios:");
        // agrega al nodo raiz toodos los comentarios
        agregarNodoATree(lCom, 0, raiz);

        // Carga el arbol en el TreeModel
        TreeModel datos = new DefaultTreeModel(raiz);
        // Carga el TreeModel en el JTree
        treeComentarios.setModel(datos);
        // la siguiente funcion la saque de stackoverflow
        expandAllNodes(treeComentarios, 0, treeComentarios.getRowCount());
    }
    private void expandAllNodes(javax.swing.JTree tree, int startingIndex, int rowCount) {
        // Extraido de:
        // https://stackoverflow.com/questions/15210979/how-do-i-auto-expand-a-jtree-when-setting-a-new-treemodel
        for (int i = startingIndex; i < rowCount; ++i) {
            tree.expandRow(i);
        }

        if (tree.getRowCount() != rowCount) {
            expandAllNodes(tree, rowCount, tree.getRowCount());
        }
    }
    private void agregarNodoATree(ArrayList<DtComentario> l, int e, DefaultMutableTreeNode nodoPadre){
        // si el array vacio, no hay nada que hacer
        if (e == l.size()){
            return;
        }
        
        // guardo el nivel del prmer comentario con el que se trabajara (no siempre sera el primer elemento del array)
        int nivelActual = l.get(e).getNivelSubComentario();
        // Variable para el nuevo comentario a procesar
        DefaultMutableTreeNode nodoComentario = null;
        // sera true si se ebe llamar a la recursividad
        boolean llamarRecursividad = false;
        
        // recorre los elementos desde el indice pasado como parametro hasta el final del array
        for (; e < l.size(); e++){
            // variable del comentario para trabajar en esta iteracion del for
            DtComentario coment = l.get(e);
            
            if (coment.getNivelSubComentario() == nivelActual) {
                // Si el coment esta al nivel a partir del cual se procesara
                // extrae los datos en un string
                String textoAMostrar = coment.getNickname() + ": " + coment.getTexto();
                // instancia el nodo con los datos
                nodoComentario = new DefaultMutableTreeNode(textoAMostrar);
                // lo agrega como hijo del nodo padre recibido como parametro
                nodoPadre.add(nodoComentario);
                // activa la recursividad en caso de que se encuentren hijos del comentario
                llamarRecursividad = true;
            }else if (coment.getNivelSubComentario() > nivelActual){
                // Si el comentario de esta iteracion es menor que el nivel a procesar
                
                // si hay que llamar recursividd
                if (llamarRecursividad){
                    // llama a recursividad pero pasando como nodo padre al comentario recien creado
                    agregarNodoATree(l, e, nodoComentario);
                    // en este punto ya se han agregado todos los hijos y nietos del comentario recien creado
                    // asi que ya no hay que llamar recursividad hasta agregar otro nodo en el primer if
                    llamarRecursividad = false;
                }
            }else{
                // si se encuentra un comentario de menor nivel al que se esta procesando
                // debe salir, esa es otra familia de comentarios
                return;
            }
        }
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
        // limpieza de listas
        lstLike.setModel(new DefaultListModel());
        lstDislike.setModel(new DefaultListModel());
        // limpieza de Arbol
        treeComentarios.setModel(new DefaultTreeModel(new DefaultMutableTreeNode("Comentarios:")));
    }
    public String obtenerTextoComoEnlace(String enlace, String texto) {
        // Extraido de
        // http://www.forosdelweb.com/f45/jlabel-como-hipervinculo-netbeans-948388/
        return"<html><a href=" + '"' + enlace + '"'+ ">" + texto + "</a></html>";
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JLabel lbCantDisLikes;
    private javax.swing.JLabel lbCantLikes;
    private javax.swing.JLabel lbCategoria;
    private javax.swing.JLabel lbDuracion;
    private javax.swing.JLabel lbFechaPublicacion;
    private javax.swing.JLabel lbNombre;
    private javax.swing.JLabel lbPrivacidad;
    private javax.swing.JLabel lbUrl;
    private javax.swing.JList<String> lstDislike;
    private javax.swing.JList<String> lstDuenioVideo;
    private javax.swing.JList<String> lstLike;
    private javax.swing.JList<String> lstVideoUsuario;
    private javax.swing.JTree treeComentarios;
    private javax.swing.JTextArea txtDescripcion;
    // End of variables declaration//GEN-END:variables
}
