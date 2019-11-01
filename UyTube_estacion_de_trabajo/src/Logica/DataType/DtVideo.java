package Logica.DataType;

import java.sql.Time;
import java.sql.Date;
import Logica.Enumerados.Privacidad;

public class DtVideo {
    private int id;
    private String nombre;
    private String descripcion;
    private Time duracion;
    private Date fechaPublicacion;
    private String urlVideoOriginal;
    private Privacidad privacidad;
    private String categoria;
    private int cantLikes;
    private int cantDisLikes;
    private String nombreDuenio;

    public DtVideo(int id, String nombre, String descripcion, Time duracion, Date fechaPublicacion, String urlVideoOriginal, Privacidad privacidad, String categoria, int cantLikes, int cantDisLikes) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaPublicacion = fechaPublicacion;
        this.urlVideoOriginal = urlVideoOriginal;
        this.privacidad = privacidad;
        this.categoria = categoria;
        this.cantLikes = cantLikes;
        this.cantDisLikes = cantDisLikes;
    }

    public DtVideo(int id, String nombre, String descripcion, Time duracion, Date fechaPublicacion, String urlVideoOriginal, Privacidad privacidad, String categoria, int cantLikes, int cantDisLikes, String nombreDuenio) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.duracion = duracion;
        this.fechaPublicacion = fechaPublicacion;
        this.urlVideoOriginal = urlVideoOriginal;
        this.privacidad = privacidad;
        this.categoria = categoria;
        this.cantLikes = cantLikes;
        this.cantDisLikes = cantDisLikes;
        this.nombreDuenio = nombreDuenio;
    }
    
    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public Time getDuracion() {
        return duracion;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public String getUrlVideoOriginal() {
        return urlVideoOriginal;
    }

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public String getCategoria() {
        return categoria;
    }

    public int getCantLikes() {
        return cantLikes;
    }

    public int getCantDisLikes() {
        return cantDisLikes;
    }

    @Override
    public String toString() {
        return "DtVideo{" + "id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", duracion=" + duracion + ", fechaPublicacion=" + fechaPublicacion + ", urlVideoOriginal=" + urlVideoOriginal + ", privacidad=" + privacidad + ", categoria=" + categoria + ", cantLikes=" + cantLikes + ", cantDisLikes=" + cantDisLikes + '}';
    }
    
}
