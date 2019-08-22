package Logica;

import Logica.Clases.Canal;
import Logica.Clases.Usuario;
import Logica.DataType.DtUsuario;
import Logica.Enumerados.Privacidad;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {
        
        Canal c = new Canal(Canal.getNuevoId(),"Luc31G" ," ", Privacidad.PUBLICO);
        
        Usuario Usu = new Usuario("LuC31G", "LUC31G@gmail.com", null, " ", " ", "Lucas", "Garrido", c.getDT());
        Usuario Usu2 = new Usuario("1", "LUC31G@gmail.com", null, " ", " ", "Lucas", "Garrido", c.getDT());
        Usuario Usu3 = new Usuario("2", "LUC31G@gmail.com", null, " ", " ", "Lucas", "Garrido", c.getDT());
        
        Usu.agregarOQuitarSeguido(Usu2);
        Usu.agregarOQuitarSeguido(Usu3);
        
        ArrayList<DtUsuario> ARL = Usu.listarUsuariosSeguidos();
        //ArrayList<DtUsuario> ARL2 = Usu3.listarUsuariosSeguidores();
        
        for (int i = 0; i < ARL.size(); i++) {
            System.out.println(ARL.get(i).toString());
        }
        
    }
}
