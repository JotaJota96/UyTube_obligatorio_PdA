
package logica.controladores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtRegistroHistorial complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtRegistroHistorial">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idVideo" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="ultimaVez" type="{http://Controladores.Logica/}fecha" minOccurs="0"/>
 *         &lt;element name="cantVisitas" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtRegistroHistorial", propOrder = {
    "id",
    "idVideo",
    "ultimaVez",
    "cantVisitas"
})
public class DtRegistroHistorial {

    protected int id;
    protected int idVideo;
    protected Fecha ultimaVez;
    protected int cantVisitas;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad idVideo.
     * 
     */
    public int getIdVideo() {
        return idVideo;
    }

    /**
     * Define el valor de la propiedad idVideo.
     * 
     */
    public void setIdVideo(int value) {
        this.idVideo = value;
    }

    /**
     * Obtiene el valor de la propiedad ultimaVez.
     * 
     * @return
     *     possible object is
     *     {@link Fecha }
     *     
     */
    public Fecha getUltimaVez() {
        return ultimaVez;
    }

    /**
     * Define el valor de la propiedad ultimaVez.
     * 
     * @param value
     *     allowed object is
     *     {@link Fecha }
     *     
     */
    public void setUltimaVez(Fecha value) {
        this.ultimaVez = value;
    }

    /**
     * Obtiene el valor de la propiedad cantVisitas.
     * 
     */
    public int getCantVisitas() {
        return cantVisitas;
    }

    /**
     * Define el valor de la propiedad cantVisitas.
     * 
     */
    public void setCantVisitas(int value) {
        this.cantVisitas = value;
    }

}
