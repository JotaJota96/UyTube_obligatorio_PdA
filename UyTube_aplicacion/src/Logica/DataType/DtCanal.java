
package Logica.DataType;
import Logica.Enumerados.*;
        
public class DtCanal {
    int id;
    String nombre;
    String descripcion;
    Privacidad privacidad;

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
    
}
