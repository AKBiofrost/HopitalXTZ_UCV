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
public class Medico {
    private String id;
    private String nombre;
    private String especialidad;

    public Medico(String id, String nombre, String especialidad) {
        this.id = id;
        this.nombre = nombre;
        this.especialidad = especialidad;
    }
    
    public static Medico parseJSON (Map medico) {
        String id = (String) medico.get("id");
        String nombre = (String) medico.get("nombre");
        String especialidad = (String) medico.get("especialidad");

        System.out.println("\t{");
        System.out.println("\t\t [Medico] id : " + id);
        System.out.println("\t\t [Medico] nombre : " + nombre);
        System.out.println("\t\t [Medico] especialidad : " + especialidad);
        System.out.println("\t}");
        
        return new Medico(id, nombre, especialidad);
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {    
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
