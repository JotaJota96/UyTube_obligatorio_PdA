package Logica.Controladores;

import JPAControllerClasses.ImagenUsuarioJpaController;
import JPAControllerClasses.exceptions.NonexistentEntityException;
import Logica.Clases.ImagenUsuario;
import Logica.DataType.DtImagenUsuario;
import Logica.Interfaces.IPersistenciaDeImagenes;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.effect.ImageInput;
import javax.swing.ImageIcon;

public class CPersistenciaDeImagenes implements IPersistenciaDeImagenes {

    private static CPersistenciaDeImagenes instancia = null;

    // Constructor
    private CPersistenciaDeImagenes() {
    }

    // Singleton
    public static CPersistenciaDeImagenes getInstancia() {
        if (instancia == null) {
            instancia = new CPersistenciaDeImagenes();
        }
        return instancia;
    }

    //****************************************************************************************
    @Override
    public DtImagenUsuario find(String id) throws RuntimeException {
        if ( ! exists(id)){
            return getDefaultImage();
        }
        try {
            ImagenUsuario iu = new ImagenUsuarioJpaController().findImagenUsuario(id);
            return new DtImagenUsuario(iu.getNickname(), iu.getImagen(), iu.getNombreArchivo());
        } catch (Exception ex) {
            Logger.getLogger(CPersistenciaDeImagenes.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar consultar la imagen\n" + ex.getMessage());
        }
    }

    @Override
    public void create(DtImagenUsuario iu) throws RuntimeException {
        if (exists(iu.getNickname())) {
            edit(iu);
            return;
        }
        try {
            new ImagenUsuarioJpaController().create(
                    new ImagenUsuario(iu.getNickname(), iu.getImagen(), iu.getNombreArchivo())
            );
        } catch (Exception ex) {
            Logger.getLogger(CPersistenciaDeImagenes.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar guardar la imagen\n" + ex.getMessage());
        }
    }

    //new ImagenUsuarioJpaController().
    @Override
    public void edit(DtImagenUsuario iu) throws RuntimeException {
        if (!exists(iu.getNickname())) {
            create(iu);
            return;
        }
        try {
            new ImagenUsuarioJpaController().edit(
                    new ImagenUsuario(iu.getNickname(), iu.getImagen(), iu.getNombreArchivo())
            );
        } catch (Exception ex) {
            Logger.getLogger(CPersistenciaDeImagenes.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar modificar la imagen\n" + ex.getMessage());
        }
    }

    @Override
    public void remove(String id) throws RuntimeException {
        try {
            new ImagenUsuarioJpaController().destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(CPersistenciaDeImagenes.class.getName()).log(Level.SEVERE, null, ex);
            throw new RuntimeException("Algo falló al intentar remover la imagen\n" + ex.getMessage());
        }
    }

    @Override
    public boolean exists(String id) throws RuntimeException {
        return new ImagenUsuarioJpaController().findImagenUsuario(id) != null;
    }

    @Override
    public DtImagenUsuario getDefaultImage() {
        try {
            InputStream in = getClass().getResourceAsStream("/imagenes/ukp.png");
            //File f = new File(getClass().getResource("/imagenes/ukp.png").getFile());
            //File f = new File(connection.getJarFileURL().toURI()); //asociamos el archivo fisico
            //InputStream is = new FileInputStream(f); //lo abrimos. Lo importante es que sea un InputStream
            byte[] buffer = new byte[(int) in.available()]; //creamos el buffer
            int readers = in.read(buffer); //leemos el archivo al buffer
            
            return new DtImagenUsuario("", buffer, "ukp.png");
            
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
