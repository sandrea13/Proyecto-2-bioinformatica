/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */


/**
 * Clase que representa un patrón (tripleta) de ADN.
 * Guarda la secuencia, la frecuencia y las ubicaciones donde aparece.
 */
public class PatronADN {
    String tripleta; // clave
    int frecuencia; // cuántas veces se repite
    ListaUbicaciones ubicaciones; // posiciones donde aparece
    
    /**
     * Constructor de la clase PatronADN.
     * @param tripleta Tripleta de nucleótidos.
     */
    public PatronADN(String tripleta) {
        this.tripleta = tripleta;
        this.frecuencia = 1;
        this.ubicaciones = new ListaUbicaciones();
    }

    /**
     * Agrega una nueva ubicación donde aparece la tripleta.
     * @param posicion Posición en la secuencia principal.
     */
    public void agregarUbicacion(int posicion) {
        this.ubicaciones.agregar(posicion);
    }
    

}
