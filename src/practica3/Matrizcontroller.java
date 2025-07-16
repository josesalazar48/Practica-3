/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

import java.util.Random;

/**
 *
 * @author JOSE SALAZAR
 */
public class Matrizcontroller {
    Utilidades u = new Utilidades();
    Random r = new Random();
    public int[][] matrizNumeros(int filas, int columnas) {
        int[][] matriz = new int[filas][columnas];
        int valor = 1;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                matriz[i][j] = r.nextInt(100)+1;
            }
        }

        return matriz;
    }
    public Object[][] eliminarNumero(int[][] matriz, int numeroAEliminar) {
        Object[][] nuevaMatriz = new Object[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (matriz[i][j] == numeroAEliminar) {
                    nuevaMatriz[i][j] = "*";
                } else {
                    nuevaMatriz[i][j] = matriz[i][j];
                }
            }
        }

        return nuevaMatriz;
    }
      public Object[][] eliminarPrimos(int[][] matriz) {
        Object[][] nuevaMatriz = new Object[matriz.length][matriz[0].length];

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                if (u.numeroPrimo(matriz[i][j])) {
                    nuevaMatriz[i][j] = "*";
                } else {
                    nuevaMatriz[i][j] = matriz[i][j];
                }
            }
        }

        return nuevaMatriz;
    }
}

