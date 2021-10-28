/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hind;

import java.util.Scanner;

/**
 *
 * @author hinda
 */
public class Parte1 {

    public static void main(String[] args) {

        //declaracion y initializacion variables
        int consumoAparato;
        String opcion;
        double horasFuncion, precioKwh, totalConsumacionKw, totalCastadoAparato;
        //CONSTANTES
        int KW = 1000;

        //pedir datos
        Scanner sc = new Scanner(System.in);

        do {
             
            //si el valor introducido no entre el rango se repite la instruccion hasta que el usuario Introduce valor valido entre 1 y 4500
            do {
                System.out.println("Introducir el consumo del aparto en Wh");
                consumoAparato = sc.nextInt();
                
            } while (consumoAparato < 1 || consumoAparato > 4500);
            
            //pedir las horas
           do {
                System.out.println("Introducir las horas que esta funcionando al dia");
                horasFuncion = sc.nextDouble();
                
            } while (horasFuncion<=0 || horasFuncion > 24);

            //controlar el valor del precio que debe ser entre 0.1 y 0.45 
            do {
                System.out.println("Introducir el precio del kWh entre 0.1 y 0.45");
                precioKwh = sc.nextDouble();
                
            } while (precioKwh < 0.1 || precioKwh > 0.45);

            //calcular el total de consumo en Kw devido el consumo per horas/1000 para convertirlo a kw porque el consumo en Wh
            totalConsumacionKw = (consumoAparato * horasFuncion) / KW;
            totalCastadoAparato = totalConsumacionKw * precioKwh; // el resulta del total de castado es total consumo multiplicando por precio

            // usando printf para limitar la salida en 2 decimales
            System.out.printf("Entonces el Aparato ha gastado %.2f\n", totalCastadoAparato);

            System.out.println("escribe S se quieres realisar el programa y N si quieres salir ");
            opcion = sc.next();
            
           
            if(!(opcion.equalsIgnoreCase("s")) && (opcion.equalsIgnoreCase("n"))){
                System.out.println("error");
            }
          
        } while (!opcion.equalsIgnoreCase("n"));

        System.out.println("Finalizar");
    }
}
