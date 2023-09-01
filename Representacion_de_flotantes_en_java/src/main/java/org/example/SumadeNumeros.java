package org.example;

/*Integrantes:
-Madrid Murillo José Alejandro
-Peña Perez Miguel Angel
-Carrillo Campos Luis Fernando

Grupo: 1358
*/

public class SumadeNumeros {

    public static void main(String[] args) {

        String numero1 = "0 1000000 110000000000";
        String numero2 = "1 1000000 101000000000";

        double sumar = sumaBinaria(numero1, numero2);
        System.out.println("Suma binaria: " + sumar);

    }

        public static double sumaBinaria(String numero1, String numero2){
            //Parsear los componentes del primer número binario
            int signo1 = Character.getNumericValue(numero1.charAt(0));
            int exponente1 = Integer.parseInt(numero1.substring(2,10),2);
            double matisa1 = 1 + binarioaDecimal(numero1.substring(11));

            //Parsear los componentes del segundo número binario
            int signo2 = Character.getNumericValue(numero1.charAt(0));
            int exponente2 = Integer.parseInt(numero1.substring(2,10),2);
            double matisa2 = 1 + binarioaDecimal(numero1.substring(11));

            //Igualamos los exponentes
            int igExponente = Math.max(exponente1,exponente2);
            matisa1 = ajustarMatisa(matisa1,exponente1,igExponente);
            matisa2 = ajustarMatisa(matisa2,exponente2,igExponente);

            //Sumamos las matisas considerando el signo usando OR (|)
            double resultadoMatisa = (signo1 == 0 ? 1 : -1) * matisa1 + (signo2 == 0 ? 1 : -1) * matisa2;

            //Ajustamos las matisas y el exponente después de la suma
            int resultadoExponente = igExponente + 1;
            resultadoMatisa = igualarMatisa(resultadoMatisa, resultadoExponente);

            //Combinar los componentes para obtener el resultado final
            long signoResultante = resultadoMatisa >= 0 ? 0 : 1;
            String resultadoBinario = signoResultante + " " + Integer.toBinaryString(resultadoExponente) + " " + decimalaBinario(resultadoMatisa);


            return parseBinarioFlotante(resultadoBinario);



        }
            //Metodos para completar el código

                //Binario a Decimal

                public static double binarioaDecimal (String binario){
                    double decimal = 0.0;
                    for(int i = 0; i < binario.length(); i++){
                        if(binario.charAt(i) == '1'){
                            decimal += 1.0 / Math.pow(2, i + 1);
                        }
                    }
                    return decimal;
                }

                public static double ajustarMatisa(double matisa, int exponenteActual, int exponenteSeleccionado){
                    return matisa * Math.pow(2, exponenteSeleccionado - exponenteActual);
                }

                public static double igualarMatisa(double matisa, int exponente){
                    while(Math.abs(matisa) >= 2){
                        matisa /= 2;
                        exponente++;
                    }
                    return matisa;
                }

                public static String decimalaBinario(double decimal){
                    StringBuilder binario = new StringBuilder();
                    while(decimal > 0){
                        decimal *= 2;
                        binario.append((int) decimal);
                        if(decimal >= 1){
                            decimal -= 1;
                        }
                    }
                    return binario.toString();
                }

                public static double parseBinarioFlotante(String numero){
                    String [] componentes = numero.split(" ");
                    int signo = Integer.parseInt(componentes[0]);
                    int exponente = Integer.parseInt(componentes[1],2);
                    double matisa = 1 + binarioaDecimal(componentes[2]);
                    return (signo == 0 ? 1 : -1) * matisa * Math.pow(2,exponente -1);
                }
        }







