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
public class CitaHistoriaValores {
    String peso;            
    String talla;
    String pesoTalla;
    String pulso;

    /**
     *
     * @param peso
     * @param talla
     * @param pesoTalla
     * @param pulso
     * @param tension sdfsdfdfdf
     */
    public CitaHistoriaValores (String peso, String talla, String pesoTalla, 
        String pulso, CitaHistoriaValores.Tension tension
    ) {
        this.peso = peso;
        this.talla = talla;
        this.pesoTalla = pesoTalla;
        this.pulso = pulso;
    }

    public static CitaHistoriaValores parseJSON (Map valores) {
        String peso = (String) valores.get("peso");
        String talla = (String) valores.get("talla");
        String pesoTalla = (String) valores.get("pesoTalla");
        String pulso = (String) valores.get("pulso");
        CitaHistoriaValores.Tension tension;
        
        System.out.println("\t\t\t\t{");
        System.out.println("\t\t\t\t\t [Historia Cita Valores] peso : " + peso);
        System.out.println("\t\t\t\t\t [Historia Cita Valores] talla : " + talla);
        System.out.println("\t\t\t\t\t [Historia Cita Valores] pesoTalla : " + pesoTalla);
        System.out.println("\t\t\t\t\t [Historia Cita Valores] pulso : " + pulso);
        
        System.out.println("\t\t\t\t\t [Historia Cita Valores] tension : ");
        Map mapTensionJ = ((Map) valores.get("tension"));
        tension = CitaHistoriaValores.Tension.parseJSON(mapTensionJ);
        System.out.println("\t\t\t\t}");

        return new CitaHistoriaValores(peso, talla, pesoTalla, pulso, tension);
    }    
    
    private static class Tension {
        String maxima;        
        String minima;
        
        public Tension (String maxima, String minima) {
            this.maxima = maxima;
            this.minima = minima;
        }
        
        public static Tension parseJSON (Map valores) {
            String max = (String) valores.get("maxima");
            String min = (String) valores.get("minima");

            System.out.println("\t\t\t\t\t{");
            System.out.println("\t\t\t\t\t\t [Historia Cita Valores] maxima : " + max);
            System.out.println("\t\t\t\t\t\t [Historia Cita Valores] minima : " + min);
            System.out.println("\t\t\t\t\t}");

            return new Tension(max, min);
        } 
;
    }
}
