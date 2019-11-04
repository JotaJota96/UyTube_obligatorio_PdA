
package logica.controladores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtVideo complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtVideo">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="descripcion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duracion" type="{http://Controladores.Logica/}duracion" minOccurs="0"/>
 *         &lt;element name="fechaPublicacion" type="{http://Controladores.Logica/}fecha" minOccurs="0"/>
 *         &lt;element name="urlVideoOriginal" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="privacidad" type="{http://Controladores.Logica/}privacidad" minOccurs="0"/>
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantLikes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="cantDisLikes" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombreDuenio" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtVideo", propOrder = {
    "id",
    "nombre",
    "descripcion",
    "duracion",
    "fechaPublicacion",
    "urlVideoOriginal",
    "privacidad",
    "categoria",
    "cantLikes",
    "cantDisLikes",
    "nombreDuenio"
})
public class DtVideo {

    protected int id;
    protected String nombre;
    protected String descripcion;
    protected Duracion duracion;
    protected Fecha fechaPublicacion;
    protected String urlVideoOriginal;
    @XmlSchemaType(name = "string")
    protected Privacidad privacidad;
    protected String categoria;
    protected int cantLikes;
    protected int cantDisLikes;
    protected String nombreDuenio;

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
     * Obtiene el valor de la propiedad nombre.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad descripcion.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Define el valor de la propiedad descripcion.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescripcion(String value) {
        this.descripcion = value;
    }

    /**
     * Obtiene el valor de la propiedad duracion.
     * 
     * @return
     *     possible object is
     *     {@link Duracion }
     *     
     */
    public Duracion getDuracion() {
        return duracion;
    }

    /**
     * Define el valor de la propiedad duracion.
     * 
     * @param value
     *     allowed object is
     *     {@link Duracion }
     *     
     */
    public void setDuracion(Duracion value) {
        this.duracion = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaPublicacion.
     * 
     * @return
     *     possible object is
     *     {@link Fecha }
     *     
     */
    public Fecha getFechaPublicacion() {
        return fechaPublicacion;
    }

    /**
     * Define el valor de la propiedad fechaPublicacion.
     * 
     * @param value
     *     allowed object is
     *     {@link Fecha }
     *     
     */
    public void setFechaPublicacion(Fecha value) {
        this.fechaPublicacion = value;
    }

    /**
     * Obtiene el valor de la propiedad urlVideoOriginal.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUrlVideoOriginal() {
        return urlVideoOriginal;
    }

    /**
     * Define el valor de la propiedad urlVideoOriginal.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUrlVideoOriginal(String value) {
        this.urlVideoOriginal = value;
    }

    /**
     * Obtiene el valor de la propiedad privacidad.
     * 
     * @return
     *     possible object is
     *     {@link Privacidad }
     *     
     */
    public Privacidad getPrivacidad() {
        return privacidad;
    }

    /**
     * Define el valor de la propiedad privacidad.
     * 
     * @param value
     *     allowed object is
     *     {@link Privacidad }
     *     
     */
    public void setPrivacidad(Privacidad value) {
        this.privacidad = value;
    }

    /**
     * Obtiene el valor de la propiedad categoria.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Define el valor de la propiedad categoria.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCategoria(String value) {
        this.categoria = value;
    }

    /**
     * Obtiene el valor de la propiedad cantLikes.
     * 
     */
    public int getCantLikes() {
        return cantLikes;
    }

    /**
     * Define el valor de la propiedad cantLikes.
     * 
     */
    public void setCantLikes(int value) {
        this.cantLikes = value;
    }

    /**
     * Obtiene el valor de la propiedad cantDisLikes.
     * 
     */
    public int getCantDisLikes() {
        return cantDisLikes;
    }

    /**
     * Define el valor de la propiedad cantDisLikes.
     * 
     */
    public void setCantDisLikes(int value) {
        this.cantDisLikes = value;
    }

    /**
     * Obtiene el valor de la propiedad nombreDuenio.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombreDuenio() {
        return nombreDuenio;
    }

    /**
     * Define el valor de la propiedad nombreDuenio.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombreDuenio(String value) {
        this.nombreDuenio = value;
    }

}
