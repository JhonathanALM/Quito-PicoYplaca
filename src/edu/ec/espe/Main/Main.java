package edu.ec.espe.Main;

import java.util.Scanner;

/**
 *
 * @author Jhonathan Lechon
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        boolean op=true;
        do {
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            System.out.println("\t\tPico y Placa");
            System.out.print("Ingrese placa(AAA-000): ");
            String plate = s.next();
            System.out.print("Ingrese fecha(aaaa-MM-dd): ");
            String date = s.next();
            System.out.print("Ingrese tiempo(hh:mm): ");
            String time = s.next();
            Predict pre = new Predict();
            System.out.println(pre.calculateDate(plate, date, time));
            System.out.print("Dese ingresar otra fecha? s/n: ");
            String option = s.next();
            if (!option.toLowerCase().equals("s")) {
                op = false;
            }
        }while (op);
    }

}
