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
public class Historia {
    private String id;
    private String paciente;        
    private ArrayList<CitaHistoria> citas = new ArrayList<>();

    /**
     *
     * @param id
     * @param paciente
     * @param citas
     */
    public Historia (String id, String paciente, ArrayList<CitaHistoria> citas) {
        this.id = id;
        this.paciente = paciente;
        this.citas = citas;
    }
    
    public static Historia parseJSON (Map historia) {
        String id = (String) historia.get("id");
        String paciente = (String) historia.get("paciente");
        ArrayList<CitaHistoria> citas = new ArrayList<>();

        System.out.println("\t\t{");
        System.out.println("\t\t\t [Historial] id : " + id);
        System.out.println("\t\t\t [Historial] paciente : " + paciente);
        
        System.out.println("\t\t\t [Historial] citas : ");
        JSONArray citasJ = (JSONArray) historia.get("citas");
        Iterator itrCitasJ = citasJ.iterator();
        while(itrCitasJ.hasNext()){
            Map mapCitasJ = ((Map) itrCitasJ.next());
            citas.add(CitaHistoria.parseJSON(mapCitasJ));    
        }
        System.out.println("\t\t}");
        
        return new Historia(id, paciente, citas);
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
    
}
