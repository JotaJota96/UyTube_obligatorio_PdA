package Logica.Clases;

import Logica.DataType.DtComentario;
import java.sql.Date;
import java.util.ArrayList;

public class Comentario {
    private static int contadorComentarios = 1;
    
    private int id;
    private Date fecha;
    private String texto;
    private int nivelSubComentario;
    private Usuario usr;
    private ArrayList<Comentario> misComentario;

    public Comentario() {
    }
    
    public Comentario(int id, Date fecha, String texto, int nivelSubComentario, Usuario usr) {
        this.id = id;
        this.fecha = fecha;
        this.texto = texto;
        this.nivelSubComentario = nivelSubComentario;
        this.usr = usr;
        this.misComentario = new ArrayList();
    }

    public static int getNuevoID(){
        return contadorComentarios++;
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
    }
    
    
    public boolean agregarSubComentario(int idComPadre, DtComentario dtC, Usuario usr){
        return true;
    }
    
    public DtComentario getDT(){
        DtComentario dtC = new DtComentario(this.id, this.usr.getNickname(), this.fecha, this.texto, this.nivelSubComentario);
        return dtC;
    }
    
    public ArrayList<DtComentario> listarSubComentarios(){
        ArrayList lsc = new ArrayList();
        for(int i = 0; i< lsc.size();i++){
            lsc.add(this.misComentario.get(i).getDT());
            lsc.addAll(this.misComentario.get(i).listarSubComentarios());
        }
        return new ArrayList();
    }
      
}
