package lad.com.alura.conversormoneda;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Conversor {
    public void eleccionMenu() {
        Scanner entradamoneda = new Scanner(System.in);
        int opciones = 0;

        String menu = """
                ***************************************************
                Elige la opción que quieras realizar la conversión:
                1. USD --> EUR
                2. EUR --> USD
                3. USD --> MXN
                4. BRL --> USD
                5. USD --> BRL
                6. ARG --> USD
                7. USD --> ARG
                8. SALIR
                ***************************************************
                """;

        while (opciones != 8) {
            System.out.println(menu);
            try {
                opciones = entradamoneda.nextInt();
                entradamoneda.nextLine();

                if (opciones == 8) {
                    System.out.println("Saliendo del programa...");
                    break;
                }

                TipoConversion variable = TipoConversion.recorrerConversion(opciones);

                if (variable != null) {
                    System.out.println("Has seleccionado: " + variable.getDescripcion());
                    System.out.print("Ingresa el monto a convertir: ");

                    double monto = entradamoneda.nextDouble();
                    entradamoneda.nextLine();

                    double tasa = ServicioTasaCambio.obtenerTasa(variable.getOrigen(), variable.getDestino());
                    double resultado = monto * tasa;

                    System.out.printf("Tasa %s -> %s: %.4f%n", variable.getOrigen(), variable.getDestino(), tasa);
                    System.out.printf("El resultado es: %.2f %s%n", resultado, variable.getDestino());
                    System.out.println("---------------------------------------------------");

                } else {
                    System.out.println("Opción fuera de rango. Intenta de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Error: Ingresa un número, no letras.");
                entradamoneda.nextLine();
            }
        }
        entradamoneda.close();
    }
}