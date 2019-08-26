package Logica.DataType;

import java.sql.Date;

public class DtComentario {
    private int id;
    private String nickname;
    private  Date fecha;
    private String texto;
    private int nivelSubComentario;

    public DtComentario(int id, String nickname, Date fecha, String texto, int nivelSubComentario) {
        this.id = id;
        this.nickname = nickname;
        this.fecha = fecha;
        this.texto = texto;
        this.nivelSubComentario = nivelSubComentario;
    }

    public int getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
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

    @Override
    public String toString() {
        return "DtComentario{" + "id=" + id + ", nickname=" + nickname + ", fecha=" + fecha + ", texto=" + texto + ", nivelSubComentario=" + nivelSubComentario + '}';
    }
    
    
}
