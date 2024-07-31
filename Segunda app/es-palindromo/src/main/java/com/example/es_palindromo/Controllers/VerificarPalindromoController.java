package com.example.es_palindromo.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/** A nivel de clase
 * Controlador para Verificar Palíndromos.
 */

@RestController
public class VerificarPalindromoController {

    /** A nivel de método
     * Endpoint para verificar si una palabra es un palíndromo.
     * @param palabra La palabra a verificar.
     * @return Un mensaje indicando si la palabra es un palíndromo o no.
     */

    @GetMapping("/prueba/{palabra}")
    public String verificarPalindromo(@PathVariable String palabra) {
        String palabraNormalizada = normalizar(palabra);
        boolean esPalindromo = isPalindrome(palabraNormalizada);
        return palabra + (esPalindromo ? " es  un palíndromo." : " NO es un palíndromo.");
    }

    private boolean esPalindromo(String palabra) {
        palabra = palabra.toLowerCase();
        String palabraInvertida = new StringBuilder(palabra).reverse().toString();
        return palabra.equals(palabraInvertida);
    }

    //----------------OTRA ALTERNATIVA:------------------

    /**
     * Metodo para limpiar la palabra ingresada para evitar errores. El metodo lo convierte a minuscula y elimina los caracteres especiales.
     * @param palabra
     * @return
     */
    private String normalizar(String palabra) {
        return palabra.toLowerCase().replaceAll("[^a-z]", "");
    }

    private boolean isPalindrome(String palabra) {
        int longitudPalabra = palabra.length();
        for (int i = 0; i < longitudPalabra / 2; i++) {
            if (palabra.charAt(i) != palabra.charAt(longitudPalabra - i - 1)) {
                return false;
            }
        }
        return true;
    }
}