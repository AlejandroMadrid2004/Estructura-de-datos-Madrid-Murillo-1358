#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
Created on Fri Nov  3 13:44:13 2023

@author: saraveronicamurillohernandez
"""

class Diccionario:
    def __init__(self):
        self.tamanioTabla = 16
        self.claves = []
        self.valores = []
        self.tablaHash = []
        for i in range(self.tamanioTabla):
            self.tablaHash.append(None)

    def funcionHash(self, clave, nuevoTamanio=0):
        if nuevoTamanio == 0:
            return hash(clave) % self.tamanioTabla
        else:
            return hash(clave) % nuevoTamanio

    def agregar(self, clave, valor):
        if self.tablaHash[self.funcionHash(clave)] is None:
            self.tablaHash[self.funcionHash(clave)] = valor
            self.claves.append(clave)
            self.valores.append(valor)
        else:
            if self.verificaClave(clave):
                self.valores.remove(self.tablaHash[self.funcionHash(clave)])
                self.tablaHash[self.funcionHash(clave)] = valor
                self.valores.append(valor)
            else:
                while not self.tablaHash[self.funcionHash(clave)] is None:
                    self.duplicaTamanio()
                self.tablaHash[self.funcionHash(clave)] = valor
                self.claves.append(clave)
                self.valores.append(valor)

    def duplicaTamanio(self):
        nuevaTabla = []
        for i in range(self.tamanioTabla * 2):
            nuevaTabla.append(None)
        for c in self.claves:
            nuevaTabla[self.funcionHash(c, self.tamanioTabla * 2)] = self.tablaHash[self.funcionHash(c)]
        self.tamanioTabla *= 2
        self.tablaHash = nuevaTabla

    def verificaClave(self, clave):
        for c in self.claves:
            if type(c) == type(clave):
                if c == clave:
                    return True
        return False

    def borrar(self, clave):
        if self.verificaClave(clave):
            indice = self.claves.index(clave)
            self.claves.remove(clave)
            self.valores.remove(self.tablaHash[self.funcionHash(clave)])
            self.tablaHash[self.funcionHash(clave)] = None
        else:
            print("Clave no encontrada")

    def limpiar(self):
        self.tablaHash = []
        self.claves = []
        self.valores = []
        for i in range(self.tamanioTabla):
            self.tablaHash.append(None)

    def consultar(self, clave):
        if self.verificaClave(clave):
            return self.tablaHash[self.funcionHash(clave)]
        else:
            print("Clave no encontrada")
            return None