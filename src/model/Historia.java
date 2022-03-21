/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
import java.util.Map;
/**
 *
 * @author Windows 10
 */
public class Historia {
    private String id;
    private String paciente;        
    private ArrayList<citaHistoria> citas = new ArrayList<>();

    public Historia (String id, String paciente) {
        this.id = id;
        this.paciente = paciente;
    }
    
    public static Historia parseJSON (Map cita) {
        String id = (String) cita.get("id");
        String paciente = (String) cita.get("paciente");
        ArrayList<citaHistoria> citas = new ArrayList<>();

        System.out.println("\t\t{");
        System.out.println("\t\t\t [Historial] id : " + id);
        System.out.println("\t\t\t [Historial] paciente : " + paciente);
        System.out.println("\t\t\t [Historial] citas : " + cita.get("citas"));
        System.out.println("\t\t}");
        
        return new Historia(id, paciente);
    }

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

    public ArrayList<citaHistoria> getCitas() {
        return citas;
    }

    public void setCitas(ArrayList<citaHistoria> citas) {
        this.citas = citas;
    }
    
    
    
    
    public static class citaHistoria{
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
