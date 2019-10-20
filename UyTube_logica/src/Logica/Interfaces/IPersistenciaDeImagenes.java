package Logica.Interfaces;

import Logica.DataType.DtImagenUsuario;

/**
 * Esta interfaz permite realizar acciones CRUD de las imágenes de perfil de los
 * usuarios
 *
 * @author Juan
 */
public interface IPersistenciaDeImagenes {

    /**
     * Devuelve los datos de la imagen del usuario con ese ID
     *
     * @param id ID del usuario del cual se quiere obtener la imagen
     * @return Datos del usuario si existe, o null si no se encontro
     */
    public DtImagenUsuario find(String id) throws RuntimeException;

    /**
     * Persiste una nueva imagen de usuario
     *
     * @param iu Datos de la imagen del usuario
     */
    public void create(DtImagenUsuario iu) throws RuntimeException;

    /**
     * Modifica los datos de la imagen de usuario
     *
     * @param iu Datos de la imagen del usuario
     */
    public void edit(DtImagenUsuario iu) throws RuntimeException;

    /**
     * Elimina la imagen del usuario
     *
     * @param id ID del usuario
     */
    public void remove(String id) throws RuntimeException;

    /**
     * Comprueba si el usuario con el ID indicado posee imagen de perfil
     * persistida
     *
     * @param id ID del usuario
     * @return true si el usuario tiene una imagen de perfil persistida
     */
    public boolean exists(String id) throws RuntimeException;
    
    public DtImagenUsuario getDefaultImage();
    
}
