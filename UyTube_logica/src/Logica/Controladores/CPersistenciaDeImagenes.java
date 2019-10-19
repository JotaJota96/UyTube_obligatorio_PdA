package Logica.Controladores;

import JPAControllerClasses.ImagenUsuarioJpaController;
import JPAControllerClasses.exceptions.NonexistentEntityException;
import Logica.Clases.ImagenUsuario;
import Logica.DataType.DtImagenUsuario;
import Logica.Interfaces.IPersistenciaDeImagenes;
import java.util.logging.Level;
import java.util.logging.Logger;

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
            return null;
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
}
