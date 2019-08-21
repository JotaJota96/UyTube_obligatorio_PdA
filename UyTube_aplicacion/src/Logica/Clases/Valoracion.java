package Logica.Clases;

import Logica.DataType.DtValoracion;
import Logica.Enumerados.TipoValoracion;

public class Valoracion {
    private TipoValoracion val;
    private Usuario usr;

    public Valoracion() {
    }
    
    public Valoracion(TipoValoracion val, Usuario usr) {
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

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }/*
    private DtValoracion getDT(){
        DtValoracion dtV = new DtValoracion(this.val, this.usr.getNickname());
        return dtV;
    }
    private DtValoracion getDT(String nickname){
        //faltan cosas-------------------------
        DtValoracion dtV = new DtValoracion();
        return dtV;
    }
    private boolean modificar(DtValoracion dtV, String nickname){
        bolean b;
        //faltan cosas-------------------------
        return b;
    }
    */
    
}
