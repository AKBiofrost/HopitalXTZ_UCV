/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Windows 10
 */
public class Data {
    private static Data instance;
    static String path = "data.json";    
    static String pathRunning = "data_running.json";
    ArrayList<Sucursal> sucursales = new ArrayList<>();
    ArrayList<Directivo> juntaDirectiva = new ArrayList<>();
    

    private Data() {
        //String[] nombres = new String[]{"Sucursal Uno","Sucursal XYZ"};
        readFile();
    }
 
    private void readFile () {
        try{
            Object obj = new JSONParser().parse(new FileReader(path));
            JSONObject dataJ = (JSONObject) obj;
            
            // Junta Directiva
            System.out.println("[Data] juntaDirectiva : ");
            JSONArray juntaDirectivaJ = (JSONArray) dataJ.get("juntaDirectiva");            
            Iterator itrJuntaDirectivaJ = juntaDirectivaJ.iterator();
            while(itrJuntaDirectivaJ.hasNext()){
                Map mapDirectivo = ((Map) itrJuntaDirectivaJ.next());
                this.juntaDirectiva.add(Directivo.parseJSON(mapDirectivo));
            }

            // Sucursales
            System.out.println("[Data] sucursales : ");
            JSONArray sucursalesJ = (JSONArray) dataJ.get("sucursales");
            Iterator itrSucursalesJ = sucursalesJ.iterator();
            while(itrSucursalesJ.hasNext()){
                Map mapSuc = ((Map) itrSucursalesJ.next());
                this.sucursales.add(Sucursal.parseJSON(mapSuc));    
            }
            
        }catch (IOException | ParseException e) {
            System.out.println("[readFile] Error: " + e);
        }
    }
    
    public static Data getInstance() {
        if(instance == null) instance = new Data();
        return instance;
    }

    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }
    
    public ArrayList<Sucursal> getSucursalesByNombre(String nombre) {
        ArrayList<Sucursal> found = new ArrayList<>();
        for (Sucursal suc: sucursales) {
            if(suc.getNombre().matches(".*"+ nombre +"*")){
                found.add(suc);
            }
        }
        return found;
    }
    
    public Sucursal getSucursalByNombre(String nombre) {
        ArrayList<Sucursal> found = new ArrayList<>();
        for (Sucursal suc: sucursales) {
            if(suc.getNombre().matches(".*"+ nombre +"*")){
                found.add(suc);
            }
        }
        
        if(found.isEmpty())return null;
        else return found.get(0);
    }

    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    
}