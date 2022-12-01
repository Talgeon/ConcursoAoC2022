import java.util.Arrays;
import java.util.Scanner;
import static java.lang.Integer.*;

public class MainDos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        int[] mayores = new int[3];
        while (sc.hasNextLine()) {
            try {
                cuenta += parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                if (cuenta > mayores[0]) {
                    mayores[2] = mayores[1];
                    mayores[1] = mayores[0];
                    mayores[0] = cuenta;
                } else if (cuenta > mayores[1]) {
                    mayores[2] = mayores[1];
                    mayores[1] = cuenta;
                } else if (cuenta > mayores[2]) {
                    mayores[2] = cuenta;
                }
                cuenta = 0;
            }
        }
        System.out.println(Arrays.stream(mayores).sum());
        sc.close();
    }
}