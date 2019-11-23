package Logica.Clases;

import Logica.DataType.DtRegistroHistorial;
import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "registro_historial")
public class RegistroHistorial implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Basic
    @Column(name = "ultima_vez")
    private Date ultimaVez;
    
    @Column(name = "cant_visitas")
    private int cantVisitas;
    
    //-----------------------------------------------------------------------------
    public RegistroHistorial() {
        java.util.Date hoy = new java.util.Date();
        this.ultimaVez = new Date(hoy.getYear(), hoy.getMonth(), hoy.getDate());
        this.cantVisitas = 1;
    }
    
    public void actualizar(){
        java.util.Date hoy = new java.util.Date();
        this.ultimaVez = new Date(hoy.getYear(), hoy.getMonth(), hoy.getDate());
        this.cantVisitas++;
    }
    
    public Integer getId() {
        return id;
    }

    //-----------------------------------------------------------------------------
    public void setId(Integer id) {    
        this.id = id;
    }

    public Date getUltimaVez() {
        return ultimaVez;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }
    
    public DtRegistroHistorial getDt(int idVideo){
        return new DtRegistroHistorial(id, idVideo, ultimaVez, cantVisitas);
    }
}
