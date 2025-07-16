/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica3;

import java.io.IOException;

/**
 *
 * @author JOSE SALAZAR
 */
public class Casacontroller {
   Utilidades u = new Utilidades();
   private String file_name = "Casa.data";
   public boolean registroCasa(int nrocasa,String barrio, float largo, float ancho, int pisos){
       String data = nrocasa+"\t"+barrio+"\t"+largo+"\t"+ancho+"\t"+pisos+"\n";
       try {
           u.save(data, file_name);
           return true;
       } catch (Exception e) {
           System.out.println(e);
           return false;
       }
   }
   public String [][] listar(){
       try {
           return u.listAll(file_name);
       } catch (IOException e) {
           System.out.println("Hubo un error en listar");
           return null;
       }
   }
   public String numerarCasas(){
       String numeral = "001";
       String[][] listado = listar();
       if(listado != null){
           Integer numero = listado.length +1;
           numeral = "000";
           numeral = numeral.substring(numero.toString().length())+numero.toString();
       }else{
           numeral = "001";
       }
       return numeral;
   }
   public boolean esHomonima(int posicion,int pisos, float largo, float ancho) {
    String[][] casas = listar();
    if (casas != null) {
        for (int i = 0; i < casas.length; i++) {
            if (i != posicion) { // Ignorar la casa que estamos evaluando
                int pi = Integer.parseInt(casas[i][4]);
                float lar = Float.parseFloat(casas[i][2]);
                float an = Float.parseFloat(casas[i][3]);

                if (pi == pisos && lar == largo && an == ancho) {
                    return true; 
                }
            }
        }
    }
    return false;
}
}
