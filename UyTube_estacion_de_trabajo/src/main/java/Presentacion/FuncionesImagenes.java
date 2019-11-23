package Presentacion;

import java.awt.Image;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import sun.awt.image.ByteArrayImageSource;
import sun.awt.image.ToolkitImage;

public class FuncionesImagenes {
    
    private static final FuncionesImagenes INSTANCE = new FuncionesImagenes();
    private FuncionesImagenes(){}
    
    public static byte[] pathToByteArray(String ruta) {
        try {
            File f = new File(ruta); //asociamos el archivo fisico
            InputStream is = new FileInputStream(f); //lo abrimos. Lo importante es que sea un InputStream
            byte[] buffer = new byte[(int) f.length()]; //creamos el buffer
            int readers = is.read(buffer); //leemos el archivo al buffer
            return buffer;
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public static Image byteArrayToImage(byte[] arrayDeBytes) {
        try {
            Image image = new ToolkitImage(new ByteArrayImageSource(arrayDeBytes)); //lo convertimos a Image
            return image;
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public static String seleccionarImagen() {
        // Crea un JFileChooser
        JFileChooser JFC = new JFileChooser();
        // crea un filtro para aceptar solo algunas extensiones
        FileNameExtensionFilter filtroImagen = new FileNameExtensionFilter("JPG", "JPEG", "PNG", "jpg", "jpeg", "png");
        // Agrega el filtro al JFileChooser
        JFC.setFileFilter(filtroImagen);

        // archivo seleccionado
        File archivo;
        // para saber si se selecciono algo o se cancelo
        int resultado;

        while (true) {
            // muestra el JFileChooser
            resultado = JFC.showOpenDialog(null);

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
    
    public static void cargarImagenPorDefectoEnJlabel(javax.swing.JLabel jLabelx) {
        jLabelx.setText(null);
        URL path = INSTANCE.getClass().getClassLoader().getResource("ukp.png");
        // Carga la imagen a la variable de tipo Image
        Image img = new ImageIcon(path).getImage();
        // Crea un ImageIcon a partir de la imagen (obtiene las dimenciones del jLbel y escala la imagen para que entre en el mismo)
        ImageIcon icono = new ImageIcon(
                img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH)
        );
        // establece la imagen en el label
        jLabelx.setIcon(icono);
    }


    public static void cargarImagenEnJlabel(javax.swing.JLabel jLabelx, Image img) {
        jLabelx.setText(null);
        if (img == null){
            jLabelx.setIcon(null);
            return;
        }
        // Carga la imagen a la variable de tipo Image
        // Crea un ImageIcon a partir de la imagen (obtiene las dimenciones del jLbel y escala la imagen para que entre en el mismo)
        ImageIcon icono = new ImageIcon(
                img.getScaledInstance(jLabelx.getWidth(), jLabelx.getHeight(), Image.SCALE_SMOOTH)
        );
        // establece la imagen en el label
        jLabelx.setIcon(icono);
    }
    
    public static String getExtensionArchivo(String nombreArchivo){
        String ret = "";
        // recorre desde el final hacia el principio hasta encontrar un '.'  extrayendo la extension del archivo
        for (int i = nombreArchivo.length() - 1; i >= 0; i--) {
            if (nombreArchivo.charAt(i) == '.') {
                break;
            }
            ret = nombreArchivo.charAt(i) + ret;
        }
        // si la extension obtenida es igual al nombre del archivo, entonces no se encontro ningun punto y el archivo no tienee extension
        if (ret.equals(nombreArchivo)) {
            return "";
        }
        // sino devuelve la extension obtenida
        return ret;
    }
    
    
    public static String getNombreArchivo(String nombreArchivo){
        String ret = "";
        // recorre desde el final hacia el principio hasta encontrar un '.'  extrayendo la extension del archivo
        for (int i = nombreArchivo.length() - 1; i >= 0; i--) {
            if (nombreArchivo.charAt(i) == '/' || nombreArchivo.charAt(i) == '\\') {
                break;
            }
            ret = nombreArchivo.charAt(i) + ret;
        }
        // si la extension obtenida es igual al nombre del archivo, entonces no se encontro ningun punto y el archivo no tienee extension
        if (ret.equals(nombreArchivo)) {
            return "";
        }
        // sino devuelve la extension obtenida
        return ret;
    }
}
