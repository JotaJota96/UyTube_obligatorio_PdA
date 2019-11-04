package Logica.DataType;

import java.sql.Date;

public class DtUsuario extends DtPersona{
    private String nickname;
    private String correo;
    private Fecha fechaNacimiento;
    private Fecha fechaEliminado;
    private String imagen;
    private int cantSeguidores;

    public DtUsuario(String nickname, String contrasenia, String nombre, String apellido, String correo, Date fechaNacimiento, String imagen, int cantSeguidores) {
        // Antes de leer esto, lee el constructor de DtPersona...
        // para setear los atributos de la clase padre, se utiliza super(..) y 
        // sele asan los atributos que recibe el constructor de la clase padre
        super(nombre, apellido, contrasenia);
        // y ahora se setean los atributos propios
        this.nickname = nickname;
        this.correo = correo;
        this.fechaNacimiento = null;
        if (fechaNacimiento != null) {
            this.fechaNacimiento = new Fecha(fechaNacimiento);
        }
        this.imagen = imagen;
        this.cantSeguidores = cantSeguidores;
    }
    
    public DtUsuario(String nickname, String contrasenia, String nombre, String apellido, String correo, Date fechaNacimiento, Date fechaEliminado, String imagen, int cantSeguidores) {
        // Antes de leer esto, lee el constructor de DtPersona...
        // para setear los atributos de la clase padre, se utiliza super(..) y 
        // sele asan los atributos que recibe el constructor de la clase padre
        super(nombre, apellido, contrasenia);
        // y ahora se setean los atributos propios
        this.nickname = nickname;
        this.correo = correo;
        this.fechaNacimiento = null;
        if (fechaNacimiento != null) {
            this.fechaNacimiento = new Fecha(fechaNacimiento);
        }
        this.fechaEliminado = null;
        if (fechaEliminado != null) {
            this.fechaEliminado = new Fecha(fechaEliminado);
        }
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
        if (fechaNacimiento == null){
            return null;
        }
        return fechaNacimiento.toSqlDate();
    }

    public Date getFechaEliminado() {
        if (fechaEliminado == null){
            return null;
        }
        return fechaEliminado.toSqlDate();
    }

    public String getImagen() {
        return imagen;
    }

    public int getCantSeguidores() {
        return cantSeguidores;
    }

    @Override
    public String toString() {
        return "DtUsuario{" + super.toString() + ", nickname=" + nickname + ", correo=" + correo + ", fechaNacimiento=" + fechaNacimiento + ", fechaEliminado=" + fechaEliminado + ", imagen=" + imagen + ", cantSeguidores=" + cantSeguidores + '}';
    }
}
