/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

/**
 *
 * @author Víctor
 */
public class NIF {

    //Atributos
    private long numero;
    private char letra;
    private LocalDate fechaCaducidad;
    //Atributos propios finales
    private final static char[] CARACTERES = {'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E'};
    private final static int DIVISION_CHAR = 23;
    private final static int ANIOS_RENOVACION = 10;
    //Constructor

    public NIF(long numero, LocalDate fechaCaducidad) {
        this.numero = numero;
        this.letra = calcularLetra();
        this.fechaCaducidad = fechaCaducidad;
    }

    //Getter and seter
    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public LocalDate getFechaCaducidad() {
        return fechaCaducidad;
    }

    public void setFechaCaducidad(LocalDate fechaCaducidad) {
        this.fechaCaducidad = fechaCaducidad;
    }

    //To String
    @Override
    public String toString() {
        return "NIF{" + "numero=" + numero + ", letra=" + letra + ", fechaCaducidad=" + fechaCaducidad + '}';
    }

    //Equals and HashCode
    @Override
    public int hashCode() {
        int hash = 5;
        hash = 13 * hash + (int) (this.numero ^ (this.numero >>> 32));
        hash = 13 * hash + this.letra;
        hash = 13 * hash + Objects.hashCode(this.fechaCaducidad);
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
        final NIF other = (NIF) obj;
        if (this.numero != other.numero) {
            return false;
        }
        if (this.letra != other.letra) {
            return false;
        }
        return Objects.equals(this.fechaCaducidad, other.fechaCaducidad);
    }

    //Métodos
    //Generar Letra
    private char calcularLetra() {
        //Dividimos el número entre 23
        int division = (int) this.numero % DIVISION_CHAR;
        //Devolvemos el char de la posicion que de como resultado de la división
        char letra = this.CARACTERES[division];
        return letra;
    }

    //Renovar Dni
    public void renovarDNI(LocalDate fechaSolicitudRenovacion) {
        //Le añadimos 10 años desde que lo solicita
        this.fechaCaducidad = fechaSolicitudRenovacion.plusYears(ANIOS_RENOVACION);
        System.out.println("Su nueva fecha de caducidad es: " + this.fechaCaducidad);
    }

}
