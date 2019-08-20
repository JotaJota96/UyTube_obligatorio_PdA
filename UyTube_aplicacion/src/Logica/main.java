package Logica;

import Logica.Clases.Administrador;
import Logica.Clases.Persona;
import Logica.Clases.Usuario;

public class main {
    public static void main(String[] args) {
        Persona U = new Usuario("Luc31G", "LuC31G@gmail.com",null, " ", "", "Lucas", "Garrido", null);
        Usuario usu = (Usuario)U;
        U.setNombre("Lucasssss");
        System.out.println(usu.getDT().getNickname());
         
    
    }
}
