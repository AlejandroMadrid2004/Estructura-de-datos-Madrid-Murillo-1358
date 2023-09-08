package org.example;

import java.awt.geom.NoninvertibleTransformException;
import java.util.Arrays;

public class Fila {
    int tamanio;
    int[] cuerpo = new int [tamanio];
    int ultimo = 0;

    public Fila() {
    }

    public Fila(int[] cuerpo, int tamanio, int ultimo) {
        this.cuerpo = cuerpo;
        this.tamanio = tamanio;
        this.ultimo = ultimo;
    }

    public int[] getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(int[] cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public int getUltimo() {
        return ultimo;
    }

    public void setUltimo(int ultimo) {
        this.ultimo = ultimo;
    }

    @Override
    public String toString() {
        return "Fila{" +
                "tamanio=" + tamanio +
                ", cuerpo=" + Arrays.toString(cuerpo) +
                ", ultimo=" + ultimo +
                '}';
    }

    public boolean vacia() {
        if (ultimo == 0) {
            return true;
        }else{
            return false;
        }
    }

    public boolean llena(){
        if(ultimo == tamanio){
            return true;
        }else{
            return false;
        }
    }

    public void push(int a){
        if(llena() == true){
            cuerpo[ultimo] = a;
            ultimo =+ 1;
        }else{
            System.out.println("La Pila esta llena.");
        }
    }

    public int pop(int porquex){

        if(vacia()){
            porquex = cuerpo[ultimo -1];
            return porquex;
        }else {
            System.out.println("La pila esta vacia");
            return porquex;
        }
    }

}
