package Logica.DataType;

public class DtCategoria {
    private String nombre;

    public DtCategoria() {}

    public DtCategoria(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "DtCategoria{" + "nombre=" + nombre + '}';
    }
    
    
}
