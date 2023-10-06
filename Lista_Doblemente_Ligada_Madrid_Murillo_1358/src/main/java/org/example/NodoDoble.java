package org.example;

public class NodoDoble {
    public int dato;
    //Creamos los punteros
    NodoDoble siguiente,anterior;

    //Constructor para cuando aun no hay nodos
    public NodoDoble(int elemento){
        this(elemento,null,null);
    }

    //Constructor para cuando ya hay nodos
    public NodoDoble(int elemento, NodoDoble puntero, NodoDoble punteroAnterior){
        dato = elemento;
        siguiente = puntero;
        anterior = punteroAnterior;
    }




}
