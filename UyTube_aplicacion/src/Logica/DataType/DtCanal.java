package Logica.DataType;

public class DtCanal {
    int id;
    String nombre;
    String descripcion;
    //privacidad privacidad;

    public DtCanal() {}
    
    public DtCanal(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }
     
    
    
    
}
