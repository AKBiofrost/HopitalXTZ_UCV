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
 * Singleton
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

    // Sucursales
    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }
    
    public ArrayList<Sucursal> getSucursalesByNombre(String nombre) {
        ArrayList<Sucursal> found = new ArrayList<>();
        for (Sucursal suc: sucursales) {
            if(suc.getNombre().matches(".*"+ nombre +".*")){
                found.add(suc);
            }
        }
        return found;
    }
    
    public Sucursal getSucursalByNombre(String nombre) {
        ArrayList<Sucursal> found = new ArrayList<>();
        for (Sucursal suc: sucursales) {
            if(suc.getNombre().matches(nombre)){
                found.add(suc);
                break;
            }
        }
        
        if(found.isEmpty())return null;
        else return found.get(0);
    }

    public int getIndexSucursalByNombre (String nombre) {
        int index = -1;
        for (int i = 0; i < sucursales.size(); i++) {
                Sucursal e = sucursales.get(i);
                if (e.getNombre().equals(nombre)) {
                        index = i;
                        break; // Terminar ciclo
                }
        }
        return index;
    }
    
    public boolean deleteSucursalByNombre (String nombre) {
        int index = getIndexSucursalByNombre(nombre);
        if(index == -1) return false;
        
        sucursales.remove(index);
        return true;
    }
    
    public boolean insertSucursal(String nombre)
    {
        System.out.println("insertSucursal");
        System.out.println("nombre :" + nombre);
        
        int index = getIndexSucursalByNombre(nombre);
        if(index != -1) return false;
        
        ArrayList<Medico> medicos = new ArrayList<>();
        ArrayList<Paciente> pacientes = new ArrayList<>();
        
        Sucursal newSucursal = new Sucursal(nombre, medicos, pacientes);
        sucursales.add(newSucursal);
        return true;
    }
    
    public void setSucursales(ArrayList<Sucursal> sucursales) {
        this.sucursales = sucursales;
    }

    
    // Médicos
    public boolean insertMedico(String id, String nombre, String apellido, 
        String especialidad, String sucursal)
    {
        System.out.println("insertMEdico");
        System.out.println("id: " + id);
        System.out.println("nombre :" + nombre);
        System.out.println("apellido :" + apellido);
        System.out.println("especialidad : " + especialidad);
        System.out.println("sucursal : " + sucursal);
    
        int index = getIndexSucursalByNombre(sucursal);
        if(index == -1) return false;
        
        Medico newMedico = new Medico(id, nombre, apellido, especialidad);
        sucursales.get(index).medicos.add(newMedico);
        return true;
    }
    
    public ArrayList<Medico> getMedicosBySucursalName(String sucursal) {
        //System.out.println("getMedicosBySucursalName");
        //System.out.println("sucursal : " + sucursal);
        ArrayList<Medico> arrayEmpty = new ArrayList<>();
    
        int index = getIndexSucursalByNombre(sucursal);
        if(index == -1) return arrayEmpty;
        
        return sucursales.get(index).getMedicos();
    }
    
    // Citas
    public boolean insertCita(String sucursal, String cita, String paciente, 
        String medico, String fecha)
    {
        System.out.println("insertCita");
        System.out.println("sucursal : " + sucursal);
        System.out.println("cita: " + cita);
        System.out.println("paciente :" + paciente);
        System.out.println("medico :" + medico);
        System.out.println("fecha : " + fecha);
    
        int idxSuc = getIndexSucursalByNombre(sucursal);
        if(idxSuc == -1) return false;
                System.out.println("idxSuc: " + idxSuc);

        int idxPac = getIndexPacienteByCedula(idxSuc, paciente);
        if(idxPac == -1) return false;
                System.out.println("idxPac: " + idxPac);

        Cita newCita = new Cita(cita, medico, fecha);
        sucursales.get(idxSuc).pacientes.get(idxPac).citas.add(newCita);
        return true;
    }
    
    
    
    // Pacientes
    public boolean insertPaciente(String sucursal, String cedula, String nombre)
    {
        //System.out.println("insertMEdico");
        //System.out.println("sucursal: " + sucursal);
        //System.out.println("nombre :" + nombre);
        //System.out.println("cedula :" + cedula);
    
        int index = getIndexSucursalByNombre(sucursal);
        if(index == -1) return false;
        
        ArrayList<Cita> citas = new ArrayList<>();
        ArrayList<Historia> historial = new ArrayList<>();
        
        Paciente newPaciente = new Paciente(cedula, nombre, citas, historial);
        sucursales.get(index).pacientes.add(newPaciente);
        return true;
    }
    
    
    public int getIndexPacienteByCedula (int indexSucursal, String cedula) {
        int index = -1;
        ArrayList<Paciente> pacientes = sucursales.get(indexSucursal).pacientes;
        for (int i = 0; i < pacientes.size(); i++) {
                Paciente e = pacientes.get(i);
                if (e.getCedula().equals(cedula)) {
                        index = i;
                        break; // Terminar ciclo
                }
        }
        return index;
    }
    
}
