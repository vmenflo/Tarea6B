/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Víctor
 */
public class Hospital {

    //Atributos
    private String nombre;
    private String direccion;
    private int numeroCamas;
    private List<Paciente> pacientes;
    private List<Empleado> empleados;

    //Constructor
    public Hospital(String nombre, String direccion, int numeroCamas) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.numeroCamas = numeroCamas;
        this.pacientes = new ArrayList<>();//Inicializo en el constructor
        this.empleados = new ArrayList<>();
    }

    //Getter and Setter
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getNumeroCamas() {
        return numeroCamas;
    }

    public void setNumeroCamas(int numeroCamas) {
        this.numeroCamas = numeroCamas;
    }

    public List<Paciente> getPaciente() {
        return pacientes;
    }

    public void setPaciente(List<Paciente> paciente) {
        this.pacientes = paciente;
    }

    public List<Empleado> getEmpleado() {
        return empleados;
    }

    public void setEmpleado(List<Empleado> empleado) {
        this.empleados = empleado;
    }

    //To string
    @Override
    public String toString() {
        return "Hospital{" + "nombre=" + nombre + ", direccion=" + direccion + ", numeroCamas=" + numeroCamas + ", paciente=" + pacientes + ", empleado=" + empleados + '}';
    }
    //Equals and hashcode

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.direccion);
        hash = 53 * hash + this.numeroCamas;
        hash = 53 * hash + Objects.hashCode(this.pacientes);
        hash = 53 * hash + Objects.hashCode(this.empleados);
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
        final Hospital other = (Hospital) obj;
        if (this.numeroCamas != other.numeroCamas) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.pacientes, other.pacientes)) {
            return false;
        }
        return Objects.equals(this.empleados, other.empleados);
    }

    //Métodos
    //Contratar a un empleado nuevo
    public void contratarEmpleado(Empleado empleado) {
        empleados.add(empleado);
        System.out.println(empleado.getNombre() + " ha sido contratado");
    }

    //Contratar un trabajador nuevo
    public void ingresarPaciente(Paciente paciente) {
        if(pacientes.size()<=this.numeroCamas){
            pacientes.add(paciente);
            System.out.println("Paciente "+paciente.getNombre()+" "+paciente.getApellidos() +" ha sido ingresado");
        }else{
            System.out.println("No tenemos camas suficientes, "
                    + "te reubicamos en otro Hospital");
        }
    }
}
