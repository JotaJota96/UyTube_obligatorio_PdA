package com.uytube.Logica.Clases;

import com.uytube.JPAControllerClasses.RegistroHistorialJpaController;
import com.uytube.Logica.DataType.DtListaDeReproduccion;
import com.uytube.Logica.DataType.DtListaDeReproduccionHistorial;
import com.uytube.Logica.DataType.DtRegistroHistorial;
import com.uytube.Logica.DataType.DtVideo;
import com.uytube.Logica.Enumerados.Privacidad;
import com.uytube.Logica.Enumerados.TipoListaDeReproduccion;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "lista_de_reproduccion_historial")
public class ListaDeReproduccionHistorial extends ListaDeReproduccion implements Serializable{
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_lista")
    // almacena el par IDvideo y el registro (contador de visualizaciones y fecha de ultima visita)
    private Map<Integer, RegistroHistorial> registros;

    //-----------------------------------------------------------------------------
    public ListaDeReproduccionHistorial() {
    }

    public ListaDeReproduccionHistorial(int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria) {
        super(id, nombre, privacidad, tipo, categoria);
        this.registros = new TreeMap();
    }
    
    //-----------------------------------------------------------------------------
    @Override
    public void agregarVideoA(Video v) {
        if (v == null) {
            throw new RuntimeException("El video recibido para agregar al historial es NULL");
        }
        int idVideo = v.getId();
        if (this.registros.containsKey(idVideo)) {
            this.registros.get(idVideo).actualizar();
            try {
                new RegistroHistorialJpaController().edit(this.registros.get(idVideo));
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        } else {
            RegistroHistorial nuevoRegistro = new RegistroHistorial();
            this.registros.put(idVideo, nuevoRegistro);
            try {
                new RegistroHistorialJpaController().create(nuevoRegistro);
            } catch (Exception e) {
                throw new RuntimeException(e.getMessage());
            }
        }
        super.agregarVideoA(v);
    }
    
    @Override
    public void eliminar() {
        super.eliminar();
    }

    public DtListaDeReproduccionHistorial getDt() {
        ArrayList<DtRegistroHistorial> registrosOrdenados = new ArrayList();
        // obtengo los ID de los videos pero ordenados segun cantidad de visualizaciones
        ArrayList<Integer> orden = obtenerOrdenDeVideos();
        // recorro el ArrayList obteniendo para cada video su DataType
        for (int i : orden){
            registrosOrdenados.add(registros.get(i).getDt(i));
        }
        // public DtListaDeReproduccionHistorial(ArrayList<DtRegistroHistorial> registros, int id, String nombre, Privacidad privacidad, TipoListaDeReproduccion tipo, String categoria, String nombreDuenio) {
        return new DtListaDeReproduccionHistorial(
                registrosOrdenados, 
                this.id, 
                this.nombre, 
                this.privacidad,
                this.tipo, 
                this.categoria
        );
    }
    
    @Override
    public void modificar(DtListaDeReproduccion ldr) {
        super.modificar(ldr);
    }
    
    @Override
    public ArrayList<DtVideo> listarVideos() {
        ArrayList<DtVideo> ret = new ArrayList();
        // obtengo los ID de los videos pero ordenados segun cantidad de visualizaciones
        ArrayList<Integer> orden = obtenerOrdenDeVideos();
        // recorro el ArrayList obteniendo para cada video su DataType
        for (int i : orden){
            ret.add(misVideos.get(i).getDt());
        }
        return ret;
    }
    
    @Override
    public void quitarVideo(int idVideo) {
        super.quitarVideo(idVideo);
        this.registros.remove(idVideo);
        try {
            new RegistroHistorialJpaController().destroy(idVideo);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
    
    private ArrayList<Integer> obtenerOrdenDeVideos(){
        /** Idea de solucion:
         * Creo el Map maxAux que es una copia del Map de registros (para poder ir eliminando y facilitar las recorridas)
         * Creo un de retorno ret para guardar en orden los IDs de los videos
         * Recorro mapAux buscando el video con mas reproducciones
         *     Al encontrarlo, almacenar su ID en ret y quitar el elemento del mapAux
         * Retorna ret
         * (El algoritmo no contempla empate de cantidad de visualizaciones
         */
        ArrayList<Integer> ret = new ArrayList();
        Map<Integer, RegistroHistorial> mapAux = new TreeMap(registros);

        // mientras hayan elementos hay que ordenar
        while (!mapAux.isEmpty()) {
            int max = 0; // referencia de cantidad de visualizaciones de un video (para cada iteracion del while)
            int idVideoBorrar = 0; // ID del video con mas visualizaciones (para cada iteracion del while)
            // salgo a buscar el video con mas visitas
            for (Map.Entry<Integer, RegistroHistorial> it : mapAux.entrySet()) {
                // si encuentra un candidato, actualiza las variables
                if (it.getValue().getCantVisitas() > max) {
                    max = it.getValue().getCantVisitas();
                    idVideoBorrar = it.getKey();
                }
            }
            mapAux.remove(idVideoBorrar);
            ret.add(idVideoBorrar);
        }
        return ret;
    }

}
