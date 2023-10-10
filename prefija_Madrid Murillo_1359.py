from pila import Pila

def es_operador(caracter):
    return caracter in ["(",")","^","*","/","+","-"]

def prioridad(caracter):
    if caracter in ["^"]:
        x = 3
    elif caracter in ["*", "/"]:
        x = 2
    elif caracter in ["+", "-"]:
        x = 1
    else:
        x = 0
    return x 

pila_operandos = Pila()
pila_operadores = Pila()

cadena = input("Expresión: ")

for caracter in cadena:
    if not es_operador(caracter):
        pila_operandos.push(caracter)
    else:
        if caracter in ["("]:
            pila_operadores.push(caracter)
        elif caracter in [")"]:
            while(not pila_operadores.pila_vacia() and pila_operadores.tope_pila() not in ["("]):
                operando2 = pila_operandos.pop()
                operando1 = pila_operandos.pop()
                operador = pila_operadores.pop()
                nuevo_operando = ""+operador+operando1+operando2
                pila_operandos.push(nuevo_operando)
            operador = pila_operadores.pop()
        else:
            while(not pila_operadores.pila_vacia() and prioridad(caracter) <= prioridad(pila_operadores.tope_pila())):
                operando2 = pila_operandos.pop()
                operando1 = pila_operandos.pop()
                operador = pila_operadores.pop()
                nuevo_operando = "" + operador + operando1 + operando2
                pila_operandos.push(nuevo_operando)
            pila_operadores.push(caracter)


while(not pila_operadores.pila_vacia()):
    operando2 = pila_operandos.pop()
    operando1 = pila_operandos.pop()
    operador = pila_operadores.pop()
    nuevo_operando = ""+operador+operando1+operando2
    pila_operandos.push(nuevo_operando)
    
expresion = pila_operandos.pop()

print("La expresión en prefijo es. ", expresion)    

def resolv_exp(expresion):
    pila_operandos = Pila(10)
    pila_operadores = Pila(10)
    for c in expresion:
        if (c in "+*/-"):
            b = Pila.pop()      
            a = Pila.pop()
            if c == '+':
                pila_operandos.push(a+b)
                     
            if c == '-':
                pila_operandos.push(a-b)
         
            if c == '*':
                pila_operandos.push(a*b)
         
            if c == '/':
                pila_operandos.push(a/b)
          
    for c in expresion:
        if(c in "0123456789"):
            Pila.push(float(c))
            return pila_operadores.pop()    
             
         
        exp1 = expresion
        print(resolv_exp(exp1))    
      