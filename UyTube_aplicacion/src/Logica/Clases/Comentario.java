package Logica.Clases;

import Logica.DataType.DtComentario;
import java.sql.Date;

public class Comentario {
    private int id;
    private Date fecha;
    private String texto;
    private int nivelSubComentario;
    private Usuario usr;

    public Comentario() {
    }
    
    public Comentario(int id, Date fecha, String texto, int nivelSubComentario, Usuario usr) {
        this.id = id;
        this.fecha = fecha;
        this.texto = texto;
        this.nivelSubComentario = nivelSubComentario;
        this.usr = usr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public int getNivelSubComentario() {
        return nivelSubComentario;
    }

    public void setNivelSubComentario(int nivelSubComentario) {
        this.nivelSubComentario = nivelSubComentario;
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }/*
    public boolean agregarSubComentario(int x, DtComentario dtC, Usuario usr){
        
    }
    public DtComentario getDT(){
        DtComentario dtC = new DtComentario(this.id, usr.getNickname, this.fecha, this.texto, this.nivelSubComentario);
        return dtC;
    }
    public boolean agregarSubComentario(int x, DtComentario dtC, Usuario usr){
        
    }
    */
    
    
}
