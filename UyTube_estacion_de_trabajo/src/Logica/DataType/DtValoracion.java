package Logica.DataType;

import Logica.Enumerados.TipoValoracion;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
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

    @Override
    public String toString() {
        return "DtValoracion{" + "val=" + val + ", nickname=" + nickname + '}';
    }
    
}
