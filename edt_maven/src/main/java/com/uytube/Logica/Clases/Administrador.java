package com.uytube.Logica.Clases;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="administrador")
public class Administrador extends Persona implements Serializable{
    
    @Id
    // No logre hacer que el id fuera auto-incremental, no se por que, probe de todo y no pude
    //@GeneratedValue(strategy=GenerationType.IDENTITY)
    //@Column(name = "id")
    private Integer id;
    
    //-------------------------------------------------------------------------

    public Administrador() {
        super();
    }
    
    public Administrador(int id, String contrasenia, String nombre, String apellido){
        super(nombre,apellido,contrasenia);
        this.id = id;
    }
    
    public int getIdAdmin() {
        return id;
    }
    
}
