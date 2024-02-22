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
final public class Administrativo extends Empleado {

    //Atributos
    private GRUPO irpf;

    //Constructor
    public Administrativo(GRUPO irpf, String nombre, String apellidos, NIF nif) {
        super(nombre, apellidos, nif);
        this.irpf = irpf;
    }

    //Getter and Setter
    public GRUPO getIrpf() {
        return irpf;
    }

    public void setIrpf(GRUPO irpf) {
        this.irpf = irpf;
    }

    //To string
    @Override
    public String toString() {
        return super.toString() + "Administrativo{" + "irpf=" + irpf + '}';
    }

    //Equals and hashcode
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.irpf);
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
        final Administrativo other = (Administrativo) obj;
        return this.irpf == other.irpf;
    }

    //Método heredado
    @Override
    double calcularIRFP() {
        //El sueldo * el porcentaje que retiene
        double retenido = (this.getSalario()) * (this.irpf.getIrpf());
        return retenido;
    }

    //Método registrar documento
//    - El registro de un documento por parte de un administrativo se implementa
//    usando un mensaje por consola que indique el nombre y apellidos del
//    administrativo que registra el documento, el nombre del documento y el
//    hashcode del String que se pasa como parámetro al método.
    public void registrarDocumento(String documento) {
        //Creo un blocText
        String informe = """
                       %s %s ha registrado el documento " %s " -- HashCode:(%d).
                        """.formatted(super.getNombre(),
                super.getApellidos(), documento,
                documento.hashCode());
        //Así directamente coje nombre, apellidos, documento y hashcode
        System.out.println(informe);
    }
}
