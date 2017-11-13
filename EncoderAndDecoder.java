/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosdatos;

/**
 *
 * @author luis03
 */
import java.util.Scanner;

public class EncoderAndDecoder {

    /**
     * 
     * @param palabra
     * @return 
     */
    public static String encriptar(String palabra) {
        char contenedor[] = palabra.toCharArray();//declaramos un arreglo que contendra la palabra
        char aux;
        for (int i = 0; i < palabra.length() / 2; i++) {//recorremos la palabra
            aux = contenedor[i];//asignamos a aux el valor de contenedor
            contenedor[i] = contenedor[palabra.length() - i - 1];
            contenedor[palabra.length() - i - 1] = aux;
        }
        palabra = "";

        for (int i = 0; i < contenedor.length; i++) {//recorremos el contenedor
            palabra += contenedor[i];//asignamos cada letra o numero a palabra
        }
        return palabra;//retornamos los caracteres convertidos
    }

    public static void descodificar(String descodificado) {//método para descodificar 
        descodificado = encriptar(descodificado);//encry convierte los numeros a su simbolo ascii correspondiente
        String palabra = "";
        for (int i = 1; i < descodificado.length(); i += 2) {//recorremos la palabra o el numero
            int aux = Integer.parseInt(descodificado.charAt(i - 1) + "" + descodificado.charAt(i));//convertimos los caracteres a enteros

            palabra += ((char) ((aux >= 100) ? aux - 43 : aux));//evaluamos la palabra
        }
        System.out.println(palabra);//imprimimos la palabra
    }

    public static void codificar(String codificado) {//metodo para codificar
        String aux = "";
        for (int i = 0; i < codificado.length(); i++) {//leemos el parametro
            aux += codificado.codePointAt(i);//a cada caracter lo convertimos a su número correspondiente en ascii
        }
        System.out.println(encriptar(aux));//imprimimos
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        String palabra;

        do {
            palabra = l.next();
            if (Character.isDigit(palabra.charAt(0))) {
                descodificar(palabra);
            } else {
                codificar(palabra);
            }
        } while (!palabra.equals(""));
    }
}
