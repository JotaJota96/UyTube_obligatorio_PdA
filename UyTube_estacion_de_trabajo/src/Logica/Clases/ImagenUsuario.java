package Logica.Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "ImagenUsuario")
public class ImagenUsuario implements Serializable {
    @Id
    @Column(name = "id")
    private String nickname;
    
    @Lob
    @Column(name = "imagen")
    private byte[] imagen;
    
    @Column(name = "nombreArchivo")
    private String nombreArchivo;
    
    //******************** Constructores ********************
    public ImagenUsuario() {
    }

    public ImagenUsuario(String nickname, byte[] imagen, String nombreArchivo) {
        this.nickname = nickname;
        this.imagen = imagen;
        this.nombreArchivo = nombreArchivo;
    }

    //***************** Getters y setters *****************
    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public String getExtension(){
        String ret = "";
        // recorre desde el final hacia el principio hasta encontrar un '.'  extrayendo la extension del archivo
        for (int i = this.nombreArchivo.length() - 1; i >= 0; i--) {
            if (this.nombreArchivo.charAt(i) == '.') {
                break;
            }
            ret = this.nombreArchivo.charAt(i) + ret;
        }
        // si la extension obtenida es igual al nombre del archivo, entonces no se encontro ningun punto y el archivo no tienee extension
        if (ret.equals(this.nombreArchivo)) {
            return "";
        }
        // sino devuelve la extension obtenida
        return ret;
    }
}
