
package logica.controladores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtListaDeReproduccion complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtListaDeReproduccion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="privacidad" type="{http://Controladores.Logica/}privacidad" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://Controladores.Logica/}tipoListaDeReproduccion" minOccurs="0"/>
 *         &lt;element name="categoria" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
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
@XmlType(name = "dtListaDeReproduccion", propOrder = {
    "id",
    "nombre",
    "privacidad",
    "tipo",
    "categoria",
    "nombreDuenio"
})
@XmlSeeAlso({
    DtListaDeReproduccionHistorial.class
})
public class DtListaDeReproduccion {

    protected int id;
    protected String nombre;
    @XmlSchemaType(name = "string")
    protected Privacidad privacidad;
    @XmlSchemaType(name = "string")
    protected TipoListaDeReproduccion tipo;
    protected String categoria;
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
     * Obtiene el valor de la propiedad tipo.
     * 
     * @return
     *     possible object is
     *     {@link TipoListaDeReproduccion }
     *     
     */
    public TipoListaDeReproduccion getTipo() {
        return tipo;
    }

    /**
     * Define el valor de la propiedad tipo.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoListaDeReproduccion }
     *     
     */
    public void setTipo(TipoListaDeReproduccion value) {
        this.tipo = value;
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
