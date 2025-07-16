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
public class Laberintocontroller {
    private static final String entrada= "E";
    private static final String  salida= "S";
    private static final String muros= "x";
    private static final String caminos= "";

    private Random random;

    public Laberintocontroller(){
        this.random = new Random();
    }

    public String[][] generarLaberinto(int dimension) throws IllegalArgumentException {
        if (dimension < 10 || dimension > 100) {
            throw new IllegalArgumentException("La dimensión debe estar entre 10 y 100");
        }
        double porcentajeMuros = calcularMuros();
        String[][] laberinto = new String[dimension][dimension];
        llenarCaminos(laberinto);
        colocarMuros(laberinto, porcentajeMuros);
        colocarEntradaySalida(laberinto);

        return laberinto;
    }

    private double calcularMuros() {
        double porcentaje = 40 + (random.nextDouble() * 20);
        return porcentaje / 100.0;
    }
    private void llenarCaminos(String[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                laberinto[i][j] = caminos;
            }
        }
    }

    private void colocarMuros(String[][] laberinto, double porcentajeMuros) {
        int dimension = laberinto.length;
        int totalCeldas = dimension * dimension;
        int numeroMuros = (int) (totalCeldas * porcentajeMuros);

        int murosColocados = 0;

        while (murosColocados < numeroMuros) {
            int fila = random.nextInt(dimension);
            int columna = random.nextInt(dimension);

            if (laberinto[fila][columna].equals(caminos)) {
                laberinto[fila][columna] = muros;
                murosColocados++;
            }
        }
    }

    private void colocarEntradaySalida(String[][] laberinto) {
        int dimension = laberinto.length;
        boolean entradaColocada = false;
        int intentosEntrada = 0;
        while (!entradaColocada && intentosEntrada < 100) {
            int filaEntrada = 0; 
            int columnaEntrada = random.nextInt(dimension);

            if (!laberinto[filaEntrada][columnaEntrada].equals(muros)) {
                laberinto[filaEntrada][columnaEntrada] = entrada;
                entradaColocada = true;
            } else {

                laberinto[0][0] = entrada;
                entradaColocada = true;
            }
            intentosEntrada++;
        }

        boolean salidaColocada = false;
        int intentosSalida = 0;

        while (!salidaColocada && intentosSalida < 100) {
            int filaSalida = dimension - 1;
            int columnaSalida = random.nextInt(dimension);

            if (!laberinto[filaSalida][columnaSalida].equals(muros)
                    && !laberinto[filaSalida][columnaSalida].equals(entrada)) {
                laberinto[filaSalida][columnaSalida] = salida;
                salidaColocada = true;
            } else {
                laberinto[dimension - 1][dimension - 1] = salida;
                salidaColocada = true;
            }
            intentosSalida++;
        }
    }
}
