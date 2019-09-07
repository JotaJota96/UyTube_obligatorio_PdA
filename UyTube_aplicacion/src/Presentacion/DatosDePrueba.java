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
        
        cargarCategorias();
        cargarUsuariosYCanales();
        cargarSeguidores();
        cargarVideosAUsuarios();
        cargarListasDeReproduccionAUsuarios();
        agregarVideosAListasDeReproduccion();
        agregarComentarios();
        mostrarDatos();
    }
    
    private static void cargarCategorias(){
        sys.altaCategoria("MUSICA");
        sys.altaCategoria("DEPORTE");
        sys.altaCategoria("GAMING");
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
                new DtUsuario("JotaJota96", "12345678", "Juan", "Alvarez", "jjap96@gmail.com", new Date(96, 9, 9), "Imagenes\\JotaJota96.jpg", 0),
                new DtCanal(0, "GuitarCovers", "Covers en guitarra de rock uruguayo", Privacidad.PUBLICO)
        );
	 sys.altaUsuarioCanal(
                new DtUsuario("LuC31G", "12345678", "Lucas", "Garrido", "LuC31@gmail.com", new Date(98, 11, 31), "", 0),
                new DtCanal(0, "PricKG", "No se de que va a ser mi canal", Privacidad.PUBLICO)
        );
        sys.altaUsuarioCanal(
                new DtUsuario("MCBolso", "12345678", "Mariano", "Castro", "mcbolso96@gmail.com", new Date(99, 7, 4), "", 0),
                new DtCanal(0, "BolsoCovers", "Covers de lo mejor del futbool uruguayo", Privacidad.PUBLICO)
        );
        // Creacion de usuario Facundo
        sys.altaUsuarioCanal(
                new DtUsuario("camilillo15", "12345678", "Facundo", "Camilo", "facu_camilo2@hotmail.com", new Date(99, 6, 13), "", 0),
                new DtCanal(0, "Rock ingles", "Temones" ,Privacidad.PUBLICO)
        );
        
        sys.altaUsuarioCanal(
                new DtUsuario("jarrieta31", "jarrieta31", "Julio", "Arrieta", "julioarrieta23@gmail.com", new Date(76, 1, 31), "https://images.app.goo.gl/MX2hauy99QVndWdv6", 0),
                new DtCanal(0, "jarrieta31", "El mejor canal para pasar el rato", Privacidad.PUBLICO)
        );
    }
    
    private static void cargarSeguidores(){
        sys.seleccionarUsuario("JotaJota96");
        sys.seleccionarUsuarioActual("LuC31G");
        sys.seguirUsuario();
        sys.seleccionarUsuarioActual("camilillo15");
        sys.seguirUsuario();
        sys.seleccionarUsuarioActual("MCBolso");
        sys.seguirUsuario();
        
        sys.seleccionarUsuario("LuC31G");
        sys.seleccionarUsuarioActual("JotaJota96");
        sys.seguirUsuario();
        sys.seleccionarUsuarioActual("jarrieta31");
        sys.seguirUsuario();
        
        
        sys.seleccionarUsuario("jarrieta31");
        sys.seleccionarUsuarioActual("LuC31G");
        sys.seguirUsuario();
        sys.seleccionarUsuarioActual("JotaJota96");
        sys.seguirUsuario();
        sys.seleccionarUsuarioActual("MCBolso");
        sys.seguirUsuario();
        sys.seleccionarUsuarioActual("camilillo15");
        sys.seguirUsuario();        
        
        sys.liberarMemoriaUsuario();
        sys.liberarMemoriaUsuarioActual();
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
                new DtVideo(0, "Naufrago - 4 Pesos de Propina (Cover en guitarra)", "Cover de Naufrago - 4 Pesos de Propina ", new Time(18, 30, 3), new Date(119, 1, 2), "https://www.youtube.com/watch?v=ksuDZQuJLSY", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "Como pasa el tiempo - Cuarteto de nos (Cover en guitarra)", "Cover de Como pasa el tiempo - Cuarteto de nos ", new Time(15, 0, 0), new Date(119, 4, 15), "https://www.youtube.com/watch?v=n1AR_VSHPek", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "La casa de al lado Christian Cary (Cover en guitarra)", "Cover de La casa de al lado Christian Cary", new Time(21, 15, 0), new Date(119, 6, 21), "https://www.youtube.com/watch?v=An0uvGCUB9k", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "Verde - La Triple Nelson (Cover en guitarra)", "Cover de Verde - La Triple Nelson", new Time(11, 38, 0), new Date(119, 8, 29), "https://www.youtube.com/watch?v=ojYnrNRXOjk", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.liberarMemoriaUsuario();
        
        
        sys.seleccionarUsuario("LuC31G");
        sys.altaVideo(
                new DtVideo(0, "HolaQueHace", "Hola Que hace xD xD xD", new Time(18, 30, 3), new Date(119, 1, 2), "https://www.youtube.com/watch?v=Nl-Sq5OXIWk", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.liberarMemoriaUsuario();
        
        
        sys.seleccionarUsuario("MCBolso");
        sys.altaVideo(
                new DtVideo(0, "NO CREERÁS LO QUE LLEVO EN MI BOLSO", "Camila Guiribitey", new Time(18, 30, 3), new Date(119, 1, 2), "https://www.youtube.com/watch?v=7wCUuplgmQM", Privacidad.PRIVADO, "UNDEFINED", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "C.N. de F. Tema Nuevo 2019", "Por la del Bolso hay que matar o morir - La Banda Del Parque", new Time(15, 0, 0), new Date(119, 4, 15), "https://www.youtube.com/watch?v=9L5qQ9iyhJk", Privacidad.PRIVADO, "DEPORTE", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "No se como voy, no se como vengo", "Canta el bolso en la previa vs San Lorenzo", new Time(21, 15, 0), new Date(119, 6, 21), "https://www.youtube.com/watch?v=S0_FBF8XaO0", Privacidad.PRIVADO, "DEPORTE", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "Las mejores canciones de La Banda", "de La Banda del Parque (CON LETRA) | Hinchada de Nacional 2019", new Time(11, 38, 0), new Date(119, 8, 29), "https://www.youtube.com/watch?v=ob0TPs5-Y5Y", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.liberarMemoriaUsuario();
        
        
        sys.seleccionarUsuario("camilillo15");
        sys.altaVideo(
                new DtVideo(1, "505 - Arctic Monkeys", "Album Favourite Worst Nightmare", new Time(18, 30, 3), new Date(119, 1, 2), "https://www.youtube.com/watch?v=iV5VKdcQOJE", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(0, "Wonderwall - Oasis", "Ni idea como se llama el album", new Time(15, 0, 0), new Date(119, 4, 15), "https://www.youtube.com/watch?v=bx1Bh8ZvH84", Privacidad.PRIVADO, "MUSICA", 0, 0)
        );
        sys.liberarMemoriaUsuario();
        
        
        sys.seleccionarUsuario("jarrieta31");
        sys.altaVideo(
                new DtVideo(1, "Tutorial android 1", "Curso de android, tarea 4", new Time(00, 04, 2), new Date(119, 9, 30), "https://www.youtube.com/watch?v=xCq7YXGXaLc&list=PL-6ex1wzFuEh9RUN-5nCOU13eYknEXl09", Privacidad.PUBLICO, "UNDEFINED", 0, 0)
        );
        sys.altaVideo(
                new DtVideo(1, "Tutorial android 2", "Curso de android, tarea 5", new Time(00, 1, 17), new Date(119, 9, 30), "https://www.youtube.com/watch?v=i4W5LFeIdNU", Privacidad.PUBLICO, "UNDEFINED", 0, 0)
        );
        
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
                new DtListaDeReproduccion(0, "Minecraft", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "GAMING")
        );
        sys.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "Mis covers", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );
        sys.liberarMemoriaUsuario();
        
        sys.seleccionarUsuario("LuC31G");
        sys.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "Pasar el rato", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );
        sys.liberarMemoriaUsuario();
        
        sys.seleccionarUsuario("MCBolso");
        sys.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "Bolso siempre bolso naa", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
        );
        sys.liberarMemoriaUsuario();
        
        sys.seleccionarUsuario("camilillo15");
        sys.altaListaDeReproduccionParticular(
                new DtListaDeReproduccion(0, "Oasis", Privacidad.PUBLICO, TipoListaDeReproduccion.PARTICULAR, "UNDEFINED")
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
        
        nickname = "LuC31G";
        sys.seleccionarUsuario(nickname);
        sys.seleccionarUsuarioActual(nickname);
        misVideos = sys.listarVideosDeUsuario();
        misListas = sys.listarListasDeReproduccionDeUsuario(nickname);
        idLista = misListas.get(misListas.size()-1).getId();
        for (int i = 0; i < misVideos.size(); i++){
            sys.seleccionarVideo(misVideos.get(i).getId());
            sys.agregarVideoAListaDeReproduccion(idLista);
        }
        
        nickname = "MCBolso";
        sys.seleccionarUsuario(nickname);
        sys.seleccionarUsuarioActual(nickname);
        misVideos = sys.listarVideosDeUsuario();
        misListas = sys.listarListasDeReproduccionDeUsuario(nickname);
        idLista = misListas.get(misListas.size()-1).getId();
        for (int i = 0; i < misVideos.size(); i++){
            sys.seleccionarVideo(misVideos.get(i).getId());
            sys.agregarVideoAListaDeReproduccion(idLista);
        }
        
        nickname = "camilillo15";
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
    

    private static void agregarComentarios(){
        sys.seleccionarUsuario("JotaJota96");
        sys.seleccionarVideo(1);
        
        // 1
        sys.seleccionarUsuarioActual("LuC31G");
        sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Buenisimo!!", 0));
            // 2
            sys.seleccionarUsuarioActual("JotaJota96");
            sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Gracias!!!", 0), 1);
        // 3
        sys.seleccionarUsuarioActual("camilillo15");
        sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Cuando sale algo de los Artic Monkeys?",0));
            // 4
            sys.seleccionarUsuarioActual("LuC31G");
            sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Solo sube covers de rock nacional", 0), 3);
                // 5
                sys.seleccionarUsuarioActual("MCBolso");
                sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "siempre hay un boludo", 0), 4);
            // 6
            sys.seleccionarUsuarioActual("jarrieta31");
            sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "O de los Guns and Roses", 0), 3);
                // 7
                sys.seleccionarUsuarioActual("MCBolso");
                sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "otro mas...", 0), 6);
                    // 8
                    sys.seleccionarUsuarioActual("jarrieta31");
                    sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "otro mas que?", 7), 7);
        // 9
        sys.seleccionarUsuarioActual("MCBolso");
        sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "¿Que usas para editar el video?", 0));
            // 10
            sys.seleccionarUsuarioActual("JotaJota96");
            sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Sony Vegas Pro en Windows 10", 0), 9);
                // 11
                sys.seleccionarUsuarioActual("MCBolso");
                sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Tipico, nadie usa Linux.", 0), 10);
                    // 12
                    sys.seleccionarUsuarioActual("jarrieta31");
                    sys.altaComentario(new DtComentario(0, "", new Date(119, 7, 1), "Boo, que paso con Linux? hee??", 0), 11);

    }
    
    
    /////////////////////////////////////////////////////////////////////////////////////////////
    // Esta tampoco la toquen
    private static void mostrarDatos(){
        ArrayList<DtUsuario> users = sys.listarUsuarios();
        int tab = 0;
        for (DtUsuario u :users){
            tab = 0;
            
            System.out.println(u.toString());
            sys.seleccionarUsuario(u.getNickname());
            
            tab(tab+1);   System.out.println("Videos:");
            for (DtVideo v : sys.listarVideosDeUsuario()) {
               tab(tab+1);   System.out.println(v.toString());
                
               tab(tab+2);   System.out.println("Comentarios :");
               sys.seleccionarVideo(v.getId());
               boolean vacio = true;
               for (DtComentario c : sys.listarComentariosDeVideo()){
                   vacio = false;
                   tab(tab+2); tab(c.getNivelSubComentario()); System.out.println(c.toString());
                }
               if (vacio){
                   tab(tab+2);  System.out.println("No hay comentarios");
               }
                System.out.println("");
            }
            System.out.println("");
            
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
            
            System.out.println("");
            System.out.println("");
        }
        
    }
    
    // Ni esta
    private static void tab(int t){
        for (int i = 0; i < t; i++){
            System.out.print("    ");
        }
    }
    
}



