/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */
public class PatronADN {
    String tripleta; // clave
    int frecuencia; // cuántas veces se repite
    ListaUbicaciones ubicaciones; // posiciones donde aparece

    public PatronADN(String tripleta) {
        this.tripleta = tripleta;
        this.frecuencia = 1;
        this.ubicaciones = new ListaUbicaciones();
    }

    public void agregarUbicacion(int posicion) {
        this.ubicaciones.agregar(posicion);
    }
}
