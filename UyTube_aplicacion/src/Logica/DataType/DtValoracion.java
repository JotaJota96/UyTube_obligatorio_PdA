package Logica.DataType;

import Logica.Enumerados.TipoValoracion;


public class DtValoracion {
    private TipoValoracion val;
    private String nickname;

    public DtValoracion(TipoValoracion val, String nickname) {
        this.val = val;
        this.nickname = nickname;
    }
    public String getNickname() {
        return nickname;
    }
    public TipoValoracion getVal() {
        return val;
    }
}
