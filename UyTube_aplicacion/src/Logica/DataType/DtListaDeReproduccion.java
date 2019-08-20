package Logica.DataType;

import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;

public class DtListaDeReproduccion {
    private int id;
    private String nombre;
    private Privacidad privacidad;
    private TipoListaDeReproduccion tipo;
    private String categoria;

    public DtListaDeReproduccion() {}

    public DtListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPrivacidad(Privacidad privacidad) {
        this.privacidad = privacidad;
    }

    public void setTipo(TipoListaDeReproduccion tipo) {
        this.tipo = tipo;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
