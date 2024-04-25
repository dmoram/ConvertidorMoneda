import com.dmoram.componentes.ConsultaAPI;
import com.dmoram.componentes.GUI;
import com.dmoram.modelos.Conversion;
import com.dmoram.modelos.ConversionAPI;
import com.dmoram.modelos.RegistroConversiones;

import javax.sound.midi.SysexMessage;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        boolean repetir = true;
        Scanner teclado = new Scanner(System.in);
        int respuesta;
        double monto;
        String continuar;
        RegistroConversiones registro = new RegistroConversiones();
        while(repetir){
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
                        7) Salir
                    ------------------------------------------------------         
                    """);
            try {
                System.out.print("Ingrese acción(1-7): ");
                respuesta = teclado.nextInt();
                teclado.nextLine();
                switch (respuesta) {
                    case 1:
                        //clp -> usd
                        System.out.print("Ingrese monto a convertir: ");
                        monto = teclado.nextInt();
                        ConversionAPI convAPI = ConsultaAPI.hacerConversion("CLP", "USD",monto);
                        Conversion conv = new Conversion(convAPI, monto);
                        registro.añadirRegistro(conv);
                        System.out.println(registro);
                        break;
                        /*System.out.print("Desea realizar otra conversión? (si o no)");
                        continuar = teclado.nextLine();
                        if (continuar.equals("si")){
                            teclado.nextLine();
                        }else if(continuar.equals("no")){
                            repetir = false;
                        }
                        */
                    case 2:
                        System.out.print("Ingrese monto a convertir: ");
                        monto = teclado.nextInt();
                        //usd -> clp
                        ConsultaAPI.hacerConversion("USD", "CLP",1500);
                    case 3:
                        System.out.print("Ingrese monto a convertir: ");
                        monto = teclado.nextInt();
                        //clp -> brl
                        ConsultaAPI.hacerConversion("CLP", "BRL",1500);
                    case 4:
                        System.out.print("Ingrese monto a convertir: ");
                        monto = teclado.nextInt();
                        //brl -> clp
                        ConsultaAPI.hacerConversion("BRL", "CLP",1500);
                    case 5:
                        System.out.print("Ingrese monto a convertir: ");
                        monto = teclado.nextInt();
                        //usd -> brl
                        ConsultaAPI.hacerConversion("USD", "BRL",1500);
                    case 6:
                        System.out.print("Ingrese monto a convertir: ");
                        monto = teclado.nextInt();
                        //brl -> usd
                        ConsultaAPI.hacerConversion("BRL", "USD",1500);
                    case 7:

                        //salir
                        repetir = false;
                        break;
                }
            }catch (InputMismatchException e){
                teclado.nextLine();
                System.out.println("Respuesta inválida, intente nuevamente");

            }catch (Exception e){
                System.out.println("Ha ocurrido un error");
            }
        }
    }
}
