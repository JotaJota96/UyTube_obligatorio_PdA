package Logica.Clases;

public class Persona {
    String nombre;
    String apellido;
    String contraseña;

    public Persona(){
        this.nombre = "";
        this.apellido = "";
        this.contraseña = "";
    }

    public Persona(String nombre, String apellido, String contraseña) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
