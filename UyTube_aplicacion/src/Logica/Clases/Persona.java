package Logica.Clases;

public class Persona {
    private String nombre;
    private String apellido;
    private String contrasenia;

    public Persona(String nombre, String apellido, String contrasenia) {
        if(contrasenia == ""){
                throw new RuntimeException("La contraseña no puede ser Vacio");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public boolean validarContrasenia(String pass){
        return this.contrasenia.equals(pass);
    }
    
}
