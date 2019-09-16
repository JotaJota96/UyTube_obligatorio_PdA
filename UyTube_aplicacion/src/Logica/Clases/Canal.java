package Logica.Clases;

import Logica.Enumerados.Privacidad;
import Logica.DataType.DtComentario;
import Logica.DataType.DtListaDeReproduccion;
import Logica.DataType.DtValoracion;
import Logica.DataType.DtVideo;
import Logica.DataType.DtCanal;
import Logica.Enumerados.TipoListaDeReproduccion;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "canal")
public class Canal {
    private static int contadorCanal = 1;
    
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "descripcion")
    private String descripcion;
    
    @Enumerated(EnumType.STRING)
    @Column(name = "privacidad")
    private Privacidad privacidad;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_canal")
    private Map<Integer, ListaDeReproduccion> misListas;
    
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_canal")
    private Map<Integer, Video> misVideos;

    //-------------------------------------------------------------------------------------
    public Canal() {
    }

    public Canal(int id, String nombre, String descripcion, Privacidad privacidad, ArrayList<String> listas) {
        if (nombre.equals("")){
            throw new RuntimeException("El nombre del canal no puede ser vacio");
        }
        
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.privacidad = privacidad;
        this.misListas = new TreeMap();
        this.misVideos = new TreeMap();
        this.actualizarListasPorDefecto(listas);
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

    public Privacidad getPrivacidad() {
        return privacidad;
    }

    public void setNombre(String nombre) {
         if (nombre.equals("")) {
            throw new RuntimeException("El nombre del canal no puede ser vacio");
        }
        this.nombre = nombre;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setPrivacidad(Privacidad privacidad) {
        // Si el canal es publico y se va a cambiar a privado, se deben cambiar a privado todos los videos del canal
        if (privacidad == Privacidad.PRIVADO){
            for (Map.Entry<Integer, Video> m : misVideos.entrySet()) {
                m.getValue().setPrivacidad(Privacidad.PRIVADO);
            }
            for (Map.Entry<Integer, ListaDeReproduccion> m : misListas.entrySet()) {
                m.getValue().setPrivacidad(Privacidad.PRIVADO);
            }
        }
        this.privacidad = privacidad;
    }

    public static int getNuevoId() {
        return contadorCanal++;
    }

    //-----------------------------------------------------------------------------
    public void actualizarListasPorDefecto(ArrayList<String> listas) {
        // descarta las listas que ya estan agregadas
        for (Map.Entry<Integer, ListaDeReproduccion> l : misListas.entrySet()) {
            if (l.getValue().getTipo() == TipoListaDeReproduccion.POR_DEFECTO) {
                listas.remove(l.getValue().getNombre());
            }
        }
        // agrega las que pasaron el filtro anterior
        for (String lista : listas) {
            int nuevoID = ListaDeReproduccion.getNuevoId();
            this.misListas.put(nuevoID, new ListaDeReproduccion(nuevoID, lista, Privacidad.PRIVADO, TipoListaDeReproduccion.POR_DEFECTO, "UNDEFINED"));
        }
    }

    public void agregarComentarioAVideo(int id, DtComentario comentario, Usuario usuario) {
        if (this.misVideos.containsKey(id)) {
            this.misVideos.get(id).agregarComentario(comentario, usuario);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

    public void agregarComentarioAVideo(int id, int idComentario, DtComentario comentario, Usuario usuario) {
        if (this.misVideos.containsKey(id)) {
            this.misVideos.get(id).agregarComentario(idComentario, comentario, usuario);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

    public void agregarListaParticular(DtListaDeReproduccion listaReproduccion) {
        int idLdr = ListaDeReproduccion.getNuevoId();
        if (listaReproduccion == null){
            throw new RuntimeException("La lista de reprodccion es null");
        }
        if (listaReproduccion.getNombre().equals("")){
            throw new RuntimeException("El nombre no puede ser vacio");
        }
        if (this.privacidad == Privacidad.PRIVADO && listaReproduccion.getPrivacidad() == Privacidad.PUBLICO){
            throw new RuntimeException("No se puede agregar una lista de reproduccion publica a un canal privado");
        }
        if (listaReproduccion.getCategoria().equals("")){
            throw new RuntimeException("La categoria no puede ser vacia");
        }
        
         // un canal no puede tener dos videos con el mismo nomre
         for (Map.Entry<Integer, ListaDeReproduccion> v : misListas.entrySet()){
             if (v.getValue().getNombre().equals(listaReproduccion.getNombre())){
                 throw new RuntimeException("El canal ya posee una lista de reproduccion con ese nombre");
             }
         }
         
        ListaDeReproduccion ldr = new ListaDeReproduccion(
                idLdr, 
                listaReproduccion.getNombre(), 
                listaReproduccion.getPrivacidad(), 
                listaReproduccion.getTipo(), 
                listaReproduccion.getCategoria());
        this.misListas.put(idLdr, ldr);
    }

    public void quitarValoracion(int idVideo, String nickname) {
        if (this.misVideos.containsKey(idVideo)) {
            this.misVideos.get(idVideo).quitarValoracion(nickname);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
        
    }

    public void agregarModificarValoracion(int id, DtValoracion valoracion, Usuario usuario) {
        if (this.misVideos.containsKey(id)) {
            this.misVideos.get(id).agregarModificarValoracion(valoracion, usuario);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
        
    }

    public void agregarVideo(DtVideo video) {
        if(video== null){
            throw new RuntimeException("El Datatype del video es null");
        }
        if (video.getNombre().equals("")){
            throw new RuntimeException("El nombre no puede ser vacio");
        }
        if(video.getDuracion() == null){
            throw new RuntimeException("La duracion no puede ser null");
        }
        if(video.getFechaPublicacion() == null){
            throw new RuntimeException("La fecha de publicion no puede ser null");
        }
         if (video.getUrlVideoOriginal().equals("")){
            throw new RuntimeException("La direccion URL no puede ser vacia");
        }
         if (video.getCategoria().equals("")){
            throw new RuntimeException("La categoría no puede ser vacía");
        }
        
         // un canal no puede tener dos videos con el mismo nomre
         for (Map.Entry<Integer, Video> v : misVideos.entrySet()){
             if (v.getValue().getNombre().equals(video.getNombre())){
                 throw new RuntimeException("El canal ya posee un video con ese nombre");
             }
         }
         
        int idVideo = Video.getNuevoId();
        Video vd = new Video(idVideo, 
                video.getNombre(), 
                video.getDescripcion(), 
                video.getDuracion(), 
                video.getFechaPublicacion(), 
                video.getUrlVideoOriginal(), 
                video.getCategoria());
        
        // si el canal es privado, el video debera serlo tambien
        // si el canal es publico, el video sera lo definido en el DataType
         if (this.privacidad == Privacidad.PRIVADO){
             vd.setPrivacidad(Privacidad.PRIVADO);
         }
        
        this.misVideos.put(idVideo, vd);
    }

    public void agregarVideoALista(int id, Video video) {
        if (this.misListas.containsKey(id)) {
            this.misListas.get(id).agregarVideoA(video);
        } else {
            throw new RuntimeException("La lista no pertenece al canal");
        }
    }

    public DtCanal getDT() {
        return new DtCanal(this.id, 
                this.nombre, 
                this.descripcion, 
                this.privacidad);
    }

    public ArrayList<DtComentario> listarComentariosDeVideo(int id) {
        if (this.misVideos.containsKey(id)) {
            return this.misVideos.get(id).listarComentarios();
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

    public ArrayList<DtListaDeReproduccion> listarListasDeReproduccion(boolean soloParticulares) {
        ArrayList<DtListaDeReproduccion> ret = new ArrayList();
        // porDefecto = false --> lista todas las listas
        // porDefecto = true --> lista solo las particulares
        for (Map.Entry<Integer, ListaDeReproduccion> m : misListas.entrySet()) {
            if(soloParticulares && m.getValue().getTipo()==TipoListaDeReproduccion.POR_DEFECTO){
                continue;
            }
            ret.add(m.getValue().getDt());
        }

        return ret;
    }

    public ArrayList<DtValoracion> listarValoracionesDeVideo(int id) {
        if (this.misVideos.containsKey(id)) {
            return this.misVideos.get(id).listarValoraciones();
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

    public ArrayList<DtVideo> listarVideos() {
        ArrayList<DtVideo> ret = new ArrayList();

        // para cada elemento en misVideos
        /**
         * este for no es normal, se declara la variable m que es de tipo
         * Entrada de Map (como un nodo arbol), y autmaticamente la hace avanzar
         * por todas las entradas de la coleccion. De la entrada actual se puede
         * obtener la Key y el Valor almacenado
         */
        for (Map.Entry<Integer, Video> m : misVideos.entrySet()) {
            // hace un getDT y lo agrega a la coleccion de retorno
            ret.add(m.getValue().getDt());
        }
        return ret;
    }

    public ArrayList<DtVideo> listarVideosDeListaDeReproduccion(int id) {
        if (this.misListas.containsKey(id)) {
            return this.misListas.get(id).listarVideos();
        } else {
            throw new RuntimeException("La lista de reproduccion no pertenece al canal");
        }
    }

    public void modificar(DtCanal canal) {
        if (canal.getNombre().equals("")) {
            throw new RuntimeException("El nombre no puede ser vacio");
        }
        
        // Si el canal es publico y se va a cambiar a privado, se deben cambiar a privado todos los videos del canal
        if (this.privacidad == Privacidad.PUBLICO && canal.getPrivacidad() == Privacidad.PRIVADO){
            this.setPrivacidad(canal.getPrivacidad());
        }
        
        this.nombre = canal.getNombre();
        this.descripcion = canal.getDescripcion();
        this.privacidad = canal.getPrivacidad();
    }

    public void modificarListaDeReproduccion(DtListaDeReproduccion ldr) {
        if (ldr == null) {
            throw new RuntimeException("El Datatype de la lista de reprodccion es null");
        }
        if (this.misListas.containsKey(ldr.getId())) {
            
            if (this.privacidad == Privacidad.PRIVADO && ldr.getPrivacidad() == Privacidad.PUBLICO){
                throw new RuntimeException("No se puede hacer publica una lista de reproduccion de un canal privado");
            }
            for (Map.Entry<Integer, ListaDeReproduccion> m : this.misListas.entrySet()){
                if (m.getKey() != ldr.getId()){
                    if (m.getValue().getNombre().equals(ldr.getNombre())) {
                        throw new RuntimeException("El canal ya posee una lista con ese nombre");
                    }
                }
            }
            
            this.misListas.get(ldr.getId()).modificar(ldr);
        } else {
            throw new RuntimeException("La lista de reproduccion no pertenece al canal");
        }
    }

    public void modificarVideo(DtVideo video) {
        if(video== null){
            throw new RuntimeException("El Datatype del video es null");
        }
        
        if (this.misVideos.containsKey(video.getId())) {
            
            if (this.privacidad == Privacidad.PRIVADO && video.getPrivacidad() == Privacidad.PUBLICO){
                throw new RuntimeException("No se puede hacer publico un video de un canal privado");
            }
            
            for (Map.Entry<Integer, Video> m : this.misVideos.entrySet()){
                if (m.getKey() != video.getId()){
                    if (m.getValue().getNombre().equals(video.getNombre())) {
                        throw new RuntimeException("El canal ya posee una lista con ese nombre");
                    }
                }
            }
            
            this.misVideos.get(video.getId()).modificar(video);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }
    
    public DtListaDeReproduccion obtenerListaDeReproduccion(int id){
        ListaDeReproduccion ldr = misListas.get(id);
        if (ldr == null){
            throw new RuntimeException("La lista de reproduccion no pertenece al canal");
        }else{
            return ldr.getDt();
        }
    }
    
    public ArrayList<DtListaDeReproduccion> obtenerListasEnCategoria(String cat) {
        ArrayList<DtListaDeReproduccion> ret = new ArrayList();

        // para cada elemento en misVideos
        /**
         * este for no es normal, se declara la variable m que es de tipo
         * Entrada de Map (como un nodo arbol), y autmaticamente la hace avanzar
         * por todas las entradas de la coleccion. De la entrada actual se puede
         * obtener la Key y el Valor almacenado
         */
        for (Map.Entry<Integer, ListaDeReproduccion> m : misListas.entrySet()) {
            // hace un getDT y lo agrega a la coleccion de retorno
            if (m.getValue().getCategoria().equals(cat)) {
                ret.add(m.getValue().getDt());
            }
        }
        
        return ret;
    }

    public DtVideo obtenerDtVideo(int id) {
        if (this.misVideos.containsKey(id)) {
            return this.misVideos.get(id).getDt();
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

    public Video obtenerVideo(int id) {
        if (this.misVideos.containsKey(id)) {
            return this.misVideos.get(id);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

    public ArrayList<DtVideo> obtenerVideosEnCategoria(String cat) {
        ArrayList<DtVideo> ret = new ArrayList();

        // para cada elemento en misVideos
        /**
         * este for no es normal, se declara la variable m que es de tipo
         * Entrada de Map (como un nodo arbol), y autmaticamente la hace avanzar
         * por todas las entradas de la coleccion. De la entrada actual se puede
         * obtener la Key y el Valor almacenado
         */
        for (Map.Entry<Integer, Video> m : misVideos.entrySet()) {
            // hace un getDT y lo agrega a la coleccion de retorno
            if (m.getValue().getCategoria().equals(cat)) {
                ret.add(m.getValue().getDt());
            }
        }
        
        return ret;
    }

    public void quitarVideoDeListaDeReproduccion(int idLista, int idVideo) {
        if (this.misListas.containsKey(idLista)) {
            this.misListas.get(idLista).quitarVideo(idVideo);
        } else {
            throw new RuntimeException("La lista de reproduccion no pertenece al canal");
        }
    }

    public boolean validarListaParticular(String nombreLista) {
        for (Map.Entry<Integer, ListaDeReproduccion> l : misListas.entrySet()) {
            if (l.getValue().getTipo() == TipoListaDeReproduccion.PARTICULAR && l.getValue().getNombre().equals(nombreLista)) {
                return false;
            }
        }
        return true;
    }

    public DtValoracion obtenerValoracion(int id, String nickname) {
        if (this.misVideos.containsKey(id)) {
            return this.misVideos.get(id).obtenerValoracion(nickname);
        } else {
            throw new RuntimeException("El video no pertenece al canal");
        }
    }

}
