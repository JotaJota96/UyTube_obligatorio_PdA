package Logica.Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Id
    @Column(name = "nombre")
    private String nombre;

    //---------------------------------------------------------------------------
    public Categoria() {
    }

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
