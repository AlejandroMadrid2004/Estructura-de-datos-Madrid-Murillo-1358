class nodopila(object):
    dato = None
    siguiente = None
    
class Pila(object):    
    def __init__(self):
        self.tope = None
    
    def reiniciar(self):
        self.tope = None
    
    def push(self,dato):
        nodo = nodopila()
        nodo.dato = dato
        nodo.siguiente = self.tope
        self.tope = nodo            

    def pop(self):
        x = self.tope.dato
        nodo_eliminar = self.tope
        self.tope = self.tope.siguiente
        nodo_eliminar.siguiente = None
        return x
    
    def pila_vacia(self):
        return self.tope is None
        
    def tope_pila(self):
        if self.tope is not None:
            return self.tope.dato
        else:
            return None
        
    def imprime(self):
        pila_aux = Pila()
        cadena= ""
        while not self.pila_vacia():
            dato = self.pop()
            cadena += "\n\n" + str(dato) + "\n"
            pila_aux.push(dato)
            
            
        while not pila_aux.pila_vacia():
            dato = pila_aux.pop()
            self.push(dato)
        return cadena