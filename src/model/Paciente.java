/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
/**
 *
 * @author Windows 10
 */
public class Paciente {
    private String cedula;
    private String nombre;
    private ArrayList<Cita> citas = new ArrayList<>();
    private ArrayList<Historia> historial = new ArrayList<>();
/*public void addAvailableAppointment(String date, String time){
    availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }*/
    public Paciente (String cedula, String nombre, ArrayList<Cita> citas, ArrayList<Historia> historial ){
        this.cedula = cedula;        
        this.nombre = nombre;
        this.citas = citas;
    }
    
    public static Paciente parseJSON (Map paciente) {
        String cedula = (String) paciente.get("cedula");
        String nombre = (String) paciente.get("nombre");
        ArrayList<Cita> citas = new ArrayList<>();
        ArrayList<Historia> historial = new ArrayList<>();

        System.out.println("\t{");
        System.out.println("\t\t [Paciente] cedula : " + cedula);
        System.out.println("\t\t [Paciente] nombre : " + nombre);
        
        // citas
        System.out.println("\t\t [Paciente] citas : ");
        JSONArray citasJ = (JSONArray) paciente.get("citas");
        Iterator itrCitasJ = citasJ.iterator();
        while(itrCitasJ.hasNext()){
            Map mapCitaJ = ((Map) itrCitasJ.next());
            citas.add(Cita.parseJSON(mapCitaJ));    
        }
        
        // historial
        System.out.println("\t\t [Paciente] historial : ");
        JSONArray historialJ = (JSONArray) paciente.get("historial");
        Iterator itrHistorialJ = historialJ.iterator();
        while(itrHistorialJ.hasNext()){
            Map mapHistorialJ = ((Map) itrHistorialJ.next());
            historial.add(Historia.parseJSON(mapHistorialJ));    
        }
        System.out.println("\t}");

        return new Paciente(cedula, nombre, citas, historial);
    }
    
    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Cita> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<Cita> citas) {
        this.citas = citas;
    }

    public ArrayList<Historia> getHistorial() {
        return historial;
    }

    public void setHistorial(ArrayList<Historia> historial) {
        this.historial = historial;
    }

    
    
}
