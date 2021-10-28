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
                precioHorasPunta, precioHorasLlanas, precioHorasValle, horasfuncion;
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

                    do {
                        System.out.println("Introducir cuántas horas está funcionando el aparato en horas llans: ");
                        horasLlanas = sc.nextDouble();
                        if (horasLlanas >= horasPunta || horasPunta + horasLlanas > 24) {
                            System.out.println("Error.Introduce otravez la horas llanas tienen que ser menos que horas punta");
                        }

                    } while (horasLlanas >= horasPunta || horasPunta + horasLlanas > 24);

                    do {

                        System.out.println("Introducir cuántas horas está funcionando el aparato en horas valle: ");
                        horasValle = sc.nextDouble();
                        if (horasValle >= horasLlanas || horasValle >= horasPunta) {
                            System.out.println("Error.Introduce otravez la horaValle tiene que ser menos que horas llanas y horas valle");
                        }

                    } while (horasValle >= horasLlanas || horasValle >= horasPunta);

                    horasfuncion = horasValle + horasLlanas + horasPunta;

                    if (horasfuncion <= 0 || horasfuncion > 24) {
                        System.out.println("Error las horas tienen que ser mas que 0 y menos que 24h");
                    }
                } while (horasfuncion <= 0 || horasfuncion > 24);

                //controlar el valor del precio que debe ser entre 0.1 y 0.45 
                System.out.println("-----------Introducir el precio del kWh entre 0.1 y 0.45------------");
                //contralar que el precioPunto seria el mas caro y despues precio de horas llanas y despues de horas valles si no se repete pedir datos

                do {
                    System.out.println("Introducir el precio de horas punta");
                    precioHorasPunta = sc.nextDouble();
                    if (precioHorasPunta < 0.1 || precioHorasPunta > 0.45) {
                        System.out.println("el precio tiene que estar entre 0.1 y 0.45");
                    }
                } while (precioHorasPunta < 0.1 || precioHorasPunta > 0.45);

                do {
                    System.out.println("Introducir el precio de horas llanas");
                    precioHorasLlanas = sc.nextDouble();
                    if (precioHorasLlanas > precioHorasPunta) {
                        System.out.println("Error.el precio de horas llanas tiene que ser menos que de horas puntas");
                    }
                } while (precioHorasLlanas > precioHorasPunta || precioHorasLlanas < 0.1 || precioHorasLlanas > 0.45);

                do {
                    System.out.println("Introducir el precio de horas valle");
                    precioHorasValle = sc.nextDouble();
                    if (precioHorasValle > precioHorasLlanas || precioHorasValle > precioHorasPunta || precioHorasValle < 0.1 || precioHorasValle > 0.45) {
                        System.out.println("Error.el precio tiene que ser menos del horas llanas y horas punta y entre 0.1 y 0.45");
                    }

                } while (precioHorasValle > precioHorasLlanas || precioHorasValle > precioHorasPunta || precioHorasValle < 0.1 || precioHorasValle > 0.45);

                //calcular el total de consumo,calculamos el total de consumo de cada tipo de horas y despues hacemos la suma
                totalConsumacionHorasPunta = ((consumoAparato * horasPunta) / KW * precioHorasPunta);
                totalConsumacionHorasLlanas = ((consumoAparato * horasLlanas) / KW * precioHorasLlanas);
                totalConsumacionHorasValle = ((consumoAparato * horasValle) / KW * precioHorasValle);

                totalCastadoAparato = totalConsumacionHorasPunta + totalConsumacionHorasLlanas + totalConsumacionHorasValle;

                System.out.printf("Entonces el Aparato ha gastado %.2f\n ", totalCastadoAparato);

            } else if (opcion != 1 && opcion != 2) {
                System.out.println("Error.introduce opcion valida");
            } else {
                System.out.println("-------------------------------------");
                System.out.println("Finalizar");
            }

        } while (opcion != 2);

    }
}
