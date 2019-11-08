package Logica.DataType;

import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaDeReproduccionHistorial extends DtListaDeReproduccion {

    ArrayList<DtRegistroHistorial> registros;

    //*********************************************************************
    public DtListaDeReproduccionHistorial() {
        super();
    }
    
    public DtListaDeReproduccionHistorial(ArrayList<DtRegistroHistorial> registros, int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        super(id, nombre, privacidad, tipo, categoria);
        this.registros = registros;
    }

    //*********************************************************************
    public ArrayList<DtRegistroHistorial> getRegistros() {
        return registros;
    }

}
