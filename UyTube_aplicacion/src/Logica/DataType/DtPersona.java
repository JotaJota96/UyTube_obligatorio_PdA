package Logica.DataType;

public abstract class DtPersona {
    private String nombre;
    private String apellido;
    private String contrasenia;

    public DtPersona() {}

    public DtPersona(String nombre, String apellido, String contrasenia) {
        // esta clase es abstracta, eso se define arriba al hacer 'public abstract class...'
        // aca se setean los valores recibidos
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

    public String getContrasenia() {
        return contrasenia;
    }

    @Override
    public String toString() {
        return "DtPersona{" + "nombre=" + nombre + ", apellido=" + apellido + ", contrasenia=" + contrasenia + '}';
    }
    
}
