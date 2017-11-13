
package ejerciciosdatos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author luis03
 * Usaremos la funcion BufferString y sus métodos
 * append(), delete(), reverse() entre otros
 * 
 */

/**
 * 
 * Los casos de prueba se deben ingresar en mayuscula, asi como aparece en el documento de los ejercicios
 * 
 */
public class Palindrome {

    public static String palindrome(String palabra) {
        Scanner l = new Scanner(System.in);
        String mitad, mitad1;
        StringBuffer reverso;
        int longitud;
        boolean esPalindrome, esReverse;
        char[] mirror = new char[128];
        mirror['A'] = 'A';
        mirror['E'] = '3';
        mirror['H'] = 'H';
        mirror['I'] = 'I';
        mirror['J'] = 'L';
        mirror['L'] = 'J';
        mirror['M'] = 'M';
        mirror['O'] = 'O';
        mirror['S'] = '2';
        mirror['T'] = 'T';
        mirror['U'] = 'U';
        mirror['V'] = 'V';
        mirror['W'] = 'W';
        mirror['X'] = 'X';
        mirror['Y'] = 'Y';
        mirror['Z'] = '5';
        mirror['1'] = '1';
        mirror['2'] = 'S';
        mirror['3'] = 'E';
        mirror['5'] = 'Z';
        mirror['8'] = '8';

            longitud = palabra.length();
            esPalindrome = false;
            esReverse = false;

            reverso = new StringBuffer(palabra);
            reverso = reverso.reverse();//reverse() invierte el orden de los caracteres

            if (palabra.equals(reverso.toString())) {
                esPalindrome = true;

                reverso.delete(0, reverso.length());//delete() borra la cadena de caraceres incluidos entre los 2 indices indicados
                //desde la primera posicion hasta la última

                for (int i = 0; i < longitud; i++) {
                    reverso.append(mirror[palabra.charAt(i)]);
                }
                if (palabra.equals(reverso.toString())) {
                    esReverse = true;
                }
                if (esReverse && esPalindrome) {
                    System.out.println("is a mirrored palindrome\n");
                } else if (esPalindrome) {
                    System.out.println("is a regular palindrome\n");
                }
            } else {
                if (longitud % 2 == 0) {
                    longitud /= 2;
                    mitad1 = palabra.substring(longitud);
                } else {
                    longitud = ((longitud - 1) / 2) + 1;
                    mitad1 = palabra.substring(longitud - 1);
                }
                mitad = palabra.substring(0, longitud);
                reverso.delete(0, reverso.length());
                for (int i = 0; i < longitud; i++) {
                    reverso.append(mirror[mitad1.charAt(i)]);
                }
                reverso = reverso.reverse();
                if (reverso.toString().equals(mitad)) {
                    System.out.println("is a mirrored string");
                } else {
                    System.out.println("is not a palindrome");
                }
            }

        return palabra;
    }

    public static void main(String[] args) {
        Scanner l = new Scanner(System.in);
        String palabra="";
        do {
            palabra = l.next();
            palindrome(palabra);
            
        } while (!palabra.equals(""));
        
    }

}
