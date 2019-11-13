package Funciones;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import logica.controladores.Duracion;
import logica.controladores.Fecha;

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
    
    public static boolean esUnDispositivoMovil(HttpServletRequest request){
        /**
         * El plan B en caso de que esta funcion no funcione (osea, que sea una
         * disfuncion) es utilizar esta clase: 
         * https://github.com/ahand/mobileesp/tree/master/Java
         */
        String ua = request.getHeader("User-Agent");
        //System.out.println("El cliente es: " + ua);
        String[] so = {"Linux", "Windows", "Mac OS", "Iphone", "Android"};
        //String cliente = "";
        for (String item : so) {
            switch (item) {
                case "Linux":
                    //console.log(ua);
                    if (ua.indexOf("Android") != -1 && ua.indexOf("Linux") != -1) {
                        //cliente = "Estás usando android";
                        return true;
                    }
                    if (ua.indexOf("Linux") != -1) {
                        return false;
                    }
                    break;
                case "Mac OS":
                    if (ua.indexOf("iPhone OS") != -1 && ua.indexOf("Mac OS") != -1) {
                        //cliente  = "Estás usando iphone";
                        return true;
                    }
                    if (ua.indexOf("Mac OS") != -1) {
                        //cliente  = "Estas usando Mac";
                        return false;
                    }
                    break;
                case "Windows":
                    if (ua.indexOf("Win64") != -1 || ua.indexOf("Win32") != -1 || ua.indexOf("Win86") != -1) {
                        //cliente  = "Estas en Windows";
                        return false;
                    }
                    break;

            }
        }
        return false;
    }
    
    public static boolean isNumeric(String cadena) {
        boolean resultado;
        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public static String darFormatoFecha(Fecha f){
        int anio = f.getAnio();
        int mes = f.getMes();
        int dia = f.getDia();
        
        String strAnio = "" + anio;
        String strMes = "" + mes;
        String strDia = "" + dia;
        
        if (mes < 10) strMes = "0" + mes;
        if (dia < 10) strDia = "0" + dia;
        
        return strAnio + "-" + strMes + "-" + strDia;
    }
    
    public static String darFormatoDuracion(Duracion d){
        int horas = d.getHoras();
        int minutos = d.getMinutos();
        int segundos = d.getSegundos();
        
        String strHoras = "" + horas;
        String strMinutos = "" + minutos;
        String strSegundos = "" + segundos;
        
        if (horas < 10) strHoras = "0" + horas;
        if (minutos < 10) strMinutos = "0" + minutos;
        if (segundos < 10) strMinutos = "0" + segundos;
        
        return strHoras + ":" + strMinutos + ":" + strSegundos;
    }
    
    public static String getEnVEntry(String clave) {
        // https://stackoverflow.com/questions/4195688/how-can-i-read-context-parameter-web-xml-values-in-a-non-servlet-java-file
        try {
            // Get the base naming context
            javax.naming.Context env = (javax.naming.Context) new javax.naming.InitialContext().lookup("java:comp/env");
            // Get a single value
            return (String) env.lookup(clave);
        } catch (javax.naming.NamingException ex) {
            throw new RuntimeException(ex.getMessage());
        }
    }
    
}
