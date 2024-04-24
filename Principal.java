import com.dmoram.componentes.ConsultaAPI;
import com.dmoram.componentes.GUI;

public class Principal {
    public static void main(String[] args) {
        ConsultaAPI.hacerConversion("CLP", "PEN",1500);
        System.out.println("hola");
        //GUI gui = new GUI();
        while(true){
            System.out.println("""
                    #### Conversor de monedas ####
                    
                    Seleccione el tipo de conversión a realizar:
                    
                    1) Peso chileno(CLP) a dólar(USD).                   
                    """);
        }
    }
}
