import com.dmoram.conexion.ConsultaAPI;
import com.dmoram.conexion.GUI;

public class Principal {
    public static void main(String[] args) {
        ConsultaAPI.hacerConversion("CLP", "PEN",1500);
        System.out.println("hola");
        GUI gui = new GUI();
    }
}
