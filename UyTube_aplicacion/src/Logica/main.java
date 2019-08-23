package Logica;

import Logica.Clases.Usuario;
import Logica.Clases.Video;
import Logica.DataType.DtCanal;
import Logica.DataType.DtComentario;
import Logica.DataType.DtValoracion;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoValoracion;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        
        Video v = new Video(Video.getNuevoId(), "nombe", "", new Time(0, 4, 25), new Date(2019-1900, 1, 1), "url", "UNDEFINED");
        Usuario u1 = new Usuario("nk1", "nk1", new Date(2019-1900, 1, 1), "", "1234", "", "", 
                new DtCanal(0, "can_1", "", Privacidad.PRIVADO));
        Usuario u2 = new Usuario("nk2", "nk2", new Date(2019-1900, 1, 1), "", "1234", "", "", 
                new DtCanal(0, "can_2", "", Privacidad.PRIVADO));
        Usuario u3 = new Usuario("nk3", "nk3", new Date(2019-1900, 1, 1), "", "1234", "", "", 
                new DtCanal(0, "can_3", "", Privacidad.PRIVADO));
        
        v.agregarComentario(new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_1", 0), u1);
        v.agregarComentario(new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_2", 0), u2);
        v.agregarComentario(new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_3", 0), u1);
        v.agregarComentario(new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_4", 0), u2);
        
        v.agregarComentario(1, new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_1.1", 0), u1);
        v.agregarComentario(1, new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_1.2", 0), u2);
        v.agregarComentario(2, new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_2.1", 0), u1);
        v.agregarComentario(4, new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_4.1", 0), u2);
        v.agregarComentario(6, new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_1.2.1", 0), u1);
        v.agregarComentario(9, new DtComentario(0, "", new Date(2019-1900, 1, 1), "com_1.2.1.1", 0), u2);
        /*
        ArrayList<DtComentario> l = v.listarComentarios();
        for (int i = 0; i < l.size(); i++){
            System.out.println(l.get(i).toString());
        }
        */
        
        v.agregarModificarValoracion(new DtValoracion(TipoValoracion.LIKE, "nk1"), u1);
        v.agregarModificarValoracion(new DtValoracion(TipoValoracion.DISLIKE, "nk2"), u2);
        v.agregarModificarValoracion(new DtValoracion(TipoValoracion.LIKE, "nk3"), u3);
        
        v.quitarValoracion("nk3");
        
        System.out.println("Likes: " + v.getCantLikes());
        System.out.println("DisLikes: " + v.getCantDisLikes());
        ArrayList<DtValoracion> l = v.listarValoraciones();
        for (int i = 0; i < l.size(); i++){
            System.out.println(l.get(i).toString());
        }
        
    }
}
