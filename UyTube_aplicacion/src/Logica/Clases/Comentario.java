package Logica.Clases;

import Logica.DataType.DtComentario;
import java.io.Serializable;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comentario")
public class Comentario implements Serializable {
    private static int contadorComentarios = 1;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Basic
    @Column(name = "fecha")
    private Date fecha;
    
    @Column(name = "texto")
    private String texto;
    
    @Column(name = "nivel")
    private int nivelSubComentario;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nick_usuario")
    private Usuario usr;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_com_padre")
    private List<Comentario> misComentario;
    
    //---------------------------------------------------------------------------
    public Comentario() {
    }

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
