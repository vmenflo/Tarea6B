/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public abstract class Empleado extends Persona {

    //Atributos
    private String numeroSeguridadSocial;
    private double salario;
    private final List<String> numerosSS;
    //constructor

    public Empleado(String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.numerosSS = new ArrayList<>();
        this.numeroSeguridadSocial = generarNumeroSeguridadSocial();
        this.salario = generarSueldo();
    }

    //Getter and Setter
    public String getNumeroSeguridadSocial() {
        return numeroSeguridadSocial;
    }

    public void setNumeroSeguridadSocial(String numeroSeguridadSocial) {
        this.numeroSeguridadSocial = numeroSeguridadSocial;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    //To String
    @Override
    public String toString() {
        return super.toString() + "Empleado{" + "numeroSeguridadSocial=" + numeroSeguridadSocial + ", salario=" + salario + '}';
    }

    //Equals and hashCode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.numeroSeguridadSocial);
        hash = 97 * hash + (int) (Double.doubleToLongBits(this.salario) ^ (Double.doubleToLongBits(this.salario) >>> 32));
        hash = 97 * hash + Objects.hashCode(this.numerosSS);
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
        final Empleado other = (Empleado) obj;
        if (Double.doubleToLongBits(this.salario) != Double.doubleToLongBits(other.salario)) {
            return false;
        }
        if (!Objects.equals(this.numeroSeguridadSocial, other.numeroSeguridadSocial)) {
            return false;
        }
        return Objects.equals(this.numerosSS, other.numerosSS);
    }

    //Métodos propios
    private String generarNumeroSeguridadSocial() {
        StringBuilder generado = new StringBuilder();
        String numero;
        Random r = new Random(); //Creo objeto aleatorio
        do {//Controlo que no este repetido el numero
            //Relleno de 4 letras aleatorias
            for (int i = 0; i < 4; i++) {
                char letra = (char) (r.nextInt(26) + 'A');
                generado.append(letra);
            }
            //Relleno de 12 numeros aleatorios
            for (int i = 0; i < 12; i++) {
                generado.append(r.nextInt(10));
            }
            numero = generado.toString();
        } while (numerosSS.contains(numero));
        numerosSS.add(numero);
        return numero; //Devuelvo el String
    }

    //Generar suedo
    private double generarSueldo() {
        Random r = new Random();
        //Genero aleatoriamente un double
        double sueldo = r.nextDouble(1500, 3000);
        return sueldo;
    }
    //Método que sobreescribiremos según el tipo de empleado
    abstract double calcularIRFP();

}
