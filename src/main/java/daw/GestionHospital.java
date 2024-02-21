/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package daw;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Víctor
 */
public class GestionHospital {

    public static void main(String[] args) {
        //Creo Hospital
        Hospital clinico = new Hospital("Clinico", "Teatinos, Málaga", 150);
        //Dar de alta empleados 2 medicos 3 administrativos
        clinico.contratarEmpleado(generarAdministrativo());
        clinico.contratarEmpleado(generarAdministrativo());
        clinico.contratarEmpleado(generarAdministrativo());
        clinico.contratarEmpleado(generarMedico());
        clinico.contratarEmpleado(generarMedico());
        
        //Ingreso a 5 pacientes
        clinico.ingresarPaciente(generarPaciente());
        clinico.ingresarPaciente(generarPaciente());
        clinico.ingresarPaciente(generarPaciente());
        clinico.ingresarPaciente(generarPaciente());
        clinico.ingresarPaciente(generarPaciente());
        
        //Medico receta Pancetamol
        //Casting para poder acceder a tratar
        if(clinico.getEmpleado().get(3) instanceof Medico){
            Medico medico = (Medico)clinico.getEmpleado().get(3);
            medico.tratar(clinico.getPaciente().get(2), "Pancetamol");
        }
        
        //calcular RPF a todos los empleados
        DecimalFormat formato = new DecimalFormat("#.##"); //Dar forma
        for (Empleado empleado : clinico.getEmpleado()) {
            System.out.println(formato.format(empleado.calcularIRFP())+" €.");
        }
        
        //Renovar Dni paciente
        clinico.getPaciente().get(0).renovarDNI(LocalDate.now());
        
    }

    //Métodos
//    La clase GestiónHospital contiene el main() y métodos para crear pacientes, 
//    crear médicos y crear administrativos, con datos aleatorios o como estimes 
//    conveniente. 
    public static Paciente generarPaciente() {
        Random r = new Random();//Objeto random
        //Array de nombres y apellidos
        String[] nombres = {"Victor", "Aiman", "Edu", "Tomas", "Rafael", "Antonio",
            "Rocio", "Gema", "Alvaro", "Cristina", "Aida", "Alicia", "Simon", "Vico"};
        String[] apellidos = {"Mena", "Ariel", "Gonzalez", "Mohamed", "Fernandez",
            "Flores", "Vallejo", "Aragon", "Rivas", "Flor", "Montes"};
        //Creo tantos pacientes y relleno la lista como indique
        
            int aleatorioNombre = r.nextInt(0, nombres.length);
            int aleatorioApellidos = r.nextInt(0, apellidos.length);
            long aleatorioDNI = r.nextLong(10000000, 999999999);
            int aleatorioDia = r.nextInt(1, 29);
            int aleatorioMes = r.nextInt(1, 13);
            int aleatorioAño = r.nextInt(LocalDate.now().getYear(), LocalDate.now().getYear() + 10);
            Paciente paciente = new Paciente("aaa",
                    nombres[aleatorioNombre], apellidos[aleatorioApellidos],
                    new NIF(aleatorioDNI, LocalDate.of(
                            aleatorioAño, aleatorioMes, aleatorioDia)));
        
        return paciente;//Devuelvo la paciente
    }
    //Generar administrativos
    public static Empleado generarAdministrativo() {
        
        Random r = new Random();//Objeto random
        //Array de nombres y apellidos
        String[] nombres = {"Victor", "Aiman", "Edu", "Tomas", "Rafael", "Antonio",
            "Rocio", "Gema", "Alvaro", "Cristina", "Aida", "Alicia", "Simon", "Vico"};
        String[] apellidos = {"Mena", "Ariel", "Gonzalez", "Mohamed", "Fernandez",
            "Flores", "Vallejo", "Aragon", "Rivas", "Flor", "Montes"};
       //Datos aleatorios
            int aleatorioNombre = r.nextInt(0, nombres.length);
            int aleatorioApellidos = r.nextInt(0, apellidos.length);
            long aleatorioDNI = r.nextLong(10000000, 999999999);
            int aleatorioDia = r.nextInt(1, 29);
            int aleatorioMes = r.nextInt(1, 13);
            int aleatorioAño = r.nextInt(LocalDate.now().getYear(), LocalDate.now().getYear()+10);
            GRUPO[] grupo = GRUPO.values(); //Devolver irpf aleatorio
            int aleatorio = r.nextInt(0, 3);
            Administrativo admin = new Administrativo(grupo[aleatorio],
                    nombres[aleatorioNombre], apellidos[aleatorioApellidos],
                    new NIF(aleatorioDNI, LocalDate.of(
                            aleatorioAño, aleatorioMes, aleatorioDia)));
        
        return admin;//Devuelvo la paciente
    }
    
   //Generar medicos
    public static Medico generarMedico() {
        
        Random r = new Random();//Objeto random
        //Array de nombres y apellidos
        String[] nombres = {"Victor", "Aiman", "Edu", "Tomas", "Rafael", "Antonio",
            "Rocio", "Gema", "Alvaro", "Cristina", "Aida", "Alicia", "Simon", "Vico"};
        String[] apellidos = {"Mena", "Ariel", "Gonzalez", "Mohamed", "Fernandez",
            "Flores", "Vallejo", "Aragon", "Rivas", "Flor", "Montes","Medina","España"};
       //Datos aleatorios
            int aleatorioNombre = r.nextInt(0, nombres.length);
            int aleatorioApellidos = r.nextInt(0, apellidos.length);
            long aleatorioDNI = r.nextLong(10000000, 999999999);
            int aleatorioDia = r.nextInt(1, 29);
            int aleatorioMes = r.nextInt(1, 13);
            int aleatorioAño = r.nextInt(LocalDate.now().getYear(), LocalDate.now().getYear() + 10);
            
            Medico doc = new Medico("Cirujano",
                    nombres[aleatorioNombre], apellidos[aleatorioApellidos],
                    new NIF(aleatorioDNI, LocalDate.of(
                            aleatorioAño, aleatorioMes, aleatorioDia)));
        
        return doc;//Devuelvo la paciente
    }
}
