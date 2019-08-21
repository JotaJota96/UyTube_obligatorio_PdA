package Logica;

import Logica.Clases.Canal;
import Logica.Clases.Usuario;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;

public class main {
    public static void main(String[] args) {
        System.out.println("Hola mundo");
        Canal c = new Canal(Canal.getNuevoId(),"Luc31G" ," ", Privacidad.PUBLICO);
        Usuario u = new Usuario("LuC31G", "LUC31G@gmail.com", null, " ", " ", "Lucas", "Garrido", c.getDT());
        Usuario u1 = new Usuario("1", "1@gmail.com", null, " ", " ", "1", "1", null);
        Usuario u2 = new Usuario("2", "2@gmail.com", null, " ", " ", "2", "2", null);
        
        u.agregarOQuitarSeguido(u1);
        u.agregarOQuitarSeguido(u2);
        u.agregarOQuitarSeguidor(u2);
        
        System.out.println(u.listarUsuariosSeguidores().get(0).getNickname());
        
    }
}
