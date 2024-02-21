/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public class Paciente extends Persona implements Nadadores {

    //Atributos
    private String numeroHistoria;

    //Constructor
    public Paciente(String numeroHistoria, String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.numeroHistoria = numeroHistoria;
    }

    //Getter and Setter
    public String getNumeroHistoria() {
        return numeroHistoria;
    }

    public void setNumeroHistoria(String numeroHistoria) {
        this.numeroHistoria = numeroHistoria;
    }
    //To string

    @Override
    public String toString() {
        return super.toString() + "Paciente{" + "numeroHistoria=" + numeroHistoria + '}';
    }
    //Equals and hashcode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + Objects.hashCode(this.numeroHistoria);
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
        final Paciente other = (Paciente) obj;
        return Objects.equals(this.numeroHistoria, other.numeroHistoria);
    }

    //Métodos
    //Tomar Médicina
    public void tomarMedicina(String medicina){
        Random r = new Random();
        int aleatorio = r.nextInt(2);
        
        if(aleatorio==0){
            System.out.println("Paciente " + super.getNombre()+" " 
                    +super.getApellidos()+" se ha curado");
        }else{
            System.out.println("Paciente " + super.getNombre()+" " 
                    +super.getApellidos()+" NO se ha curado");
        }
    }

    @Override
    public void nadar() {
        System.out.println("Soy un paciente y nado");
    }
}
