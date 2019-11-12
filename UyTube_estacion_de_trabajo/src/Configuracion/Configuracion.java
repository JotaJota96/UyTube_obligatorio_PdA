package Configuracion;

/**
 * El codigo de esta clase esta basado en la documentacion recomendada
 * https://docs.oracle.com/javase/tutorial/essential/environment/properties.html
 */
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Properties;

public class Configuracion {

    private static final String NOMBRE_ARCHIVO = "src/Configuracion/configuracion.properties";
    
    public static String getValue(String clave) {
        Exception ex = null;
        for (int intentos = 2; intentos > 0; intentos--){
            try {
                // Creo una variable para guardar las propiedades guardadas
                Properties propiedades = new Properties();
                // Creo un flujo de entrada
                FileInputStream in = new FileInputStream(NOMBRE_ARCHIVO);
                // Cargo las propiedades utilizando el flujo de entrada
                propiedades.load(in);
                // termino la lectura
                in.close();
                // retorno el valor almacenado para la clave solicitada
                return propiedades.getProperty(clave);
            } catch (Exception e) {
                ex = e;
                // si no se pudo leer el archivo, hay que generar el archivo por defecto y leer desde el (si se logro crear)
                generarArchivoPorDefecto();
            }
        }
        throw new RuntimeException(ex.getMessage());
    }

    private static void generarArchivoPorDefecto() {
        try {
            // creo una variable de propiedades
            Properties propiedades = new Properties();
            
            // Defino el contenido del archivo con la configuracion por defecto
            String contenido = "";
            contenido += "Descripcion de los datos\n";
            contenido += "rutaPublicacionWebService: Ruta en la cual se publicara el Web Service\n";
            
            // Agrego las propiedades a guardar
            propiedades.setProperty("rutaPublicacionWebService", "http://192.168.1.7:9789/UyTube_ws");
            
            // creo un flujo de salida mediante el cual se escribiran los datos
            FileOutputStream out = new FileOutputStream(NOMBRE_ARCHIVO);
            // mando a escribir la informacion utilizando el flujo de salida
            propiedades.store(out, contenido);
            // termina la escritura
            out.close();
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
