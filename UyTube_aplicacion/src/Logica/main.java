package Logica;

import Logica.Clases.Comentario;
import Logica.Clases.Usuario;
import Logica.DataType.DtComentario;
import java.sql.Date;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        /*Usuario u1 = new Usuario("nicku1", "email1", new Date(2019-1900,7,15), "c/imagenes/algo1.jpg", "1234", "carlos1", "perez1", null);
        Usuario u2 = new Usuario("nicku2", "email2", new Date(2019-1900,7,15), "c/imagenes/algo2.jpg", "1234", "carlos2", "perez2", null);
        Usuario u3 = new Usuario("nicku3", "email3", new Date(2019-1900,7,15), "c/imagenes/algo3.jpg", "1234", "carlos3", "perez3", null);
        Usuario u4 = new Usuario("nicku4", "email4", new Date(2019-1900,7,15), "c/imagenes/algo4.jpg", "1234", "carlos4", "perez4", null);
        Usuario u5 = new Usuario("nicku5", "email5", new Date(2019-1900,7,15), "c/imagenes/algo5.jpg", "1234", "carlos5", "perez5", null);
        
        Comentario c1 = new Comentario(Comentario.getNuevoID(), new Date(2019-1900,7,15), "1: exelente video", 0, u1);

        c1.agregarSubComentario(c1.getId(), new DtComentario(1, null,new Date(2019-1900,7,15), "sub_1_1: mas o menos", 1), u2);
        c1.agregarSubComentario(c1.getId(), new DtComentario(1, null,new Date(2019-1900,7,15), "sub_1_2: mas o menos", 1), u3);
        c1.agregarSubComentario(c1.getId(), new DtComentario(1, null,new Date(2019-1900,7,15), "sub_1_3: mas o menos", 1), u4);
        
        c1.agregarSubComentario(c1.getId(), new DtComentario(1, null,new Date(2019-1900,7,15), "sub_1_sub_1_1: mas o menos", 2), u3);
        
        ArrayList l = c1.listarSubComentarios();
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i).toString());
        }*/
        ArrayList<Integer> l = new ArrayList();
        l.add(2);
        l.add(8);
        l.add(15);
        l.add(22);
        l.add(7);
        for(int i=0;i<l.size();i++){
            System.out.println(l.get(i));
        }
    }
}
