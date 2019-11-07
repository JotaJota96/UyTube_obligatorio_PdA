
package logica.controladores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoValoracion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoValoracion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="LIKE"/>
 *     &lt;enumeration value="DISLIKE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoValoracion")
@XmlEnum
public enum TipoValoracion {

    LIKE,
    DISLIKE;

    public String value() {
        return name();
    }

    public static TipoValoracion fromValue(String v) {
        return valueOf(v);
    }

}
