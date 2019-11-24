
package logica.controladores;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtListaDeReproduccionHistorial complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtListaDeReproduccionHistorial">
 *   &lt;complexContent>
 *     &lt;extension base="{http://Controladores.Logica/}dtListaDeReproduccion">
 *       &lt;sequence>
 *         &lt;element name="registros" type="{http://Controladores.Logica/}dtRegistroHistorial" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtListaDeReproduccionHistorial", propOrder = {
    "registros"
})
public class DtListaDeReproduccionHistorial
    extends DtListaDeReproduccion
{

    @XmlElement(nillable = true)
    protected List<DtRegistroHistorial> registros;

    /**
     * Gets the value of the registros property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the registros property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegistros().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtRegistroHistorial }
     * 
     * 
     */
    public List<DtRegistroHistorial> getRegistros() {
        if (registros == null) {
            registros = new ArrayList<DtRegistroHistorial>();
        }
        return this.registros;
    }

}
