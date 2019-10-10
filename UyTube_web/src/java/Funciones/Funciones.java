package Funciones;

/**
 *
 * @author Juan
 */
public class Funciones {
    
    /**
     * Extrae el ID del video
     * @param URLYoutube URL del video de Youtube
     * @return ID del video
     */
    public static String extraerIDYoutube(String URLYoutube) {
        //https://www.youtube.com/embed/fepmsnGBwJo
        String idYoutube = "";
        String urlDT = URLYoutube;
        int i = 0;
        for (; i < urlDT.length() && urlDT.charAt(i) != '='; i++) {
        }
        i++;
        for (; i < urlDT.length(); i++) {
            idYoutube += urlDT.charAt(i);
        }
        return idYoutube;
    }
    
    /**
     * Enlace para embeber video en una página
     * @param idYoutube ID del video de Youtube
     * @return En lace para embeber video
     */
    public static String obtenerEnlaceEmbebido(String idYoutube) {
        return "https://www.youtube.com/embed/" + idYoutube;
    }
    
    /**
     * Obtiene la url de la miniatura del video original en YouTube
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
        switch (tamanio){
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
    
}
