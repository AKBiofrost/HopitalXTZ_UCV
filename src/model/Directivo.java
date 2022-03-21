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
public class Directivo {
    private String nombre;
       
    public Directivo(String nombre) {
        this.nombre = nombre;
    }
    
    public static Directivo parseJSON (Map directivo) {
        String nombre = (String) directivo.get("nombre");

        System.out.println("{");
        System.out.println("\t [Directivo] nombre : " + nombre);
        System.out.println("}");
        
        return new Directivo(nombre);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
