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
public class CitaHistoria {
    String id;
    CitaHistoriaValores valores;

    public CitaHistoria (String id, CitaHistoriaValores valores) {
        this.id = id;
        this.valores = valores;
    }

    public static CitaHistoria parseJSON (Map cita) {
        String id = (String) cita.get("id");
        CitaHistoriaValores valores;

        System.out.println("\t\t\t{");
        System.out.println("\t\t\t\t [Historia Cita] id : " + id);
        System.out.println("\t\t\t\t [Historial Cita] valores : ");
        
        Map mapValoresJ = ((Map) cita.get("valores"));
        valores = CitaHistoriaValores.parseJSON(mapValoresJ);
        System.out.println("\t\t\t}");

        return new CitaHistoria(id, valores);
    }    

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

          
}
