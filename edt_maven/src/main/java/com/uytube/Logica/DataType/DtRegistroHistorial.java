package com.uytube.Logica.DataType;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtRegistroHistorial {
    
    private int id;
    private int idVideo;
    private Fecha ultimaVez;
    private int cantVisitas;

    //-----------------------------------------------------------------------------------
    public DtRegistroHistorial() {
    }

    public DtRegistroHistorial(int id, int idVideo, Date ultimaVez, int cantVisitas) {
        this.id = id;
        this.idVideo = idVideo;
        if (ultimaVez != null){
            this.ultimaVez = new Fecha(ultimaVez);
        }
        this.cantVisitas = cantVisitas;
    }
    
    //---------- Getters ----------------------------------------------------------------
    public int getId() {
        return id;
    }

    public int getIdVideo() {
        return idVideo;
    }

    public Date getUltimaVez() {
        if (ultimaVez == null) return null;
        return ultimaVez.toSqlDate();
    }

    public int getCantVisitas() {
        return cantVisitas;
    }
    
}
