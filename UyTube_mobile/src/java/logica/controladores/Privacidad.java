
package logica.controladores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para privacidad.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="privacidad">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PUBLICO"/>
 *     &lt;enumeration value="PRIVADO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "privacidad")
@XmlEnum
public enum Privacidad {

    PUBLICO,
    PRIVADO;

    public String value() {
        return name();
    }

    public static Privacidad fromValue(String v) {
        return valueOf(v);
    }

}
