package Logica.DataType;

import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;

public class DtListaDeReproduccion {
    private int id;
    private String nombre;
    private Privacidad privacidad;
    private TipoListaDeReproduccion tipo;
    private String categoria;

    public DtListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public TipoListaDeReproduccion getTipo() {
        return tipo;
    }

    public String getCategoria() {
        return categoria;
    }

    @Override
    public String toString() {
        return "DtListaDeReproduccion{" + "id=" + id + ", nombre=" + nombre + ", privacidad=" + privacidad + ", tipo=" + tipo + ", categoria=" + categoria + '}';
    }
    
}
