package Logica.DataType;

import java.sql.Date;

public class DtUsuario extends DtPersona{
    private String nickname;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private int cantSeguidores;

    public DtUsuario() {}

    public DtUsuario(String nickname, String contrasenia, String nombre, String apellido, String correo, Date fechaNacimiento, String imagen, int cantSeguidores) {
        // Antes de leer esto, lee el constructor de DtPersona...
        // para setear los atributos de la clase padre, se utiliza super(..) y 
        // sele asan los atributos que recibe el constructor de la clase padre
        super(nombre, apellido, contrasenia);
        // y ahora se setean los atributos propios
        this.nickname = nickname;
        this.correo = correo;
        this.fechaNacimiento = fechaNacimiento;
        this.imagen = imagen;
        this.cantSeguidores = cantSeguidores;
    }

    public String getNickname() {
        return nickname;
    }

    public String getCorreo() {
        return correo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public String getImagen() {
        return imagen;
    }

    public int getCantSeguidores() {
        return cantSeguidores;
    }

    
    
}
