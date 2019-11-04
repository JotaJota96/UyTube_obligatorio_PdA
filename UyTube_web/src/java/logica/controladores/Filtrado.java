
package logica.controladores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para filtrado.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="filtrado">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CANALES"/>
 *     &lt;enumeration value="VIDEOS"/>
 *     &lt;enumeration value="LISTAS_DE_REPRODUCCION"/>
 *     &lt;enumeration value="TODO"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "filtrado")
@XmlEnum
public enum Filtrado {

    CANALES,
    VIDEOS,
    LISTAS_DE_REPRODUCCION,
    TODO;

    public String value() {
        return name();
    }

    public static Filtrado fromValue(String v) {
        return valueOf(v);
    }

}
