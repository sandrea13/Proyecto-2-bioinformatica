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

    public ListaEnlazada[] getTabla() {
        return tabla;
    }

    public void setTabla(ListaEnlazada[] tabla) {
        this.tabla = tabla;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
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
    
    
    public void imprimirTabla() {
        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;
            while (actual != null) {
                System.out.println("Tripleta: " + actual.dato.tripleta + 
                                   " | Frecuencia: " + actual.dato.frecuencia);
                actual = actual.siguiente;
            }
        }
    }
    
    public PatronADN obtenerPatronMasFrecuente() {
        PatronADN masFrecuente = null;

        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;
            while (actual != null) {
                if (masFrecuente == null || actual.dato.frecuencia > masFrecuente.frecuencia) {
                    masFrecuente = actual.dato;
                }
                actual = actual.siguiente;
            }
        }

        return masFrecuente;
    }
    
    public PatronADN obtenerPatronMenosFrecuente() {
        PatronADN menosFrecuente = null;

        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;
            while (actual != null) {
                if (menosFrecuente == null || actual.dato.frecuencia < menosFrecuente.frecuencia) {
                    menosFrecuente = actual.dato;
                }
                actual = actual.siguiente;
            }
        }

        return menosFrecuente;
    }
    
    public String reporteColisiones() {
        String reporte = "";
        boolean hayColisiones = false;

        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;

            // Contar cuántos nodos hay en esta posición
            int contador = 0;
            NodoLista temp = actual;
            while (temp != null) {
                contador++;
                temp = temp.siguiente;
            }

            // Si hay más de un nodo, hubo colisión
            if (contador > 1) {
                hayColisiones = true;
                reporte+=("Colisión en índice ") + i+ (":\n");

                while (actual != null) {
                    reporte+=(" - Tripleta: ")+(actual.dato.tripleta)+(" | Frecuencia: ")+(actual.dato.frecuencia)+("\n");
                    actual = actual.siguiente;
                }
                reporte+=("\n");
            }
        }

        if (!hayColisiones) {
            reporte+=("No se detectaron colisiones.\n");
        }

        return reporte.toString();
    }
    
    
    
    public String listarPorAminoacido() {
        StringBuilder resultado = new StringBuilder();

        // Tabla de codones completa (en ARN)
        String[][] codonTable = {
            {"UUU", "Fenilalanina (F)"}, {"UUC", "Fenilalanina (F)"},
            {"UUA", "Leucina (L)"}, {"UUG", "Leucina (L)"},
            {"CUU", "Leucina (L)"}, {"CUC", "Leucina (L)"},
            {"CUA", "Leucina (L)"}, {"CUG", "Leucina (L)"},
            {"AUU", "Isoleucina (I)"}, {"AUC", "Isoleucina (I)"},
            {"AUA", "Isoleucina (I)"}, {"AUG", "Metionina (Inicio)"},
            {"GUU", "Valina (V)"}, {"GUC", "Valina (V)"},
            {"GUA", "Valina (V)"}, {"GUG", "Valina (V)"},
            {"UCU", "Serina (S)"}, {"UCC", "Serina (S)"},
            {"UCA", "Serina (S)"}, {"UCG", "Serina (S)"},
            {"CCU", "Prolina (P)"}, {"CCC", "Prolina (P)"},
            {"CCA", "Prolina (P)"}, {"CCG", "Prolina (P)"},
            {"ACU", "Treonina (T)"}, {"ACC", "Treonina (T)"},
            {"ACA", "Treonina (T)"}, {"ACG", "Treonina (T)"},
            {"GCU", "Alanina (A)"}, {"GCC", "Alanina (A)"},
            {"GCA", "Alanina (A)"}, {"GCG", "Alanina (A)"},
            {"UAU", "Tirosina (Y)"}, {"UAC", "Tirosina (Y)"},
            {"UAA", "STOP (Ocre)"}, {"UAG", "STOP (Ámbar)"},
            {"CAU", "Histidina (H)"}, {"CAC", "Histidina (H)"},
            {"CAA", "Glutamina (Q)"}, {"CAG", "Glutamina (Q)"},
            {"AAU", "Asparagina (N)"}, {"AAC", "Asparagina (N)"},
            {"AAA", "Lisina (K)"}, {"AAG", "Lisina (K)"},
            {"GAU", "Ácido aspártico (D)"}, {"GAC", "Ácido aspártico (D)"},
            {"GAA", "Ácido glutámico (E)"}, {"GAG", "Ácido glutámico (E)"},
            {"UGU", "Cisteína (C)"}, {"UGC", "Cisteína (C)"},
            {"UGA", "STOP (Ópalo)"}, {"UGG", "Triptófano (W)"},
            {"CGU", "Arginina (R)"}, {"CGC", "Arginina (R)"},
            {"CGA", "Arginina (R)"}, {"CGG", "Arginina (R)"},
            {"AGU", "Serina (S)"}, {"AGC", "Serina (S)"},
            {"AGA", "Arginina (R)"}, {"AGG", "Arginina (R)"},
            {"GGU", "Glicina (G)"}, {"GGC", "Glicina (G)"},
            {"GGA", "Glicina (G)"}, {"GGG", "Glicina (G)"}
        };

        // Recorremos la tabla hash
        for (int i = 0; i < tabla.length; i++) {
            NodoLista actual = tabla[i].cabeza;

            while (actual != null) {
                String tripletaADN = actual.dato.tripleta;
                String tripletaARN = tripletaADN.replace('T', 'U'); // Convertir a ARN

                // Buscar en la tabla de codones
                String aminoacido = "No corresponde a un aminoácido";

                for (int j = 0; j < codonTable.length; j++) {
                    if (codonTable[j][0].equals(tripletaARN)) {
                        aminoacido = codonTable[j][1];
                        break;
                    }
                }

                resultado.append("Tripleta: ").append(tripletaADN)
                         .append(" - Aminoácido: ").append(aminoacido)
                         .append(" - Frecuencia: ").append(actual.dato.frecuencia)
                         .append("\n");

                actual = actual.siguiente;
            }
        }

        return resultado.toString();
    }



}
