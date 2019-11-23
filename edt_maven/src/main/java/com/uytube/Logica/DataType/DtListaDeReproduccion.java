package com.uytube.Logica.DataType;

import com.uytube.Logica.Enumerados.Privacidad;
import com.uytube.Logica.Enumerados.TipoListaDeReproduccion;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtListaDeReproduccion {
    protected int id;
    protected String nombre;
    protected Privacidad privacidad;
    protected TipoListaDeReproduccion tipo;
    protected String categoria;
    protected String nombreDuenio;
    
    public DtListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
    }

    public DtListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria, String nombreDuenio) {
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
        this.nombreDuenio = nombreDuenio;
    }

    public DtListaDeReproduccion() {
    }
    
    //*********************************************************************
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
