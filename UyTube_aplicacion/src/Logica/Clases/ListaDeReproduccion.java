package Logica.Clases;

import Logica.DataType.DtListaDeReproduccion;
import Logica.Enumerados.Privacidad;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ListaDeReproduccion {
    private static int contadorListasDeReproduccion = 1;
    
    private int id;
    private String nombre;
    private Privacidad privacidad;
    private TipoListaDeReproduccion tipo;
    private String categoria;
    private Map<Integer, Video> misVideos;

    public ListaDeReproduccion() {
        this.id = getNuevoId();
        this.misVideos = new TreeMap();
    }
    
    public ListaDeReproduccion(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        this.id = id;
        this.nombre = nombre;
        this.privacidad = privacidad;
        this.tipo = tipo;
        this.categoria = categoria;
        this.misVideos = new TreeMap();
    }

    public static int getNuevoId(){
        return contadorListasDeReproduccion++;
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
    
    
    public void agregarVideoA(Video v){
        
    }
    
    public DtListaDeReproduccion getDt(){
        return new DtListaDeReproduccion(this.id, this.nombre, this.privacidad, this.tipo, this.categoria);
    }

    public ArrayList listarVideos(){
        return new ArrayList();
    }
    
    public void modificar(DtListaDeReproduccion ldr) {

    }

    public void quitarVideo(int idVideo) {

    }
}
