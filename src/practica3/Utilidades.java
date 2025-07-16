/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author JOSE SALAZAR
 */
public class Utilidades {
    private String path = "Casa.data";
    public void save(String text, String name_file) throws IOException{
        FileWriter file = new FileWriter(path + File.separatorChar + name_file, true);
        file.write(text);
        file.close();
    }
     private int countRegister(String name_file) throws IOException {
        FileReader file = new FileReader(path + File.separatorChar + name_file);
        BufferedReader br = new BufferedReader(file);
        int lines = (int) br.lines().count();
        file.close();
        br.close();
        return lines;
    }

   private int countColum(String name_file) throws IOException {
    FileReader file = new FileReader(path + File.separatorChar + name_file);
    BufferedReader br = new BufferedReader(file);
    String line = br.readLine();

    while (line != null && line.trim().isEmpty()) {
        line = br.readLine(); // saltar líneas vacías
    }

    int columns = 0;
    if (line != null) {
        columns = line.split("\t").length;
    }
    br.close();
    file.close();
    return columns;
}

     public String[][] listAll(String name_file) throws IOException {
    String[][] data = null;
    Integer filas = countRegister(name_file);
    if (filas > 0) {
        Integer col = countColum(name_file);
        data = new String[filas][col];
        FileReader file = new FileReader(path + File.separatorChar + name_file);
        BufferedReader br = new BufferedReader(file);
        String linea = br.readLine();
        int fil = 0;
        while (linea != null) {
            String[] columnas = linea.split("\t");
            if (columnas.length == col) {  // Validar que tenga la cantidad esperada de columnas
                for (int j = 0; j < columnas.length; j++) {
                    data[fil][j] = columnas[j];
                }
                fil++;
            } else {
                System.out.println("Línea con formato inválido ignorada: " + linea);
            }
            linea = br.readLine();
        }
        file.close();
        br.close();

        // Si hubo líneas inválidas, ajustar tamaño del arreglo
        if (fil < filas) {
            String[][] temp = new String[fil][col];
            System.arraycopy(data, 0, temp, 0, fil);
            data = temp;
        }
    }
    return data;
}
     
     public boolean numeroPrimo(int n){
        if (n <= 1) return false;
        if (n == 2) return true;
        if (n % 2 == 0) return false;
        for (int i = 3; i <= Math.sqrt(n); i += 2)
            if (n % i == 0) return false;
        return true;
    }
}

