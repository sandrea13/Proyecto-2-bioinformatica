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
 * Clase que implementa una tabla hash con manejo de colisiones por encadenamiento.
 */
public class HashTable {
    private ListaEnlazada[] tabla;
    private int tamaño;

    /**
     * Constructor de la tabla hash.
     * @param tamaño Tamaño de la tabla.
     */
    public HashTable(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ListaEnlazada[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    /**
     * Calcula el índice hash para una tripleta.
     * @param tripleta Tripleta de nucleótidos.
     * @return Índice calculado.
     */
    private int funcionHash(String tripleta) {
        int hash = 0;
        for (int i = 0; i < tripleta.length(); i++) {
            hash += tripleta.charAt(i) * (i + 1);
        }
        return hash % tamaño;
    }

    
    /**
     * Inserta una tripleta en la tabla hash.
     * @param tripleta Tripleta a insertar.
     * @param posicion Posición en la secuencia principal.
     */
    public void insertar(String tripleta, int posicion) {
        int indice = funcionHash(tripleta);
        PatronADN patron = tabla[indice].buscar(tripleta);
        if (patron == null) {
            patron = new PatronADN(tripleta);
            patron.agregarUbicacion(posicion);
            tabla[indice].insertar(patron);
        } else {
            patron.frecuencia++;
            patron.agregarUbicacion(posicion);
        }
    }

    /**
     * Busca una tripleta en la tabla hash.
     * @param tripleta Tripleta a buscar.
     * @return PatronADN encontrado o null si no existe.
     */
    public PatronADN buscar(String tripleta) {
        int indice = funcionHash(tripleta);
        return tabla[indice].buscar(tripleta);
    }

}
