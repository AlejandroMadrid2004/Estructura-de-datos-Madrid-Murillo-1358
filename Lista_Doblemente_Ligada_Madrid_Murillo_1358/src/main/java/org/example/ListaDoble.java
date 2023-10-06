package org.example;

import javax.swing.*;

public class ListaDoble {

    private NodoDoble inicio, fin;

    //Constructor por defecto
    public ListaDoble(){
        inicio = fin = null;
    }

    //Metodo para saber cuando la lista esta vacia
    public boolean estaVacia(){
        return inicio == null;
    }

    //Metodo para agregar nodos al final
    public void agregarAlFinal(int dato) {
        //Verificamos que la lista esta vacia
         if(!estaVacia()){
            fin = new NodoDoble(dato,null,fin);
            fin.anterior.siguiente = fin;
        }else{
             inicio = fin = new NodoDoble(dato);
         }
    }

    //Metodo para agregar al inicio
    public void agregarAlInicio(int dato) {
        //Verificamos que la lista esta vacia
        if(!estaVacia()){
            inicio = new NodoDoble(dato,inicio,null);
            inicio.siguiente.anterior = inicio;
        }else{
            inicio = fin = new NodoDoble(dato);
        }
    }

    //Metodo para mostrar la lista de Inicio a Fin
    public void mostrarListaInicioFin(){
        if(!estaVacia()){
            String datos = "<=>";
            NodoDoble auxiliar = inicio;
            while(auxiliar != null){
                datos = datos + " [ " + auxiliar.dato + " ]<=>";
                auxiliar = auxiliar.siguiente;
            }
            JOptionPane.showMessageDialog(null,datos,"Mostrar Lista de Inicio a Fin",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Metodo para mostrar la Lista de Fin a Inicio
    public void mostrarListaFinInicio(){
        if(!estaVacia()){
            String datos = "<=>";
            NodoDoble auxiliar = fin;
            while(auxiliar != null){
                datos = datos + " [ " + auxiliar.dato + " ]<=>";
                auxiliar = auxiliar.anterior;
            }
            JOptionPane.showMessageDialog(null,datos,"Mostrar Lista de Inicio a Fin",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }

    //Metodo para eliminar del inicio
    public int eliminarDelInicio(){
        int elemento = inicio.dato;
        if (inicio == fin){
            inicio = fin = null;
        }else {
            inicio = inicio.siguiente;
            inicio.anterior = null;
        }
        return elemento;
    }

    //Metodo para eliminar del final
    public int eliminarDelFinal(){
        int elemento = fin.dato;
        if (inicio == fin){
            inicio = fin = null;
        }else {
            fin = fin.anterior;
            fin.siguiente = null;
        }
        return elemento;
    }

}
