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

    public Comentario(int id, Date fecha, String texto, int nivelSubComentario, Usuario usr) {
        if(usr==null){
            throw new RuntimeException("Usuario No puede ser null");
        }
        if(fecha==null){
            throw new RuntimeException("Date No puede ser null");
        }
        this.id = id;
        this.fecha = fecha;
        this.texto = texto;
        this.nivelSubComentario = nivelSubComentario;
        this.usr = usr;
        this.misComentario = new ArrayList();
    }

    public static int getNuevoID() {
        return contadorComentarios++;
    }

    public int getId() {
        return id;
    }

    public Date getFecha() {
        return fecha;
    }
    public String getTexto() {
        return texto;
    }
    public int getNivelSubComentario() {
        return nivelSubComentario;
    }

    public Usuario getUsr() {
        return usr;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", fecha=" + fecha + ", texto=" + texto + ", nivelSubComentario=" + nivelSubComentario + '}';
    }

    public boolean agregarSubComentario(int idComPadre, DtComentario dtC, Usuario usr) {
        if(dtC==null){
            throw new RuntimeException("DtComentario No puede ser null");
        }
        if(usr==null){
            throw new RuntimeException("Usuario No puede ser null");
        }
        if (this.id == idComPadre) {
            Comentario com = new Comentario(Comentario.getNuevoID(),
                    dtC.getFecha(),
                    dtC.getTexto(),
                    this.nivelSubComentario + 1,
                    usr);
            this.misComentario.add(com);
            return true;
        } else {

            for (int i = 0; i < misComentario.size(); i++) {
                if (this.misComentario.get(i).agregarSubComentario(idComPadre, dtC, usr)) {
                    return true;
                }
            }
            return false;
        }
    }

    public DtComentario getDT() {
        DtComentario dtC = new DtComentario(this.id, this.usr.getNickname(), this.fecha, this.texto, this.nivelSubComentario);
        return dtC;
    }

    public ArrayList<DtComentario> listarSubComentarios() {
        ArrayList lsc = new ArrayList();

        for (int i = 0; i < this.misComentario.size(); i++) {
            lsc.add(this.misComentario.get(i).getDT());
            lsc.addAll(this.misComentario.get(i).listarSubComentarios());
        }
        return lsc;
    }
}