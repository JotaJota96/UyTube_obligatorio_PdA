package Logica.DataType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)

public class Fecha {

    private int anio;
    private int mes;
    private int dia;

    public Fecha() {
        this.anio = 1900;
        this.mes = 1;
        this.dia = 1;
    }

    public Fecha(int anio, int mes, int dia) {
        this.anio = anio;
        this.mes = mes;
        this.dia = dia;
    }

    public Fecha(java.sql.Date d) {
        if (d == null) {
            this.anio = 1900;
            this.mes = 1;
            this.dia = 1;
        } else {
            this.anio = d.getYear() + 1900;
            this.mes = d.getMonth() +1;
            this.dia = d.getDate();
        }
    }

    public java.sql.Date toSqlDate() {
        return new java.sql.Date(anio -1900, mes- 1, dia);
    }

    @Override
    public String toString() {
        String strAnio = "" + anio;
        String strMes = "" + mes;
        String strDia = "" + dia;
        
        if (mes < 10) strMes = "0" + mes;
        if (dia < 10) strDia = "0" + dia;
        
        return strAnio + "-" + strMes + "-" + strDia;
    }

}
