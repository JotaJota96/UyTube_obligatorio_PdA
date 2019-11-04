
package logica.controladores;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtUsuario complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtUsuario">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Controladores.Logica/}dtPersona">
 *       &lt;sequence>
 *         &lt;element name="nickname" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="correo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="fechaNacimiento" type="{http://Controladores.Logica/}fecha" minOccurs="0"/>
 *         &lt;element name="fechaEliminado" type="{http://Controladores.Logica/}fecha" minOccurs="0"/>
 *         &lt;element name="imagen" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="cantSeguidores" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtUsuario", propOrder = {
    "nickname",
    "correo",
    "fechaNacimiento",
    "fechaEliminado",
    "imagen",
    "cantSeguidores"
})
public class DtUsuario
    extends DtPersona
{

    protected String nickname;
    protected String correo;
    protected Fecha fechaNacimiento;
    protected Fecha fechaEliminado;
    protected String imagen;
    protected int cantSeguidores;

    /**
     * Obtiene el valor de la propiedad nickname.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * Define el valor de la propiedad nickname.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickname(String value) {
        this.nickname = value;
    }

    /**
     * Obtiene el valor de la propiedad correo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Define el valor de la propiedad correo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCorreo(String value) {
        this.correo = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaNacimiento.
     * 
     * @return
     *     possible object is
     *     {@link Fecha }
     *     
     */
    public Fecha getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * Define el valor de la propiedad fechaNacimiento.
     * 
     * @param value
     *     allowed object is
     *     {@link Fecha }
     *     
     */
    public void setFechaNacimiento(Fecha value) {
        this.fechaNacimiento = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaEliminado.
     * 
     * @return
     *     possible object is
     *     {@link Fecha }
     *     
     */
    public Fecha getFechaEliminado() {
        return fechaEliminado;
    }

    /**
     * Define el valor de la propiedad fechaEliminado.
     * 
     * @param value
     *     allowed object is
     *     {@link Fecha }
     *     
     */
    public void setFechaEliminado(Fecha value) {
        this.fechaEliminado = value;
    }

    /**
     * Obtiene el valor de la propiedad imagen.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImagen() {
        return imagen;
    }

    /**
     * Define el valor de la propiedad imagen.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImagen(String value) {
        this.imagen = value;
    }

    /**
     * Obtiene el valor de la propiedad cantSeguidores.
     * 
     */
    public int getCantSeguidores() {
        return cantSeguidores;
    }

    /**
     * Define el valor de la propiedad cantSeguidores.
     * 
     */
    public void setCantSeguidores(int value) {
        this.cantSeguidores = value;
    }

}
