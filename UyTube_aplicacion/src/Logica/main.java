package Logica;

import Logica.Interfaces.IAdmin;


public class main {

    public static void main(String[] args) {
        try {
            // Obtengo una fabrica
            Fabrica fab = Fabrica.getInstancia();
            // le pido la instancia del sistema
            IAdmin sys = fab.getIAdmin();
            
            // Aca se pueden ir llamando las funciones del sistema para el administrador
            
        } catch (Exception e) {
            System.out.println("-->>" + e);
        }
    }
}
