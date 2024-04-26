// Desarrollado por Diego Mora

import com.dmoram.componentes.ConsultaAPI;
import com.dmoram.modelos.Conversion;
import com.dmoram.modelos.ConversionAPI;
import com.dmoram.modelos.RegistroConversiones;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        RegistroConversiones registro = new RegistroConversiones();

        while(true){
            System.out.println("""
                    -----------------------------------------------------
                                CONVERSOR DE MONEDAS
                     Seleccione el tipo de conversión a realizar:
                        1) Peso chileno(CLP) a dólar estadounidense(USD).
                        2) Dólar estadounidense(USD) a peso chileno(CLP).
                        3) Peso chileno(CLP) a real brasileño(BRL).
                        4) Real brasileño(BRL) a peso chileno(CLP).
                        5) Dólar estadounidense(USD) a real brasileño(BRL).
                        6) Real brasileño(BRL) a dólar estadounidense(USD).
                        7) Ver registro de conversiones
                        0) Salir
                    ------------------------------------------------------         
                    """);
            try {
                System.out.print("Ingrese acción(0-7): ");
                int respuesta = teclado.nextInt();
                teclado.nextLine(); // Limpiar el buffer de entrada

                switch (respuesta) {
                    case 0:
                        System.out.println("¡Hasta luego!");
                        return;
                    case 1:
                        realizarConversion(teclado, registro, "CLP", "USD");
                        break;
                    case 2:
                        realizarConversion(teclado, registro, "USD", "CLP");
                        break;
                    case 3:
                        realizarConversion(teclado, registro, "CLP", "BRL");
                        break;
                    case 4:
                        realizarConversion(teclado, registro, "BRL", "CLP");
                        break;
                    case 5:
                        realizarConversion(teclado, registro, "USD", "BRL");
                        break;
                    case 6:
                        realizarConversion(teclado, registro, "BRL", "USD");
                        break;
                    case 7:
                        System.out.println(registro);
                        break;
                    default:
                        System.out.println("¡Opción inválida! Por favor, ingrese un número entre 0 y 7.");
                }
            } catch (InputMismatchException e) {
                System.out.println("¡Error! Ingrese un número entero válido.");
                teclado.nextLine(); // Limpiar el buffer de entrada
            } catch (Exception e) {
                System.out.println("¡Ha ocurrido un error inesperado!");
            }
        }
    }

    private static void realizarConversion(Scanner teclado, RegistroConversiones registro, String monedaOrigen, String monedaDestino) {
        double monto;
        String continuar;
        do {
            System.out.print("Ingrese monto a convertir: ");
            monto = teclado.nextDouble();
            ConversionAPI convAPI = ConsultaAPI.hacerConversion(monedaOrigen, monedaDestino, monto);
            Conversion conv = new Conversion(convAPI, monto);
            registro.agregarRegistro(conv);

            System.out.print("¿Desea realizar otra conversión? (si o no): ");
            continuar = teclado.next().toLowerCase();
        } while (continuar.equals("si"));
    }
}


