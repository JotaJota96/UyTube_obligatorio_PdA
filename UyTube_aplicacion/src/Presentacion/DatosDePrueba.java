package Presentacion;

import Logica.Clases.Usuario;
import Logica.Fabrica;
import Logica.Interfaces.IAdmin;
import Logica.DataType.*;
import Logica.Enumerados.*;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
/**
 * Esta clase fue hecha para cargar datos de prueba en el sistema
 * @author Juan
 */
public class DatosDePrueba {
    private static IAdmin sys = null;
    
    // Esta funcion no la toquen
    public static void cargarDatos(){
        // Se obtiene la instancia de la fabrica
        Fabrica f = Fabrica.getInstancia();
        // Se le pide a la fabrica la instancia del sistema que usaremos
        sys = f.getIAdmin();
        // ahora se puede interactuar con el sistema invocando sus funciones mediante sys
        
        cargarUsuariosYCanales();
        cargarVideosAUsuarios();
        cargarListasDeReproduccionAUsuarios();
        agregarVideosAListasDeReproduccion();
        mostrarDatos();
    }
    
    private static void cargarUsuariosYCanales(){
        /* Plantilla de creacion de usuario:
        instance.altaUsuarioCanal(
                new DtUsuario("usu1", "contrasenia1", "nombre1", "apellido1", "correo1", new Date(86, 5, 18), "imagen1", 0),
                new DtCanal(0, "canal1", "descripcion1", Privacidad.PUBLICO)
        );
        */
        
        // Creacion de usuario Juan
        sys.altaUsuarioCanal(
                new DtUsuario("JotaJota96", "12345678", "Juan", "Alvarez", "jjap96@gmail.com", new Date(96, 9, 9), "", 0),
                new DtCanal(0, "GuitarCovers", "Covers en guitarra de rock uruguayo", Privacidad.PUBLICO)
        );
        
        
        
    }
    
    private static void cargarVideosAUsuarios(){
        /* Plantilla de creacion de Alta Video:
        sys.seleccionarUsuario("tu nickname");
        sys.altaVideo(
                new DtVideo(1, "Naufrago - 4 Pesos de Propina (Cover en guitarra)", "Cover de Naufrago - 4 Pesos de Propina ", new Time(18, 30, 3), new Date(119, 1, 2), "https://www.youtube.com/watch?v=ksuDZQuJLSY", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.liberarMemoriaUsuario();
        */
        
        sys.seleccionarUsuario("JotaJota96");
        sys.altaVideo(
                new DtVideo(0, "Naufrago - 4 Pesos de Propina (Cover en guitarra)", "Cover de Naufrago - 4 Pesos de Propina ", new Time(18, 30, 3), new Date(119, 1, 2), "https://www.youtube.com/watch?v=ksuDZQuJLSY", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "Como pasa el tiempo - Cuarteto de nos (Cover en guitarra)", "Cover de Como pasa el tiempo - Cuarteto de nos ", new Time(15, 0, 0), new Date(119, 4, 15), "https://www.youtube.com/watch?v=n1AR_VSHPek", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "La casa de al lado Christian Cary (Cover en guitarra)", "Cover de La casa de al lado Christian Cary", new Time(21, 15, 0), new Date(119, 6, 21), "https://www.youtube.com/watch?v=An0uvGCUB9k", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "Verde - La Triple Nelson (Cover en guitarra)", "Cover de Verde - La Triple Nelson", new Time(11, 38, 0), new Date(119, 8, 29), "https://www.youtube.com/watch?v=ojYnrNRXOjk", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.liberarMemoriaUsuario();
        
    }
    
    private static void cargarListasDeReproduccionAUsuarios(){
        /* Plantilla de creacion de lista de reproduccion particular
        
        sys.seleccionarUsuario("tu nickname");
        sys.seleccionarUsuario("tu nickname");
        sys.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "mi lista", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );
        sys.liberarMemoriaUsuario();
        */
        
        sys.seleccionarUsuario("JotaJota96");
        sys.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "Mis covers", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );
        sys.liberarMemoriaUsuario();
        
    }
    
    private static void agregarVideosAListasDeReproduccion(){
        String nickname = "";
        ArrayList<DtVideo> misVideos;
        ArrayList<DtListaDeReproduccion> misListas;
        int idLista;
        
        // copien y peguen el siguiente codigo y solo modifiquen su nickname
        nickname = "JotaJota96";
        sys.seleccionarUsuario(nickname);
        sys.seleccionarUsuarioActual(nickname);
        misVideos = sys.listarVideosDeUsuario();
        misListas = sys.listarListasDeReproduccionDeUsuario(nickname);
        idLista = misListas.get(misListas.size()-1).getId();
        for (int i = 0; i < misVideos.size(); i++){
            sys.seleccionarVideo(misVideos.get(i).getId());
            sys.agregarVideoAListaDeReproduccion(idLista);
        }
        
        
    }
    
    // Esta tampoco la toquen
    private static void mostrarDatos(){
        ArrayList<DtUsuario> users = sys.listarUsuarios();
        int tab = 0;
        for (DtUsuario u :users){
            tab = 0;
            
            System.out.println(u.toString());
            sys.seleccionarUsuario(u.getNickname());
            
            tab(tab+1);   System.out.println("-- Videos --");
            for (DtVideo v : sys.listarVideosDeUsuario()) {
               tab(tab+1);   System.out.println(v.toString());
            }
            
            tab(tab+1);   System.out.println("-- Listas --");
            for (DtListaDeReproduccion l : sys.listarListasDeReproduccionDeUsuario(u.getNickname())) {
               tab(tab+1);   System.out.println(l.toString());
               sys.seleccionarListaDeReproduccion(l.getId());
               boolean vacia = true;
               for (DtVideo v : sys.listarVideosDeListaDeReproduccion()) {
                   vacia = false;
                   tab(tab+2);   System.out.println(v.toString());
               }
               if (vacia){
                   tab(tab+2);   System.out.println("No hay videos en la lista");
               }
            }
            
            
            
            
        }
        
    }
    
    // Ni esta
    private static void tab(int t){
        for (int i = 0; i < t; i++){
            System.out.print("    ");
        }
    }
    
}



