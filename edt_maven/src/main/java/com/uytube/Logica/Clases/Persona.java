package com.uytube.Logica.Clases;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Persona implements Serializable {
    @Id
    private int id;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellido")
    private String apellido;
    
    @Column(name = "contrasenia")
    private String contrasenia;

    //-----------------------------------------------------------------------------

    public Persona() {
    }
    
    public Persona(String nombre, String apellido, String contrasenia) {
        if(contrasenia.equals("")){
                throw new RuntimeException("La contraseña no puede ser Vacio");
        }
        this.nombre = nombre;
        this.apellido = apellido;
        this.contrasenia = contrasenia;
    }

    public int getId() {
        return id;
    }
    
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public boolean validarContrasenia(String pass){
        return this.contrasenia.equals(pass);
    }
    
}
