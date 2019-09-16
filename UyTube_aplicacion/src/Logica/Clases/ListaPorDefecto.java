package Logica.Clases;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "lista_por_defecto")
public class ListaPorDefecto {

    @Id
    @Column(name = "nombre")
    private String nombre;

    //----------------------------------------------------------------------
    public ListaPorDefecto() {
    }

    public ListaPorDefecto(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

}
