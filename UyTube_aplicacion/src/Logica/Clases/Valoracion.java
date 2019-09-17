package Logica.Clases;

import Logica.DataType.DtValoracion;
import Logica.Enumerados.TipoValoracion;
import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "valoracion")
public class Valoracion implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Enumerated(EnumType.STRING)
    @JoinColumn(name = "valoracion")
    private TipoValoracion val;
    
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "nick_usuario")
    private Usuario usr;
    
    //-----------------------------------------------------------------------
    public Valoracion() {
    }

    public Valoracion(TipoValoracion val, Usuario usr) {
        if(usr==null){
            throw new RuntimeException("Usuario No puede ser null");
        }
        this.val = val;
        this.usr = usr;
    }

    //-----------------------------------------------------------------------
    public int getId() {
        return id;
    }

    public TipoValoracion getVal() {
        return val;
    }

    public void setVal(TipoValoracion val) {
        this.val = val;
    }

    public String getNicknameDeUsuario() {
        return this.usr.getNickname();
    }
    
    public DtValoracion getDT(){
        DtValoracion dtV = new DtValoracion(this.val, this.usr.getNickname());
        return dtV;
    }
    public DtValoracion getDT(String nickname){
        if(nickname==null){
            throw new RuntimeException("Nickname No puede ser null");
        }
        // si esta valoracion corresponde al usuario, devuelve su DT, sino null
        if (nickname.equals(this.usr.getNickname())){
            return this.getDT();
        }else{
            return null;
        }
    }
    public boolean modificar(DtValoracion dtV, String nickname){
        if(dtV==null){
            throw new RuntimeException("DtValoracion No puede ser null");
        }
        if(nickname==null){
            throw new RuntimeException("Nickname No puede ser null");
        }
        if (nickname.equals(this.usr.getNickname())){
            this.val = dtV.getVal();
            return true;
        }else{
            return false;
        }
    }
    
    
}
