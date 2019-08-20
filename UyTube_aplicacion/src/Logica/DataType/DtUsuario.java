package Logica.DataType;

import java.util.Date;

public class DtUsuario extends DtPersona{
    
    private String nickname;
    private String correo;
    private Date fechaNacimiento;
    private String imagen;
    private int cantSeguidores;

    public DtUsuario(String nickname, String correo, Date fechaNacimiento, String imagen, int cantSeguidores) {
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
