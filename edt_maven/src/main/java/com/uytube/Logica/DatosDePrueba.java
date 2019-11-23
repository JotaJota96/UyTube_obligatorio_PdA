package com.uytube.Logica;

import com.uytube.Logica.Interfaces.IAdmin;
import com.uytube.Logica.Interfaces.IUsuario;
import java.util.ArrayList;

public class DatosDePrueba {
    private static IAdmin adminSys = null;
    private static IUsuario usuSys = null;
    
    public static void main(String[] args) {
        //Fabrica f = Fabrica.getInstancia();
        try {
            
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
