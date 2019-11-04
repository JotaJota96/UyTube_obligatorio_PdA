
package logica.controladores;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para tipoListaDeReproduccion.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoListaDeReproduccion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="POR_DEFECTO"/>
 *     &lt;enumeration value="PARTICULAR"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoListaDeReproduccion")
@XmlEnum
public enum TipoListaDeReproduccion {

    POR_DEFECTO,
    PARTICULAR;

    public String value() {
        return name();
    }

    public static TipoListaDeReproduccion fromValue(String v) {
        return valueOf(v);
    }

}
