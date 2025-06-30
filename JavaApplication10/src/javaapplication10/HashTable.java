/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */
public class HashTable {
    private ListaEnlazada[] tabla;
    private int tamaño;

    public HashTable(int tamaño) {
        this.tamaño = tamaño;
        this.tabla = new ListaEnlazada[tamaño];
        for (int i = 0; i < tamaño; i++) {
            tabla[i] = new ListaEnlazada();
        }
    }

    private int funcionHash(String tripleta) {
        int hash = 0;
        for (int i = 0; i < tripleta.length(); i++) {
            hash += tripleta.charAt(i) * (i + 1);
        }
        return hash % tamaño;
    }

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

    public PatronADN buscar(String tripleta) {
        int indice = funcionHash(tripleta);
        return tabla[indice].buscar(tripleta);
    }

}
