/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package daw;

/**
 *
 * @author Víctor
 */
public enum GRUPO {
    C(0.175),
    D(0.18),
    E(0.185);
    private double irpf;
    //constructor
    private GRUPO(double irpf) {
        this.irpf = irpf;
    }
    
    //Getter

    public double getIrpf() {
        return irpf;
    }
    
    
}
