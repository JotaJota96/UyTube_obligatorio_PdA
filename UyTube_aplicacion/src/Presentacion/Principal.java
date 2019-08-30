package Presentacion;

import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.UIManager;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        DatosDePrueba.cargarDatos();
        
        initComponents();
        Inicio_Sesion.setVisible(false);
        Nuevo_Usuario.setVisible(false);
        Comentar_video.setVisible(false);
        Consultar_Usuario.setVisible(false);
        Modificar_Usuario.setVisible(false);
        About.setVisible(false);
        ListarUsuarios.setVisible(false);
        SeguirUsuarios.setVisible(false);
        altaVideo.setVisible(false);
        Modificar_Video.setVisible(false);
        Consultar_Video.setVisible(false);
        Valorar_Video.setVisible(false);
        NuevaListaRepro.setVisible(false);
        Modificar_list_rep.setVisible(false);
        ConsultaList_rep.setVisible(false);
        agregar_video_listRep.setVisible(false);
        quitar_video_listRep.setVisible(false);
        nueva_Categoria.setVisible(false);
        listar_categorias.setVisible(false);
        Consulta_categoria.setVisible(false);
        RB_particular.setSelected(true);

        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        this.setLocationRelativeTo(null);

        jSpinner1.setValue(1992);
        jSpinner2.setValue(6);
        jSpinner3.setValue(15);

        jSpinner13.setValue(1992);
        jSpinner14.setValue(6);
        jSpinner15.setValue(15);

        jSpinner7.setValue(2019);
        jSpinner8.setValue(8);
        jSpinner9.setValue(15);

        jSpinner10.setValue(1992);
        jSpinner11.setValue(6);
        jSpinner12.setValue(15);

        jSpinner19.setValue(2019);
        jSpinner20.setValue(8);
        jSpinner21.setValue(15);

        jLabel38.setText(null);
        Image img7 = new ImageIcon("Imagenes/about.png").getImage();
        ImageIcon img8 = new ImageIcon(img7.getScaledInstance(jLabel38.getWidth(), jLabel38.getHeight(), Image.SCALE_SMOOTH));
        jLabel38.setIcon(img8);

        jLabel2.setText(null);
        Image img = new ImageIcon("Imagenes/ukp.png").getImage();
        ImageIcon img2 = new ImageIcon(img.getScaledInstance(jLabel2.getWidth(), jLabel2.getHeight(), Image.SCALE_SMOOTH));
        jLabel2.setIcon(img2);

        this.jLabel16.setText(null);
        Image img3 = new ImageIcon("Imagenes/des.jpeg").getImage();
        ImageIcon img4 = new ImageIcon(img3.getScaledInstance(jLabel16.getWidth(), jLabel16.getHeight(), Image.SCALE_SMOOTH));
        jLabel16.setIcon(img4);

        jTree1.setRootVisible(false);
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
        Consultar_Usuario = new javax.swing.JInternalFrame();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList<>();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel30 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTextArea3 = new javax.swing.JTextArea();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        jList4 = new javax.swing.JList<>();
        jScrollPane9 = new javax.swing.JScrollPane();
        jList5 = new javax.swing.JList<>();
        jButton22 = new javax.swing.JButton();
        jLabel79 = new javax.swing.JLabel();
        jLabel80 = new javax.swing.JLabel();
        jScrollPane20 = new javax.swing.JScrollPane();
        jList13 = new javax.swing.JList<>();
        jScrollPane21 = new javax.swing.JScrollPane();
        jList14 = new javax.swing.JList<>();
        jLabel51 = new javax.swing.JLabel();
        Comentar_video = new javax.swing.JInternalFrame();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton4 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTree2 = new javax.swing.JTree();
        jButton6 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList<>();
        jLabel45 = new javax.swing.JLabel();
        jScrollPane52 = new javax.swing.JScrollPane();
        jList42 = new javax.swing.JList<>();
        jLabel150 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jSpinner19 = new javax.swing.JSpinner();
        jSpinner20 = new javax.swing.JSpinner();
        jSpinner21 = new javax.swing.JSpinner();
        jLabel47 = new javax.swing.JLabel();
        jLabel48 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        Inicio_Sesion = new javax.swing.JInternalFrame();
        jPanel4 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jPasswordField1 = new javax.swing.JPasswordField();
        Nuevo_Usuario = new javax.swing.JInternalFrame();
        jPanel2 = new javax.swing.JPanel();
        jButton3 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jTextField5 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextField8 = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel14 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel3 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jSpinner1 = new javax.swing.JSpinner();
        jSpinner2 = new javax.swing.JSpinner();
        jSpinner3 = new javax.swing.JSpinner();
        jRadioButton4 = new javax.swing.JRadioButton();
        jButton9 = new javax.swing.JButton();
        jLabel42 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        SeguirUsuarios = new javax.swing.JInternalFrame();
        jPanel12 = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        jList6 = new javax.swing.JList<>();
        jScrollPane12 = new javax.swing.JScrollPane();
        jList7 = new javax.swing.JList<>();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jButton15 = new javax.swing.JButton();
        jButton16 = new javax.swing.JButton();
        jButton17 = new javax.swing.JButton();
        ListarUsuarios = new javax.swing.JInternalFrame();
        jPanel11 = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        jList3 = new javax.swing.JList<>();
        jLabel60 = new javax.swing.JLabel();
        jButton14 = new javax.swing.JButton();
        quitar_video_listRep = new javax.swing.JInternalFrame();
        jPanel22 = new javax.swing.JPanel();
        jLabel118 = new javax.swing.JLabel();
        jScrollPane43 = new javax.swing.JScrollPane();
        jList34 = new javax.swing.JList<>();
        jButton29 = new javax.swing.JButton();
        jLabel119 = new javax.swing.JLabel();
        jScrollPane44 = new javax.swing.JScrollPane();
        jList35 = new javax.swing.JList<>();
        jLabel120 = new javax.swing.JLabel();
        jScrollPane45 = new javax.swing.JScrollPane();
        jList36 = new javax.swing.JList<>();
        Aceptar_NLR3 = new javax.swing.JButton();
        altaVideo = new javax.swing.JInternalFrame();
        jPanel13 = new javax.swing.JPanel();
        jLabel63 = new javax.swing.JLabel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jList8 = new javax.swing.JList<>();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        jLabel67 = new javax.swing.JLabel();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jScrollPane14 = new javax.swing.JScrollPane();
        jList9 = new javax.swing.JList<>();
        jLabel70 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jSpinner7 = new javax.swing.JSpinner();
        jSpinner8 = new javax.swing.JSpinner();
        jSpinner9 = new javax.swing.JSpinner();
        jScrollPane15 = new javax.swing.JScrollPane();
        jTextArea5 = new javax.swing.JTextArea();
        jButton18 = new javax.swing.JButton();
        jButton19 = new javax.swing.JButton();
        jSpinner4 = new javax.swing.JSpinner();
        jSpinner5 = new javax.swing.JSpinner();
        jSpinner6 = new javax.swing.JSpinner();
        jLabel135 = new javax.swing.JLabel();
        jLabel136 = new javax.swing.JLabel();
        jLabel137 = new javax.swing.JLabel();
        jLabel138 = new javax.swing.JLabel();
        jLabel139 = new javax.swing.JLabel();
        jLabel140 = new javax.swing.JLabel();
        Modificar_Video = new javax.swing.JInternalFrame();
        jPanel14 = new javax.swing.JPanel();
        jButton20 = new javax.swing.JButton();
        jButton21 = new javax.swing.JButton();
        jScrollPane16 = new javax.swing.JScrollPane();
        jList10 = new javax.swing.JList<>();
        jLabel71 = new javax.swing.JLabel();
        jScrollPane17 = new javax.swing.JScrollPane();
        jList11 = new javax.swing.JList<>();
        jLabel72 = new javax.swing.JLabel();
        jTextField10 = new javax.swing.JTextField();
        jLabel73 = new javax.swing.JLabel();
        jLabel74 = new javax.swing.JLabel();
        jLabel75 = new javax.swing.JLabel();
        jTextField15 = new javax.swing.JTextField();
        jLabel76 = new javax.swing.JLabel();
        jScrollPane18 = new javax.swing.JScrollPane();
        jTextArea6 = new javax.swing.JTextArea();
        jLabel77 = new javax.swing.JLabel();
        jSpinner10 = new javax.swing.JSpinner();
        jSpinner11 = new javax.swing.JSpinner();
        jSpinner12 = new javax.swing.JSpinner();
        jLabel78 = new javax.swing.JLabel();
        jScrollPane19 = new javax.swing.JScrollPane();
        jList12 = new javax.swing.JList<>();
        jRadioButton5 = new javax.swing.JRadioButton();
        jRadioButton6 = new javax.swing.JRadioButton();
        jSpinner16 = new javax.swing.JSpinner();
        jLabel144 = new javax.swing.JLabel();
        jSpinner17 = new javax.swing.JSpinner();
        jLabel145 = new javax.swing.JLabel();
        jSpinner18 = new javax.swing.JSpinner();
        jLabel146 = new javax.swing.JLabel();
        jLabel147 = new javax.swing.JLabel();
        jLabel148 = new javax.swing.JLabel();
        jLabel149 = new javax.swing.JLabel();
        Valorar_Video = new javax.swing.JInternalFrame();
        jPanel16 = new javax.swing.JPanel();
        jScrollPane28 = new javax.swing.JScrollPane();
        jList19 = new javax.swing.JList<>();
        jScrollPane29 = new javax.swing.JScrollPane();
        jList20 = new javax.swing.JList<>();
        jLabel96 = new javax.swing.JLabel();
        jLabel97 = new javax.swing.JLabel();
        jScrollPane30 = new javax.swing.JScrollPane();
        jList21 = new javax.swing.JList<>();
        jLabel98 = new javax.swing.JLabel();
        jRadioButton7 = new javax.swing.JRadioButton();
        jRadioButton8 = new javax.swing.JRadioButton();
        jButton8 = new javax.swing.JButton();
        jButton23 = new javax.swing.JButton();
        ConsultaList_rep = new javax.swing.JInternalFrame();
        jPanel20 = new javax.swing.JPanel();
        jButton24 = new javax.swing.JButton();
        jLabel106 = new javax.swing.JLabel();
        jLabel107 = new javax.swing.JLabel();
        jScrollPane37 = new javax.swing.JScrollPane();
        jList28 = new javax.swing.JList<>();
        jScrollPane38 = new javax.swing.JScrollPane();
        jList29 = new javax.swing.JList<>();
        jLabel108 = new javax.swing.JLabel();
        jLabel109 = new javax.swing.JLabel();
        jLabel110 = new javax.swing.JLabel();
        jLabel111 = new javax.swing.JLabel();
        jScrollPane39 = new javax.swing.JScrollPane();
        jList30 = new javax.swing.JList<>();
        jButton27 = new javax.swing.JButton();
        jLabel112 = new javax.swing.JLabel();
        jLabel113 = new javax.swing.JLabel();
        jLabel114 = new javax.swing.JLabel();
        Consultar_Video = new javax.swing.JInternalFrame();
        jPanel15 = new javax.swing.JPanel();
        jLabel81 = new javax.swing.JLabel();
        jScrollPane22 = new javax.swing.JScrollPane();
        jList15 = new javax.swing.JList<>();
        jLabel82 = new javax.swing.JLabel();
        jScrollPane23 = new javax.swing.JScrollPane();
        jList16 = new javax.swing.JList<>();
        jLabel83 = new javax.swing.JLabel();
        jLabel84 = new javax.swing.JLabel();
        jLabel85 = new javax.swing.JLabel();
        jLabel86 = new javax.swing.JLabel();
        jScrollPane24 = new javax.swing.JScrollPane();
        jTextArea7 = new javax.swing.JTextArea();
        jLabel87 = new javax.swing.JLabel();
        jLabel88 = new javax.swing.JLabel();
        jLabel89 = new javax.swing.JLabel();
        jLabel90 = new javax.swing.JLabel();
        jLabel91 = new javax.swing.JLabel();
        jLabel92 = new javax.swing.JLabel();
        jLabel93 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel94 = new javax.swing.JLabel();
        jLabel95 = new javax.swing.JLabel();
        jScrollPane25 = new javax.swing.JScrollPane();
        jList17 = new javax.swing.JList<>();
        jScrollPane26 = new javax.swing.JScrollPane();
        jList18 = new javax.swing.JList<>();
        jScrollPane27 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jLabel99 = new javax.swing.JLabel();
        NuevaListaRepro = new javax.swing.JInternalFrame();
        jPanel17 = new javax.swing.JPanel();
        jLabel100 = new javax.swing.JLabel();
        jTextField16 = new javax.swing.JTextField();
        jPanel18 = new javax.swing.JPanel();
        jLabel101 = new javax.swing.JLabel();
        jScrollPane31 = new javax.swing.JScrollPane();
        jList22 = new javax.swing.JList<>();
        jRadioButton11 = new javax.swing.JRadioButton();
        jRadioButton12 = new javax.swing.JRadioButton();
        jLabel102 = new javax.swing.JLabel();
        jScrollPane32 = new javax.swing.JScrollPane();
        jList23 = new javax.swing.JList<>();
        Aceptar_NLR = new javax.swing.JButton();
        jButton25 = new javax.swing.JButton();
        jPanel26 = new javax.swing.JPanel();
        RB_porDefecto = new javax.swing.JRadioButton();
        RB_particular = new javax.swing.JRadioButton();
        Modificar_list_rep = new javax.swing.JInternalFrame();
        jPanel19 = new javax.swing.JPanel();
        jScrollPane33 = new javax.swing.JScrollPane();
        jList24 = new javax.swing.JList<>();
        jLabel103 = new javax.swing.JLabel();
        jScrollPane34 = new javax.swing.JScrollPane();
        jList25 = new javax.swing.JList<>();
        jLabel104 = new javax.swing.JLabel();
        jRadioButton13 = new javax.swing.JRadioButton();
        jRadioButton14 = new javax.swing.JRadioButton();
        jButton26 = new javax.swing.JButton();
        Aceptar_NLR1 = new javax.swing.JButton();
        jLabel105 = new javax.swing.JLabel();
        jScrollPane35 = new javax.swing.JScrollPane();
        jList26 = new javax.swing.JList<>();
        agregar_video_listRep = new javax.swing.JInternalFrame();
        jPanel21 = new javax.swing.JPanel();
        jScrollPane40 = new javax.swing.JScrollPane();
        jList31 = new javax.swing.JList<>();
        jScrollPane41 = new javax.swing.JScrollPane();
        jList32 = new javax.swing.JList<>();
        jScrollPane42 = new javax.swing.JScrollPane();
        jList33 = new javax.swing.JList<>();
        jLabel115 = new javax.swing.JLabel();
        jLabel116 = new javax.swing.JLabel();
        jLabel117 = new javax.swing.JLabel();
        jButton28 = new javax.swing.JButton();
        Aceptar_NLR2 = new javax.swing.JButton();
        nueva_Categoria = new javax.swing.JInternalFrame();
        jPanel23 = new javax.swing.JPanel();
        jLabel121 = new javax.swing.JLabel();
        jButton30 = new javax.swing.JButton();
        jButton31 = new javax.swing.JButton();
        jTextField17 = new javax.swing.JTextField();
        listar_categorias = new javax.swing.JInternalFrame();
        jPanel24 = new javax.swing.JPanel();
        jButton32 = new javax.swing.JButton();
        jScrollPane46 = new javax.swing.JScrollPane();
        jList37 = new javax.swing.JList<>();
        jLabel122 = new javax.swing.JLabel();
        Consulta_categoria = new javax.swing.JInternalFrame();
        jPanel25 = new javax.swing.JPanel();
        jButton33 = new javax.swing.JButton();
        jLabel123 = new javax.swing.JLabel();
        jScrollPane47 = new javax.swing.JScrollPane();
        jList38 = new javax.swing.JList<>();
        jLabel124 = new javax.swing.JLabel();
        jScrollPane48 = new javax.swing.JScrollPane();
        jList39 = new javax.swing.JList<>();
        jLabel125 = new javax.swing.JLabel();
        jScrollPane49 = new javax.swing.JScrollPane();
        jList40 = new javax.swing.JList<>();
        About = new javax.swing.JInternalFrame();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jButton10 = new javax.swing.JButton();
        Modificar_Usuario = new javax.swing.JInternalFrame();
        jPanel7 = new javax.swing.JPanel();
        jLabel126 = new javax.swing.JLabel();
        jLabel127 = new javax.swing.JLabel();
        jLabel128 = new javax.swing.JLabel();
        jTextField18 = new javax.swing.JTextField();
        jTextField19 = new javax.swing.JTextField();
        jLabel129 = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel130 = new javax.swing.JLabel();
        jSpinner13 = new javax.swing.JSpinner();
        jSpinner14 = new javax.swing.JSpinner();
        jSpinner15 = new javax.swing.JSpinner();
        jLabel131 = new javax.swing.JLabel();
        jScrollPane50 = new javax.swing.JScrollPane();
        jList41 = new javax.swing.JList<>();
        jButton34 = new javax.swing.JButton();
        jButton35 = new javax.swing.JButton();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel132 = new javax.swing.JLabel();
        jLabel133 = new javax.swing.JLabel();
        jTextField20 = new javax.swing.JTextField();
        jLabel134 = new javax.swing.JLabel();
        jScrollPane51 = new javax.swing.JScrollPane();
        jTextArea8 = new javax.swing.JTextArea();
        jRadioButton15 = new javax.swing.JRadioButton();
        jRadioButton16 = new javax.swing.JRadioButton();
        B_LR = new javax.swing.JButton();
        B_Video = new javax.swing.JButton();
        jButton38 = new javax.swing.JButton();
        jPanel27 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jSeparator6 = new javax.swing.JSeparator();
        jLabel141 = new javax.swing.JLabel();
        jLabel142 = new javax.swing.JLabel();
        jLabel143 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel16 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem11 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();
        jMenuItem19 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem22 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem23 = new javax.swing.JMenuItem();
        jMenuItem24 = new javax.swing.JMenuItem();
        jMenuItem25 = new javax.swing.JMenuItem();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem26 = new javax.swing.JMenuItem();

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
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Consultar_Usuario.setTitle("Consultar Usuario");
        Consultar_Usuario.setVisible(true);
        Consultar_Usuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel17.setText("Eliga un usuario:");
        jPanel6.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jList1);

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
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, 90));

        jPanel6.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 230, 100, 90));
        jPanel6.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 190, 210, 20));

        jLabel26.setText(" ");
        jPanel6.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 160, 260, 20));

        jLabel27.setText(" ");
        jPanel6.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 130, 260, -1));

        jLabel28.setText(" ");
        jPanel6.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 100, 260, -1));

        jLabel29.setText(" ");
        jPanel6.add(jLabel29, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 260, -1));
        jPanel6.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 550, 10));

        jLabel30.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel30.setText("Canal:");
        jPanel6.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 360, -1, -1));

        jLabel32.setText("Descripcion:");
        jPanel6.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 390, -1, -1));

        jTextArea3.setColumns(20);
        jTextArea3.setRows(5);
        jScrollPane5.setViewportView(jTextArea3);

        jPanel6.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, 290, 100));

        jSeparator4.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel6.add(jSeparator4, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 0, 10, 560));

        jLabel36.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel36.setText(" ");
        jPanel6.add(jLabel36, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 450, 120, 40));

        jLabel37.setText(" ");
        jPanel6.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, 110, -1));
        jPanel6.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 230, 440, 10));

        jLabel39.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel39.setText("Segidores:");
        jPanel6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 20, -1, -1));

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel40.setText("Segidos:");
        jPanel6.add(jLabel40, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 20, -1, -1));

        jScrollPane8.setViewportView(jList4);

        jPanel6.add(jScrollPane8, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 50, 160, 150));

        jScrollPane9.setViewportView(jList5);

        jPanel6.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 50, 160, 150));

        jButton22.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton22.setText("Aceptar");
        jButton22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton22ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton22, new org.netbeans.lib.awtextra.AbsoluteConstraints(593, 480, 360, 50));

        jLabel79.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel79.setText("Videos:");
        jPanel6.add(jLabel79, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 240, -1, -1));

        jLabel80.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel80.setText("Listas de Reproduccion:");
        jPanel6.add(jLabel80, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 240, -1, -1));

        jScrollPane20.setViewportView(jList13);

        jPanel6.add(jScrollPane20, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 270, 160, 190));

        jScrollPane21.setViewportView(jList14);

        jPanel6.add(jScrollPane21, new org.netbeans.lib.awtextra.AbsoluteConstraints(790, 272, 160, 190));

        jLabel51.setBorder(javax.swing.BorderFactory.createTitledBorder("Privacidad"));
        jPanel6.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 410, 170, 110));

        Consultar_Usuario.getContentPane().add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(Consultar_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        Comentar_video.setClosable(true);
        Comentar_video.setTitle("Comentar Video");
        Comentar_video.setVisible(true);
        Comentar_video.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTextArea2.setColumns(20);
        jTextArea2.setFont(new java.awt.Font("Monospaced", 0, 24)); // NOI18N
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel5.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 360, 410, 170));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton4.setText("Comentar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 470, 210, 60));

        jTree2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        javax.swing.tree.DefaultMutableTreeNode treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree2.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jTree2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jScrollPane3.setViewportView(jTree2);

        jPanel5.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 370, 260));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton6.setText("Terminar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 470, 210, 60));

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel15.setText("Comentarios:");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jLabel35.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel35.setText("Ingrese comentario");
        jPanel5.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, -1));

        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane6.setViewportView(jList2);

        jPanel5.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 240, 380));

        jLabel45.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel45.setText("Eliga un usuario:");
        jPanel5.add(jLabel45, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane52.setViewportView(jList42);

        jPanel5.add(jScrollPane52, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 50, 250, 260));

        jLabel150.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel150.setText("Videos:");
        jPanel5.add(jLabel150, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 20, -1, -1));

        jLabel46.setText("Ingrese Fecha del comentario:");
        jPanel5.add(jLabel46, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 350, -1, -1));
        jPanel5.add(jSpinner19, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 400, 70, -1));
        jPanel5.add(jSpinner20, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 400, 50, -1));
        jPanel5.add(jSpinner21, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 400, 50, -1));

        jLabel47.setText("Dia");
        jPanel5.add(jLabel47, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 380, -1, -1));

        jLabel48.setText("Mes");
        jPanel5.add(jLabel48, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 380, -1, -1));

        jLabel49.setText("Año");
        jPanel5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 380, -1, -1));

        Comentar_video.getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(Comentar_video, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        Inicio_Sesion.setClosable(true);
        Inicio_Sesion.setTitle("Inicio de sesion");
        Inicio_Sesion.setVisible(true);
        Inicio_Sesion.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Nro de Empleado");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 30, -1, -1));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 30, 160, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Contraseña");
        jPanel4.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Cancelar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 150, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setText("Iniciar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 130, 150, 40));
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 110, 100));

        jPasswordField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel4.add(jPasswordField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 80, 160, 30));

        Inicio_Sesion.getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 190));

        getContentPane().add(Inicio_Sesion, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 150, 460, 220));
        try {
            Inicio_Sesion.setMaximum(true);
        } catch (java.beans.PropertyVetoException e1) {
            e1.printStackTrace();
        }

        Nuevo_Usuario.setClosable(true);
        Nuevo_Usuario.setTitle("Nuevo Usuario");
        Nuevo_Usuario.setVisible(true);
        Nuevo_Usuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton3.setText("Selecionar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 270, 130, 70));

        jLabel1.setText("Nickname");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, -1, -1));

        jLabel3.setText("Nombre");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, -1, -1));

        jLabel6.setText("Apellido");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jLabel7.setText("Dia");
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 210, -1, -1));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Usuario");
        jPanel2.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));
        jPanel2.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 270, -1));
        jPanel2.add(jTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 270, -1));
        jPanel2.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 270, -1));
        jPanel2.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 270, -1));

        jLabel9.setText("Fecha de nacimiento");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Canal");
        jPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, -1, -1));

        jLabel12.setText("Nombre");
        jPanel2.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 60, -1, -1));

        jLabel13.setText("Descripción");
        jPanel2.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, -1, -1));

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 120, 410, 200));
        jPanel2.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 60, 290, -1));

        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel2.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 0, 10, 560));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("opcional *");
        jPanel2.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(840, 60, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton5.setText(" Cargar ");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 460, 360, 60));

        privacidad_nuevoUsuario.add(jRadioButton1);
        jRadioButton1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton1.setText("Publico");
        jPanel2.add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, -1, -1));
        jPanel2.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 980, 10));

        jPanel3.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel3MouseClicked(evt);
            }
        });
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel3.add(jLabel41, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 130, 110));

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 270, 130, 110));

        jLabel10.setText("Imagen");
        jPanel2.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, -1, 20));
        jPanel2.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 230, 70, -1));
        jPanel2.add(jSpinner2, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 230, 50, -1));
        jPanel2.add(jSpinner3, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 230, 50, -1));

        privacidad_nuevoUsuario.add(jRadioButton4);
        jRadioButton4.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jRadioButton4.setText("Privado");
        jPanel2.add(jRadioButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 350, -1, -1));

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton9.setText("Cancelar");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 340, 60));

        jLabel42.setText("Email");
        jPanel2.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel43.setText("Año");
        jPanel2.add(jLabel43, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 210, -1, -1));

        jLabel44.setText("Mes");
        jPanel2.add(jLabel44, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 210, -1, -1));

        jLabel50.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel50.setText("opcional *");
        jPanel2.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 360, -1, -1));

        Nuevo_Usuario.getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(Nuevo_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        SeguirUsuarios.setTitle("Seguir Usuario");
        SeguirUsuarios.setVisible(true);
        SeguirUsuarios.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel12.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane11.setViewportView(jList6);

        jPanel12.add(jScrollPane11, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 330, 290));

        jScrollPane12.setViewportView(jList7);

        jPanel12.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 50, 320, 290));

        jLabel61.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel61.setText("Seguidor:");
        jPanel12.add(jLabel61, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 20, -1, -1));

        jLabel62.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel62.setText("Seguido:");
        jPanel12.add(jLabel62, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 20, -1, -1));

        jButton15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton15.setText("Seguir");
        jPanel12.add(jButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 370, 190, 40));

        jButton16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton16.setText("Aceptar");
        jButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton16ActionPerformed(evt);
            }
        });
        jPanel12.add(jButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 370, 120, 40));

        jButton17.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton17.setText("Dejar de Seguir");
        jPanel12.add(jButton17, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 370, 200, 40));

        SeguirUsuarios.getContentPane().add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 430));

        getContentPane().add(SeguirUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 60, 780, 460));

        ListarUsuarios.setTitle("Listar Usuarios");
        ListarUsuarios.setPreferredSize(new java.awt.Dimension(280, 300));
        ListarUsuarios.setVisible(true);
        ListarUsuarios.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel11.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane10.setViewportView(jList3);

        jPanel11.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 260, 250));

        jLabel60.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel60.setText("Usuarios:");
        jPanel11.add(jLabel60, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton14.setText("Aceptar");
        jButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton14ActionPerformed(evt);
            }
        });
        jPanel11.add(jButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 140, 40));

        ListarUsuarios.getContentPane().add(jPanel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 300, 350));

        getContentPane().add(ListarUsuarios, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 310, 380));

        quitar_video_listRep.setTitle("Quitar Video de Lista de Reproducción");
        quitar_video_listRep.setVisible(true);
        quitar_video_listRep.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel22.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel118.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel118.setText("Usuarios:");
        jPanel22.add(jLabel118, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jList34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane43.setViewportView(jList34);

        jPanel22.add(jScrollPane43, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 210, 300));

        jButton29.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton29.setText("Cancelar");
        jButton29.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton29ActionPerformed(evt);
            }
        });
        jPanel22.add(jButton29, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 210, 40));

        jLabel119.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel119.setText("Videos:");
        jLabel119.setToolTipText("");
        jPanel22.add(jLabel119, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 10, -1, -1));

        jList35.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane44.setViewportView(jList35);

        jPanel22.add(jScrollPane44, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, 240, 300));

        jLabel120.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel120.setText("Listas de Reproduccion:");
        jPanel22.add(jLabel120, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 10, -1, -1));

        jList36.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jScrollPane45.setViewportView(jList36);

        jPanel22.add(jScrollPane45, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 230, 300));

        Aceptar_NLR3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        Aceptar_NLR3.setText("Quitar");
        Aceptar_NLR3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_NLR3ActionPerformed(evt);
            }
        });
        jPanel22.add(Aceptar_NLR3, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 350, 230, 40));

        quitar_video_listRep.getContentPane().add(jPanel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 410));

        getContentPane().add(quitar_video_listRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 800, 440));

        altaVideo.setTitle("Nuevo Video");
        altaVideo.setVisible(true);
        altaVideo.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel13.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel63.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel63.setText("Dueño del video:");
        jPanel13.add(jLabel63, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane13.setViewportView(jList8);

        jPanel13.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 290, 390));

        jLabel64.setText("Nombre:");
        jPanel13.add(jLabel64, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 50, -1, -1));

        jLabel65.setText("Segundos");
        jPanel13.add(jLabel65, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 90, -1, -1));

        jLabel66.setText("URL:");
        jPanel13.add(jLabel66, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 150, -1, -1));

        jLabel67.setText("Descripción:");
        jPanel13.add(jLabel67, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 190, -1, -1));

        jLabel68.setText("Fecha publicación:");
        jPanel13.add(jLabel68, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 390, -1, -1));

        jLabel69.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel69.setText("Asignar categoría:");
        jPanel13.add(jLabel69, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 20, -1, -1));

        jScrollPane14.setViewportView(jList9);

        jPanel13.add(jScrollPane14, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 50, 260, 390));

        jLabel70.setText("Opcional *");
        jPanel13.add(jLabel70, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 20, -1, -1));
        jPanel13.add(jTextField6, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 240, -1));
        jPanel13.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 150, 240, -1));
        jPanel13.add(jSpinner7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 390, 70, -1));
        jPanel13.add(jSpinner8, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 390, 60, -1));
        jPanel13.add(jSpinner9, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 390, 60, -1));

        jTextArea5.setColumns(20);
        jTextArea5.setRows(5);
        jScrollPane15.setViewportView(jTextArea5);

        jPanel13.add(jScrollPane15, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 190, 240, 160));

        jButton18.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton18.setText("Aceptar");
        jButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton18ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton18, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 460, 260, 70));

        jButton19.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton19.setText("Cancelar");
        jButton19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton19ActionPerformed(evt);
            }
        });
        jPanel13.add(jButton19, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 463, 290, 70));
        jPanel13.add(jSpinner4, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 110, 60, -1));
        jPanel13.add(jSpinner5, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 110, 60, -1));
        jPanel13.add(jSpinner6, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, 60, -1));

        jLabel135.setText("Duración:");
        jPanel13.add(jLabel135, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 90, -1, -1));

        jLabel136.setText("Horas");
        jPanel13.add(jLabel136, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, -1, -1));

        jLabel137.setText("Minutos");
        jPanel13.add(jLabel137, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 90, -1, -1));

        jLabel138.setText("Año");
        jPanel13.add(jLabel138, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 370, -1, -1));

        jLabel139.setText("Mes");
        jPanel13.add(jLabel139, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 370, -1, -1));

        jLabel140.setText("Dia");
        jPanel13.add(jLabel140, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 370, -1, -1));

        altaVideo.getContentPane().add(jPanel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(altaVideo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        Modificar_Video.setTitle("Modificar Video");
        Modificar_Video.setVisible(true);
        Modificar_Video.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel14.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton20.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton20.setText("Modificar");
        jButton20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton20ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton20, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 470, 390, 50));

        jButton21.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton21.setText("Cancelar");
        jButton21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton21ActionPerformed(evt);
            }
        });
        jPanel14.add(jButton21, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 473, 390, 50));

        jScrollPane16.setViewportView(jList10);

        jPanel14.add(jScrollPane16, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 180, 400));

        jLabel71.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel71.setText("Dueño del video:");
        jPanel14.add(jLabel71, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane17.setViewportView(jList11);

        jPanel14.add(jScrollPane17, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 50, 180, 400));

        jLabel72.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel72.setText("Video del Usuario:");
        jPanel14.add(jLabel72, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));
        jPanel14.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 50, 210, -1));

        jLabel73.setText("Nombre:");
        jPanel14.add(jLabel73, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 50, -1, -1));

        jLabel74.setText("Duración:");
        jPanel14.add(jLabel74, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 100, -1, -1));

        jLabel75.setText("URL:");
        jPanel14.add(jLabel75, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 130, -1, -1));
        jPanel14.add(jTextField15, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, 210, -1));

        jLabel76.setText("Descripción:");
        jPanel14.add(jLabel76, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, -1, -1));

        jTextArea6.setColumns(20);
        jTextArea6.setRows(5);
        jScrollPane18.setViewportView(jTextArea6);

        jPanel14.add(jScrollPane18, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 170, 210, 120));

        jLabel77.setText("Fecha publicación:");
        jPanel14.add(jLabel77, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, -1, -1));
        jPanel14.add(jSpinner10, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 320, 60, -1));
        jPanel14.add(jSpinner11, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 320, 50, -1));
        jPanel14.add(jSpinner12, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 320, 50, -1));

        jLabel78.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel78.setText("Asignar categoría:");
        jPanel14.add(jLabel78, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 20, -1, -1));

        jScrollPane19.setViewportView(jList12);

        jPanel14.add(jScrollPane19, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 180, 400));

        privacidad_modVideo.add(jRadioButton5);
        jRadioButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton5.setText("Publico");
        jPanel14.add(jRadioButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, -1, -1));

        privacidad_modVideo.add(jRadioButton6);
        jRadioButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jRadioButton6.setText("Privado");
        jPanel14.add(jRadioButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 390, -1, -1));
        jPanel14.add(jSpinner16, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 100, 60, -1));

        jLabel144.setText("Horas");
        jPanel14.add(jLabel144, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 80, -1, -1));
        jPanel14.add(jSpinner17, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 100, 50, -1));

        jLabel145.setText("Minutos");
        jPanel14.add(jLabel145, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 80, -1, -1));
        jPanel14.add(jSpinner18, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, 50, -1));

        jLabel146.setText("Segundos");
        jPanel14.add(jLabel146, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 80, -1, -1));

        jLabel147.setText("Año");
        jPanel14.add(jLabel147, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 300, -1, -1));

        jLabel148.setText("Mes");
        jPanel14.add(jLabel148, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 300, -1, -1));

        jLabel149.setText("Dia");
        jPanel14.add(jLabel149, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, -1, -1));

        Modificar_Video.getContentPane().add(jPanel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(Modificar_Video, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        Valorar_Video.setTitle("Valorar Video");
        Valorar_Video.setVisible(true);
        Valorar_Video.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel16.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane28.setViewportView(jList19);

        jPanel16.add(jScrollPane28, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 50, 260, 310));

        jScrollPane29.setViewportView(jList20);

        jPanel16.add(jScrollPane29, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 250, 310));

        jLabel96.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel96.setText("Usuario valorador:");
        jPanel16.add(jLabel96, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, -1, -1));

        jLabel97.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel97.setText("Video a valorar:");
        jPanel16.add(jLabel97, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jScrollPane30.setViewportView(jList21);

        jPanel16.add(jScrollPane30, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 220, 310));

        jLabel98.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel98.setText("Usuario valorado:");
        jPanel16.add(jLabel98, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        valorarVideo.add(jRadioButton7);
        jRadioButton7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton7.setText("Me gusta");
        jPanel16.add(jRadioButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 390, -1, -1));

        valorarVideo.add(jRadioButton8);
        jRadioButton8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton8.setText("No me gusta");
        jPanel16.add(jRadioButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 390, -1, -1));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Valorar");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 380, 260, 40));

        jButton23.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton23.setText("Cancelar");
        jButton23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton23ActionPerformed(evt);
            }
        });
        jPanel16.add(jButton23, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 383, 220, 40));

        Valorar_Video.getContentPane().add(jPanel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));

        getContentPane().add(Valorar_Video, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 860, 480));

        ConsultaList_rep.setTitle("Consultar Lista de Reproducción");
        ConsultaList_rep.setVisible(true);
        ConsultaList_rep.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel20.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton24.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton24.setText("Aceptar");
        jButton24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton24ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton24, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 390, 240, 40));

        jLabel106.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel106.setText("Usuario");
        jPanel20.add(jLabel106, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jLabel107.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel107.setText("Listas de Reproduccion:");
        jPanel20.add(jLabel107, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 20, -1, -1));

        jScrollPane37.setViewportView(jList28);

        jPanel20.add(jScrollPane37, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 320));

        jScrollPane38.setViewportView(jList29);

        jPanel20.add(jScrollPane38, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 50, 240, 320));

        jLabel108.setText("Nombre:");
        jPanel20.add(jLabel108, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 380, -1, -1));

        jLabel109.setText("Privacidad:");
        jPanel20.add(jLabel109, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, -1, -1));

        jLabel110.setText("Tipo:");
        jPanel20.add(jLabel110, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 420, -1, -1));

        jLabel111.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel111.setText("Videos:");
        jPanel20.add(jLabel111, new org.netbeans.lib.awtextra.AbsoluteConstraints(580, 20, -1, -1));

        jScrollPane39.setViewportView(jList30);

        jPanel20.add(jScrollPane39, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 50, 260, 320));

        jButton27.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton27.setText("Consultar video");
        jButton27.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton27ActionPerformed(evt);
            }
        });
        jPanel20.add(jButton27, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 390, 200, 40));

        jLabel112.setText(" ");
        jPanel20.add(jLabel112, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 420, 150, -1));

        jLabel113.setText(" ");
        jPanel20.add(jLabel113, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 200, -1));

        jLabel114.setText(" ");
        jPanel20.add(jLabel114, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 150, -1));

        ConsultaList_rep.getContentPane().add(jPanel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 850, 450));

        getContentPane().add(ConsultaList_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 50, 860, 480));

        Consultar_Video.setTitle("Consultar Video");
        Consultar_Video.setVisible(true);
        Consultar_Video.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel15.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel81.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel81.setText("Dueño del video:");
        jPanel15.add(jLabel81, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, -1, -1));

        jScrollPane22.setViewportView(jList15);

        jPanel15.add(jScrollPane22, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 140, 300));

        jLabel82.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel82.setText("Comentarios:");
        jPanel15.add(jLabel82, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 20, -1, -1));

        jScrollPane23.setViewportView(jList16);

        jPanel15.add(jScrollPane23, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 50, 160, 300));

        jLabel83.setText("Nombre:");
        jPanel15.add(jLabel83, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, -1, -1));

        jLabel84.setText("Duración:");
        jPanel15.add(jLabel84, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 80, -1, -1));

        jLabel85.setText("URL:");
        jPanel15.add(jLabel85, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 110, -1, -1));

        jLabel86.setText("Descripción:");
        jPanel15.add(jLabel86, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 200, -1, -1));

        jTextArea7.setColumns(20);
        jTextArea7.setRows(5);
        jScrollPane24.setViewportView(jTextArea7);

        jPanel15.add(jScrollPane24, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 220, 230, 130));

        jLabel87.setText("Privacidad:");
        jPanel15.add(jLabel87, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 140, -1, -1));

        jLabel88.setText("Categoria:");
        jPanel15.add(jLabel88, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 170, -1, -1));

        jLabel89.setText(" ");
        jPanel15.add(jLabel89, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 220, -1));

        jLabel90.setText(" ");
        jPanel15.add(jLabel90, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 80, 170, -1));

        jLabel91.setText(" ");
        jPanel15.add(jLabel91, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 110, 180, -1));

        jLabel92.setText(" ");
        jPanel15.add(jLabel92, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 140, 170, -1));

        jLabel93.setText(" ");
        jPanel15.add(jLabel93, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 170, 170, -1));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton7.setText("Aceptar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel15.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 280, 40));

        jLabel94.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel94.setText("Les gusto:");
        jPanel15.add(jLabel94, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, -1, -1));

        jLabel95.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel95.setText("No les gusto:");
        jPanel15.add(jLabel95, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 370, -1, -1));

        jScrollPane25.setViewportView(jList17);

        jPanel15.add(jScrollPane25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 400, 250, 110));

        jScrollPane26.setViewportView(jList18);

        jPanel15.add(jScrollPane26, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 400, 300, 110));

        treeNode1 = new javax.swing.tree.DefaultMutableTreeNode("root");
        jTree1.setModel(new javax.swing.tree.DefaultTreeModel(treeNode1));
        jScrollPane27.setViewportView(jTree1);

        jPanel15.add(jScrollPane27, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 50, 280, 420));

        jLabel99.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel99.setText("Video del Usuario:");
        jPanel15.add(jLabel99, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 20, -1, -1));

        Consultar_Video.getContentPane().add(jPanel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 980, 550));

        getContentPane().add(Consultar_Video, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        NuevaListaRepro.setTitle("Nueva Lista de Reproducción");
        NuevaListaRepro.setVisible(true);
        NuevaListaRepro.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel17.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel100.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel100.setText("Nombre:");
        jPanel17.add(jLabel100, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, -1, -1));
        jPanel17.add(jTextField16, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 40, 300, -1));

        jPanel18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel18.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel101.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel101.setText("Usuarios:");
        jPanel18.add(jLabel101, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jScrollPane31.setViewportView(jList22);

        jPanel18.add(jScrollPane31, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 40, 340, 180));

        privacidad_NuevaLR.add(jRadioButton11);
        jRadioButton11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton11.setText("Publica");
        jPanel18.add(jRadioButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 230, -1, -1));

        privacidad_NuevaLR.add(jRadioButton12);
        jRadioButton12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton12.setText("Privada");
        jPanel18.add(jRadioButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 230, -1, -1));

        jLabel102.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel102.setText("Categoria:");
        jPanel18.add(jLabel102, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 10, -1, -1));

        jScrollPane32.setViewportView(jList23);

        jPanel18.add(jScrollPane32, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 320, 180));

        jPanel17.add(jPanel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 750, 270));

        Aceptar_NLR.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Aceptar_NLR.setText("Aceptar");
        Aceptar_NLR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_NLRActionPerformed(evt);
            }
        });
        jPanel17.add(Aceptar_NLR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 370, 370, 40));

        jButton25.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton25.setText("Cancelar");
        jButton25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton25ActionPerformed(evt);
            }
        });
        jPanel17.add(jButton25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 370, 350, 40));

        jPanel26.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipo"));
        jPanel26.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jPanel26.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tipo_nLR.add(RB_porDefecto);
        RB_porDefecto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RB_porDefecto.setText("Por defecto");
        RB_porDefecto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_porDefectoActionPerformed(evt);
            }
        });
        jPanel26.add(RB_porDefecto, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 20, -1, -1));

        tipo_nLR.add(RB_particular);
        RB_particular.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        RB_particular.setText("Particular");
        RB_particular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RB_particularActionPerformed(evt);
            }
        });
        jPanel26.add(RB_particular, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, -1, -1));

        jPanel17.add(jPanel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(32, 10, 330, 60));

        NuevaListaRepro.getContentPane().add(jPanel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 430));

        getContentPane().add(NuevaListaRepro, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 820, 460));

        Modificar_list_rep.setTitle("Modificar Lista de Reproducción");
        Modificar_list_rep.setVisible(true);
        Modificar_list_rep.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel19.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane33.setViewportView(jList24);

        jPanel19.add(jScrollPane33, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 240, 270));

        jLabel103.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel103.setText("Usuarios:");
        jPanel19.add(jLabel103, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane34.setViewportView(jList25);

        jPanel19.add(jScrollPane34, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 50, 240, 270));

        jLabel104.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel104.setText("Categoria:");
        jPanel19.add(jLabel104, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 20, -1, -1));

        privacidad_modListaR.add(jRadioButton13);
        jRadioButton13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton13.setText("Privada");
        jPanel19.add(jRadioButton13, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 340, -1, -1));

        privacidad_modListaR.add(jRadioButton14);
        jRadioButton14.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton14.setText("Publica");
        jPanel19.add(jRadioButton14, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 340, -1, -1));

        jButton26.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton26.setText("Cancelar");
        jButton26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton26ActionPerformed(evt);
            }
        });
        jPanel19.add(jButton26, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 350, 240, 50));

        Aceptar_NLR1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Aceptar_NLR1.setText("Aceptar");
        Aceptar_NLR1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_NLR1ActionPerformed(evt);
            }
        });
        jPanel19.add(Aceptar_NLR1, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 350, 240, 50));

        jLabel105.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel105.setText("List. Reproduccion:");
        jPanel19.add(jLabel105, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 20, -1, -1));

        jScrollPane35.setViewportView(jList26);

        jPanel19.add(jScrollPane35, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 50, 250, 270));

        Modificar_list_rep.getContentPane().add(jPanel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 810, 430));

        getContentPane().add(Modificar_list_rep, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 40, 820, 460));

        agregar_video_listRep.setTitle("Agregar Video a Lista de Reproducción");
        agregar_video_listRep.setVisible(true);
        agregar_video_listRep.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel21.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane40.setViewportView(jList31);

        jPanel21.add(jScrollPane40, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 290));

        jScrollPane41.setViewportView(jList32);

        jPanel21.add(jScrollPane41, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 210, 290));

        jScrollPane42.setViewportView(jList33);

        jPanel21.add(jScrollPane42, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 40, 240, 290));

        jLabel115.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel115.setText("Usuarios:");
        jPanel21.add(jLabel115, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jLabel116.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel116.setText("List. Reproduccion del segundo usuario:");
        jPanel21.add(jLabel116, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, -1, -1));

        jLabel117.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel117.setText("Videos del primer Usuario:");
        jLabel117.setToolTipText("");
        jPanel21.add(jLabel117, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jButton28.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton28.setText("Cancelar");
        jButton28.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton28ActionPerformed(evt);
            }
        });
        jPanel21.add(jButton28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 350, 220, 40));

        Aceptar_NLR2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        Aceptar_NLR2.setText("Agregar");
        Aceptar_NLR2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Aceptar_NLR2ActionPerformed(evt);
            }
        });
        jPanel21.add(Aceptar_NLR2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 350, 240, 40));

        agregar_video_listRep.getContentPane().add(jPanel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 410));

        getContentPane().add(agregar_video_listRep, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 800, 440));

        nueva_Categoria.setTitle("Nueva Categoría");
        nueva_Categoria.setVisible(true);
        nueva_Categoria.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel23.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel121.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel121.setText("Nombre:");
        jPanel23.add(jLabel121, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 30, -1, -1));

        jButton30.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton30.setText("Aceptar");
        jButton30.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton30ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton30, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 70, 120, 40));

        jButton31.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton31.setText("Cancelar");
        jButton31.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton31ActionPerformed(evt);
            }
        });
        jPanel23.add(jButton31, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 120, 40));

        jTextField17.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField17.setText(" ");
        jPanel23.add(jTextField17, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, 210, 30));

        nueva_Categoria.getContentPane().add(jPanel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 350, 130));

        getContentPane().add(nueva_Categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 220, 360, 150));

        listar_categorias.setTitle("Listar Categorías");
        listar_categorias.setVisible(true);
        listar_categorias.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel24.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton32.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton32.setText("Aceptar");
        jButton32.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton32ActionPerformed(evt);
            }
        });
        jPanel24.add(jButton32, new org.netbeans.lib.awtextra.AbsoluteConstraints(133, 333, 140, 30));

        jScrollPane46.setViewportView(jList37);

        jPanel24.add(jScrollPane46, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 250, 280));

        jLabel122.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel122.setText("Categorias:");
        jPanel24.add(jLabel122, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        listar_categorias.getContentPane().add(jPanel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 290, 380));

        getContentPane().add(listar_categorias, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, 300, 410));

        Consulta_categoria.setTitle("Consulta de Categoría");
        Consulta_categoria.setVisible(true);
        Consulta_categoria.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel25.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton33.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton33.setText("Aceptar");
        jButton33.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton33ActionPerformed(evt);
            }
        });
        jPanel25.add(jButton33, new org.netbeans.lib.awtextra.AbsoluteConstraints(553, 343, 210, 50));

        jLabel123.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel123.setText("Categorias:");
        jPanel25.add(jLabel123, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 10, -1, -1));

        jScrollPane47.setViewportView(jList38);

        jPanel25.add(jScrollPane47, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 220, 350));

        jLabel124.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel124.setText("Videos:");
        jPanel25.add(jLabel124, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 10, -1, -1));

        jScrollPane48.setViewportView(jList39);

        jPanel25.add(jScrollPane48, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 40, 240, 350));

        jLabel125.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel125.setText("List. Reproduccion:");
        jPanel25.add(jLabel125, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, -1, -1));

        jScrollPane49.setViewportView(jList40);

        jPanel25.add(jScrollPane49, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 40, 210, 280));

        Consulta_categoria.getContentPane().add(jPanel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 790, 410));

        getContentPane().add(Consulta_categoria, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 50, 800, 440));

        About.setTitle("Acerca de:");
        About.setVisible(true);
        About.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel10.setBackground(new java.awt.Color(20, 20, 20));
        jPanel10.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel10.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 420));

        jButton10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton10.setText("Aceptar");
        jButton10.setBorderPainted(false);
        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel10.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(433, 413, 110, 30));

        About.getContentPane().add(jPanel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 460));

        getContentPane().add(About, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 50, 580, 490));

        Modificar_Usuario.setTitle("Modificar Usuario");
        Modificar_Usuario.setVisible(true);
        Modificar_Usuario.getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel7.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel126.setText("Nombre");
        jPanel7.add(jLabel126, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, -1, -1));

        jLabel127.setText("Apellido");
        jPanel7.add(jLabel127, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 100, -1, -1));

        jLabel128.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel128.setText("Usuario");
        jPanel7.add(jLabel128, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 10, -1, -1));
        jPanel7.add(jTextField18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, 230, -1));
        jPanel7.add(jTextField19, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 100, 230, -1));

        jLabel129.setText("Fecha de nacimiento");
        jPanel7.add(jLabel129, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 170, -1, -1));

        jSeparator9.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 0, 10, 560));

        jLabel130.setText("Imagen");
        jPanel7.add(jLabel130, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 260, -1, 20));
        jPanel7.add(jSpinner13, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 170, 60, -1));
        jPanel7.add(jSpinner14, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 170, 40, -1));
        jPanel7.add(jSpinner15, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 170, 40, -1));

        jLabel131.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel131.setText("Seleccionar usuario");
        jPanel7.add(jLabel131, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, -1, -1));

        jScrollPane50.setViewportView(jList41);

        jPanel7.add(jScrollPane50, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 50, 260, 420));

        jButton34.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton34.setText("Modificar");
        jButton34.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton34ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton34, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 490, 270, 50));

        jButton35.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton35.setText("Seleccionar");
        jButton35.setToolTipText("");
        jButton35.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButton35.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton35ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton35, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 300, 120, 60));

        jSeparator10.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel7.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 10, 560));

        jLabel132.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel132.setText("Canal");
        jPanel7.add(jLabel132, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 10, -1, -1));

        jLabel133.setText("Nombre");
        jPanel7.add(jLabel133, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 60, -1, -1));
        jPanel7.add(jTextField20, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 190, -1));

        jLabel134.setText("Descripción");
        jPanel7.add(jLabel134, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 100, -1, -1));

        jTextArea8.setColumns(20);
        jTextArea8.setRows(5);
        jScrollPane51.setViewportView(jTextArea8);

        jPanel7.add(jScrollPane51, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 100, 200, 160));

        privacidad_modUsuario.add(jRadioButton15);
        jRadioButton15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton15.setText("Publico");
        jPanel7.add(jRadioButton15, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 290, -1, -1));

        privacidad_modUsuario.add(jRadioButton16);
        jRadioButton16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jRadioButton16.setText("Privado");
        jPanel7.add(jRadioButton16, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 290, -1, -1));

        B_LR.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        B_LR.setText("Lista de reproduccion");
        B_LR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_LRActionPerformed(evt);
            }
        });
        jPanel7.add(B_LR, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 343, 270, 50));

        B_Video.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        B_Video.setText("Video");
        B_Video.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_VideoActionPerformed(evt);
            }
        });
        jPanel7.add(B_Video, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 410, 270, 50));

        jButton38.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jButton38.setText("Cancelar");
        jButton38.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton38ActionPerformed(evt);
            }
        });
        jPanel7.add(jButton38, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 260, 50));

        jPanel27.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel27.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel27.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 140, 110));

        jPanel7.add(jPanel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 300, 140, 110));
        jPanel7.add(jSeparator6, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, 650, 20));

        jLabel141.setText("Año");
        jPanel7.add(jLabel141, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 150, -1, -1));

        jLabel142.setText("Mes");
        jPanel7.add(jLabel142, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 150, -1, -1));

        jLabel143.setText("Dia");
        jPanel7.add(jLabel143, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 150, -1, -1));

        jLabel33.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel33.setText("Opcional *");
        jPanel7.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 380, -1, -1));

        Modificar_Usuario.getContentPane().add(jPanel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 560));

        getContentPane().add(Modificar_Usuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        jDesktopPane1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setText("jLabel16");
        jDesktopPane1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 990, 580));

        jMenu6.setText("Sesion");

        jMenuItem1.setText("Inisiar sesion");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem1);

        jMenuItem2.setText("Cerrar sesion");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem2);

        jMenuBar1.add(jMenu6);

        jMenu1.setText("Usuario");

        jMenuItem5.setText("Nuevo Usuario");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem6.setText("Consultar Usuario");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem6);

        jMenuItem7.setText("Modificar Usuario");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem8.setText("Listar Usuarios");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem9.setText("Segir Usuario");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem9);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Video");

        jMenuItem11.setText("Nuevo Video");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem11);

        jMenuItem12.setText("Modificar Video");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem12);

        jMenuItem13.setText("Consultar Video");
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem15.setText("Comentar Video");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem15);

        jMenuItem16.setText("Valorar Video");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem16);

        jMenuBar1.add(jMenu2);

        jMenu3.setText("Lista de reproduccion");

        jMenuItem17.setText("Nueva Lista");
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem17);

        jMenuItem18.setText("Modificar Lista");
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem18);

        jMenuItem19.setText("Consultar Lista");
        jMenuItem19.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem19ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem19);

        jMenuItem20.setText("Agregar Video");
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem20);

        jMenuItem22.setText("Quitar Video");
        jMenuItem22.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem22ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem22);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Categoria");

        jMenuItem23.setText("Nueva Categoria");
        jMenuItem23.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem23ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem23);

        jMenuItem24.setText("Consultar Categoria");
        jMenuItem24.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem24ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem24);

        jMenuItem25.setText("Listar Categoria");
        jMenuItem25.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem25ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem25);

        jMenuBar1.add(jMenu4);

        jMenu7.setText("About");

        jMenuItem26.setText("Acerca de nos");
        jMenuItem26.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem26ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem26);

        jMenuBar1.add(jMenu7);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        //Sesion->iniciarSecion
        Inicio_Sesion.setVisible(true);
        
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem1ActionPerformed
    public boolean isIntegerTF(javax.swing.JTextField TF) {
        try {
            Integer.parseInt(TF.getText());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        //Sesion->iniciarSecion->iniciar
        if ("".equals(jPasswordField1.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese su contraseña!");
        } else if (jPasswordField1.getText().length()<8) {
            JOptionPane.showMessageDialog(null, "La contraseña no puede\n  ser menor a 8 digitos!");
        }else if ("".equals(jTextField1.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese Su Nro de empleado!");
        }else if (jTextField1.getText().length()<8) {
            JOptionPane.showMessageDialog(null, "El Nro de empleado no puede\n   ser menor a 8 digitos!");
        } else if (isIntegerTF(jTextField1)) {
            //codifo ...
            //*
            //*
            //fin del codigo.
            jTextField1.setText("");
            jPasswordField1.setText("");
            Inicio_Sesion.setVisible(false);
            jMenu1.setEnabled(true);
            jMenu2.setEnabled(true);
            jMenu3.setEnabled(true);
            jMenu4.setEnabled(true);
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese solo numeros en su \nNro de empleado");
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        //Sesion->cerrar secion
        JOptionPane.showMessageDialog(null, "¿Esta Seguro que desea Cerrando sesion?");
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        //Usiario->nuevo Usuario
        Nuevo_Usuario.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        //Usiario->nuevo Usuario->cargar
        if ("".equals(jTextField2.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese su Nickname");
        } else if ("".equals(jTextField3.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese su Nombre");
        } else if ("".equals(jTextField4.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese su Apellido");
        } else if ("".equals(jTextField5.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese su e-mail");
        } else {
            Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            Matcher mather = pattern.matcher(jTextField5.getText());
            if (!mather.find()) {
                JOptionPane.showMessageDialog(null, "El email ingresado es inválido.");
            } else if ("".equals(jTextField8.getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese Nombre del canal");
            } else if ("".equals(jTextArea1.getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese Una descripcion!");
            } else if (!jRadioButton1.isSelected() && !jRadioButton4.isSelected()) {
                JOptionPane.showMessageDialog(null, "Defina privacidad!");
            } else {
                jTextField2.setText("");
                jTextField3.setText("");
                jTextField4.setText("");
                jTextField5.setText("");
                jTextField8.setText("");
                jTextArea1.setText("");
                jLabel41.setIcon(null);
                Nuevo_Usuario.setVisible(false);
            }
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        //Usiario->nuevo Usuario->seleccionar
        cargarImagen(jLabel41);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        //Video->comentar video
        Comentar_video.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem15ActionPerformed
    DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Comentarios:");

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
    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        //Video->comentar video->comentar
        DefaultMutableTreeNode otro = new DefaultMutableTreeNode(jTextArea2.getText());
        TreePath d = jTree2.getAnchorSelectionPath();

        if (isSelected(d)) {
            DefaultMutableTreeNode mm = (DefaultMutableTreeNode) d.getLastPathComponent();
            mm.add(otro);

            DefaultTreeModel modelo = new DefaultTreeModel(raiz);
            this.jTree2.setModel(modelo);

            jTextArea2.setText("");
        } else {
            raiz.add(otro);
            DefaultTreeModel modelo = new DefaultTreeModel(raiz);
            this.jTree2.setModel(modelo);

            jTextArea2.setText("");
        }
        for (int i = 0; i < jTree2.getRowCount(); i++) {//expande los nodos
            jTree2.expandRow(i);
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        //Video->comentar video->Terminar
        Comentar_video.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        //Usuario->consultar usuario
        Consultar_Usuario.setVisible(true);
        //jList1.addListSelectionListener(listener);
        String[] usr = new String[3];
        usr[0] = "MCBOLSO";
        usr[1] = "Juan_96";
        usr[2] = "Pepe_85";

        jList1.setListData(usr);
        //JOptionPane.showMessageDialog(null, jList1.getSele); 
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        //Usuario->consultar usuario->lista de usuarios->"usuario selecionado"
        List<String> valor = jList1.getSelectedValuesList();
        jLabel29.setText(valor.get(0));
        if ("MCBOLSO".equals(valor.get(0))) {
            jLabel28.setText("Mariano");
            jLabel27.setText("Castro");
            jLabel26.setText("MCBolsoSape@hotmail.com");
            jLabel25.setText("1999-19-19");
            //jLabel24.setText("C/MCBolso/Desktop/imagenes"); //ver cargarImagen()
            jLabel24.setVisible(true);
            jLabel37.setText("LoMejorDelBolso");
            jLabel36.setText("Publico");
            jTextArea3.setText("Lo mejor del bolso desde el 1987 al 2015");

            jLabel28.setVisible(true);
            jLabel27.setVisible(true);
            jLabel26.setVisible(true);
            jLabel25.setVisible(true);
            jLabel37.setVisible(true);
            jLabel36.setVisible(true);
            jTextArea3.setVisible(true);
        } else {
            jLabel28.setVisible(false);
            jLabel27.setVisible(false);
            jLabel26.setVisible(false);
            jLabel25.setVisible(false);
            jLabel24.setVisible(false);
            jLabel37.setVisible(false);
            jLabel36.setVisible(false);
            jTextArea3.setVisible(false);

        }
    }//GEN-LAST:event_jList1ValueChanged
    private void cargarImagen(javax.swing.JLabel jLabelx) {
        JFileChooser jf = new JFileChooser();
        jf.showOpenDialog(this);
        File archivo = jf.getSelectedFile();

        if (archivo != null) {
            FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG, PNG", "jpg", "png");
            jf.setFileFilter(filtroImagen);
            //jLabel4.setText(archivo.getAbsolutePath());
            Image img = new ImageIcon(archivo.getAbsolutePath()).getImage();
            float i = 0f;
            if (img.getHeight(null) > img.getWidth(null)) {
                i = img.getHeight(null) / img.getWidth(null);
            } else {
                i = img.getWidth(null) / img.getHeight(null);
            }
            if (i < 1.4 && i >= 1) {
                ImageIcon img2 = new ImageIcon(img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH));
                jLabelx.setIcon(img2);
                /*
                ImageIcon img3 = new ImageIcon(img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH));
                jLabelx.setIcon(img3);//cuidado!!
                jLabelx.setVisible(false);//cuidado!!*/
            } else {
                JOptionPane.showMessageDialog(null, "Imagen fuera de dimenciones " + img.getWidth(null) + " x " + img.getHeight(null));
            }
        }
    }
    private void jPanel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel3MouseClicked
        //cargar imagen en nuevo usuario
        //cargarImagen(jLabel34);
    }//GEN-LAST:event_jPanel3MouseClicked

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        //Usuario->modificar usuario
        Modificar_Usuario.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem26ActionPerformed
        About.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem26ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        //Usuario->listar usuario
        ListarUsuarios.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
        //Usuario->listar usuario->acptar
        ListarUsuarios.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton14ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        //usuario->seruir usuario->acptar
        SeguirUsuarios.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
        //usuario->seruir usuario->acptar
        SeguirUsuarios.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton16ActionPerformed

    private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
        // video->nuevo video->aceptar
        if ("".equals(jTextField6.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre del video");
        } else if ("".equals(jTextField12.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese URL del video");
        } else {
            Pattern pattern = Pattern.compile("(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?");
            Matcher mather = pattern.matcher(jTextField12.getText());
            if (!mather.find()) {
                JOptionPane.showMessageDialog(null, "URL ivalida!");
            } else if ("".equals(jTextArea5.getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese Una descripcion");
            } else {
                jTextField6.setText("");
                jTextField12.setText("");
                jTextArea5.setText("");
                altaVideo.setVisible(false);
            }
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton18ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        // video->nuevo video
        altaVideo.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
        // video->nuevo video->cancelar
        jTextField6.setText("");
        jTextField12.setText("");
        jTextArea5.setText("");
        altaVideo.setVisible(false);
        
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton19ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        // video->modificar video
        Modificar_Video.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
        // video->modificar video->modificar
        if ("".equals(jTextField6.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre del video");
        } else if ("".equals(jTextField12.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese URL del video");
        } else {
            Pattern pattern = Pattern.compile("(http://|https://)(www.)?([a-zA-Z0-9]+).[a-zA-Z0-9]*.[a-z]{3}.?([a-z]+)?");
            Matcher mather = pattern.matcher(jTextField12.getText());
            if (!mather.find()) {
                JOptionPane.showMessageDialog(null, "URL ivalida!");
            } else if ("".equals(jTextArea5.getText())) {
                JOptionPane.showMessageDialog(null, "Ingrese Una descripcion");
            } else if (!jRadioButton5.isSelected() && !jRadioButton6.isSelected()) {
                JOptionPane.showMessageDialog(null, "Defina privacidad!");
            } else {
                altaVideo.setVisible(false);
                Modificar_Video.setVisible(false);
                B_Video.setVisible(true);
            }
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton20ActionPerformed

    private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
        // video->modificar video->cancelar
        jTextField10.setText("");
        jTextField15.setText("");
        jTextArea6.setText("");
        Modificar_Video.setVisible(false);
        B_Video.setVisible(true);
        
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton21ActionPerformed

    private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
        //usuario->consultar usuario->aceptar
        Consultar_Usuario.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton22ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // video->consultar video->aceptar
        Consultar_Video.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        // video->consultar video
        Consultar_Video.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        //vieo->calorar video->aceptar
        if (!jRadioButton5.isSelected() && !jRadioButton6.isSelected()) {
            JOptionPane.showMessageDialog(null, "Defina Valoracion!");
        } else {
            Valorar_Video.setVisible(false);
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
        //vieo->calorar video->cancelar
        Valorar_Video.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton23ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        //vieo->calorar video->aceptar
        Valorar_Video.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void Aceptar_NLRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_NLRActionPerformed
        //lista_rep->nueva_list_rep->aceptar
        if ("".equals(jTextField16.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre de la lista!");
        } else if (!jRadioButton11.isSelected() && !jRadioButton12.isSelected()) {
            JOptionPane.showMessageDialog(null, "Defina privacidad!");
        } else if (!RB_particular.isSelected() && !RB_porDefecto.isSelected()) {
            JOptionPane.showMessageDialog(null, "Defina Tipo de lista!");
        } else {
            jTextField6.setText("");
            NuevaListaRepro.setVisible(false);
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_Aceptar_NLRActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        //lista_rep->nueva_list_rep
        NuevaListaRepro.setVisible(true);

        RB_particular.setSelected(true);
        
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
        //lista_rep->nueva_list_rep->cancelar
        jTextField6.setText("");
        NuevaListaRepro.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton25ActionPerformed

    private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
        //lista_rep->modificar->cancelar
        Modificar_list_rep.setVisible(false);
        B_LR.setVisible(true);
        
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton26ActionPerformed

    private void Aceptar_NLR1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_NLR1ActionPerformed
        //lista_rep->modificar->acptar
        if (!jRadioButton13.isSelected() && !jRadioButton14.isSelected()) {
            JOptionPane.showMessageDialog(null, "Defina privacidad!");
        } else {
            Modificar_list_rep.setVisible(false);
            B_LR.setVisible(true);
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_Aceptar_NLR1ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed
        //lista_rep->modificar
        Modificar_list_rep.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem19ActionPerformed
        //listaRep->consultarlitRep
        ConsultaList_rep.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem19ActionPerformed

    private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
        //listaRep->consultarlitRep->aceptar
        jLabel113.setText("");
        jLabel114.setText("");
        jLabel112.setText("");
        ConsultaList_rep.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton24ActionPerformed

    private void jButton27ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton27ActionPerformed
        //listaRep->consultarlitRep->consultar video
        Consultar_Video.setVisible(true);
    }//GEN-LAST:event_jButton27ActionPerformed

    private void jButton28ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton28ActionPerformed
        //listaRep->agregarVideo->cancelar
        agregar_video_listRep.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton28ActionPerformed

    private void Aceptar_NLR2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_NLR2ActionPerformed
        //listaRep->agregarVideo->aceptar
        agregar_video_listRep.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_Aceptar_NLR2ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        //listaRep->agregarVideo
        agregar_video_listRep.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem22ActionPerformed
        //listaRep->quitarVideo
        quitar_video_listRep.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem22ActionPerformed

    private void jButton29ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton29ActionPerformed
        //listaRep->quitarVideo->cancelar
        quitar_video_listRep.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton29ActionPerformed

    private void Aceptar_NLR3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Aceptar_NLR3ActionPerformed
        //listaRep->quitarVideo->quitar
        quitar_video_listRep.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_Aceptar_NLR3ActionPerformed

    private void jMenuItem23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem23ActionPerformed
        //categoria->nuevaCat
        nueva_Categoria.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem23ActionPerformed

    private void jButton30ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton30ActionPerformed
        //categoria->nuevaCat->aceptar
        if ("".equals(jTextField17.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese un nombre!");
        } else {
            jTextField17.setText("");
            nueva_Categoria.setVisible(false);
        }
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton30ActionPerformed

    private void jButton31ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton31ActionPerformed
        //categoria->nuevaCat->cancelar
        jTextField17.setText("");
        nueva_Categoria.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton31ActionPerformed

    private void jButton32ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton32ActionPerformed
        //categoria->lisatr categoria->aceptar
        listar_categorias.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton32ActionPerformed

    private void jMenuItem25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem25ActionPerformed
        //categoria->lisatr categoria
        listar_categorias.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem25ActionPerformed

    private void jMenuItem24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem24ActionPerformed
        //categoria->consultarCategoria
        Consulta_categoria.setVisible(true);
        jMenu1.setEnabled(false);
        jMenu2.setEnabled(false);
        jMenu3.setEnabled(false);
        jMenu4.setEnabled(false);
        jMenu6.setEnabled(false);
        jMenu7.setEnabled(false);
    }//GEN-LAST:event_jMenuItem24ActionPerformed

    private void jButton33ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton33ActionPerformed
        //categoria->consultarCategoria->aceptar
        Consulta_categoria.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton33ActionPerformed

    private void jButton34ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton34ActionPerformed
        //usuario->modificar usuario->modificar
        if ("".equals(jTextField18.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre del usuario!");
        } else if ("".equals(jTextField19.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese apellido del usuario!");
        } else if ("".equals(jTextField20.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese nombre del canal!");
        } else if ("".equals(jTextArea8.getText())) {
            JOptionPane.showMessageDialog(null, "Ingrese descripcion");
        } else if (!jRadioButton15.isSelected() && !jRadioButton16.isSelected()) {
            JOptionPane.showMessageDialog(null, "Defina privacidad!");
        } else {
            jTextField18.setText("");
            jTextField19.setText("");
            jTextField20.setText("");
            jTextArea8.setText("");
            Modificar_Usuario.setVisible(false);
        }
        jLabel34.setIcon(null);
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextArea8.setText("");
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton34ActionPerformed

    private void B_LRActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_LRActionPerformed
        //usuario->modificar usuario->lista de rep
        Modificar_list_rep.setVisible(true);
        B_LR.setVisible(false);
    }//GEN-LAST:event_B_LRActionPerformed

    private void B_VideoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_VideoActionPerformed
        //usuario->modificar usuario->video
        Modificar_Video.setVisible(true);
        B_Video.setVisible(false);
    }//GEN-LAST:event_B_VideoActionPerformed

    private void jButton38ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton38ActionPerformed
        //usuario->modificar usuario->cancelar
        Modificar_Usuario.setVisible(false);
        jLabel34.setIcon(null);
        jTextField18.setText("");
        jTextField19.setText("");
        jTextField20.setText("");
        jTextArea8.setText("");
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton38ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        //usuario->nuevo usuario->cancelar
        jTextField2.setText("");
        jTextField3.setText("");
        jTextField4.setText("");
        jTextField5.setText("");
        jTextField8.setText("");
        jTextArea1.setText("");
        jLabel41.setIcon(null);
        Nuevo_Usuario.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        //about->acptar
        About.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton35ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton35ActionPerformed
        // usuario->modificar usuario->seleccionar
        cargarImagen(jLabel34);
    }//GEN-LAST:event_jButton35ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // insicar secion->cancelar
        jTextField1.setText("");
        jPasswordField1.setText("");
        Inicio_Sesion.setVisible(false);
        jMenu1.setEnabled(true);
        jMenu2.setEnabled(true);
        jMenu3.setEnabled(true);
        jMenu4.setEnabled(true);
        jMenu6.setEnabled(true);
        jMenu7.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void RB_particularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_particularActionPerformed
        if (RB_particular.isSelected()) {
            jPanel18.setVisible(true);
        } else {
            jPanel18.setVisible(false);
        }
    }//GEN-LAST:event_RB_particularActionPerformed

    private void RB_porDefectoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RB_porDefectoActionPerformed
        if (RB_particular.isSelected()) {
            jPanel18.setVisible(true);
        } else {
            jPanel18.setVisible(false);
        }
    }//GEN-LAST:event_RB_porDefectoActionPerformed

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_jList2ValueChanged

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
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);

        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JInternalFrame About;
    private javax.swing.JButton Aceptar_NLR;
    private javax.swing.JButton Aceptar_NLR1;
    private javax.swing.JButton Aceptar_NLR2;
    private javax.swing.JButton Aceptar_NLR3;
    private javax.swing.JButton B_LR;
    private javax.swing.JButton B_Video;
    private javax.swing.JInternalFrame Comentar_video;
    private javax.swing.JInternalFrame ConsultaList_rep;
    private javax.swing.JInternalFrame Consulta_categoria;
    private javax.swing.JInternalFrame Consultar_Usuario;
    private javax.swing.JInternalFrame Consultar_Video;
    private javax.swing.JInternalFrame Inicio_Sesion;
    private javax.swing.JInternalFrame ListarUsuarios;
    private javax.swing.JInternalFrame Modificar_Usuario;
    private javax.swing.JInternalFrame Modificar_Video;
    private javax.swing.JInternalFrame Modificar_list_rep;
    private javax.swing.JInternalFrame NuevaListaRepro;
    private javax.swing.JInternalFrame Nuevo_Usuario;
    private javax.swing.JRadioButton RB_particular;
    private javax.swing.JRadioButton RB_porDefecto;
    private javax.swing.JInternalFrame SeguirUsuarios;
    private javax.swing.JInternalFrame Valorar_Video;
    private javax.swing.JInternalFrame agregar_video_listRep;
    private javax.swing.JInternalFrame altaVideo;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton14;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton16;
    private javax.swing.JButton jButton17;
    private javax.swing.JButton jButton18;
    private javax.swing.JButton jButton19;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton20;
    private javax.swing.JButton jButton21;
    private javax.swing.JButton jButton22;
    private javax.swing.JButton jButton23;
    private javax.swing.JButton jButton24;
    private javax.swing.JButton jButton25;
    private javax.swing.JButton jButton26;
    private javax.swing.JButton jButton27;
    private javax.swing.JButton jButton28;
    private javax.swing.JButton jButton29;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton30;
    private javax.swing.JButton jButton31;
    private javax.swing.JButton jButton32;
    private javax.swing.JButton jButton33;
    private javax.swing.JButton jButton34;
    private javax.swing.JButton jButton35;
    private javax.swing.JButton jButton38;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel100;
    private javax.swing.JLabel jLabel101;
    private javax.swing.JLabel jLabel102;
    private javax.swing.JLabel jLabel103;
    private javax.swing.JLabel jLabel104;
    private javax.swing.JLabel jLabel105;
    private javax.swing.JLabel jLabel106;
    private javax.swing.JLabel jLabel107;
    private javax.swing.JLabel jLabel108;
    private javax.swing.JLabel jLabel109;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel110;
    private javax.swing.JLabel jLabel111;
    private javax.swing.JLabel jLabel112;
    private javax.swing.JLabel jLabel113;
    private javax.swing.JLabel jLabel114;
    private javax.swing.JLabel jLabel115;
    private javax.swing.JLabel jLabel116;
    private javax.swing.JLabel jLabel117;
    private javax.swing.JLabel jLabel118;
    private javax.swing.JLabel jLabel119;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel120;
    private javax.swing.JLabel jLabel121;
    private javax.swing.JLabel jLabel122;
    private javax.swing.JLabel jLabel123;
    private javax.swing.JLabel jLabel124;
    private javax.swing.JLabel jLabel125;
    private javax.swing.JLabel jLabel126;
    private javax.swing.JLabel jLabel127;
    private javax.swing.JLabel jLabel128;
    private javax.swing.JLabel jLabel129;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel130;
    private javax.swing.JLabel jLabel131;
    private javax.swing.JLabel jLabel132;
    private javax.swing.JLabel jLabel133;
    private javax.swing.JLabel jLabel134;
    private javax.swing.JLabel jLabel135;
    private javax.swing.JLabel jLabel136;
    private javax.swing.JLabel jLabel137;
    private javax.swing.JLabel jLabel138;
    private javax.swing.JLabel jLabel139;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel140;
    private javax.swing.JLabel jLabel141;
    private javax.swing.JLabel jLabel142;
    private javax.swing.JLabel jLabel143;
    private javax.swing.JLabel jLabel144;
    private javax.swing.JLabel jLabel145;
    private javax.swing.JLabel jLabel146;
    private javax.swing.JLabel jLabel147;
    private javax.swing.JLabel jLabel148;
    private javax.swing.JLabel jLabel149;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel150;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel67;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel73;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel77;
    private javax.swing.JLabel jLabel78;
    private javax.swing.JLabel jLabel79;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel80;
    private javax.swing.JLabel jLabel81;
    private javax.swing.JLabel jLabel82;
    private javax.swing.JLabel jLabel83;
    private javax.swing.JLabel jLabel84;
    private javax.swing.JLabel jLabel85;
    private javax.swing.JLabel jLabel86;
    private javax.swing.JLabel jLabel87;
    private javax.swing.JLabel jLabel88;
    private javax.swing.JLabel jLabel89;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel90;
    private javax.swing.JLabel jLabel91;
    private javax.swing.JLabel jLabel92;
    private javax.swing.JLabel jLabel93;
    private javax.swing.JLabel jLabel94;
    private javax.swing.JLabel jLabel95;
    private javax.swing.JLabel jLabel96;
    private javax.swing.JLabel jLabel97;
    private javax.swing.JLabel jLabel98;
    private javax.swing.JLabel jLabel99;
    private javax.swing.JList<String> jList1;
    private javax.swing.JList<String> jList10;
    private javax.swing.JList<String> jList11;
    private javax.swing.JList<String> jList12;
    private javax.swing.JList<String> jList13;
    private javax.swing.JList<String> jList14;
    private javax.swing.JList<String> jList15;
    private javax.swing.JList<String> jList16;
    private javax.swing.JList<String> jList17;
    private javax.swing.JList<String> jList18;
    private javax.swing.JList<String> jList19;
    private javax.swing.JList<String> jList2;
    private javax.swing.JList<String> jList20;
    private javax.swing.JList<String> jList21;
    private javax.swing.JList<String> jList22;
    private javax.swing.JList<String> jList23;
    private javax.swing.JList<String> jList24;
    private javax.swing.JList<String> jList25;
    private javax.swing.JList<String> jList26;
    private javax.swing.JList<String> jList27;
    private javax.swing.JList<String> jList28;
    private javax.swing.JList<String> jList29;
    private javax.swing.JList<String> jList3;
    private javax.swing.JList<String> jList30;
    private javax.swing.JList<String> jList31;
    private javax.swing.JList<String> jList32;
    private javax.swing.JList<String> jList33;
    private javax.swing.JList<String> jList34;
    private javax.swing.JList<String> jList35;
    private javax.swing.JList<String> jList36;
    private javax.swing.JList<String> jList37;
    private javax.swing.JList<String> jList38;
    private javax.swing.JList<String> jList39;
    private javax.swing.JList<String> jList4;
    private javax.swing.JList<String> jList40;
    private javax.swing.JList<String> jList41;
    private javax.swing.JList<String> jList42;
    private javax.swing.JList<String> jList5;
    private javax.swing.JList<String> jList6;
    private javax.swing.JList<String> jList7;
    private javax.swing.JList<String> jList8;
    private javax.swing.JList<String> jList9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem19;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem22;
    private javax.swing.JMenuItem jMenuItem23;
    private javax.swing.JMenuItem jMenuItem24;
    private javax.swing.JMenuItem jMenuItem25;
    private javax.swing.JMenuItem jMenuItem26;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel19;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel20;
    private javax.swing.JPanel jPanel21;
    private javax.swing.JPanel jPanel22;
    private javax.swing.JPanel jPanel23;
    private javax.swing.JPanel jPanel24;
    private javax.swing.JPanel jPanel25;
    private javax.swing.JPanel jPanel26;
    private javax.swing.JPanel jPanel27;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton11;
    private javax.swing.JRadioButton jRadioButton12;
    private javax.swing.JRadioButton jRadioButton13;
    private javax.swing.JRadioButton jRadioButton14;
    private javax.swing.JRadioButton jRadioButton15;
    private javax.swing.JRadioButton jRadioButton16;
    private javax.swing.JRadioButton jRadioButton4;
    private javax.swing.JRadioButton jRadioButton5;
    private javax.swing.JRadioButton jRadioButton6;
    private javax.swing.JRadioButton jRadioButton7;
    private javax.swing.JRadioButton jRadioButton8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane15;
    private javax.swing.JScrollPane jScrollPane16;
    private javax.swing.JScrollPane jScrollPane17;
    private javax.swing.JScrollPane jScrollPane18;
    private javax.swing.JScrollPane jScrollPane19;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane20;
    private javax.swing.JScrollPane jScrollPane21;
    private javax.swing.JScrollPane jScrollPane22;
    private javax.swing.JScrollPane jScrollPane23;
    private javax.swing.JScrollPane jScrollPane24;
    private javax.swing.JScrollPane jScrollPane25;
    private javax.swing.JScrollPane jScrollPane26;
    private javax.swing.JScrollPane jScrollPane27;
    private javax.swing.JScrollPane jScrollPane28;
    private javax.swing.JScrollPane jScrollPane29;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane30;
    private javax.swing.JScrollPane jScrollPane31;
    private javax.swing.JScrollPane jScrollPane32;
    private javax.swing.JScrollPane jScrollPane33;
    private javax.swing.JScrollPane jScrollPane34;
    private javax.swing.JScrollPane jScrollPane35;
    private javax.swing.JScrollPane jScrollPane36;
    private javax.swing.JScrollPane jScrollPane37;
    private javax.swing.JScrollPane jScrollPane38;
    private javax.swing.JScrollPane jScrollPane39;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane40;
    private javax.swing.JScrollPane jScrollPane41;
    private javax.swing.JScrollPane jScrollPane42;
    private javax.swing.JScrollPane jScrollPane43;
    private javax.swing.JScrollPane jScrollPane44;
    private javax.swing.JScrollPane jScrollPane45;
    private javax.swing.JScrollPane jScrollPane46;
    private javax.swing.JScrollPane jScrollPane47;
    private javax.swing.JScrollPane jScrollPane48;
    private javax.swing.JScrollPane jScrollPane49;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane50;
    private javax.swing.JScrollPane jScrollPane51;
    private javax.swing.JScrollPane jScrollPane52;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator6;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JSpinner jSpinner10;
    private javax.swing.JSpinner jSpinner11;
    private javax.swing.JSpinner jSpinner12;
    private javax.swing.JSpinner jSpinner13;
    private javax.swing.JSpinner jSpinner14;
    private javax.swing.JSpinner jSpinner15;
    private javax.swing.JSpinner jSpinner16;
    private javax.swing.JSpinner jSpinner17;
    private javax.swing.JSpinner jSpinner18;
    private javax.swing.JSpinner jSpinner19;
    private javax.swing.JSpinner jSpinner2;
    private javax.swing.JSpinner jSpinner20;
    private javax.swing.JSpinner jSpinner21;
    private javax.swing.JSpinner jSpinner3;
    private javax.swing.JSpinner jSpinner4;
    private javax.swing.JSpinner jSpinner5;
    private javax.swing.JSpinner jSpinner6;
    private javax.swing.JSpinner jSpinner7;
    private javax.swing.JSpinner jSpinner8;
    private javax.swing.JSpinner jSpinner9;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextArea jTextArea3;
    private javax.swing.JTextArea jTextArea5;
    private javax.swing.JTextArea jTextArea6;
    private javax.swing.JTextArea jTextArea7;
    private javax.swing.JTextArea jTextArea8;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField15;
    private javax.swing.JTextField jTextField16;
    private javax.swing.JTextField jTextField17;
    private javax.swing.JTextField jTextField18;
    private javax.swing.JTextField jTextField19;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField20;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTree jTree1;
    private javax.swing.JTree jTree2;
    private javax.swing.JInternalFrame listar_categorias;
    private javax.swing.JInternalFrame nueva_Categoria;
    public static javax.swing.ButtonGroup privacidad_NuevaLR;
    public static javax.swing.ButtonGroup privacidad_modListaR;
    public static javax.swing.ButtonGroup privacidad_modUsuario;
    public static javax.swing.ButtonGroup privacidad_modVideo;
    public static javax.swing.ButtonGroup privacidad_nuevoUsuario;
    private javax.swing.JInternalFrame quitar_video_listRep;
    public static javax.swing.ButtonGroup tipo_nLR;
    public static javax.swing.ButtonGroup valorarVideo;
    // End of variables declaration//GEN-END:variables
}
