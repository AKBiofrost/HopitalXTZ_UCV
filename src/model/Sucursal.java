/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import org.json.simple.JSONArray;
/**
 *
 * @author Windows 10
 */
public class Sucursal {
    private String nombre;    
    ArrayList<Medico> medicos = new ArrayList<>();
    ArrayList<Paciente> pacientes = new ArrayList<>();

    public Sucursal() {
    }
    
    public Sucursal(String nombre, ArrayList<Medico> medicos, ArrayList<Paciente> pacientes) {
        this.nombre = nombre;
        this.medicos = medicos;
        this.pacientes = pacientes;
    }
    
    public static Sucursal parseJSON (Map sucursal) {
        
        String nombre = (String) sucursal.get("nombre");
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        System.out.println("{");
        // nombre        
        System.out.println("\t [Sucursal] nombre : " + nombre);

        // médícos
        System.out.println("\t [Sucursal] médicos : ");
        JSONArray medicosJ = (JSONArray) sucursal.get("medicos");
        Iterator itrMedicosJ = medicosJ.iterator();
        while(itrMedicosJ.hasNext()){
            Map mapMedJ = ((Map) itrMedicosJ.next());
            medicos.add(Medico.parseJSON(mapMedJ));    
        }

        // pacientes
        System.out.println("\t [Sucursal] pacientes : ");
        JSONArray pacientesJ = (JSONArray) sucursal.get("pacientes");
        Iterator itrPacientesJ = pacientesJ.iterator();
        while(itrPacientesJ.hasNext()){
            Map mapPacJ = ((Map) itrPacientesJ.next());
            pacientes.add(Paciente.parseJSON(mapPacJ));    
        }
        System.out.println("}");
        
        return new Sucursal(nombre, medicos, pacientes);
    }
    
    //Nombre
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    //Médicos
    public ArrayList<Medico> getMedicos() {
        return medicos;
    }

    public int getMedicosSize() {
        int size = this.medicos.size();
        return size;
    }
    
    public ArrayList<Medico> getMedicosSearch(String search) {
        ArrayList<Medico> found = new ArrayList<>();
        for (Medico med: medicos) {
            if(med.getId().matches(".*"+ search +".*")
               || med.getNombre().matches(".*"+ search +".*")
               || med.getEspecialidad().matches(".*"+ search +".*")
            ){
                found.add(med);
            }
        }
        return found;
    }
    
    public void setMedicos(ArrayList<Medico> medicos) {
        this.medicos = medicos;
    }
    
    //Pacientes
    public ArrayList<Paciente> getPacientes() {
        return this.pacientes;
    }
    
    public Paciente getPacienteByCedula(String cedula) {
        int idx = getIndexPacienteByCedula(cedula);
        return this.pacientes.get(idx);
    }
    
    public int getIndexPacienteByCedula (String cedula) {
        int index = -1;
        for (int i = 0; i < this.pacientes.size(); i++) {
                Paciente e = this.pacientes.get(i);
                if (e.getCedula().equals(cedula)) {
                        index = i;
                        break; // Terminar ciclo
                }
        }
        return index;
    }
    
    public int getPacientesSize() {
        int size = this.pacientes.size();
        return size;
    }

    public ArrayList<Paciente> getPacientesSearch(String search) {
        ArrayList<Paciente> found = new ArrayList<>();
        for (Paciente pac: this.pacientes) {
            if(pac.getCedula().matches(".*"+ search +".*")
               || pac.getNombre().matches(".*"+ search +".*")
            ){
                found.add(pac);
            }
        }
        return found;
    }
    
    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sucursal elemento = (Sucursal) o;
        return  Objects.equals(nombre, elemento.nombre); 
                //&& Objects.equals(nombre, elemento.nombre);
        //Float.compare(elemento.precio, precio) == 0
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, medicos, pacientes);
    }
}
