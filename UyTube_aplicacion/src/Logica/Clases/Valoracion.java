package Logica.Clases;

import Logica.DataType.DtValoracion;
import Logica.Enumerados.TipoValoracion;

public class Valoracion {
    private TipoValoracion val;
    private Usuario usr;

    public Valoracion() {
    }
    
    public Valoracion(TipoValoracion val, Usuario usr) {
        if(usr==null){
            throw new RuntimeException("Usuario No puede ser null");
        }
        this.val = val;
        this.usr = usr;
    }

    public TipoValoracion getVal() {
        return val;
    }

    public void setVal(TipoValoracion val) {
        this.val = val;
    }

    public Usuario getUsr() {
        return usr;
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
