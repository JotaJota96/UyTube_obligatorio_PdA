package Logica.Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador extends Persona implements Serializable{
    private static int contadorAdministrador = 1;
    
    @Id
    private int id;
    
    //-------------------------------------------------------------------------

    public Administrador() {
        super();
    }
    
    public Administrador(int id, String contrasenia, String nombre, String apellido){
        super(nombre,apellido,contrasenia);
        this.id = id;
    }
    
    public static int getNuevoID(){
        return contadorAdministrador++;
    }

    public int getIdAdmin() {
        return id;
    }
    
}
