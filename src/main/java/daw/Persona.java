/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Víctor
 */
public abstract class Persona {

    //Atributos
    private String nombre;
    private String apellidos;
    private NIF nif;

    //Constructor
    public Persona(String nombre, String apellidos, NIF nif) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.nif = nif;
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public NIF getNif() {
        return nif;
    }

    public void setNif(NIF nif) {
        this.nif = nif;
    }

    //To string
    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellidos=" + apellidos + ", nif=" + nif + '}';
    }

    //Equals and hashCode
    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.nombre);
        hash = 29 * hash + Objects.hashCode(this.apellidos);
        hash = 29 * hash + Objects.hashCode(this.nif);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Persona other = (Persona) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        return Objects.equals(this.nif, other.nif);
    }

    //Métodos
    final public void renovarDNI(LocalDate fechaSolicitudRenovacion) {
        //Le añadimos 10 años desde que lo solicita
        System.out.println("..renovano dni a: " + this.nombre+" "+this.apellidos);
        this.nif.renovarDNI(fechaSolicitudRenovacion);

    }
}
