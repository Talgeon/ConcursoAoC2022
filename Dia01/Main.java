import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cuenta = 0;
        int maximo = 0;
        while (sc.hasNextLine()) {
            try {
                cuenta += Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                if (cuenta > maximo) maximo = cuenta;
                cuenta = 0;
            }
        }
        sc.close();
        System.out.println(maximo);

    }
}