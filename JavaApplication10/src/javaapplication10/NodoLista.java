/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication10;

/**
 *
 * @author Adolfo Castillo, Andrea Sanchez, Luciano Rojas
 */
public class NodoLista {
    PatronADN dato;
    NodoLista siguiente;

    public NodoLista(PatronADN dato) {
        this.dato = dato;
        this.siguiente = null;
    }
}
