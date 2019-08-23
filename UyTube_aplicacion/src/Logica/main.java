package Logica;

import Logica.Clases.Usuario;
import Logica.DataType.DtCanal;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import java.sql.Date;
import java.util.ArrayList;


public class main {
    public static void main(String[] args) {
        try {
             Usuario u1 = new Usuario("nk1", "c1", new Date(0, 0, 0), "", "1234", "nom", "ape", 
                new DtCanal(0, "canal1", "", Privacidad.PRIVADO));
            Usuario u2 = new Usuario("nk2", "c2", new Date(0, 0, 0), "", "1234", "nom", "ape", 
                new DtCanal(0, "canal2", "", Privacidad.PRIVADO));
            Usuario u3 = new Usuario("nk3", "c3", new Date(0, 0, 0), "", "1234", "nom", "ape", 
                new DtCanal(0, "canal3", "", Privacidad.PRIVADO));
            Usuario u4 = new Usuario("nk4", "c4", new Date(0, 0, 0), "", "1234", "nom", "ape", 
                new DtCanal(0, "canal4", "", Privacidad.PRIVADO));
            
            u1.agregarOQuitarSeguido(u2);
            u1.agregarOQuitarSeguido(u3);
            u1.agregarOQuitarSeguido(u4);
            
            u3.agregarOQuitarSeguido(u1);
            
            
            ArrayList<DtUsuario> l1 = u3.listarUsuariosSeguidos();
            ArrayList<DtUsuario> l2 = u3.listarUsuariosSeguidores();
            
            for (int i = 0; i < l1.size(); i++){
                System.out.println(l1.get(i).toString());
            }
            
            System.out.println("-------------------");
            
            for (int i = 0; i < l2.size(); i++){
                System.out.println(l2.get(i).toString());
            }
            
        } catch (Exception e) {
            System.out.println("-->>" + e);
        }
 
        
        
    }
}
