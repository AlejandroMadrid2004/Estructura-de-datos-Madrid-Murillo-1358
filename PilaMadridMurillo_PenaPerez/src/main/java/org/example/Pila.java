package org.example;
import java.util.Scanner;
import java.util.Arrays;

public class Pila {

   Scanner scanner = new Scanner(System.in);
    int tamanio;
    int ultimo;
    int cuerpo[];
    int push;
    int pop;
    int a;

    public Pila() {
        tamanio = 0;
    }

    public Pila(int tamanio, int ultimo, int[] cuerpo, int push, int pop) {
        this.tamanio = tamanio;
        this.ultimo = ultimo;
        this.cuerpo = cuerpo;
        this.push = push;
        this.pop = pop;
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

    public int[] getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(int[] cuerpo) {
        this.cuerpo = cuerpo;
    }

    public int getPush() {
        return push;
    }

    public void setPush(int push) {
        this.push = push;
    }

    public int getPop() {
        return pop;
    }

    public void setPop(int pop) {
        this.pop = pop;
    }

    @Override
    public String toString() {
        return "Pila{" +
                "tamanio=" + tamanio +
                ", ultimo=" + ultimo +
                ", cuerpo=" + Arrays.toString(cuerpo) +
                ", push=" + push +
                ", pop=" + pop +
                '}';
    }



    public void push(int push){
        for (int i = 0; i < cuerpo.length; i++){
            System.out.println("Ingrese un valor para la pila: ");
            push = scanner.nextInt();

        }
    }

    public int pop(){
        for(int i = 0; i < cuerpo.length; i++){
            if (cuerpo[ultimo -1] == 0){
                cuerpo[i]-=1;
            }
        }
        return ultimo;
    }

    boolean llena(){
        if(ultimo == 0){
            return true;
        }
    return false;
    }

    boolean vacia(){
        if(ultimo == 0){
            return true;
        }
        else{
            return false;
        }
    }

}