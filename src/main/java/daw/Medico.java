/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.Objects;

/**
 *
 * @author Víctor
 */
public class Medico extends Empleado implements Nadadores{

    //Atributos
    private String especialidad;
    //Finales
    private final static double IRPF_CIRUGIA = 0.25;
    private final static double IRPF = 0.235;

    //Constructor
    public Medico(String especialidad, String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.especialidad = especialidad;
    }

    //Getter and Setter
    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    //To string
    @Override
    public String toString() {
        return super.toString() + "Medico{" + "especialidad=" + especialidad + '}';
    }
    //Equals and hashCode

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.especialidad);
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
        final Medico other = (Medico) obj;
        return Objects.equals(this.especialidad, other.especialidad);
    }

    //Métodos
    @Override
    double calcularIRFP() {
        if (this.especialidad.equalsIgnoreCase("cirugia")) {
            return super.getSalario() * IRPF_CIRUGIA;
        } else {
            return super.getSalario() * IRPF;
        }
    }

    //Tratar
    public void tratar(Paciente paciente, String medicina) {
        //La accion es registrar la receta
        System.out.println("El Doctor " + super.getNombre() + " " + super.getApellidos()
                + " trata al paciente: " + paciente.getNombre() + " "
                + super.getApellidos() + " con " + medicina);
        //El paciente toma la medicina que receta el medico
        paciente.tomarMedicina(medicina);
    }

    @Override
    public void nadar() {
        System.out.println("Soy un médico y nado");
    }

}
