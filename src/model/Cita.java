/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.Map;

/**
 *
 * @author Windows 10
 */
public class Cita {
    private String id;
    private String medico;
    private String fecha;

    public Cita (String id, String medico, String fecha){
        this.id = id;
        this.medico = medico;
        this.fecha = fecha;
    }
    
    public static Cita parseJSON (Map cita) {
        String id = (String) cita.get("id");
        String medico = (String) cita.get("medico");
        String fecha = (String) cita.get("fecha");

        System.out.println("\t\t{");
        System.out.println("\t\t\t [Cita] id : " + id);
        System.out.println("\t\t\t [Cita] medico : " + medico);
        System.out.println("\t\t\t [Cita] fecha : " + fecha);
        System.out.println("\t\t}");
        
        return new Cita(id, medico, fecha);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMedico() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico = medico;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
