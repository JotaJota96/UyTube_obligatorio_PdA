package Logica.Clases;

public class Categoria {
    private String nombre;

    public Categoria(String nombre) {
        if (nombre.equals("")){
            throw new RuntimeException("El nombre de la categoria no puede ser vacio");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}
