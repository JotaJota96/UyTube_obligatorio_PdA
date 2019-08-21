package Logica.DataType;

import Logica.Enumerados.Privacidad;

public class DtCanal {
    private int id;
    private String nombre;
    private String descripcion;
    private Privacidad privacidad;

    public DtCanal() {}
    
    public DtCanal(int id, String nombre, String descripcion,Privacidad privacidad) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.privacidad = privacidad;
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
    
    public Privacidad getPrivacidad() {
        return privacidad;
    }

    @Override
    public String toString() {
        return "DtCanal{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", privacidad=" + privacidad + '}';
    }
    
    
}
