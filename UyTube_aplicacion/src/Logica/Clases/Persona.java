package Logica.Clases;

public class Persona {
    String nombre;
    String apellido;
    String contrnia;

    public Persona(){
        this.nombre = "";
        this.apellido = "";
        this.contrnia = "";
    }

    public Persona(String nombre, String apellido, String contrnia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrnia = contrnia;
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
        return contrnia;
    }

    public void setContraseña(String contraseña) {
        this.contrnia = contraseña;
    }
    
    
}
