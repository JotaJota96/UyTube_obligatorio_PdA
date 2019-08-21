package Logica;

import Logica.Clases.*;
import Logica.DataType.*;
import Logica.Enumerados.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        
        
        System.out.println("Creando lista nueva");
        ListaDeReproduccion l1 = new ListaDeReproduccion(1, "lista_test", Privacidad.PRIVADO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED");
        System.out.println(l1.toString());
        
        System.out.println("Creando 5 videos");
        Video v1 = new Video(Video.getNuevoId(), "video_1", "desc_1", new Time(0, 1, 50), new Date(2019-1900, 0, 5), "url_1", "DEFAULT");
        Video v2 = new Video(Video.getNuevoId(), "video_2", "desc_2", new Time(0, 2, 40), new Date(2019-1900, 2, 4), "url_2", "MUSICA");
        Video v3 = new Video(Video.getNuevoId(), "video_3", "desc_3", new Time(0, 3, 30), new Date(2019-1900, 3, 3), "url_3", "DEPORTE");
        Video v4 = new Video(Video.getNuevoId(), "video_4", "desc_4", new Time(0, 4, 20), new Date(2019-1900, 4, 2), "url_4", "GAMING");
        Video v5 = new Video(Video.getNuevoId(), "video_5", "desc_5", new Time(0, 5, 10), new Date(2019-1900, 5, 1), "url_5", "MUSICA");
        
        System.out.println("agregando videos 1, 3 y 4");
        l1.agregarVideoA(v3);
        l1.agregarVideoA(v1);
        l1.agregarVideoA(v4);
        System.out.println(l1.toString());
        
        System.out.println("Quitando video 2");
        l1.quitarVideo(2);
        System.out.println(l1.toString());
        System.out.println("Quitando video 3");
        l1.quitarVideo(3);
        System.out.println(l1.toString());
        System.out.println("agregando video 5");
        l1.agregarVideoA(v5);
        
        System.out.println("Listando todos los videos");
        ArrayList<DtVideo> dt = l1.listarVideos();
        for (int i = 0; i < dt.size(); i++){
            System.out.println(dt.get(i).toString());
        }
        
        
        
    }
}
