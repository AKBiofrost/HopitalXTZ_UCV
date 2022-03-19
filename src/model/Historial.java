/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author Windows 10
 */
public class Historial {
    private String id;
    private String paciente;        
    private ArrayList<citaHistorial> citas = new ArrayList<>();

    /*public void addAvailableAppointment(String date, String time){
        availableAppointments.add(new Doctor.AvailableAppointment(date,time));
    }*/

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPaciente() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente = paciente;
    }

    public ArrayList<citaHistorial> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<citaHistorial> citas) {
        this.citas = citas;
    }
    
    
    
    
    public static class citaHistorial{
        private String id;
        private String valores;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getValores() {
            return valores;
        }

        public void setValores(String valores) {
            this.valores = valores;
        }
        
    }
    
}
