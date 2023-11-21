#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Tue Nov 21 16:39:16 2023

@author: saraveronicamurillohernandez
"""

class Nodo:
    def __init__(self, valor):
        self.valor = valor
        self.izquierdo = None
        self.derecho = None

    def agregar_hijo(self, hijo):
        if hijo.valor < self.valor:
            if self.izquierdo is None:
                self.izquierdo = hijo
            else:
                self.izquierdo.agregar_hijo(hijo)
        else:
            if self.derecho is None:
                self.derecho = hijo
            else:
                self.derecho.agregar_hijo(hijo)

    def obtener_valores(self):
        valores = []
        if self.izquierdo:
            valores += self.izquierdo.obtener_valores()
        valores.append(self.valor)
        if self.derecho:
            valores += self.derecho.obtener_valores()
        return valores
    
    def bfs(raiz):
        cola = [raiz]
        while cola:
            nodo = cola.pop(0)
            print(nodo.valor, end=" ")
            if nodo.izquierdo:
                cola.append(nodo.izquierdo)
            if nodo.derecho:
                cola.append(nodo.derecho)
               
    def dfs(raiz):
        pila = [raiz]
        while pila:
            nodo = pila.pop()
            print(nodo.valor, end=" ")
            if nodo.derecho:
                pila.append(nodo.derecho)
            if nodo.izquierdo:
                pila.append(nodo.izquierdo)           
               
    