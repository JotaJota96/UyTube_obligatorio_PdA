package Logica.DataType;

public class Duracion {

    private int horas;
    private int minutos;
    private int segundos;

    public Duracion() {
        this.horas = 0;
        this.minutos = 0;
        this.segundos = 0;
    }

    public Duracion(int horas, int minutos, int segundos) {
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public Duracion(java.sql.Time t) {
        if (t == null) {
            this.horas = 0;
            this.minutos = 0;
            this.segundos = 0;
        } else {
            this.horas = t.getHours();
            this.minutos = t.getMinutes();
            this.segundos = t.getSeconds();
        }
    }

    public java.sql.Time toSqlDate() {
        return new java.sql.Time(horas, minutos, segundos);
    }

    @Override
    public String toString() {
        String strHoras = "" + horas;
        String strMinutos = "" + minutos;
        String strSegundos = "" + segundos;
        
        if (minutos < 10) strMinutos = "0" + minutos;
        if (segundos < 10) strMinutos = "0" + segundos;
        
        return strHoras + ":" + strMinutos + ":" + strSegundos;
    }

}
