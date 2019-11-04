package Funciones;

import java.util.Map;
import logica.controladores.CUsuario;
import logica.controladores.CUsuarioService;
import logica.controladores.DtUsuario;

/**
 *
 * @author Juan
 */
public class Funciones {

    /**
     * Extrae el ID del video
     *
     * @param URLYoutube URL del video de Youtube
     * @return ID del video
     */
    public static String extraerIDYoutube(String URLYoutube) {
        //https://www.youtube.com/embed/fepmsnGBwJo
        String idYoutube = "";
        String urlDT = URLYoutube;
        int i = 0;
        i = URLYoutube.indexOf("v=") + 2;

        for (; i < urlDT.length(); i++) {
            if (urlDT.charAt(i) == '&') {
                break;
            }
            idYoutube += urlDT.charAt(i);
        }
        return idYoutube;
    }

    /**
     * Enlace para embeber video en una página
     *
     * @param idYoutube ID del video de Youtube
     * @return En lace para embeber video
     */
    public static String obtenerEnlaceEmbebido(String idYoutube) {
        return "https://www.youtube.com/embed/" + idYoutube;
    }

    /**
     * Obtiene la url de la miniatura del video original en YouTube
     *
     * @param idYoutube ID del video de Youtube
     * @param tamanio Tamaño de la imagen [1 a 4]
     * @return URL de la miniatura del video
     */
    public static String obtenerImagenDeVideo(String idYoutube, int tamanio) {
        /*
        http://img.youtube.com/vi/VideoID/default.jpg
        http://img.youtube.com/vi/VideoID/mqdefault.jpg
        http://img.youtube.com/vi/VideoID/hqdefault.jpg
        http://img.youtube.com/vi/VideoID/sddefault.jpg
         */
        String strTamanio = "/default.jpg";
        switch (tamanio) {
            case 1:
                strTamanio = "/default.jpg";
                break;
            case 2:
                strTamanio = "/mqdefault.jpg";
                break;
            case 3:
                strTamanio = "/hqdefault.jpg";
                break;
            case 4:
                strTamanio = "/sddefault.jpg";
                break;
        }
        return "https://i.ytimg.com/vi/" + idYoutube + strTamanio;
    }

    public static java.sql.Date fechaActual() {
        java.util.Date today = new java.util.Date();
        java.sql.Date ret = new java.sql.Date(today.getTime());
        return ret;
    }

    public static void showLog(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) {
        try {
            String inicio = "-------- " + request.getMethod() + " " + request.getRequestURI() + " --------";
            System.out.println(inicio);

            if (request.getParameterMap().size() > 0) {
                System.out.println("Atributos:");
                for (Map.Entry<String, String[]> it : request.getParameterMap().entrySet()) {
                    if (it.getValue().length > 0) {
                        for (int i = 0; i < it.getValue().length; i++) {
                            System.out.println(it.getKey() + ": '" + it.getValue()[i] + "'");
                        }
                    } else {
                        System.out.println(it.getKey() + ": '''");
                    }
                }
            } else {
                System.out.println("No hay parametros");
            }
            for (int i = 0; i < inicio.length(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("---- Error al intentar mostrar el log ----");
            System.out.println(e.getMessage());
            System.out.println("------------------------------------------");
        }
    }

    public static void showLog(String titulo, String log) {
        try {
            if (titulo == null) {
                titulo = "No hay titulo";
            }
            if (log == null) {
                log = "No hay mensaje";
            }
            titulo = "---- " + titulo + " ----";

            System.out.println(titulo);
            System.out.println(log);
            for (int i = 0; i < titulo.length(); i++) {
                System.out.print("-");
            }
            System.out.println("");
        } catch (Exception e) {
            System.out.println("");
            System.out.println("///// No se pudo mostrar el log ////");
            System.out.println("");
        }
    }

    public static void showLog(Exception e) {
        System.out.println();
        System.out.println("//////////// Exception ////////////");
        System.out.println(e.getMessage());
        System.out.println("///////////////////////////////////");
    }

}
