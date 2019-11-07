
package logica.controladores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para ordenacion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="ordenacion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="ALFABETICA_ASCENDENTE"/>
 *     &lt;enumeration value="FECHA_DESCENDENTE"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "ordenacion")
@XmlEnum
public enum Ordenacion {

    ALFABETICA_ASCENDENTE,
    FECHA_DESCENDENTE;

    public String value() {
        return name();
    }

    public static Ordenacion fromValue(String v) {
        return valueOf(v);
    }

}
