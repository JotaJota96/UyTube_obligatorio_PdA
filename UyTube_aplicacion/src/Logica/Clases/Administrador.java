package Logica.Clases;

public class Administrador extends Persona{
    private int idAdmin;
    private static int contadorAdministrador = 1;
            
    public Administrador(int id, String contrasenia, String nombre, String apellido){
        super(nombre,apellido,contrasenia);
        idAdmin = id;
    }
    
    public static int getNuevoID(){
        return contadorAdministrador++;
    }

    public int getIdAdmin() {
        return idAdmin;
    }
    
    
    
}
