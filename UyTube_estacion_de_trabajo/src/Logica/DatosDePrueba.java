package Logica;

import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtListaDeReproduccionHistorial;
import Logica.DataType.DtRegistroHistorial;
import Logica.DataType.DtVideo;
import Logica.Interfaces.IAdmin;
import Logica.Interfaces.IUsuario;
import java.util.ArrayList;

public class DatosDePrueba {
    private static IAdmin adminSys = null;
    private static IUsuario usuSys = null;
    
    public static void main(String[] args) {
        //Fabrica f = Fabrica.getInstancia();
        try {
            /*
            usuSys = f.getIUsuario();
            
            usuSys.iniciarSesionUsuario("JotaJota96", "12345678");
            usuSys.seleccionarUsuario("JotaJota96");
            usuSys.seleccionarVideo(4);
            
            usuSys.agregarVideoAHistorial();
            usuSys.agregarVideoAHistorial();
            usuSys.agregarVideoAHistorial();
            usuSys.agregarVideoAHistorial();
            usuSys.agregarVideoAHistorial();
            
            DtListaDeReproduccion lista = usuSys.seleccionarListaDeReproduccion(14);
            ArrayList<DtRegistroHistorial> regs = ((DtListaDeReproduccionHistorial) lista).getRegistros();
            ArrayList<DtVideo> vids = usuSys.listarVideosDeListaDeReproduccion();
            for (int i = 0; i < vids.size(); i++) {
                DtRegistroHistorial r = regs.get(i);
                System.out.println("Video: " + vids.get(i).getNombre());
                System.out.println("Visualizaciones:" + r.getCantVisitas());
                System.out.println("Fecha:" + r.getUltimaVez().toString());
                System.out.println("-");
            }
            */
        } catch (Exception e) {
            System.out.println("//////////////////////////");
            System.out.println(e.getMessage());
            System.out.println("//////////////////////////");
        }
        System.exit(0);
    }
    
    
    /*
    private static void mostrarLista(ArrayList<Object> lst){
        // Prueba de búsqueda por categoría
        for (Object o : lst){
            System.out.println("> " + o.toString());
        }
    }
    */
    private static void mostrarLista(Object lst){
        // Prueba de búsqueda por categoría
        for (Object o : (ArrayList<Object>)lst){
            System.out.println("> " + o.toString());
        }
    }
}
