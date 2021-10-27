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
public class Parte2 {

    public static void main(String[] args) {
        //declaracion y initializacion variables
        int consumoAparato, opcion;
        double horasPunta, horasLlanas, horasValle, totalConsumacionHorasPunta, totalConsumacionHorasLlanas, totalConsumacionHorasValle, totalCastadoAparato,
                precioHorasPunta, precioHorasLlanas, precioHorasValle;
        //CONSTANTES
        int KW = 1000;

        //pedir datos
        Scanner sc = new Scanner(System.in);

        do {
            //para controlar si el usuario quiere salir o continuar
            System.out.println("escribe 1 se quieres realisar el programa y 2 si quieres salir ");
            opcion = sc.nextInt();

            if (opcion == 1) {//repite el programa hasta que el usario quiere salir y entra 2
                //si el valor introducido no entre el rango se repite la instruccion hasta que el usuario Introduce valor valido entre 1 y 4500
                do {
                    System.out.println("Introducir el consumo del aparto en Wh");
                    consumoAparato = sc.nextInt();
                } while (consumoAparato < 1 || consumoAparato > 4500);

                //pedir las horas puntas,llanas y valle
                do {
                    System.out.println("Introducir cuántas horas está funcionando el aparato en horas punta: ");
                    horasPunta = sc.nextDouble();

                    System.out.println("Introducir cuántas horas está funcionando el aparato en horas llans: ");
                    horasLlanas = sc.nextDouble();

                    System.out.println("Introducir cuántas horas está funcionando el aparato en horas valle: ");
                    horasValle = sc.nextDouble();
                } while (horasPunta > 24 || horasLlanas > 24 || horasValle > 24);

                //controlar el valor del precio que debe ser entre 0.1 y 0.45 
                do {
                    System.out.println("-----------Introducir el precio del kWh entre 0.1 y 0.45------------");
                    //contralar que el precioPunto seria el mas caro y despues precio de horas llanas y despues de horas valles si no se repete pedir datos
                    do {
                        System.out.println("Introducir el precio de horas punta");
                        precioHorasPunta = sc.nextDouble();

                        System.out.println("Introducir el precio de horas llanas");
                        precioHorasLlanas = sc.nextDouble();

                        System.out.println("Introducir el precio de horas valle");
                        precioHorasValle = sc.nextDouble();

                    } while (precioHorasValle > precioHorasLlanas || precioHorasValle > precioHorasPunta || precioHorasLlanas > precioHorasPunta);

                } while ((precioHorasPunta < 0.1 && precioHorasLlanas < 0.1 && precioHorasValle < 0.1) || (precioHorasPunta > 0.45 && precioHorasLlanas > 0.45 && precioHorasValle > 0.45));

                //calcular el total de consumo,calculamos el total de consumo de cada tipo de horas y despues hacemos la suma
                totalConsumacionHorasPunta = ((consumoAparato * horasPunta) / KW * precioHorasPunta);
                totalConsumacionHorasLlanas = ((consumoAparato * horasLlanas) / KW * precioHorasLlanas);
                totalConsumacionHorasValle = ((consumoAparato * horasValle) / KW * precioHorasValle);

                totalCastadoAparato = totalConsumacionHorasPunta + totalConsumacionHorasLlanas + totalConsumacionHorasValle;

                System.out.printf("Entonces el Aparato ha gastado %.2f\n ", totalCastadoAparato - 0.005);

            } else {
                System.out.println("-------------------------------------");
                System.out.println("Finalizar");

            }

        } while (opcion != 2);

    }
}
