package Logica.DataType;

public class DtImagenUsuario {

    private String nickname;
    private byte[] imagen;
    private String nombreArchivo;

    public DtImagenUsuario(String nickname, byte[] imagen, String nombreArchivo) {
        this.nickname = nickname;
        this.imagen = imagen;
        this.nombreArchivo = nombreArchivo;
    }

    public String getNickname() {
        return nickname;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
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

    @Override
    public String toString() {
        return "DtImagenUsuario{" + "nickname=" + nickname + ", imagen=" + imagen.length + ", nombreArchivo=" + nombreArchivo + '}';
    }
    
}
