package org.example;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {

        ListaDoble listita = new ListaDoble();
        int opcion = 0;
        int elemento;

        do{
            try{
                opcion = Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Agregar un nodo al inicio\n"
                + " 2. Agregar un nodo al Final \n"
                + " 3. Mostrar la lista de inicio a fin \n"
                + " 4. Mostrar la lista de Fin a inicio\n"
                + " 5. Eliminar un nodo del inicio\n"
                + " 6. Eliminar un nodo del final\n"
                + " 7. SALIR\n"
                + " Que deseas Hacer?", "Menú de Opciones",
                        JOptionPane.INFORMATION_MESSAGE));
                switch(opcion){
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del Nodo", "Agregando Nodos al Inicio",
                                JOptionPane.INFORMATION_MESSAGE));
                        listita.agregarAlInicio(elemento);
                        break;
                    case 2:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento del Nodo", "Agregando Nodos al Final",
                                JOptionPane.INFORMATION_MESSAGE));
                        listita.agregarAlFinal(elemento);
                        break;
                    case 3:
                        if(!listita.estaVacia()){
                            listita.mostrarListaInicioFin();
                        }else{
                            JOptionPane.showMessageDialog(null,"Aun no hay nodos",
                                    "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 4:
                        if(!listita.estaVacia()){
                            listita.mostrarListaFinInicio();
                        }else{
                            JOptionPane.showMessageDialog(null,"Aun no hay nodos",
                                    "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 5:
                       if(!listita.estaVacia()){
                           elemento = listita.eliminarDelInicio();
                           JOptionPane.showMessageDialog(null,"El elemento eliminado es " + elemento,
                                   "Eliminando Nodo del Inicio", JOptionPane.INFORMATION_MESSAGE);
                       }else{
                           JOptionPane.showMessageDialog(null,"Aun no hay nodos",
                                   "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                       }
                        break;
                    case 6:
                        if(!listita.estaVacia()){
                            elemento = listita.eliminarDelFinal();
                            JOptionPane.showMessageDialog(null,"El elemento eliminado es " + elemento,
                                    "Eliminando el nodo del final", JOptionPane.INFORMATION_MESSAGE);
                        }else{
                            JOptionPane.showMessageDialog(null,"Aun no hay nodos",
                                    "Lista Vacia", JOptionPane.INFORMATION_MESSAGE);
                        }
                        break;
                    case 7:
                        JOptionPane.showMessageDialog(null,"Aplicación finalizada",
                                "Fin", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "La Opcion no esta en el menu",
                                "Incorrecto", JOptionPane.INFORMATION_MESSAGE);
                }

            }catch(NumberFormatException n){
                JOptionPane.showMessageDialog(null, "Error " + n.getMessage());
            }
        }while(opcion!=7);
    }
}